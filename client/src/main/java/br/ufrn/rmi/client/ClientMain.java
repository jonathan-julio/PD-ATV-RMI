package br.ufrn.rmi.client;

import java.rmi.Naming;

import br.ufrn.rmi.hospital.AmbulanceService;
import br.ufrn.rmi.hospital.Hospital;
import br.ufrn.rmi.hospital.Location;

public class ClientMain {
    public static void main(String[] args) {
        try {
            // Obter uma referência ao serviço de ambulância do servidor RMI
            AmbulanceService ambulanceService = (AmbulanceService) Naming.lookup("rmi://localhost:1099/HospitalLocator");

            // Definir a localização do paciente
            Location patientLocation = new Location(-5.1, -39.8);

            // Encontrar o hospital mais próximo da localização do paciente
            Hospital nearestHospital = ambulanceService.findNearestHospital(patientLocation);

            // Exibir o resultado
            System.out.println("O hospital mais próximo é: "  + nearestHospital.getName() ) ;
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}