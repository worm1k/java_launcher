package src.utility;

import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class Writer {
	
	private static PrintWriter writer = null;

	private Writer() {}

	public static PrintWriter getWriter() throws FileNotFoundException {
		if (writer == null) {
			writer = new PrintWriter("simulation.txt");
		}
		return writer;
	}

	public static void writeIntoAFile(String text) {
		writer.println(text);
	}	

	public static void closeWriter() {
		writer.close();
	}
}
