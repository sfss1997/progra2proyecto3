
package domain;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class TransportUnit  implements java.io.Serializable{
    
    private int idTransportUnit;
    private String plate;
    private String capacity;
    private String url;

    public TransportUnit() {
    }

    public TransportUnit(int idTransportUnit, String plate, String capacity, String url) {
        this.idTransportUnit = idTransportUnit;
        this.plate = plate;
        this.capacity = capacity;
        this.url = url;
    }

    /**
     * @return the idTransportUnit
     */
    public int getIdTransportUnit() {
        return idTransportUnit;
    }

    /**
     * @param idTransportUnit the idTransportUnit to set
     */
    public void setIdTransportUnit(int idTransportUnit) {
        this.idTransportUnit = idTransportUnit;
    }

    /**
     * @return the plate
     */
    public String getPlate() {
        return plate;
    }

    /**
     * @param plate the plate to set
     */
    public void setPlate(String plate) {
        this.plate = plate;
    }

    /**
     * @return the capacity
     */
    public String getCapacity() {
        return capacity;
    }

    /**
     * @param capacity the capacity to set
     */
    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "TransportUnit{" + "idTransportUnit=" + idTransportUnit + ", plate=" + plate + ", capacity=" + capacity + ", url=" + url + '}';
    }
    
}
