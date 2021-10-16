package arrayvisitors.visitors;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.HashSet;
import java.util.Set;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.FileProcessor;

/**
 * 
 * PopulateMyArrayVisitor
 *
 */
public class PopulateMyArrayVisitor implements Visitor {
	String strInFile;

	/**
	 * 
	 * @param strInFile
	 */
	public PopulateMyArrayVisitor(String strInFile) {
		this.strInFile = strInFile;
	}

	/**
	 * visitor
	 */
	@Override
	public void visitor(MyArrayI myarray) {
		FileProcessor fp = null;
		try {
			fp = new FileProcessor(strInFile);
		} catch (InvalidPathException | SecurityException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String strInt;

		Set<String> skillset = new HashSet<String>();
		int index = 0;
		try {
			while ((strInt = fp.poll()) != null) {
				if (isNumber(strInt)) {
					myarray.setElement(Integer.parseInt(strInt), index);
				}
				index++;
			}
		} catch (NumberFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	static boolean isNumber(String s) {
		try {
			Integer.parseInt(s);
		} catch (NumberFormatException ex) {
			return false;
		}

		return true;
	}

	/**
	 * visitor
	 */
	@Override
	public void visitor(MyArrayListI myarrayList) {

		myarrayList.setElement();
		// TODO Auto-generated method stub

	}

}
