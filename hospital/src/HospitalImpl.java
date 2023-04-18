import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class HospitalImpl extends UnicastRemoteObject implements Hospital {

    private String name;
    private String address;
    private double latitude;
    private double longitude;

    public HospitalImpl(String name, String address, double latitude, double longitude) throws RemoteException {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() throws RemoteException {
        return name;
    }

    public String getAddress() throws RemoteException {
        return address;
    }

    public double getLatitude() throws RemoteException {
        return latitude;
    }

    public double getLongitude() throws RemoteException {
        return longitude;
    }
}
