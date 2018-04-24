
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;


public class RequestTest {

    @Test
    public void toXml() {
        Request request = new Request();
        String[] input = {"","5706 Fm 1952", "", "Wallis", "Tx", "77485", ""};
        String expected = "<AddressValidateRequest%20USERID=\"341UNIVE1266\"><Address%20ID=\"0\"><FirmName></FirmName>" +
                "<Address1>5706%20Fm%201952</Address1>" +
                "<Address2></Address2><City>Wallis</City><State>Tx</State><Zip5>77485</Zip5>" +
                "<Zip4></Zip4></Address></AddressValidateRequest>";

        Address address = new Address(input);
        String received = request.toXml(address);
        assertEquals(expected, received);
    }

    @Test
    public void apiRequest() {
        Request request = new Request();
        String[] input = {"","5706 Fm 1952", "", "Wallis", "Tx", "77485", ""};
        String expected = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><AddressValidateResponse><Address ID=\"0\">" +
                "<Address2>5706 FM 1952 RD</Address2>" +
                "<City>WALLIS</City><State>TX</State><Zip5>77485</Zip5>" +
                "<Zip4>9659</Zip4></Address></AddressValidateResponse>";
        Address address = new Address(input);
        String xml = request.toXml(address);
        String received = request.apiRequest(xml);
        assertEquals(expected, received);
    }

    @Test
    public void xmlParse() {
        Request request = new Request();
        String[] input = {"","5706 Fm 1952", "", "Wallis", "Tx", "77485", ""};
        String[] expected = {"5706 FM 1952 RD", "WALLIS", "TX", "77485", "9659"};
        Address address = new Address(input);
        String xml = request.toXml(address);
        String receivedXml = request.apiRequest(xml);
        String[] received = request.xmlParse(receivedXml);

        for(int i = 0; i < received.length; i++){
            assertEquals(expected[i], received[i]);
        }


    }
}
