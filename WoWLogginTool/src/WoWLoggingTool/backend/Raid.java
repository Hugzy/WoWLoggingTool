/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WoWLoggingTool.backend;

import javafx.collections.ObservableList;

/**
 *
 * @author Daniel Johansen
 */
public class Raid {
    
    private final String name;
    private final ObservableList<RaidBoss> bossList;
       
    public Raid(String name,ObservableList<RaidBoss> bossList ){
        this.name = name;
        this.bossList = bossList;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @return the bossList
     */
    public ObservableList<RaidBoss> getBossList() {
        return bossList;
    }
}
