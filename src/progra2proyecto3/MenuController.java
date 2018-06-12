/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package progra2proyecto3;


import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import static logic.Logic.configuration;

import javafx.stage.Stage;
import logic.ReadFiles;
import org.json.simple.parser.ParseException;

/**
 *
 * @author fabian
 */
public class MenuController implements Initializable {
    
   public  String file ="";
    ReadFiles readFiles= new ReadFiles();

    
    
    @FXML
    private void StartButton(ActionEvent event) throws IOException, ParseException {
//        System.out.println(readFiles.readJsonFiles(difficultyComboBox.getValue().toString()));
        cambioScene(event, "/progra2proyecto3/FXMLDocument.fxml");
        
        
       
    }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        
        
            System.out.println("Ingrese la URL del archivo");
            
            Scanner entradaEscaner = new Scanner (System.in); //CreaciÃ³n de un objeto Scanner

       
            String file  = entradaEscaner.nextLine ();
                    
      
       try {
           configuration = readFiles.readJsonFiles(file);
       } catch (IOException ex) {
           Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
       } catch (ParseException ex) {
           Logger.getLogger(MenuController.class.getName()).log(Level.SEVERE, null, ex);
       }
       

    }
    
        
    private void cambioScene(ActionEvent event, String destino) throws IOException{
        Parent tableViewParent = FXMLLoader.load(getClass().getResource(destino));
        Scene tableViewScene = new Scene(tableViewParent);
        
        //Esta linea obtiene la informacion del Stage
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        
        window.setScene(tableViewScene);
        window.setResizable(false);
        window.show();
    }
    
}
