
package domain;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class Cellar  implements java.io.Serializable {
    
    private int idCellar;
    private String name;
    private String latitude;
    private String length;
    private float distance;
    private String url;

    public Cellar() {
    }

    public Cellar(int idCellar, String name, String latitude, String length, float distance, String url) {
        this.idCellar = idCellar;
        this.name = name;
        this.latitude = latitude;
        this.length = length;
        this.distance = distance;
        this.url = url;
    }

    /**
     * @return the idCellar
     */
    public int getIdCellar() {
        return idCellar;
    }

    /**
     * @param idCellar the idCellar to set
     */
    public void setIdCellar(int idCellar) {
        this.idCellar = idCellar;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     * @param latitude the latitude to set
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    /**
     * @return the length
     */
    public String getLength() {
        return length;
    }

    /**
     * @param length the length to set
     */
    public void setLength(String length) {
        this.length = length;
    }

    /**
     * @return the distance
     */
    public float getDistance() {
        return distance;
    }

    /**
     * @param distance the distance to set
     */
    public void setDistance(float distance) {
        this.distance = distance;
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
        return "Cellar{" + "idCellar=" + idCellar + ", name=" + name + ", latitude=" + latitude + ", length=" + length + ", distance=" + distance + ", url=" + url + '}';
    }
    
    
}
