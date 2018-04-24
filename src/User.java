import java.util.Scanner;

public class User {
    public static void main(String[] args){
        Address address = new Address();
        inputArray(address);
        Request request = new Request();

        String[] returnedAddress = request.xmlParse(request.apiRequest(request.toXml(address)));
        printArray(returnedAddress);
    }

    public static void inputArray(Address address){
        Scanner keys = new Scanner(System.in);

        out("Enter FirmName");
        address.setFirmName(keys.nextLine());
        out("Enter address 1");
        address.setAddress1(keys.nextLine());
        out("Enter address 2");
        address.setAddress2(keys.nextLine());
        out("Enter City");
        address.setCity(keys.nextLine());
        out("Enter State code");
        address.setState(keys.nextLine());
        out("Enter zip5");
        address.setZip1(keys.nextLine());
        out("Enter zip4");
        address.setZip2(keys.nextLine());


    }

    public static void printArray(String[] array){

        if(array.length > 1)
            out("Returned address");
        else
            out("Error");

        for(int i = 0;i < array.length; i++){
            if(array[i] != null)
                System.out.println(array[i]);

        }
    }
    public static void out(String in){
        System.out.println(in);
    }
}
