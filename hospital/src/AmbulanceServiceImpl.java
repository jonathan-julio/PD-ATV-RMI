import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class AmbulanceServiceImpl extends UnicastRemoteObject implements AmbulanceService {
    private List<Hospital> hospitals;

    public AmbulanceServiceImpl(List<Hospital> hospitals) throws RemoteException {
        this.hospitals = hospitals;
    }

    public Hospital findNearestHospital(Location location) throws RemoteException {
        Hospital nearestHospital = null;
        double nearestDistance = Double.MAX_VALUE;

        for (Hospital hospital : hospitals) {
            Location hospitalLocation = hospital.getLocation();
            double distance = calculateDistance(location, hospitalLocation);

            if (distance < nearestDistance) {
                nearestDistance = distance;
                nearestHospital = hospital;
            }
        }

        return nearestHospital;
    }

    private double calculateDistance(Location location1, Location location2) {
        double lat1 = location1.getLatitude();
        double lon1 = location1.getLongitude();
        double lat2 = location2.getLatitude();
        double lon2 = location2.getLongitude();

        double R = 6371; // raio da terra em km
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double lat1Radians = Math.toRadians(lat1);
        double lat2Radians = Math.toRadians(lat2);

        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.sin(dLon/2) * Math.sin(dLon/2) * Math.cos(lat1Radians) * Math.cos(lat2Radians);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double distance = R * c;

        return distance;
    }
}
