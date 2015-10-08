import java.util.ArrayList;
import java.util.List;

public class LinkedTree<E> extends ATree<E>
{
	protected static class Node<E> implements IPosition<E>
	{
		private E element;
		private Node<E> parent;
		private List<Node<E>> children;
		
		public Node (E e, Node<E> p, List<Node<E>> c)
		{
			element = e;
			parent = p;
			children = c;
		}
		
		public E getElement (){ return element;}
		public Node<E> getParent () {return parent;}
		public List<Node<E>> getChildren () {return children;}
		
		public void setElement (E e) {element = e;}
		public void setParent (Node<E> p) {parent = p;}
		public void setChildren(List<Node<E>> c){children = c;}
	}
	
	protected Node<E> root = null;
	protected int size = 0;
	
	private Node<E> newNode (E e, Node<E> p, List<Node<E>> c)
	{
		return new Node<E>(e,p,c);
	}
	
	private Node<E> validate (IPosition<E> p) throws Exception
	{
		Node<E> testNode = null;
		try
		{
			testNode = ((Node<E>)p);
			if (testNode.getParent() == testNode) throw new Exception("invalid position type");
		}
		catch (Exception e)
		{
			throw new Exception ("invalid position type");
		}
		
		return testNode;
	}

	public IPosition<E> root() { return root;}

	public IPosition<E> parent(IPosition<E> p) {
		Node<E> pNode = null;
		try
		{
			pNode = validate(p);
		}
		catch (Exception e)
		{
			System.out.println("ERROR root: " + e.getMessage());
		}
		return pNode.getParent();
	}

	public Iterable<IPosition<E>> children(IPosition<E> p) {
		Node<E> pNode = null;
		List<IPosition<E>> child = new ArrayList<IPosition<E>>();
		
		try
		{
			pNode = validate(p);
			child.addAll(pNode.getChildren());
		}
			
		catch (Exception e)
		{
			System.out.println("ERROR children: " + e.getMessage());
		}
		
		return child;
	}

	public int size()
	{
		return size;
	}
	
	public IPosition<E> addRoot (E e)
	{
		if (root == null)
		{
			//ready to add root
			root = newNode(e,null,new ArrayList<Node<E>>());
			size++;
		}
		else
		{
			System.out.println("ERROR addRoot: the tree is not empty");
			return null;
		}
		
		return root;
	}
	
	public IPosition<E> addChild (IPosition<E> p, E e)
	{
		Node<E> newNode = null ,pNode = null;
		
		try
		{
			pNode = validate(p);
			newNode = newNode(e,pNode,new ArrayList<Node<E>>());
			pNode.getChildren().add(newNode);
			size++;
		}
		catch (Exception err)
		{
			System.out.println("ERROR addChild: " + err.getMessage());
		}
		
		return newNode;
	}
	
	public E set (IPosition<E> p, E e)
	{
		Node<E> setNode = null;
		try
		{
			setNode = validate(p);
			setNode.setElement(e);
		}
		catch (Exception err)
		{
			System.out.println("ERROR set: " + err.getMessage());
		}
		return e;
	}
	
	public E remove (IPosition<E> p)
	{
		E tempVal = p.getElement();
		((Node<E>)p).getChildren().remove(p);
		size -= 1+ ((List<IPosition<E>>)preOrder()).size();
		return tempVal;
	}
	
	public void swap (IPosition<E> p, IPosition<E> q)
	{
		Node<E> nodeA = null, nodeB = null;
		try
		{
			nodeA = validate(p);
			nodeB = validate(q);
		}
		catch (Exception e)
		{
			System.out.println("ERROR swap: "+ e.getMessage());
		}
		
		E temp = nodeA.getElement();
		nodeA.setElement(nodeB.getElement());
		nodeB.setElement(temp);
	}
}
