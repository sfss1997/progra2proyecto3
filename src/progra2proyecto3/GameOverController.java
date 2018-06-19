/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra2proyecto3;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.scene.media.AudioClip;

/**
 * FXML Controller class
 *
 * @author fabian
 */
public class GameOverController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        AudioClip note = new AudioClip(this.getClass().getResource("/sounds/mario-bros game over.mp3").toString());
        note.play();
    }    
    
}
