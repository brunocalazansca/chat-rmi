package chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Chat extends Remote {
    ArrayList<String> historico(String nome, String mensagem) throws RemoteException;
}
