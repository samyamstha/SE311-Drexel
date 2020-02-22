package edu.drexel.samyam;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class LineStorage extends MyObservable {

	private ArrayList<String> lines;
	private ArrayList<String> alphabetized;

	private LinkedHashMap<String, ArrayList<String>> linesMap;

	public LineStorage() {
		lines = new ArrayList<String>();
		linesMap = new LinkedHashMap<String, ArrayList<String>>();
	}
	
	public void setAlphabetized(ArrayList<String> alphabetized) {
		this.alphabetized = alphabetized;
	}
	
	public ArrayList<String> getAlphabetized() {
		return alphabetized;
	}

	public ArrayList<String> getLines() {
		return lines;
	}

	public LinkedHashMap<String, ArrayList<String>> getLinesMap() {
		return linesMap;
	}

	public void addLine(String line) {
		lines.add(line.replaceAll("\\p{Punct}", ""));
		processEvent(new MyEvent(lines.size() - 1, MyEvent.LINE_ADDED));
	}

	public void addCircularShiftedLines(String line, ArrayList<String> shiftedLines) {
		linesMap.put(line, shiftedLines);
	}

	public void removeLine(int lineIndex) {
		linesMap.remove(lines.get(lineIndex));
		lines.remove(lineIndex);
	}

	public void clear() {
		lines.clear();
	}

	private void processEvent(MyEvent event) {
		notifyAllObservers(event);
	}


}
