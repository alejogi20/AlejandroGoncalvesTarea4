
package alejandrogoncalvestarea4;

/**
 *
 * @author Alejandro Goncalves
 */
public class Client {
    
    private int idNumber,numberOfPassengers;
    private String destination;
    
    public Client(int idNumber, int numberOfPassengers, String destination) {
        this.idNumber = idNumber;
        this.numberOfPassengers = numberOfPassengers;
        this.destination = destination;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int identityDocumentNumber) {
        this.idNumber = identityDocumentNumber;
    }

    public int getNumberOfPassengers() {
        return numberOfPassengers;
    }

    public void setNumberOfPassengers(int numberOfPassengers) {
        this.numberOfPassengers = numberOfPassengers;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    
}

    
