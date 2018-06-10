/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import javafx.animation.PathTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Line;
import javafx.util.Duration;
import logic.Logic;

/**
 *
 * @author fabian
 */
public class Player {

    private Logic logic;
    private int playerRow;
    private int playerColumn;
    private int visionRange;
    private int defense;
    private int shortAttack;
    private int LongAttack;
    private float delay;
    private int range;

    public Player(int playerRow, int playerColumn) {
        this.logic = new Logic();
        this.playerRow = playerRow;
        this.playerColumn = playerColumn;
        this.logic.cell[playerRow][playerColumn].setIdAndImageView(2);
    }

    public void playerUp() {
        this.logic.cell[this.playerRow][this.playerColumn].setIdAndImageView(1);
        if (this.playerRow > 0 && this.logic.cell[this.playerRow - 1][this.playerColumn].getID() == 1) {
            this.playerRow--;
        }
        this.logic.cell[this.playerRow][this.playerColumn].setIdAndImageView(2);
    }

    public void playerDown() {
        this.logic.cell[this.playerRow][this.playerColumn].setIdAndImageView(1);
        if (playerRow < this.logic.cell.length - 1 && this.logic.cell[this.playerRow + 1][this.playerColumn].getID() == 1) {
            this.playerRow++;
        }
        this.logic.cell[this.playerRow][this.playerColumn].setIdAndImageView(2);
    }

    public void playerLeft() {
        this.logic.cell[this.playerRow][this.playerColumn].setIdAndImageView(1);
        if (this.playerColumn > 0 && this.logic.cell[this.playerRow][this.playerColumn - 1].getID() == 1) {
            this.playerColumn--;
        }
        this.logic.cell[this.playerRow][this.playerColumn].setIdAndImageView(2);
    }

    public void playerRight() {
        this.logic.cell[this.playerRow][this.playerColumn].setIdAndImageView(1);
        if (playerColumn < this.logic.cell[0].length - 1 && this.logic.cell[this.playerRow][this.playerColumn + 1].getID() == 1) {
            this.playerColumn++;
        }
        this.logic.cell[this.playerRow][this.playerColumn].setIdAndImageView(2);
    }

    public void removeEarthUp() {
        if (this.playerRow > 0 && this.logic.cell[this.playerRow - 1][this.playerColumn].getID() == 1) {
            this.logic.cell[this.playerRow - 1][this.playerColumn].setIdAndImageView(0);
        }
    }

    public void removeEarthDown() {
        if (playerRow < this.logic.cell.length - 1 && this.logic.cell[this.playerRow + 1][this.playerColumn].getID() == 1) {
            this.logic.cell[this.playerRow + 1][this.playerColumn].setIdAndImageView(0);
        }
    }

    public void removeEarthLeft() {
        if (this.playerColumn > 0 && this.logic.cell[this.playerRow][this.playerColumn - 1].getID() == 1) {
            this.logic.cell[this.playerRow][this.playerColumn - 1].setIdAndImageView(0);
        }
    }

    public void removeEarthRight() {
        if (playerColumn < this.logic.cell[0].length - 1 && this.logic.cell[this.playerRow][this.playerColumn + 1].getID() == 1) {
            this.logic.cell[this.playerRow][this.playerColumn + 1].setIdAndImageView(0);
        }
    }

    public int getPlayerRow() {
        return playerRow;
    }

    public void setPlayerRow(int playerRow) {
        this.playerRow = playerRow;
    }

    public int getPlayerColumn() {
        return playerColumn;
    }

    public void setPlayerColumn(int playerColumn) {
        this.playerColumn = playerColumn;
    }

    public int getVisionRange() {
        return visionRange;
    }

    public void setVisionRange(int visionRange) {
        this.visionRange = visionRange;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getShortAttack() {
        return shortAttack;
    }

    public void setShortAttack(int shortAttack) {
        this.shortAttack = shortAttack;
    }

    public int getLongAttack() {
        return LongAttack;
    }

    public void setLongAttack(int LongAttack) {
        this.LongAttack = LongAttack;
    }

    public float getDelay() {
        return delay;
    }

    public void setDelay(float delay) {
        this.delay = delay;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    @Override
    public String toString() {
        return "Player{" + "visionRange=" + visionRange + ", defense=" + defense + ", shortAttack=" + shortAttack + ", LongAttack=" + LongAttack + ", delay=" + delay + ", range=" + range + '}';
    }

}
