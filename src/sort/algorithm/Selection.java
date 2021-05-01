package sort.algorithm;

import sort.preSorting;
import sort.algorithm.algorithm.SampleSort;

public class Selection extends preSorting implements SampleSort {

	public static int smallestindex;
	public static double temp_num, change_num;
	public static String temp_text, change_text;
	public static boolean change;
	public Selection(String data) 
	{
		super(data);
		change = false;
	}

	public void Sort_number_asc(int curindex) 
	{
		temp_num = sort_num.get(curindex);
		smallestindex = curindex;
		for (int i = curindex + 1; i < sort_num.size(); i++) 
		{
			if (temp_num > sort_num.get(i)) 
			{
				temp_num = sort_num.get(i);
				smallestindex = i;
			}
		}

		if (smallestindex != curindex)
		{
			change_num = sort_num.get(smallestindex);
			change = true;
			temp_num = sort_num.get(curindex);	
			sort_num.set(curindex, sort_num.get(smallestindex));
			sort_num.set(smallestindex, temp_num);
		}
		temp_num = sort_num.get(smallestindex);
		dataStorage_number(sort_num, curindex);
		changePart_number(change, curindex, change_num, temp_num);
	}

	public void Sort_number_desc(int curindex) 
	{
		temp_num = sort_num.get(curindex);
		smallestindex = curindex;
		for (int i = curindex + 1; i < sort_num.size(); i++) 
		{
			if (temp_num < sort_num.get(i)) 
			{
				temp_num = sort_num.get(i);
				smallestindex = i;
			}
		}

		if (smallestindex != curindex)
		{
			change_num = sort_num.get(smallestindex);
			change = true;
			temp_num = sort_num.get(curindex);
			sort_num.set(curindex, sort_num.get(smallestindex));
			sort_num.set(smallestindex, temp_num);
		}
		temp_num = sort_num.get(smallestindex);
		dataStorage_number(sort_num, curindex);	
		changePart_number(true, curindex, change_num, temp_num);
	}

	public void Sort_text_asc(int curindex) 
	{
		temp_text = sort_text.get(curindex);
		smallestindex = curindex;
		for (int i = curindex + 1; i < sort_num.size(); i++) 
		{
			if (sort_text.get(i).compareTo(temp_text) < 0) 
			{
				temp_text = sort_text.get(i);
				smallestindex = i;
			}
		}

		if (smallestindex != curindex)
		{
			change_text = sort_text.get(smallestindex);
			change = true;
			temp_text = sort_text.get(curindex);
			sort_text.set(curindex, sort_text.get(smallestindex));
			sort_text.set(smallestindex, temp_text);
		}
		temp_text = sort_text.get(smallestindex);
		dataStorage_text(sort_text, curindex);
		changePart_text(change, curindex, change_text, temp_text);
	}

	public void Sort_text_desc(int curindex) 
	{
		temp_text = sort_text.get(curindex);
		smallestindex = curindex;
		for (int i = curindex + 1; i < sort_text.size(); i++) 
		{
			if (sort_text.get(i).compareTo(temp_text) > 0) 
			{
				temp_text = sort_text.get(i);
				smallestindex = i;
			}
		}

		if (smallestindex != curindex)
		{
			change_text = sort_text.get(smallestindex);
			change = true;
			temp_text = sort_text.get(curindex);
			sort_text.set(curindex, sort_text.get(smallestindex));
			sort_text.set(smallestindex, temp_text);
		}
		temp_text = sort_text.get(smallestindex);
		dataStorage_text(sort_text, curindex);
		changePart_text(change, curindex, change_text, temp_text);
	}
	
	public int getDataSize() {
		return dataSize;
	}
	
	public String getSortData(int times, int num) {
		return sortData[times][num];
	}
}
