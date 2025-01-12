package chat;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Cliente {
    public Cliente() {
    }

    public ArrayList<String> getMensagem(String nome, String mensagem){
        try{
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Chat chat = (Chat) registry.lookup("Chat");

            ArrayList<String> mensagemEnviada = chat.historico(nome, mensagem);

            if (mensagemEnviada == null || mensagemEnviada.isEmpty()) {
                return new ArrayList<>();
            } else {
                return mensagemEnviada;
            }

        } catch (Exception e){
            System.out.println("Erro no cliente: " + e.getMessage());
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {

    }
}
