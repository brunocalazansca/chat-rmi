import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Scanner;

public class Servidor implements Chat{
    public Servidor() {}

    public ArrayList<String> historico(String nome, String mensagem) throws RemoteException {
        ArrayList<String> mensagemRecebida = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        Chat chat = new Servidor();

        while (!mensagem.equalsIgnoreCase("parar")) {
            System.out.print("Digite o nome: ");
            nome = scanner.nextLine();

            System.out.print("Digite o mensagem: ");
            mensagem = scanner.nextLine();

            if (!mensagem.equals("parar")) {
                mensagemRecebida.addAll(chat.historico(nome, mensagem));
                System.out.println("\n" + mensagemRecebida.get(mensagemRecebida.size() - 1));
                System.out.println(mensagemRecebida);
            }
        }
        return mensagemRecebida;
    }

    public String[] mensagem(ArrayList<String> historico) throws RemoteException {
        String[] mensagem = {historico.get(historico.size() - 1)};
        return mensagem;
    }

    public static void main(String[] args) {

        try {
            Servidor servidor = new Servidor();
            Chat stub = (Chat) UnicastRemoteObject.exportObject(servidor, 0);
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Chat", stub);

            System.err.println("Servidor está pronto...");

        } catch (Exception e) {
            System.err.println("Exceção no Servidor:" + e.getMessage());
        }
    }
}
