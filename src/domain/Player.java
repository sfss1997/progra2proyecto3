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
import logic.PlayerWay;

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
    private static PlayerWay way;
    private static int weapon;

    public Player(int playerRow, int playerColumn) {
        this.logic = new Logic();
        this.playerRow = playerRow;
        this.playerColumn = playerColumn;
        this.logic.cell[playerRow][playerColumn].setIdAndImage(2);
        this.way = PlayerWay.LEFT;
        this.weapon = 1;
    }

    public void changeWeapons(int i) {
        PlayerWay playerWay = this.logic.cell[playerRow][playerColumn].getPlayerWay();
        if (i == 1 && playerWay == playerWay.RIGHT) {
            this.weapon = 1;
            this.way = PlayerWay.RIGHT;
            this.logic.cell[playerRow][playerColumn].setIdAndImage(1);
        } else if (i == 1 && playerWay == playerWay.LEFT) {
            this.weapon = 1;
            this.way = PlayerWay.LEFT;
            this.logic.cell[playerRow][playerColumn].setIdAndImage(2);
        } else if (i == 2 && playerWay == playerWay.RIGHT) {
            this.weapon = 2;
            this.way = PlayerWay.RIGHT;
            this.logic.cell[playerRow][playerColumn].setIdAndImage(3);
        } else if (i == 2 && playerWay == playerWay.LEFT) {
            this.weapon = 2;
            this.way = PlayerWay.LEFT;
            this.logic.cell[playerRow][playerColumn].setIdAndImage(4);
        } else if (i == 3 && playerWay == playerWay.RIGHT) {
            this.weapon = 3;
            this.way = PlayerWay.RIGHT;
            this.logic.cell[playerRow][playerColumn].setIdAndImage(5);
        } else if (i == 3 && playerWay == playerWay.LEFT) {
            this.weapon = 3;
            this.way = PlayerWay.LEFT;
            this.logic.cell[playerRow][playerColumn].setIdAndImage(6);
        }
    }
    
    private void playerWay(int weapon, PlayerWay way){
        switch(weapon){
            case 1:
                if(way == PlayerWay.RIGHT){
                    this.logic.cell[this.playerRow][this.playerColumn].setIdAndImage(1);
                } else if (way == PlayerWay.LEFT){
                    this.logic.cell[this.playerRow][this.playerColumn].setIdAndImage(2);
                }
                break;
            case 2:
                if(way == PlayerWay.RIGHT){
                    this.logic.cell[this.playerRow][this.playerColumn].setIdAndImage(3);
                } else if (way == PlayerWay.LEFT){
                    this.logic.cell[this.playerRow][this.playerColumn].setIdAndImage(4);
                }
            case 3:
                if(way == PlayerWay.RIGHT){
                    this.logic.cell[this.playerRow][this.playerColumn].setIdAndImage(5);
                } else if (way == PlayerWay.LEFT){
                    this.logic.cell[this.playerRow][this.playerColumn].setIdAndImage(6);
                }
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////
    
    public void playerUp() {
        this.logic.cell[this.playerRow][this.playerColumn].setIdAndImage(0);
        if (this.playerRow > 0 && this.logic.cell[this.playerRow - 1][this.playerColumn].getID() == 0) {
            this.playerRow--;
        }
        playerWay(this.weapon, this.way);
    }

    public void playerDown() {
        this.logic.cell[this.playerRow][this.playerColumn].setIdAndImage(0);
        if (playerRow < this.logic.cell.length - 1 && this.logic.cell[this.playerRow + 1][this.playerColumn].getID() == 0) {
            this.playerRow++;
        }
        playerWay(this.weapon, this.way);
    }

    public void playerLeft() {
        this.logic.cell[this.playerRow][this.playerColumn].setIdAndImage(0);
        if (this.playerColumn > 0 && this.logic.cell[this.playerRow][this.playerColumn - 1].getID() == 0) {
            this.playerColumn--;
        }
        playerWay(this.weapon, PlayerWay.LEFT);
    }

    public void playerRight() {
        this.logic.cell[this.playerRow][this.playerColumn].setIdAndImage(0);
        if (playerColumn < this.logic.cell[0].length - 1 && this.logic.cell[this.playerRow][this.playerColumn + 1].getID() == 0) {
            this.playerColumn++;
        }
        playerWay(this.weapon, PlayerWay.RIGHT);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////

    public void removeEarthUp() {
        int idPlayer = this.logic.cell[this.playerRow][this.playerColumn].getID();
        if (this.playerRow > 0 && this.logic.cell[this.playerRow - 1][this.playerColumn].getID() == 9 
                && (idPlayer == 5 || idPlayer ==6)) {
            this.logic.cell[this.playerRow - 1][this.playerColumn].setIdAndImage(0);
        }
    }

    public void removeEarthDown() {
        int idPlayer = this.logic.cell[this.playerRow][this.playerColumn].getID();
        if (playerRow < this.logic.cell.length - 1 && this.logic.cell[this.playerRow + 1][this.playerColumn].getID() == 9
                && (idPlayer == 5 || idPlayer ==6)) {
            this.logic.cell[this.playerRow + 1][this.playerColumn].setIdAndImage(0);
        }
    }

    public void removeEarthLeft() {
        int idPlayer = this.logic.cell[this.playerRow][this.playerColumn].getID();
        if (this.playerColumn > 0 && this.logic.cell[this.playerRow][this.playerColumn - 1].getID() == 9
                && (idPlayer == 5 || idPlayer ==6)) {
            this.logic.cell[this.playerRow][this.playerColumn - 1].setIdAndImage(0);
        }
    }

    public void removeEarthRight() {
        int idPlayer = this.logic.cell[this.playerRow][this.playerColumn].getID();
        if (playerColumn < this.logic.cell[0].length - 1 && this.logic.cell[this.playerRow][this.playerColumn + 1].getID() == 9
                && (idPlayer == 5 || idPlayer ==6)) {
            this.logic.cell[this.playerRow][this.playerColumn + 1].setIdAndImage(0);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    
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
