package br.ufrn.rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import br.ufrn.rmi.hospital.Hospital;
import br.ufrn.rmi.hospital.Location;

public class HospitalImpl extends UnicastRemoteObject implements Hospital {

    private String name;
    private int vacancies;
    private Location location;

    public HospitalImpl(String name, int vacancies, Location location) throws RemoteException {
        this.name = name;
        this.vacancies = vacancies;
        this.location = location;
    }

    public String getName() throws RemoteException {
        return name;
    }

    public int getVacancies() throws RemoteException {
        return vacancies;
    }

    public Location getLocation() throws RemoteException {
        return location;
    }

    public Boolean isAvaliable() throws RemoteException {
        return !(this.vacancies == 0);
    }

    public void occupyVacancy() throws RemoteException {
        this.vacancies--;
    }

}
