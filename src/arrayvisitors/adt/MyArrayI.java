package arrayvisitors.adt;

import arrayvisitors.visitors.Element;
/**
 * 
 * MyArray Interface
 *
 */
public interface MyArrayI extends Element{
	/**
	 * 
	 * @param arrayElement
	 * @param index
	 */
	public void setElement(int arrayElement, int index);
	int[] getArray();
}
