/*
 * Name: Minh Phan
 * ID: 300269120
 * */
public class Domestic extends Commercial{
    private double airportFee;

    Domestic(String departLocation, String destination, Time departTime, Time duration, double securityFee, double airportFee){
        super(departLocation, destination, departTime, duration, securityFee);
        setFlightNumber();
        this.airportFee = airportFee;
    }
    //setters
    private void setFlightNumber() {
        flightNumber += "-D";
    }
     public void setAirportFee(double af){
        airportFee = af;
     }
    //getters
    public double getAirportFee(){
        return airportFee;
    }

    @Override
    public String toString(){
        return super.toString()+"\n";
    }




}