import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AmbulanceServiceInterface extends Remote {
    Hospital findNearestHospital(Location location) throws RemoteException;
}
