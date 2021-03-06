package com.subrata.tree.core;
/**
 * Binary Search Tree implementation. 
 * @author Subrata Saha.
 *
 * @param <T>
 */
public class BinarySearchTree<T extends Comparable<T>> implements ITree<T> {
	
	protected TNode<T> root = null;
	protected TNode<T> levelNode = null;
	int size;

	public void addNode(T value) {
		TNode<T> newNode = new TNode<T>(value);
		
		if(root == null){
			root = newNode;
			size ++ ;
			//System.out.println("****** Subrata -> root ::"+newNode.getValue());
			return;
		}
		
		TNode<T> temp = root , prev = null;
		
		// Find the place where it need to be inserted.
		while(temp != null){
			prev = temp;
			if (value.compareTo(temp.value) < 0) {
				temp = temp.leftNode;
			}else if(value.compareTo(temp.value) > 0){
				temp = temp.rightNode;
			} else {
				temp = null;
				// loop terminating condition.
			}
		}
		
		// once inserted node is found put it in left or right.
		if(newNode.value.compareTo(prev.value) < 0){
			newNode.setParenNode(prev);
			prev.leftNode = newNode ;
			//System.out.println("****** Subrata ->  "+prev.getValue()+" left child is "+newNode.getValue());
			size ++ ;
		}else if(newNode.value.compareTo(prev.value) > 0){
			newNode.setParenNode(prev);
			prev.rightNode = newNode ;
			//System.out.println("****** Subrata ->  "+prev.getValue()+" right child is "+newNode.getValue());
			size ++ ;
		}else {
			//System.out.println("Neglecting the already inserted value ::"+value);
		}
	}
	
	public int getSize(){
		return size;
	}
}
