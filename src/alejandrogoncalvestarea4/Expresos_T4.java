
package alejandrogoncalvestarea4;

import java.util.Scanner;


/**
 *
 * @author Alejandro Goncalves
 */
public class Expresos_T4 {
    private int numberOfClients, totalAmount;
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
            
            System.out.println("============================================================");
            
            Client client = new Client(idNumber, passengers, destination);
            
            
            this.destinationAvailability(client);
            
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
                System.out.println("Congratulations, you are a perfect client and for that your buy is totally free!!");
                System.out.println("Thanks! next client...");
            }else{
                
                System.out.println("Gross Amount to pay: " + client.getGrossAmount());
                System.out.println("Discount amount: " + client.getDiscountAmount());
                System.out.println("Taxes amount (IVA): " + client.getTaxAmount());
                System.out.println("Net Amount to pay: " + client.getNetAmount());
            }
            
            
            System.out.println("=================================================");
            
        }
        
    }
    
    
    public void destinationAvailability(Client client){
        
        switch(client.getDestination()){
            
            case "V": 
                
                if(this.valencia.availableVacancies() >= client.getNumberOfPassengers()){
                    this.billing(client, this.getValencia());
                    this.numberOfClients++;
                }
                else {
                    
                    System.out.println("There are not enough tickets for Valencia.");
                    System.out.println("Available tickets for Valencia: " + this.valencia.availableVacancies());
                }
                     
                break;
                      
            case "P": 
                
                if(this.puerto_La_Cruz.availableVacancies() >= client.getNumberOfPassengers()){
                    this.billing(client, this.getPuerto_La_Cruz());
                    this.numberOfClients++;
                }
                else {
                    
                    System.out.println("There are not enough available tickets for Puerto La Cruz.");
                    System.out.println("Available tickets for Valencia: " + this.puerto_La_Cruz.availableVacancies());
                }
                
                break;
                        
            case "B": 
                
                if(this.barquisimeto.availableVacancies() >= client.getNumberOfPassengers()){
                    
                    this.billing(client, this.getBarquisimeto());
                    this.numberOfClients++;
                }
                else {
                    
                    System.out.println("There are not enough available tickets for Barquisimeto.");
                    System.out.println("Available tickets: " + this.barquisimeto.availableVacancies());
                }
                
                break;
                
            default: 
                
                break;
        }
        
    }
    
     
    public void billing(Client client, Destination destination){
        
        destination.setNumClients(destination.getNumClients()+ 1);
        destination.busManager(client.getNumberOfPassengers());
        this.calculateAmounts(destination.getCostPerPassenger(),  client);
    }
    
    public void calculateAmounts(int costPerPassenger, Client client){
        
        
        
        int divisor = 1;
        int sum = 0;
        
        while(divisor < this.getNumberOfClients()){
            
            sum += divisor; 
            
            if(this.getNumberOfClients() % divisor == 0 && sum == this.getNumberOfClients() ){
                client.setFreeBuy(true);
            }  
            
        }
        
        if(!client.isFreeBuy()){
            if(client.getNumberOfPassengers() > 4) {
                
                client.setGrossAmount(costPerPassenger * client.getNumberOfPassengers());
                
                client.setDiscountAmount(client.getGrossAmount() * (20/100));
                 
                client.setTaxAmount((client.getGrossAmount() - client.getDiscountAmount())* (12/100));
                
                client.setNetAmount(client.getGrossAmount() - client.getDiscountAmount() + client.getTaxAmount());
            }else{
                
                client.setGrossAmount(costPerPassenger * client.getNumberOfPassengers());
                
                client.setDiscountAmount(0);
                 
                client.setTaxAmount((client.getGrossAmount() * (12/100)));
                
                client.setNetAmount(client.getGrossAmount()  + client.getTaxAmount());
            }
            
        }else{
            
            client.setGrossAmount(0);
                
                client.setDiscountAmount(0);
                 
                client.setTaxAmount(0);
                
                client.setNetAmount(0);
        }
        
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

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }
    
    
}
