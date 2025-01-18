package chat;

import chat.ICliente;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Chat extends Remote {
    // Enviar mensagem ao servidor
    void enviarMensagem(String usuario, String mensagem) throws RemoteException;

    // Registrar cliente no servidor
    void registrarCliente(ICliente icliente) throws RemoteException;

    void entrarChat(ICliente icliente, String nome) throws RemoteException;

    void sairChat(ICliente icliente, String nome) throws RemoteException;

    // Obter mensagens já enviadas
    List<String> obterMensagens() throws RemoteException;
}
