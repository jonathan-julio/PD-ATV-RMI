package br.ufrn.rmi.hospital;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Hospital extends Remote {
    String getName() throws RemoteException;
    int getVacancies() throws RemoteException;
    Location getLocation() throws RemoteException;
    Boolean isAvaliable() throws RemoteException;
    void occupyVacancy() throws RemoteException;
}
