
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.URL;



public class Request {
    public Request(){

    }

    public String toXml(Address address) {
        String id = "341UNIVE1266";

        String xml = (
                "<AddressValidateRequest%20USERID=\"" + id + "\">" +
                        "<Address%20ID=\"0\">" +
                            "<FirmName></FirmName>" +
                            "<Address1>" + address.getAddress1() + "</Address1>" +
                            "<Address2>" + address.getAddress2() + "</Address2>" +
                            "<City>" + address.getCity() + "</City>" +
                            "<State>" + address.getState() + "</State>" +
                            "<Zip5>" + address.getZip1() + "</Zip5>" +
                            "<Zip4>" + address.getZip2() + "</Zip4>" +
                        "</Address>" +
                        "</AddressValidateRequest>");

        return xml.replaceAll("\\s","%20");
    }


    public String apiRequest(String xmlAddress){

        String urlAddress =  ("http://production.shippingapis.com/ShippingAPI.dll?API=Verify&XML=" + xmlAddress);
        String incomingXml;

        try {
            URL url = new URL(urlAddress);
            In page = new In(urlAddress);
            incomingXml = page.readAll();
        }catch(IOException e){
            incomingXml = null;
            e.printStackTrace();
        }
        return incomingXml;

    }
    public String[] xmlParse(String xml){

        String[] returnAddress = new String[7];
        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document parse = newDocumentBuilder.parse(new ByteArrayInputStream(xml.getBytes()));
            String[] tags = {"Address1", "Address2", "City", "State", "Zip5", "Zip4"};
             if (parse.getElementsByTagName("Error").item(0) != null) {
                 returnAddress[0] = parse.getElementsByTagName("Description").item(0).getTextContent();
                 return returnAddress;
             }

             for (int i = 1; i < tags.length; i++) {
                 if (parse.getElementsByTagName(tags[i]) != null)
                     returnAddress[i] = (parse.getElementsByTagName(tags[i]).item(0).getTextContent());
             }
        } catch (ParserConfigurationException|IOException |SAXException e) {
            e.printStackTrace();
        }


        return returnAddress;
    }

}
