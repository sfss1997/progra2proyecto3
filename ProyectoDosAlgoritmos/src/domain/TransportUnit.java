
package domain;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class TransportUnit  implements java.io.Serializable{
    
    private int idTransportUnit;
    private String plate;
    private int minCapacity;
    private int maxCapacity;
    private String url;

    public TransportUnit() {
    }

    public TransportUnit(int idTransportUnit, String plate, int minCapacity, int maxCapacity, String url) {
        this.idTransportUnit = idTransportUnit;
        this.plate = plate;
        this.minCapacity = minCapacity;
        this.maxCapacity = maxCapacity;
        this.url = url;
    }

    public int getIdTransportUnit() {
        return idTransportUnit;
    }

    public void setIdTransportUnit(int idTransportUnit) {
        this.idTransportUnit = idTransportUnit;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public int getMinCapacity() {
        return minCapacity;
    }

    public void setMinCapacity(int minCapacity) {
        this.minCapacity = minCapacity;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "TransportUnit{" + "idTransportUnit=" + idTransportUnit + ", plate=" + plate + ", minCapacity=" + minCapacity + ", maxCapacity=" + maxCapacity + ", url=" + url + '}';
    }

   
}
