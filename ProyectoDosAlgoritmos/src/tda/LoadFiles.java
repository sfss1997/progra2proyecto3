
package tda;

import administratorFiles.AdministratorFiles;
import domain.Category;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import static tda.LoadTda.categoryMap;

/**
 * Clase para cargar la información de las estructuras de datos a los archivos.
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class LoadFiles {
    
    AdministratorFiles administratorFiles = new AdministratorFiles();
    
    public void fileCategory() throws IOException {
        ArrayList<Category> arrayList = new ArrayList<>();
        Iterator iterator = categoryMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            arrayList.add(categoryMap.get(key));
        }
        administratorFiles.writeCategoryFile(arrayList);
    }
    
    public void file() throws IOException {
        ArrayList<Category> arrayList = new ArrayList<>();
        Iterator iterator = categoryMap.keySet().iterator();
        while (iterator.hasNext()) {
            String key = (String) iterator.next();
            arrayList.add(categoryMap.get(key));
        }
        administratorFiles.writeCategoryFile(arrayList);
    }
   
}
