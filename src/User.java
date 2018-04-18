import java.io.IOException;

public class User {
    public static void main(String[] args)throws IOException {
        String[] input = {"5706 Fm 1952 Rd", "5706 Fm 1952 Rd", "Wallis", "TX", "77485", ""};
        Address address = new Address(input);
        Request request = new Request();
        request.apiRequest(request.parse(address));
        //System.out.println(request.parse(address));
    }
}
