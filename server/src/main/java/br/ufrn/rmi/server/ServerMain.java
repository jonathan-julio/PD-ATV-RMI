package br.ufrn.rmi.server;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class ServerMain {
    ServerMain() throws MalformedURLException, AlreadyBoundException{
        try {
            System.setProperty("java.rmi.server.hostname", "localhost");
            LocateRegistry.createRegistry(1099);

            HospitalLocator hospitalLocator = new HospitalLocator();

            Naming.bind("HospitalLocator", (Remote) hospitalLocator);

            System.out.println("HospitalLocator is running..." + hospitalLocator);
        } catch (RemoteException e) {
            System.out.println("Error: " + e.getMessage());
        }

    }

    public static void main(String[] args) throws MalformedURLException, AlreadyBoundException {
        new ServerMain();
    }
}

