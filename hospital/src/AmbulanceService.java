import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AmbulanceService extends Remote {
    
    Hospital getNearestHospital(double latitude, double longitude) throws RemoteException;
    
}
