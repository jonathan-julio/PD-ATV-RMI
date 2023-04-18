import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class AmbulanceServiceImpl extends UnicastRemoteObject implements AmbulanceService {

    private List<Hospital> hospitals;

    public AmbulanceServiceImpl() throws RemoteException {
        super();
        // Configura a lista de hospitais disponíveis
        hospitals = new ArrayList<>();
        hospitals.add(new Hospital("Hospital A", -23.5505, -46.6333));
        hospitals.add(new Hospital("Hospital B", -23.5506, -46.6334));
        hospitals.add(new Hospital("Hospital C", -23.5507, -46.6335));
    }

    @Override
    public Hospital getNearestHospital(double latitude, double longitude) throws RemoteException {
        double minDistance = Double.MAX_VALUE;
        Hospital nearestHospital = null;

        // Itera sobre a lista de hospitais disponíveis para encontrar o mais próximo
        for (Hospital hospital : hospitals) {
            double distance = calculateDistance(latitude, longitude, hospital.getLatitude(), hospital.getLongitude());
            if (distance < minDistance) {
                minDistance = distance;
                nearestHospital = hospital;
            }
        }

        return nearestHospital;
    }

    // Calcula a distância entre dois pontos em uma esfera (utilizando a fórmula de Haversine)
    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        int earthRadiusKm = 6371;

        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);

        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
                   Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        return earthRadiusKm * c;
    }
}
