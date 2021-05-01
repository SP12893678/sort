package sort.algorithm;

import javax.swing.*;

import component.EssentialComponent;

import java.util.*;

public class ObjectBubblesort {

    List<List<String>> objectdata = new ArrayList<List<String>>();
    int priority=0;
	public ObjectBubblesort(List<List<String>> objectdata,int priority){
        this.objectdata=objectdata;
        this.priority=priority;
	}

	public void Bubblesort(int asc){
        EssentialComponent.displayarea.setText("");
        if(number_check()){
            if(asc==0){
                Bubblesort_num_asc();
            }else{
                Bubblesort_num_des();
            }
        }else{
            if(asc==0){
                Bubblesort_text_asc();
            }else{
                Bubblesort_text_des();
            }
        }
    }

    public void Bubblesort_num_asc(){
        int size=objectdata.size();
        int i,j,temp_location;
        double temp_num ,comp_temp;
        ArrayList<Integer> output=new ArrayList<Integer>();
        for(int x=0;x<size;x++){
            output.add(x);
        }
        for(i=0;i<size;i++){
            for(j=size-1;j>i;j--){
                temp_num = Double.parseDouble(objectdata.get(output.get(j)).get(priority));
                comp_temp=Double.parseDouble(objectdata.get(output.get(j-1)).get(priority));
                if(temp_num<comp_temp){
                    temp_location=output.get(j);
                    output.set(j,output.get(j-1));
                    output.set(j-1,temp_location);
                }
            }
            display(output,size);
        }
    }
    
    public void Bubblesort_num_des(){
        int size=objectdata.size();
        int i,j,temp_location;
        double temp_num ,comp_temp;
        ArrayList<Integer> output=new ArrayList<Integer>();
        for(int x=0;x<size;x++){
            output.add(x);
        }
        for(i=0;i<size;i++){
            for(j=size-1;j>i;j--){
                temp_num = Double.parseDouble(objectdata.get(output.get(j)).get(priority));
                comp_temp=Double.parseDouble(objectdata.get(output.get(j-1)).get(priority));
                if(temp_num>comp_temp){
                    temp_location=output.get(j);
                    output.set(j,output.get(j-1));
                    output.set(j-1,temp_location);
                }
            }
            display(output,size);
        }
    }

    public void Bubblesort_text_asc(){
        int size=objectdata.size();
        int i,j,temp_location;
        String temp_num ,comp_temp;
        ArrayList<Integer> output=new ArrayList<Integer>();
        for(int x=0;x<size;x++){
            output.add(x);
        }
        for(i=0;i<size;i++){
            for(j=size-1;j>i;j--){
                temp_num = objectdata.get(output.get(j)).get(priority);
                comp_temp = objectdata.get(output.get(j-1)).get(priority);
                if(temp_num.compareTo(comp_temp)>0){
                    temp_location=output.get(j);
                    output.set(j,output.get(j-1));
                    output.set(j-1,temp_location);
                }
            }
            display(output,size);
        }
    }

    public void Bubblesort_text_des(){
        int size=objectdata.size();
        int i,j,temp_location;
        String temp_num ,comp_temp;
        ArrayList<Integer> output=new ArrayList<Integer>();
        for(int x=0;x<size;x++){
            output.add(x);
        }
        for(i=0;i<size;i++){
            for(j=size-1;j>i;j--){
                temp_num = objectdata.get(output.get(j)).get(priority);
                comp_temp = objectdata.get(output.get(j-1)).get(priority);
                if(temp_num.compareTo(comp_temp)<0){
                    temp_location=output.get(j);
                    output.set(j,output.get(j-1));
                    output.set(j-1,temp_location);
                }
            }
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
