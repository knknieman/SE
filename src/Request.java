package softwareengineeringproject;

import static com.sun.javafx.util.Utils.split;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.net.*;
import java.net.URLEncoder;


public class Request {
    public Request(){

    }

    public String toXml(Address address) {
        String id = "341UNIVE1266";

        String xml = (
                "<AddressValidateRequest USERID=\"" + id + "\">" +
                        "<Address ID=\"0\">" +
                            "<FirmName>" + address.getFirmName() + "</FirmName>" +
                            "<Address1>" + address.getAddress1() + "</Address1>" +
                            "<Address2>" + address.getAddress2() + "</Address2>" +
                            "<City>" + address.getCity() + "</City>" +
                            "<State>" + address.getState() + "</State>" +
                            "<Zip5>" + address.getZip5() + "</Zip5>" +
                            "<Zip4>" + address.getZip4() + "</Zip4>" +
                        "</Address>" +
                        "</AddressValidateRequest>");
        try{
            return URLEncoder.encode(xml, "UTF-8");
        }
        catch(UnsupportedEncodingException e){
        }        
        
        return "";
    }
    


    public String apiRequest(String xmlAddress) {

        String urlAddress =  ("https://secure.shippingapis.com/ShippingAPI.dll?API=Verify&XML=" + xmlAddress);
        String incomingXml;

        try {
            URL url = new URL(urlAddress);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();
            incomingXml = content.toString();
        }catch(IOException e){
            incomingXml = null;
            e.printStackTrace();
        }
        return incomingXml;
    }
    public String[] xmlParse(String xml) throws UnsupportedEncodingException{

        StringBuilder returnBuild = new StringBuilder();
        String[] tags = {"FirmName","Address1", "Address2", "City", "State", "Zip5", "Zip4"};

        try {
            DocumentBuilder newDocumentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document parse = newDocumentBuilder.parse(new ByteArrayInputStream(xml.getBytes()));

            //Checks For error Message
             if (parse.getElementsByTagName("Error").item(0) != null) {
                 String[] error = {parse.getElementsByTagName("Description").item(0).getTextContent()};
                 return error;
             }
             //Parses input into StringBuilder
            for (int i = 0; i < tags.length; i++) {
                if (parse.getElementsByTagName(tags[i]).item(0) != null){
                    returnBuild.append((parse.getElementsByTagName(tags[i]).item(0).getTextContent()) + "\\s");
                }
            }
        } catch (ParserConfigurationException|IOException |SAXException e) {
            e.printStackTrace();
        }
        //tokenizes String into string array to return
        String[] returnAddress = split(returnBuild.toString(),"\\s");
        return returnAddress;
    }

}