import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyClient {

    public static void main(String[] args) {
        double wynik;

        CalcObject zObiekt;

        System.setProperty(
                "java.security.policy",
                //Adres do waszego pliku srv.policy
                "/FILEPATH-CHANGE-IT/Zad02part02/srv.policy"
        );

        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            zObiekt = (CalcObject) registry.lookup("metoda");

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        try {
            wynik = zObiekt.calculate(1.1, 2.2);
        } catch (Exception e) {
            System.out.println("Blad zdalnego wywolania."); e.printStackTrace();
            return;
        }
        System.out.println("Wynik = "+wynik);
        return;
    }
}