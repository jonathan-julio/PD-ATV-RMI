import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class HospitalLocator extends UnicastRemoteObject implements HospitalLocatorInterface {
    private static final long serialVersionUID = 1L;
    private List<Hospital> hospitals;

    public HospitalLocator() throws RemoteException {
        super();
        hospitals = new ArrayList<>();
        hospitals.add(new Hospital("Hospital A", new Location(10, 10)));
        hospitals.add(new Hospital("Hospital B", new Location(20, 20)));
        hospitals.add(new Hospital("Hospital C", new Location(30, 30)));
    }

    @Override
    public Hospital findNearestHospital(Location location) throws RemoteException {
        Hospital nearestHospital = null;
        double nearestDistance = Double.MAX_VALUE;
        for (Hospital hospital : hospitals) {
            double distance = hospital.getLocation().distance(location);
            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearestHospital = hospital;
            }
        }
        return nearestHospital;
    }
}
