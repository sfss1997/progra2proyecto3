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
    private static int idThread;

    public Chimera(int idThread) {
        this.logic = new Logic();
        this.idThread = idThread;
        findEarth();

    }

    public void chimeraUp() {
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdAndImage(0);
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdThread(-1);
        if (this.chimeraRow > 0 && this.logic.cell[this.chimeraRow - 1][this.chimeraColumn].getID() == 0) {
            this.chimeraRow--;
        }
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdAndImage(7);
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdThread(idThread);
    }

    public void chimeraDown() {
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdAndImage(0);
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdThread(-1);
        if (chimeraRow < this.logic.cell.length - 1 && this.logic.cell[this.chimeraRow + 1][this.chimeraColumn].getID() == 0) {
            this.chimeraRow++;
        }
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdAndImage(7);
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdThread(idThread);
    }

    public void chimeraLeft() {
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdAndImage(0);
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdThread(-1);
        if (this.chimeraColumn > 0 && this.logic.cell[this.chimeraRow][this.chimeraColumn - 1].getID() == 0 /*&& isEarthLeft() == true*/) {
            this.chimeraColumn--;
            if (this.logic.cell[this.chimeraRow + 1][this.chimeraColumn].getID() != 7
                    || this.logic.cell[this.chimeraRow + 1][this.chimeraColumn].getID() != 8) {
                while (isEarthDown(this.chimeraRow, this.chimeraColumn) == false) {
                    this.chimeraRow++;
                }
            }
        }
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdAndImage(7);
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdThread(idThread);
    }

    public void chimeraRight() {
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdAndImage(0);
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdThread(-1);
        if (chimeraColumn < this.logic.cell[0].length - 1 && this.logic.cell[this.chimeraRow][this.chimeraColumn + 1].getID() == 0 /*&& isEarthRight() == true*/) {
            this.chimeraColumn++;        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdThread(idThread);

            if (this.logic.cell[this.chimeraRow + 1][this.chimeraColumn].getID() != 7
                    || this.logic.cell[this.chimeraRow + 1][this.chimeraColumn].getID() != 8) {
                while (isEarthDown(this.chimeraRow, this.chimeraColumn) == false) {
                    this.chimeraRow++;
                }
            }
        }
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdAndImage(7);
        this.logic.cell[this.chimeraRow][this.chimeraColumn].setIdThread(idThread);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    private boolean isEarthLeft() {
        if (this.logic.cell[this.chimeraRow + 1][this.chimeraColumn - 1].getID() == 9
                || this.logic.cell[this.chimeraRow + 1][this.chimeraColumn - 1].getID() == 10) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isEarthRight() {
        if (this.logic.cell[this.chimeraRow + 1][this.chimeraColumn + 1].getID() == 9
                || this.logic.cell[this.chimeraRow + 1][this.chimeraColumn + 1].getID() == 10) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isEarthDown(int row, int column) {
        if (row + 1 < this.logic.cell.length) {
            if (this.logic.cell[row][column].getID() == 0) {
                if ((this.logic.cell[row + 1][column].getID() == 9 || this.logic.cell[row + 1][column].getID() == 10)
                        && this.logic.cell[row][column].getID() == 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return true;
            }

        } else {
            return false;
        }
    }

    private void findEarth() {
        while (true) {
            int randomRow = (int) (Math.random() * this.logic.cell.length);
            int randomColumn = (int) (Math.random() * this.logic.cell[0].length);

            if (isEarthDown(randomRow, randomColumn) == true) {

                this.chimeraRow = randomRow;
                this.chimeraColumn = randomColumn;
                this.logic.cell[chimeraRow][chimeraColumn].setIdAndImage(7);
                this.logic.cell[chimeraRow][chimeraColumn].setIdThread(idThread);
                randomRow = this.logic.cell.length;
                randomColumn = this.logic.cell[0].length;
                break;
            }
        }
    }

}
