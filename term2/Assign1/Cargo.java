/*
* Name: Minh Phan
* ID: 300269120
* */

public class Cargo extends Flight{
    private String  freightDescription;

    Cargo(String departLocation, String destination, Time departTime, Time duration, String freightDescription ){
        super(departLocation, destination, departTime, duration);
        setFlightNumber();
        this.freightDescription = freightDescription;
    }
    //setters
    private void setFlightNumber(){
        flightNumber+="-C";
    }
    public void setFreightDescription(String fd){
        freightDescription = fd;
    }
    //getters
    public String getFreightDescription(){
        return freightDescription;
    }

    @Override
    public String toString() {
        return super.toString()+"Freight: " +getFreightDescription()+"\n";
    }
}