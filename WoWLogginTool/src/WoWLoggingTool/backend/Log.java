/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WoWLoggingTool.backend;

import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Daniel Johansen
 */
public class Log {
    private Raid raid;
    private ObservableList<RaidEncounter> raidEncounters;
    private LocalDateTime date;
    
    public Log(Raid raid, ObservableList<RaidEncounter> raidEncounters){
        this.raid = raid;
        date = LocalDateTime.now();
    }
    public Log(Raid raid){
        this.raid = raid;
        this.raidEncounters = FXCollections.observableArrayList();
    }

    /**
     * @return the raid
     */
    public Raid getRaid() {
        return raid;
    }

    /**
     * @return the raidEncounters
     */
    public ObservableList<RaidEncounter> getRaidEncounters() {
        return raidEncounters;
    }
    
    public void addRaidEncounter(RaidEncounter raidEncounter){
        this.raidEncounters.add(raidEncounter);
    }
            
}
