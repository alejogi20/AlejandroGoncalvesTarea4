
package alejandrogoncalvestarea4;

/**
 *
 * @author Alejandro Goncalves
 */
public class Client {
    
    private int idNumber,numberOfPassengers, grossAmount, discountAmount, taxAmount, netAmount;
    private String destination;
    private boolean freeBuy;
    
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

    public int getGrossAmount() {
        return grossAmount;
    }

    public void setGrossAmount(int grossAmount) {
        this.grossAmount = grossAmount;
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(int taxAmount) {
        this.taxAmount = taxAmount;
    }

    public int getNetAmount() {
        return netAmount;
    }

    public void setNetAmount(int netAmount) {
        this.netAmount = netAmount;
    }

    public boolean isFreeBuy() {
        return freeBuy;
    }

    public void setFreeBuy(boolean freeBuy) {
        this.freeBuy = freeBuy;
    }
    
    
    
    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }
    
    
}

    
