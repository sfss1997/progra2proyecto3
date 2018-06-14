/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.util.logging.Level;
import java.util.logging.Logger;
import logic.Logic;

/**
 *
 * @author fabian
 */
public class Chimera {

    private Logic logic;
    private int chimeraRow;
    private int chimeraColumn;

    public Chimera(int chimeraRow, int chimeraColumn) {
        this.logic = new Logic();
        this.chimeraRow = chimeraRow;
        this.chimeraColumn = chimeraColumn;
        this.logic.cell[chimeraRow][chimeraColumn].setIdAndImage(8);
    }

    public void run() {
        this.logic.cell[chimeraRow][chimeraColumn].setIdAndImage(8);
        int random;
        while (true) {
            random = (int) (Math.random() * 3);
            if (random == 0) {
                chimeraUp();
            } else if (random == 1) {
                chimeraDown();
            } else if (random == 2) {
                chimeraLeft();
            } else if (random == 3) {
                chimeraRight();
            }
            try {
                this.wait(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Chimera.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    public void chimeraUp() {
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdAndImage(1);
        if (this.chimeraRow > 0 && this.logic.cell[this.chimeraRow - 1][this.chimeraColumn].getID() == 1) {
            this.chimeraRow--;
        }
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdAndImage(3);
    }

    public void chimeraDown() {
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdAndImage(1);
        if (chimeraRow < this.logic.cell.length - 1 && this.logic.cell[this.chimeraRow + 1][this.chimeraColumn].getID() == 1) {
            this.chimeraRow++;
        }
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdAndImage(3);
    }

    public void chimeraLeft() {
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdAndImage(1);
        if (this.chimeraColumn > 0 && this.logic.cell[this.chimeraRow][this.chimeraColumn - 1].getID() == 1) {
            this.chimeraColumn--;
        }
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdAndImage(3);
    }

    public void chimeraRight() {
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdAndImage(1);
        if (chimeraColumn < this.logic.cell[0].length - 1 && this.logic.cell[this.chimeraRow][this.chimeraColumn + 1].getID() == 1) {
            this.chimeraColumn++;
        }
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdAndImage(3);
    }

}

