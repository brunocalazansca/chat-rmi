package chat;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Servidor implements Chat {
    public Servidor() {
    }

    private final List<String> mensagens = new ArrayList<>();
    private final List<ICliente> iclientes = new ArrayList<>();
    private final List<String> usuariosConectados = new ArrayList<>();

    @Override
    public synchronized void entrarChat(ICliente cliente, String nome) throws RemoteException {
        String msg = nome + " entrou no chat";
        mensagens.add(msg);
        usuariosConectados.add(nome);
        for (ICliente icliente : iclientes) {
            icliente.atualizarMensagens(msg);
            icliente.atualizarConexoes(usuariosConectados);
        }
    }

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

    @Override
    public synchronized void enviarMensagem(String usuario, String mensagem) throws RemoteException {
        String mensagemFormatada = usuario + ": " + mensagem;
        mensagens.add(mensagemFormatada);
        for (ICliente icliente : iclientes) {
            icliente.atualizarMensagens(mensagemFormatada);
        }
    }

    @Override
    public synchronized void registrarCliente(ICliente cliente) throws RemoteException {
        iclientes.add(cliente);
        System.out.println("Cliente registrado: " + cliente);
    }

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
