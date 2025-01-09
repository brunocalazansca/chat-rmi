import java.lang.reflect.Array;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Chat extends Remote {
    ArrayList<String> historico(String nome, String mensagem) throws RemoteException;
    String[] mensagem (ArrayList<String> historico) throws RemoteException;
}
