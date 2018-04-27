package softwareengineeringproject;

public class Address {
    String firmName, address1, address2, city, state, zip5, zip4;
    
    public Address(){
        firmName = "";
        address1 = "";
        address2 = "";
        city = "";
        state = "";
        zip5 = "";
        zip4 = "";
    }
    public Address(String[] inputAddress){
        firmName = inputAddress[0];
        address1 = inputAddress[1];
        address2 = inputAddress[2];
        city = inputAddress[3];
        state = inputAddress[4];
        zip5 = inputAddress[5];
        zip4 = inputAddress[6];
    }

    public void setFirmName(String firmName){
        this.firmName = firmName;
    }
    
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public void setAddress2(String address2){
        this.address2 = address2;
    }

    public void setCity(String city){
        this.city = city;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setZip5(String zip1){
        this.zip5 = zip5;
    }

    public void setZip4(String zip2){
        this.zip4 = zip4;
    }

    public String getFirmName(){
        return firmName;
    }
    
    public String getAddress1(){
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getZip5() {
        return zip5;
    }

    public String getZip4() {
        return zip4;
    }

}