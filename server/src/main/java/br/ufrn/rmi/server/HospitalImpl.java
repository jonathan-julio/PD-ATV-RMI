package br.ufrn.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.ufrn.rmi.hospital.Hospital;
import br.ufrn.rmi.hospital.Location;

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

    public Boolean isAvaliable() throws RemoteException {
        return true;
    }

}
