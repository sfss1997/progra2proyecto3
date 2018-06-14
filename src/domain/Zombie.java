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
public class Zombie {

    private Logic logic; 
    private int zombieRow;
    private int zombieColumn;

    public Zombie() {
        this.logic = new Logic();
        findEarth();
    }
    
    public void zombieUp() {
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdAndImage(0);
        if (this.zombieRow > 0 && this.logic.cell[this.zombieRow-1][this.zombieColumn].getID() == 0) {
            this.zombieRow--;
        }
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdAndImage(8);
    }

    public void zombieDown() {
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdAndImage(0);
        if (zombieRow < this.logic.cell.length-1 && this.logic.cell[this.zombieRow+1][this.zombieColumn].getID() == 0) {
            this.zombieRow++;
        }
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdAndImage(8);
    }

    public void zombieLeft() {
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdAndImage(0);
        if (this.zombieColumn > 0 && this.logic.cell[this.zombieRow][this.zombieColumn-1].getID() == 0
                && isEarthLeft() == true) {
            this.zombieColumn--;
        }
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdAndImage(8);
    }

    public void zombieRight() {
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdAndImage(0);
        if (zombieColumn < this.logic.cell[0].length-1 && this.logic.cell[this.zombieRow][this.zombieColumn+1].getID() == 0
                && isEarthRight() == true) {
            this.zombieColumn++;
        }
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdAndImage(8);
    }
    
    /////////////////////////////////////////////////////////////////////////////////////////////
    private boolean isEarthLeft() {
        if (this.logic.cell[this.zombieRow + 1][this.zombieColumn - 1].getID() == 9
                || this.logic.cell[this.zombieRow + 1][this.zombieColumn - 1].getID() == 10) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEarthRight() {
        if (this.logic.cell[this.zombieRow + 1][this.zombieColumn + 1].getID() == 9
                || this.logic.cell[this.zombieRow + 1][this.zombieColumn + 1].getID() == 10) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEarthDown(int row, int column) {
        if (row + 1 < this.logic.cell.length) {
            if ((this.logic.cell[row + 1][column].getID() == 9 || this.logic.cell[row + 1][column].getID() == 10)
                    && this.logic.cell[row][column].getID() == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    

    private void findEarth() {
        for (int i = 0; i < this.logic.cell.length; i++) {
            for (int j = 0; j < this.logic.cell[0].length; j++) {
                if (isEarthDown(i, j) == true) {
                    this.zombieRow = i;
                    this.zombieColumn = j;
                    this.logic.cell[zombieRow][zombieColumn].setIdAndImage(8);

                    i = this.logic.cell.length;
                    j = this.logic.cell[0].length;
                }
            }
        }
    }
    
}
