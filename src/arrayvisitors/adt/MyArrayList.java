package arrayvisitors.adt;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
/**
 * MyArrayList
 *
 */
public class MyArrayList implements MyArrayListI {
	ArrayList<int[]> arrayList = new ArrayList<int[]>();
	MyArrayI myarray1 ;
	MyArrayI myarray2 ;
	/**
	 * MyArrayList
	 * @param myarray1
	 * @param myarray2
	 */
	public MyArrayList(MyArrayI myarray1,MyArrayI myarray2) {
		this.myarray1 = myarray1;
		this.myarray2 = myarray2;
	}
	/**
	 * ArrayList
	 */
	public ArrayList<int[]> getArrayList() {
		return arrayList;
	}
/**
 * toString
 */
	@Override
	public String toString() {
		return "MyArrayList [arrayList=" + arrayList + ", myarray1=" + myarray1 + ", myarray2=" + myarray2 + "]";
	}
	public void setArrayList(ArrayList<int[]> arrayList) {
		this.arrayList = arrayList;
	}
/**
 * setElement
 */
	@Override
	public void setElement() {
		arrayList.add(myarray1.getArray());
		arrayList.add(myarray2.getArray());

	}
}
