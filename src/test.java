import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class test{
	String str;
	int num;
	double dou;
	
	public void set(String str){
		ArrayList<String> temp=execute(str);
		setstr(temp.get(0));
		setnum(temp.get(1));
		setdou(temp.get(2));
		print();
	}
	public void setstr(String str){
		this.str=str;
	}
	public void setnum(String str){
		this.num=Integer.parseInt(str);
	}
	public void setdou(String str){
		this.dou=Double.parseDouble(str);
	}
	public String gettype(){
		String name="String/int/double";
		return name;
	}
	public String getname(){
		String name="str/num/dou";
		return name;
	}
	public String get(){
		String content=getstr()+"/"+getnum()+"/"+getdou();
		return content;
	}
	public String getstr(){
		return str;
	}
	public int getnum(){
		return num;
	}
	public double getdou(){
		return dou;
	}
	public String get_choose_type(String temp){
		String content;
		switch(temp){
			case "str":
				content="String";
				break;
			case "num":
				content="int";
				break;
			case "dou":
				content="double";
				break;
			default:
				content="error";
				break;
		}
		return content;
	}
	public void print(){
		System.out.print("sucess\t"+get()+"\n");
	}
	public ArrayList<String> execute(String temp){
		ArrayList<String> str = new ArrayList<String>();
		StringTokenizer st = new StringTokenizer(temp,"{/} \t");
		while(st.hasMoreTokens()){
			str.add(st.nextToken());
		} 
		return str;
	} 
}
