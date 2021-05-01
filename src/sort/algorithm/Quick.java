package sort.algorithm;

import java.util.ArrayList;
import java.util.List;

import sort.preSorting;
import sort.algorithm.algorithm.SampleSort;


public class Quick extends preSorting implements SampleSort {

	public Quick(String data) 
	{
		super(data);
	}

	@Override
	public void Sort_number_asc(int times)
	{
		dataStorage_number(Sort_number_asc(sort_num), times);
	}
	
	@Override
	public void Sort_number_desc(int times)
	{
		dataStorage_number(Sort_number_desc(sort_num), times);
	}
	
	@Override
	public void Sort_text_asc(int times)
	{
		dataStorage_text(Sort_text_asc(sort_text),times);
	}
	
	@Override
	public void Sort_text_desc(int times)
	{
		dataStorage_text(Sort_text_desc(sort_text),times);
	}
	
	public List<Double> Sort_number_asc(List<Double> sort){
		
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
		return quick(Sort_number_asc(less), pivot, Sort_number_asc(greater));
	}
	
	public List<Double> Sort_number_desc(List<Double> sort){
		
		if(sort.size() <= 1){
			return sort;
		}
		int middle=sort.size()-sort.size()/2;
		double pivot=sort.get(middle);

		List<Double> less=new ArrayList<Double>();
		List<Double> greater=new ArrayList<Double>();
		
		for (int i=0;i<sort.size(); i++) {
			if(sort.get(i) >= pivot){
				if(i==middle){
					continue;
				}
				less.add(sort.get(i));
			}
			else{
				greater.add(sort.get(i));
			}
		}
		return quick(Sort_number_desc(less), pivot, Sort_number_desc(greater));
	}
	
	public List<String> Sort_text_asc(List<String> sort){
		
		if(sort.size() <= 1){
			return sort;
		}
		int middle=sort.size()-sort.size()/2;
		String pivot=sort.get(middle);

		List<String> less=new ArrayList<String>();
		List<String> greater=new ArrayList<String>();
		
		for (int i=0;i<sort.size(); i++) {
			if(sort.get(i).compareTo(pivot)<=0){
				if(i==middle){
					continue;
				}
				less.add(sort.get(i));
			}
			else{
				greater.add(sort.get(i));
			}
		}
		return quick(Sort_text_asc(less), pivot, Sort_text_asc(greater));
	}
	
	public List<String> Sort_text_desc(List<String> sort){
		
		if(sort.size() <= 1){
			return sort;
		}
		int middle=sort.size()-sort.size()/2;
		String pivot=sort.get(middle);

		List<String> less=new ArrayList<String>();
		List<String> greater=new ArrayList<String>();
		
		for (int i=0;i<sort.size(); i++) {
			if(sort.get(i).compareTo(pivot)>=0){
				if(i==middle){
					continue;
				}
				less.add(sort.get(i));
			}
			else{
				greater.add(sort.get(i));
			}
		}
		return quick(Sort_text_desc(less), pivot, Sort_text_desc(greater));
	}
	
	private List<Double> quick(List<Double> less, double pivot, List<Double> greater){
		
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
	
	private List<String> quick(List<String> less, String pivot, List<String> greater){
		
		List<String> list=new ArrayList<String>();
		
		for (int i=0;i<less.size(); i++) {
			list.add(less.get(i));
		}
		
		list.add(pivot);
		
		for (int i=0;i<greater.size(); i++) {
			list.add(greater.get(i));
		}
		
		return list;
	}

	public int getDataSize() {
		return dataSize;
	}

	public String getSortData(int times,int num)
	{
		return sortData[times][num];
	}

}
