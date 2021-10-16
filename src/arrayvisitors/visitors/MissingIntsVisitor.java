package arrayvisitors.visitors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.Results;

/**
 * 
 * MissingIntsVisitor
 *
 */
public class MissingIntsVisitor implements Visitor {
	Set<Integer> obj = new HashSet<>();

	List MissingIntsList = new ArrayList<>();

	/**
	 * 
	 * @param rs
	 */
	public MissingIntsVisitor(Results rs) {
		rs.setMissingIntsList(getMissingIntsList());
	}

	/**
	 * 
	 * @return
	 */
	public Set<Integer> getObj() {
		return obj;
	}

	/**
	 * 
	 * @param obj
	 */
	public void setObj(Set<Integer> obj) {
		this.obj = obj;
	}

	/**
	 * 
	 * @return
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
	 * visitor
	 */
	public void visitor(MyArrayListI myarrayList) {
		ArrayList<int[]> arraylist = myarrayList.getArrayList();

	}

	/**
	 * visitor
	 * 
	 * @param myarray
	 */
	public void visitor(MyArrayI myarray) {

		int[] allArray = new int[100];
		for (int i = 0; i < allArray.length; i++) {
			allArray[i] = i;
		}
		int[] arrayOne = myarray.getArray();
		System.out.println("Array: " + Arrays.toString(arrayOne));

		Arrays.sort(arrayOne);
		for (int i : allArray) {
			if (Arrays.binarySearch(arrayOne, i) < 0)
				MissingIntsList.add(allArray[i]);
		}

	}
}
