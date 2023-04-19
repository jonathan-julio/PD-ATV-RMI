import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerMain {
    public static void main(String[] args) {
        try {
            Hospital[] hospitals = {
                    new HospitalImpl("Hospital A", "", new Location(10, 20)),
                    new HospitalImpl("Hospital B","", new Location(30, 40)),
                    new HospitalImpl("Hospital C","", new Location(50, 60))
            };

            HospitalLocator hospitalLocator = new HospitalLocator();

            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("HospitalLocator", hospitalLocator);

            System.out.println("HospitalLocator is running...");
        } catch (RemoteException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

/* HospitalLocatorImpl hospitalLocator = new HospitalLocatorImpl();
    List<Hospital> hospitals = new ArrayList<Hospital>();
    hospitals.add(new Hospital("Hospital 1", new Location(1, 1)));
    hospitals.add(new Hospital("Hospital 2", new Location(2, 2)));
    hospitals.add(new Hospital("Hospital 3", new Location(3, 3)));
    hospitalLocator.setHospitals(hospitals);

    AmbulanceServiceImpl ambulanceService = new AmbulanceServiceImpl(hospitalLocator);

    Registry registry = LocateRegistry.createRegistry(1099);
    registry.rebind("AmbulanceService", ambulanceService);

    System.out.println("Server is running..."); */
