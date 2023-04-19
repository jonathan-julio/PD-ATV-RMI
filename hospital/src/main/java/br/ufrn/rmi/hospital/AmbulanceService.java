package br.ufrn.rmi.hospital;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AmbulanceService extends Remote {
    Hospital findNearestHospital(Location location) throws RemoteException;
}
