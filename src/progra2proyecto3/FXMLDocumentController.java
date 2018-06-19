/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra2proyecto3;

import domain.Chimera;
import domain.Zombie;
import domain.Player;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
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
        
        try {
            updateInterface();
        } catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        }
        addKeyAction();
        godThread();
        moveThread();
//        AudioClip note = new AudioClip(this.getClass().getResource("/sounds/Indiana Jones Theme 8-Bit.mp3").toString());
//        note.play();
    }

    private void updateInterface() throws IOException {

        if(this.player.getLive()<0){
            cambioScene("/progra2proyecto3/GameOver.fxml");
        }
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
                try {
                    updateInterface();
//                downThread();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getCode() == KeyCode.LEFT) {
                this.player.playerLeft();
                try {
                    updateInterface();
//                downThread();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getCode() == KeyCode.UP) {
                this.player.playerUp();
                try {
                    updateInterface();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getCode() == KeyCode.DOWN) {
                this.player.playerDown();
                try {
                    updateInterface();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            //cambiar armas del personaje
            if (e.getCode() == KeyCode.DIGIT1) {
                this.player.changeWeapons(1);
                try {
                    updateInterface();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getCode() == KeyCode.DIGIT2) {
                this.player.changeWeapons(2);
                try {
                    updateInterface();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getCode() == KeyCode.DIGIT3) {
                this.player.changeWeapons(3);
                try {
                    updateInterface();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (e.getCode() == KeyCode.A) {
                this.player.setLive(0);
                try {
                    updateInterface();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getCode()== KeyCode.S) {
                this.player.setLive(1);
                try {
                    updateInterface();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getCode()== KeyCode.D) {
                this.player.setLive(2);
                try {
                    updateInterface();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (e.getCode()== KeyCode.F) {
                this.player.setLive(3);
                try {
                    updateInterface();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
            if (e.isControlDown() && e.getCode() == KeyCode.RIGHT) {
                this.player.removeEarthRight();
                try {
                    updateInterface();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else if (e.isControlDown() && e.getCode() == KeyCode.LEFT) {
                this.player.removeEarthLeft();
                try {
                    updateInterface();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            } else if (e.isControlDown() && e.getCode() == KeyCode.UP) {
                this.player.removeEarthUp();
                try {
                    updateInterface();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else if (e.isControlDown() && e.getCode() == KeyCode.DOWN) {
                this.player.removeEarthDown();
                try {
                    updateInterface();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
            //ataca
            if (e.isAltDown()&& e.getCode() == KeyCode.RIGHT) {
                try {
                    atackRight();
                } catch (InterruptedException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    updateInterface();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } else if (e.isAltDown()&& e.getCode() == KeyCode.LEFT) {
                try {
                    atackLeft();
                } catch (InterruptedException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    updateInterface();
                } catch (IOException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });

    }

    private void zombieThread(int row, int column) throws IOException {
        

            Zombie h = new Zombie(row, column);
            
            int random;
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
                
            
        

    }

    private void chimeraThread(int row,int column) throws IOException {

            Chimera c = new Chimera(row, column);
            int random;
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
                

    }
    
    private void moveThread(){
        Runnable runnable = () -> {
            while(true){
                for (int i = 0; i < this.logic.cell.length; i++) {
                    for (int j = 0; j < this.logic.cell[0].length; j++) {
                        if(this.logic.cell[i][j].getID() == 7){
                            try {
                                chimeraThread(i, j);
                            } catch (IOException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try {
                                updateInterface();
                            } catch (IOException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else if(this.logic.cell[i][j].getID() == 8){
                            try {
                                zombieThread(i, j);
                            } catch (IOException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            try {
                                updateInterface();
                            } catch (IOException ex) {
                                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        Thread t = new Thread(runnable);
        t.start();
    }

    private void godThread() {
        
        Runnable runnable = () -> {

                while(true) {
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
                    new Zombie(idThread);
                    try {
                        updateInterface();
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.print("God crea un nuevo zombie");
//                    limZ--;
                } else if (random > zombie && random <= chimera && limC > 0) {
                    new Chimera(idThread);
                    try {
                        updateInterface();
                    } catch (IOException ex) {
                        Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.print("God crea un nuevo dragón");
//                    limC--;
                }
                try {
                    Thread.sleep(1200);
                } catch (InterruptedException ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        };
        Thread t = new Thread(runnable);
        t.start();
        
    }

    @FXML
    private void x(ActionEvent event) throws IOException {
        this.player.playerRight();
        updateInterface();
    }
    
    public void atackRight() throws InterruptedException, IOException{
        this.playerRow = this.player.getPlayerRow();
        this.playerColumn = this.player.getPlayerColumn();
        this.logic.cell[this.playerRow][this.playerColumn+1].setLives(this.logic.cell[this.playerRow][this.playerColumn+1].getLives()-1);
        if(this.logic.cell[this.playerRow][this.playerColumn+1].getLives()==0){
            System.out.println(">>>>>>>>>> " + this.logic.cell[this.playerRow][this.playerColumn + 1].getIdThread());
//            this.threadsList.get(this.logic.cell[this.playerRow][this.playerColumn + 1].getIdThread()).suspend();
//            this.threadsList.get(this.logic.cell[this.playerRow][this.playerColumn + 1].getIdThread()).stop();
//            this.threadsList.get(this.logic.cell[this.playerRow][this.playerColumn + 1].getIdThread()).destroy();
//            this.threadsList.get(this.logic.cell[this.playerRow][this.playerColumn + 1].getIdThread()).wait();
//            threadsList.remove(this.threadsList.get(this.logic.cell[this.playerRow][this.playerColumn + 1].getIdThread()));
            this.logic.cell[this.playerRow][this.playerColumn + 1].setIdAndImage(0);
            this.logic.cell[this.playerRow][this.playerColumn + 1].setIdThread(-1);
            updateInterface();
        }
    }
    
    public void atackLeft() throws InterruptedException, IOException{
        this.playerRow = this.player.getPlayerRow();
        this.playerColumn = this.player.getPlayerColumn();
        
      this.logic.cell[this.playerRow][this.playerColumn-1].setLives(this.logic.cell[this.playerRow][this.playerColumn-1].getLives()-1);
      if(this.logic.cell[this.playerRow][this.playerColumn-1].getLives()==0){
//            this.threadsList.get(this.logic.cell[this.playerRow][this.playerColumn - 1].getIdThread()).suspend();
//            this.threadsList.get(this.logic.cell[this.playerRow][this.playerColumn - 1].getIdThread()).stop();
//            this.threadsList.get(this.logic.cell[this.playerRow][this.playerColumn - 1].getIdThread()).destroy();
//            this.threadsList.get(this.logic.cell[this.playerRow][this.playerColumn - 1].getIdThread()).wait();
//            threadsList.remove(this.threadsList.get(this.logic.cell[this.playerRow][this.playerColumn - 1].getIdThread()));
           
            this.logic.cell[this.playerRow][this.playerColumn - 1].setIdAndImage(0);
            this.logic.cell[this.playerRow][this.playerColumn - 1].setIdThread(-1);
            updateInterface();
        }
    }
    
    private void cambioScene( String destino) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource(destino));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) anchorPane).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.setX(0);
        window.setY(0);
        window.setFullScreen(true);
        window.show();
        
    }

}
