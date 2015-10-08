public interface ITree<E>
{
	IPosition<E> root();
	IPosition<E> parent (IPosition<E> p);
	
	Iterable<IPosition<E>> children (IPosition<E> p);
	
	int numChildren (IPosition<E> p);
	
	int size();
	
	boolean isEmpty();
	
	Iterable<IPosition<E>> preOrder();
	Iterable<IPosition<E>> postOrder();
}
