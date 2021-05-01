package sort.algorithm;

import java.util.List;

import sort.preSorting;
import sort.algorithm.algorithm.SampleSort;

import java.util.ArrayList;
 
public class Merge extends preSorting implements SampleSort{


    public Merge(String data) {
		super(data);

	}
     
    @Override
	public void Sort_number_asc(int times)
	{
    	if(times<1)
    		sort_number(sort_num);
		dataStorage_number(sort_num, times);
	}
	
	@Override
	public void Sort_number_desc(int times)
	{
		if(times<1)
			sort_number(sort_num);
		dataStorage_number(sort_num, times);
	}
	
	@Override
	public void Sort_text_asc(int times)
	{
		if(times<1)
			sort_text(sort_text);
		dataStorage_text(sort_text,times);
	}
	
	@Override
	public void Sort_text_desc(int times)
	{
		if(times<1)
			sort_text(sort_text);
		dataStorage_text(sort_text,times);
	}

	public void sort_number(List<Double> sort){
		
		List<Double> temp=new ArrayList<Double>();
		for(int asize=0;asize<10000000;asize++){
			double zero=0;
			temp.add(zero);
		}
        int n=sort.size();
        int length=1;
        while(length<n){
        	number_mergepass(sort,temp,n,length);
			length*=2;
			number_mergepass(temp,sort,n,length);
			length*=2;
		}
	}
	
	public void sort_text(List<String> sort){
		
		List<String> temp=new ArrayList<String>();
		for(int asize=0;asize<10000000;asize++){
			String zero="a";
			temp.add(zero);
		}
        int n=sort.size();
        int length=1;
        while(length<n){
        	text_mergepass(sort,temp,n,length);
			length*=2;
			text_mergepass(temp,sort,n,length);
			length*=2;
		} 		
	}
    
	public void number_mergepass(List<Double> list,List<Double> sorted,int n,int length){
		int i,j;
		for(i=0;i<=n-2*length;i+=2*length)
		{
			if(preSorting.selected_order_item.equals("Ascending"))
				Sort_number_asc(list,sorted,i,i+length-1,i+2*length-1);
			else
				Sort_number_desc(list,sorted,i,i+length-1,i+2*length-1);
		}	
		if(i+length<n)
		{
			if(preSorting.selected_order_item.equals("Ascending"))
				Sort_number_asc(list,sorted,i,i+length-1,n-1);
			else
				Sort_number_desc(list,sorted,i,i+length-1,n-1);
		}
		else
			for(j=i;j<n;j++)
				sorted.set(j,list.get(j));
	}
	
	public void text_mergepass(List<String> list,List<String> sorted,int n,int length){
		int i,j;
		for(i=0;i<=n-2*length;i+=2*length)
		{
			if(preSorting.selected_order_item.equals("Ascending"))
				Sort_text_asc(list,sorted,i,i+length-1,i+2*length-1);
			else
				Sort_text_desc(list,sorted,i,i+length-1,i+2*length-1);
		}
		if(i+length<n)
		{
			if(preSorting.selected_order_item.equals("Ascending"))
				Sort_text_asc(list,sorted,i,i+length-1,n-1);
			else
				Sort_text_desc(list,sorted,i,i+length-1,n-1);
		}
		else
			for(j=i;j<n;j++)
				sorted.set(j,list.get(j));
	}
	
	public void Sort_number_asc(List<Double> list,List<Double> sorted,int i,int m,int n){
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
	
	public void Sort_number_desc(List<Double> list,List<Double> sorted,int i,int m,int n){
		int j,k,t;
		j=m+1;
		k=i;
		
		while(i<=m&&j<=n){
			
			if(list.get(i)>=list.get(j))
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
	
	public void Sort_text_asc(List<String> list,List<String> sorted,int i,int m,int n){
		int j,k,t;
		j=m+1;
		k=i;
		
		while(i<=m&&j<=n){
			
			if(list.get(i).compareTo(list.get(j))<0)
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
	
	public void Sort_text_desc(List<String> list,List<String> sorted,int i,int m,int n){
		int j,k,t;
		j=m+1;
		k=i;
		
		while(i<=m&&j<=n){
			
			if(list.get(i).compareTo(list.get(j))>0)
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

	public int getDataSize() {
		return dataSize;
	}

	public String getSortData(int times,int num)
	{
		return sortData[times][num];
	}
}
