
package administratorFiles;

import domain.Batch;
import domain.Category;
import domain.Cellar;
import domain.DistributionOrder;
import domain.Product;
import domain.TransportUnit;
import domain.User;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Clase para leer la información de los archivos.
 * @author Nicole Fonseca, Wilmer Mata, Sergio Siles
 */
public class AdministratorFiles implements java.io.Serializable{
    
    public void writeBatchFile(ArrayList<Batch> arrayList) throws FileNotFoundException, IOException{ 
      ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("Batch.txt"));
      salida.writeObject(arrayList);
      salida.close();
    }
    public ArrayList<Batch> readBatchFile() throws FileNotFoundException, IOException, ClassNotFoundException{
      ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("Batch.txt"));
      ArrayList<Batch> arrayList = (ArrayList<Batch>)entrada.readObject();
      return arrayList;
    }
    
    
    public void writeCategoryFile(ArrayList<Category> arrayList) throws FileNotFoundException, IOException{
      ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("Category.txt"));
      salida.writeObject(arrayList);
      salida.close();
    }
    public ArrayList<Category> readCategoryFile() throws FileNotFoundException, IOException, ClassNotFoundException{
      ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("Category.txt"));
      ArrayList<Category> arrayList = (ArrayList<Category>)entrada.readObject();
      return arrayList;
    }
    
    
    public void writeCellarFile(ArrayList<Cellar> arrayList) throws FileNotFoundException, IOException{   
      ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("Cellar.txt"));
      salida.writeObject(arrayList);
      salida.close();
    }
    public ArrayList<Cellar> readCellarFile() throws FileNotFoundException, IOException, ClassNotFoundException{   
      ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("Cellar.txt"));
      ArrayList<Cellar> arrayList = (ArrayList<Cellar>)entrada.readObject();
      return arrayList;
    }
    
    
    public void writeDistributionOrderFile(ArrayList<DistributionOrder> arrayList) throws FileNotFoundException, IOException{
      ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("DistributionOrder.txt"));
      salida.writeObject(arrayList);
      salida.close();
    }
    public ArrayList<DistributionOrder> readFile() throws FileNotFoundException, IOException, ClassNotFoundException{
      ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("DistributionOrder.txt"));
      ArrayList<DistributionOrder> arrayList = (ArrayList<DistributionOrder>)entrada.readObject();
      return arrayList;
    }
    
    
    public void writeProductFile(ArrayList<Product> arrayList) throws FileNotFoundException, IOException{   
      ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("Product.txt"));
      salida.writeObject(arrayList);
      salida.close();
    }
    public ArrayList<Product> readProductFile() throws FileNotFoundException, IOException, ClassNotFoundException{ 
      ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("Product.txt"));
      ArrayList<Product> arrayList = (ArrayList<Product>)entrada.readObject();
      return arrayList;
    }
    
    
    public void writeTransportUnitFile(ArrayList<TransportUnit> arrayList) throws FileNotFoundException, IOException{
  
      ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("TransportUnit.txt"));
      salida.writeObject(arrayList);
      salida.close();
    }
    public ArrayList<TransportUnit> readTransportUnitFile() throws FileNotFoundException, IOException, ClassNotFoundException{  
      ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("TransportUnit.txt"));
      ArrayList<TransportUnit> arrayList = (ArrayList<TransportUnit>)entrada.readObject();
      return arrayList;
    }
    
    
    public void writeUserFile(ArrayList<User> arrayList) throws FileNotFoundException, IOException{  
      ObjectOutputStream salida=new ObjectOutputStream(new FileOutputStream("User.txt"));
      salida.writeObject(arrayList);
      salida.close();
    }
    public ArrayList<User> readUserFile() throws FileNotFoundException, IOException, ClassNotFoundException{    
      ObjectInputStream entrada=new ObjectInputStream(new FileInputStream("User.txt"));
      ArrayList<User> arrayList = (ArrayList<User>)entrada.readObject();
      return arrayList;
    }
}
