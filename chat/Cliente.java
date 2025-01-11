package chat;

import view.Mensagem;

import javax.swing.*;
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

            return mensagemEnviada;

        } catch (Exception e){
            System.out.println("Erro no cliente: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        String host = (args.length < 1) ? "localhost" : args[0];

        try{
            Registry registry = LocateRegistry.getRegistry(host, 1099);
            Chat chat = (Chat) registry.lookup("Chat");

        } catch (Exception e){
            System.out.println("Erro no cliente: " + e.getMessage());
        }
    }
}
