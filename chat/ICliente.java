package chat;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ICliente extends Remote {
    // Atualizar mensagens em tempo real
    void atualizarMensagens(String mensagem) throws RemoteException;
}
