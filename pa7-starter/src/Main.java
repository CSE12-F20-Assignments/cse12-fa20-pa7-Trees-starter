import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	public static final String DEFAULT_TRAINING_FILENAME = "GreenEggsAndHam.txt";
	public static final int CUTOFF_FREQUENCY = 15;
	public static final int MIN_PREFIX_LEN = 1;
	public static final int MAX_PREFIX_LEN = 5;
	public static final boolean USE_FREQ_LIST = false;
	public static final int[] FREQ_LIST = {35, 25, 15, 10, 5};

	public static void main(String[] args) {		

		String fileData = getFileData(DEFAULT_TRAINING_FILENAME);
		
		FrequencyFilter filt = new FrequencyFilter();
		filt.buildFrequencyTrees(fileData, MIN_PREFIX_LEN, MAX_PREFIX_LEN);
		if (USE_FREQ_LIST) {
			System.out.println(filt.filter(FREQ_LIST));
		} else {
			System.out.println(filt.filter(CUTOFF_FREQUENCY));
		}
	}

	private static String getFileData(String filename) {
		Path trainingFilePath = Paths.get(filename);
		BufferedReader reader = null;
		try { 
			reader = Files.newBufferedReader(trainingFilePath);
		} catch (IOException e) {
		    System.err.println(e);
		    System.exit(-1);
		}
		
		StringBuilder fileContents = readFile(reader);
		try {
			reader.close();
		} catch (IOException e) {
			System.err.println("An error occurred while closing the file");
			System.exit(-1);
		}
		
		if (fileContents == null) {
			System.exit(-1);
		}
		
		fileContents = sanitizeFileContents(fileContents);
		return fileContents.toString().trim();
	}
	
	private static StringBuilder readFile(BufferedReader fileReader) {
		StringBuilder fileContents = new StringBuilder();
		try {
			String line = null;
			while ((line = fileReader.readLine()) != null) {
				fileContents.append(line.trim() + " ");
			}
		} catch (IOException e) {
			System.err.println(e);
			System.err.println("An error occurred while reading from the file");
			return null;
		}
		return fileContents;
	}
	
	private static StringBuilder sanitizeFileContents(StringBuilder fileContents) {
		String[] words = fileContents.toString().split("\\s");
		StringBuilder sanitizedFileContents = new StringBuilder(fileContents.length());
		
		for (String word : words) {
			if (word.isEmpty() || word.trim().isEmpty()) {
				continue;
			}
			sanitizedFileContents.append(word + " ");
		}
		
		return sanitizedFileContents;
	}	

}
