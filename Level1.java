import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

public class Level1 extends JPanel implements KeyListener,Runnable
{
	private int x;
	private int y;
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	private int x3;
	private int y3;
	private int x4;
	private int y4;
	private int x5;
	private int y5;
	private int x6;
	private int y6;
	private int x7;
	private int y7;
	private int x8;
	private int y8;
	private int x9;
	private int y9;
	private int x10;
	private int y10;
	private int x11;
	private int y11;
	private int x12;
	private int y12;
	private int x13;
	private int y13;
	private int x14;
	private int y14;
	private int x15;
	private int y15;
	private int x16;
	private int y16;
	private int x17;
	private int y17;
	private JFrame frame;
	private Thread t;
	private boolean gameOn;
	private boolean gameOn2;
	private boolean winner;
	private boolean pointer;
	private Polygon poly;
	private Polygon poly2;
	private Polygon poly3;
	private Font extra;
	private int deaths;
	private ArrayList<SideToSide> ballsList;
	private ArrayList<UpAndDown> ballsList2;
	private boolean right=false;
	private boolean left=false;
	private boolean up=false;
	private boolean down=false;

	public Level1()
	{
		frame=new JFrame();
		x=80;
		y=190;
		x1=150;
		y1=235;
		x2=380;
		y2=210;
		x3=150;
		y3=185;
		x4=380;
		y4=160;
		x5=150;
		y5=280;
		x6=175;
		y6=140;
		x7=200;
		y7=280;
		x8=225;
		y8=140;
		x9=250;
		y9=280;
		x10=275;
		y10=140;
		x11=300;
		y11=280;
		x12=325;
		y12=140;
		x13=350;
		y13=280;
		x14=375;
		y14=140;
		x15=400;
		y15=280;
		x16=425;
		y16=140;
		x17=75;
		y17=210;
		deaths=0;
		gameOn=true;
		gameOn2=false;
		winner=false;
		pointer=true;
		setArea();
		frame.addKeyListener(this);
		extra=new Font("STSong",Font.BOLD,60);
		frame.add(this);
		frame.setSize(600,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		t=new Thread(this);
		t.start();
	}

	public void setArea()
	{
		poly= new Polygon();
		poly.addPoint(50,275);
		poly.addPoint(50,125);
		poly.addPoint(125,125);
		poly.addPoint(125,250);
		poly.addPoint(150,250);
		poly.addPoint(150,145);
		poly.addPoint(375,145);
		poly.addPoint(375,125);
		poly.addPoint(500,125);
		poly.addPoint(500,275);
		poly.addPoint(425,275);
		poly.addPoint(425,150);
		poly.addPoint(400,150);
		poly.addPoint(400,250);
		poly.addPoint(175,250);
		poly.addPoint(175,275);
		
		poly2= new Polygon();
		poly2.addPoint(0,0);
		poly2.addPoint(0,25);
		poly2.addPoint(600,25);
		poly2.addPoint(600,0);
		
		poly3= new Polygon();
		poly3.addPoint(55,245);
		poly3.addPoint(55,190);
		poly3.addPoint(135,190);
		poly3.addPoint(135,135);
		poly3.addPoint(460,135);
		poly3.addPoint(460,190);
		poly3.addPoint(540,190);
		poly3.addPoint(540,245);
		poly3.addPoint(460,245);
		poly3.addPoint(460,300);
		poly3.addPoint(135,300);
		poly3.addPoint(135,245);
		
		ballsList=new ArrayList<SideToSide>();
		ballsList.add(new SideToSide(x1,y1,10,poly));
		ballsList.add(new SideToSide(x2,y2,10,poly));
		ballsList.add(new SideToSide(x3,y3,10,poly));
		ballsList.add(new SideToSide(x4,y4,10,poly));
		
		ballsList2=new ArrayList<UpAndDown>();
		ballsList2.add(new UpAndDown(x5,y5,10,poly3));
		ballsList2.add(new UpAndDown(x6,y6,10,poly3));
		ballsList2.add(new UpAndDown(x7,y7,10,poly3));
		ballsList2.add(new UpAndDown(x8,y8,10,poly3));
		ballsList2.add(new UpAndDown(x9,y9,10,poly3));
		ballsList2.add(new UpAndDown(x10,y10,10,poly3));
		ballsList2.add(new UpAndDown(x11,y11,10,poly3));
		ballsList2.add(new UpAndDown(x12,y12,10,poly3));
		ballsList2.add(new UpAndDown(x13,y13,10,poly3));
		ballsList2.add(new UpAndDown(x14,y14,10,poly3));
		ballsList2.add(new UpAndDown(x15,y15,10,poly3));
		ballsList2.add(new UpAndDown(x16,y16,10,poly3));
	}

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;

		g2d.setColor(new Color(180,181,254));
		g2d.fillRect(0,0,600,400);
		g2d.setColor(Color.BLACK);
		g2d.fillPolygon(poly2);
		g2d.setColor(Color.WHITE);
		g2d.drawString("Deaths: "+deaths,480,18);

		if(gameOn)
		{
			g2d.setColor(Color.WHITE);
			g2d.fillPolygon(poly);
			g2d.setColor(new Color(181,254,180));
			g2d.fillRect(50,125,75,150);
			g2d.fillRect(425,125,75,150);
			g2d.setColor(Color.BLACK);
			g2d.setStroke(new BasicStroke(2));
			g2d.draw(poly);
			g2d.setColor(Color.RED);
			g2d.fillRect(x,y,15,15);
			g2d.setColor(Color.BLACK);
			g2d.drawRect(x,y,15,15);
			
			for(int a=0; a<ballsList.size(); a++)
			{
				g2d.setColor(Color.BLUE);
				g2d.fillOval(ballsList.get(a).getX(),ballsList.get(a).getY(),10,10);
				g2d.setColor(Color.BLACK);
				g2d.drawOval(ballsList.get(a).getX(),ballsList.get(a).getY(),10,10);
			}
		}
		else if(gameOn2) {
			g2d.setColor(Color.WHITE);
			g2d.fillPolygon(poly3);
			g2d.setColor(new Color(181,254,180));
			g2d.fillRect(55,190,80,55);
			g2d.fillRect(460,190,80,55);
			g2d.setColor(Color.BLACK);
			g2d.setStroke(new BasicStroke(2));
			g2d.draw(poly3);
			g2d.setColor(Color.RED);
			g2d.fillRect(x17,y17,15,15);
			g2d.setColor(Color.BLACK);
			g2d.drawRect(x17,y17,15,15);
			if(pointer) {
				g2d.setColor(Color.YELLOW);
				g2d.fillOval(300,215,10,10);
				g2d.setColor(Color.BLACK);
				g2d.drawOval(300,215,10,10);
			}
			for(int a=0; a<ballsList2.size(); a++)
			{
				g2d.setColor(Color.BLUE);
				g2d.fillOval(ballsList2.get(a).getX(),ballsList2.get(a).getY(),10,10);
				g2d.setColor(Color.BLACK);
				g2d.drawOval(ballsList2.get(a).getX(),ballsList2.get(a).getY(),10,10);
			}
		}
		else if(winner) {
			g2d.setColor(Color.WHITE);
			g2d.setFont(extra);
			g2d.drawString("You Win",100,250);
		}
	}
	public void run()
	{
		while(true)
		{
			if(gameOn)
			{
				boolean moveOk=true;
				if(right)
				{
					if(!poly.contains(new Rectangle(x+2,y,15,15)))
						moveOk=false;
				}
				if(left)
				{
					if(!poly.contains(new Rectangle(x-2,y,15,15)))
						moveOk=false;
				}
				if(up)
				{
					if(!poly.contains(new Rectangle(x,y-2,15,15)))
						moveOk=false;
				}
				if(down)
				{
					if(!poly.contains(new Rectangle(x,y+2,15,15)))
						moveOk=false;
				}

				if(moveOk)
				{
					if(right)
					{
						x+=2;
					}
					if(left)
					{
						x-=2;
					}
					if(up)
						y-=2;
					if(down)
						y+=2;
				}
				for(SideToSide b:ballsList)
				{
					b.move();
					Rectangle point=new Rectangle(x,y,15,15);
					if(point.intersects(new Rectangle(b.getX(),b.getY(),b.getSize(),b.getSize())))
					{
						x=80;
						y=190;
						deaths++;
					}
				}
				if(x>=425) {
					gameOn=false;
					gameOn2=true;
				}
			}
			if(gameOn2)
			{
				boolean moveOk=true;
				if(right)
				{
					if(!poly3.contains(new Rectangle(x17+2,y17,15,15)))
						moveOk=false;
				}
				if(left)
				{
					if(!poly3.contains(new Rectangle(x17-2,y17,15,15)))
						moveOk=false;
				}
				if(up)
				{
					if(!poly3.contains(new Rectangle(x17,y17-2,15,15)))
						moveOk=false;
				}
				if(down)
				{
					if(!poly3.contains(new Rectangle(x17,y17+2,15,15)))
						moveOk=false;
				}

				if(moveOk)
				{
					if(right)
					{
						x17+=2;
					}
					if(left)
					{
						x17-=2;
					}
					if(up)
						y17-=2;
					if(down)
						y17+=2;
				}
				for(UpAndDown c:ballsList2)
				{
					c.move();
					Rectangle point=new Rectangle(x17,y17,15,15);
					if(point.intersects(new Rectangle(c.getX(),c.getY(),c.getSize(),c.getSize())))
					{
						x17=75;
						y17=210;
						pointer=true;
						deaths++;
					}
				}
				if(x17<=310 && x17>=290 && y17<=225 && y17>=205)
					pointer=false;
				if(x17>=460 && pointer==false) {
					gameOn2=false;
					winner=true;
				}
			}
			try
			{
				t.sleep(10);
			}
			catch(InterruptedException e)
			{

			}
			repaint();
		}
	}

	public void keyPressed(KeyEvent ke)
	{

		if(ke.getKeyCode()==39)
		{
			right=true;
			up=false;
			down=false;
			left=false;
		}

		if(ke.getKeyCode()==37)
		{
			right=false;
			up=false;
			down=false;
			left=true;
		}
		if(ke.getKeyCode()==38)
		{
			right=false;
			up=true;
			down=false;
			left=false;
		}

		if(ke.getKeyCode()==40)
		{
			right=false;
			up=false;
			down=true;
			left=false;
		}
		else if(ke.getKeyCode()==32)
				gameOn=true;
	}

	public void keyReleased(KeyEvent ke)
	{
		right=false;
		up=false;
		down=false;
		left=false;
	}

	public void keyTyped(KeyEvent ke)
	{
	}

	public static void main(String args[])
	{
		Level1 app=new Level1();
	}
}
