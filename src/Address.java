public class Address {
    String address1, address2, city, state, zip1, zip2;
    public Address(){
        address1 = "";
        address2 = "";
        city = "";
        state = "";
        zip1 = "";
        zip2 = "";
    }
    public Address(String[] inputAddress){
        address1 = inputAddress[0];
        address2 = inputAddress[1];
        city = inputAddress[2];
        state = inputAddress[3];
        zip1 = inputAddress[4];
        zip2 = inputAddress[5];
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
