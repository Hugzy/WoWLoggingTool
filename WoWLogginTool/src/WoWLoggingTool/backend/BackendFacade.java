/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WoWLoggingTool.backend;

/**
 *
 * @author Danieln Johansen
 */
public class BackendFacade implements IConnectGui {

	public void test() {
		LoadLog ll = new LoadLog();
		LoadRaid lr = new LoadRaid();
		LoadRaider lred = new LoadRaider();
		ll.loadObservableList("testloadlog.txt", lr.loadObservableList("testraid.txt"), lred.loadObservableList("testraiders.txt"));
	}
}
