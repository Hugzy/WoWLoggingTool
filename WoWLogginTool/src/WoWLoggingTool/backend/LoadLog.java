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
public class LoadLog {

	public ObservableList<Log> loadObservableList(String fileToRead, ObservableList<Raid> raids, ObservableList<Raider> raiders) {
		ObservableList<Log> listToReturn = FXCollections.observableArrayList();
		try {
			ObservableList<RaidEncounter> raidEncounters = FXCollections.observableArrayList();
			RaidGroup raidGroup = null;
			RaidBoss raidBoss = null;
			Raid raid = null;
			Difficulty difficultyType = null;
			String description = null;
			boolean creatingEncounter = false;
			boolean createLog = false;
			BufferedReader reader = new BufferedReader(new FileReader(fileToRead));

			while (reader.ready()) {

				String evaluateString = reader.readLine();
				String[] stringArray = evaluateString.split("=");
				if (creatingEncounter) {
					boolean createEncounter = false;
					switch (stringArray[0]) {
						case "raidBoss":
							for (Raid r : raids) {
								for (RaidBoss boss : r.getBossList()) {
									if (boss.name.equalsIgnoreCase(stringArray[stringArray.length - 1])) {
										raidBoss = boss;
										raid = r;
									}
								}
							}
							break;
						case "raiders":
							String[] raiderNames = stringArray[stringArray.length - 1].split(":");
							raidGroup = createRaidGroup(raiderNames);

							break;
						case "difficulty":
							String difficulty = stringArray[stringArray.length - 1];
							for (Difficulty d : Difficulty.values()) {
								if (d.toString().equalsIgnoreCase(difficulty)) {
									difficultyType = d;
								}
							}
							break;
						case "description":
							description = stringArray[stringArray.length - 1];
							break;
						case "endOfEncounter":
							createEncounter = true;
							creatingEncounter = false;
							break;
						default:
							break;

					}
					if (createEncounter) {
						raidEncounters.add(new RaidEncounter(raidGroup, difficultyType, description, raidBoss));
					}
				} else {
					switch (stringArray[0]) {
						case "[raidEncounter]":
							creatingEncounter = true;
							break;
						case "[endOfEncounters]":
							createLog = true;
							break;
					}
				}
				if (createLog) {
					listToReturn.add(new Log(raid, raidEncounters));
				}
			}

		} catch (FileNotFoundException ex) {
			Logger.getLogger(LoadRaider.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(LoadRaider.class.getName()).log(Level.SEVERE, null, ex);
		}
		return listToReturn;
	}

	private RaidGroup createRaidGroup(String[] raiderNames) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
