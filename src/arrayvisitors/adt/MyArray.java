package arrayvisitors.adt;

import java.util.Arrays;
/**
 * MyArray implements MyArray Interface
 */
public class MyArray implements MyArrayI {
	int MAX_SIZE = 10;
	int ACT_ARR_LEN = 0;
	int arr[] = new int[MAX_SIZE];
/**
 * MyArray
 */
	public MyArray() {
		this.arr = arr;
	}
/**
 * @param arrayElement
 * @param indexß
 */
	public void setElement(int arrayElement, int index) {

		/*
		 * if(index<10) { this.MAX_SIZE = index; arr = new int[MAX_SIZE]; }
		 */

		if (index >= 10) {

			this.MAX_SIZE = (int) (MAX_SIZE + (int) MAX_SIZE * (50.0 / 100.0));
			int[] oldarray = Arrays.copyOf(arr, MAX_SIZE);
			arr = new int[MAX_SIZE];
			arr = Arrays.copyOf(oldarray, MAX_SIZE);
		}

		this.arr[index] = arrayElement;
		ACT_ARR_LEN = index+1;

	}
/**
 * getArray
 */
	public int[] getArray() {
		arr = Arrays.copyOf(arr, ACT_ARR_LEN);
		//System.out.println(Arrays.toString(arr));
		return arr;
	}
/**
 * toString
 */
	@Override
	public String toString() {
		return "MyArray [MAX_SIZE=" + MAX_SIZE + ", arr=" + Arrays.toString(arr) + "]";
	}
/**
 * getArrayElement
 * @param index
 * @return
 */
	int getArrayElement(int index) {
		return arr[index];
	}

}
