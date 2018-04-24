public class Address {
    String firmName, address1, address2, city, state, zip1, zip2;
    public Address(){
        firmName = "";
        address1 = "";
        address2 = "";
        city = "";
        state = "";
        zip1 = "";
        zip2 = "";
    }
    public Address(String[] inputAddress){
        setFirmName(inputAddress[0]);
        setAddress1(inputAddress[1]);
        setAddress2(inputAddress[2]);
        setCity(inputAddress[3]);
        setState(inputAddress[4]);
        setZip1(inputAddress[5]);
        setZip2(inputAddress[6]);
    }

    public void setFirmName(String firmName) {
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

    public void setZip1(String zip1){
        this.zip1 = zip1;
    }

    public void setZip2(String zip2){
        this.zip2 = zip2;
    }

    public String getFirmName() {
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

    public String getZip1() {
        return zip1;
    }

    public String getZip2() {
        return zip2;
    }

}
