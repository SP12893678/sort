import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class test1{
	String str;
	String str1;
	int num;
	int num1;
	double dou;
	double dou1;
	
	public void set(String str){
		ArrayList<String> temp=execute(str);
		setstr(temp.get(0));
		setstr1(temp.get(1));
        setnum(temp.get(2));
        setnum1(temp.get(3));
        setdou(temp.get(4));
        setdou1(temp.get(4));
		print();
	}
	public void setstr(String str){
		this.str=str;
    }
    public void setstr1(String str){
		this.str1=str;
	}
	public void setnum(String str){
		this.num=Integer.parseInt(str);
    }
    public void setnum1(String str){
		this.num1=Integer.parseInt(str);
	}
	public void setdou(String str){
		this.dou=Double.parseDouble(str);
    }
    public void setdou1(String str){
		this.dou1=Double.parseDouble(str);
	}
	public String gettype(){
		String name="String/String/int/int/double/double";
		return name;
	}
	public String getname(){
		String name="str/str1/num/num1/dou/dou1";
		return name;
	}
	public String get(){
		String content=getstr()+"/"+getstr1()+"/"+getnum()+"/"+getnum1()+"/"+getdou()+"/"+getdou1();
		return content;
	}
	public String getstr(){
		return str;
    }
    public String getstr1(){
		return str1;
	}
	public int getnum(){
		return num;
    }
    public int getnum1(){
		return num1;
	}
	public double getdou(){
		return dou;
    }
    public double getdou1(){
		return dou1;
	}
	public String get_choose_type(String temp){
		String content;
		switch(temp){
			case "str":
				content="String";
				break;
			case "str1":
				content="String";
				break;
			case "num":
				content="int";
				break;
			case "num1":
				content="int";
				break;
			case "dou":
				content="double";
				break;
			case "dou1":
				content="double";
				break;
			default:
				content="";
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
