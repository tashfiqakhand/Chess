import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;


//by Tashfiq Akhand
public class Chess extends JFrame implements ActionListener{

	public static void main(String args[]) {
		new board().setVisible(true);
	}
	
	private Chess(){
		
		setSize(100,100);
		setBackground(Color.GREEN);
		setLayout(new FlowLayout()); //button border and layout
		setResizable(true); //resizes window
	
		setDefaultCloseOperation(EXIT_ON_CLOSE); //exits program on close
		
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
	}

}
