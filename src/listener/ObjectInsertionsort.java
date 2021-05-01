package listener;

import javax.swing.*;
import java.util.*;
import java.lang.reflect.*;
public class ObjectInsertionsort {

    ArrayList<Object> objectdata;
    JTextArea display_sort = new JTextArea();
    String priority;
	public ObjectInsertionsort( ArrayList<Object> objectdata,String priority,JTextArea display_sort){
        this.objectdata=objectdata;
        this.priority=priority;
        this.display_sort=display_sort;
	}

	public void Insertionsort(int asc){
        display_sort.setText("");
        
        if(number_check(objectdata.get(0),priority)){
            if(asc==0){
                Insertionsort_text_asc();
            }else{
                Insertionsort_text_des();
            }
        }else{
            if(asc==0){
                Insertionsort_num_asc();
            }else{
                Insertionsort_num_des();
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
            temp_num = Double.parseDouble(get_String(objectdata.get(output.get(i)),priority));
            temp_location=i;
            for(j=0;j<i;j++){
                comp_temp=Double.parseDouble(get_String(objectdata.get(output.get(j)),priority));
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
            temp_num = Double.parseDouble(get_String(objectdata.get(output.get(i)),priority));
            temp_location=i;
            for(j=0;j<i;j++){
                comp_temp=Double.parseDouble(get_String(objectdata.get(output.get(j)),priority));
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
            temp_num = get_String(objectdata.get(output.get(i)),priority);
            temp_location=i;
            for(j=0;j<i;j++){
                comp_temp=get_String(objectdata.get(output.get(j)),priority);
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
            temp_num = get_String(objectdata.get(output.get(i)),priority);
            temp_location=i;
            for(j=0;j<i;j++){
                comp_temp=get_String(objectdata.get(output.get(j)),priority);
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
            display_sort.append(i+"----{"+object_value(objectdata.get(output.get(i)))+"}\n");
        }
    }

    public String get_String(Object o,String priority){
        try{
            Class<?> cc = o.getClass();
            Method mm = cc.getMethod("get"+priority);
            String temp = mm.invoke(o).toString();
            return temp;
        }catch(Exception error) {
            error.printStackTrace();
            return "error";
        }
    }/*
    public double get_num(Object o,String priority){
        try{
            Class<?> cc = o.getClass();
            Method mm = cc.getMethod("get"+priority);
            double temp=Double.parseDouble(mm.invoke(o).toString());
            return temp;
        }catch(Exception error) {
            error.printStackTrace();
            return 0;
        }
    }*/
    public String object_value(Object o){
        try{
            Class<?> cc = o.getClass();
            Method mm = cc.getMethod("get");
            String str = mm.invoke(o).toString();
            return str;
        }catch(Exception error) {
            error.printStackTrace();
            return "error";
        }
    }
    public boolean number_check(Object o,String priority){
        try{
            Class<?> cc = o.getClass();
            Method mm = cc.getMethod("get_choose_type", String.class);
            String str = mm.invoke(o,priority).toString();
            return (str.compareTo("String")==0)?true:false;
        }catch(Exception error) {
            error.printStackTrace();
            return false;
        }
    }
}
