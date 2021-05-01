package sort.algorithm;

import sort.preSorting;
import sort.algorithm.algorithm.SampleSort;
public class Bubble extends preSorting implements SampleSort {
	double temp_num;
	String temp;
	public Bubble(String data) 
	{
		super(data);
	}

	public void Sort_number_asc(int times) 
	{
		for (int j = 0; j < sort_num.size() - 1; j++) 
		{
			if (sort_num.get(j) > sort_num.get(j + 1)) 
			{
				temp_num = sort_num.get(j);
				sort_num.set(j, sort_num.get(j + 1));
				sort_num.set(j + 1, temp_num);
			}
		}
		dataStorage_number(sort_num, times);
	}

	public void Sort_number_desc(int times) 
	{
		for (int j = 0; j < sort_num.size() - 1; j++) 
		{
			if (sort_num.get(j) < sort_num.get(j + 1)) 
			{
				temp_num = sort_num.get(j);
				sort_num.set(j, sort_num.get(j + 1));
				sort_num.set(j + 1, temp_num);
			}
		}
		dataStorage_number(sort_num, times);
	}

	public void Sort_text_asc(int times) 
	{
		for (int j = 0; j < sort_text.size() - 1; j++) 
		{
			if (sort_text.get(j).compareTo(sort_text.get(j + 1)) > 0) 
			{
				temp = sort_text.get(j);
				sort_text.set(j, sort_text.get(j + 1));
				sort_text.set(j + 1, temp);
			}
		}
		dataStorage_text(sort_text, times);
	}

	public void Sort_text_desc(int times) 
	{
		for (int j = 0; j < sort_text.size() - 1; j++) 
		{
			if (sort_text.get(j).compareTo(sort_text.get(j + 1)) < 0) 
			{
				temp = sort_text.get(j);
				sort_text.set(j, sort_text.get(j + 1));
				sort_text.set(j + 1, temp);
			}
		}
		dataStorage_text(sort_text, times);
	}
	
	public int getDataSize() {
		return dataSize;
	}
	
	public String getSortData(int times, int num) {
		return sortData[times][num];
	}
}
