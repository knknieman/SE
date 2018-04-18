
import com.sun.javafx.fxml.builder.URLBuilder;

import java.io.*;
import java.net.HttpURLConnection;

import java.net.URL;


public class Request {
    public Request(){

    }

    public String parse(Address address) {
        String id = "341UNIVE1266";
        String xml = (
                "<AddressValidateRequest USERID=\"" + id + "\">" +
                        "<Address ID=\"0\">" +
                            "<FirmName></FirmName>" +
                            "<Address1>" + address.getAddress1() + "</Address1>" +
                            "<Address2>" + address.getAddress2() + "</Address2>" +
                            "<City>" + address.getCity() + "</City>" +
                            "<Zip5>" + address.getZip1() + "</Zip5>" +
                            "<Zip4>" + address.getZip2() + "</Zip4>" +
                        "</Address>" +
                        "</AddressValidateRequest>");

        return xml;
    }


    public void apiRequest(String xmlAddress)throws IOException{
        //String urlAddress =  ("http://production.shippingapis.com/ShippingAPI.dll?API=Verify&XML=" + xmlAddress);
        //String urlAddress = "http://production.shippingapis.com/ShippingAPI.dll";
        String urlAddress = "https://secure.shippingapis.com/ShippingAPI.dll?API=Verify&XML=" + xmlAddress;

        System.out.println(urlAddress);
            URL url = new URL(urlAddress);
            HttpURLConnection connect = (HttpURLConnection) url.openConnection();
        System.out.println(connect.getResponseCode());
            connect.setRequestMethod("GET");
            System.out.println(connect.getResponseCode());
            /*
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connect.getInputStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();

            while((inputLine = in.readLine()) != null){
                response.append(inputLine);
            }
            in.close();
            System.out.println(response.toString());*/

    }

}
