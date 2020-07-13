import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class board extends JFrame implements ActionListener{
	static JButton board[][] = new JButton[8][8];//chess board
	static int col;
	static int row;
	static int r, c;//used for bishop
	static ImageIcon icon;
	//BLACK PIECES
	static ImageIcon Bpawn[] = new ImageIcon[8];
	static ImageIcon Wpawn[] = new ImageIcon[8];
	static ImageIcon Bpro1 = new ImageIcon("Bqueen.png");
	static ImageIcon Bpro2 = new ImageIcon("Bqueen.png");
	static ImageIcon Bpro3 = new ImageIcon("Bqueen.png");
	static ImageIcon Bpro4 = new ImageIcon("Bqueen.png");
	static ImageIcon Bpro5 = new ImageIcon("Bqueen.png");
	static ImageIcon Bpro6 = new ImageIcon("Bqueen.png");
	static ImageIcon Bpro7 = new ImageIcon("Bqueen.png");
	static ImageIcon Bpro8 = new ImageIcon("Bqueen.png");
	static ImageIcon Bking = new ImageIcon("Bking.png");
	static ImageIcon Bqueen = new ImageIcon("Bqueen.png");
	static ImageIcon Brook1 = new ImageIcon("Brook.png");
	static ImageIcon Brook2 = new ImageIcon("Brook.png");
	static ImageIcon Bknight1 = new ImageIcon("Bknight.png");
	static ImageIcon Bknight2 = new ImageIcon("Bknight.png");
	static ImageIcon Bbishop1 = new ImageIcon("Bbishop.png");
	static ImageIcon Bbishop2 = new ImageIcon("Bbishop.png");
	//WHITE PIECES
	static ImageIcon Wking = new ImageIcon("Wking.png");
	static ImageIcon Wqueen = new ImageIcon("Wqueen.png");
	static ImageIcon Wrook1 = new ImageIcon("Wrook.png");
	static ImageIcon Wrook2 = new ImageIcon("Wrook.png");
	static ImageIcon Wknight1 = new ImageIcon("Wknight.png");
	static ImageIcon Wknight2 = new ImageIcon("Wknight.png");
	static ImageIcon Wbishop1 = new ImageIcon("Wbishop.png");
	static ImageIcon Wbishop2 = new ImageIcon("Wbishop.png");
	static ImageIcon Wpro1 = new ImageIcon("Wqueen.png");
	static ImageIcon Wpro2 = new ImageIcon("Wqueen.png");
	static ImageIcon Wpro3 = new ImageIcon("Wqueen.png");
	static ImageIcon Wpro4 = new ImageIcon("Wqueen.png");
	static ImageIcon Wpro5 = new ImageIcon("Wqueen.png");
	static ImageIcon Wpro6 = new ImageIcon("Wqueen.png");
	static ImageIcon Wpro7 = new ImageIcon("Wqueen.png");
	static ImageIcon Wpro8 = new ImageIcon("Wqueen.png");
	
	//helps for turn base
	static boolean black=false;
	static boolean white=true;
	

	public board() {
		
        super("Chess Game");
		
		setSize(600,600);
		setBackground(Color.GREEN);
		setLayout(new GridLayout(8,8)); //button border and layout
		setResizable(true); //resizes window
	
		setDefaultCloseOperation(EXIT_ON_CLOSE); //exits program on close
		//Initializes board color
		for (row = 0; row < 8; row ++) {
		      for (col = 0; col < 8; col++) {
		    	board[row][col] = new JButton();
		    	  if (row % 2 == 0) {
		    	    if (col % 2 == 0){
		    		board[row][col].setBackground(Color.WHITE);
		    	    }
		    	    else board[row][col].setBackground(Color.GRAY);
		          }
		    	  else {
		    	    if (col % 2 == 0){
		  	          board[row][col].setBackground(Color.GRAY);
		  	    	}
		  	    	else board[row][col].setBackground(Color.WHITE);
		    	  }
		    	  add(board[row][col]);
		      }
	   } //initializes each element in the chess board
	   //BLACK PIECES
	   board[7][4].setIcon(Bking);
	   board[7][3].setIcon(Bqueen);
	   board[7][0].setIcon(Brook1);
	   board[7][7].setIcon(Brook2);
	   board[7][1].setIcon(Bknight1);
	   board[7][6].setIcon(Bknight2);
	   board[7][2].setIcon(Bbishop1);
	   board[7][5].setIcon(Bbishop2);
	   for (int i = 0; i < 8; i++){//black pawns
		   Bpawn[i] = new ImageIcon("Bpawn.png");
		   board[6][i].setIcon(Bpawn[i]);
	   }
	   
	   //WHITE PIECES
	   board[0][4].setIcon(Wking);
	   board[0][3].setIcon(Wqueen);
	   board[0][0].setIcon(Wrook1);
	   board[0][7].setIcon(Wrook2);
	   board[0][1].setIcon(Wknight1);
	   board[0][6].setIcon(Wknight2);
	   board[0][2].setIcon(Wbishop1);
	   board[0][5].setIcon(Wbishop2);
	   for (int i = 0; i < 8; i++){//white pawns
		   Wpawn[i] = new ImageIcon("Wpawn.png");
		   board[1][i].setIcon(Wpawn[i]);
	   }
	   for (row = 0; row < 8; row++) {
		     for (col = 0; col < 8; col++) {
		    	 board[row][col].addActionListener(this);
		     }
	   }
	   
   }

	
	public void actionPerformed(ActionEvent t) {
		//allows action to occur when clicked 
		 King(t);
		 Queen(t);
		 Knight(t);
		 Bishop(t);
		 Rook(t);
		 Pawn(t);
         PawnToQueen(t);
	}
	
	
	
	void King(ActionEvent t){
		if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Bking&&black==true){
			 gridcolor();//sets to default board color
			 icon = Bking;
			 row = getRow(icon);//gets the icons row
			 col = getCol(icon);//gets the icons column
			 
			//checks conditions and restriction for highlighted moves to show
			 if ((row-1)<8 && (row-1)>-1 && (col)<8 && (col)>-1&&Bcheck((row-1),col)==true)board[row-1][col].setBackground(Color.cyan);
			 if ((row-1)<8 && (row-1)>-1 && (col+1)<8 && (col+1)>-1&&Bcheck((row-1),col+1)==true)board[row-1][col+1].setBackground(Color.cyan);
			 if ((row)<8 && (row)>-1 && (col+1)<8 && (col+1)>-1&&Bcheck((row),col+1)==true)board[row][col+1].setBackground(Color.cyan);
			 if ((row+1)<8 && (row+1)>-1 && (col+1)<8 && (col+1)>-1&&Bcheck((row+1),col+1)==true)board[row+1][col+1].setBackground(Color.cyan);
			 if ((row+1)<8 && (row+1)>-1 && (col)<8 && (col)>-1&&Bcheck((row+1),col)==true)board[row+1][col].setBackground(Color.cyan);
			 if ((row+1)<8 && (row+1)>-1 && (col-1)<8 && (col-1)>-1&&Bcheck((row+1),col-1)==true)board[row+1][col-1].setBackground(Color.cyan);
			 if ((row)<8 && (row)>-1 && (col-1)<8 && (col-1)>-1&&Bcheck((row),col-1)==true)board[row][col-1].setBackground(Color.cyan);
			 if ((row-1)<8 && (row-1)>-1 && (col-1)<8 && (col-1)>-1&&Bcheck((row-1),col-1)==true)board[row-1][col-1].setBackground(Color.cyan);

		 }
		//move up when clicked
		 if ((row-1)<8 && (row-1)>-1 && (col)<8 && (col)>-1&&row == getRow(Bking) && col == getCol(Bking) && t.getSource() == board[row-1][col]
				 &&black==true&&Bcheck((row-1),col)==true){
			 icon = Bking;
			 row = getRow(icon);//gets row
			 col = getCol(icon);//gets col
			 board[row][col].setIcon(null); 
		     board[row-1][col].setIcon(Bking);//moves icon
		     gridcolor();//sets color of board to default colors
		     black=false;//allows black piece to turn off until a white piece is played
		     white=true;//white piece turns on
		 }
		 //moves upright when clicked
        if ((row-1)<8 && (row-1)>-1 && (col+1)<8 && (col+1)>-1&&row == getRow(Bking) && col == getCol(Bking) && t.getSource() == board[row-1][col+1]
       		 &&black==true&&Bcheck((row-1),col)==true){
       	 icon = Bking;
			 row = getRow(icon);
			 col = getCol(icon);
			 board[row][col].setIcon(null); 
		     board[row-1][col+1].setIcon(Bking);//moves icon
		     gridcolor();//sets color of board to default colors
		     black=false;
		     white=true;

		 }
        //moves right when clicked
        if ((row)<8 && (row)>-1 && (col+1)<8 && (col+1)>-1&&row == getRow(Bking) && col == getCol(Bking) && t.getSource() == board[row][col+1]
       		 &&black==true&&Bcheck((row),col+1)==true){
       	     icon = Bking;
			 row = getRow(icon);
			 col = getCol(icon);
			 board[row][col].setIcon(null); 
		     board[row][col+1].setIcon(Bking);//moves icon
		     gridcolor();//sets color of board to default colors
		     black=false;
		     white=true;
		 }
        //moves downright when clicked
        if ((row+1)<8 && (row+1)>-1 && (col+1)<8 && (col+1)>-1&&row == getRow(Bking) && col == getCol(Bking) && t.getSource() == board[row+1][col+1]
       		 &&black==true&&Bcheck((row+1),col+1)==true){
       	     icon = Bking;
			 row = getRow(icon);
			 col = getCol(icon);
			 board[row][col].setIcon(null); 
		     board[row+1][col+1].setIcon(Bking);//moves icon
		     gridcolor();//sets color of board to default colors
		     black=false;
		     white=true;
        }
        //moves down when clicked
        if ((row+1)<8 && (row+1)>-1 && (col)<8 && (col)>-1&&row == getRow(Bking) && col == getCol(Bking) && t.getSource() == board[row+1][col]
       		 &&black==true&&Bcheck((row+1),col)==true){
       	     icon = Bking;
			 row = getRow(icon);
			 col = getCol(icon);
			 board[row][col].setIcon(null); 
		     board[row+1][col].setIcon(Bking);//moves icon
		     gridcolor();//sets color of board to default colors
		     black=false;
		     white=true;
        }
        //moves downleft when clicked
        if ((row+1)<8 && (row+1)>-1 && (col-1)<8 && (col-1)>-1&&row == getRow(Bking) && col == getCol(Bking) && t.getSource() == board[row+1][col-1]
       		 &&black==true&&Bcheck((row+1),col-1)==true){
       	     icon = Bking;
			 row = getRow(icon);
			 col = getCol(icon);
			 board[row][col].setIcon(null); 
		     board[row+1][col-1].setIcon(Bking);//moves icon
		     gridcolor();//sets color of board to default colors
		     black=false;
		     white=true;
        }
        //moves left when clicked
        if ((row)<8 && (row)>-1 && (col-1)<8 && (col-1)>-1&&row == getRow(Bking) && col == getCol(Bking) && t.getSource() == board[row][col-1]
       		 &&black==true&&Bcheck((row),col-1)==true){
       	     icon = Bking;
			 row = getRow(icon);
			 col = getCol(icon);
			 board[row][col].setIcon(null); 
		     board[row][col-1].setIcon(Bking);//moves icon
		     gridcolor();//sets color of board to default colors
		     black=false;
		     white=true;
        }
        //moves upleft when clicked
        if ((row-1)<8 && (row-1)>-1 && (col-1)<8 && (col-1)>-1&&row == getRow(Bking) && col == getCol(Bking) && t.getSource() == board[row-1][col-1]
       		 &&black==true&&Bcheck((row-1),col-1)==true){
       	     icon = Bking;
			 row = getRow(icon);
			 col = getCol(icon);
			 board[row][col].setIcon(null); 
		     board[row-1][col-1].setIcon(Bking);//moves icon
		     gridcolor();//sets color of board to default colors
		     black=false;
		     white=true;
        }
        //same format as the black king but it is the white king instead
        if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Wking&&white==true){
       	     gridcolor();
			 icon = Wking;
			 row = getRow(icon);
			 col = getCol(icon);
			 
			 if ((row-1)<8 && (row-1)>-1 && (col)<8 && (col)>-1&&Wcheck((row-1),col)==true)board[row-1][col].setBackground(Color.cyan);
			 if ((row-1)<8 && (row-1)>-1 && (col+1)<8 && (col+1)>-1&&Wcheck((row-1),col+1)==true)board[row-1][col+1].setBackground(Color.cyan);
			 if ((row)<8 && (row)>-1 && (col+1)<8 && (col+1)>-1&&Wcheck((row),col+1)==true)board[row][col+1].setBackground(Color.cyan);
			 if ((row+1)<8 && (row+1)>-1 && (col+1)<8 && (col+1)>-1&&Wcheck((row+1),col+1)==true)board[row+1][col+1].setBackground(Color.cyan);
			 if ((row+1)<8 && (row+1)>-1 && (col)<8 && (col)>-1&&Wcheck((row+1),col)==true)board[row+1][col].setBackground(Color.cyan);
			 if ((row+1)<8 && (row+1)>-1 && (col-1)<8 && (col-1)>-1&&Wcheck((row+1),col-1)==true)board[row+1][col-1].setBackground(Color.cyan);
			 if ((row)<8 && (row)>-1 && (col-1)<8 && (col-1)>-1&&Wcheck((row),col-1)==true)board[row][col-1].setBackground(Color.cyan);
			 if ((row-1)<8 && (row-1)>-1 && (col-1)<8 && (col-1)>-1&&Wcheck((row-1),col-1)==true)board[row-1][col-1].setBackground(Color.cyan);

		 }
		 if ((row-1)<8 && (row-1)>-1 && (col)<8 && (col)>-1&&row == getRow(Wking) && col == getCol(Wking) && t.getSource() == board[row-1][col]
				 &&white==true&&Wcheck((row-1),col)==true){
			 icon = Wking;
			 row = getRow(icon);
			 col = getCol(icon);
			 board[row][col].setIcon(null); 
		     board[row-1][col].setIcon(Wking);
		     gridcolor();
		     white=false;//sets white pieces off until black piece is played
		     black=true;//turns black piece on
		 }
        if ((row-1)<8 && (row-1)>-1 && (col+1)<8 && (col+1)>-1&&row == getRow(Wking) && col == getCol(Wking) && t.getSource() == board[row-1][col+1]
       		 &&white==true&&Wcheck((row-1),col+1)==true){
       	     icon = Wking;
			 row = getRow(icon);
			 col = getCol(icon);
			 board[row][col].setIcon(null); 
		     board[row-1][col+1].setIcon(Wking);
		     gridcolor();
		     white=false;
		     black=true;
		 }
        if ((row)<8 && (row)>-1 && (col+1)<8 && (col+1)>-1&&row == getRow(Wking) && col == getCol(Wking) && t.getSource() == board[row][col+1]
       		 &&white==true&&Wcheck((row),col+1)==true){
       	    icon = Wking;
			 row = getRow(icon);
			 col = getCol(icon);
			 board[row][col].setIcon(null); 
		     board[row][col+1].setIcon(Wking);
		     gridcolor();
		     white=false;
		     black=true;
		 }
        if ((row+1)<8 && (row+1)>-1 && (col+1)<8 && (col+1)>-1&&row == getRow(Wking) && col == getCol(Wking) && t.getSource() == board[row+1][col+1]
       		 &&white==true&&Wcheck((row+1),col+1)==true){
       	     icon = Wking;
			 row = getRow(icon);
			 col = getCol(icon);
			 board[row][col].setIcon(null); 
		     board[row+1][col+1].setIcon(Wking);
		     gridcolor();
		     white=false;
		     black=true;
        }
        if ((row+1)<8 && (row+1)>-1 && (col)<8 && (col)>-1&&row == getRow(Wking) && col == getCol(Wking) && t.getSource() == board[row+1][col]
       		 &&white==true&&Wcheck((row+1),col)==true){
          	 icon = Wking;
			 row = getRow(icon);
			 col = getCol(icon);
			 board[row][col].setIcon(null); 
		     board[row+1][col].setIcon(Wking);
		     gridcolor();
		     white=false;
		     black=true;
        }
        if ((row+1)<8 && (row+1)>-1 && (col-1)<8 && (col-1)>-1&&row == getRow(Wking) && col == getCol(Wking) && t.getSource() == board[row+1][col-1]
       		 &&white==true&&Wcheck((row+1),col-1)==true){
       	     icon = Wking;
			 row = getRow(icon);
			 col = getCol(icon);
			 board[row][col].setIcon(null); 
		     board[row+1][col-1].setIcon(Wking);
		     gridcolor();
		     white=false;
		     black=true;
        }
        if ((row)<8 && (row)>-1 && (col-1)<8 && (col-1)>-1&&row == getRow(Wking) && col == getCol(Wking) && t.getSource() == board[row][col-1]
       		 &&white==true&&Wcheck((row),col-1)==true){
       	     icon = Wking;
			 row = getRow(icon);
			 col = getCol(icon);
			 board[row][col].setIcon(null); 
		     board[row][col-1].setIcon(Wking);
		     gridcolor();
		     white=false;
		     black=true;
        }
        if ((row-1)<8 && (row-1)>-1 && (col-1)<8 && (col-1)>-1&&row == getRow(Wking) && col == getCol(Wking) && t.getSource() == board[row-1][col-1]
       		 &&white==true&&Wcheck((row-1),col-1)==true){
       	     icon = Wking;
			 row = getRow(icon);
			 col = getCol(icon);
			 board[row][col].setIcon(null); 
		     board[row-1][col-1].setIcon(Wking);
		     gridcolor();
		     white=false;
		     black=true;
        }
	}
	
	void Queen(ActionEvent t){
		c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Bqueen&&black==true){
			 gridcolor();//sets board to original colors
			 icon = Bqueen;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 //highlights possible moves like the bishop
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	
				 }
				 c++;
			 }
			 for (int i = 1; i <= 7; i++){
				 //highlights possible moves like the rook
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Bcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Bcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Bcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Bcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (r=1; r <=7; r++){
			 //moves upleft when clicked
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bqueen) && col == getCol(Bqueen) 
					 && t.getSource() == board[row-r][col-c]&&black==true&&Bcheck((row-r),(col-c))==true){
				 icon = Bqueen;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); //sets piece's original position to null
			     board[row-r][col-c].setIcon(Bqueen);//sets piece to new position
			     gridcolor();//sets board to original colors
			     black=false;
			     white=true;
			 }
			 //moves upright when clicked
            if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bqueen) && col == getCol(Bqueen) 
           		 && t.getSource() == board[row-r][col+c]&&black==true&&Bcheck((row-r),(col+c))==true){
           	 icon = Bqueen;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); //sets piece's original position to null
   		     board[row-r][col+c].setIcon(Bqueen);//sets piece to new position
   		     gridcolor();//sets board to original colors
   		     black=false;
   		     white=true;
			 }
            //moves downleft when clicked
            if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bqueen) && col == getCol(Bqueen) 
           		 && t.getSource() == board[row+r][col-c]&&black==true&&Bcheck((row+r),(col-c))==true){
           	 icon = Bqueen;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); //sets piece's original position to null
   		     board[row+r][col-c].setIcon(Bqueen);//sets piece to new position
   		     gridcolor();//sets board to original colors
   		     black=false;
   		     white=true;
			 }
            //moves downright when clicked
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bqueen) && col == getCol(Bqueen) 
           		 && t.getSource() == board[row+r][col+c]&&black==true&&Bcheck((row+r),(col+c))==true){
           	 icon = Bqueen;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); //sets piece's original position to null
   		     board[row+r][col+c].setIcon(Bqueen);//sets piece to new position
   		     gridcolor();//sets board to original colors
   		     black=false;
   		     white=true;
            }
			 
			 c++;
		 }
		 for (int i = 1; i<8 ; i++){
			 //moves up when clicked
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Bqueen) && col == getCol(Bqueen) 
					 && t.getSource() == board[row-i][col]&&black==true&&Bcheck((row-i),(col))==true){
				 icon = Bqueen;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); //sets piece's original position to null
			     board[row-i][col].setIcon(Bqueen);//sets piece to new position
			     gridcolor();//sets board to original colors
			     black=false;
			     white=true;
			 }
			 //moves down when clicked
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Bqueen) && col == getCol(Bqueen) 
					 && t.getSource() == board[row+i][col]&&black==true&&Bcheck((row+i),(col))==true){
				 icon = Bqueen;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); //sets piece's original position to null
			     board[row+i][col].setIcon(Bqueen);//sets piece to new position
			     gridcolor();//sets board to original colors
			     black=false;
			     white=true;
			 }
			 //moves lefts when clicked
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Bqueen) && col == getCol(Bqueen) 
					 && t.getSource() == board[row][col-i]&&black==true&&Bcheck((row),(col-i))==true){
				 icon = Bqueen;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); //sets piece's original position to null
			     board[row][col-i].setIcon(Bqueen);//sets piece to new position
			     gridcolor();//sets board to original colors
			     black=false;
			     white=true;
			 }
			 //moves right when clicked
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Bqueen) && col == getCol(Bqueen) 
					 && t.getSource() == board[row][col+i]&&black==true&&Bcheck((row),(col+i))==true){
				 icon = Bqueen;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); //sets piece's original position to null
			     board[row][col+i].setIcon(Bqueen);//sets piece to new position
			     gridcolor();//sets board to original colors
			     black=false;
			     white=true;
			 }
		 }
		 //same as black king but white king instead
		 c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Wqueen&&white==true){
			 gridcolor();
			 icon = Wqueen;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	
				 }
				 c++;
			 }
			 for (int i = 1; i <= 7; i++){
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Wcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Wcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Wcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Wcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (r=1; r <=7; r++){
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wqueen) && col == getCol(Wqueen) 
					 && t.getSource() == board[row-r][col-c]&&white==true&&Wcheck((row-r),(col-c))==true){
				 icon = Wqueen;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-r][col-c].setIcon(Wqueen);
			     gridcolor();
			     white=false;
			     black=true;
			 }
            if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wqueen) && col == getCol(Wqueen) 
           		 && t.getSource() == board[row-r][col+c]&&white==true&&Wcheck((row-r),(col+c))==true){
           	 icon = Wqueen;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row-r][col+c].setIcon(Wqueen);
   		     gridcolor();
   		     white=false;
   		     black=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wqueen) && col == getCol(Wqueen) 
           		 && t.getSource() == board[row+r][col-c]&&white==true&&Wcheck((row+r),(col-c))==true){
           	 icon = Wqueen;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col-c].setIcon(Wqueen);
   		     gridcolor();
   		     white=false;
   		     black=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wqueen) && col == getCol(Wqueen) 
           		 && t.getSource() == board[row+r][col+c]&&white==true&&Wcheck((row+r),(col+c))==true){
           	 icon = Wqueen;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col+c].setIcon(Wqueen);
   		     gridcolor();
   		     white=false;
   		     black=true;
            }
			 
			 c++;
		 }
		 for (int i = 1; i<8 ; i++){
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wqueen) && col == getCol(Wqueen) 
					 && t.getSource() == board[row-i][col]&&white==true&&Wcheck((row-i),(col))==true){
				 icon = Wqueen;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-i][col].setIcon(Wqueen);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wqueen) && col == getCol(Wqueen) 
					 && t.getSource() == board[row+i][col]&&white==true&&Wcheck((row+i),(col))==true){
				 icon = Wqueen;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row+i][col].setIcon(Wqueen);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Wqueen) && col == getCol(Wqueen) 
					 && t.getSource() == board[row][col-i]&&white==true&&Wcheck((row),(col-i))==true){
				 icon = Wqueen;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col-i].setIcon(Wqueen);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Wqueen) && col == getCol(Wqueen) 
					 && t.getSource() == board[row][col+i]&&white==true&&Wcheck((row),(col+i))==true){
				 icon = Wqueen;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col+i].setIcon(Wqueen);
			     gridcolor();
			     white=false;
			     black=true;
			 }
		 }
	}
    
	void Knight(ActionEvent t){
		if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Bknight1&&black==true){
			 gridcolor();//sets board to original color
			 icon = Bknight1;
			 row = getRow(icon);
			 col = getCol(icon);
			 //highlights possible moves
			 if ((row-2)<8 && (row-2)>-1 && (col-1)<8 && (col-1)>-1&&Bcheck((row-2),(col-1))==true) board[row-2][col-1].setBackground(Color.cyan);
			 if ((row-2)<8 && (row-2)>-1 && (col+1)<8 && (col+1)>-1&&Bcheck((row-2),(col+1))==true) board[row-2][col+1].setBackground(Color.cyan);
			 if ((row-1)<8 && (row-1)>-1 && (col+2)<8 && (col+2)>-1&&Bcheck((row-1),(col+2))==true) board[row-1][col+2].setBackground(Color.cyan);
			 if ((row+1)<8 && (row+1)>-1 && (col+2)<8 && (col+2)>-1&&Bcheck((row+1),(col+2))==true) board[row+1][col+2].setBackground(Color.cyan);
			 if ((row+2)<8 && (row+2)>-1 && (col+1)<8 && (col+1)>-1&&Bcheck((row+2),(col+1))==true) board[row+2][col+1].setBackground(Color.cyan);
			 if ((row+2)<8 && (row+2)>-1 && (col-1)<8 && (col-1)>-1&&Bcheck((row+2),(col-1))==true) board[row+2][col-1].setBackground(Color.cyan);
			 if ((row+1)<8 && (row+1)>-1 && (col-2)<8 && (col-2)>-1&&Bcheck((row+1),(col-2))==true) board[row+1][col-2].setBackground(Color.cyan);
			 if ((row-1)<8 && (row-1)>-1 && (col-2)<8 && (col-2)>-1&&Bcheck((row-1),(col-2))==true) board[row-1][col-2].setBackground(Color.cyan);
		 }
		//moves up2left1 when clicked
		 if ((row-2)<8 && (row-2)>-1 && (col-1)<8 && (col-1)>-1&&row == getRow(Bknight1) && col == getCol(Bknight1) 
				 && t.getSource() == board[row-2][col-1]&&black==true&&Bcheck((row-2),(col-1))==true){
			 icon = Bknight1;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); //sets piece's original position to null
		     board[row-2][col-1].setIcon(Bknight1);//sets piece to new position 
		     gridcolor();//sets board to original color
		     black=false;
		     white=true;
		 }
		 //moves up2right1 when clicked
		 if ((row-2)<8 && (row-2)>-1 && (col+1)<8 && (col+1)>-1&&row == getRow(Bknight1) && col == getCol(Bknight1) 
				 && t.getSource() == board[row-2][col+1]&&black==true&&Bcheck((row-2),(col+1))==true){
			 icon = Bknight1;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); //sets piece's original position to null
		     board[row-2][col+1].setIcon(Bknight1);//sets piece to new position 
		     gridcolor();//sets board to original color
		     black=false;
		     white=true;
		 }
		 //moves up1right2 when clicked
		 if ((row-1)<8 && (row-1)>-1 && (col+2)<8 && (col+2)>-1&&row == getRow(Bknight1) && col == getCol(Bknight1) 
				 && t.getSource() == board[row-1][col+2]&&black==true&&Bcheck((row-1),(col+2))==true){
			 icon = Bknight1;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); //sets piece's original position to null
		     board[row-1][col+2].setIcon(Bknight1);//sets piece to new position 
		     gridcolor();//sets board to original color
		     black=false;
		     white=true;
		 }
		 //moves down2right1 when clicked
		 if ((row+2)<8 && (row+2)>-1 && (col+1)<8 && (col+1)>-1&&row == getRow(Bknight1) && col == getCol(Bknight1) 
				 && t.getSource() == board[row+2][col+1]&&black==true&&Bcheck((row+2),(col+1))==true){
			 icon = Bknight1;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); //sets piece's original position to null
		     board[row+2][col+1].setIcon(Bknight1);//sets piece to new position 
		     gridcolor();//sets board to original color
		     black=false;
		     white=true;
		 }
		 //moves down1right2 when clicked
		 if ((row+1)<8 && (row+1)>-1 && (col+2)<8 && (col+2)>-1&&row == getRow(Bknight1) && col == getCol(Bknight1) 
				 && t.getSource() == board[row+1][col+2]&&black==true&&Bcheck((row+1),(col+2))==true){
			 icon = Bknight1;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); //sets piece's original position to null
		     board[row+1][col+2].setIcon(Bknight1);//sets piece to new position 
		     gridcolor();//sets board to original color
		     black=false;
		     white=true;
		 }
		 //moves down2left1 when clicked
		 if ((row+2)<8 && (row+2)>-1 && (col-1)<8 && (col-1)>-1&&row == getRow(Bknight1) && col == getCol(Bknight1) 
				 && t.getSource() == board[row+2][col-1]&&black==true&&Bcheck((row+2),(col-1))==true){
			 icon = Bknight1;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); //sets piece's original position to null
		     board[row+2][col-1].setIcon(Bknight1);//sets piece to new position 
		     gridcolor();//sets board to original color
		     black=false;
		     white=true;
		 }
		 //moves down1left2 when clicked
		 if ((row+1)<8 && (row+1)>-1 && (col-2)<8 && (col-2)>-1&&row == getRow(Bknight1) && col == getCol(Bknight1) 
				 && t.getSource() == board[row+1][col-2]&&black==true&&Bcheck((row+1),(col-2))==true){
			 icon = Bknight1;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); //sets piece's original position to null
		     board[row+1][col-2].setIcon(Bknight1);//sets piece to new position 
		     gridcolor();//sets board to original color
		     black=false;
		     white=true;
		 }
		 //moves down1left2 when clicked
		 if ((row-1)<8 && (row-1)>-1 && (col-2)<8 && (col-2)>-1&&row == getRow(Bknight1) && col == getCol(Bknight1) 
				 && t.getSource() == board[row-1][col-2]&&black==true&&Bcheck((row-1),(col-2))==true){
			 icon = Bknight1;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); //sets piece's original position to null
		     board[row-1][col-2].setIcon(Bknight1);//sets piece to new position 
		     gridcolor();//sets board to original color
		     black=false;
		     white=true;
		 }
		 
         //same as the first black knight
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Bknight2&&black==true){
			 gridcolor();
			 icon = Bknight2;
			 row = getRow(icon);
			 col = getCol(icon);
			 if ((row-2)<8 && (row-2)>-1 && (col-1)<8 && (col-1)>-1&&Bcheck((row-2),(col-1))==true) board[row-2][col-1].setBackground(Color.cyan);
			 if ((row-2)<8 && (row-2)>-1 && (col+1)<8 && (col+1)>-1&&Bcheck((row-2),(col+1))==true) board[row-2][col+1].setBackground(Color.cyan);
			 if ((row-1)<8 && (row-1)>-1 && (col+2)<8 && (col+2)>-1&&Bcheck((row-1),(col+2))==true) board[row-1][col+2].setBackground(Color.cyan);
			 if ((row+1)<8 && (row+1)>-1 && (col+2)<8 && (col+2)>-1&&Bcheck((row+1),(col+2))==true) board[row+1][col+2].setBackground(Color.cyan);
			 if ((row+2)<8 && (row+2)>-1 && (col+1)<8 && (col+1)>-1&&Bcheck((row+2),(col+1))==true) board[row+2][col+1].setBackground(Color.cyan);
			 if ((row+2)<8 && (row+2)>-1 && (col-1)<8 && (col-1)>-1&&Bcheck((row+2),(col-1))==true) board[row+2][col-1].setBackground(Color.cyan);
			 if ((row+1)<8 && (row+1)>-1 && (col-2)<8 && (col-2)>-1&&Bcheck((row+1),(col-2))==true) board[row+1][col-2].setBackground(Color.cyan);
			 if ((row-1)<8 && (row-1)>-1 && (col-2)<8 && (col-2)>-1&&Bcheck((row-1),(col-2))==true) board[row-1][col-2].setBackground(Color.cyan);
		 }
		 if ((row-2)<8 && (row-2)>-1 && (col-1)<8 && (col-1)>-1&&row == getRow(Bknight2) && col == getCol(Bknight2) 
				 && t.getSource() == board[row-2][col-1]&&black==true&&Bcheck((row-2),(col-1))==true){
			 icon = Bknight2;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row-2][col-1].setIcon(Bknight2);
		     gridcolor();
		     black=false;
		     white=true;
		 }
		 if ((row-2)<8 && (row-2)>-1 && (col+1)<8 && (col+1)>-1&&row == getRow(Bknight2) && col == getCol(Bknight2) 
				 && t.getSource() == board[row-2][col+1]&&black==true&&Bcheck((row-2),(col+1))==true){
			 icon = Bknight2;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row-2][col+1].setIcon(Bknight2);
		     gridcolor();
		     black=false;
		     white=true;
		 }
		 if ((row-1)<8 && (row-1)>-1 && (col+2)<8 && (col+2)>-1&&row == getRow(Bknight2) && col == getCol(Bknight2) 
				 && t.getSource() == board[row-1][col+2]&&black==true&&Bcheck((row-1),(col+2))==true){
			 icon = Bknight2;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row-1][col+2].setIcon(Bknight2);
		     gridcolor();
		     black=false;
		     white=true;
		 }
		 if ((row+2)<8 && (row+2)>-1 && (col+1)<8 && (col+1)>-1&&row == getRow(Bknight2) && col == getCol(Bknight2) 
				 && t.getSource() == board[row+2][col+1]&&black==true&&Bcheck((row+2),(col+1))==true){
			 icon = Bknight2;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row+2][col+1].setIcon(Bknight2);
		     gridcolor();
		     black=false;
		     white=true;
		 }
		 if ((row+1)<8 && (row+1)>-1 && (col+2)<8 && (col+2)>-1&&row == getRow(Bknight2) && col == getCol(Bknight2) 
				 && t.getSource() == board[row+1][col+2]&&black==true&&Bcheck((row+1),(col+2))==true){
			 icon = Bknight2;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row+1][col+2].setIcon(Bknight2);
		     gridcolor();
		     black=false;
		     white=true;
		 }
		 if ((row+2)<8 && (row+2)>-1 && (col-1)<8 && (col-1)>-1&&row == getRow(Bknight2) && col == getCol(Bknight2) 
				 && t.getSource() == board[row+2][col-1]&&black==true&&Bcheck((row+2),(col-1))==true){
			 icon = Bknight2;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row+2][col-1].setIcon(Bknight2);
		     gridcolor();
		     black=false;
		     white=true;
		 }
		 if ((row+1)<8 && (row+1)>-1 && (col-2)<8 && (col-2)>-1&&row == getRow(Bknight2) && col == getCol(Bknight2) 
				 && t.getSource() == board[row+1][col-2]&&black==true&&Bcheck((row+1),(col-2))==true){
			 icon = Bknight2;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row+1][col-2].setIcon(Bknight2);
		     gridcolor();
		     black=false;
		     white=true;
		 }
		 if ((row-1)<8 && (row-1)>-1 && (col-2)<8 && (col-2)>-1&&row == getRow(Bknight2) && col == getCol(Bknight2) 
				 && t.getSource() == board[row-1][col-2]&&black==true&&Bcheck((row-1),(col-2))==true){
			 icon = Bknight2;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row-1][col-2].setIcon(Bknight2);
		     gridcolor();
		     black=false;
		     white=true;
		 }	
		 //same as the black knights but white knights instead
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Wknight1&&white==true){
			 gridcolor();
			 icon = Wknight1;
			 row = getRow(icon);
			 col = getCol(icon);
			 if ((row-2)<8 && (row-2)>-1 && (col-1)<8 && (col-1)>-1&&Wcheck((row-2),(col-1))==true) board[row-2][col-1].setBackground(Color.cyan);
			 if ((row-2)<8 && (row-2)>-1 && (col+1)<8 && (col+1)>-1&&Wcheck((row-2),(col+1))==true) board[row-2][col+1].setBackground(Color.cyan);
			 if ((row-1)<8 && (row-1)>-1 && (col+2)<8 && (col+2)>-1&&Wcheck((row-1),(col+2))==true) board[row-1][col+2].setBackground(Color.cyan);
			 if ((row+1)<8 && (row+1)>-1 && (col+2)<8 && (col+2)>-1&&Wcheck((row+1),(col+2))==true) board[row+1][col+2].setBackground(Color.cyan);
			 if ((row+2)<8 && (row+2)>-1 && (col+1)<8 && (col+1)>-1&&Wcheck((row+2),(col+1))==true) board[row+2][col+1].setBackground(Color.cyan);
			 if ((row+2)<8 && (row+2)>-1 && (col-1)<8 && (col-1)>-1&&Wcheck((row+2),(col-1))==true) board[row+2][col-1].setBackground(Color.cyan);
			 if ((row+1)<8 && (row+1)>-1 && (col-2)<8 && (col-2)>-1&&Wcheck((row+1),(col-2))==true) board[row+1][col-2].setBackground(Color.cyan);
			 if ((row-1)<8 && (row-1)>-1 && (col-2)<8 && (col-2)>-1&&Wcheck((row-1),(col-2))==true) board[row-1][col-2].setBackground(Color.cyan);
		 }
		 if ((row-2)<8 && (row-2)>-1 && (col-1)<8 && (col-1)>-1&&row == getRow(Wknight1) && col == getCol(Wknight1) 
				 && t.getSource() == board[row-2][col-1]&&white==true&&Wcheck((row-2),(col-1))==true){
			 icon = Wknight1;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row-2][col-1].setIcon(Wknight1);
		     gridcolor();
		     white=false;
		     black=true;
		 }
		 if ((row-2)<8 && (row-2)>-1 && (col+1)<8 && (col+1)>-1&&row == getRow(Wknight1) && col == getCol(Wknight1) 
				 && t.getSource() == board[row-2][col+1]&&white==true&&Wcheck((row-2),(col+1))==true){
			 icon = Wknight1;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row-2][col+1].setIcon(Wknight1);
		     gridcolor();
		     white=false;
		     black=true;
		 }
		 if ((row-1)<8 && (row-1)>-1 && (col+2)<8 && (col+2)>-1&&row == getRow(Wknight1) && col == getCol(Wknight1) 
				 && t.getSource() == board[row-1][col+2]&&white==true&&Wcheck((row-1),(col+2))==true){
			 icon = Wknight1;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row-1][col+2].setIcon(Wknight1);
		     gridcolor();
		     white=false;
		     black=true;
		 }
		 if ((row+2)<8 && (row+2)>-1 && (col+1)<8 && (col+1)>-1&&row == getRow(Wknight1) && col == getCol(Wknight1) 
				 && t.getSource() == board[row+2][col+1]&&white==true&&Wcheck((row+2),(col+1))==true){
			 icon = Wknight1;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row+2][col+1].setIcon(Wknight1);
		     gridcolor();
		     white=false;
		     black=true;
		 }
		 if ((row+1)<8 && (row+1)>-1 && (col+2)<8 && (col+2)>-1&&row == getRow(Wknight1) && col == getCol(Wknight1) 
				 && t.getSource() == board[row+1][col+2]&&white==true&&Wcheck((row+1),(col+2))==true){
			 icon = Wknight1;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row+1][col+2].setIcon(Wknight1);
		     gridcolor();
		     white=false;
		     black=true;
		 }
		 if ((row+2)<8 && (row+2)>-1 && (col-1)<8 && (col-1)>-1&&row == getRow(Wknight1) && col == getCol(Wknight1) 
				 && t.getSource() == board[row+2][col-1]&&white==true&&Wcheck((row+2),(col-1))==true){
			 icon = Wknight1;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row+2][col-1].setIcon(Wknight1);
		     gridcolor();
		     white=false;
		     black=true;
		 }
		 if ((row+1)<8 && (row+1)>-1 && (col-2)<8 && (col-2)>-1&&row == getRow(Wknight1) && col == getCol(Wknight1) 
				 && t.getSource() == board[row+1][col-2]&&white==true&&Wcheck((row+1),(col-2))==true){
			 icon = Wknight1;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row+1][col-2].setIcon(Wknight1);
		     gridcolor();
		     white=false;
		     black=true;
		 }
		 if ((row-1)<8 && (row-1)>-1 && (col-2)<8 && (col-2)>-1&&row == getRow(Wknight1) && col == getCol(Wknight1) 
				 && t.getSource() == board[row-1][col-2]&&white==true&&Wcheck((row-1),(col-2))==true){
			 icon = Wknight1;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row-1][col-2].setIcon(Wknight1);
		     gridcolor();
		     white=false;
		     black=true;
		 }
		//same as the black knights but white knights instead
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Wknight2&&white==true){
			 gridcolor();
			 icon = Wknight2;
			 row = getRow(icon);
			 col = getCol(icon);
			 if ((row-2)<8 && (row-2)>-1 && (col-1)<8 && (col-1)>-1&&Wcheck((row-2),(col-1))==true) board[row-2][col-1].setBackground(Color.cyan);
			 if ((row-2)<8 && (row-2)>-1 && (col+1)<8 && (col+1)>-1&&Wcheck((row-2),(col+1))==true) board[row-2][col+1].setBackground(Color.cyan);
			 if ((row-1)<8 && (row-1)>-1 && (col+2)<8 && (col+2)>-1&&Wcheck((row-1),(col+2))==true) board[row-1][col+2].setBackground(Color.cyan);
			 if ((row+1)<8 && (row+1)>-1 && (col+2)<8 && (col+2)>-1&&Wcheck((row+1),(col+2))==true) board[row+1][col+2].setBackground(Color.cyan);
			 if ((row+2)<8 && (row+2)>-1 && (col+1)<8 && (col+1)>-1&&Wcheck((row+2),(col+1))==true) board[row+2][col+1].setBackground(Color.cyan);
			 if ((row+2)<8 && (row+2)>-1 && (col-1)<8 && (col-1)>-1&&Wcheck((row+2),(col-1))==true) board[row+2][col-1].setBackground(Color.cyan);
			 if ((row+1)<8 && (row+1)>-1 && (col-2)<8 && (col-2)>-1&&Wcheck((row+1),(col-2))==true) board[row+1][col-2].setBackground(Color.cyan);
			 if ((row-1)<8 && (row-1)>-1 && (col-2)<8 && (col-2)>-1&&Wcheck((row-1),(col-2))==true) board[row-1][col-2].setBackground(Color.cyan);
		 }
		 if ((row-2)<8 && (row-2)>-1 && (col-1)<8 && (col-1)>-1&&row == getRow(Wknight2) && col == getCol(Wknight2) 
				 && t.getSource() == board[row-2][col-1]&&white==true&&Wcheck((row-2),(col-1))==true){
			 icon = Wknight2;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row-2][col-1].setIcon(Wknight2);
		     gridcolor();
		     white=false;
		     black=true;
		 }
		 if ((row-2)<8 && (row-2)>-1 && (col+1)<8 && (col+1)>-1&&row == getRow(Wknight2) && col == getCol(Wknight2) 
				 && t.getSource() == board[row-2][col+1]&&white==true&&Wcheck((row-2),(col+1))==true){
			 icon = Wknight2;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row-2][col+1].setIcon(Wknight2);
		     gridcolor();
		     white=false;
		     black=true;
		 }
		 if ((row-1)<8 && (row-1)>-1 && (col+2)<8 && (col+2)>-1&&row == getRow(Wknight2) && col == getCol(Wknight2) 
				 && t.getSource() == board[row-1][col+2]&&white==true&&Wcheck((row-1),(col+2))==true){
			 icon = Wknight2;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row-1][col+2].setIcon(Wknight2);
		     gridcolor();
		     white=false;
		     black=true;
		 }
		 if ((row+2)<8 && (row+2)>-1 && (col+1)<8 && (col+1)>-1&&row == getRow(Wknight2) && col == getCol(Wknight2) 
				 && t.getSource() == board[row+2][col+1]&&white==true&&Wcheck((row+2),(col+1))==true){
			 icon = Wknight2;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row+2][col+1].setIcon(Wknight2);
		     gridcolor();
		     white=false;
		     black=true;
		 }
		 if ((row+1)<8 && (row+1)>-1 && (col+2)<8 && (col+2)>-1&&row == getRow(Wknight2) && col == getCol(Wknight2) 
				 && t.getSource() == board[row+1][col+2]&&white==true&&Wcheck((row+1),(col+2))==true){
			 icon = Wknight2;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row+1][col+2].setIcon(Wknight2);
		     gridcolor();
		     white=false;
		     black=true;
		 }
		 if ((row+2)<8 && (row+2)>-1 && (col-1)<8 && (col-1)>-1&&row == getRow(Wknight2) && col == getCol(Wknight2) 
				 && t.getSource() == board[row+2][col-1]&&white==true&&Wcheck((row+2),(col-1))==true){
			 icon = Wknight2;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row+2][col-1].setIcon(Wknight2);
		     gridcolor();
		     white=false;
		     black=true;
		 }
		 if ((row+1)<8 && (row+1)>-1 && (col-2)<8 && (col-2)>-1&&row == getRow(Wknight2) && col == getCol(Wknight2) 
				 && t.getSource() == board[row+1][col-2]&&white==true&&Wcheck((row+1),(col-2))==true){
			 icon = Wknight2;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row+1][col-2].setIcon(Wknight2);
		     gridcolor();
		     white=false;
		     black=true;
		 }
		 if ((row-1)<8 && (row-1)>-1 && (col-2)<8 && (col-2)>-1&&row == getRow(Wknight2) && col == getCol(Wknight2) 
				 && t.getSource() == board[row-1][col-2]&&white==true&&Wcheck((row-1),(col-2))==true){
			 icon = Wknight2;
			 col = getCol(icon);
			 row = getRow(icon);					
			 board[row][col].setIcon(null); 
		     board[row-1][col-2].setIcon(Wknight2);
		     gridcolor();
		     white=false;
		     black=true;
		 }
	}
    void Bishop(ActionEvent t){
		 c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Bbishop1&&black==true){
			 gridcolor();//sets board to original color
			 icon = Bbishop1;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 //highlights possible moves
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	
				 }
				 c++;
			 }
		 }
		 for (r=1; r <=7; r++){
			 //moves upleft when clicked
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bbishop1) && col == getCol(Bbishop1) 
					 && t.getSource() == board[row-r][col-c]&&black==true&&Bcheck((row-r),(col-c))==true){
				 icon = Bbishop1;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); //sets piece's original position to null 
			     board[row-r][col-c].setIcon(Bbishop1);//sets piece to new position
			     gridcolor();//sets board to original color
			     black=false;
			     white=true;
			 }
			 //moves upright when clicked
            if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bbishop1) && col == getCol(Bbishop1) 
           		 && t.getSource() == board[row-r][col+c]&&black==true&&Bcheck((row-r),(col+c))==true){
           	 icon = Bbishop1;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); //sets piece's original position to null 
   		     board[row-r][col+c].setIcon(Bbishop1);//sets piece to new position
   		     gridcolor();//sets board to original color
   		     black=false;
   		     white=true;
			 }
            //moves downleft when clicked
            if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bbishop1) && col == getCol(Bbishop1) 
           		 && t.getSource() == board[row+r][col-c]&&black==true&&Bcheck((row+r),(col-c))==true){
           	 icon = Bbishop1;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); //sets piece's original position to null 
   		     board[row+r][col-c].setIcon(Bbishop1);//sets piece to new position
   		     gridcolor();//sets board to original color
   		     black=false;
   		     white=true;
			 }
            //moves downright when clicked
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bbishop1) && col == getCol(Bbishop1) 
           		 && t.getSource() == board[row+r][col+c]&&black==true&&Bcheck((row+r),(col+c))==true){
           	 icon = Bbishop1;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null);//sets piece's original position to null 
   		     board[row+r][col+c].setIcon(Bbishop1);//sets piece to new position
   		     gridcolor();//sets board to original color
   		     black=false;
   		     white=true;
            }
			 
			 c++;
		 }
		 //same as the first black bishop
		 c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Bbishop2&&black==true){
			 gridcolor();
			 icon = Bbishop2;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	 
				 }
				 c++;
			 }
		 }
		 for (r=1; r <=7; r++){
			 
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bbishop2) && col == getCol(Bbishop2) 
					 && t.getSource() == board[row-r][col-c]&&black==true&&Bcheck((row-r),(col-c))==true){
				 icon = Bbishop2;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-r][col-c].setIcon(Bbishop2);
			     gridcolor();
			     black=false;
			     white=true;
			 }
            if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bbishop2) && col == getCol(Bbishop2) 
           		 && t.getSource() == board[row-r][col+c]&&black==true&&Bcheck((row-r),(col+c))==true){
           	 icon = Bbishop2;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row-r][col+c].setIcon(Bbishop2);
   		     gridcolor();
   		     black=false;
   		     white=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bbishop2) && col == getCol(Bbishop2) 
           		 && t.getSource() == board[row+r][col-c]&&black==true&&Bcheck((row+r),(col-c))==true){
           	 icon = Bbishop2;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col-c].setIcon(Bbishop2);
   		     gridcolor();
   		     black=false;
   		     white=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bbishop2) && col == getCol(Bbishop2) 
           		 && t.getSource() == board[row+r][col+c]&&black==true&&Bcheck((row+r),(col+c))==true){
           	 icon = Bbishop2;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col+c].setIcon(Bbishop2);
   		     gridcolor();
   		     black=false;
   		     white=true;
            }
			 
			 c++;
		 }	
		 //same as the black bishops but white bishops instead
		 c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Wbishop1&&white==true){
			 gridcolor();
			 icon = Wbishop1;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	 
				 }
				 c++;
			 }
		 }
		 for (r=1; r <=7; r++){
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wbishop1) && col == getCol(Wbishop1) 
					 && t.getSource() == board[row-r][col-c]&&white==true&&Wcheck((row-r),(col-c))==true){
				 icon = Wbishop1;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-r][col-c].setIcon(Wbishop1);
			     gridcolor();
			     white=false;
			     black=true;
			 }
          if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wbishop1) && col == getCol(Wbishop1) 
       		   && t.getSource() == board[row-r][col+c]&&white==true&&Wcheck((row-r),(col+c))==true){
           	 icon = Wbishop1;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row-r][col+c].setIcon(Wbishop1);
   		     gridcolor();
   		     white=false;
   		     black=true;
			 }
          if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wbishop1) && col == getCol(Wbishop1) 
       		   && t.getSource() == board[row+r][col-c]&&white==true&&Wcheck((row+r),(col-c))==true){
           	 icon = Wbishop1;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col-c].setIcon(Wbishop1);
   		     gridcolor();
   		     white=false;
   		     black=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wbishop1) && col == getCol(Wbishop1) 
           		 && t.getSource() == board[row+r][col+c]&&white==true&&Wcheck((row+r),(col+c))==true){
           	 icon = Wbishop1;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col+c].setIcon(Wbishop1);
   		     gridcolor();
   		     white=false;
   		     black=true;
            }
			 
			 c++;
		 }
		//same as the black bishops but white bishops instead
		 c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Wbishop2&&white==true){
			 gridcolor();
			 icon = Wbishop2;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	 
				 }
				 c++;
			 }
		 }
		 for (r=1; r <=7; r++){
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wbishop2) && col == getCol(Wbishop2) 
					 && t.getSource() == board[row-r][col-c]&&white==true&&Wcheck((row-r),(col-c))==true){
				 icon = Wbishop2;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-r][col-c].setIcon(Wbishop2);
			     gridcolor();
			     white=false;
			     black=true;
			 }
            if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wbishop2) && col == getCol(Wbishop2) 
           		 && t.getSource() == board[row-r][col+c]&&white==true&&Wcheck((row-r),(col+c))==true){
           	 icon = Wbishop2;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row-r][col+c].setIcon(Wbishop2);
   		     gridcolor();
   		     white=false;
   		     black=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wbishop2) && col == getCol(Wbishop2) 
           		 && t.getSource() == board[row+r][col-c]&&white==true&&Wcheck((row+r),(col-c))==true){
           	 icon = Wbishop2;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col-c].setIcon(Wbishop2);
   		     gridcolor();
   		     white=false;
   		     black=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wbishop2) && col == getCol(Wbishop2) 
           		 && t.getSource() == board[row+r][col+c]&&white==true&&Wcheck((row+r),(col+c))==true){
           	 icon = Wbishop2;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col+c].setIcon(Wbishop2);
   		     gridcolor();
   		     white=false;
   		     black=true;
            }
			 
			 c++;
		 }
	}
    void Rook(ActionEvent t){
    	if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Brook1&&black==true){
			 gridcolor();//sets board to original color
			 icon = Brook1;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (int i = 1; i <= 7; i++){//highlights possible moves
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Bcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Bcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Bcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Bcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (int i = 1; i<8 ; i++){
			 //moves up when clicked
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Brook1) && col == getCol(Brook1) 
					 && t.getSource() == board[row-i][col]&&black==true&&Bcheck((row-i),(col))==true){
				 icon = Brook1;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); //sets original position of piece to null
			     board[row-i][col].setIcon(Brook1);//sets the icon to the new position 
			     gridcolor();//sets board to original color
			     black=false;
			     white=true;
			 }
			 //moves down when clicked
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Brook1) && col == getCol(Brook1) 
					 && t.getSource() == board[row+i][col]&&black==true&&Bcheck((row+i),(col))==true){
				 icon = Brook1;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); //sets original position of piece to null
			     board[row+i][col].setIcon(Brook1);//sets the icon to the new position
			     gridcolor();//sets board to original color
			     black=false;
			     white=true;
			 }
			 //moves left when clicked
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Brook1) && col == getCol(Brook1) 
					 && t.getSource() == board[row][col-i]&&black==true&&Bcheck((row),(col-i))==true){
				 icon = Brook1;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); //sets original position of piece to null
			     board[row][col-i].setIcon(Brook1);//sets the icon to the new position
			     gridcolor();//sets board to original color
			     black=false;
			     white=true;
			 }
			 //moves right when clicked
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Brook1) && col == getCol(Brook1) 
					 && t.getSource() == board[row][col+i]&&black==true&&Bcheck((row),(col+i))==true){
				 icon = Brook1;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); //sets original position of piece to null
			     board[row][col+i].setIcon(Brook1);//sets the icon to the new position
			     gridcolor();//sets board to original color
			     black=false;
			     white=true;
			 }
		 }
		 //same as the first black rook
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Brook2&&black==true){
			 gridcolor();
			 icon = Brook2;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (int i = 1; i <= 7; i++){
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Bcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Bcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Bcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Bcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (int i = 1; i<8 ; i++){
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Brook2) && col == getCol(Brook2) 
					 && t.getSource() == board[row-i][col]&&black==true&&Bcheck((row-i),(col))==true){
				 icon = Brook2;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-i][col].setIcon(Brook2);
			     gridcolor();
			     black=false;
			     white=true;

			 }
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Brook2) && col == getCol(Brook2) 
					 && t.getSource() == board[row+i][col]&&black==true&&Bcheck((row+i),(col))==true){
				 icon = Brook2;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row+i][col].setIcon(Brook2);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Brook2) && col == getCol(Brook2) 
					 && t.getSource() == board[row][col-i]&&black==true&&Bcheck((row),(col-i))==true){
				 icon = Brook2;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col-i].setIcon(Brook2);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Brook2) && col == getCol(Brook2) 
					 && t.getSource() == board[row][col+i]&&black==true&&Bcheck((row),(col+i))==true){
				 icon = Brook2;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col+i].setIcon(Brook2);
			     gridcolor();
			     black=false;
			     white=true;
			 }
		 }	
		 //same functuality as the black rooks but it is a white rook instead
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Wrook1&&white==true){
			 gridcolor();
			 icon = Wrook1;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (int i = 1; i <= 7; i++){
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Wcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Wcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Wcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Wcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (int i = 1; i<8 ; i++){
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wrook1) && col == getCol(Wrook1) 
					 && t.getSource() == board[row-i][col]&&white==true&&Wcheck((row-i),(col))==true){
				 icon = Wrook1;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-i][col].setIcon(Wrook1);
			     gridcolor();
			     white=false;
			     black=true;

			 }
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wrook1) && col == getCol(Wrook1) 
					 && t.getSource() == board[row+i][col]&&white==true&&Wcheck((row+i),(col))==true){
				 icon = Wrook1;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row+i][col].setIcon(Wrook1);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Wrook1) && col == getCol(Wrook1) 
					 && t.getSource() == board[row][col-i]&&white==true&&Wcheck((row),(col-i))==true){
				 icon = Wrook1;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col-i].setIcon(Wrook1);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Wrook1) && col == getCol(Wrook1) 
					 && t.getSource() == board[row][col+i]&&white==true&&Wcheck((row),(col+i))==true){
				 icon = Wrook1;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col+i].setIcon(Wrook1);
			     gridcolor();
			     white=false;
			     black=true;
			 }
		 }		 
		 //same functuality as the black rooks but it is a white rook instead
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Wrook2&&white==true){
			 gridcolor();
			 icon = Wrook2;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (int i = 1; i <= 7; i++){
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Wcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Wcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Wcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Wcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (int i = 1; i<8 ; i++){
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wrook2) && col == getCol(Wrook2) 
					 && t.getSource() == board[row-i][col]&&white==true&&Wcheck((row-i),(col))==true){
				 icon = Wrook2;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-i][col].setIcon(Wrook2);
			     gridcolor();
			     white=false;
			     black=true;

			 }
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wrook2) && col == getCol(Wrook2) 
					 && t.getSource() == board[row+i][col]&&white==true&&Wcheck((row+i),(col))==true){
				 icon = Wrook2;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row+i][col].setIcon(Wrook2);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Wrook2) && col == getCol(Wrook2) 
					 && t.getSource() == board[row][col-i]&&white==true&&Wcheck((row),(col-i))==true){
				 icon = Wrook2;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col-i].setIcon(Wrook2);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Wrook2) && col == getCol(Wrook2) 
					 && t.getSource() == board[row][col+i]&&white==true&&Wcheck((row),(col+i))==true){
				 icon = Wrook2;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col+i].setIcon(Wrook2);
			     gridcolor();
			     white=false;
			     black=true;
			 }
		 }		
	}
    void Pawn(ActionEvent t){
    	 for (int i = 0; i < 8; i++){
			 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Bpawn[i]&&black==true){
				 gridcolor();
				 icon = Bpawn[i];
				 row = getRow(icon);
				 col = getCol(icon);
				 //highlights possible moves
				 if ((row-1)<8 && (row-1)>-1 && col<8 && col>-1&&checkpawn((row-1), col) == true&&checkAll((row-1), col) == true){
					 board[row-1][col].setBackground(Color.cyan);
				 }
				 if ((row-2)<8 && (row-2)>-1 && col<8 && col>-1&&checkpawn((row-2), col) == true&&checkAll((row-2), col) == true
						 &&checkpawn((row-1), col) == true&&checkAll((row-1), col) == true&&B2(row)==true) {
					 board[row-2][col].setBackground(Color.cyan);
				 }
				 
				 if ((row-1)<8 && (row-1)>-1 && (col-1)<8 && (col-1)>-1&&Bcheck((row-1), (col-1)) == true&&Wcheck((row-1),(col-1))==false){
					 board[row-1][col-1].setBackground(Color.cyan);
				 }
				 if ((row-1)<8 && (row-1)>-1 && (col+1)<8 && (col+1)>-1&&Bcheck((row-1), (col+1)) == true&&Wcheck((row-1),(col+1))==false){
					 board[row-1][col+1].setBackground(Color.cyan);
				 }
			 }
			 //moves up one when clicked
			 if ((row-1)<8 && (row-1)>-1 && col<8 && col>-1&&row == getRow(Bpawn[i]) &&col==getCol(Bpawn[i])&& t.getSource() == board[row-1][col]
					 &&black==true&&checkpawn((row-1), col) == true&&checkAll((row-1), col) == true) {
			     icon = Bpawn[i];
			     row = getRow(icon);
			     col = getCol(icon);
			     board[row][col].setIcon(null); //sets original postion to null
				 board[row-1][col].setIcon(Bpawn[i]);//sets icon to the place where clicked
				 if((row-1)==0){//if the pawn reaches other end of board
					 if (Bpawn[i]==Bpawn[0])board[row-1][col].setIcon(Bpro1);
					 if (Bpawn[i]==Bpawn[1])board[row-1][col].setIcon(Bpro2);
					 if (Bpawn[i]==Bpawn[2])board[row-1][col].setIcon(Bpro3);
					 if (Bpawn[i]==Bpawn[3])board[row-1][col].setIcon(Bpro4);
					 if (Bpawn[i]==Bpawn[4])board[row-1][col].setIcon(Bpro5);
					 if (Bpawn[i]==Bpawn[5])board[row-1][col].setIcon(Bpro6);
					 if (Bpawn[i]==Bpawn[6])board[row-1][col].setIcon(Bpro7);
					 if (Bpawn[i]==Bpawn[7])board[row-1][col].setIcon(Bpro8);
				 }
				 gridcolor();
				 black=false;
				 white=true;
			 }
			 //moves up 2 when clicked		 
			 if ((row-2)<8 && (row-2)>-1 && col<8 && col>-1&&row == getRow(Bpawn[i])&&col==getCol(Bpawn[i])&& t.getSource() == board[row-2][col]&&black==true
					 &&checkpawn((row-2), col) == true&&checkAll((row-2), col) == true
					 &&checkpawn((row-1), col) == true&&checkAll((row-1), col) == true&&B2(row)==true) {
			     icon = Bpawn[i];
			     row = getRow(icon);
			     col = getCol(icon);
				 board[row][col].setIcon(null);
				 board[row-2][col].setIcon(Bpawn[i]);
				 if((row-2)==0){//if the pawn reaches other end of board
					 if (Bpawn[i]==Bpawn[0])board[row-2][col].setIcon(Bpro1);
					 if (Bpawn[i]==Bpawn[1])board[row-2][col].setIcon(Bpro2);
					 if (Bpawn[i]==Bpawn[2])board[row-2][col].setIcon(Bpro3);
					 if (Bpawn[i]==Bpawn[3])board[row-2][col].setIcon(Bpro4);
					 if (Bpawn[i]==Bpawn[4])board[row-2][col].setIcon(Bpro5);
					 if (Bpawn[i]==Bpawn[5])board[row-2][col].setIcon(Bpro6);
					 if (Bpawn[i]==Bpawn[6])board[row-2][col].setIcon(Bpro7);
					 if (Bpawn[i]==Bpawn[7])board[row-2][col].setIcon(Bpro8);
				 }
				 gridcolor();
				 black=false;
				 white=true;
			 }	
			 //moves upleft one when clicked
			 if ((row-1)<8 && (row-1)>-1 && (col-1)<8 && (col-1)>-1&&row == getRow(Bpawn[i]) &&col==getCol(Bpawn[i])&& t.getSource() == board[row-1][col-1]
					 &&black==true&&Bcheck((row-1), (col-1)) == true&&Wcheck((row-1),(col-1))==false) {
			     icon = Bpawn[i];
			     row = getRow(icon);	
			     col = getCol(icon);
			     board[row][col].setIcon(null); 
				 board[row-1][col-1].setIcon(Bpawn[i]);
				 if((row-1)==0){//if the pawn reaches other end of board
					 if (Bpawn[i]==Bpawn[0])board[row-1][col-1].setIcon(Bpro1);
					 if (Bpawn[i]==Bpawn[1])board[row-1][col-1].setIcon(Bpro2);
					 if (Bpawn[i]==Bpawn[2])board[row-1][col-1].setIcon(Bpro3);
					 if (Bpawn[i]==Bpawn[3])board[row-1][col-1].setIcon(Bpro4);
					 if (Bpawn[i]==Bpawn[4])board[row-1][col-1].setIcon(Bpro5);
					 if (Bpawn[i]==Bpawn[5])board[row-1][col-1].setIcon(Bpro6);
					 if (Bpawn[i]==Bpawn[6])board[row-1][col-1].setIcon(Bpro7);
					 if (Bpawn[i]==Bpawn[7])board[row-1][col-1].setIcon(Bpro8);
				 }
				 gridcolor();
				 black=false;
				 white=true;
			 }
			 //moves upright one when clicked
			 if ((row-1)<8 && (row-1)>-1 && (col+1)<8 && (col+1)>-1&&row == getRow(Bpawn[i]) &&col==getCol(Bpawn[i])&& t.getSource() == board[row-1][col+1]
					 &&black==true&&Bcheck((row-1), (col+1)) == true&&Wcheck((row-1),(col+1))==false) {
			     icon = Bpawn[i];
			     row = getRow(icon);	
			     col = getCol(icon);
			     board[row][col].setIcon(null); 
				 board[row-1][col+1].setIcon(Bpawn[i]);
				 if((row-1)==0){//if the pawn reaches other end of board
					 if (Bpawn[i]==Bpawn[0])board[row-1][col+1].setIcon(Bpro1);
					 if (Bpawn[i]==Bpawn[1])board[row-1][col+1].setIcon(Bpro2);
					 if (Bpawn[i]==Bpawn[2])board[row-1][col+1].setIcon(Bpro3);
					 if (Bpawn[i]==Bpawn[3])board[row-1][col+1].setIcon(Bpro4);
					 if (Bpawn[i]==Bpawn[4])board[row-1][col+1].setIcon(Bpro5);
					 if (Bpawn[i]==Bpawn[5])board[row-1][col+1].setIcon(Bpro6);
					 if (Bpawn[i]==Bpawn[6])board[row-1][col+1].setIcon(Bpro7);
					 if (Bpawn[i]==Bpawn[7])board[row-1][col+1].setIcon(Bpro8);
				 }
				 gridcolor();
				 black=false;
				 white=true;
			 }
		     		 
		 }	
    	 
         //same as black pawn but it is white instead
		 for (int i = 0; i < 8; i++){
			 
			 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Wpawn[i]&&white==true){
				 gridcolor();
				 icon = Wpawn[i];
				 row = getRow(icon);
				 col = getCol(icon);
				 if ((row+1)<8 && (row+1)>-1 && col<8 && col>-1&&checkpawn((row+1), col) == true&&checkAll((row+1), col) == true) {
					 board[row+1][col].setBackground(Color.cyan);
				 }
				 if ((row+2)<8 && (row+2)>-1 && col<8 && col>-1&&checkpawn((row+2), col) == true&&checkAll((row+2), col) == true
						 &&checkpawn((row+1), col) == true&&checkAll((row+1), col) == true&&W2(row)==true) {
					 board[row+2][col].setBackground(Color.cyan);
				 }
				 if ((row+1)<8 && (row+1)>-1 && (col-1)<8 && (col-1)>-1&&Bcheck((row+1), (col-1)) == false&&Wcheck((row+1),(col-1))==true){
					 board[row+1][col-1].setBackground(Color.cyan);
				 }
				 if ((row+1)<8 && (row+1)>-1 && (col+1)<8 && (col+1)>-1&&Bcheck((row+1), (col+1)) == false&&Wcheck((row+1),(col+1))==true){
					 board[row+1][col+1].setBackground(Color.cyan);
				 }
			 }
			 //moves down 1 when clicked
			 if ((row+1)<8 && (row+1)>-1 && col<8 && col>-1&&row == getRow(Wpawn[i]) &&col==getCol(Wpawn[i])&& t.getSource() == board[row+1][col]
					 &&white==true&&checkpawn((row+1), col) == true&&checkAll((row+1), col) == true) {
		    	 icon = Wpawn[i];
				 row = getRow(icon);					
				 col = getCol(icon);
				 board[row][col].setIcon(null); 
			     board[row+1][col].setIcon(Wpawn[i]);
			     if((row+1)==7){//if the pawn reaches other end of board
					 if (Wpawn[i]==Wpawn[0])board[row+1][col].setIcon(Wpro1);
					 if (Wpawn[i]==Wpawn[1])board[row+1][col].setIcon(Wpro2);
					 if (Wpawn[i]==Wpawn[2])board[row+1][col].setIcon(Wpro3);
					 if (Wpawn[i]==Wpawn[3])board[row+1][col].setIcon(Wpro4);
					 if (Wpawn[i]==Wpawn[4])board[row+1][col].setIcon(Wpro5);
					 if (Wpawn[i]==Wpawn[5])board[row+1][col].setIcon(Wpro6);
					 if (Wpawn[i]==Wpawn[6])board[row+1][col].setIcon(Wpro7);
					 if (Wpawn[i]==Wpawn[7])board[row+1][col].setIcon(Wpro8);
				 }
			     gridcolor();
			     white=false;
			     black=true;
		     }
			//moves down 2 when clicked	 
		     if ((row+2)<8 && (row+2)>-1 && col<8 && col>-1&&row == getRow(Wpawn[i]) &&col==getCol(Wpawn[i])&& t.getSource() == board[row+2][col]&&white==true
		    		 &&checkpawn((row+2), col) == true&&checkAll((row+2), col) == true
					 &&checkpawn((row+1), col) == true&&checkAll((row+1), col) == true&&W2(row)==true) {
		    	 icon = Wpawn[i];
				 row = getRow(icon);	
				 col = getCol(icon);
			     board[row][col].setIcon(null);
			     board[row+2][col].setIcon(Wpawn[i]);
			     if((row+2)==7){//if the pawn reaches other end of board
					 if (Wpawn[i]==Wpawn[0])board[row+2][col].setIcon(Wpro1);
					 if (Wpawn[i]==Wpawn[1])board[row+2][col].setIcon(Wpro2);
					 if (Wpawn[i]==Wpawn[2])board[row+2][col].setIcon(Wpro3);
					 if (Wpawn[i]==Wpawn[3])board[row+2][col].setIcon(Wpro4);
					 if (Wpawn[i]==Wpawn[4])board[row+2][col].setIcon(Wpro5);
					 if (Wpawn[i]==Wpawn[5])board[row+2][col].setIcon(Wpro6);
					 if (Wpawn[i]==Wpawn[6])board[row+2][col].setIcon(Wpro7);
					 if (Wpawn[i]==Wpawn[7])board[row+2][col].setIcon(Wpro8);
				 }
			     gridcolor();
			     white=false;
			     black=true;
		     }	
		     //moves downleft when clicked
		     if ((row+1)<8 && (row+1)>-1 && (col-1)<8 && (col-1)>-1&&row == getRow(Wpawn[i]) &&col==getCol(Wpawn[i])&& t.getSource() == board[row+1][col-1]
					 &&white==true&&Wcheck((row+1), (col-1)) == true&&Bcheck((row+1),(col-1))==false) {
			     icon = Wpawn[i];
			     row = getRow(icon);	
			     col = getCol(icon);
			     board[row][col].setIcon(null); 
				 board[row+1][col-1].setIcon(Wpawn[i]);
				 if((row+1)==7){//if the pawn reaches other end of board
					 if (Wpawn[i]==Wpawn[0])board[row+1][col-1].setIcon(Wpro1);
					 if (Wpawn[i]==Wpawn[1])board[row+1][col-1].setIcon(Wpro2);
					 if (Wpawn[i]==Wpawn[2])board[row+1][col-1].setIcon(Wpro3);
					 if (Wpawn[i]==Wpawn[3])board[row+1][col-1].setIcon(Wpro4);
					 if (Wpawn[i]==Wpawn[4])board[row+1][col-1].setIcon(Wpro5);
					 if (Wpawn[i]==Wpawn[5])board[row+1][col-1].setIcon(Wpro6);
					 if (Wpawn[i]==Wpawn[6])board[row+1][col-1].setIcon(Wpro7);
					 if (Wpawn[i]==Wpawn[7])board[row+1][col-1].setIcon(Wpro8);
				 }
				 gridcolor();
				 white=false;
				 black=true;
			 }
		     //moves down right when clicked
			 if ((row+1)<8 && (row+1)>-1 && (col+1)<8 && (col+1)>-1&&row == getRow(Wpawn[i]) &&col==getCol(Wpawn[i])&& t.getSource() == board[row+1][col+1]
					 &&white==true&&Wcheck((row+1), (col+1)) == true&&Bcheck((row+1),(col+1))==false) {
			     icon = Wpawn[i];
			     row = getRow(icon);	
			     col = getCol(icon);
			     board[row][col].setIcon(null); 
				 board[row+1][col+1].setIcon(Wpawn[i]);
				 if((row+1)==7){//if the pawn reaches other end of board
					 if (Wpawn[i]==Wpawn[0])board[row+1][col+1].setIcon(Wpro1);
					 if (Wpawn[i]==Wpawn[1])board[row+1][col+1].setIcon(Wpro2);
					 if (Wpawn[i]==Wpawn[2])board[row+1][col+1].setIcon(Wpro3);
					 if (Wpawn[i]==Wpawn[3])board[row+1][col+1].setIcon(Wpro4);
					 if (Wpawn[i]==Wpawn[4])board[row+1][col+1].setIcon(Wpro5);
					 if (Wpawn[i]==Wpawn[5])board[row+1][col+1].setIcon(Wpro6);
					 if (Wpawn[i]==Wpawn[6])board[row+1][col+1].setIcon(Wpro7);
					 if (Wpawn[i]==Wpawn[7])board[row+1][col+1].setIcon(Wpro8);
				 }
				 gridcolor();
				 white=false;
				 black=true;
			 }
		 }
    }
    
	void PawnToQueen (ActionEvent t) {
		//same function as queen when a pawn moves to the other end of the board
		c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Bpro1&&black==true){
			 gridcolor();
			 icon = Bpro1;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	
				 }
				 c++;
			 }
			 for (int i = 1; i <= 7; i++){
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Bcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Bcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Bcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Bcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (r=1; r <=7; r++){
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bpro1) && col == getCol(Bpro1) 
					 && t.getSource() == board[row-r][col-c]&&black==true&&Bcheck((row-r),(col-c))==true){
				 icon = Bpro1;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-r][col-c].setIcon(Bpro1);
			     gridcolor();
			     black=false;
			     white=true;
			 }
            if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bpro1) && col == getCol(Bpro1) 
           		 && t.getSource() == board[row-r][col+c]&&black==true&&Bcheck((row-r),(col+c))==true){
           	 icon = Bpro1;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row-r][col+c].setIcon(Bpro1);
   		     gridcolor();
   		     black=false;
   		     white=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bpro1) && col == getCol(Bpro1) 
           		 && t.getSource() == board[row+r][col-c]&&black==true&&Bcheck((row+r),(col-c))==true){
           	 icon = Bpro1;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col-c].setIcon(Bpro1);
   		     gridcolor();
   		     black=false;
   		     white=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bpro1) && col == getCol(Bpro1) 
           		 && t.getSource() == board[row+r][col+c]&&black==true&&Bcheck((row+r),(col+c))==true){
           	 icon = Bpro1;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col+c].setIcon(Bpro1);
   		     gridcolor();
   		     black=false;
   		     white=true;
            }
			 
			 c++;
		 }
		 for (int i = 1; i<8 ; i++){
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Bpro1) && col == getCol(Bpro1) 
					 && t.getSource() == board[row-i][col]&&black==true&&Bcheck((row-i),(col))==true){
				 icon = Bpro1;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-i][col].setIcon(Bpro1);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Bpro1) && col == getCol(Bpro1) 
					 && t.getSource() == board[row+i][col]&&black==true&&Bcheck((row+i),(col))==true){
				 icon = Bpro1;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row+i][col].setIcon(Bpro1);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Bpro1) && col == getCol(Bpro1) 
					 && t.getSource() == board[row][col-i]&&black==true&&Bcheck((row),(col-i))==true){
				 icon = Bpro1;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col-i].setIcon(Bpro1);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Bpro1) && col == getCol(Bpro1) 
					 && t.getSource() == board[row][col+i]&&black==true&&Bcheck((row),(col+i))==true){
				 icon = Bpro1;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col+i].setIcon(Bpro1);
			     gridcolor();
			     black=false;
			     white=true;
			 }
		 }
		 c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Bpro2&&black==true){
			 gridcolor();
			 icon = Bpro2;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	
				 }
				 c++;
			 }
			 for (int i = 1; i <= 7; i++){
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Bcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Bcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Bcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Bcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (r=1; r <=7; r++){
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bpro2) && col == getCol(Bpro2) 
					 && t.getSource() == board[row-r][col-c]&&black==true&&Bcheck((row-r),(col-c))==true){
				 icon = Bpro2;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-r][col-c].setIcon(Bpro2);
			     gridcolor();
			     black=false;
			     white=true;
			 }
            if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bpro2) && col == getCol(Bpro2) 
           		 && t.getSource() == board[row-r][col+c]&&black==true&&Bcheck((row-r),(col+c))==true){
           	 icon = Bpro2;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row-r][col+c].setIcon(Bpro2);
   		     gridcolor();
   		     black=false;
   		     white=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bpro2) && col == getCol(Bpro2) 
           		 && t.getSource() == board[row+r][col-c]&&black==true&&Bcheck((row+r),(col-c))==true){
           	 icon = Bpro2;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col-c].setIcon(Bpro2);
   		     gridcolor();
   		     black=false;
   		     white=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bpro2) && col == getCol(Bpro2) 
           		 && t.getSource() == board[row+r][col+c]&&black==true&&Bcheck((row+r),(col+c))==true){
           	 icon = Bpro2;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col+c].setIcon(Bpro2);
   		     gridcolor();
   		     black=false;
   		     white=true;
            }
			 
			 c++;
		 }
		 for (int i = 1; i<8 ; i++){
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Bpro2) && col == getCol(Bpro2) 
					 && t.getSource() == board[row-i][col]&&black==true&&Bcheck((row-i),(col))==true){
				 icon = Bpro2;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-i][col].setIcon(Bpro2);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Bpro2) && col == getCol(Bpro2) 
					 && t.getSource() == board[row+i][col]&&black==true&&Bcheck((row+i),(col))==true){
				 icon = Bpro2;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row+i][col].setIcon(Bpro2);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Bpro2) && col == getCol(Bpro2) 
					 && t.getSource() == board[row][col-i]&&black==true&&Bcheck((row),(col-i))==true){
				 icon = Bpro2;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col-i].setIcon(Bpro2);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Bpro2) && col == getCol(Bpro2) 
					 && t.getSource() == board[row][col+i]&&black==true&&Bcheck((row),(col+i))==true){
				 icon = Bpro2;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col+i].setIcon(Bpro2);
			     gridcolor();
			     black=false;
			     white=true;
			 }
		 }
		 c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Bpro3&&black==true){
			 gridcolor();
			 icon = Bpro3;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	
				 }
				 c++;
			 }
			 for (int i = 1; i <= 7; i++){
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Bcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Bcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Bcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Bcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (r=1; r <=7; r++){
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bpro3) && col == getCol(Bpro3) 
					 && t.getSource() == board[row-r][col-c]&&black==true&&Bcheck((row-r),(col-c))==true){
				 icon = Bpro3;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-r][col-c].setIcon(Bpro3);
			     gridcolor();
			     black=false;
			     white=true;
			 }
            if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bpro3) && col == getCol(Bpro3) 
           		 && t.getSource() == board[row-r][col+c]&&black==true&&Bcheck((row-r),(col+c))==true){
           	 icon = Bpro3;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row-r][col+c].setIcon(Bpro3);
   		     gridcolor();
   		     black=false;
   		     white=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bpro3) && col == getCol(Bpro3) 
           		 && t.getSource() == board[row+r][col-c]&&black==true&&Bcheck((row+r),(col-c))==true){
           	 icon = Bpro3;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col-c].setIcon(Bpro3);
   		     gridcolor();
   		     black=false;
   		     white=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bpro3) && col == getCol(Bpro3) 
           		 && t.getSource() == board[row+r][col+c]&&black==true&&Bcheck((row+r),(col+c))==true){
           	 icon = Bpro3;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col+c].setIcon(Bpro3);
   		     gridcolor();
   		     black=false;
   		     white=true;
            }
			 
			 c++;
		 }
		 for (int i = 1; i<8 ; i++){
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Bpro3) && col == getCol(Bpro3) 
					 && t.getSource() == board[row-i][col]&&black==true&&Bcheck((row-i),(col))==true){
				 icon = Bpro3;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-i][col].setIcon(Bpro3);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Bpro3) && col == getCol(Bpro3) 
					 && t.getSource() == board[row+i][col]&&black==true&&Bcheck((row+i),(col))==true){
				 icon = Bpro3;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row+i][col].setIcon(Bpro3);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Bpro3) && col == getCol(Bpro3) 
					 && t.getSource() == board[row][col-i]&&black==true&&Bcheck((row),(col-i))==true){
				 icon = Bpro3;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col-i].setIcon(Bpro3);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Bpro3) && col == getCol(Bpro3) 
					 && t.getSource() == board[row][col+i]&&black==true&&Bcheck((row),(col+i))==true){
				 icon = Bpro3;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col+i].setIcon(Bpro3);
			     gridcolor();
			     black=false;
			     white=true;
			 }
		 }
		 c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Bpro4&&black==true){
			 gridcolor();
			 icon = Bpro4;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	
				 }
				 c++;
			 }
			 for (int i = 1; i <= 7; i++){
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Bcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Bcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Bcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Bcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (r=1; r <=7; r++){
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bpro4) && col == getCol(Bpro4) 
					 && t.getSource() == board[row-r][col-c]&&black==true&&Bcheck((row-r),(col-c))==true){
				 icon = Bpro4;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-r][col-c].setIcon(Bpro4);
			     gridcolor();
			     black=false;
			     white=true;
			 }
            if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bpro4) && col == getCol(Bpro4) 
           		 && t.getSource() == board[row-r][col+c]&&black==true&&Bcheck((row-r),(col+c))==true){
           	 icon = Bpro4;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row-r][col+c].setIcon(Bpro4);
   		     gridcolor();
   		     black=false;
   		     white=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bpro4) && col == getCol(Bpro4) 
           		 && t.getSource() == board[row+r][col-c]&&black==true&&Bcheck((row+r),(col-c))==true){
           	 icon = Bpro4;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col-c].setIcon(Bpro4);
   		     gridcolor();
   		     black=false;
   		     white=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bpro4) && col == getCol(Bpro4) 
           		 && t.getSource() == board[row+r][col+c]&&black==true&&Bcheck((row+r),(col+c))==true){
           	 icon = Bpro4;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col+c].setIcon(Bpro4);
   		     gridcolor();
   		     black=false;
   		     white=true;
            }
			 
			 c++;
		 }
		 for (int i = 1; i<8 ; i++){
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Bpro4) && col == getCol(Bpro4) 
					 && t.getSource() == board[row-i][col]&&black==true&&Bcheck((row-i),(col))==true){
				 icon = Bpro4;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-i][col].setIcon(Bpro4);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Bpro4) && col == getCol(Bpro4) 
					 && t.getSource() == board[row+i][col]&&black==true&&Bcheck((row+i),(col))==true){
				 icon = Bpro4;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row+i][col].setIcon(Bpro4);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Bpro4) && col == getCol(Bpro4) 
					 && t.getSource() == board[row][col-i]&&black==true&&Bcheck((row),(col-i))==true){
				 icon = Bpro4;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col-i].setIcon(Bpro4);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Bpro4) && col == getCol(Bpro4) 
					 && t.getSource() == board[row][col+i]&&black==true&&Bcheck((row),(col+i))==true){
				 icon = Bpro4;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col+i].setIcon(Bpro4);
			     gridcolor();
			     black=false;
			     white=true;
			 }
		 }
		 c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Bpro5&&black==true){
			 gridcolor();
			 icon = Bpro5;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	
				 }
				 c++;
			 }
			 for (int i = 1; i <= 7; i++){
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Bcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Bcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Bcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Bcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (r=1; r <=7; r++){
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bpro5) && col == getCol(Bpro5) 
					 && t.getSource() == board[row-r][col-c]&&black==true&&Bcheck((row-r),(col-c))==true){
				 icon = Bpro5;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-r][col-c].setIcon(Bpro5);
			     gridcolor();
			     black=false;
			     white=true;
			 }
            if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bpro5) && col == getCol(Bpro5) 
           		 && t.getSource() == board[row-r][col+c]&&black==true&&Bcheck((row-r),(col+c))==true){
           	 icon = Bpro5;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row-r][col+c].setIcon(Bpro5);
   		     gridcolor();
   		     black=false;
   		     white=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bpro5) && col == getCol(Bpro5) 
           		 && t.getSource() == board[row+r][col-c]&&black==true&&Bcheck((row+r),(col-c))==true){
           	 icon = Bpro5;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col-c].setIcon(Bpro5);
   		     gridcolor();
   		     black=false;
   		     white=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bpro5) && col == getCol(Bpro5) 
           		 && t.getSource() == board[row+r][col+c]&&black==true&&Bcheck((row+r),(col+c))==true){
           	 icon = Bpro5;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col+c].setIcon(Bpro5);
   		     gridcolor();
   		     black=false;
   		     white=true;
            }
			 
			 c++;
		 }
		 for (int i = 1; i<8 ; i++){
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Bpro5) && col == getCol(Bpro5) 
					 && t.getSource() == board[row-i][col]&&black==true&&Bcheck((row-i),(col))==true){
				 icon = Bpro5;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-i][col].setIcon(Bpro5);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Bpro5) && col == getCol(Bpro5) 
					 && t.getSource() == board[row+i][col]&&black==true&&Bcheck((row+i),(col))==true){
				 icon = Bpro5;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row+i][col].setIcon(Bpro5);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Bpro5) && col == getCol(Bpro5) 
					 && t.getSource() == board[row][col-i]&&black==true&&Bcheck((row),(col-i))==true){
				 icon = Bpro5;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col-i].setIcon(Bpro5);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Bpro5) && col == getCol(Bpro5) 
					 && t.getSource() == board[row][col+i]&&black==true&&Bcheck((row),(col+i))==true){
				 icon = Bpro5;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col+i].setIcon(Bpro5);
			     gridcolor();
			     black=false;
			     white=true;
			 }
		 }
		 c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Bpro6&&black==true){
			 gridcolor();
			 icon = Bpro6;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	
				 }
				 c++;
			 }
			 for (int i = 1; i <= 7; i++){
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Bcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Bcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Bcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Bcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (r=1; r <=7; r++){
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bpro6) && col == getCol(Bpro6) 
					 && t.getSource() == board[row-r][col-c]&&black==true&&Bcheck((row-r),(col-c))==true){
				 icon = Bpro6;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-r][col-c].setIcon(Bpro6);
			     gridcolor();
			     black=false;
			     white=true;
			 }
            if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bpro6) && col == getCol(Bpro6) 
           		 && t.getSource() == board[row-r][col+c]&&black==true&&Bcheck((row-r),(col+c))==true){
           	 icon = Bpro6;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row-r][col+c].setIcon(Bpro6);
   		     gridcolor();
   		     black=false;
   		     white=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bpro6) && col == getCol(Bpro6) 
           		 && t.getSource() == board[row+r][col-c]&&black==true&&Bcheck((row+r),(col-c))==true){
           	 icon = Bpro6;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col-c].setIcon(Bpro6);
   		     gridcolor();
   		     black=false;
   		     white=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bpro6) && col == getCol(Bpro6) 
           		 && t.getSource() == board[row+r][col+c]&&black==true&&Bcheck((row+r),(col+c))==true){
           	 icon = Bpro6;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col+c].setIcon(Bpro6);
   		     gridcolor();
   		     black=false;
   		     white=true;
            }
			 
			 c++;
		 }
		 for (int i = 1; i<8 ; i++){
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Bpro6) && col == getCol(Bpro6) 
					 && t.getSource() == board[row-i][col]&&black==true&&Bcheck((row-i),(col))==true){
				 icon = Bpro6;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-i][col].setIcon(Bpro6);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Bpro6) && col == getCol(Bpro6) 
					 && t.getSource() == board[row+i][col]&&black==true&&Bcheck((row+i),(col))==true){
				 icon = Bpro6;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row+i][col].setIcon(Bpro6);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Bpro6) && col == getCol(Bpro6) 
					 && t.getSource() == board[row][col-i]&&black==true&&Bcheck((row),(col-i))==true){
				 icon = Bpro6;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col-i].setIcon(Bpro6);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Bpro6) && col == getCol(Bpro6) 
					 && t.getSource() == board[row][col+i]&&black==true&&Bcheck((row),(col+i))==true){
				 icon = Bpro6;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col+i].setIcon(Bpro6);
			     gridcolor();
			     black=false;
			     white=true;
			 }
		 }
		 c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Bpro7&&black==true){
			 gridcolor();
			 icon = Bpro7;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	
				 }
				 c++;
			 }
			 for (int i = 1; i <= 7; i++){
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Bcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Bcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Bcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Bcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (r=1; r <=7; r++){
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bpro7) && col == getCol(Bpro7) 
					 && t.getSource() == board[row-r][col-c]&&black==true&&Bcheck((row-r),(col-c))==true){
				 icon = Bpro7;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-r][col-c].setIcon(Bpro7);
			     gridcolor();
			     black=false;
			     white=true;
			 }
            if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bpro7) && col == getCol(Bpro7) 
           		 && t.getSource() == board[row-r][col+c]&&black==true&&Bcheck((row-r),(col+c))==true){
           	 icon = Bpro7;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row-r][col+c].setIcon(Bpro7);
   		     gridcolor();
   		     black=false;
   		     white=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bpro7) && col == getCol(Bpro7) 
           		 && t.getSource() == board[row+r][col-c]&&black==true&&Bcheck((row+r),(col-c))==true){
           	 icon = Bpro7;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col-c].setIcon(Bpro7);
   		     gridcolor();
   		     black=false;
   		     white=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bpro7) && col == getCol(Bpro7) 
           		 && t.getSource() == board[row+r][col+c]&&black==true&&Bcheck((row+r),(col+c))==true){
           	 icon = Bpro7;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col+c].setIcon(Bpro7);
   		     gridcolor();
   		     black=false;
   		     white=true;
            }
			 
			 c++;
		 }
		 for (int i = 1; i<8 ; i++){
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Bpro7) && col == getCol(Bpro7) 
					 && t.getSource() == board[row-i][col]&&black==true&&Bcheck((row-i),(col))==true){
				 icon = Bpro7;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-i][col].setIcon(Bpro7);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Bpro7) && col == getCol(Bpro7) 
					 && t.getSource() == board[row+i][col]&&black==true&&Bcheck((row+i),(col))==true){
				 icon = Bpro7;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row+i][col].setIcon(Bpro7);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Bpro7) && col == getCol(Bpro7) 
					 && t.getSource() == board[row][col-i]&&black==true&&Bcheck((row),(col-i))==true){
				 icon = Bpro7;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col-i].setIcon(Bpro7);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Bpro7) && col == getCol(Bpro7) 
					 && t.getSource() == board[row][col+i]&&black==true&&Bcheck((row),(col+i))==true){
				 icon = Bpro7;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col+i].setIcon(Bpro7);
			     gridcolor();
			     black=false;
			     white=true;
			 }
		 }
		 c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Bpro8&&black==true){
			 gridcolor();
			 icon = Bpro8;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Bcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Bcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	
				 }
				 c++;
			 }
			 for (int i = 1; i <= 7; i++){
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Bcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Bcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Bcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Bcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (r=1; r <=7; r++){
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bpro8) && col == getCol(Bpro8) 
					 && t.getSource() == board[row-r][col-c]&&black==true&&Bcheck((row-r),(col-c))==true){
				 icon = Bpro8;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-r][col-c].setIcon(Bpro8);
			     gridcolor();
			     black=false;
			     white=true;
			 }
            if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bpro8) && col == getCol(Bpro8) 
           		 && t.getSource() == board[row-r][col+c]&&black==true&&Bcheck((row-r),(col+c))==true){
           	 icon = Bpro8;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row-r][col+c].setIcon(Bpro8);
   		     gridcolor();
   		     black=false;
   		     white=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Bpro8) && col == getCol(Bpro8) 
           		 && t.getSource() == board[row+r][col-c]&&black==true&&Bcheck((row+r),(col-c))==true){
           	 icon = Bpro8;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col-c].setIcon(Bpro8);
   		     gridcolor();
   		     black=false;
   		     white=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Bpro8) && col == getCol(Bpro8) 
           		 && t.getSource() == board[row+r][col+c]&&black==true&&Bcheck((row+r),(col+c))==true){
           	 icon = Bpro8;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col+c].setIcon(Bpro8);
   		     gridcolor();
   		     black=false;
   		     white=true;
            }
			 
			 c++;
		 }
		 for (int i = 1; i<8 ; i++){
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Bpro8) && col == getCol(Bpro8) 
					 && t.getSource() == board[row-i][col]&&black==true&&Bcheck((row-i),(col))==true){
				 icon = Bpro8;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-i][col].setIcon(Bpro8);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Bpro8) && col == getCol(Bpro8) 
					 && t.getSource() == board[row+i][col]&&black==true&&Bcheck((row+i),(col))==true){
				 icon = Bpro8;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row+i][col].setIcon(Bpro8);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Bpro8) && col == getCol(Bpro8) 
					 && t.getSource() == board[row][col-i]&&black==true&&Bcheck((row),(col-i))==true){
				 icon = Bpro8;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col-i].setIcon(Bpro8);
			     gridcolor();
			     black=false;
			     white=true;
			 }
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Bpro8) && col == getCol(Bpro8) 
					 && t.getSource() == board[row][col+i]&&black==true&&Bcheck((row),(col+i))==true){
				 icon = Bpro8;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col+i].setIcon(Bpro8);
			     gridcolor();
			     black=false;
			     white=true;
			 }
		 }
		 
		 
		 
		c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Wpro1&&white==true){
			 gridcolor();
			 icon = Wpro1;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	
				 }
				 c++;
			 }
			 for (int i = 1; i <= 7; i++){
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Wcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Wcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Wcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Wcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (r=1; r <=7; r++){
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wpro1) && col == getCol(Wpro1) 
					 && t.getSource() == board[row-r][col-c]&&white==true&&Wcheck((row-r),(col-c))==true){
				 icon = Wpro1;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-r][col-c].setIcon(Wpro1);
			     gridcolor();
			     white=false;
			     black=true;
			 }
           if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wpro1) && col == getCol(Wpro1) 
          		 && t.getSource() == board[row-r][col+c]&&white==true&&Wcheck((row-r),(col+c))==true){
          	 icon = Wpro1;
  			 col = getCol(icon);
  			 row = getRow(icon);					
  			 board[row][col].setIcon(null); 
  		     board[row-r][col+c].setIcon(Wpro1);
  		     gridcolor();
  		     white=false;
  		     black=true;
			 }
           if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wpro1) && col == getCol(Wpro1) 
          		 && t.getSource() == board[row+r][col-c]&&white==true&&Wcheck((row+r),(col-c))==true){
          	 icon = Wpro1;
  			 col = getCol(icon);
  			 row = getRow(icon);					
  			 board[row][col].setIcon(null); 
  		     board[row+r][col-c].setIcon(Wpro1);
  		     gridcolor();
  		     white=false;
  		     black=true;
			 }
           if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wpro1) && col == getCol(Wpro1) 
          		 && t.getSource() == board[row+r][col+c]&&white==true&&Wcheck((row+r),(col+c))==true){
          	 icon = Wpro1;
  			 col = getCol(icon);
  			 row = getRow(icon);					
  			 board[row][col].setIcon(null); 
  		     board[row+r][col+c].setIcon(Wpro1);
  		     gridcolor();
  		     white=false;
  		     black=true;
           }
			 
			 c++;
		 }
		 for (int i = 1; i<8 ; i++){
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wpro1) && col == getCol(Wpro1) 
					 && t.getSource() == board[row-i][col]&&white==true&&Wcheck((row-i),(col))==true){
				 icon = Wpro1;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-i][col].setIcon(Wpro1);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wpro1) && col == getCol(Wpro1) 
					 && t.getSource() == board[row+i][col]&&white==true&&Wcheck((row+i),(col))==true){
				 icon = Wpro1;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row+i][col].setIcon(Wpro1);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Wpro1) && col == getCol(Wpro1) 
					 && t.getSource() == board[row][col-i]&&white==true&&Wcheck((row),(col-i))==true){
				 icon = Wpro1;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col-i].setIcon(Wpro1);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Wpro1) && col == getCol(Wpro1) 
					 && t.getSource() == board[row][col+i]&&white==true&&Wcheck((row),(col+i))==true){
				 icon = Wpro1;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col+i].setIcon(Wpro1);
			     gridcolor();
			     white=false;
			     black=true;
			 }
		 }
		 c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Wpro2&&white==true){
			 gridcolor();
			 icon = Wpro2;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	
				 }
				 c++;
			 }
			 for (int i = 1; i <= 7; i++){
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Wcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Wcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Wcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Wcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (r=1; r <=7; r++){
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wpro2) && col == getCol(Wpro2) 
					 && t.getSource() == board[row-r][col-c]&&white==true&&Wcheck((row-r),(col-c))==true){
				 icon = Wpro2;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-r][col-c].setIcon(Wpro2);
			     gridcolor();
			     white=false;
			     black=true;
			 }
            if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wpro2) && col == getCol(Wpro2) 
           		 && t.getSource() == board[row-r][col+c]&&white==true&&Wcheck((row-r),(col+c))==true){
           	 icon = Wpro2;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row-r][col+c].setIcon(Wpro2);
   		     gridcolor();
   		     white=false;
   		     black=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wpro2) && col == getCol(Wpro2) 
           		 && t.getSource() == board[row+r][col-c]&&white==true&&Wcheck((row+r),(col-c))==true){
           	 icon = Wpro2;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col-c].setIcon(Wpro2);
   		     gridcolor();
   		     white=false;
   		     black=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wpro2) && col == getCol(Wpro2) 
           		 && t.getSource() == board[row+r][col+c]&&white==true&&Wcheck((row+r),(col+c))==true){
           	 icon = Wpro2;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col+c].setIcon(Wpro2);
   		     gridcolor();
   		     white=false;
   		     black=true;
            }
			 
			 c++;
		 }
		 for (int i = 1; i<8 ; i++){
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wpro2) && col == getCol(Wpro2) 
					 && t.getSource() == board[row-i][col]&&white==true&&Wcheck((row-i),(col))==true){
				 icon = Wpro2;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-i][col].setIcon(Wpro2);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wpro2) && col == getCol(Wpro2) 
					 && t.getSource() == board[row+i][col]&&white==true&&Wcheck((row+i),(col))==true){
				 icon = Wpro2;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row+i][col].setIcon(Wpro2);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Wpro2) && col == getCol(Wpro2) 
					 && t.getSource() == board[row][col-i]&&white==true&&Wcheck((row),(col-i))==true){
				 icon = Wpro2;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col-i].setIcon(Wpro2);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Wpro2) && col == getCol(Wpro2) 
					 && t.getSource() == board[row][col+i]&&white==true&&Wcheck((row),(col+i))==true){
				 icon = Wpro2;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col+i].setIcon(Wpro2);
			     gridcolor();
			     white=false;
			     black=true;
			 }
		 }
		 c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Wpro3&&white==true){
			 gridcolor();
			 icon = Wpro3;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	
				 }
				 c++;
			 }
			 for (int i = 1; i <= 7; i++){
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Wcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Wcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Wcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Wcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (r=1; r <=7; r++){
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wpro3) && col == getCol(Wpro3) 
					 && t.getSource() == board[row-r][col-c]&&white==true&&Wcheck((row-r),(col-c))==true){
				 icon = Wpro3;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-r][col-c].setIcon(Wpro3);
			     gridcolor();
			     white=false;
			     black=true;
			 }
            if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wpro3) && col == getCol(Wpro3) 
           		 && t.getSource() == board[row-r][col+c]&&white==true&&Wcheck((row-r),(col+c))==true){
           	 icon = Wpro3;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row-r][col+c].setIcon(Wpro3);
   		     gridcolor();
   		     white=false;
   		     black=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wpro3) && col == getCol(Wpro3) 
           		 && t.getSource() == board[row+r][col-c]&&white==true&&Wcheck((row+r),(col-c))==true){
           	 icon = Wpro3;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col-c].setIcon(Wpro3);
   		     gridcolor();
   		     white=false;
   		     black=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wpro3) && col == getCol(Wpro3) 
           		 && t.getSource() == board[row+r][col+c]&&white==true&&Wcheck((row+r),(col+c))==true){
           	 icon = Wpro3;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col+c].setIcon(Wpro3);
   		     gridcolor();
   		     white=false;
   		     black=true;
            }
			 
			 c++;
		 }
		 for (int i = 1; i<8 ; i++){
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wpro3) && col == getCol(Wpro3) 
					 && t.getSource() == board[row-i][col]&&white==true&&Wcheck((row-i),(col))==true){
				 icon = Wpro3;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-i][col].setIcon(Wpro3);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wpro3) && col == getCol(Wpro3) 
					 && t.getSource() == board[row+i][col]&&white==true&&Wcheck((row+i),(col))==true){
				 icon = Wpro3;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row+i][col].setIcon(Wpro3);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Wpro3) && col == getCol(Wpro3) 
					 && t.getSource() == board[row][col-i]&&white==true&&Wcheck((row),(col-i))==true){
				 icon = Wpro3;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col-i].setIcon(Wpro3);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Wpro3) && col == getCol(Wpro3) 
					 && t.getSource() == board[row][col+i]&&white==true&&Wcheck((row),(col+i))==true){
				 icon = Wpro3;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col+i].setIcon(Wpro3);
			     gridcolor();
			     white=false;
			     black=true;
			 }
		 }
		 c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Wpro4&&white==true){
			 gridcolor();
			 icon = Wpro4;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	
				 }
				 c++;
			 }
			 for (int i = 1; i <= 7; i++){
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Wcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Wcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Wcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Wcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (r=1; r <=7; r++){
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wpro4) && col == getCol(Wpro4) 
					 && t.getSource() == board[row-r][col-c]&&white==true&&Wcheck((row-r),(col-c))==true){
				 icon = Wpro4;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-r][col-c].setIcon(Wpro4);
			     gridcolor();
			     white=false;
			     black=true;
			 }
            if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wpro4) && col == getCol(Wpro4) 
           		 && t.getSource() == board[row-r][col+c]&&white==true&&Wcheck((row-r),(col+c))==true){
           	 icon = Wpro4;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row-r][col+c].setIcon(Wpro4);
   		     gridcolor();
   		     white=false;
   		     black=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wpro4) && col == getCol(Wpro4) 
           		 && t.getSource() == board[row+r][col-c]&&white==true&&Wcheck((row+r),(col-c))==true){
           	 icon = Wpro4;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col-c].setIcon(Wpro4);
   		     gridcolor();
   		     white=false;
   		     black=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wpro4) && col == getCol(Wpro4) 
           		 && t.getSource() == board[row+r][col+c]&&white==true&&Wcheck((row+r),(col+c))==true){
           	 icon = Wpro4;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col+c].setIcon(Wpro4);
   		     gridcolor();
   		     white=false;
   		     black=true;
            }
			 
			 c++;
		 }
		 for (int i = 1; i<8 ; i++){
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wpro4) && col == getCol(Wpro4) 
					 && t.getSource() == board[row-i][col]&&white==true&&Wcheck((row-i),(col))==true){
				 icon = Wpro4;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-i][col].setIcon(Wpro4);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wpro4) && col == getCol(Wpro4) 
					 && t.getSource() == board[row+i][col]&&white==true&&Wcheck((row+i),(col))==true){
				 icon = Wpro4;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row+i][col].setIcon(Wpro4);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Wpro4) && col == getCol(Wpro4) 
					 && t.getSource() == board[row][col-i]&&white==true&&Wcheck((row),(col-i))==true){
				 icon = Wpro4;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col-i].setIcon(Wpro4);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Wpro4) && col == getCol(Wpro4) 
					 && t.getSource() == board[row][col+i]&&white==true&&Wcheck((row),(col+i))==true){
				 icon = Wpro4;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col+i].setIcon(Wpro4);
			     gridcolor();
			     white=false;
			     black=true;
			 }
		 }
		 c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Wpro5&&white==true){
			 gridcolor();
			 icon = Wpro5;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	
				 }
				 c++;
			 }
			 for (int i = 1; i <= 7; i++){
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Wcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Wcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Wcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Wcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (r=1; r <=7; r++){
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wpro5) && col == getCol(Wpro5) 
					 && t.getSource() == board[row-r][col-c]&&white==true&&Wcheck((row-r),(col-c))==true){
				 icon = Wpro5;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-r][col-c].setIcon(Wpro5);
			     gridcolor();
			     white=false;
			     black=true;
			 }
            if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wpro5) && col == getCol(Wpro5) 
           		 && t.getSource() == board[row-r][col+c]&&white==true&&Wcheck((row-r),(col+c))==true){
           	 icon = Wpro5;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row-r][col+c].setIcon(Wpro5);
   		     gridcolor();
   		     white=false;
   		     black=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wpro5) && col == getCol(Wpro5) 
           		 && t.getSource() == board[row+r][col-c]&&white==true&&Wcheck((row+r),(col-c))==true){
           	 icon = Wpro5;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col-c].setIcon(Wpro5);
   		     gridcolor();
   		     white=false;
   		     black=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wpro5) && col == getCol(Wpro5) 
           		 && t.getSource() == board[row+r][col+c]&&white==true&&Wcheck((row+r),(col+c))==true){
           	 icon = Wpro5;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col+c].setIcon(Wpro5);
   		     gridcolor();
   		     white=false;
   		     black=true;
            }
			 
			 c++;
		 }
		 for (int i = 1; i<8 ; i++){
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wpro5) && col == getCol(Wpro5) 
					 && t.getSource() == board[row-i][col]&&white==true&&Wcheck((row-i),(col))==true){
				 icon = Wpro5;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-i][col].setIcon(Wpro5);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wpro5) && col == getCol(Wpro5) 
					 && t.getSource() == board[row+i][col]&&white==true&&Wcheck((row+i),(col))==true){
				 icon = Wpro5;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row+i][col].setIcon(Wpro5);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Wpro5) && col == getCol(Wpro5) 
					 && t.getSource() == board[row][col-i]&&white==true&&Wcheck((row),(col-i))==true){
				 icon = Wpro5;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col-i].setIcon(Wpro5);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Wpro5) && col == getCol(Wpro5) 
					 && t.getSource() == board[row][col+i]&&white==true&&Wcheck((row),(col+i))==true){
				 icon = Wpro5;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col+i].setIcon(Wpro5);
			     gridcolor();
			     white=false;
			     black=true;
			 }
		 }
		 c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Wpro6&&white==true){
			 gridcolor();
			 icon = Wpro6;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	
				 }
				 c++;
			 }
			 for (int i = 1; i <= 7; i++){
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Wcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Wcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Wcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Wcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (r=1; r <=7; r++){
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wpro6) && col == getCol(Wpro6) 
					 && t.getSource() == board[row-r][col-c]&&white==true&&Wcheck((row-r),(col-c))==true){
				 icon = Wpro6;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-r][col-c].setIcon(Wpro6);
			     gridcolor();
			     white=false;
			     black=true;
			 }
            if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wpro6) && col == getCol(Wpro6) 
           		 && t.getSource() == board[row-r][col+c]&&white==true&&Wcheck((row-r),(col+c))==true){
           	 icon = Wpro6;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row-r][col+c].setIcon(Wpro6);
   		     gridcolor();
   		     white=false;
   		     black=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wpro6) && col == getCol(Wpro6) 
           		 && t.getSource() == board[row+r][col-c]&&white==true&&Wcheck((row+r),(col-c))==true){
           	 icon = Wpro6;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col-c].setIcon(Wpro6);
   		     gridcolor();
   		     white=false;
   		     black=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wpro6) && col == getCol(Wpro6) 
           		 && t.getSource() == board[row+r][col+c]&&white==true&&Wcheck((row+r),(col+c))==true){
           	 icon = Wpro6;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col+c].setIcon(Wpro6);
   		     gridcolor();
   		     white=false;
   		     black=true;
            }
			 
			 c++;
		 }
		 for (int i = 1; i<8 ; i++){
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wpro6) && col == getCol(Wpro6) 
					 && t.getSource() == board[row-i][col]&&white==true&&Wcheck((row-i),(col))==true){
				 icon = Wpro6;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-i][col].setIcon(Wpro6);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wpro6) && col == getCol(Wpro6) 
					 && t.getSource() == board[row+i][col]&&white==true&&Wcheck((row+i),(col))==true){
				 icon = Wpro6;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row+i][col].setIcon(Wpro6);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Wpro6) && col == getCol(Wpro6) 
					 && t.getSource() == board[row][col-i]&&white==true&&Wcheck((row),(col-i))==true){
				 icon = Wpro6;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col-i].setIcon(Wpro6);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Wpro6) && col == getCol(Wpro6) 
					 && t.getSource() == board[row][col+i]&&white==true&&Wcheck((row),(col+i))==true){
				 icon = Wpro6;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col+i].setIcon(Wpro6);
			     gridcolor();
			     white=false;
			     black=true;
			 }
		 }
		 c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Wpro7&&white==true){
			 gridcolor();
			 icon = Wpro7;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	
				 }
				 c++;
			 }
			 for (int i = 1; i <= 7; i++){
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Wcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Wcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Wcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Wcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (r=1; r <=7; r++){
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wpro7) && col == getCol(Wpro7) 
					 && t.getSource() == board[row-r][col-c]&&white==true&&Wcheck((row-r),(col-c))==true){
				 icon = Wpro7;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-r][col-c].setIcon(Wpro7);
			     gridcolor();
			     white=false;
			     black=true;
			 }
            if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wpro7) && col == getCol(Wpro7) 
           		 && t.getSource() == board[row-r][col+c]&&white==true&&Wcheck((row-r),(col+c))==true){
           	 icon = Wpro7;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row-r][col+c].setIcon(Wpro7);
   		     gridcolor();
   		     white=false;
   		     black=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wpro7) && col == getCol(Wpro7) 
           		 && t.getSource() == board[row+r][col-c]&&white==true&&Wcheck((row+r),(col-c))==true){
           	 icon = Wpro7;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col-c].setIcon(Wpro7);
   		     gridcolor();
   		     white=false;
   		     black=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wpro7) && col == getCol(Wpro7) 
           		 && t.getSource() == board[row+r][col+c]&&white==true&&Wcheck((row+r),(col+c))==true){
           	 icon = Wpro7;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col+c].setIcon(Wpro7);
   		     gridcolor();
   		     white=false;
   		     black=true;
            }
			 
			 c++;
		 }
		 for (int i = 1; i<8 ; i++){
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wpro7) && col == getCol(Wpro7) 
					 && t.getSource() == board[row-i][col]&&white==true&&Wcheck((row-i),(col))==true){
				 icon = Wpro7;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-i][col].setIcon(Wpro7);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wpro7) && col == getCol(Wpro7) 
					 && t.getSource() == board[row+i][col]&&white==true&&Wcheck((row+i),(col))==true){
				 icon = Wpro7;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row+i][col].setIcon(Wpro7);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Wpro7) && col == getCol(Wpro7) 
					 && t.getSource() == board[row][col-i]&&white==true&&Wcheck((row),(col-i))==true){
				 icon = Wpro7;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col-i].setIcon(Wpro7);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Wpro7) && col == getCol(Wpro7) 
					 && t.getSource() == board[row][col+i]&&white==true&&Wcheck((row),(col+i))==true){
				 icon = Wpro7;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col+i].setIcon(Wpro7);
			     gridcolor();
			     white=false;
			     black=true;
			 }
		 }
		 c=1;
		 if ((ImageIcon) ((AbstractButton) t.getSource()).getIcon() == Wpro8&&white==true){
			 gridcolor();
			 icon = Wpro8;
			 row = getRow(icon);
			 col = getCol(icon);
			 for (r = 1; r <= 7; r++){
				 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row-r),(col-c))==true){
					 board[row-r][col-c].setBackground(Color.cyan);	 
				 }
				 if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row-r),(col+c))==true){
					 board[row-r][col+c].setBackground(Color.cyan);	 
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1&&Wcheck((row+r),(col-c))==true){
					 board[row+r][col-c].setBackground(Color.cyan);	
				 }
				 if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1&&Wcheck((row+r),(col+c))==true){
					 board[row+r][col+c].setBackground(Color.cyan);	
				 }
				 c++;
			 }
			 for (int i = 1; i <= 7; i++){
				 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&Wcheck((row-i),(col))==true)board[row-i][col].setBackground(Color.cyan);
				 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&Wcheck((row+i),(col))==true)board[row+i][col].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&Wcheck((row),(col-i))==true)board[row][col-i].setBackground(Color.cyan);
				 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&Wcheck((row),(col+i))==true)board[row][col+i].setBackground(Color.cyan);
			 }
		 }
		 for (r=1; r <=7; r++){
			 if ((row-r)<8 && (row-r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wpro8) && col == getCol(Wpro8) 
					 && t.getSource() == board[row-r][col-c]&&white==true&&Wcheck((row-r),(col-c))==true){
				 icon = Wpro8;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-r][col-c].setIcon(Wpro8);
			     gridcolor();
			     white=false;
			     black=true;
			 }
            if ((row-r)<8 && (row-r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wpro8) && col == getCol(Wpro8) 
           		 && t.getSource() == board[row-r][col+c]&&white==true&&Wcheck((row-r),(col+c))==true){
           	 icon = Wpro8;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row-r][col+c].setIcon(Wpro8);
   		     gridcolor();
   		     white=false;
   		     black=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col-c)<8 && (col-c)>-1 && row == getRow(Wpro8) && col == getCol(Wpro8) 
           		 && t.getSource() == board[row+r][col-c]&&white==true&&Wcheck((row+r),(col-c))==true){
           	 icon = Wpro8;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col-c].setIcon(Wpro8);
   		     gridcolor();
   		     white=false;
   		     black=true;
			 }
            if ((row+r)<8 && (row+r)>-1 && (col+c)<8 && (col+c)>-1 && row == getRow(Wpro8) && col == getCol(Wpro8) 
           		 && t.getSource() == board[row+r][col+c]&&white==true&&Wcheck((row+r),(col+c))==true){
           	 icon = Wpro8;
   			 col = getCol(icon);
   			 row = getRow(icon);					
   			 board[row][col].setIcon(null); 
   		     board[row+r][col+c].setIcon(Wpro8);
   		     gridcolor();
   		     white=false;
   		     black=true;
            }
			 
			 c++;
		 }
		 for (int i = 1; i<8 ; i++){
			 if ((row-i)<8 && (row-i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wpro8) && col == getCol(Wpro8) 
					 && t.getSource() == board[row-i][col]&&white==true&&Wcheck((row-i),(col))==true){
				 icon = Wpro8;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row-i][col].setIcon(Wpro8);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row+i)<8 && (row+i)>-1 && (col)<8 && (col)>-1&&row == getRow(Wpro8) && col == getCol(Wpro8) 
					 && t.getSource() == board[row+i][col]&&white==true&&Wcheck((row+i),(col))==true){
				 icon = Wpro8;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row+i][col].setIcon(Wpro8);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col-i)<8 && (col-i)>-1&&row == getRow(Wpro8) && col == getCol(Wpro8) 
					 && t.getSource() == board[row][col-i]&&white==true&&Wcheck((row),(col-i))==true){
				 icon = Wpro8;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col-i].setIcon(Wpro8);
			     gridcolor();
			     white=false;
			     black=true;
			 }
			 if ((row)<8 && (row)>-1 && (col+i)<8 && (col+i)>-1&&row == getRow(Wpro8) && col == getCol(Wpro8) 
					 && t.getSource() == board[row][col+i]&&white==true&&Wcheck((row),(col+i))==true){
				 icon = Wpro8;
				 col = getCol(icon);
				 row = getRow(icon);					
				 board[row][col].setIcon(null); 
			     board[row][col+i].setIcon(Wpro8);
			     gridcolor();
			     white=false;
			     black=true;
			 }
		 }
	}
	
	
	
	public static int getRow(ImageIcon icon){
		//receives the row from piece
		int x = 0;
		
		for (int row = 0; row < 8; row ++) {
	    	  for (int col = 0; col < 8; col++) {
	    	  	  if (board[row][col].getIcon() == icon) {
	    			 x = row;
	    		  }
	    	  }
	    }
		
		return x;
		
	}
	public static int getCol(ImageIcon icon){
		//receives the column of piece
		int x = 0;
		
		for (int row = 0; row < 8; row ++) {
	    	  for (int col = 0; col < 8; col++) {
	    	  	  if (board[row][col].getIcon() == icon) {
	    			 x = col;
	    		  }
	    	  }
	    }
		
		return x;
		
	}
	
	public static void gridcolor(){
		//sets original board color
		for (row = 0; row < 8; row ++) {
			for (col = 0; col < 8; col++) {
				if (row % 2 == 0) {
					if (col % 2 == 0){
						board[row][col].setBackground(Color.WHITE);
		    	    }
		    	    else board[row][col].setBackground(Color.GRAY);
				}
		    	else {
		    		if (col % 2 == 0){
		    			board[row][col].setBackground(Color.GRAY);
		  	    	}
		  	    	else board[row][col].setBackground(Color.WHITE);
		    	}
			}
	   }
	}
	
	public static boolean checkpawn(int row, int col){
		//same as check all but pawns included
		boolean x = false;
		if(board[row][col].getIcon() != Bking&&board[row][col].getIcon() != Bqueen&&board[row][col].getIcon() != Bknight1&&
				board[row][col].getIcon() != Bknight2&&board[row][col].getIcon() != Bbishop1&&
				board[row][col].getIcon() != Bbishop2&&board[row][col].getIcon() != Brook1&&
				board[row][col].getIcon() != Brook2&&board[row][col].getIcon() != Wking&&
				board[row][col].getIcon() != Wqueen&&board[row][col].getIcon() != Wknight1&&
				board[row][col].getIcon() != Wknight2&&board[row][col].getIcon() != Wbishop1&&
				board[row][col].getIcon() != Wbishop2&&board[row][col].getIcon() != Wrook1&&
				board[row][col].getIcon() != Wrook2) x = true;
		else x=false;
		
		return x;
	}
	public static boolean checkAll(int row, int col) {
		//checks every piece for the pawn since a pawn can not kill vertically
		boolean x = false;
		int a=0;
		int b=0;
		for (int i=0; i<8; i++){
			if(board[row][col].getIcon()!=Bpawn[i]) a++;
			if(board[row][col].getIcon()!=Wpawn[i]) b++;
		}
		if(a==8&&b==8)x=true;
		else x = false;
		return x;
	}
	public static boolean Bcheck(int row, int col){
		//checks all black pieces and returns a boolean to allow a black piece not hit another black piece
		boolean x = false;
		int count=0;
		for (int i = 0; i<8; i++){
		if(board[row][col].getIcon() != Bking&&board[row][col].getIcon() != Bqueen&&board[row][col].getIcon() != Bknight1&&
				board[row][col].getIcon() != Bknight2&&board[row][col].getIcon() != Bbishop1&&
				board[row][col].getIcon() != Bbishop2&&board[row][col].getIcon() != Brook1&&
				board[row][col].getIcon() != Brook2&&board[row][col].getIcon() != Bpawn[i]) count++;
		}
		if (count==8)x=true;
		else x=false;
		
		return x;
	}
	public static boolean Wcheck(int row, int col){
		//checks all white pieces and returns a boolean to allow a white piece not hit another white piece
		boolean x = false;
		int count=0;
		for (int i = 0; i<8; i++){
		if(board[row][col].getIcon() != Wking&&board[row][col].getIcon() != Wqueen&&board[row][col].getIcon() != Wknight1&&
				board[row][col].getIcon() != Wknight2&&board[row][col].getIcon() != Wbishop1&&
				board[row][col].getIcon() != Wbishop2&&board[row][col].getIcon() != Wrook1&&
				board[row][col].getIcon() != Wrook2&&board[row][col].getIcon() != Wpawn[i]) count++;
		}
		if (count==8)x=true;
		else x=false;
		
		return x;
	}
	public static boolean B2(int row){
		//sets only the black pawns in original space to move 2 spaces
		boolean x = false;
		if(row == 6)x=true;
		else x = false;
		
		return x;
	}
	public static boolean W2(int row){
		//sets only the white pawns in original space to move 2 spaces

		boolean x = false;
		if(row == 1)x=true;
		else x = false;
		
		return x;
	}	
	
}
