package arrayvisitors.driver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.Results;
import arrayvisitors.visitors.CommonIntsVisitor;
import arrayvisitors.visitors.MissingIntsVisitor;
import arrayvisitors.visitors.PopulateMyArrayVisitor;
import arrayvisitors.visitors.Visitor;
import arrayvisitors.util.MyLogger;

/**
 * Driver class Retrieving inputs from input file and writes output to output
 * 
 * @author Ram Ch
 *
 */
public class Driver {

	private static final int REQUIRED_NUMBER_OF_CMDLINE_ARGS = 2;

	/**
	 * 
	 * @param args to pass from file
	 * @throws Exception             indicates conditions that a reasonable
	 *                               application might want to catch.
	 * @throws EmptyFileException    to find empty file
	 * @throws InvalidPathException  if the path is invalid
	 * @throws SecurityException     to indicate a security violation.
	 * @throws FileNotFoundException when file not found
	 * @throws IOException           Signals that an I/O exception of some sort has
	 *                               occurred.
	 * @throws invalidInputException to find invalid input
	 */
	public static void main(String[] args)
			throws Exception, InvalidPathException, SecurityException, FileNotFoundException, IOException {

		if ((args.length != 5) || (args[0].equals("${inputone}"))
				|| (args[1].equals("${inputtwo}") || (args[2].equals("${commonintsout}"))
						|| (args[3].equals("${missingintsout}")) || args[4].equals("${debug}"))) {
			System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.",
					REQUIRED_NUMBER_OF_CMDLINE_ARGS);
		}
		String strInFile1 = args[0];
		String strInFile2 = args[1];
		String strCommonInts = args[2];
		String strMissingInts = args[3];
		// String strDebug = args[4];
		int strDebug = Integer.parseInt(args[4]);

		MyLogger myLogger = MyLogger.getInstance();
		myLogger.setDebugValue(strDebug);
		myLogger.writeMessage("You are in Driver class.", MyLogger.DebugLevel.DRIVER);

		// inputone.txt inputtwo.txt commonintsout.txt missingintsout.txt 1

		// String strInFile1 = "inputone.txt";
		// String strInFile2 = "inputtwo.txt";
		// String strCommonInts = "commonintsout.txt";
		// String strMissingInts = "missingintsout.txt";

		try {
			// two instances of MyArray
			MyArrayI myarray1 = new MyArray();
			MyArrayI myarray2 = new MyArray();
			Visitor populateVisitor = new PopulateMyArrayVisitor(strInFile1);
			// PopulateMyArrayVisitor
			populateVisitor.visitor(myarray1);
			populateVisitor = new PopulateMyArrayVisitor(strInFile2);
			populateVisitor.visitor(myarray2);
			MyArrayListI myArrayList = new MyArrayList(myarray1, myarray2);
			populateVisitor.visitor(myArrayList);
			// instances of Results
			Results rs = new Results();
			// Create instances of the visitors
			Visitor commonIntsVisitor = new CommonIntsVisitor(rs);
			// CommonIntsVisitor
			commonIntsVisitor.visitor(myArrayList);
			rs.writeToFileCommonIntsList();
			rs.stdPrintCommonInts();
			// MissingIntsVisitor
			Visitor missingIntsVisitor = new MissingIntsVisitor(rs);
			missingIntsVisitor.visitor(myarray1);
			rs.stdPrintMissingInts();
			rs.writToFileMissingIntsList1();
			missingIntsVisitor = new MissingIntsVisitor(rs);
			missingIntsVisitor.visitor(myarray2);
			rs.stdPrintMissingInts();
			rs.writToFileMissingIntsList2();

		} catch (InvalidPathException e) {
			e.printStackTrace();
			System.exit(1);
		} catch (SecurityException e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
}
