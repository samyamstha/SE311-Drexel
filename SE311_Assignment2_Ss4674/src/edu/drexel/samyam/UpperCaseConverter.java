package edu.drexel.samyam;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class UpperCaseConverter extends Filter {

	public UpperCaseConverter(Pipe input_, Pipe output_) {
		super(input_, output_);
	}

	@Override
	protected void transform() {
		try {
			String line;
			while ((line = (String) input.get()) != null) {
				output.put(line.toUpperCase());
			}
			output.put(null);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
