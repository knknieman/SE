package softwareengineeringproject;

import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class FXMLDocumentController implements Initializable {
    /*@FXML gets id by tag from fxml file
    * i.e.
    * @FXML
    * private Label label; //copies object reference for 'label' in FXML
    */
    
    private Request request = new Request();
    private Address address = new Address();
    
    @FXML
    private Text title;
    
    @FXML
    private TextField FirmName;
    
    @FXML
    private TextField Address1;
    
    @FXML
    private TextField Address2;
    
    @FXML
    private TextField City;
    
    @FXML
    private TextField State;
    
    @FXML
    private TextField Zip5;
    
    @FXML
    private TextField Zip4;
    
    @FXML
    private TextArea output;
    
    @FXML
    private void getTextFields(){
        address.setFirmName(FirmName.getText());
        address.setAddress1(Address1.getText());
        address.setAddress2(Address2.getText());
        address.setCity(City.getText());
        address.setState(State.getText());
        address.setZip5(Zip5.getText());
        address.setZip4(Zip4.getText());
    }
   
    @FXML
    private void Cancel(ActionEvent event){
        System.exit(1);
    }
    
    @FXML
    private void Submit(ActionEvent event) {
        //grab information from text fields that have been filled out
        getTextFields();
        String[] returnedAddress = {};

        try{
            //construct and send HTTP GET request for API
            returnedAddress = request.xmlParse(request.apiRequest(request.toXml(address)));
        }
        catch(UnsupportedEncodingException e){
        } 
        
        StringBuilder token = new StringBuilder();
        
        for(int i = 0; i < returnedAddress.length; i++){
            token.append(returnedAddress[i]+"\n");
        }
        
        output.setText(token.toString());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        title.setFont(Font.font("Calibri", 20));
        title.setTextAlignment(TextAlignment.CENTER);
        output.setMinWidth(150d);
        output.setMinHeight(265d);
        output.setMaxWidth(150d);
        output.setMaxHeight(265d);
    }    
    
}
