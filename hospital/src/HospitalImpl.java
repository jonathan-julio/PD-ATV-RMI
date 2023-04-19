import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HospitalImpl extends UnicastRemoteObject implements Hospital {

    private String name;
    private String address;
    private Location location;

    public HospitalImpl(String name, String address, Location location) throws RemoteException {
        this.name = name;
        this.address = address;
        this.location = location;
    }

    public String getName() throws RemoteException {
        return name;
    }

    public String getAddress() throws RemoteException {
        return address;
    }

    public Location getLocation() throws RemoteException {
        return location;
    }

}
