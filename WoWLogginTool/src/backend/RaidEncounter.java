/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend;

/**
 *
 * @author Daniel Johansen
 */
public class RaidEncounter {
    
    private RaidGroup raidGroup;
    private Difficulty diff;
    private String description;
    private RaidBoss raidBoss;
    public static int tryNumber = 1;
    
    public RaidEncounter(RaidGroup raidGroup, Difficulty diff, String description, RaidBoss raidBoss){
        this.diff = diff;
        this.raidBoss = raidBoss;
        this.description = description;
        
        if(this.diff.getMAXRAIDSIZE() >= raidGroup.getRaidGroupSize()){
        this.raidGroup = raidGroup;
        } else {
            System.out.println("raidGroup too big");
        }
        
    }

    /**
     * @return the raidGroup
     */
    public RaidGroup getRaidGroup() {
        return raidGroup;
    }

    /**
     * @param raidGroup the raidGroup to set
     */
    public void setRaidGroup(RaidGroup raidGroup) {
        this.raidGroup = raidGroup;
    }

    /**
     * @return the diff
     */
    public Difficulty getDiff() {
        return diff;
    }

    /**
     * @param diff the diff to set
     */
    public void setDiff(Difficulty diff) {
        this.diff = diff;
    }
}
