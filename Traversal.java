public class Traversal 
{
	public static <E> void printPreorder (ATree<E> T)
	{
		for (IPosition<E> p: T.preOrder()) System.out.print(p.getElement() + "-");
		System.out.println();
	}
	
	public static <E> void printPostorder (ATree<E> T)
	{
		for (IPosition<E> p: T.postOrder()) System.out.print(p.getElement() + "-");
		System.out.println();
	}
	
	public static <E> void printParenthesized (ITree<E> T)
	{
		if (T.isEmpty())
			System.out.println("ERROR printParenthesized: the tree is empty");
		else
			parenthesized(T,T.root());
		System.out.println();
	}
	
	public static <E> void parenthesized (ITree<E> T, IPosition<E> p)
	{
		System.out.print(p.getElement());
		if (T.numChildren(p) == 0) return; //no child
		boolean firstTime = true;
		for (IPosition<E> t : T.children(p))
		{
			if (firstTime){System.out.print("(");}
			else{System.out.print(",");}
			firstTime = false;
			parenthesized(T,t);
		}
		System.out.print(")");
	}
	
	
}
