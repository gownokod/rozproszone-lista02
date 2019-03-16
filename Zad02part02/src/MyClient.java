import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyClient {

    public static void main(String[] args) {

        double wynik;
        CalcObject zObiekt;

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
        
        CalcObject2 zObiekt2;
        ResultType wynik2;
        InputType inObj;

        inObj = new InputType();
        inObj.x1= 4.5;
        inObj.x2= 3.2; inObj.operation="add";

        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            zObiekt2 = (CalcObject2) registry.lookup("metoda2");

        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try {
            wynik2 = zObiekt2.calculate(inObj);
            System.out.println("Wynik2 = " + wynik2.result);

        } catch (Exception e) {
            System.out.println("Blad zdalnego wywolania."); e.printStackTrace();
            return;
        }
    }
}