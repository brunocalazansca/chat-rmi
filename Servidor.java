import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class Servidor implements Chat{
    public Servidor() {}

    public ArrayList<String> mensagem(String nome, String mensagemEnviada){
        ArrayList<String> mensagemRecebida = new ArrayList<>();

        if (mensagemEnviada == null){
            System.out.println("Digite uma mensagem!");
        } else {
            mensagemRecebida.add(nome + ": " + mensagemEnviada);
        }
        return mensagemRecebida;
    }

    public ArrayList<String> historicoMensagem(){
        return null;
    }
}
