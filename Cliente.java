import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Cliente {
    private Cliente() {
    }

    public static void main(String[] args) {
        String host = (args.length < 1) ? null : args[0];
    }
}
