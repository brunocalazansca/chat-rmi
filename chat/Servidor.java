package chat;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Servidor implements Chat {
    public Servidor() {
    }

    private final List<String> mensagens = new ArrayList<>();
    private final List<ICliente> iclientes = new ArrayList<>();
    private final List<String> usuariosConectados = new ArrayList<>();

    // Adiciona o novo usuário no chat e atualiza para todos os usuários que permaneceram
    public synchronized void entrarChat(ICliente cliente, String nome) throws RemoteException {
        String msg = nome + " entrou no chat";
        mensagens.add(msg);
        usuariosConectados.add(nome);
        for (ICliente icliente : iclientes) {
            icliente.atualizarMensagens(msg);
            icliente.atualizarConexoes(usuariosConectados);
        }
    }

    // Remove o novo usuário no chat e atualiza para todos os usuários que permaneceram
    @Override
    public synchronized void sairChat(ICliente cliente, String nome) throws RemoteException {
        String msg = nome + " saiu do chat";
        mensagens.add(msg);
        iclientes.remove(cliente);
        usuariosConectados.remove(nome);
        for (ICliente icliente : iclientes) {
            icliente.atualizarMensagens(msg);
            icliente.atualizarConexoes(usuariosConectados);
        }
    }

    // Envia o a mensagem de um usuário para todos os outros
    @Override
    public synchronized void enviarMensagem(String usuario, String mensagem) throws RemoteException {
        String mensagemFormatada = usuario + ": " + mensagem;
        mensagens.add(mensagemFormatada);
        for (ICliente icliente : iclientes) {
            icliente.atualizarMensagens(mensagemFormatada);
        }
    }

    // Registra um novo cliente
    @Override
    public synchronized void registrarCliente(ICliente cliente) throws RemoteException {
        iclientes.add(cliente);
        System.out.println("Cliente registrado: " + cliente);
    }

    // Recebe a mensagem e retorna em uma lista
    @Override
    public synchronized List<String> obterMensagens() throws RemoteException {
        return new ArrayList<>(mensagens);
    }

    public static void main(String[] args) {
        try {
            Servidor servidor = new Servidor();
            Chat stub = (Chat) UnicastRemoteObject.exportObject(servidor, 0);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("Chat", stub);

            System.out.println("Servidor de Chat pronto...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
