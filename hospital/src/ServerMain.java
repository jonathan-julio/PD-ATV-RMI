import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain {
    public static void main(String[] args) {
        try {
            Hospital[] hospitals = {
                    new Hospital("Hospital A", new Location(10, 20)),
                    new Hospital("Hospital B", new Location(30, 40)),
                    new Hospital("Hospital C", new Location(50, 60))
            };

            HospitalLocator hospitalLocator = new HospitalLocatorImpl(hospitals);
            HospitalLocator stub = (HospitalLocator) UnicastRemoteObject.exportObject(hospitalLocator, 0);

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("HospitalLocator", stub);

            System.out.println("HospitalLocator is running...");
        } catch (RemoteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
