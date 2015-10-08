public class PartialTester {
	static IPosition<String> p,q,r,s;
	static LinkedTree<String> tree = new LinkedTree<String>();
	public static void main(String args[]) {
		// STEP 1
		r = tree.addRoot("%%");	print();
		s = tree.addRoot("~~"); next();
		p = tree.addChild(r,"xx"); print();
		q = tree.addChild(r,"&&"); print();
		tree.addChild(s,"^^"); next();
		
		// STEP 2
		p = tree.addChild(q,"oo"); tree.addChild(q,"??"); tree.addChild(r,"##");
		print();
		Traversal.printPreorder(tree);
		Traversal.printPostorder(tree); next();
		
		// STEP 3
		System.out.println(tree.root().getElement());
		System.out.println(tree.parent(p).getElement());
		System.out.println(tree.numChildren(p));
		System.out.println(tree.numChildren(q));
		System.out.println(tree.numChildren(s)); next();
		
//		//STEP 4
		tree.set(p,"$$"); print();
		tree.set(s,"!!"); next();
	}
	private static <E> void print() {System.out.print(tree.size() + " "); Traversal.printParenthesized(tree);}
	private static <E> void next()  {System.out.println();}
}
