import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;


public class GridLandMetro {

	public void tester(){
		point one = new point(1, 3);
		point two = new point(2, 7);
		point three = new point(9, 10);
		point four = new point(2, 6);
		PriorityQueue<point> newLL = new PriorityQueue<point>(); 
		LinkedList<point> newLL2 = new LinkedList<point>(); 
		newLL.add(one);
		newLL.add(two);
		newLL.add(three);
		newLL.add(four);
		
		while (newLL.size() >1){
			point point1 = newLL.poll();
			point point2 = newLL.poll();
			if (point2.start > point1.end){
				newLL.add(point2);
				newLL2.add(point1);
			}else if (point2.end <= point1.end){
				newLL.add(point1);
			}else if (point2.start <= point1.end){			
				point newP = new point(point1.start, point2.end);
				newLL.add(newP);
			}else {
				
			}
		}
		
		newLL2.add(newLL.poll());
		
		int size =0;
		while (!newLL2.isEmpty()){
			point cur = newLL2.pop();
			size += cur.end- cur.start +1;
		}
		
		System.out.println(size);
		
		
		
	}
	
	class point implements Comparable<point> {
		public point(long start,long end){
			this.start = start;
			this.end = end;
		}
		public long start;
		public long end;
		@Override
		public int compareTo(point o) {
			return (int)(start - o.start);
		}
		
	}
	public void doIt(){
		Scanner in = new Scanner(System.in);
		long rowSize = in.nextInt();
		long columnSize = in.nextInt();
		int numOfTracks = in.nextInt();
		
		//int[] cityState =   new int[columnSize] ;
		
		HashMap<Integer, PriorityQueue<point>> HM = new HashMap<Integer,PriorityQueue<point>>();
		
		long trackSize = 0;
		for (int i = 0 ; i< numOfTracks;i++){
			int trackRowNumber = in.nextInt();
			int trackStart = in.nextInt();
			int trackEnd = in.nextInt();
			point newPoint = new point(trackStart,trackEnd);

			PriorityQueue<point> newLL;
			if (!HM.containsKey(trackRowNumber)){
				newLL = new PriorityQueue<point>();
				HM.put(trackRowNumber, newLL);
			}else {
				newLL = HM.get(trackRowNumber);
			}
			newLL.add(newPoint);
		}
		
		for (Entry<Integer, PriorityQueue<point>> entry : HM.entrySet())
		{
			PriorityQueue<point> TrainLine=  entry.getValue();
			LinkedList<point> newLL2 = new LinkedList<point>(); 
			while (TrainLine.size() >1){
				point point1 = TrainLine.poll();
				point point2 = TrainLine.poll();
				if (point2.start > point1.end){
					TrainLine.add(point2);
					newLL2.add(point1);
				}else if (point2.end <= point1.end){
					TrainLine.add(point1);
				}else if (point2.start <= point1.end){			
					point newP = new point(point1.start, point2.end);
					TrainLine.add(newP);
				}else {
					
				}
			}
			
			newLL2.add(TrainLine.poll());
			
			while (!newLL2.isEmpty()){
				point cur = newLL2.pop();
				trackSize += cur.end- cur.start +1;
			}
		}
		
		long size = rowSize * columnSize;
		System.out.println(size- trackSize);
	}
	public static void main(String[] args) {
		GridLandMetro me = new GridLandMetro();
		me.doIt();	
		
	}
}
