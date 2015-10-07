import java.util.List;
import java.util.ArrayList;

public class LinkedTree<E> extends ATree<E>
{
	protected static class Node<E> implements IPosition<E>
	{
		private E element;
		private Node<E> parent;
		private List<Node<E>> children;
		
		public Node(E e,Node<E> parent, List<Node<E>> children)
		{
			element = e;
			this.parent = parent;
			this.children = children;
		}
		
		//Getter
		public E getElement () { return element; }
		public Node<E> getParent () {return parent;}
		public List<Node<E>> getChildren(){return children;}
		
		//Setter
		public void setElement (E element) {this.element = element;}
		public void setParent (Node<E> parent) {this.parent = parent;}
		public void setChildren (List<Node<E>> setParent) {this.children = setParent;}
	}
	
	protected Node<E> root = null;
	private int size = 0;
	
	public Node<E> newNode (E e, Node<E> p, List<Node<E>> child) {return new Node<E> (e,p,child);}
	
	protected Node<E> validate (IPosition<E> p) throws Exception
	{
		Node<E> node = null;
		try
		{
			node = (Node<E>) p;
			if (node.getParent() == node) throw new Exception("the position is no longer in the tree");
		}
		catch (Exception e){throw new Exception ("invalid position type.");}
		return node;
	}
	
	public IPosition<E> root() {return root;}
	
	public IPosition<E> parent(IPosition<E> p) {
		Node<E> testNode = null;
		
		try
		{
			testNode = validate(p);
		}
		catch (Exception e)
		{
			System.out.println("ERROR Parent: " + e.getMessage());
		}
		
		return testNode;
	}

	public int size() {
		return size;
	}

	public Iterable<IPosition<E>> children(IPosition<E> p) 
	{
		ArrayList<IPosition<E>> exportChild = new ArrayList<>();
		Node<E> chkNode = null;
		try
		{
			chkNode = validate(p);
			exportChild.addAll(chkNode.getChildren());
		}
		catch (Exception e)
		{
			System.out.println("ERROR Children :" + e.getMessage());
		}
		
		//it's ok that exportChild = null <- this node isn't in the tree or doesn't have any child

		return exportChild;
	}
	
	public IPosition<E> addRoot(E e)
	{
		if (root == null)
		{
			//ready to add
			root = new Node<E>(e,null,new ArrayList<Node<E>>());
			size++;
		}
		else
		{
			//already added root node call error message
			System.out.println("Error addRoot: the tree is not empty");
			return null;
		}
		
		return root;
	}

	
	public IPosition<E> addChild(IPosition<E> p , E e)
	{
		Node<E> pNode = null;
		Node<E> newNode = null;
		
		try
		{
			pNode =  validate(p);
			newNode = newNode(e,pNode,new ArrayList<Node<E>>());
			pNode.getChildren().add(newNode);
			size++;			
		}
		catch (Exception err) {System.out.println("ERROR addChild: " + err.getMessage());}
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
		Node<E> removeNode = null;
		E eVal = null;
		
		try
		{
			removeNode = validate(p);
			eVal = removeNode.getElement();
			
			//check whether this node is root or not
			if (removeNode.getParent() == null)
				root = null;
			else
				//otherwise remove link form parent via ArrayList.remove()
				removeNode.getChildren().remove(removeNode);
			size -= 1 + postOrderSubTree(p,new ArrayList<IPosition<E>>()).size();
		}
		catch (Exception e)
		{
			System.out.println("ERROR remove: " + e.getMessage());
		}
		
		return eVal;
	}
	
	public void swap (IPosition<E> p, IPosition<E> q)
	{
		Node<E> NodeA = null, NodeB = null;
		
		try
		{
			NodeA = validate(p);
			NodeB = validate(q);
			
			E temp = NodeA.getElement();
			NodeA.setElement(NodeB.getElement());
			NodeB.setElement(temp);
		}
		catch (Exception e)
		{
			System.out.println("ERROR swap: " + e.getMessage());
		}
	}
}
