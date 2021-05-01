package sort;

import java.util.*;

import component.EssentialComponent;
import gui.DisplayPanel;
import gui.MainFrame;
import listener.function.Submit;
import sort.algorithm.*;
import sort.algorithm.algorithm.SampleSort;


public class Sorting{

	public static int line;
	public int times = 0;
	String data;
	Timer timer = new Timer();
	Display time = new Display();
	static SampleSort sort;
	public Sorting(String data) 
	{
		this.data = data;
		line = 0;
		newsort();
		RunSort(0);
		showProcess();
	}

	public void RunSort(int i)
	{
		for (; i < sort.getDataSize(); i++)
		{
			if(Submit.is_pause)
			{
				times = i;
				break;
			}
			runSort(i);
		}
		times = i;
	}
	public void showProcess()
	{
		if(!Submit.is_pause)
		{
			timer = new Timer();
			time = new Display();
			Submit.is_pause = false;
			Submit.is_submit = false;
			timer.schedule(time, 1000, 1500);
		}
	}

	public void skip()
	{
		Submit.is_pause = false;
		timer = new Timer();
		time = new Display();
		timer.schedule(time, 10, 10);
	}

	public void newsort()
	{
		switch (preSorting.selected_algorithm_item) 
		{
			case "Insertion":
				sort = new Insertion(data);
				break;
			case "Selection":
				sort = new Selection(data);
				break;
			case "Bubble":
				sort = new Bubble(data);
				break;
			case "Merge":
				sort = new Merge(data);
				break;
			case "Quick":
				sort = new Quick(data);
				break;
			default:
				break;
		}
	}
	
	public static Object getSortData(int line,int pos)
	{
		return sort.getSortData(line, pos);
	}
	
	protected void runSort(int times) {
		switch (preSorting.selected_ioFilter_item) 
		{
			case "Number":
				//DisplayPanel.trypan.getSortData(sort.getDataSize());
				switch (preSorting.selected_order_item) 
				{
					case "Ascending":
						sort.Sort_number_asc(times);
						break;
					case "Descending":
						sort.Sort_number_desc(times);
						break;
					default:
						break;
				}
				break;
			case "Text":
				//DisplayPanel.trypan.getSorttext(sort.getDataSize());
				switch (preSorting.selected_order_item) 
				{
					case "Ascending":
						sort.Sort_text_asc(times);
						break;
					case "Descending":
						sort.Sort_text_desc(times);
						break;
					default:
						break;
				}
				break;
			default:
				break;
		}
	}

	public class Display extends TimerTask {
		@Override
		public void run() 
		{
			String Data = "";
			for (int w = 0; w < sort.getDataSize(); w++)
			{
				if(sort.getSortData(line,w)!=null)
					EssentialComponent.displayarea.append(sort.getSortData(line, w) + " ");
				Data += sort.getSortData(line, w) + " ";
			}	
			EssentialComponent.displayarea.append("|\t     ");
			EssentialComponent.displayarea.append("\n");
			
			DisplayPanel.trypan.setData(Data);
        	DisplayPanel.trypan.hasData = true;
			DisplayPanel.trypan.updateUI();
			line++;
			if (line >= Submit.sort_text.size() || Submit.is_pause || Submit.is_interrupt) 
			{
				timer.cancel();
				Submit.NormalStatus();
				MainFrame.finishSound.playSound();
				return;
			}
		}
	}
}
