package chat;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    public Cliente() {
    }

    public void iniciarCliente(){
        // String host = (args.length < 1) ? "localhost" : args[0];

        try{
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);

        } catch (Exception e){
            System.out.println("Erro no cliente: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente();
        cliente.iniciarCliente();
    }
}
