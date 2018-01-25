import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
public class SideToSide
{
	private int x;
	private int y;
	private int size;
	private int dire;
	private Polygon area;
	ArrayList<Integer> moveList;

	public SideToSide(int xv, int yv, int sv, Polygon av)
	{
		x=xv;
		y=yv;
		size=sv;
		area=av;
	}

	public void move()
	{
		if(x==160)
			dire=0;
		if(x==380)
			dire=1;
		if(dire==0)
			x+=2;
		if(dire==1)
			x-=2;
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
