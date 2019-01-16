/*
 * Name: Minh Phan
 * ID: 300269120
 * */
public class International extends Commercial {
    private String country;

    International(String departLocation, String destination, Time departTime, Time duration, double securityFee, String country) {
        super(departLocation, destination, departTime, duration, securityFee);
        setFlightNumber();
        this.country = country;
    }

    //setters

    private void setFlightNumber() {
        flightNumber += "-I";
    }

    public void setCountry(String c) {
        country = c;
    }
    //getters

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return super.toString() + "\nCountry: " + getCountry()+"\n";
    }
}
