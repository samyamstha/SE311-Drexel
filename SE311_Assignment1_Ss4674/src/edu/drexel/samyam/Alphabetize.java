package edu.drexel.samyam;

import java.util.ArrayList;
import java.util.Collections;

public class Alphabetize {

	private LineStorage lineStorage;
	private ArrayList<String> alphabetizedLines;
	
	public Alphabetize(LineStorage lineStorage) {
		this.lineStorage = lineStorage;
		alphabetizedLines = new ArrayList<String>();
	}
	
	public void alphabetizeLines() {
		
		for (String each : lineStorage.getLines()) {
			alphabetizedLines.add(each);
		}

		// alphabetically sort the lines ignoring the letter cases
		Collections.sort(alphabetizedLines, String.CASE_INSENSITIVE_ORDER);
		
		// clear the line storage and add he alphabetized lines to line storage
		lineStorage.clear();
		
		for(String each : alphabetizedLines) {
			lineStorage.addLine(each);
		}
	}

}
