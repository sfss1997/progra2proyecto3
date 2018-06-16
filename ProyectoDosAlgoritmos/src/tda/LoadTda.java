
package tda;

import domain.Batch;
import domain.Category;
import domain.DistributionOrder;
import domain.TransportUnit;
import domain.User;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Clase para cargar la información de los archivos a las estructuras de datos.
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class LoadTda {
    
    //Producto mayorista árbol binario
    public static Map<String, Category> categoryMap = new HashMap<>();
    public static Map<Integer, Batch> batchMap = new TreeMap<>();
    public static Map<Integer, TransportUnit> transportUnitMap = new LinkedHashMap<>();
    //Bodega, grafo con matriz de adyacencia
    public static LinkedList<DistributionOrder> distributionOrderList = new LinkedList<>();
    public static LinkedList<User> userList = new LinkedList<>();
    
    public void tda() {
        
    }
}
