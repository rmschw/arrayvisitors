package arrayvisitors.visitors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.Results;

/**
 * 
 * CommonIntsVisitor
 *
 */
public class CommonIntsVisitor implements Visitor {
	Set<Integer> obj = new HashSet<>();
	List CommonIntsList = new ArrayList<>();

	/**
	 * 
	 * @param rs
	 */
	public CommonIntsVisitor(Results rs) {
		rs.setCommonIntsList(getCommonIntsList());
	}

	/**
	 * 
	 * @return obj
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
	 * visitor
	 */
	@Override
	public void visitor(MyArrayListI myarrayList) {
		ArrayList<int[]> arraylist = myarrayList.getArrayList();

		Arrays.stream(arraylist.get(0)).forEach(obj::add);
		//System.out.println(obj);
		int[] secondarray = arraylist.get(1);

		for (int j = 0; j < secondarray.length; j++) {
			if (obj.contains(secondarray[j]))
				CommonIntsList.add(secondarray[j]);
		} 
	}

	/**
	 * visitor
	 */
	@Override
	public void visitor(MyArrayI myarray) {
		// TODO Auto-generated method stub

	}

}
