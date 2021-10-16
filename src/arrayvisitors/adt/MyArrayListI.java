package arrayvisitors.adt;

import java.util.ArrayList;
import java.util.Collection;

import arrayvisitors.visitors.Element;
/**
 * 
 * MyArrayListI
 *
 */
public interface MyArrayListI extends Element{
	void setElement();
	/**
	 * 
	 * @return
	 */
	ArrayList<int[]> getArrayList();
}
