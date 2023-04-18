import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hospital extends Remote {
    public String getName() throws RemoteException;
    public Location getLocation() throws RemoteException;
}
