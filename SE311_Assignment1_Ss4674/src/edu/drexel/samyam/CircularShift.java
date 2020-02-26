package edu.drexel.samyam;

import java.util.ArrayList;
import java.util.Collections;

public class CircularShift {

	private LineStorage lineStorage;

	public CircularShift(LineStorage lineStorage) {
		this.lineStorage = lineStorage;
	}

	public void setup() {
		ArrayList<String> shiftedLines = new ArrayList<String>();
		
		for (String each : lineStorage.getLines()) {
			String[] words = each.split(" ");
			ArrayList<String> wordsList = new ArrayList<String>();
			Collections.addAll(wordsList, words);

			// perform circular shifts
			for (int i = 0; i < wordsList.size() - 1; i++) {
				wordsList.add(wordsList.get(0));
				wordsList.remove(0);
				String shiftedLine = String.join(" ", wordsList);
				shiftedLines.add(shiftedLine);
			}
		}	
		
		// add the shifted lines to line storage
		for (String each : shiftedLines) {
			lineStorage.addLine(each);
		}
	}


}
