package arrayvisitors.util;
import arrayvisitors.util.MyLogger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.List;
import java.util.Formatter;

/**
 * 
 * Results to show results
 *
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {
	List<Integer> CommonIntsList = new ArrayList<Integer>();
	List<Integer> MissingIntsList = new ArrayList<Integer>();

	/**
	 * 
	 * @return CommonIntsList
	 */
	public List getCommonIntsList() {
		return CommonIntsList;
	}

	/**
	 * 
	 * @param commonIntsList
	 */
	public void setCommonIntsList(List commonIntsList) {
		CommonIntsList = commonIntsList;
	}

	/**
	 * 
	 * @return MissingIntsList
	 */
	public List getMissingIntsList() {
		return MissingIntsList;
	}

	/**
	 * 
	 * @param missingIntsList
	 */
	public void setMissingIntsList(List missingIntsList) {
		MissingIntsList = missingIntsList;
	}

	/**
	 * stdPrintCommonInts
	 */
	public void stdPrintCommonInts() {
		System.out.println("Common Ints" + CommonIntsList);
		MyLogger myLogger = MyLogger.getInstance();
		myLogger.writeMessage("You are in Results class.", MyLogger.DebugLevel.RESULTS);
		while (CommonIntsList.get(CommonIntsList.size() - 1) == 0) {
			CommonIntsList.remove(CommonIntsList.size() - 1);
		}
		for (int i : CommonIntsList) {
			String formattedStr2 = String.format("%02d", i);
			System.out.println(formattedStr2 + " ");
			// System.out.println(i);
		}
	}

	/**
	 * stdPrintMissingInts
	 */
	public void stdPrintMissingInts() {
		System.out.println("Missing Ints");
		while (MissingIntsList.get(MissingIntsList.size() - 1) == 0) {
			MissingIntsList.remove(MissingIntsList.size() - 1);
		}
		for (int i : MissingIntsList) {
			String formattedStr = String.format("%02d", i);
			System.out.println(formattedStr + " ");
			// System.out.print(i + " ");
		}
		System.out.println();

	}

	/**
	 * writeToFileCommonIntsList
	 */
	public void writeToFileCommonIntsList() throws InvalidPathException, SecurityException {
		File file = new File("commonintsout.txt");
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(file, false));
			bw.write("Common Ints List");
			bw.newLine();
			for (int i = 0; i < CommonIntsList.size(); i++) {
				String formattedStr = String.format("%02d", CommonIntsList.get(i));
				bw.write(formattedStr.toString());
				bw.newLine();
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * writToFileMissingIntsList1
	 */
	public void writToFileMissingIntsList1() throws InvalidPathException, SecurityException {
		File file2 = new File("missingintsout.txt");
		try {
			BufferedWriter bw2 = new BufferedWriter(new FileWriter(file2, false));
			bw2.write("Missing Ints List1:");
			bw2.newLine();
			for (int i2 = 0; i2 < MissingIntsList.size(); i2++) {
				String formattedStr = String.format("%02d", MissingIntsList.get(i2));
				bw2.write(formattedStr.toString());
				bw2.newLine();
			}
			bw2.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * writToFileMissingIntsList2
	 */
	public void writToFileMissingIntsList2() throws InvalidPathException, SecurityException {
		File file2 = new File("missingintsout2.txt");
		try {
			BufferedWriter bw2 = new BufferedWriter(new FileWriter(file2, false));
			bw2.write("Missing Ints List2:");
			bw2.newLine();
			for (int i2 = 0; i2 < MissingIntsList.size(); i2++) {
				String formattedStr = String.format("%02d", MissingIntsList.get(i2));
				bw2.write(formattedStr.toString());
				bw2.newLine();
			}
			bw2.close();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
