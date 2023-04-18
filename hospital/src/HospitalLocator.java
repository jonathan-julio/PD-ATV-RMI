import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface HospitalLocator extends Remote {
    List<Hospital> getAvailableHospitals() throws RemoteException;
    Hospital findNearestHospital(Location location) throws RemoteException;
}
