package sort.algorithm;

import javax.swing.*;

import component.EssentialComponent;

import java.util.*;

public class ObjectSelectionsort {

    List<List<String>> objectdata = new ArrayList<List<String>>();
    int priority=0;
	public ObjectSelectionsort(List<List<String>> objectdata,int priority){
        this.objectdata=objectdata;
        this.priority=priority;
	}

	public void Selectionsort(int asc){
        EssentialComponent.displayarea.setText("");
        if(number_check()){
            if(asc==0){
                Selectionsort_num_asc();
            }else{
                Selectionsort_num_des();
            }
        }else{
            if(asc==0){
                Selectionsort_text_asc();
            }else{
                Selectionsort_text_des();
            }
        }
    }

    public void Selectionsort_num_asc(){
        int size=objectdata.size();
        int i,j,temp_location,temp;
        double min ,comp_temp;
        ArrayList<Integer> output=new ArrayList<Integer>();
        for(int x=0;x<size;x++){
            output.add(x);
        }
        for(i=0;i<size;i++){
            min = Double.parseDouble(objectdata.get(output.get(i)).get(priority));
            temp_location=output.get(i);
            temp=i;
            for(j=i+1;j<size;j++){
                comp_temp=Double.parseDouble(objectdata.get(output.get(j)).get(priority));
                if(min>comp_temp){
                    min = comp_temp;
                    temp_location=output.get(j);
                    temp=j;
                }
            }
            for(int x=temp;i<x;x--){
                output.set(x,output.get(x-1));
            }
            output.set(i,temp_location);
            display(output,size);
        }
    }
    
    public void Selectionsort_num_des(){
        int size=objectdata.size();
        int i,j,temp_location,temp;
        double max ,comp_temp;
        ArrayList<Integer> output=new ArrayList<Integer>();
        for(int x=0;x<size;x++){
            output.add(x);
        }
        for(i=0;i<size;i++){
            max = Double.parseDouble(objectdata.get(output.get(i)).get(priority));
            temp_location=output.get(i);
            temp=i;
            for(j=i+1;j<size;j++){
                comp_temp=Double.parseDouble(objectdata.get(output.get(j)).get(priority));
                if(max<comp_temp){
                    max = comp_temp;
                    temp_location=output.get(j);
                    temp = j;
                }
            }
            for(int x=temp;i<x;x--){
                output.set(x,output.get(x-1));
            }
            output.set(i,temp_location);
            display(output,size);
        }
    }

    public void Selectionsort_text_asc(){
        int size=objectdata.size();
        int i,j,temp_location,temp;
        String min,comp_temp;
        ArrayList<Integer> output=new ArrayList<Integer>();
        for(int x=0;x<size;x++){
            output.add(x);
        }
        for(i=0;i<size;i++){
            min = (objectdata.get(output.get(i)).get(priority));
            temp_location=output.get(i);
            temp=i;
            for(j=i+1;j<size;j++){
                comp_temp=(objectdata.get(output.get(j)).get(priority));
                if(min.compareTo(comp_temp)>0){
                    min = comp_temp;
                    temp_location=output.get(j);
                    temp=j;
                }
            }
            for(int x=temp;i<x;x--){
                output.set(x,output.get(x-1));
            }
            output.set(i,temp_location);
            display(output,size);
        }
    }

    public void Selectionsort_text_des(){
        int size=objectdata.size();
        int i,j,temp_location,temp;
        String max,comp_temp;
        ArrayList<Integer> output=new ArrayList<Integer>();
        for(int x=0;x<size;x++){
            output.add(x);
        }
        for(i=0;i<size;i++){
            max =(objectdata.get(output.get(i)).get(priority));
            temp_location=output.get(i);
            temp=i;
            for(j=i+1;j<size;j++){
                comp_temp=(objectdata.get(output.get(j)).get(priority));
                if(max.compareTo(comp_temp)<0){
                    max = comp_temp;
                    temp_location=output.get(j);
                    temp = j ;
                }
            }
            for(int x=temp;i<x;x--){
                output.set(x,output.get(x-1));
            }
            output.set(i,temp_location);
            display(output,size);
        }
    }

    public void display(ArrayList<Integer> output,int size){
        for(int i=0;i<size;i++){
            EssentialComponent.displayarea.append(i+"----{");
            for(int j=0;j<objectdata.get(0).size();j++){
                EssentialComponent.displayarea.append(objectdata.get(output.get(i)).get(j)+" ");
            }
            EssentialComponent.displayarea.append("}\n");
        }
        EssentialComponent.displayarea.append("\n");
    }

    public boolean number_check(){
        boolean check = true;
        for(int i=0;i<objectdata.size();i++){
            try {  
                Double.parseDouble(objectdata.get(i).get(priority));
            } catch(NumberFormatException e){  
                check = false;
                break;  
            }  
        }
        return check ;
    }
}
