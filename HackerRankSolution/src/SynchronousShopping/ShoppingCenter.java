package SynchronousShopping;

import java.util.LinkedList;

public class ShoppingCenter {
	public int ID;
	public LinkedList<Road> Neighbor;
	public LinkedList<Integer> fishSell;
	public ShoppingCenter(int id){
		ID = id;
		Neighbor = new LinkedList<Road>();
		fishSell = new LinkedList<Integer>();
	}
}
