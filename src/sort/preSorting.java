package sort;

import java.util.*;

public class preSorting {

	public static String selected_ioFilter_item = "Number";
    public static String selected_order_item = "Ascending";
    public static String selected_algorithm_item = "Insertion";
    public List<Double> sort_num = new ArrayList<Double>();
    public List<String> sort_text = new ArrayList<String>();
    public String[][] sortData;
    public String[] compareData;
    public int dataSize;
    public preSorting(String data)
    {
        switch (selected_ioFilter_item) 
        {
            case "Number":
                Addn_num(data, sort_num);
                setDataSize_number(sort_num);
                break;
            case "Text":
                Addn_text(data, sort_text);
                setDataSize_text(sort_text);
                break;
            default:
                break;
        }
    }
	public static void Addn_num(String str, List<Double> data)
	{
		StringTokenizer strt = new StringTokenizer(str, " []\t\n\r");
		while (strt.hasMoreTokens())
		{
			data.add(Double.parseDouble(strt.nextToken()));
		}
	}

	public static void Addn_text(String str, List<String> data)
	{
		StringTokenizer strt = new StringTokenizer(str, " []\t\n\r");
		while (strt.hasMoreTokens())
		{
			data.add(strt.nextToken());
		}
	}

	public static boolean isFloat(List<String> data)
    {
        try
        {
            for (int j = 0; j < data.size(); j++)
                Float.parseFloat(data.get(j));
        }
        catch (Exception e)
        {
            return false;
        }
        return true;
	}
	
	public static boolean detect_ioFilter(List<String> data)
    {
        if(data==null || data.isEmpty())
            return false;
        else if(isFloat(data) && selected_ioFilter_item.equals("Number"))
            return true;
        else if(selected_ioFilter_item.equals("Text"))
            return true;
        else
            return false;
    }

    public void setDataSize_number(List<Double> data)
    {
        dataSize = data.size();
        sortData = new String[dataSize][dataSize];
        compareData = new String[dataSize];
    }

    public void setDataSize_text(List<String> data)
    {
        dataSize = data.size();
        sortData = new String[dataSize][dataSize];
        compareData = new String[dataSize];
    }

    public void dataStorage_number(List<Double> data,int times)
    {
        for(int w=0;w<data.size();w++)
        {
            if(data.get(w)==Math.floor(data.get(w)))
                sortData[times][w] = Integer.toString(data.get(w).intValue());
            else
                sortData[times][w] = Double.toString(data.get(w));
        }
    }

    public void changePart_number(boolean change,int times,double change_num,double temp_num)
    {
        String tmp="";
        if(change)
		{
			int change_int = (int) change_num;
			int temp_int = (int) temp_num;
			if(temp_int==temp_num)
                tmp += temp_int;
			else
                tmp += temp_num;
            /*-----------------------------------------*/
            if(selected_algorithm_item.equals("Selection"))
                tmp += " <-> ";
            else if(selected_order_item.equals("Ascending"))
                tmp += " < ";
            else
                tmp += " > ";
            /*-----------------------------------------*/
			if(change_int==change_num)
                tmp += change_int;
			else
                tmp += change_num;
        }
        compareData[times] = tmp;
    }

    public void dataStorage_text(List<String> data,int times)
    {
        for(int w=0;w<data.size();w++)
            sortData[times][w] = data.get(w);
    }

    public void changePart_text(boolean change,int times,String change_text,String temp_text)
    {
        String tmp="";
        if(change)
        {
            System.out.println(selected_algorithm_item);
            if(selected_algorithm_item.equals("Selection"))
                tmp += temp_text + " <-> " + change_text;
            else if ((change_text.compareTo(temp_text) > 0) && selected_order_item.equals("Ascending"))
                tmp += temp_text + " < " + change_text;
            else if ((change_text.compareTo(temp_text) < 0) && selected_order_item.equals("Descending"))
                tmp += temp_text + " > " + change_text;
        }
        compareData[times] = tmp;
    }
}
