public class AATree<T extends Comparable<? super T>> {
	
	
	private class BinaryNode {

		private T element;
		private BinaryNode leftChild;
		private BinaryNode rightChild;
		private int height;
		private boolean balance;

		public BinaryNode(T e) {
			element = e;
			height = 0;
			leftChild = rightChild = null;
		}

		private boolean insert(T element2) {
			if (element.compareTo(element2) > 0) {
				if (leftChild == null) {
					leftChild = new BinaryNode(element2);
					//size++;
					updateHeight();
					return true;
				} else {
					boolean temp = leftChild.insert(element2);
					checkHeight();
					updateHeight();
					return temp;
				}
			} else if (element.compareTo(element2) < 0) {
				if (rightChild == null) {
					rightChild = new BinaryNode(element2);
					//size++;
					updateHeight();
					return true;
				} else {
					boolean temp = rightChild.insert(element2);
					checkHeight();
					updateHeight();
					return temp;
				}
			} else {
				return false;
			}
		}

		public String toString() {
			String s = "[" + element + " "
					+ ((leftChild == null) ? null : leftChild.element) + " "
					+ ((rightChild == null) ? null : rightChild.element)
					+ "]\n";
			if (leftChild != null) {
				s += leftChild.toString();
			}
			if (rightChild != null) {
				s += rightChild.toString();
			}
			return s;
		}

		public Object[] toArray(Object[] list, int index) {
			if (leftChild != null) {
				list = leftChild.toArray(list, index++);
				// index++;
			}
			list[index] = element;
			if (rightChild != null) {
				index++;
				list = rightChild.toArray(list, index);

			}
			return list;
		}

		public boolean find(T e) {
			int compare = e.compareTo(element);
			if (compare == 0) {
				return true;
			}
			if (compare > 0 && rightChild != null) {
				return rightChild.find(e);
			}
			if (compare < 0 && leftChild != null) {
				return leftChild.find(e);
			}
			return false;
		}

		public void checkHeight() {
			int rightheight = 0;
			if (rightChild != null) {
				rightheight = rightChild.height() + 1;
			}
			int leftheight = 0;
			if (leftChild != null) {
				leftheight = leftChild.height() + 1;
			}
			if (Math.abs(leftheight - rightheight) == 2) {
				this.balance = false;
			} else {
				this.balance = true;
			}
		}

		public void updateHeight() {
			if (rightChild == null && leftChild == null) {
				this.height = 0;
			} else if (rightChild == null) {
				this.height = 1 + leftChild.height();
			} else if (leftChild == null) {
				this.height = 1 + rightChild.height();
			} else {
				int leftheight = 0, rightheight = 0;
				if (leftChild != null) {
					leftheight = 1 + leftChild.height();
				}
				if (rightChild != null) {
					rightheight = 1 + rightChild.height();
				}
				if (leftheight > rightheight) {
					this.height = leftheight;
				} else {
					this.height = rightheight;
				}
			}
		}

		public boolean getBalance() {
			return balance;
		}

		public int height() {
			return height;
		}
	}
}
