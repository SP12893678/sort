import java.util.ArrayList;
import java.util.List;
import java.util.*;


public class Quicksortnumup {

	public static List<Double> quicksort(List<Double> sort){
		
		if(sort.size() <= 1){
			return sort;
		}
		int middle=sort.size()-sort.size()/2;
		double pivot=sort.get(middle);

		List<Double> less=new ArrayList<Double>();
		List<Double> greater=new ArrayList<Double>();
		
		for (int i=0;i<sort.size(); i++) {
			if(sort.get(i) <= pivot){
				if(i==middle){
					continue;
				}
				less.add(sort.get(i));
			}
			else{
				greater.add(sort.get(i));
			}
		}
		return quick(quicksort(less), pivot, quicksort(greater));
	}
	
	public static List<Double> quick(List<Double> less, double pivot, List<Double> greater){
		
		List<Double> list=new ArrayList<Double>();
		
		for (int i=0;i<less.size(); i++) {
			list.add(less.get(i));
		}
		
		list.add(pivot);
		
		for (int i=0;i<greater.size(); i++) {
			list.add(greater.get(i));
		}
		
		return list;
	}
	public static void Addn(String str,List<Double> sort){
        StringTokenizer strt = new StringTokenizer(str," []\t\n\r");
        
        while(strt.hasMoreTokens()){
               sort.add(Double.parseDouble(strt.nextToken()));
        }

    }
	public static void main(String[] args) {

		List<Double> sort = new ArrayList<Double>();
		Scanner what=new Scanner(System.in);
		String s=what.nextLine();
		Addn(s,sort);
		quicksort(sort);
	    
	}
}
