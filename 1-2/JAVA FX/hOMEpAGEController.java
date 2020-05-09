/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 *
 * @author RF
 */
public class hOMEpAGEController implements Initializable {
    
    @FXML
    private Button button;

    @FXML
    private TextField UserName;

    @FXML
    private Label label;

    @FXML
    void handleButtonAction(ActionEvent event) throws IOException {
        String User = UserName.getText();    
        //System.out.println("User");
         new Open_Client(User);
         UserName.clear();
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
