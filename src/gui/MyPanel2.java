package gui;

import javax.swing.*;

import sort.Sorting;
import sort.preSorting;

import java.util.*;
import java.util.List;
import java.awt.*;

public class MyPanel2 extends JPanel {
    
	private int text_x;
	private int text_y;
	private int text_width;
	private int text_height;
	private int border_x;
	private int border_y;
	private int border_width;
	private int border_height;
	private List<String> sort_text;
	public String type = "Square";
	public boolean hasData = false;
	Graphics2D g2d;
	
    public MyPanel2()
    {
    	setPreferredSize(new Dimension(800, 200));
    	setData("Hello ~ Test 123 45 9 200 666 ABC WAD121 WEAEW EAW GO 77777777 1 SSSSSSSssss");
    	hasData = true;
    }
    
    public void setData(String data)
    {
    	sort_text = new ArrayList<String>();
    	preSorting.Addn_text(data, sort_text);
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        paintText(g);
    }

    private void paintText(Graphics g)
    {
        g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font(null, Font.PLAIN, 25));
        /*-------------------------------------------------------*/
        if(hasData)
        {
        	border_x = 25;
        	/*--------------------------------*/
        	if(type.equals("Square"))
        		Square();
        	else if(type.equals("Oval"))
        		Oval();
        	else if(type.equals("Circle"))
        		Circle();
        	else if(type.equals("Triangle"))
        		Triangle();
        	/*--------------------------------*/
            int width = border_x + border_width + 20;
            setPreferredSize(new Dimension(width, 200));
            DisplayPanel.listScroll.getViewport().revalidate();
        }
        /*-------------------------------------------------------*/
    }
    
    public void Square()
    {
    	Setsquare(sort_text.get(0),border_x,100);
        drawSquare(sort_text.get(0));
        for(int i = 1;i<sort_text.size();i++)
        {
        	Setsquare(sort_text.get(i),border_x + border_width + 20,100);
            drawSquare(sort_text.get(i));
        }
    }
    
    public void Oval()
    {
    	Setoval(sort_text.get(0),border_x,100);
        drawOval(sort_text.get(0));
        for(int i = 1;i<sort_text.size();i++)
        {
        	Setoval(sort_text.get(i),border_x + border_width + 25,100);
            drawOval(sort_text.get(i));
        }
    }
    
    public void Circle()
    {
    	Setcircle(sort_text.get(0),border_x,100);
    	drawCircle(sort_text.get(0));
        for(int i = 1;i<sort_text.size();i++)
        {
        	Setcircle(sort_text.get(i),border_x + border_width + 25,100);
        	drawCircle(sort_text.get(i));
        }
    }
    
    public void Triangle()
    {
    	Settriangle(sort_text.get(0),25,100);
        drawTriangle(sort_text.get(0));
        for(int i = 1;i<sort_text.size();i++)
        {
        	Settriangle(sort_text.get(i),text_x + border_width + 30,100);
            drawTriangle(sort_text.get(i));
        }
    }
    
    public void drawSquare(String data)
    {
    	g2d.drawString(data,text_x,text_y);
        g2d.drawRect(border_x,border_y,border_width,border_height);
    }
    
    public void drawOval(String data)
    {
    	g2d.drawString(data,text_x,text_y);
        g2d.drawArc(border_x, border_y, border_width, border_height, 0, 360);
    }
    
    public void drawCircle(String data)
    {
    	g2d.drawString(data,text_x,text_y);
        g2d.drawArc(border_x, border_y, border_width, border_width, 0, 360);
    }
    
    public void Setsquare(String data,int x,int y) 
    {
    	this.text_x = x;
    	this.text_y = y;
    	text_width = g2d.getFontMetrics().stringWidth(data);
        text_height = 30;
        border_x = x - 10;
        border_y = text_y - text_height + 5;
        border_width = text_width + 20;
        border_height = text_height;
    }
    
    public void Setoval(String data,int x,int y) 
    {
    	this.text_x = x;
    	this.text_y = y;
    	text_width = g2d.getFontMetrics().stringWidth(data);
        text_height = 30;
        border_x = text_x - 15;
        border_y = text_y - text_height + 5;
        border_width = text_width + 30;
        border_height = text_height;
    }
    
    public void Setcircle(String data,int x,int y) 
    {
    	this.text_x = x;
    	this.text_y = y;
    	text_width = g2d.getFontMetrics().stringWidth(data);
        text_height = 30;
        border_x = text_x - 10;
        border_y = (int) (text_y - (text_width+20)/2 - 10);
        border_width = text_width + 20;
        border_height = text_height;
    }
    
    public void Settriangle(String data,int x,int y)
    {
    	this.text_x = x;
    	this.text_y = y;
    	text_width = g2d.getFontMetrics().stringWidth(data);
        text_height = 30;
        border_x = text_x - 20;
        border_width = text_width + 20;
    }
    
    public void drawTriangle(String data)
    {
    	g2d.drawString(data,text_x,text_y);
    	g2d.drawPolygon(new int[] {border_x, text_x + text_width/2, text_x + border_width}, new int[] {text_y, text_y - text_width/2 - 20, text_y}, 3);
    }
    
}
