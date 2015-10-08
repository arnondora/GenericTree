public abstract class Traversal 
{
	public static <E> void printPreorder (ATree<E> T)
	{
		for (IPosition<E> p : T.preOrder()) System.out.print(p.getElement() + "-");
		System.out.println();
	}
	
	public static <E> void printPostorder (ATree<E> T)
	{
		for (IPosition<E> p : T.postOrder()) System.out.print(p.getElement() + "-");
		System.out.println();
	}
	
	public static <E> void printParenthesized (ITree<E> T)
	{
		if (T.isEmpty())
		{
			System.out.println("ERROR printParenthesized: the tree is empty");
		}
		else
			parenthesized(T,T.root());
		System.out.println();
	}
	
	public static <E> void parenthesized (ITree<E> T, IPosition<E> p)
	{
		System.out.print(p.getElement());
		if (T.numChildren(p) == 0) return;

		boolean isFirst = true;
		for (IPosition<E> traveller : T.children(p))
		{
			if (isFirst == true) System.out.print("(");
			else System.out.print(",");
			isFirst = false;
			parenthesized (T,traveller);
		}
		System.out.print(")");
	}
}
