package chat;

import view.Entrar;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Servidor implements Chat {
    public Servidor() {
    }

    public static final ArrayList<String> historicoMensagem = new ArrayList<>();

    public ArrayList<String> historico(String nome, String mensagem) throws RemoteException {
        String formatoMensagem = nome + ": " + mensagem;
        historicoMensagem.add(formatoMensagem);
        return new ArrayList<>(historicoMensagem);
    }

    public void iniciarServidor() {
        try {
            Chat stub = (Chat) UnicastRemoteObject.exportObject(this, 0);
            Registry registry ;
            try {
                registry = LocateRegistry.getRegistry(1099);
                registry.list();

            } catch (RemoteException e) {
                registry = LocateRegistry.createRegistry(1099);
            }
            registry.bind("Chat", stub);
            System.err.println("Servidor está pronto...");

        } catch (Exception e) {
            System.err.println("Erro no Servidor: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Servidor servidor = new Servidor();
        servidor.iniciarServidor();

        Entrar chat = new Entrar();
        chat.setVisible(true);
    }
}
