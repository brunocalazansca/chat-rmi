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

    private final List<String> historicoMensagem = Collections.synchronizedList(new ArrayList<>());
    private final ArrayList<String> nomeEntrou = new ArrayList<>();
    private final ArrayList<String> nomeSaiu = new ArrayList<>();
    private final ArrayList<String> mensagemAtual = new ArrayList<>();

    public ArrayList<String> historico(String nome, String mensagem) throws RemoteException {
        if (mensagem.equalsIgnoreCase("")){
            return new ArrayList<>();

        } else {
            String formatoMensagem = nome + ": " + mensagem;
            historicoMensagem.add(formatoMensagem);
            return new ArrayList<>(historicoMensagem);
        }
    }

    public ArrayList<String> nomeEntrou(String nome) throws RemoteException {
        nomeEntrou.add(nome);
        return new ArrayList<>(nomeEntrou);
    }

    public ArrayList<String> nomeSaiu(String nome) throws RemoteException {
        nomeSaiu.add(nome);
        return new ArrayList<>(nomeSaiu);
    }

    public ArrayList<String> mensagemAtual (String nome, String mensagem) throws RemoteException {
        mensagemAtual.add(historico(nome, mensagem).getLast());
        return mensagemAtual;
    }

    public void iniciarServidor() {
        try {
            Servidor servidor = new Servidor();
            Chat stub = (Chat) UnicastRemoteObject.exportObject(servidor, 0);
            Registry registry ;
            try {
                registry = LocateRegistry.getRegistry();
                registry.list();

            } catch (RemoteException e) {
                registry = LocateRegistry.createRegistry(1099);
            }
            registry.bind("Chat", stub);
            System.out.println("Servidor está pronto...");

        } catch (Exception e) {
            System.err.println("Erro no Servidor: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        servidor.iniciarServidor();
    }
}
