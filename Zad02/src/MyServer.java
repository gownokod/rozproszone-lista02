import java.rmi.RMISecurityManager;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyServer {

    public static void main(String[] args) {

        System.setProperty(
                "java.security.policy",
                //Adres do waszego pliku srv.policy
                "/FILEPATH-CHANGE-IT/Zad02part02/srv.policy"
        );

        System.setSecurityManager(new RMISecurityManager());

        try {
            CalcObjectImpl implObiektu = new CalcObjectImpl();
            CalcObjImpl2 implObiektu2 = new CalcObjImpl2();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("metoda", implObiektu);
            registry.rebind("metoda2", implObiektu2);

            System.out.println("Server is registered now :-)");
            System.out.println("Press Ctrl+C to stop...");
        } catch (Exception e) {
            System.out.println("SERVER CANT'T BE REGISTERED!");
            e.printStackTrace();
            return;
        }
    }
}
