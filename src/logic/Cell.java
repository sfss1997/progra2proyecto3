/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javax.xml.parsers.ParserConfigurationException;

/**
 *
 * @author hvill
 */
public class Cell extends Pane {

    private ImageView imageView;
    private int id;
    private int row;
    private int column;

    public Cell() {
        setStyle("-fx-border-color : black");
        this.setPrefSize(100, 100);
        this.imageView = new ImageView("/images/tierra.png");
        this.getChildren().add(imageView);
        this.id = 1;
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

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
        this.getChildren().clear();
        this.getChildren().add(this.imageView);
    }

    public int getID() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setIdAndImageView(int id) {
//        if (id == 0) {
//            this.id = 0;
//            this.getChildren().clear();
//        } else if (id == 1) {
//            this.id = id;
//            this.getChildren().clear();
//            this.imageView = new ImageView("/Images/fondonegro.png");
//            this.getChildren().add(imageView);
//        } else if (id == 2) {
//            this.id = id;
//            this.getChildren().clear();
//            this.imageView = new ImageView("/Images/right2.gif");
//            this.getChildren().add(imageView);
//        } else if (id == 3) {
//            this.id = id;
//            this.getChildren().clear();
//            this.imageView = new ImageView("/Images/ghost.gif");
//            this.getChildren().add(imageView);
//        }
    }

}
