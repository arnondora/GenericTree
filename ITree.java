public interface ITree <E>
{
	//returning root
	IPosition<E> root();
	
	//returning parent
	IPosition<E> parent (IPosition<E> p);
	
	//Return list of children
	Iterable<IPosition<E>> children (IPosition<E> p);
	
	//returning number of children
	int numChildren (IPosition<E> p);
	
	//returning size of this tree
	int size();
	
	//returning state
	boolean isEmpty();
	
	Iterable<IPosition<E>> preOrder();
	Iterable<IPosition<E>> postOrder();
}
