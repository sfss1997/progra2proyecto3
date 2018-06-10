/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

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

    private Image imageView;
    private int id;
    private int row;
    private int column;

    public Cell() {
        setStyle("-fx-border-color : black");
        this.setPrefSize(100, 100);
        this.imageView = new Image("/images/tierra.png");
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

    public Image getImageView() {
        return imageView;
    }

    public void setImageView(Image imageView) {
        this.imageView = imageView;
    }

    public int getID() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

}
