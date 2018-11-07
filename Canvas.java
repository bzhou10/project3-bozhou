//Bo Zhou
//NetID: 31448703
//Lab11
//Lab section: TR TR 940-1055
//I did not collaborate with anyone on this assignment. 

import java.awt.Graphics;
import javax.swing.JComponent;
import javax.swing.JPanel;
import java.awt.Color;

import java.awt.event.MouseListener; 
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;



public class Canvas extends JComponent implements  MouseListener, MouseMotionListener{

	private int x;
	private int y;
	private int x1;
	private int x2;
	private int y1;
	private int y2; 
	

	boolean drag = false; 



	public Canvas(){
	
		addMouseListener(this); 
		addMouseMotionListener(this);


	}


	
	public void paintComponent(Graphics g){
		
		int width = getWidth();
		int height = getHeight();
		System.out.println("Canvas.paintComponent" + width + " x " + height);




		//If the user is dragging, the program draws circle which is increasing as dragging 
		//if the user only clicks, the program draws a small circle 
		if(drag == true){
			g.fillOval(x1, y1, x2-x1, y2-y1);

		}else{
			g.fillOval(x, y, 10, 10);

		}
		
		
	}


	@Override 
	public void mouseClicked(MouseEvent e){
		System.out.println("MouseListener.mouseClicked");
		x = e.getX();
		y = e.getY();
		drag = false;
		//calls paintComponent
		repaint();
	
	}



	@Override
	public void mousePressed(MouseEvent e){
		System.out.println("MouseListener.mousePressed"); 

		//Starting position 
		x1 = e.getX();
		y1 = e.getY(); 
		drag = false;
		repaint();

	}


	@Override
	public void mouseReleased(MouseEvent e){
		System.out.println("MouseListener.mouseReleased"); 
	

	}

	@Override
	public void mouseEntered(MouseEvent e){
		System.out.println("MouseListener.mouseEntered"); 

	}


	@Override
	public void mouseExited(MouseEvent e){
		System.out.println("MouseListener.mouseExited"); 
	}

	@Override
	public void mouseMoved(MouseEvent e){
		System.out.println("X: " + e.getX() + " Y: " + e.getY());
		System.out.println("MouseMotionListener.mouseMoved");
	}

	@Override
	public void mouseDragged(MouseEvent e){
		System.out.println("MouseMotionListener.mouseDragged"); 

		//Ending position
		x2 = e.getX();
		y2 = e.getY();
		drag = true; 
		repaint(); 


	}

	//Main method with new Canvas to test 
	public static void main(String[] args){

		JFrame frame = new JFrame("Canvas");
		Canvas canvas = new Canvas(); 

		
		frame.setSize(300, 300);
		frame.add(canvas); 
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		System.out.println("All Done"); 

	}







}
