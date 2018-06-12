/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

/**
 *
 * @author fabian
 */
public class Configuration {
    
    private String saveFile;
    private int width;
    private int height;
    private String type;
    private ProbabilitiesConfiguration probabilities;
    private PlayerConfiguration player;
    private ChimeraConfiguration chimera;
    private ZombieConfiguration zombie;

    public Configuration() {
    }

    public Configuration(String saveFile, int width, int height, String type, ProbabilitiesConfiguration probabilities, PlayerConfiguration player, ChimeraConfiguration chimera, ZombieConfiguration zombie) {
        this.saveFile = saveFile;
        this.width = width;
        this.height = height;
        this.type = type;
        this.probabilities = probabilities;
        this.player = player;
        this.chimera = chimera;
        this.zombie = zombie;
    }

    public String getSaveFile() {
        return saveFile;
    }

    public void setSaveFile(String saveFile) {
        this.saveFile = saveFile;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public ProbabilitiesConfiguration getProbabilities() {
        return probabilities;
    }

    public void setProbabilities(ProbabilitiesConfiguration probabilities) {
        this.probabilities = probabilities;
    }

    public PlayerConfiguration getPlayer() {
        return player;
    }

    public void setPlayer(PlayerConfiguration player) {
        this.player = player;
    }

    public ChimeraConfiguration getChimera() {
        return chimera;
    }

    public void setChimera(ChimeraConfiguration chimera) {
        this.chimera = chimera;
    }

    public ZombieConfiguration getZombie() {
        return zombie;
    }

    public void setZombie(ZombieConfiguration zombie) {
        this.zombie = zombie;
    }

    @Override
    public String toString() {
        return "Configuration{" + "\nsaveFile=" + saveFile + ",\n width=" + width + ",\n height=" + height + ",\n type=" + type + ",\n probabilities=" + probabilities + ",\n player=" + player + ",\n chimera=" + chimera + ",\n zombie=" + zombie + '}';
    }
    
    
    
}
