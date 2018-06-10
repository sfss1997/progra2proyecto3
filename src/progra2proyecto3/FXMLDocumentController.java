/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra2proyecto3;

import domain.Logic;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PathTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

/**
 *
 * @author hvill
 */
public class FXMLDocumentController implements Initializable {

    private Logic logic;
    
    @FXML
    AnchorPane anchorPane;
    @FXML
    private Canvas caca;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.logic = new Logic();
        this.logic.createGridPane();
        x();
        Image imageView = new Image("newpackage/4afb8339-9594-4917-95d2-2336c1369c2e.png");

        caca.getGraphicsContext2D().drawImage(imageView, 0, 0);

//        Line line1 = new Line(2 * 100, 2 * 100, 4 * 100, 2 * 100);
//        PathTransition pathTransitionBubble = new PathTransition();
//        pathTransitionBubble.setNode(imageView);
//        pathTransitionBubble.setDuration(Duration.seconds(1));
//        pathTransitionBubble.setPath(line1);
//        pathTransitionBubble.play();
    }

    private void x() {

        Runnable runnable = () -> {
            for (int i = 0; i < 6; i++) {
                for (int j = 0; j < 8; j++) {
                    Image imageView = this.logic.cell[i][j].getImageView();
                    caca.getGraphicsContext2D().drawImage(imageView, j * 100, i * 100);

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        };
        Thread t = new Thread(runnable);
        t.start();
//        Platform.runLater(runnable);
    }

}
