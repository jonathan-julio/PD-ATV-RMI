import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class AmbulanceServiceClient {

    public static void main(String[] args) {
        try {
            // Obtém o registry do RMI
            Registry registry = LocateRegistry.getRegistry(null);

            // Obtém o objeto remoto do serviço de solicitação de ambulância
            AmbulanceService ambulanceService = (AmbulanceService) registry.lookup("AmbulanceService");

            // Cria um scanner para ler a localização do paciente
            Scanner scanner = new Scanner(System.in);
            System.out.print("Digite a localização do paciente: ");
            String location = scanner.nextLine();

            // Chama o método remoto para obter o hospital mais próximo
            Hospital nearestHospital = ambulanceService.findNearestHospital(location);

            // Exibe o hospital mais próximo encontrado
            System.out.println("Hospital mais próximo: " + nearestHospital.getName() + " - Localização: " + nearestHospital.getLocation());

        } catch (Exception e) {
            System.err.println("Erro no cliente RMI: " + e.toString());
            e.printStackTrace();
        }
    }

}
