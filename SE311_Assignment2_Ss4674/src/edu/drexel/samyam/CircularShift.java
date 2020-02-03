package edu.drexel.samyam;

import java.util.ArrayList;
import java.util.Collections;

public class CircularShift extends Filter{



	public CircularShift(Pipe input, Pipe output) {
		super(input, output);
	}

	@Override
	protected void transform() {
		ArrayList<String> shiftedLines = new ArrayList<String>();
		String line;
		
		
		try {
			while((line = (String)input.get()) != null) {
				String[] words = line.split(" ");
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
				output.put(each);
			}
			output.put(null);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
		
			
	}


}
