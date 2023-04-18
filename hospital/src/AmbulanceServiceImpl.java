import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AmbulanceServiceImpl extends UnicastRemoteObject implements AmbulanceService {

    private List<Hospital> hospitals;

    public AmbulanceServiceImpl(List<Hospital> hospitals) throws RemoteException {
        super();
        this.hospitals = hospitals;
    }

    public Hospital findNearestHospital(double latitude, double longitude) throws RemoteException {
        List<Double> distances = new ArrayList<>();
        for (Hospital hospital : hospitals) {
            double distance = Math.sqrt(Math.pow((hospital.getLatitude() - latitude), 2)
                    + Math.pow((hospital.getLongitude() - longitude), 2));
            distances.add(distance);
        }
        int index = distances.indexOf(Collections.min(distances));
        return hospitals.get(index);
    }
}
