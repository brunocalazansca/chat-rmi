package chat;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface Chat extends Remote {
    ArrayList<String> historico(String nome, String mensagem) throws RemoteException;
    ArrayList<String> nomeEntrou(String nome) throws RemoteException;
    ArrayList<String> nomeSaiu(String nome) throws RemoteException;
    ArrayList<String> mensagemAtual(String nome, String mensagem) throws RemoteException;
}
