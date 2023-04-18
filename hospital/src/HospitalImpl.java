import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HospitalImpl extends UnicastRemoteObject implements Hospital {
    private String name;
    private Location location;

    public HospitalImpl(String name, Location location) throws RemoteException {
        this.name = name;
        this.location = location;
    }

    public String getName() throws RemoteException {
        return name;
    }

    public Location getLocation() throws RemoteException {
        return location;
    }
}
