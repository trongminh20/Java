/*
 * Name: Minh Phan
 * ID: 300269120
 * */
public class Commercial extends Flight{
    private String status;
    private double securityFee;

    Commercial(String departLocation, String destination, Time departTime, Time duration, double securityFee){
        super(departLocation, destination, departTime, duration);

        this.status = "On time";
        this.securityFee = securityFee;
    }

    //setters

    public void setStatus(String stt){
        status = stt;
    }
    public void setSecurityFee(double sf){
        securityFee =sf;
    }

    //getters

    public String getStatus(){
        return status;
    }
    public double getSecurityFee(){
        return securityFee;
    }
    @Override
    public String toString(){
        return super.toString()+"Status: " + getStatus();
    }

}