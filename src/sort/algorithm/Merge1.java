package sort.algorithm;

import java.util.*;

import sort.preSorting;
import sort.algorithm.algorithm.SampleSort;

public class Merge1 extends preSorting{

	public static int times = 0;
	public Merge1(String data) 
	{
		super(data);
		times = 0;
	}
	
	public void sort_number(List<Double> sort){
		int mid;
		List<Double> left=new ArrayList<>();
		List<Double> right=new ArrayList<>();
		if(sort.size()>1)
		{
			mid=sort.size()-sort.size()/2;
			for(int i=0;i<mid;i++)
				left.add(sort.get(i));
			for(int j=mid;j<sort.size();j++)
				right.add(sort.get(j));
			sort_number(left);
			sort_number(right);
			if(preSorting.selected_order_item.equals("Ascending"))
				Sort_number_asc(sort,left,right);
			else
				Sort_number_desc(sort,left,right);
		}
	}
	
	public void sort_text(List<String> sort){
		int mid;
		List<String> left=new ArrayList<>();
		List<String> right=new ArrayList<>();
		if(sort.size()>1){
			mid=sort.size()-sort.size()/2;
			for(int i=0;i<mid;i++)
				left.add(sort.get(i));
			for(int j=mid;j<sort.size();j++)
				right.add(sort.get(j));
			sort_text(left);
			sort_text(right);
			if(preSorting.selected_order_item.equals("Ascending"))
				Sort_text_asc(sort,left,right);
			else
				Sort_text_desc(sort,left,right);
		}
	}

	public void Sort_number_asc(List<Double> sort,List<Double> left,List<Double> right)
	{
		List<Double> temp=new ArrayList<>();
		int sortindex=0;
		int leftindex=0;
		int rightindex=0;
		while(leftindex<left.size()&&rightindex<right.size())
		{
			if(left.get(leftindex)<right.get(rightindex))
			{
				sort.set(sortindex,left.get(leftindex));
				leftindex++;
			}
			else
			{
				sort.set(sortindex,right.get(rightindex));
				rightindex++;
			}
			sortindex++;
		}
		int tempindex=0;
		if(leftindex>=left.size())
		{
			temp=right;
			tempindex=rightindex;
		}
		else
		{
			temp=left;
			tempindex=leftindex;
		}
		for(int i=tempindex;i<temp.size();i++)
		{
			sort.set(sortindex,temp.get(i));
			sortindex++;
		}
		dataStorage_number(sort,times);	
		times++;
	}

	public void Sort_number_desc(List<Double> sort,List<Double> left,List<Double> right)
	{
		List<Double> temp=new ArrayList<>();
		int sortindex=0;
		int leftindex=0;
		int rightindex=0;
		while(leftindex<left.size()&&rightindex<right.size())
		{
			if(left.get(leftindex)>right.get(rightindex)){
				sort.set(sortindex,left.get(leftindex));
				leftindex++;
			}else{
				sort.set(sortindex,right.get(rightindex));
				rightindex++;
			}
			sortindex++;
		}
		int tempindex=0;
		if(leftindex>=left.size()){
			temp=right;
			tempindex=rightindex;
		}else{
			temp=left;
			tempindex=leftindex;
		}
		for(int i=tempindex;i<temp.size();i++){
			sort.set(sortindex,temp.get(i));
			sortindex++;
		}
		dataStorage_number(sort,times);	
		times++;		
	}

	public void Sort_text_asc(List<String> sort,List<String> left,List<String> right){
		List<String> temp=new ArrayList<>();
		int sortindex=0;
		int leftindex=0;
		int rightindex=0;
		while(leftindex<left.size()&&rightindex<right.size()){
			if(left.get(leftindex).compareTo(right.get(rightindex))<0){
				sort.set(sortindex,left.get(leftindex));
				leftindex++;
			}else{
				sort.set(sortindex,right.get(rightindex));
				rightindex++;
			}
			sortindex++;
		}
		int tempindex=0;
		if(leftindex>=left.size()){
			temp=right;
			tempindex=rightindex;
		}else{
			temp=left;
			tempindex=leftindex;
		}
		for(int i=tempindex;i<temp.size();i++){
			sort.set(sortindex,temp.get(i));
			sortindex++;
		}
		dataStorage_text(sort,times);	
		times++;		
	}

	public void Sort_text_desc(List<String> sort,List<String> left,List<String> right){
		List<String> temp=new ArrayList<>();
		int sortindex=0;
		int leftindex=0;
		int rightindex=0;
		while(leftindex<left.size()&&rightindex<right.size()){
			if(left.get(leftindex).compareTo(right.get(rightindex))>0){
				sort.set(sortindex,left.get(leftindex));
				leftindex++;
			}else{
				sort.set(sortindex,right.get(rightindex));
				rightindex++;
			}
			sortindex++;
		}
		int tempindex=0;
		if(leftindex>=left.size()){
			temp=right;
			tempindex=rightindex;
		}else{
			temp=left;
			tempindex=leftindex;
		}
		for(int i=tempindex;i<temp.size();i++){
			sort.set(sortindex,temp.get(i));
			sortindex++;
		}
		dataStorage_text(sort,times);	
		times++;     		
	}
}
