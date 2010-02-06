import java.util.ArrayList;

import junit.framework.*;

public class Testing extends TestCase {
	public static int points = 0;

	// //////// Testing insertion
	public void testSplits() {
		AATree<Integer> a = new AATree<Integer>();
		a.insert(1);
		a.insert(2);
		a.insert(3);
		a.insert(4);
		a.insert(5);
		a.insert(6);
		a.insert(7);

		ArrayList<Object> result = a.toArrayList();
		ArrayList<Object> values = new ArrayList<Object>();
		ArrayList<Object> levels = new ArrayList<Object>();
		values.add(4);
		values.add(2);
		values.add(1);
		values.add(3);
		values.add(6);
		values.add(5);
		values.add(7);
		levels.add(3);
		levels.add(2);
		levels.add(1);
		levels.add(1);
		levels.add(2);
		levels.add(1);
		levels.add(1);
		for (int i = 0; i < values.size(); i++) {
			assertEquals(values.get(i), ((AATree.BinaryNode) result.get(i))
					.getElement());
			assertEquals(levels.get(i), ((AATree.BinaryNode) result.get(i))
					.getLevel());
		}
		points += 15;
	}

	public void testSkewsandSplits() {
		AATree<Integer> a = new AATree<Integer>();
		a.insert(7);
		a.insert(6);
		a.insert(5);
		a.insert(4);
		a.insert(3);
		a.insert(2);
		a.insert(1);

		ArrayList<Object> result = a.toArrayList();
		ArrayList<Object> values = new ArrayList<Object>();
		ArrayList<Object> levels = new ArrayList<Object>();
		values.add(4);
		values.add(2);
		values.add(1);
		values.add(3);
		values.add(6);
		values.add(5);
		values.add(7);
		levels.add(3);
		levels.add(2);
		levels.add(1);
		levels.add(1);
		levels.add(2);
		levels.add(1);
		levels.add(1);
		for (int i = 0; i < values.size(); i++) {
			assertEquals(values.get(i), ((AATree.BinaryNode) result.get(i))
					.getElement());
			assertEquals(levels.get(i), ((AATree.BinaryNode) result.get(i))
					.getLevel());
		}
		points += 15;
	}

	// //////// Testing removal

	public void testRemovalofLeafs() {
		AATree<Integer> a = new AATree<Integer>();
		a.insert(1);
		a.insert(2);
		a.insert(3);
		a.insert(4);

		// testing removal of leaf, requiring no adjustments
		a.remove(4);

		ArrayList<Object> result = a.toArrayList();
		ArrayList<Object> values = new ArrayList<Object>();
		ArrayList<Object> levels = new ArrayList<Object>();
		values.add(2);
		values.add(1);
		values.add(3);
		levels.add(2);
		levels.add(1);
		levels.add(1);
		for (int i = 0; i < values.size(); i++) {
			assertEquals(values.get(i), ((AATree.BinaryNode) result.get(i))
					.getElement());
			assertEquals(levels.get(i), ((AATree.BinaryNode) result.get(i))
					.getLevel());
		}
		points += 3;

		// // testing removal of leaf, requiring level adjustment on right and
		// skew

		a.remove(3);

		result = a.toArrayList();
		values = new ArrayList<Object>();
		levels = new ArrayList<Object>();
		values.add(1);
		values.add(2);
		levels.add(1);
		levels.add(1);
		for (int i = 0; i < values.size(); i++) {
			assertEquals(values.get(i), ((AATree.BinaryNode) result.get(i))
					.getElement());
			assertEquals(levels.get(i), ((AATree.BinaryNode) result.get(i))
					.getLevel());
		}

		points += 3;

		// testing removal of leaf, requiring level adjustment on left, but no
		// skew
		a = new AATree<Integer>();
		a.insert(1);
		a.insert(2);
		a.insert(3);

		a.remove(1);

		result = a.toArrayList();
		values = new ArrayList<Object>();
		levels = new ArrayList<Object>();
		values.add(2);
		values.add(3);
		levels.add(1);
		levels.add(1);
		for (int i = 0; i < values.size(); i++) {
			assertEquals(values.get(i), ((AATree.BinaryNode) result.get(i))
					.getElement());
			assertEquals(levels.get(i), ((AATree.BinaryNode) result.get(i))
					.getLevel());
		}

		points += 3;
	}

	public void testRemovalofNodesWithOneChild() {
		AATree<Integer> a = new AATree<Integer>();
		// testing removal of node with one child, requiring no level adjustment
		a.insert(1);
		a.insert(2);
		a.insert(3);
		a.insert(4);
		a.remove(3);

		ArrayList<Object> result = a.toArrayList();
		ArrayList<Object> values = new ArrayList<Object>();
		ArrayList<Object> levels = new ArrayList<Object>();
		values.add(2);
		values.add(1);
		values.add(4);
		levels.add(2);
		levels.add(1);
		levels.add(1);
		for (int i = 0; i < values.size(); i++) {
			assertEquals(values.get(i), ((AATree.BinaryNode) result.get(i))
					.getElement());
			assertEquals(levels.get(i), ((AATree.BinaryNode) result.get(i))
					.getLevel());
		}

		points += 3;

		// testing removal of root which has no children
		a.remove(4);
		a.remove(2);
		a.remove(1);
		System.out.println(a);
		result = a.toArrayList();
		assertTrue(result.size() == 0);

		points += 3;
	}

	// testing removal of nodes with two children
	public void testRemovalofNodesWithTwoChildren() {
		AATree<Integer> a = new AATree<Integer>();
		a.insert(1);
		a.insert(2);
		a.insert(3);
		a.insert(4);
		a.insert(5);
		a.remove(4);

		ArrayList<Object> result = a.toArrayList();
		ArrayList<Object> values = new ArrayList<Object>();
		ArrayList<Object> levels = new ArrayList<Object>();
		values.add(2);
		values.add(1);
		values.add(3);
		values.add(5);
		levels.add(2);
		levels.add(1);
		levels.add(1);
		levels.add(1);
		for (int i = 0; i < values.size(); i++) {
			assertEquals(values.get(i), ((AATree.BinaryNode) result.get(i))
					.getElement());
			assertEquals(levels.get(i), ((AATree.BinaryNode) result.get(i))
					.getLevel());
		}

		points += 3;

		// // testing removal of root with two children
		a = new AATree<Integer>();
		a.insert(1);
		a.insert(2);
		a.insert(3);
		a.insert(4);
		a.remove(2);

		result = a.toArrayList();
		values = new ArrayList<Object>();
		levels = new ArrayList<Object>();
		values.add(3);
		values.add(1);
		values.add(4);
		levels.add(2);
		levels.add(1);
		levels.add(1);
		for (int i = 0; i < values.size(); i++) {
			assertEquals(values.get(i), ((AATree.BinaryNode) result.get(i))
					.getElement());
			assertEquals(levels.get(i), ((AATree.BinaryNode) result.get(i))
					.getLevel());
		}

		points += 3;
	}

	public void testFigure19point63() {
		AATree<Integer> a = new AATree<Integer>();
		a.insert(1);
		a.insert(2);
		a.insert(3);
		a.insert(5);
		a.insert(6);
		a.insert(7);
		a.insert(4);

		a.remove(1);

		ArrayList<Object> result = a.toArrayList();
		ArrayList<Object> values = new ArrayList<Object>();
		ArrayList<Object> levels = new ArrayList<Object>();
		values.add(3);
		values.add(2);
		values.add(5);
		values.add(4);
		values.add(6);
		values.add(7);

		levels.add(2);
		levels.add(1);
		levels.add(2);
		levels.add(1);
		levels.add(1);
		levels.add(1);

		for (int i = 0; i < values.size(); i++) {
			assertEquals(values.get(i), ((AATree.BinaryNode) result.get(i))
					.getElement());
			assertEquals(levels.get(i), ((AATree.BinaryNode) result.get(i))
					.getLevel());
		}

		points += 3;

		// testing same fig but removal of 2
		a = new AATree<Integer>();
		a.insert(1);
		a.insert(2);
		a.insert(3);
		a.insert(5);
		a.insert(6);
		a.insert(7);
		a.insert(4);

		a.remove(2);

		result = a.toArrayList();
		values = new ArrayList<Object>();
		levels = new ArrayList<Object>();
		values.add(3);
		values.add(1);
		values.add(5);
		values.add(4);
		values.add(6);
		values.add(7);

		levels.add(2);
		levels.add(1);
		levels.add(2);
		levels.add(1);
		levels.add(1);
		levels.add(1);

		for (int i = 0; i < values.size(); i++) {
			assertEquals(values.get(i), ((AATree.BinaryNode) result.get(i))
					.getElement());
			assertEquals(levels.get(i), ((AATree.BinaryNode) result.get(i))
					.getLevel());
		}
		points += 3;
	}

	public void testFigure2FromAAPaper() {
		AATree<Integer> a = new AATree<Integer>();
		a.insert(1);
		a.insert(2);
		a.insert(3);
		a.insert(4);
		a.insert(5);
		a.insert(6);
		a.insert(7);
		a.insert(8);
		a.insert(9);
		a.insert(10);
		a.insert(11);
		a.insert(12);
		a.insert(13);
		a.remove(7);
		a.insert(7);

		a.remove(1);

		ArrayList<Object> result = a.toArrayList();
		ArrayList<Object> values = new ArrayList<Object>();
		ArrayList<Object> levels = new ArrayList<Object>();
		values.add(6);
		values.add(4);
		values.add(2);
		values.add(3);
		values.add(5);
		values.add(10);
		values.add(8);
		values.add(7);
		values.add(9);
		values.add(12);
		values.add(11);
		values.add(13);

		levels.add(3);
		levels.add(2);
		levels.add(1);
		levels.add(1);
		levels.add(1);
		levels.add(3);
		levels.add(2);
		levels.add(1);
		levels.add(1);
		levels.add(2);
		levels.add(1);
		levels.add(1);

		for (int i = 0; i < values.size(); i++) {
			assertEquals(values.get(i), ((AATree.BinaryNode) result.get(i))
					.getElement());
			assertEquals(levels.get(i), ((AATree.BinaryNode) result.get(i))
					.getLevel());
		}
		points += 3;
	}

	public void testNothing() {
		System.out.println(points);
	}

	public static void main(String args[]) {
		junit.swingui.TestRunner.run(Testing.class);
	}
}
