package sort.algorithm;

import sort.preSorting;
import sort.algorithm.algorithm.SampleSort;

public class Insertion extends preSorting implements SampleSort {

	private double temp_num, change_num;
	private String temp_text, change_text;
	private boolean change;
	public Insertion(String data)
	{
		super(data);
		change = false;
	}

	public void Sort_number_asc(int times) 
	{
		// https://youtu.be/OGzPmgsI-pQ
		temp_num = sort_num.get(times); // 動作：將被選取的數據移到暫存
		for (int j = 0; j < times; j++) 
		{
			if (sort_num.get(j) > temp_num) 
			{
				change_num = sort_num.get(j);
				change = true;
				for (int x = times; x > j; x--) 
				{
					sort_num.set(x, sort_num.get(x - 1)); // 動作：將(x-1)位置的數據移到(x)位置 [for迴圈]
				}
				sort_num.set(j, temp_num); // 動作：將暫存的數據移到選定的位置(J)
				break;
			}
		}
		dataStorage_number(sort_num, times);
		changePart_number(change, times, change_num, temp_num);
	}

	public void Sort_number_desc(int times) 
	{
		temp_num = sort_num.get(times);
		for (int j = 0; j < times; j++) 
		{
			if (sort_num.get(j) < temp_num) 
			{
				change_num = sort_num.get(j);
				change = true;
				for (int x = times; x > j; x--) 
				{
					sort_num.set(x, sort_num.get(x - 1));
				}
				sort_num.set(j, temp_num);
				break;
			}
		}
		dataStorage_number(sort_num,times);
		changePart_number(change, times, change_num, temp_num);
	}

	public void Sort_text_asc(int times) 
	{
		temp_text = sort_text.get(times);
		for (int j = 0; j < times; j++)
		{
			if (sort_text.get(j).compareTo(temp_text) > 0) 
			{
				change_text = sort_text.get(j);
				change = true;
				for (int x = times; x > j; x--) 
				{
					sort_text.set(x, sort_text.get(x - 1));
				}
				sort_text.set(j, temp_text);
				break;
			}
		}
		dataStorage_text(sort_text,times);
		changePart_text(change, times, change_text, temp_text);
	}

	public void Sort_text_desc(int times) 
	{
		temp_text = sort_text.get(times);
		for (int j = 0; j < times; j++) 
		{
			if (sort_text.get(j).compareTo(temp_text) < 0) 
			{
				change_text = sort_text.get(j);
				change = true;
				for (int x = times; x > j; x--) 
				{
					sort_text.set(x, sort_text.get(x - 1));
				}
				sort_text.set(j, temp_text);
				break;
			}
		}
		dataStorage_text(sort_text,times);
		changePart_text(change, times, change_text, temp_text);
	}

	public int getDataSize() {
		return dataSize;
	}

	public String getSortData(int times,int num)
	{
		return sortData[times][num];
	}
}
