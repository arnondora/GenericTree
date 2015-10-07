import java.util.ArrayList;
import java.util.List;

public abstract class ATree<E> implements ITree<E>
{
	public boolean isEmpty () {return root() == null;}
	
	public int numChildren (IPosition<E> p) {return ((List<IPosition<E>>) children(p)).size()-1;}
	
	public Iterable<IPosition<E>> preOrder()
	{
		return preOrderSubTree(root(),new ArrayList<IPosition<E>>());
	}
	
	public List<IPosition<E>> preOrderSubTree (IPosition<E> p, List<IPosition<E>> snapshot)
	{
		snapshot.add(p);
		for (IPosition<E> traveller : children(p)) {preOrderSubTree(traveller,snapshot);}
		return snapshot;
	}
	
	public Iterable<IPosition<E>> postOrder()
	{
		return postOrderSubTree(root(),new ArrayList<IPosition<E>>());
	}
	
	public List<IPosition<E>> postOrderSubTree (IPosition<E> p, List<IPosition<E>> snapshot)
	{
		for (IPosition<E> traveller: children(p)) {postOrderSubTree(traveller,snapshot);}
		snapshot.add(p);
		return snapshot;
	}
	
}
