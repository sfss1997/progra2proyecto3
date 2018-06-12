/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author hvill
 */
public class Cell extends Pane {

    private Image image;
    private int id;
    private int row;
    private int column;
    private PlayerWay playerWay;

    public Cell() {
        setStyle("-fx-border-color : black");
        this.setPrefSize(75, 75);
        this.image = new Image("/images/tierra.png");
        this.id = 9;
        this.playerWay = PlayerWay.LEFT;
    }

    public PlayerWay getPlayerWay() {
        return playerWay;
    }

    public void setPlayerWay(PlayerWay playerWay) {
        this.playerWay = playerWay;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image imageView) {
        this.image = imageView;
    }

    public int getID() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * 0 = Nada
     * 1 = Espada Derecha
     * 2 = Espada Izquierda
     * 3 = Latigo Derecha
     * 4 = Latigo Izquierda
     * 5 = Pala Derecha
     * 6 = Pala Izquierda
     * 7 = Dragon
     * 8 = Zombie
     * @param id 
     */
    public void setIdAndImage(int id) {
        if (id == 0) {
            this.getChildren().clear();
            this.id = id;
            this.image = null;
        } else if (id == 1) {
            this.getChildren().clear();
            this.playerWay = this.playerWay.RIGHT;
            this.id = id;
            this.image = new Image("/images/espada1.png");
        } else if (id == 2) {
            this.getChildren().clear();
            this.playerWay = this.playerWay.LEFT;
            this.id = id;
            this.image = new Image("/images/espada2.png");
        } else if (id == 3) {
            this.getChildren().clear();
            this.playerWay = this.playerWay.RIGHT;
            this.id = id;
            this.image = new Image("/images/latigo1.png");
        } else if (id == 4) {
            this.getChildren().clear();
            this.playerWay = this.playerWay.LEFT;
            this.id = id;
            this.image = new Image("/images/latigo2.png");
        } else if (id == 5) {
            this.getChildren().clear();
            this.playerWay = this.playerWay.RIGHT;
            this.id = id;
            this.image = new Image("/images/pala1.png");
        } else if (id == 6) {
            this.getChildren().clear();
            this.playerWay = this.playerWay.LEFT;
            this.id = id;
            this.image = new Image("/images/pala2.png");
        } else if (id == 7) {
            this.getChildren().clear();
            this.id = id;
            this.image = new Image("/images/drago.png");
        } else if (id == 8) {
            this.getChildren().clear();
            this.id = id;
            this.image = new Image("/images/zombie.png");
        } else if (id == 9) {
            this.getChildren().clear();
            this.id = id;
            this.image = new Image("/images/tierra.png");
        } 
    }

    

}
