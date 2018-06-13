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
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import static logic.Logic.configuration;
import logic.PlayerWay;

/**
 *
 * @author hvill
 */
public class FXMLDocumentController implements Initializable {

    private static Logic logic;
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
        this.anchorPane.setPrefSize(configuration.getWidth() * 75, configuration.getHeight() * 75);
        this.caca.setHeight(configuration.getHeight() * 75);
        this.caca.setWidth(configuration.getWidth() * 75);
        this.logic.createCell();
        this.player = new Player();
        updateInterface();
        addKeyAction();
        
        AudioClip note = new AudioClip(this.getClass().getResource("/sounds/Indiana Jones Theme 8-Bit.mp3").toString());
        note.play();
    }

    private void updateInterface() {

        caca.getGraphicsContext2D().clearRect(0, 0, configuration.getWidth() * 75, configuration.getHeight() * 75);
        for (int i = 0; i < this.logic.cell.length; i++) {
            for (int j = 0; j < this.logic.cell[0].length; j++) {

                Image imageView = this.logic.cell[i][j].getImage();
                int y = this.logic.cell[i][j].getRow() * 75;
                int x = this.logic.cell[i][j].getColumn() * 75;

                caca.getGraphicsContext2D().drawImage(imageView, x, y);

            }
        }

    }

    public void addKeyAction() {
        anchorPane.setOnKeyPressed(e -> {
            //mover al personaje
            if (e.getCode() == KeyCode.RIGHT) {
                this.player.playerRight();
                updateInterface();
//                downThread();
            } else if (e.getCode() == KeyCode.LEFT) {
                this.player.playerLeft();
                updateInterface();
//                downThread();
            } else if (e.getCode() == KeyCode.UP) {
                this.player.playerUp();
                updateInterface();
            } else if (e.getCode() == KeyCode.DOWN) {
                this.player.playerDown();
                updateInterface();
            }

            //cambiar armas del personaje
            if (e.getCode() == KeyCode.DIGIT1) {
                this.player.changeWeapons(1);
                updateInterface();
            } else if (e.getCode() == KeyCode.DIGIT2) {
                this.player.changeWeapons(2);
                updateInterface();
            } else if (e.getCode() == KeyCode.DIGIT3) {
                this.player.changeWeapons(3);
                updateInterface();
            }

            if (e.isControlDown() && e.getCode() == KeyCode.RIGHT) {
                this.player.removeEarthRight();
                updateInterface();
                AudioClip note = new AudioClip(this.getClass().getResource("/sounds/BlazeHurt.mp3").toString());
                note.play();
            } else if (e.isControlDown() && e.getCode() == KeyCode.LEFT) {
                this.player.removeEarthLeft();
                updateInterface();
                AudioClip note = new AudioClip(this.getClass().getResource("/sounds/BlazeHurt.mp3").toString());
                note.play();
            } else if (e.isControlDown() && e.getCode() == KeyCode.UP) {
                this.player.removeEarthUp();
                updateInterface();
                AudioClip note = new AudioClip(this.getClass().getResource("/sounds/BlazeHurt.mp3").toString());
                note.play();
            } else if (e.isControlDown() && e.getCode() == KeyCode.DOWN) {
                this.player.removeEarthDown();
                updateInterface();
                AudioClip note = new AudioClip(this.getClass().getResource("/sounds/BlazeHurt.mp3").toString());
                note.play();
            }
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

    private void downThread() {

        Runnable runnable = () -> {

            boolean x = true;
            while (x == true) {
                int playerRow = player.getPlayerRow();
                int playerColumn = player.getPlayerColumn();
                int weapon = player.getWeapon();
                if (player.isEarthDown(playerRow, playerColumn) == true) {
                    System.out.println("aaaaa");
                    x = false;
                    updateInterface();
                } else if (player.isEarthDown(playerRow, playerColumn) == false) {
                    this.logic.cell[playerRow][playerColumn].setIdAndImage(0);
                    player.setPlayerRow(playerRow++);
                    player.playerWay(weapon, PlayerWay.RIGHT);
                    updateInterface();
                }

                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Player.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        Thread t = new Thread(runnable);
        t.start();
    }

    @FXML
    private void x(ActionEvent event) {
        this.player.playerRight();
        updateInterface();
    }

}
