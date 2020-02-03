package edu.drexel.samyam;

import java.util.ArrayList;

public class LineStorage {

	private ArrayList<String> lines;
	private ArrayList<String> words;

	public LineStorage() {
		lines = new ArrayList<String>();
	}

	public ArrayList<String> getLines() {
		return lines;
	}

	public void addLine(String line) {
		lines.add(line.replaceAll("\\p{Punct}", ""));
	}

	public void clear() {
		lines.clear();
	}

}
