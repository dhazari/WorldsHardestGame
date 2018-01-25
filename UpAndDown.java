import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
public class UpAndDown
{
	private int x;
	private int y;
	private int size;
	private int dire;
	private Polygon area;
	ArrayList<Integer> moveList;

	public UpAndDown(int xv, int yv, int sv, Polygon av)
	{
		x=xv;
		y=yv;
		size=sv;
		area=av;
	}

	public void move()
	{
		if(y==140)
			dire=0;
		if(y==290)
			dire=1;
		if(dire==0)
			y+=2;
		if(dire==1)
			y-=2;
	}
	public void setY(int a)
	{
		y+=a;
	}

	public int getX()
	{
		return x;
	}

	public int getY()
	{
		return y;
	}

	public int getSize()
	{
		return size;
	}
	public Polygon getArea()
	{
		return area;
	}
}