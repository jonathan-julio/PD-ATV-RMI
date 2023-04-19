package br.ufrn.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.rmi.hospital.AmbulanceServiceInterface;
import br.ufrn.rmi.hospital.Hospital;
import br.ufrn.rmi.hospital.Location;

public class HospitalLocator extends UnicastRemoteObject implements AmbulanceServiceInterface {
    private static final long serialVersionUID = 1L;
    private List<Hospital> hospitals;

    protected HospitalLocator() throws RemoteException {
        super();
        hospitals = new ArrayList<>();
        hospitals.add(new HospitalImpl("Hospital A", "", new Location(10, 10)));
        hospitals.add(new HospitalImpl("Hospital B","", new Location(20, 20)));
        hospitals.add(new HospitalImpl("Hospital C","", new Location(30, 30)));
    }

    public Hospital findNearestHospital(Location location) throws RemoteException {
        Hospital nearestHospital = null;
        double nearestDistance = Double.MAX_VALUE;
        for (Hospital hospital : hospitals) {
            double distance = location.distance(hospital.getLocation());
            if (distance < nearestDistance) {
                nearestHospital = hospital;
                nearestDistance = distance;
            }
        }
        return nearestHospital;
    }
}