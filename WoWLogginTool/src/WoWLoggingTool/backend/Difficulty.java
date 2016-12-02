/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WoWLoggingTool.backend;

/**
 *
 * @author Daniel Johansen
 */
public enum Difficulty {
    NORMAL(30,"normal"), HEROIC(30,"heroic"), MYTHIC(20,"mythic");
    
    private final int MAXRAIDSIZE;
	private String difficultyString;
    
    private Difficulty(int maxRaidSize, String difficultyString){
        this.MAXRAIDSIZE = maxRaidSize;
		this.difficultyString = difficultyString;
    }

    /**
     * @return the MAXRAIDSIZE
     */
    public int getMAXRAIDSIZE() {
        return MAXRAIDSIZE;
    }
	
	@Override
	public String toString(){
		return this.difficultyString;
	}
    
}
