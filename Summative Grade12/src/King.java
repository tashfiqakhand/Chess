import java.awt.Color;


public class King extends board{
	public static void Khighlight(){
		gridcolor();
		 icon = Bking;
		 row = getRow(icon);
		 col = getCol(icon);
		 
		 if ((row-1)<8 && (row-1)>-1 && (col)<8 && (col)>-1&&Bcheck((row-1),col)==true)board[row-1][col].setBackground(Color.cyan);
		 if ((row-1)<8 && (row-1)>-1 && (col+1)<8 && (col+1)>-1&&Bcheck((row-1),col+1)==true)board[row-1][col+1].setBackground(Color.cyan);
		 if ((row)<8 && (row)>-1 && (col+1)<8 && (col+1)>-1&&Bcheck((row),col+1)==true)board[row][col+1].setBackground(Color.cyan);
		 if ((row+1)<8 && (row+1)>-1 && (col+1)<8 && (col+1)>-1&&Bcheck((row+1),col+1)==true)board[row+1][col+1].setBackground(Color.cyan);
		 if ((row+1)<8 && (row+1)>-1 && (col)<8 && (col)>-1&&Bcheck((row+1),col)==true)board[row+1][col].setBackground(Color.cyan);
		 if ((row+1)<8 && (row+1)>-1 && (col-1)<8 && (col-1)>-1&&Bcheck((row+1),col-1)==true)board[row+1][col-1].setBackground(Color.cyan);
		 if ((row)<8 && (row)>-1 && (col-1)<8 && (col-1)>-1&&Bcheck((row),col-1)==true)board[row][col-1].setBackground(Color.cyan);
		 if ((row-1)<8 && (row-1)>-1 && (col-1)<8 && (col-1)>-1&&Bcheck((row-1),col-1)==true)board[row-1][col-1].setBackground(Color.cyan);
	}
}
