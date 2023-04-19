package br.ufrn.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import br.ufrn.rmi.hospital.AmbulanceService;
import br.ufrn.rmi.hospital.Hospital;
import br.ufrn.rmi.hospital.Location;

public class HospitalLocator extends UnicastRemoteObject implements AmbulanceService {
    private static final long serialVersionUID = 1L;
    private List<Hospital> hospitals;
    private int chamado;

    protected HospitalLocator() throws RemoteException {
        super();

        hospitals = new ArrayList<>();
        hospitals.add(new HospitalImpl("Hospital Maranhão","", new Location(-5.6, -45.3)));
        hospitals.add(new HospitalImpl("Hospital Bahia","", new Location(-12.8, -41.5)));
        hospitals.add(new HospitalImpl("Hospital Pernambuco","", new Location(-8.7, -38.2)));
        hospitals.add(new HospitalImpl("Hospital Rio Grande", "", new Location(-6.0, -36.7)));

        chamado = 0;
    }

    public Hospital findNearestHospital(Location location) throws RemoteException {
        Hospital nearestHospital = null;
        double nearestDistance = Double.MAX_VALUE;

        System.out.println("Chamado número " + chamado++ + " --> Local(" + location.getLatitude() + ", " + location.getLongitude() + ")");

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
