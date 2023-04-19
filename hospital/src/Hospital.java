import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hospital extends Remote {
    String getName() throws RemoteException;
    String getAddress() throws RemoteException;
    Location getLocation() throws RemoteException;
}
