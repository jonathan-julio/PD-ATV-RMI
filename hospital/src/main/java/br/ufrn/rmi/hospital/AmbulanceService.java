package br.ufrn.rmi.hospital;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AmbulanceService extends Remote {
    Hospital findNearestHospital(double latitude, double longitude) throws RemoteException;

}
