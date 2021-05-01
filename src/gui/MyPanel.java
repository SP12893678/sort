package gui;

import javax.swing.*;

import sort.Sorting;
import sort.preSorting;

import java.util.*;
import java.util.List;
import java.awt.*;

public class MyPanel extends JPanel {
    public static List<Double> disarr = new ArrayList<Double>();
    public static List<String> disarrtext = new ArrayList<String>();
    public static int whicharr = 0;
    public static int x = 5;
    public static int y = 30;
    public static int drawy = 30;
    public static int colnum = 1;
    static int remain = 690;
    static int size;
    
    public MyPanel()
    {
        setSize(750, 750);
    }

    public static void getSortData(int s)
    {
        size = s;
        whicharr = 1;
        y = 30;
    }
    public static void getSorttext(int s)
    {
    	size = s;
        whicharr = 2;
        y = 30;
    }

    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        paintText(g);
    }

    public static void paintText(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g.create();
        int position = 0;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(new Font(null, Font.PLAIN, 25));
        if (whicharr == 0){
            g2d.drawString("目前還未有資料輸入", x, y);
        }
        else if(whicharr == 1){
            x = 5;
            remain = 650;
            for(;position < size;position ++){
                remain = remindmar(remain,position);
                if(remain < 0){
                    remain = 650;
                    if(position == size -1){
                        if(colnum+1 == 15){
                            colnum = 1;
                            x = 5;
                            y = 30;
                            //g2d.drawString(String.valueOf(disarr.get(position)), x, y);
                            g2d.drawString(Sorting.getSortData(Sorting.line,position).toString(), x, y);
                            g2d.drawRect(x,y-18,canumlen(position)*15,18);
                            x += canumlen(position)*15+8;
                        }
                        else {
                            colnum += 1;
                            y += 21;
                            x = 5;
                            //g2d.drawString(String.valueOf(disarr.get(position)), x, y);
                            g2d.drawString(Sorting.getSortData(Sorting.line,position).toString(), x, y);
                            g2d.drawRect(x,y-18,canumlen(position)*15,18);
                            x += canumlen(position)*15+8;
                        }
                    }
                    else{
                        if(colnum+1 == 15){
                            colnum = 1;
                            x = 5;
                            y = 30;
                            //g2d.drawString(String.valueOf(disarr.get(position))+",", x, y);
                            g2d.drawString(Sorting.getSortData(Sorting.line,position).toString(), x, y);
                            g2d.drawRect(x,y-18,canumlen(position)*15,18);
                            x += canumlen(position)*15+8;
                    }
                        else {
                            colnum += 1;
                            y += 21;
                            x = 5;
                            //g2d.drawString(String.valueOf(disarr.get(position))+",", x, y);
                            g2d.drawString(Sorting.getSortData(Sorting.line,position).toString(), x, y);
                            g2d.drawRect(x,y-18,canumlen(position)*15,18);
                            x += canumlen(position)*15+8;
                        }
                    }
                }
                    else {
                        if(position == size -1){
                            //g2d.drawString(String.valueOf(disarr.get(position)), x, y);
                            g2d.drawString(Sorting.getSortData(Sorting.line,position).toString(), x, y);
                            g2d.drawRect(x,y-18,canumlen(position)*15,18);
                            x += canumlen(position)*15+8;
                        }
                        else{
                            //g2d.drawString(String.valueOf(disarr.get(position))+",", x, y);
                            g2d.drawString(Sorting.getSortData(Sorting.line,position).toString(), x, y);
                            g2d.drawRect(x,y-18,canumlen(position)*15,18);
                            x += canumlen(position)*15+8;
                        }
                    }
                }
            if(colnum +1 != 15){
                colnum ++;
                y += 21;
            }
            else{
                y = 30;
                colnum = 1;
            }
        }
            else if(whicharr == 2){
                int size = disarrtext.size();
                FontMetrics metrics = g.getFontMetrics();
                int width = 0;
                x = 5;
                remain = 650;
                for(;position < size;position ++){
                    remain = textremindmar(remain,position);
                    if(remain < 0){
                        remain = 650;
                        if(position == size -1){
                            if(colnum+1 == 15){
                                colnum = 1;
                                x = 5;
                                y = 30;
                                //g2d.drawString(disarrtext.get(position), x, y);
                                g2d.drawString(Sorting.getSortData(Sorting.line,position).toString(), x, y);
                                width = (int)(metrics.stringWidth(Sorting.getSortData(Sorting.line,position).toString())*2.4);
                                g2d.drawRect(x,y-18,width,20);
                                x += width;
                            }
                            else {
                                colnum += 1;
                                y += 21;
                                x = 5;
                                //g2d.drawString(disarrtext.get(position), x, y);
                                g2d.drawString(Sorting.getSortData(Sorting.line,position).toString(), x, y);
                                width = (int)(metrics.stringWidth(Sorting.getSortData(Sorting.line,position).toString())*2.4);
                                g2d.drawRect(x,y-18,width,20);
                                x += width;
                            }
                        }
                        else{
                            if(colnum+1 == 15){
                                colnum = 1;
                                x = 5;
                                y = 30;
                                //g2d.drawString(disarrtext.get(position)+",", x, y);
                                g2d.drawString(Sorting.getSortData(Sorting.line,position).toString(), x, y);
                                width = (int)(metrics.stringWidth(Sorting.getSortData(Sorting.line,position).toString())*2.4);
                                g2d.drawRect(x,y-18,width,20);
                                x += width+10;
                        }
                            else {
                                colnum += 1;
                                y += 21;
                                x = 5;
                                g2d.drawString(disarrtext.get(position)+",", x, y);
                                width = (int)(metrics.stringWidth(Sorting.getSortData(Sorting.line,position).toString())*2.4);
                                g2d.drawRect(x,y-18,width,20);
                                x += width+10;
                            }
                        }
                    }
                    else {
                        if(position == size -1){
                            //g2d.drawString(disarrtext.get(position), x, y);
                            g2d.drawString(Sorting.getSortData(Sorting.line,position).toString(), x, y);
                            width = (int)(metrics.stringWidth(Sorting.getSortData(Sorting.line,position).toString())*2.4);
                            g2d.drawRect(x,y-18,width,20);
                            x += width;
                        }
                        else{
                            //g2d.drawString(disarrtext.get(position)+",", x, y);
                            g2d.drawString(Sorting.getSortData(Sorting.line,position).toString(), x, y);
                            width = (int)(metrics.stringWidth(Sorting.getSortData(Sorting.line,position).toString())*2.4);
                            g2d.drawRect(x,y-18,width,20);
                            x += width+10;
                        }
                    }
                }
            if(colnum +1 != 15){
                colnum ++;
                y += 21;
            }
            else{
                y = 30;
                colnum = 1;
            }
        }

        g2d.dispose();
    }

    public static int canumlen(int pos)
    {
        return Sorting.getSortData(Sorting.line,pos).toString().length();
    }
    public static int remindmar(int m,int pos){
        return (m - (canumlen(pos)+1)*15 - 15);
    }
    public static int textremindmar(int m,int pos){
        return m - canumlen(pos)*25 - 15;
    }
}
