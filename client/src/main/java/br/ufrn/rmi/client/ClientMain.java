package br.ufrn.rmi.client;

import java.rmi.Naming;
import java.util.Scanner;

import br.ufrn.rmi.hospital.AmbulanceService;
import br.ufrn.rmi.hospital.Hospital;
import br.ufrn.rmi.hospital.Location;

public class ClientMain {
    public static void main(String[] args) {
        try {
            // Obter uma referência ao serviço de ambulância do servidor RMI
            AmbulanceService ambulanceService = (AmbulanceService) Naming.lookup("rmi://localhost:1099/HospitalLocator");

            // Definir a localização do paciente
            Location patientLocation = new Location(-5.1, -39.8); // Paciente Ceará

            // Scanner sc = new Scanner(System.in);
            // System.out.print("Enter latitude - ");
            // double a = sc.nextDouble();  
            // System.out.print("Enter logitude - ");  
            // double b = sc.nextDouble();  
            // Location patientLocation = new Location(a, b); // Paciente Ceará

            // Encontrar o hospital mais próximo da localização do paciente
            Hospital nearestHospital = ambulanceService.findNearestHospital(patientLocation);

            // Exibir o resultado
            System.out.println("O hospital mais próximo é: "  + nearestHospital.getName() ) ;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}