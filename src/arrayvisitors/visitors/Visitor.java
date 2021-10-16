package arrayvisitors.visitors;

import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.adt.MyArrayListI;
/**
 * 
 * Visitor
 *
 */
public interface Visitor {
void visitor(MyArrayListI myarrayList);
void visitor(MyArrayI myarray);

}
