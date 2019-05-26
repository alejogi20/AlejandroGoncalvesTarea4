
package alejandrogoncalvestarea4;

import java.util.Scanner;


/**
 *
 * @author Alejandro Goncalves
 */
public class Expresos_T4 {
    private int numberOfClients, totalNetAmount;
    private Destination valencia = new Destination( "Valencia", "V", 12500);
    private Destination puerto_La_Cruz = new Destination( "Puerto La Cruz", "P", 16000);
    private Destination barquisimeto = new Destination( "Barquisimeto", "B", 18500);
    
    public Expresos_T4(){
        this.numberOfClients = 1;
    }

    public void Menu(){
        Scanner sc = new Scanner(System.in);
        int idNumber;
        int passengers;
        String destination;
        System.out.println("Welcome to Expresos T4, your traveling best option!");
        
        while(this.totalAvailableVacancies() > 0){
             
            System.out.println("Hello there!");
            System.out.println("Enter your ID number please: ");
            idNumber = sc.nextInt();
            System.out.println("Enter the numbers of passengers (Max. 10): ");
            passengers = sc.nextInt();
            
            
            System.out.println("Enter your destination: ");
            System.out.println("Enter " + valencia.getCode() + " for " + valencia.getName());
            System.out.println("Enter " + puerto_La_Cruz.getCode() + " for " + puerto_La_Cruz.getName());
            System.out.println("Enter " + barquisimeto.getCode() + " for " + barquisimeto.getName());
            destination = sc.next();
            
            if(passengers <= 10) {
                
                Client client = new Client(idNumber, passengers, destination);
                
                if(this.destinationAvailability(client)){
            
                    System.out.println("================================================");

                    System.out.println(" your Identification number is: " + client.getIdNumber());
                    System.out.println("Amount of tickets/passengers you are buying: " + client.getNumberOfPassengers());

                    switch(client.getDestination()){
                        case "Valencia": 
                              System.out.println("Your requested destination is Valencia of code V.");
                              break;

                        case "Barquisimeto":
                              System.out.println("Your requested destination is Barquisimeto of code B.");
                              break;

                        case "Puerto La Cruz":
                            System.out.println("Your requested destination is Puerto La Cruz of code P.");
                            break;
                    }


                    if(client.isFreeBuy()){
                        System.out.println("Congratulations, you are a perfect client (" + this.getNumberOfClients() + "),and for that, your buy is totally free!!");
                        System.out.println("Thanks! next client...");
                    }else{

                        System.out.println("Gross Amount to pay: " + client.getGrossAmount());
                        System.out.println("Discount amount: " + client.getDiscountAmount());
                        System.out.println("Taxes amount (IVA): " + client.getTaxAmount());
                        System.out.println("Net Amount to pay: " + client.getNetAmount());
                    }

                    System.out.println("================================================");
                } 
                
            }else System.out.println("Sorry you cannot buy that number of tickets (MAXIMUN: 10)"); 
        }
        
        this.endDay();
    }
    
    public int totalAvailableVacancies(){
        
        return this.valencia.availableVacancies() + this.puerto_La_Cruz.availableVacancies() + this.barquisimeto.availableVacancies();
    }
    
    public boolean destinationAvailability(Client client){
        
        switch(client.getDestination()){
            
            case "V": 
                
                if(this.valencia.availableVacancies() >= client.getNumberOfPassengers()){
                    this.numberOfClients++;
                    this.billing(client, this.getValencia());
                    this.calculateTotalsPerDestination(this.valencia, client);
                    return true;
                }
                else {
                    
                    System.out.println("There are not enough tickets for Valencia.");
                    System.out.println("Available tickets for Valencia: " + this.valencia.availableVacancies());
                    return false;
                }
               
            case "P": 
                
                if(this.puerto_La_Cruz.availableVacancies() >= client.getNumberOfPassengers()){
                    this.numberOfClients++;
                    this.billing(client, this.getPuerto_La_Cruz());
                    this.calculateTotalsPerDestination(this.puerto_La_Cruz, client);
                    return true;
                }
                else {
                    
                    System.out.println("There are not enough available tickets for Puerto La Cruz.");
                    System.out.println("Available tickets for Valencia: " + this.puerto_La_Cruz.availableVacancies());
                    return false;
                }
                     
            case "B": 
                
                if(this.barquisimeto.availableVacancies() >= client.getNumberOfPassengers()){
                    this.numberOfClients++;
                    this.billing(client, this.getBarquisimeto());
                    this.calculateTotalsPerDestination(this.barquisimeto, client);
                    return true;
                }
                else {
                    
                    System.out.println("There are not enough available tickets for Barquisimeto.");
                    System.out.println("Available tickets: " + this.barquisimeto.availableVacancies());
                    return false;
                }
             
            default: 
                System.out.println("Sorry, we cannot help you. That is not a valid destination.");
                return false;       
        }
    }
    
    public void billing(Client client, Destination destination){
        
        destination.setNumClients(destination.getNumClients()+ 1);
        destination.busManager(client.getNumberOfPassengers());
        this.calculateAmounts(destination.getCostPerPassenger(),  client);
    }
    
    public void calculateAmounts(int costPerPassenger, Client client){
        
        if(this.getNumberOfClients() == 6 || this.getNumberOfClients() == 28)  client.setFreeBuy(true);
        
        if(!client.isFreeBuy()){
            if(client.getNumberOfPassengers() > 4) {
                
                client.setGrossAmount(costPerPassenger * client.getNumberOfPassengers());
                
                client.setDiscountAmount((int) client.getGrossAmount() * 20/100);  //20% discount
                 
                client.setTaxAmount((int) (client.getGrossAmount() - client.getDiscountAmount())* 12/100);
                
                client.setNetAmount(client.getGrossAmount() - client.getDiscountAmount() + client.getTaxAmount());
            }else{
                
                client.setGrossAmount(costPerPassenger * client.getNumberOfPassengers());
                
                client.setDiscountAmount(0);
                 
                client.setTaxAmount((int) client.getGrossAmount() * 12/100);
                
                client.setNetAmount(client.getGrossAmount()  + client.getTaxAmount());
            }
            
        }else{
            
            client.setGrossAmount(0);
                
                client.setDiscountAmount(0);
                 
                client.setTaxAmount(0);
                
                client.setNetAmount(0);
        }      
    }
    
    public void calculateTotalsPerDestination(Destination destination, Client client){
        
        destination.setTotalNetAmount(destination.getTotalNetAmount() + client.getNetAmount());
        destination.setTotalDiscounts(destination.getTotalDiscounts() + client.getDiscountAmount());
    }
     
    public void endDay(){
        
        System.out.println("All tickets were selled. Day ended.");
        System.out.println("Total number of clients for Valencia: " + this.getValencia().getNumClients());
        System.out.println("Total number of clients for Puerto La Cruz: " + this.getPuerto_La_Cruz().getNumClients());
        System.out.println("Total number of clients for Barquisimeto: " + this.getBarquisimeto().getNumClients());
        System.out.println("Total net amounts per destination: ");
        System.out.println("Valencia: " + this.valencia.getTotalNetAmount());
        System.out.println("Puerto La Cruz: " + this.puerto_La_Cruz.getTotalNetAmount());
        System.out.println("Valencia: " + this.barquisimeto.getTotalNetAmount());
        System.out.println("Total discount amounts per destination: ");
        System.out.println("Valencia: " + this.valencia.getTotalDiscounts());
        System.out.println("Puerto La Cruz: " + this.puerto_La_Cruz.getTotalDiscounts());
        System.out.println("Valencia: " + this.barquisimeto.getTotalDiscounts());
        this.totalNetAmountToday();
        System.out.println("Total net amount for today: " + this.getTotalNetAmount());
    }
    
    public void totalNetAmountToday(){
        this.setTotalNetAmount(this.valencia.getTotalNetAmount() + this.puerto_La_Cruz.getTotalNetAmount() + this.barquisimeto.getTotalNetAmount());
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

    public int getTotalNetAmount() {
        return totalNetAmount;
    }

    public void setTotalNetAmount(int totalNetAmount) {
        this.totalNetAmount = totalNetAmount;
    }

    
    
    
}
