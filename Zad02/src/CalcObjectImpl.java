import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcObjectImpl extends UnicastRemoteObject implements  CalcObject {

    private static final long serialVesionUID = 101L;

    protected CalcObjectImpl() throws RemoteException {
        super();
    }

    @Override
    public double calculate(double a, double b) throws RemoteException {
        return a+b;
    }
}
