package edu.drexel.samyam;

import java.util.ArrayList;
import java.util.Collections;

public class Alphabetize extends MyObserver{

	private LineStorage lineStorage;
	private ArrayList<String> alphabetizedLines;
	
	public Alphabetize(LineStorage lineStorage) {
		this.lineStorage = lineStorage;

		
	}
	
	public void alphabetizeLines() {
		alphabetizedLines = new ArrayList<String>();
		for (String each : lineStorage.getLinesMap().keySet()) {
			alphabetizedLines.addAll(lineStorage.getLinesMap().get(each));
		}

		// alphabetically sort the lines ignoring the letter cases
		Collections.sort(alphabetizedLines, String.CASE_INSENSITIVE_ORDER);
		
		// clear the line storage and add he alphabetized lines to line storage
//		lineStorage.clear();
		
		lineStorage.setAlphabetized(alphabetizedLines);
	
	}

	@Override
	public void update(MyEvent event) {
		if (isMyEvent(event.getEventType(), MyEvent.ALPHABETIZE)) {
			alphabetizeLines();
		}
	}

}
