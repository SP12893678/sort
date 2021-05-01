package sort.algorithm;
import component.EssentialComponent;

import java.util.*;

public class ObjectInsertionsort {

    List<List<String>> objectdata = new ArrayList<List<String>>();
    int priority=0;
	public ObjectInsertionsort(List<List<String>> objectdata,int priority){
        this.objectdata=objectdata;
        this.priority=priority;
	}

	public void Insertionsort(int asc){
        EssentialComponent.displayarea.setText("");
        if(number_check()){
            if(asc==0){
                Insertionsort_num_asc();
            }else{
                Insertionsort_num_des();
            }
        }else{
            if(asc==0){
                Insertionsort_text_asc();
            }else{
                Insertionsort_text_des();
            }
        }
    }

    public void Insertionsort_num_asc(){
        int size=objectdata.size();
        int i,j,temp_location;
        Double comp_temp,temp_num;
        ArrayList<Integer> output=new ArrayList<Integer>();
        for(int x=0;x<size;x++){
            output.add(x);
        }
        for(i=0;i<size;i++){
            temp_num = Double.parseDouble(objectdata.get(output.get(i)).get(priority));
            temp_location=i;
            for(j=0;j<i;j++){
                comp_temp=Double.parseDouble(objectdata.get(output.get(j)).get(priority));
                if(comp_temp>temp_num){
                    for(int x=i;j<x;x--){
                        output.set(x,output.get(x-1));
                    }
                    output.set(j,temp_location);
                    break;
                }
            }
            display(output,size);
        }
    }
    
    public void Insertionsort_num_des(){
        int size=objectdata.size();
        int i,j,temp_location;
        Double comp_temp,temp_num;
        ArrayList<Integer> output=new ArrayList<Integer>();
        for(int x=0;x<size;x++){
            output.add(x);
        }
        for(i=0;i<size;i++){
            temp_num = Double.parseDouble(objectdata.get(output.get(i)).get(priority));
            temp_location=i;
            for(j=0;j<i;j++){
                comp_temp=Double.parseDouble(objectdata.get(output.get(j)).get(priority));
                if(comp_temp<temp_num){
                    for(int x=i;j<x;x--){
                        output.set(x,output.get(x-1));
                    }
                    output.set(j,temp_location);
                    break;
                }
            }
            display(output,size);
        }
    }

    public void Insertionsort_text_asc(){
        int size=objectdata.size();
        int i,j,temp_location;
        String comp_temp,temp_num;
        ArrayList<Integer> output=new ArrayList<Integer>();
        for(int x=0;x<size;x++){
            output.add(x);
        }
        for(i=0;i<size;i++){
            temp_num = (objectdata.get(output.get(i)).get(priority));
            temp_location=i;
            for(j=0;j<i;j++){
                comp_temp=objectdata.get(output.get(j)).get(priority);
                if(comp_temp.compareTo(temp_num)>0){
                    for(int x=i;j<x;x--){
                        output.set(x,output.get(x-1));
                    }
                    output.set(j,temp_location);
                    break;
                }
            }
            display(output,size);
        }
    }

    public void Insertionsort_text_des(){
        int size=objectdata.size();
        int i,j,temp_location;
        String comp_temp,temp_num;
        ArrayList<Integer> output=new ArrayList<Integer>();
        for(int x=0;x<size;x++){
            output.add(x);
        }
        for(i=0;i<size;i++){
            temp_num = (objectdata.get(output.get(i)).get(priority));
            temp_location=i;
            for(j=0;j<i;j++){
                comp_temp=objectdata.get(output.get(j)).get(priority);
                if(comp_temp.compareTo(temp_num)<0){
                    for(int x=i;j<x;x--){
                        output.set(x,output.get(x-1));
                    }
                    output.set(j,temp_location);
                    break;
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
