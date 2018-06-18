/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administratorFiles;

import domain.Batch;
import domain.Category;
import domain.Cellar;
import domain.DistributionOrder;
import domain.Product;
import domain.TransportUnit;
import domain.User;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

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
        
        ArrayList<Batch> batchList = new ArrayList();
        ArrayList<Category> categoryList = new ArrayList();
        ArrayList<Cellar> cellarList = new ArrayList();
        ArrayList<DistributionOrder> distributionOrderList = new ArrayList();
        ArrayList<Product> productList = new ArrayList();
        ArrayList<TransportUnit> transportUnitList = new ArrayList();
        ArrayList<User> UserList = new ArrayList();
        
        Date date = new Date();
        Date date2 = new Date(2019, 2, 23, 0, 0, 0);
        
        Batch batch0 = new Batch(0, "IDRHFU45T45", date, date2);
        Batch batch1 = new Batch(1, "KJBFH45G54G", date, date2);
        Batch batch2 = new Batch(2, "EARGE56YHRT", date, date2);
        Batch batch3 = new Batch(3, "ERGRTERHRHT", date, date2);
        Batch batch4 = new Batch(4, "DFVKNSKJVNJ", date, date2);
        batchList.add(batch0);
        batchList.add(batch1);
        batchList.add(batch2);
        batchList.add(batch3);
        batchList.add(batch4);
        
        Category category0 = new Category(0, "Jardin", "Productos para el hogar");
        Category category1 = new Category(1, "Cuidado textil", "Productos de limpieza");
        Category category2 = new Category(2, "Larga duración", "Larga duración");
        Category category3 = new Category(3, "Refrescos", "Bebidas");
        Category category4 = new Category(4, "Alcohol", "Bebidas alcoholicas");
        categoryList.add(category0);
        categoryList.add(category1);
        categoryList.add(category2);
        categoryList.add(category3);
        categoryList.add(category4);
        
        Cellar cellar0 = new Cellar(0, "Paraiso", "latitude", "length", 6, "url");
        Cellar cellar1 = new Cellar(1, "Cartago", "latitude", "length", 7, "url");
        Cellar cellar2 = new Cellar(2, "Tres Rios", "latitude", "length", 8, "url");
        Cellar cellar3 = new Cellar(3, "Lima", "latitude", "length", 9, "url");
        Cellar cellar4 = new Cellar(4, "Tejar", "latitude", "length", 10, "url");
        cellarList.add(cellar0);
        cellarList.add(cellar1);
        cellarList.add(cellar2);
        cellarList.add(cellar3);
        cellarList.add(cellar4);
        
        Product product0 = new Product(0, "Parillas", "Unidades", 20, 1, "Parrillas jardin", 0, 0, 0, "url");
        Product product1 = new Product(1, "Jabon", "Paquetes", 100, 5, "Jabon en polvo", 1, 1, 0, "");
        Product product2 = new Product(2, "Sopa", "Cajas", 10, 1, "Alimento en polvo", 2, 2, 0, "");
        Product product3 = new Product(3, "Gaseosas", "Tarimas", 15, 20, "Refresco gaseoso", 3, 3, 0, "");
        Product product4 = new Product(4, "Cervezas", "Tarimas", 10, 30, "Bebida alcoholica", 4, 4, 0, "");
        productList.add(product0);
        productList.add(product1);
        productList.add(product2);
        productList.add(product3);
        productList.add(product4);
        
        DistributionOrder distributionOrder0 = new DistributionOrder(0, 0, 1, 100000, 5000, productList, 0);
        DistributionOrder distributionOrder1 = new DistributionOrder(1, 1, 2, 200000, 10000, productList, 1);
        DistributionOrder distributionOrder2 = new DistributionOrder(2, 2, 3, 300000, 60000, productList, 2);
        DistributionOrder distributionOrder3 = new DistributionOrder(3, 3, 4, 400000, 70000, productList, 3);
        DistributionOrder distributionOrder4 = new DistributionOrder(4, 4, 0, 500000, 90000, productList, 4);
        distributionOrderList.add(distributionOrder0);
        distributionOrderList.add(distributionOrder1);
        distributionOrderList.add(distributionOrder2);
        distributionOrderList.add(distributionOrder3);
        distributionOrderList.add(distributionOrder4);
        
        TransportUnit transportUnit0 = new TransportUnit(0, "646644", 10,20, "url");
        TransportUnit transportUnit1 = new TransportUnit(1, "754532", 20,30, "url");
        TransportUnit transportUnit2 = new TransportUnit(2, "768923", 5,10, "url");
        TransportUnit transportUnit3 = new TransportUnit(3, "856326", 10,15, "url");
        TransportUnit transportUnit4 = new TransportUnit(4, "853467", 15,20, "url");
        transportUnitList.add(transportUnit0);
        transportUnitList.add(transportUnit1);
        transportUnitList.add(transportUnit2);
        transportUnitList.add(transportUnit3);
        transportUnitList.add(transportUnit4);
        
        User user0 = new User(0, "Nikol", "Administrador", "Nicky", "1234");
        User user1 = new User(1, "Guilberth", "Operador", "Willy", "1234");
        User user2 = new User(2, "Sergio Siles", "Operador", "sfss1997", "1234");
        User user3 = new User(3, "Elva Surita", "Operador", "EV", "1234");
        User user4 = new User(4, "Allan Brito", "Operador", "Nalla", "1234");
        UserList.add(user0);
        UserList.add(user1);
        UserList.add(user2);
        UserList.add(user3);
        UserList.add(user4);
        
                
        administratorFiles.writeBatchFile(batchList);
        administratorFiles.writeCategoryFile(categoryList);
        administratorFiles.writeCellarFile(cellarList);
        administratorFiles.writeDistributionOrderFile(distributionOrderList);
        administratorFiles.writeProductFile(productList);
        administratorFiles.writeTransportUnitFile(transportUnitList);
        administratorFiles.writeUserFile(UserList);
        
                
        
        
        
        
       
        
    }
    
}
