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
public enum Difficulty {
    NORMAL(30), HEROIC(30), MYTHIC(20);
    
    private final int MAXRAIDSIZE;
    
    private Difficulty(int maxRaidSize){
        this.MAXRAIDSIZE = maxRaidSize;
    }

    /**
     * @return the MAXRAIDSIZE
     */
    public int getMAXRAIDSIZE() {
        return MAXRAIDSIZE;
    }
    
}
