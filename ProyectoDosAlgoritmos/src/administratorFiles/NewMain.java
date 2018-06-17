/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administratorFiles;

import domain.Category;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author fabian
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        AdministratorFiles administratorFiles = new AdministratorFiles();
        ArrayList arrayList = new ArrayList();
        
        Category category0 = new Category(0, "Lacteo", "Leche");
        Category category1 = new Category(1, "Enlatado", "Atun");
        Category category2 = new Category(2, "Congelado", "Helado");
                        
        arrayList.add(category0);
        arrayList.add(category1);
        arrayList.add(category2);
        
        
        
       
        
    }
    
}
