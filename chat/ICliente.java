package chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ICliente extends Remote {
    // Atualizar mensagens em tempo real
    void atualizarMensagens(String mensagem) throws RemoteException;

    void atualizarConexoes (List<String> nome) throws RemoteException;
}
