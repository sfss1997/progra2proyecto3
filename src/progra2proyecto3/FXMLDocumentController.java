/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra2proyecto3;

import domain.Hilo;
import domain.Player;
import logic.Logic;
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
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Line;
import javafx.util.Duration;

/**
 *
 * @author hvill
 */
public class FXMLDocumentController implements Initializable {

    private Logic logic;
    private Player player;
    private Hilo zombie;

    @FXML
    private Canvas caca;
    @FXML
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        this.logic = new Logic();
        this.logic.createGridPane();
        this.player = new Player(2, 2);
        this.zombie = new Hilo(0, 0);
        updateInterface();
        this.logic.cell[0][0].setIdAndImageView(3);
        addKeyAction();

//        Image imageView = new Image("newpackage/4afb8339-9594-4917-95d2-2336c1369c2e.png");
//
//        caca.getGraphicsContext2D().drawImage(imageView, 0, 0);
//        Line line1 = new Line(2 * 100, 2 * 100, 4 * 100, 2 * 100);
//        PathTransition pathTransitionBubble = new PathTransition();
//        pathTransitionBubble.setNode(imageView);
//        pathTransitionBubble.setDuration(Duration.seconds(1));
//        pathTransitionBubble.setPath(line1);
//        pathTransitionBubble.play();
        zombieThread();
    }

    private void updateInterface() {

        caca.getGraphicsContext2D().clearRect(0, 0, 800, 600);
        for (int i = 0; i < this.logic.cell.length; i++) {
            for (int j = 0; j < this.logic.cell[0].length; j++) {

                Image imageView = this.logic.cell[i][j].getImageView();
                int y = this.logic.cell[i][j].getRow() * 100;
                int x = this.logic.cell[i][j].getColumn() * 100;

                caca.getGraphicsContext2D().drawImage(imageView, x, y);

            }
        }

    }

    public void addKeyAction() {
        anchorPane.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.RIGHT) {
                this.player.playerRight();
                updateInterface();
            } else if (e.getCode() == KeyCode.LEFT) {
                this.player.playerLeft();
                updateInterface();
            } else if (e.getCode() == KeyCode.UP) {
                this.player.playerUp();
                updateInterface();
            } else if (e.getCode() == KeyCode.DOWN) {
                this.player.playerDown();
                updateInterface();

            }

//            if(e.isControlDown() && e.getCode() == KeyCode.RIGHT){
//                this.player.removeEarthRight();
//            } else if(e.isControlDown() && e.getCode() == KeyCode.LEFT){
//                this.player.removeEarthLeft();
//            } else if(e.isControlDown() && e.getCode() == KeyCode.UP){
//                this.player.removeEarthUp();
//            } else if(e.isControlDown() && e.getCode() == KeyCode.DOWN){
//                this.player.removeEarthDown();
//            }
        });

    }

    private void zombieThread() {
        Runnable runnable = () -> {
        Hilo h = new Hilo(0, 0);
        int random;
        while (true) {
            random = (int) (Math.random() * 4);
            System.out.println(random);
            if (random == 0) {
                h.zombieUp();
                updateInterface();
            } else if (random == 1) {
                h.zombieDown();
                updateInterface();
            } else if (random == 2) {
                h.zombieLeft();
                updateInterface();
            } else if (random == 3) {
                h.zombieRight();
                updateInterface();
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Hilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        };
        Thread t = new Thread(runnable);
        t.start();
        
    }

    @FXML
    private void sadasdasd(ActionEvent event) {
        this.player.playerRight();
                updateInterface();
                zombieThread();
    }

}
