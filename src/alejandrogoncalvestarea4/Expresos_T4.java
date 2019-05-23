
package alejandrogoncalvestarea4;

import java.util.Scanner;

/**
 *
 * @author Alejandro Goncalves
 */
public class Expresos_T4 {
    private int numberOfClients;
    private Destination valencia = new Destination( "Valencia", "V", 12500);
    private Destination puerto_La_Cruz = new Destination( "Puerto La Cruz", "P", 16000);
    private Destination barquisimeto = new Destination( "Barquisimeto", "B", 18500);
    
    public Expresos_T4(){
        this.numberOfClients = 0;
    }

    public void Menu(){
        Scanner sc = new Scanner(System.in);
        int idNumber;
        int passengers;
        String destination;
        System.out.println("Welcome to Expresos T4, your traveling best option!");
        
        while(this.totalAvailableVacancies() > 0){
            
            this.numberOfClients++;
            
            System.out.println("Hello client number " + this.numberOfClients );
            System.out.println("Enter your ID number please: ");
            idNumber = sc.nextInt();
            System.out.println("Enter the numbers of passengers: ");
            passengers = sc.nextInt();
            System.out.println("Enter your destination: ");
            System.out.println("Enter " + valencia.getCode() + " for " + valencia.getName());
            System.out.println("Enter " + puerto_La_Cruz.getCode() + " for " + puerto_La_Cruz.getName());
            System.out.println("Enter " + barquisimeto.getCode() + " for " + barquisimeto.getName());
            destination = sc.next();
            
            Client client = new Client(idNumber, passengers, destination);
            
            this.destinationAvailability(client);
        }
        
    }
    
    
    public void destinationAvailability(Client client){
        switch(client.getDestination()){
            case "V": if(this.valencia.availableVacancies() == client.getNumberOfPassengers())  this.billing(client, this.getValencia());
                      break;
                      
            case "P": break;
                        
            case "B": break;
                
            default: 
                    break;
        }
        
    }
    
    
    public void billing(Client client, Destination destination){
        
        destination.setClientsPerDestiny(destination.getClientsPerDestiny()+ 1);
        
    }
    
    public int totalAvailableVacancies(){
        return this.valencia.availableVacancies() + this.puerto_La_Cruz.availableVacancies() + this.barquisimeto.availableVacancies();
    }
    
    public Destination getValencia() {
        return valencia;
    }

    public void setValencia(Destination valencia) {
        this.valencia = valencia;
    }

    public Destination getPuerto_La_Cruz() {
        return puerto_La_Cruz;
    }

    public void setPuerto_La_Cruz(Destination puerto_La_Cruz) {
        this.puerto_La_Cruz = puerto_La_Cruz;
    }

    public Destination getBarquisimeto() {
        return barquisimeto;
    }

    public void setBarquisimeto(Destination barquisimeto) {
        this.barquisimeto = barquisimeto;
    }

    public int getNumberOfClients() {
        return numberOfClients;
    }

    public void setNumberOfClients(int numberOfClients) {
        this.numberOfClients = numberOfClients;
    }
    
    
}
