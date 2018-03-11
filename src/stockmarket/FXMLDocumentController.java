/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockmarket;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author simarjit singh pannu
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML private TextField shareNameTextField;
    @FXML private TextField sharePriceTextField;
    @FXML private TextField shareCountryTextField;
    @FXML private TextField errorMessg;
    
    
    public void saveButtonPush(ActionEvent event)
    {
          try{

                if(shareNameTextField.getText().isEmpty()){

            }

            else if(sharePriceTextField.getText().isEmpty()){

                errorMessg.setText("Last name is mandatory"); 

            }

            else if(shareCountryTextField.getText().isEmpty()){

                 errorMessg.setText("Phone number is required"); 

            }
           Stock s1 = new Stock(shareNameTextField.getText(),sharePriceTextField.getText(),shareCountryTextField.getText()
                   );
           
           errorMessg.setText("");
      s1.insertIntoDB();  //this will insert all the values into the database
      System.out.println("The share has been saved !");
      
      //This will redirect the users to the main table page after they save their contact information
      Parent tableViewParent = FXMLLoader.load(getClass().getResource("shareTable.fxml"));
        Scene tableViewScene = new Scene(tableViewParent);
        
        Stage box = (Stage)((Node)event.getSource()).getScene().getWindow();  
        
        box.setScene(tableViewScene);
        box.show();
           }
      
        catch (Exception e)

            {

                errorMessg.setText(e.getMessage());

            }
        
      }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      
    
}

    
    
    
    
    
    
    
    
    
    
    
    

    
    
    
    
        // TODO
    
    

