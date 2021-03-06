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
    private static int idThread;
    private int lives;
    

    public Zombie(int idThread) {
        this.logic = new Logic();
        this.idThread = idThread;
       
        findEarth();
        this.lives = 3;
//        this.logic.cell[this.zombieRow][this.zombieColumn].setLives() = this.lives;
    }

    public Zombie(int zombieRow, int zombieColumn) {
        this.logic = new Logic();
        this.zombieRow = zombieRow;
        this.zombieColumn = zombieColumn;
    }

    public int getIdThread() {
        return idThread;
    }

    public void setIdThread(int idThread) {
        this.idThread = idThread;
    }

    public void zombieUp() {
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdAndImage(0);
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdThread(-1);
        int lives = this.logic.cell[this.zombieRow][this.zombieColumn].getLives();
        this.logic.cell[this.zombieRow][this.zombieColumn].setLives(-1);
        if (this.zombieRow > 0 && this.logic.cell[this.zombieRow - 1][this.zombieColumn].getID() == 0) {
            this.zombieRow--;
        }
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdAndImage(8);
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdThread(idThread);
        this.logic.cell[this.zombieRow][this.zombieColumn].setLives(lives);
    }

    public void zombieDown() {
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdAndImage(0);
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdThread(-1);
        int lives = this.logic.cell[this.zombieRow][this.zombieColumn].getLives();
        this.logic.cell[this.zombieRow][this.zombieColumn].setLives(-1);
        if (zombieRow < this.logic.cell.length - 1 && this.logic.cell[this.zombieRow + 1][this.zombieColumn].getID() == 0) {
            this.zombieRow++;
        }
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdAndImage(8);
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdThread(idThread);
        this.logic.cell[this.zombieRow][this.zombieColumn].setLives(lives);
    }

    public void zombieLeft() {
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdAndImage(0);
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdThread(-1);
        int lives = this.logic.cell[this.zombieRow][this.zombieColumn].getLives();
        this.logic.cell[this.zombieRow][this.zombieColumn].setLives(-1);
        if (this.zombieColumn > 0 && this.logic.cell[this.zombieRow][this.zombieColumn - 1].getID() == 0 /*&& isEarthLeft() == true*/) {
            this.zombieColumn--;
            if (this.logic.cell[this.zombieRow + 1][this.zombieColumn].getID() != 7
                    || this.logic.cell[this.zombieRow + 1][this.zombieColumn].getID() != 8) {
                while (isEarthDown(this.zombieRow, this.zombieColumn) == false) {
                    this.zombieRow++;
                }
            }
        }
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdAndImage(8);
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdThread(idThread);
        this.logic.cell[this.zombieRow][this.zombieColumn].setLives(lives);
    }

    public void zombieRight() {
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdAndImage(0);
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdThread(-1);
        int lives = this.logic.cell[this.zombieRow][this.zombieColumn].getLives();
        this.logic.cell[this.zombieRow][this.zombieColumn].setLives(-1);
        if (zombieColumn < this.logic.cell[0].length - 1 && this.logic.cell[this.zombieRow][this.zombieColumn + 1].getID() == 0 /*&& isEarthRight() == true*/) {
            this.zombieColumn++;
            if (this.logic.cell[this.zombieRow + 1][this.zombieColumn].getID() != 7
                    || this.logic.cell[this.zombieRow + 1][this.zombieColumn].getID() != 8) {
                while (isEarthDown(this.zombieRow, this.zombieColumn) == false) {
                    this.zombieRow++;
                }
            }
        }
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdAndImage(8);
        this.logic.cell[this.zombieRow][this.zombieColumn].setIdThread(idThread);
        this.logic.cell[this.zombieRow][this.zombieColumn].setLives(lives);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    private boolean isEarthLeft() {
        if (zombieRow + 1 < this.logic.cell.length || zombieColumn + 1 < this.logic.cell[0].length) {
            if (this.logic.cell[this.zombieRow + 1][this.zombieColumn - 1].getID() == 9
                    || this.logic.cell[this.zombieRow + 1][this.zombieColumn - 1].getID() == 10) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private boolean isEarthRight() {
        if (zombieRow + 1 < this.logic.cell.length || zombieColumn + 1 < this.logic.cell[0].length) {
            if (this.logic.cell[this.zombieRow + 1][this.zombieColumn + 1].getID() == 9
                    || this.logic.cell[this.zombieRow + 1][this.zombieColumn + 1].getID() == 10) {
                return true;
           } else {
                return false;
            }
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
        while (true) {
            int randomRow = (int) (Math.random() * this.logic.cell.length);
            int randomColumn = (int) (Math.random() * this.logic.cell[0].length);

            if (isEarthDown(randomRow, randomColumn) == true) {

                this.zombieRow = randomRow;
                this.zombieColumn = randomColumn;
                this.logic.cell[zombieRow][zombieColumn].setIdAndImage(8);
                this.logic.cell[zombieRow][zombieColumn].setIdThread(idThread);
                randomRow = this.logic.cell.length;
                randomColumn = this.logic.cell[0].length;
                break;
            }
        }
    }

    
    
    

}
