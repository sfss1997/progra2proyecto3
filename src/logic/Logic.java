/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import domain.Configuration;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

/**
 *
 * @author hvill
 */
public class Logic {

    public static Cell[][] cell;

    public static Configuration configuration = new Configuration();

    public Logic() {
        init();
    }

    private void init() {
        if (cell == null) {
            this.cell = new Cell[configuration.getHeight()][configuration.getWidth()];
        }
    }

    /**
     * Crea la matriz de cell.
     *
     * @param rows
     * @param columns
     * @param cell
     * @return Retorna el GridPane
     */
    public void createCell() {
        for (int i = 0; i < configuration.getHeight(); i++) {
            for (int j = 0; j < configuration.getWidth(); j++) {
                int random = (int) (Math.random() * 2);
                if (configuration.getType().equals("random")) {
                    if (i == configuration.getHeight() - 1) {
                        random = 2;
                    }
                    cell[i][j] = new Cell(random);
                    cell[i][j].setRow(i);
                    cell[i][j].setColumn(j);
                } else if (configuration.getType().equals("plane")) {
                    if (i != configuration.getHeight() - 1) {
                        cell[i][j] = new Cell(0);
                        cell[i][j].setRow(i);
                        cell[i][j].setColumn(j);
                    } else {
                        cell[i][j] = new Cell(2);
                        cell[i][j].setRow(i);
                        cell[i][j].setColumn(j);
                    }
                }
            }
        }
    }

}
