package edu.drexel.samyam;

import java.util.ArrayList;
import java.util.Collections;

public class Alphabetize extends Filter{

	private ArrayList<String> alphabetizedLines;
	
	public Alphabetize(Pipe input, Pipe output) {
		super(input, output);
		alphabetizedLines = new ArrayList<String>();
	}


	@Override
	protected void transform() {

		String line;
		try {
			while ((line = (String) input.get()) != null) {
				alphabetizedLines.add(line);
			}
			
			// alphabetically sort the lines ignoring the letter cases
			Collections.sort(alphabetizedLines, String.CASE_INSENSITIVE_ORDER);
			
			for(String each : alphabetizedLines) {
				output.put(each);
			}	
			output.put(null);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		
	}

}
