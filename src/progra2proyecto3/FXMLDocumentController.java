/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra2proyecto3;

import domain.Chimera;
import domain.Zombie;
import domain.Player;
import logic.Logic;
import java.net.URL;
import java.util.LinkedList;
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
import logic.Live;
import static logic.Logic.configuration;
import logic.PlayerWay;

/**
 *
 * @author hvill
 */
public class FXMLDocumentController implements Initializable {

    private static Logic logic;
    private Player player;
    private Zombie zombie;
    private int limZ;
    private int limC;
    private LinkedList<Thread> threadsList;
    private static int idThread;
    private static int playerRow;
    private static int playerColumn;

    @FXML
    private Canvas caca;
    @FXML
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        this.limC = 3;
        this.limZ = 5;
        
        this.logic = new Logic();
        this.anchorPane.setPrefSize(configuration.getWidth() * 75, configuration.getHeight() * 75);
        this.caca.setHeight(configuration.getHeight() * 75);
        this.caca.setWidth(configuration.getWidth() * 75);
        this.logic.createCell();
        this.player = new Player();
        
        this.threadsList = new LinkedList<>();
        this.idThread = 0;
        
        updateInterface();
        addKeyAction();
        godThread();

//        AudioClip note = new AudioClip(this.getClass().getResource("/sounds/Indiana Jones Theme 8-Bit.mp3").toString());
//        note.play();
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
        if(player.getLive()==3){
            this.logic.live[0].setIdAndImage(1);
            this.logic.live[1].setIdAndImage(1);
            this.logic.live[2].setIdAndImage(1);
        }else if(player.getLive()==2){
            this.logic.live[0].setIdAndImage(0);
            this.logic.live[1].setIdAndImage(1);
            this.logic.live[2].setIdAndImage(1);
        }else if(player.getLive()==1){
            this.logic.live[0].setIdAndImage(0);
            this.logic.live[1].setIdAndImage(0);
            this.logic.live[2].setIdAndImage(1);
        }else if(player.getLive()==0){
            this.logic.live[0].setIdAndImage(0);
            this.logic.live[1].setIdAndImage(0);
            this.logic.live[2].setIdAndImage(0);
        }
        for (int i = 0; i < 3; i++) {
            Image imageView = this.logic.live[i].getImage();
            
            int x=(configuration.getWidth()* 75)-30;
            int y= i*30;
            caca.getGraphicsContext2D().drawImage(imageView, x, y);
            
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
            
            if (e.getCode() == KeyCode.A) {
                this.player.setLive(0);
                updateInterface();
            } else if (e.getCode()== KeyCode.S) {
                this.player.setLive(1);
                updateInterface();
            } else if (e.getCode()== KeyCode.D) {
                this.player.setLive(2);
                updateInterface();
            } else if (e.getCode()== KeyCode.F) {
                this.player.setLive(3);
                updateInterface();
            }
            
            if (e.isControlDown() && e.getCode() == KeyCode.RIGHT) {
                this.player.removeEarthRight();
                updateInterface();
                
            } else if (e.isControlDown() && e.getCode() == KeyCode.LEFT) {
                this.player.removeEarthLeft();
                updateInterface();
               
            } else if (e.isControlDown() && e.getCode() == KeyCode.UP) {
                this.player.removeEarthUp();
                updateInterface();
                
            } else if (e.isControlDown() && e.getCode() == KeyCode.DOWN) {
                this.player.removeEarthDown();
                updateInterface();
                
            }
            
            //ataca
            if (e.isAltDown()&& e.getCode() == KeyCode.RIGHT) {
                atackRight();
                updateInterface();
                
            } else if (e.isAltDown()&& e.getCode() == KeyCode.LEFT) {
                atackLeft();
                updateInterface();
               
            }
        });

    }

    private void zombieThread() {
        Runnable runnable = () -> {

            Zombie h = new Zombie(this.idThread);
            this.idThread++;
            int random;
            while (true) {
                random = (int) (Math.random() * 4);

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
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Zombie.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        Thread t = new Thread(runnable);
        threadsList.add(t);
        if(threadsList.isEmpty()){
            threadsList.get(0).start();
        } else {
            threadsList.get(threadsList.size()-1).start();
        }

    }

    private void chimeraThread() {
        Runnable runnable = () -> {

            Chimera c = new Chimera(this.idThread);
            this.idThread++;
            int random;
            while (true) {
                random = (int) (Math.random() * 4);

                if (random == 0) {
                    c.chimeraUp();
                    updateInterface();
                } else if (random == 1) {
                    c.chimeraDown();
                    updateInterface();
                } else if (random == 2) {
                    c.chimeraLeft();
                    updateInterface();
                } else if (random == 3) {
                    c.chimeraRight();
                    updateInterface();
                }
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Chimera.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        Thread t = new Thread(runnable);
        threadsList.add(t);
        if(threadsList.isEmpty()){
            threadsList.get(0).start();
        } else {
            threadsList.get(threadsList.size()-1).start();
        }

    }

    private void godThread() {
        Runnable runnable = () -> {

            for (int i = 0; i < 100; i++) {
                
            
                int random = (int) ((Math.random() * 101) + 1);
                int stone = configuration.getProbabilities().getStone();
                int zombie = stone + configuration.getProbabilities().getZombie();
                int chimera = zombie + configuration.getProbabilities().getChimera();
                if (random <= stone) {
                    //crear piedra
                    int randomRow = (int) (Math.random() * this.logic.cell.length);
                    int randomColumn = (int) (Math.random() * this.logic.cell[0].length);
                    if (player.isEarthDown(randomRow, randomColumn) == true) {
                        this.logic.cell[randomRow][randomColumn].setIdAndImage(9);
                        System.out.print("God crea tierra");
                    }
                } else if (random > stone && random <= zombie && limZ > 0) {
                    zombieThread();
                    System.out.print("God crea un nuevo zombie");
                    limZ--;
                } else if (random > zombie && random <= chimera && limC > 0) {
                    chimeraThread();
                    System.out.print("God crea un nuevo dragón");
                    limC--;
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
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
    
    public void atackRight(){
        this.playerRow = this.player.getPlayerRow();
        this.playerColumn = this.player.getPlayerColumn();
        if(playerColumn < this.logic.cell[0].length - 1 && this.logic.cell[this.playerRow][this.playerColumn + 1].getIdThread() != -1){
            System.out.println(">>>>>>>>>> " + this.logic.cell[this.playerRow][this.playerColumn + 1].getIdThread());
            this.threadsList.get(this.logic.cell[this.playerRow][this.playerColumn + 1].getIdThread()).stop();
            this.logic.cell[this.playerRow][this.playerColumn + 1].setIdAndImage(0);
            this.logic.cell[this.playerRow][this.playerColumn + 1].setIdThread(-1);
        }
    }
    
    public void atackLeft(){
        this.playerRow = this.player.getPlayerRow();
        this.playerColumn = this.player.getPlayerColumn();
        if(this.playerColumn > 0 && this.logic.cell[this.playerRow][this.playerColumn - 1].getIdThread() != -1){
            this.threadsList.get(this.logic.cell[this.playerRow][this.playerColumn - 1].getIdThread()).stop();
            this.logic.cell[this.playerRow][this.playerColumn + 1].setIdAndImage(0);
            this.logic.cell[this.playerRow][this.playerColumn + 1].setIdThread(-1);
        }
    }

}
