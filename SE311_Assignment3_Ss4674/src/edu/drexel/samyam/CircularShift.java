package edu.drexel.samyam;

import java.util.ArrayList;
import java.util.Collections;

public class CircularShift extends MyObserver {

	private LineStorage lineStorage;

	public CircularShift(LineStorage lineStorage) {
		this.lineStorage = lineStorage;
		lineStorage.attach(this);
	}

	public void interactiveSetup(int lineIndex) {

	}

	public void setup(int lineIndex) {
		ArrayList<String> shiftedLines = new ArrayList<String>();

		String each = lineStorage.getLines().get(lineIndex);
		String[] words = each.split(" ");
		ArrayList<String> wordsList = new ArrayList<String>();
		Collections.addAll(wordsList, words);

		// perform circular shifts
		for (int i = 0; i < wordsList.size(); i++) {
			wordsList.add(wordsList.get(0));
			wordsList.remove(0);
			String shiftedLine = String.join(" ", wordsList);
			shiftedLines.add(shiftedLine);
		}
		
		lineStorage.addCircularShiftedLines(each, (ArrayList<String>) shiftedLines.clone());
		shiftedLines.clear();

		// add the shifted lines to line storage
		/*
		 * for (String each : shiftedLines) { lineStorage.addLine(each); }
		 */
	}

	@Override
	public void update(MyEvent event) {
		if (isMyEvent(event.getEventType(), MyEvent.LINE_ADDED)) {
			setup(event.getLineIndex());
		}
	}

}
