import java.rmi.Naming;
import java.rmi.RemoteException;

public class ClientMain {
    public static void main(String[] args) {
        try {
            // Obter uma referência ao serviço de ambulância do servidor RMI
            Object ambulanceService = Naming.lookup("rmi://192.168.1.5:1099/HospitalLocator");

            // Definir a localização do paciente
            //Location patientLocation = new Location(52.5167, 13.3833);

            // Encontrar o hospital mais próximo da localização do paciente
            //Hospital nearestHospital = ambulanceService.findNearestHospital(patientLocation.getLatitude(), patientLocation.getLongitude() );

            // Exibir o resultado
            System.out.println("O hospital mais próximo é: " + ambulanceService);
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}