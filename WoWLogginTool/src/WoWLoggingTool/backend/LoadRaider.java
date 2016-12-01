/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WoWLoggingTool.backend;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Daniel Johansen
 */
public class LoadRaider implements LoadFile<Raider> {
    String raiderName;
    
    @Override
    public ObservableList<Raider> loadObservableList(String fileToRead){
        ObservableList<Raider> listToReturn = FXCollections.observableArrayList();
        try {
            Boolean readyToCreateRaider = false;
            BufferedReader reader = new BufferedReader(new FileReader(fileToRead));
            while(reader.ready()){
                String evaluateString = reader.readLine();
                String[] stringArray = evaluateString.split("=");
                
                switch(stringArray[0]){
                    case "name":
                        raiderName = stringArray[stringArray.length-1];
                        readyToCreateRaider = true;
                        break;
                    default:
                        break;
                }
                if(readyToCreateRaider){
                    listToReturn.add(new Raider(raiderName));
                    readyToCreateRaider = false;
                }
                
            }
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LoadRaider.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LoadRaider.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listToReturn;
    }
}
