import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Scanner;

public class Cliente {
    private Cliente() {
    }

    public static void main(String[] args) {
        String host = (args.length < 1) ? "localhost" : args[0];

        try{
            Registry registry = LocateRegistry.getRegistry(host);
            Chat stub = (Chat) registry.lookup("Chat");
            Scanner scanner = new Scanner(System.in);

            String nome;
            String mensagemDigitada;
            String mensagemEnviada;
            ArrayList<String> historicoMensagem;

            while(true) {
                System.out.print("Digite seu nome: ");
                nome = scanner.nextLine();

                System.out.print("Digite sua mensagem: ");
                mensagemDigitada = scanner.nextLine();

                historicoMensagem = stub.historico(nome, mensagemDigitada);
                mensagemEnviada = stub.mensagem(historicoMensagem);

                System.out.println(historicoMensagem);
                System.out.println(mensagemEnviada);
            }
        } catch (Exception e){
            System.out.println("Erro no cliente: " + e.getMessage());
        }
    }
}
