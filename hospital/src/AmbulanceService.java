import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AmbulanceService extends Remote {
    public Hospital findNearestHospital(Location location) throws RemoteException;
}
