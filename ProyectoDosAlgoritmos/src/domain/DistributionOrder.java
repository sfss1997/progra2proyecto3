
package domain;

import java.util.LinkedList;

/**
 *
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class DistributionOrder {
    
    private int idDistributionOrder;
    private int idOriginCellar;
    private int idDestinyCellar;
    private double totalAmount;
    private float weightTotal;
    private LinkedList<Product> productList;
    private int idOperator;

    public DistributionOrder() {
    }

    public DistributionOrder(int idDistributionOrder, int idOriginCellar, int idDestinyCellar, double totalAmount, float weightTotal, LinkedList<Product> productList, int idOperator) {
        this.idDistributionOrder = idDistributionOrder;
        this.idOriginCellar = idOriginCellar;
        this.idDestinyCellar = idDestinyCellar;
        this.totalAmount = totalAmount;
        this.weightTotal = weightTotal;
        this.productList = productList;
        this.idOperator = idOperator;
    }

    /**
     * @return the idDistributionOrder
     */
    public int getIdDistributionOrder() {
        return idDistributionOrder;
    }

    /**
     * @param idDistributionOrder the idDistributionOrder to set
     */
    public void setIdDistributionOrder(int idDistributionOrder) {
        this.idDistributionOrder = idDistributionOrder;
    }

    /**
     * @return the idOriginCellar
     */
    public int getIdOriginCellar() {
        return idOriginCellar;
    }

    /**
     * @param idOriginCellar the idOriginCellar to set
     */
    public void setIdOriginCellar(int idOriginCellar) {
        this.idOriginCellar = idOriginCellar;
    }

    /**
     * @return the idDestinyCellar
     */
    public int getIdDestinyCellar() {
        return idDestinyCellar;
    }

    /**
     * @param idDestinyCellar the idDestinyCellar to set
     */
    public void setIdDestinyCellar(int idDestinyCellar) {
        this.idDestinyCellar = idDestinyCellar;
    }

    /**
     * @return the totalAmount
     */
    public double getTotalAmount() {
        return totalAmount;
    }

    /**
     * @param totalAmount the totalAmount to set
     */
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    /**
     * @return the weightTotal
     */
    public float getWeightTotal() {
        return weightTotal;
    }

    /**
     * @param weightTotal the weightTotal to set
     */
    public void setWeightTotal(float weightTotal) {
        this.weightTotal = weightTotal;
    }

    /**
     * @return the productList
     */
    public LinkedList<Product> getProductList() {
        return productList;
    }

    /**
     * @param productList the productList to set
     */
    public void setProductList(LinkedList<Product> productList) {
        this.productList = productList;
    }

    /**
     * @return the idOperator
     */
    public int getIdOperator() {
        return idOperator;
    }

    /**
     * @param idOperator the idOperator to set
     */
    public void setIdOperator(int idOperator) {
        this.idOperator = idOperator;
    }

    @Override
    public String toString() {
        return "DistributionOrder{" + "idDistributionOrder=" + idDistributionOrder + ", idOriginCellar=" + idOriginCellar + ", idDestinyCellar=" + idDestinyCellar + ", totalAmount=" + totalAmount + ", weightTotal=" + weightTotal + ", productList=" + productList + ", idOperator=" + idOperator + '}';
    }
    
    
}
