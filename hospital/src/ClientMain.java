import java.rmi.Naming;
import java.rmi.RemoteException;

public class ClientMain {
    public static void main(String[] args) {
        try {
            // Obter uma referência ao serviço de ambulância do servidor RMI
            String ambulanceServiceUrl = "//localhost:1099/HospitalLocator";
            AmbulanceService ambulanceService = (AmbulanceService) Naming.lookup(ambulanceServiceUrl);

            // Definir a localização do paciente
            Location patientLocation = new Location(52.5167, 13.3833);

            // Encontrar o hospital mais próximo da localização do paciente
            Hospital nearestHospital = ambulanceService.findNearestHospital(patientLocation.getLatitude(), patientLocation.getLongitude() );

            // Exibir o resultado
            System.out.println("O hospital mais próximo é: " + nearestHospital.getName());
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}