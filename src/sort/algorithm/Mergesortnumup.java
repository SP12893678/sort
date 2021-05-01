import java.util.List;
import java.util.ArrayList;
import java.lang.*;
import java.util.*;
 
public class Mergesortnumup {


    public static void sort(List<Double> sort){
		
		List<Double> temp=new ArrayList<Double>();
		for(int asize=0;asize<10000000;asize++){
			double zero=0;
			temp.add(zero);
		}
        int n=sort.size();
        int length=1;
        while(length<n){
			mergepass(sort,temp,n,length);
			length*=2;
			mergepass(temp,sort,n,length);
			length*=2;
		} 		
	}
	public static void mergepass(List<Double> list,List<Double> sorted,int n,int length){
		int i,j;
		for(i=0;i<=n-2*length;i+=2*length)
			merge(list,sorted,i,i+length-1,i+2*length-1);
		if(i+length<n)
			merge(list,sorted,i,i+length-1,n-1);
		else
			for(j=i;j<n;j++)
				sorted.set(j,list.get(j));
	}
	public static void merge(List<Double> list,List<Double> sorted,int i,int m,int n){
		int j,k,t;
		j=m+1;
		k=i;
		
		while(i<=m&&j<=n){
			
			if(list.get(i)<=list.get(j))
				sorted.set(k++,list.get(i++));
			    
			else
				sorted.set(k++,list.get(j++));
		}
		if(i>m)
			for(t=j;t<=n;t++)
				sorted.set(k+t-j,list.get(t));
			else
				for(t=i;t<=m;t++)
					sorted.set(k+t-i,list.get(t));
				
	}
	public static void Addn(String str,List<Double> sort){
        StringTokenizer strt = new StringTokenizer(str," []\t\n\r");
        
        while(strt.hasMoreTokens()){
               sort.add(Double.parseDouble(strt.nextToken()));
        }

    }
	public static void main(String[] args){
		List<Double> sort = new ArrayList<Double>(100000);

		Scanner what=new Scanner(System.in);
		String s=what.nextLine();
		Addn(s,sort);
		sort(sort);
		for(int w=0;w<sort.size();w++){
		if(sort.get(w)==Math.floor(sort.get(w))){
					System.out.print(sort.get(w).intValue()+" ");
				}
				else{
				System.out.print(sort.get(w)+" ");
			    }
		}
	}
}
