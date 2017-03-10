package com.aino.training.address;

import java.io.Serializable;

@SuppressWarnings("serial")
public class List <T extends Serializable> implements Serializable{
	Node<T> firstNode;
	
	public List() {
		this.firstNode = null;
	}

	void addNode(T a){
		if(firstNode == null){
			firstNode = new Node<T>(a, null, null);
			return ;
		}
		Node<T> last = getLast();
		last.next = new Node<T>(a,last,null);
	}

	Node<T> getLast() {
		Node<T> t = firstNode;
		
		while(t.next != null){
			t = t.next;
		}
		return t;
	}

	void display() {
		Node<T> t = firstNode;
		
		while(t != null){
			System.out.println(t.data.toString());
			t = t.next;
		}
	}
	
	boolean removeNode(T a){
		/*if list is empty*/
		if(firstNode == null){
			System.out.println("List is empty.. Remove operation cannot be performed");
			return false;
		}
		else
		{
			/*find the node in the list*/
			Node<T> temp = getNode(a);
			
			if(temp == null){
				System.out.println("Node not found");
			}
			else{
				/*if node is first node*/
				if(temp == firstNode){
					firstNode = firstNode.next;
					firstNode.prev = null;
					
				}
				
				/*if node is intermediate node*/
				else if(temp.next !=null){
					temp.prev.next = temp.next;
					temp.next.prev = temp.prev;
				}
				
				/*if node is last node*/
				else{
					temp.prev.next = null;
				}
			}
		}
		return true;
	}
	
	private Node<T> getNode(T a) {
		Node<T> currentNode = firstNode;
		
		/*iterate till we find any match*/
		while(currentNode.data != a && currentNode.next != null){
			currentNode =currentNode.next; 
		}
		/*loop will end in two cases. 
		 * Either if the actual match is found OR
		 * if the list ends. 
		 */
		
		/*if actual match is found*/
		if(currentNode.data == a){
			return currentNode;
		}
		return null;
	}

	public T searchNode(String id) {
		Node<T> temp = firstNode;
//		T a = temp.data.getData(id);
		while(temp != null){
			if(temp.data.equals(id)){
				return temp.data;
			}
			temp = temp.next;
		}
		return null;			
	}
}

@SuppressWarnings("serial")
class Node<T extends Serializable> implements Serializable{
	T data;
	Node<T> prev, next;
	
	Node(){
		
	}
	
	public Node(T data, Node<T> prev, Node<T> next) {
		super();
		this.data = data;
		this.prev = prev;
		this.next = next;
	}
}