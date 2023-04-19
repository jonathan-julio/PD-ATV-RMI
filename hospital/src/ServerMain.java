import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain {
    public static void main(String[] args) {
        try {

            HospitalLocator hospitalLocator = new HospitalLocator();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("HospitalLocator", hospitalLocator);

            System.out.println("HospitalLocator is running...");
        } catch (RemoteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

