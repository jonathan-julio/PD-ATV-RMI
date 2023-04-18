import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.ExportException;

public class HospitalLocator {

    public static void main(String[] args) {
        try {
            // Cria o registro RMI na porta 1099
            LocateRegistry.createRegistry(1099);

            // Cria a instância do serviço de solicitação de ambulância
            AmbulanceService ambulanceService = new AmbulanceServiceImpl();

            // Publica o serviço de solicitação de ambulância com o nome "AmbulanceService"
            Naming.rebind("AmbulanceService", ambulanceService);

            System.out.println("HospitalLocator is running...");
        } catch (ExportException e) {
            System.out.println("The RMI Registry is already running.");
        } catch (RemoteException e) {
            System.out.println("Error starting the RMI registry: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error binding the AmbulanceService: " + e.getMessage());
        }
    }

}
