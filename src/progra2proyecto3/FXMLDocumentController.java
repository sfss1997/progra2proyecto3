/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra2proyecto3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author hvill
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    AnchorPane anchorPane;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ImageView imageView = new ImageView("newpackage/4afb8339-9594-4917-95d2-2336c1369c2e.png");
        imageView.setLayoutX(300);
        imageView.setLayoutY(300);
        imageView.setFitHeight(100);
        imageView.setFitWidth(100);
        
        anchorPane.getChildren().add(imageView);
    }    
    
}
