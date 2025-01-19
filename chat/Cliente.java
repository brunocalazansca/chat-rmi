package chat;

import view.Entrar;
import view.Mensagem;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class Cliente extends UnicastRemoteObject implements ICliente{

    private static final List<String> mensagens = new ArrayList<>();
    private static Registry registry;
    private static Chat chat;
    private static ICliente cliente;
    private static String nome;
    private static Mensagem viewMensagem;

    public static void setViewMensagem(Mensagem mensagem) {
        viewMensagem = mensagem;
    }

    public static Registry getRegistry() {
        return registry;
    }

    public static void setRegistry(Registry registry) {
        Cliente.registry = registry;
    }

    public static List<String> getMensagens() {
        return mensagens;
    }

    public static Chat getChat() {
        return chat;
    }

    public static void setChat(Chat chat) {
        Cliente.chat = chat;
    }

    public static ICliente getCliente() {
        return cliente;
    }

    public static void setCliente(ICliente cliente) {
        Cliente.cliente = cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cliente(String nome) throws RemoteException {
        super();
        setNome(nome);
    }

    @Override
    public void atualizarMensagens(String mensagem) {
        if (viewMensagem != null) {
            viewMensagem.adicionarMensagem(mensagem);
        } else {
            System.err.println("Erro: View de mensagem não inicializada.");
        }
    }

    @Override
    public void atualizarConexoes (List<String> nome) {
        if (viewMensagem != null) {
            viewMensagem.usuariosConectados(nome);
        } else {
            System.err.println("Erro: View de mensagem não inicializada.");
        }
    }

    public void entrarChat(){
        try {
            chat.entrarChat(cliente, nome);
        } catch (Exception e) {
            System.err.println("Erro ao entrar no chat: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void sairChat(){
        try {
            chat.sairChat(cliente, nome);
        } catch (Exception e) {
            System.err.println("Erro ao entrar sair do chat: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void enviarMensagem(String mensagem) {
        try {
            chat.enviarMensagem(nome, mensagem);
        } catch (Exception e) {
            System.err.println("Erro ao enviar mensagem: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void historicoMensagens() {
        try {
            mensagens.clear();
            mensagens.addAll(chat.obterMensagens());
        } catch (Exception e) {
            System.err.println("Erro ao registrar cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void registrarCliente(String nome) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

            Chat chat = (Chat) registry.lookup("Chat");

            ICliente cliente = new Cliente(nome);

            chat.registrarCliente(cliente);

            setRegistry(registry);
            setChat(chat);
            setCliente(cliente);

            System.out.println("Cliente registrado no servidor com sucesso!");
        } catch (Exception e) {
            System.err.println("Erro ao registrar cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Entrar entrar = new Entrar();
        entrar.setVisible(true);
    }
}
