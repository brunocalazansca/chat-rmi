import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Chat {
    ArrayList<String> mensagem(String nome, String mensagem) throws RemoteException;
    ArrayList<String> historicoMensagem() throws RemoteException;
}
