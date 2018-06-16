/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

/**
 *
 * @author fabian
 */
public class Live  extends Pane{
    private Image image;
    private int id;


    public Live() {
        this.setPrefSize(20, 20);
        this.setIdAndImage(1);
        this.setId(1);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getID() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    
     public void setIdAndImage(int id) {
        if (id == 0) {
            this.id = id;
            this.image = new Image("/images/gris.png");
        } else if (id == 1) {
            this.id = id;
            this.image = new Image("/images/rojo.png");
        }
    }
}
