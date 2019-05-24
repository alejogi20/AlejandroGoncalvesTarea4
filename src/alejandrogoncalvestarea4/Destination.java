
package alejandrogoncalvestarea4;

/**
 *
 * @author Alejandro Goncalves
 */
public class Destination {
    private String name, code;
    private int costPerPassenger, ClientsPerDestiny;
    private Vehicle bus1 = new Vehicle(10);
    private Vehicle bus2 = new Vehicle(10);
    private Vehicle bus3 = new Vehicle(10);
    
    public Destination(String name, String code, int valuePerPassenger){
        this.name = name;
        this.code = code;
        this.costPerPassenger = valuePerPassenger;
    }
    
    /* the bus manager simulates the sitting of the passengers on the Buses, one by one.
    *  If the Bus1 goes full, then it starts to seat passengers on the second bus and so on...
    *
    */
    public void busManager(int newPassengers){
        
        while(newPassengers > 0){
            
            if(this.getBus1().getCapacity() > 0){
                this.getBus1().setCapacity(this.getBus1().getCapacity() - 1);
                newPassengers--;
            }else if(this.getBus2().getCapacity() > 0){
                this.getBus2().setCapacity(this.getBus1().getCapacity() - 1);
                newPassengers--;
            }else {
                this.getBus3().setCapacity(this.getBus1().getCapacity() - 1);
                newPassengers--;
            }
            
        }
        
    }
    public int availableVacancies(){
        return this.bus1.getCapacity() + this.bus2.getCapacity() + this.bus3.getCapacity();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getValuePerPassenger() {
        return costPerPassenger;
    }

    public void setValuePerPassenger(int valuePerPassenger) {
        this.costPerPassenger = valuePerPassenger;
    }

    public int getCostPerPassenger() {
        return costPerPassenger;
    }

    public void setCostPerPassenger(int costPerPassenger) {
        this.costPerPassenger = costPerPassenger;
    }

    public int getClientsPerDestiny() {
        return ClientsPerDestiny;
    }

    public void setClientsPerDestiny(int ClientsPerDestiny) {
        this.ClientsPerDestiny = ClientsPerDestiny;
    }

    
    public Vehicle getBus1() {
        return bus1;
    }

    public void setBus1(Vehicle bus1) {
        this.bus1 = bus1;
    }

    public Vehicle getBus2() {
        return bus2;
    }

    public void setBus2(Vehicle bus2) {
        this.bus2 = bus2;
    }

    public Vehicle getBus3() {
        return bus3;
    }

    public void setBus3(Vehicle bus3) {
        this.bus3 = bus3;
    }
    
    
}
