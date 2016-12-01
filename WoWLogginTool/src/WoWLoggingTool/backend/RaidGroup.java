/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WoWLoggingTool.backend;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Daniel Johansen
 */
public class RaidGroup {
    private ObservableList<Raider> raidGroup;
    private int raidGroupSize;
    
    
    public RaidGroup(int raidGroupSize){
        this.raidGroupSize = raidGroupSize;
        raidGroup = FXCollections.observableArrayList();  
    }

    /**
     * @return the raidGroup
     */
    public ObservableList<Raider> getRaidGroup() {
        return raidGroup;
    }

    /**
     * @return the raidGroupSize
     */
    public int getRaidGroupSize() {
        return raidGroupSize;
    }
    
    /**
     * Adds a raider to the raidgroup
     * @param raider 
     */
    public void addRaider(Raider raider){
        raidGroup.add(raider);
    }
}
