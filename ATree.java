import java.util.List;
import java.util.ArrayList;

public abstract class ATree<E> implements ITree<E>
{
	public int numChildren (IPosition<E> p)
	{
		List<IPosition<E>> child = ((List<IPosition<E>>)children(p));
		if (p==null) return -1;
		return child.size();
	}
	
	public boolean isEmpty () {return root() == null;}
	
	public Iterable<IPosition<E>> preOrder()
	{
		return preOrderSubtree(root(),new ArrayList<IPosition<E>>());
	}
	
	public Iterable<IPosition<E>> postOrder()
	{
		return postOrderSubTree(root(),new ArrayList<IPosition<E>>());
	}
	
	private List<IPosition<E>> preOrderSubtree (IPosition<E> p, List<IPosition<E>> snapshot)
	{
		snapshot.add(p);
		for(IPosition<E> traveller : children(p))
		{
			preOrderSubtree(traveller,snapshot);
		}
		
		return snapshot;
	}
	
	private List<IPosition<E>> postOrderSubTree (IPosition<E> p, List<IPosition<E>> snapshot)
	{
		for (IPosition<E> traveller : children(p))
			postOrderSubTree(traveller,snapshot);
		snapshot.add(p);
		return snapshot;
	}
	
}
