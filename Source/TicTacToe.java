package tictactoe;

//Importing

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.*;
import org.lwjgl.*;

public class TicTacToe {
	
	//Custom inbounds method
	
	public boolean coordInBoundsRect(double pointx, double pointy, int x1, int y1, int x2, int y2){
		if(pointx >= x1 && pointx <= x2 && pointy >= y1 && pointy <= y2){
			return true;
		}
		else{
			return false;
		}
	}
	
	public TicTacToe(){
		
		//Init
		
		try{
			
			Display.setDisplayMode(new DisplayMode(640, 480));
			Display.setTitle("Tic-Tac-Toe");
			Display.create();
			
		}
		
		catch (LWJGLException e){
			
			e.printStackTrace();
			
		}
		
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 640, 480, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		
		//Init variables
		
		TicTacToeTileTypes[][] ticTacToeBoard = new TicTacToeTileTypes[3][3];
		for(int x = 0; x < 3; x++){
			for(int y = 0; y < 3; y++){
				ticTacToeBoard[x][y] = TicTacToeTileTypes.BLANK;
			}
		}
		boolean mouseAlreadyDown = false;
		boolean mouseDown;
		double mouseX;
		double mouseY;
		Turn whoseTurn = Turn.X;
		boolean win = false;
		
		while (!Display.isCloseRequested()){
			
			mouseDown = Mouse.isButtonDown(0);
			mouseX = Mouse.getX();
			mouseY = 480 - Mouse.getY();
			
			if(mouseDown && !mouseAlreadyDown && win){
				for(int x = 0; x < 3; x++){
					for(int y = 0; y < 3; y++){
						ticTacToeBoard[x][y] = TicTacToeTileTypes.BLANK;
					}
				}
				win = false;
				whoseTurn = Turn.X;
				mouseAlreadyDown = true;
			}
			
			if(!mouseDown && mouseAlreadyDown){
				mouseAlreadyDown = false;
			}
			
			glClear(GL_COLOR_BUFFER_BIT);
			
			//Draw Board
					
			glRectd(250,100,255,400);
			glRectd(350,100,355,400);
			glRectd(150,200,450,205);
			glRectd(150,300,450,305);
			
			//Draw X's and O's
			
			if(ticTacToeBoard[0][0] == TicTacToeTileTypes.X){
				glBegin(GL_LINE_STRIP);
				glVertex2d(160,110);
				glVertex2d(240,190);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(240,110);
				glVertex2d(160,190);
				glEnd();
			}
			if(ticTacToeBoard[0][0] == TicTacToeTileTypes.O){
				glBegin(GL_LINE_STRIP);
				glVertex2d(170,120);
				glVertex2d(230,120);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(230,120);
				glVertex2d(230,180);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(170,120);
				glVertex2d(170,180);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(170,180);
				glVertex2d(230,180);
				glEnd();
			}
			if(ticTacToeBoard[0][1] == TicTacToeTileTypes.X){
				glBegin(GL_LINE_STRIP);
				glVertex2d(160,210);
				glVertex2d(240,290);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(240,210);
				glVertex2d(160,290);
				glEnd();
			}
			if(ticTacToeBoard[0][1] == TicTacToeTileTypes.O){
				glBegin(GL_LINE_STRIP);
				glVertex2d(170,220);
				glVertex2d(230,220);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(230,220);
				glVertex2d(230,280);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(170,220);
				glVertex2d(170,280);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(170,280);
				glVertex2d(230,280);
				glEnd();
			}
			if(ticTacToeBoard[0][2] == TicTacToeTileTypes.X){
				glBegin(GL_LINE_STRIP);
				glVertex2d(160,310);
				glVertex2d(240,390);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(240,310);
				glVertex2d(160,390);
				glEnd();
			}
			if(ticTacToeBoard[0][2] == TicTacToeTileTypes.O){
				glBegin(GL_LINE_STRIP);
				glVertex2d(170,320);
				glVertex2d(230,320);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(230,320);
				glVertex2d(230,380);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(170,320);
				glVertex2d(170,380);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(170,380);
				glVertex2d(230,380);
				glEnd();
			}
			if(ticTacToeBoard[1][0] == TicTacToeTileTypes.X){
				glBegin(GL_LINE_STRIP);
				glVertex2d(260,110);
				glVertex2d(340,190);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(340,110);
				glVertex2d(260,190);
				glEnd();
			}
			if(ticTacToeBoard[1][0] == TicTacToeTileTypes.O){
				glBegin(GL_LINE_STRIP);
				glVertex2d(270,120);
				glVertex2d(330,120);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(330,120);
				glVertex2d(330,180);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(270,120);
				glVertex2d(270,180);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(270,180);
				glVertex2d(330,180);
				glEnd();
			}
			if(ticTacToeBoard[1][1] == TicTacToeTileTypes.X){
				glBegin(GL_LINE_STRIP);
				glVertex2d(260,210);
				glVertex2d(340,290);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(340,210);
				glVertex2d(260,290);
				glEnd();
			}
			if(ticTacToeBoard[1][1] == TicTacToeTileTypes.O){
				glBegin(GL_LINE_STRIP);
				glVertex2d(270,220);
				glVertex2d(330,220);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(330,220);
				glVertex2d(330,280);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(270,220);
				glVertex2d(270,280);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(270,280);
				glVertex2d(330,280);
				glEnd();
			}
			if(ticTacToeBoard[1][2] == TicTacToeTileTypes.X){
				glBegin(GL_LINE_STRIP);
				glVertex2d(260,310);
				glVertex2d(340,390);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(340,310);
				glVertex2d(260,390);
				glEnd();
			}
			if(ticTacToeBoard[1][2] == TicTacToeTileTypes.O){
				glBegin(GL_LINE_STRIP);
				glVertex2d(270,320);
				glVertex2d(330,320);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(330,320);
				glVertex2d(330,380);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(270,320);
				glVertex2d(270,380);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(270,380);
				glVertex2d(330,380);
				glEnd();
			}
			if(ticTacToeBoard[2][0] == TicTacToeTileTypes.X){
				glBegin(GL_LINE_STRIP);
				glVertex2d(360,110);
				glVertex2d(440,190);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(440,110);
				glVertex2d(360,190);
				glEnd();
			}
			if(ticTacToeBoard[2][0] == TicTacToeTileTypes.O){
				glBegin(GL_LINE_STRIP);
				glVertex2d(370,120);
				glVertex2d(430,120);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(430,120);
				glVertex2d(430,180);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(370,120);
				glVertex2d(370,180);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(370,180);
				glVertex2d(430,180);
				glEnd();
			}
			if(ticTacToeBoard[2][1] == TicTacToeTileTypes.X){
				glBegin(GL_LINE_STRIP);
				glVertex2d(360,210);
				glVertex2d(440,290);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(440,210);
				glVertex2d(360,290);
				glEnd();
			}
			if(ticTacToeBoard[2][1] == TicTacToeTileTypes.O){
				glBegin(GL_LINE_STRIP);
				glVertex2d(370,220);
				glVertex2d(430,220);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(430,220);
				glVertex2d(430,280);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(370,220);
				glVertex2d(370,280);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(370,280);
				glVertex2d(430,280);
				glEnd();
			}
			if(ticTacToeBoard[2][2] == TicTacToeTileTypes.X){
				glBegin(GL_LINE_STRIP);
				glVertex2d(360,310);
				glVertex2d(440,390);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(440,310);
				glVertex2d(360,390);
				glEnd();
			}
			if(ticTacToeBoard[2][2] == TicTacToeTileTypes.O){
				glBegin(GL_LINE_STRIP);
				glVertex2d(370,320);
				glVertex2d(430,320);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(430,320);
				glVertex2d(430,380);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(370,320);
				glVertex2d(370,380);
				glEnd();
				glBegin(GL_LINE_STRIP);
				glVertex2d(370,380);
				glVertex2d(430,380);
				glEnd();
			}
			
			//See if mouseclick on tile, then change it according to whose turn it is.
			
			if(mouseDown && !mouseAlreadyDown && coordInBoundsRect(mouseX, mouseY, 150, 100, 250, 200) && ticTacToeBoard[0][0] == TicTacToeTileTypes.BLANK){
				if(whoseTurn == Turn.X){
					ticTacToeBoard[0][0] = TicTacToeTileTypes.X;
					whoseTurn = Turn.O;
				}
				else if(whoseTurn == Turn.O){
					ticTacToeBoard[0][0] = TicTacToeTileTypes.O;
					whoseTurn = Turn.X;
				}
			}
			if(mouseDown && !mouseAlreadyDown && coordInBoundsRect(mouseX, mouseY, 150, 205, 250, 305) && ticTacToeBoard[0][1] == TicTacToeTileTypes.BLANK){
				if(whoseTurn == Turn.X){
					ticTacToeBoard[0][1] = TicTacToeTileTypes.X;
					whoseTurn = Turn.O;
				}
				else if(whoseTurn == Turn.O){
					ticTacToeBoard[0][1] = TicTacToeTileTypes.O;
					whoseTurn = Turn.X;
				}
			}
			if(mouseDown && !mouseAlreadyDown && coordInBoundsRect(mouseX, mouseY, 150, 310, 250, 410) && ticTacToeBoard[0][2] == TicTacToeTileTypes.BLANK){
				if(whoseTurn == Turn.X){
					ticTacToeBoard[0][2] = TicTacToeTileTypes.X;
					whoseTurn = Turn.O;
				}
				else if(whoseTurn == Turn.O){
					ticTacToeBoard[0][2] = TicTacToeTileTypes.O;
					whoseTurn = Turn.X;
				}
			}
			if(mouseDown && !mouseAlreadyDown && coordInBoundsRect(mouseX, mouseY, 255, 100, 355, 200) && ticTacToeBoard[1][0] == TicTacToeTileTypes.BLANK){
				if(whoseTurn == Turn.X){
					ticTacToeBoard[1][0] = TicTacToeTileTypes.X;
					whoseTurn = Turn.O;
				}
				else if(whoseTurn == Turn.O){
					ticTacToeBoard[1][0] = TicTacToeTileTypes.O;
					whoseTurn = Turn.X;
				}
			}
			if(mouseDown && !mouseAlreadyDown && coordInBoundsRect(mouseX, mouseY, 255, 205, 355, 305) && ticTacToeBoard[1][1] == TicTacToeTileTypes.BLANK){
				if(whoseTurn == Turn.X){
					ticTacToeBoard[1][1] = TicTacToeTileTypes.X;
					whoseTurn = Turn.O;
				}
				else if(whoseTurn == Turn.O){
					ticTacToeBoard[1][1] = TicTacToeTileTypes.O;
					whoseTurn = Turn.X;
				}
			}
			if(mouseDown && !mouseAlreadyDown && coordInBoundsRect(mouseX, mouseY, 255, 310, 355, 410) && ticTacToeBoard[1][2] == TicTacToeTileTypes.BLANK){
				if(whoseTurn == Turn.X){
					ticTacToeBoard[1][2] = TicTacToeTileTypes.X;
					whoseTurn = Turn.O;
				}
				else if(whoseTurn == Turn.O){
					ticTacToeBoard[1][2] = TicTacToeTileTypes.O;
					whoseTurn = Turn.X;
				}
			}
			if(mouseDown && !mouseAlreadyDown && coordInBoundsRect(mouseX, mouseY, 360, 100, 460, 200) && ticTacToeBoard[2][0] == TicTacToeTileTypes.BLANK){
				if(whoseTurn == Turn.X){
					ticTacToeBoard[2][0] = TicTacToeTileTypes.X;
					whoseTurn = Turn.O;
				}
				else if(whoseTurn == Turn.O){
					ticTacToeBoard[2][0] = TicTacToeTileTypes.O;
					whoseTurn = Turn.X;
				}
			}
			if(mouseDown && !mouseAlreadyDown && coordInBoundsRect(mouseX, mouseY, 360, 205, 460, 305) && ticTacToeBoard[2][1] == TicTacToeTileTypes.BLANK){
				if(whoseTurn == Turn.X){
					ticTacToeBoard[2][1] = TicTacToeTileTypes.X;
					whoseTurn = Turn.O;
				}
				else if(whoseTurn == Turn.O){
					ticTacToeBoard[2][1] = TicTacToeTileTypes.O;
					whoseTurn = Turn.X;
				}
			}
			if(mouseDown && !mouseAlreadyDown && coordInBoundsRect(mouseX, mouseY, 360, 310, 460, 410) && ticTacToeBoard[2][2] == TicTacToeTileTypes.BLANK){
				if(whoseTurn == Turn.X){
					ticTacToeBoard[2][2] = TicTacToeTileTypes.X;
					whoseTurn = Turn.O;
				}
				else if(whoseTurn == Turn.O){
					ticTacToeBoard[2][2] = TicTacToeTileTypes.O;
					whoseTurn = Turn.X;
				}
			}
			
			//Check for 3 in a row
			
			if(ticTacToeBoard[0][0] == TicTacToeTileTypes.X && ticTacToeBoard[1][0] == TicTacToeTileTypes.X && ticTacToeBoard[2][0] == TicTacToeTileTypes.X){
				glBegin(GL_LINE_STRIP);
				glVertex2d(150,150);
				glVertex2d(450,150);
				glEnd();
				win = true;
			}
			if(ticTacToeBoard[0][0] == TicTacToeTileTypes.O && ticTacToeBoard[1][0] == TicTacToeTileTypes.O && ticTacToeBoard[2][0] == TicTacToeTileTypes.O){
				glBegin(GL_LINE_STRIP);
				glVertex2d(150,150);
				glVertex2d(450,150);
				glEnd();
				win = true;
			}
			if(ticTacToeBoard[0][1] == TicTacToeTileTypes.X && ticTacToeBoard[1][1] == TicTacToeTileTypes.X && ticTacToeBoard[2][1] == TicTacToeTileTypes.X){
				glBegin(GL_LINE_STRIP);
				glVertex2d(150,255);
				glVertex2d(450,255);
				glEnd();
				win = true;
			}
			if(ticTacToeBoard[0][1] == TicTacToeTileTypes.O && ticTacToeBoard[1][1] == TicTacToeTileTypes.O && ticTacToeBoard[2][1] == TicTacToeTileTypes.O){
				glBegin(GL_LINE_STRIP);
				glVertex2d(150,255);
				glVertex2d(450,255);
				glEnd();
				win = true;
			}
			if(ticTacToeBoard[0][2] == TicTacToeTileTypes.X && ticTacToeBoard[1][2] == TicTacToeTileTypes.X && ticTacToeBoard[2][2] == TicTacToeTileTypes.X){
				glBegin(GL_LINE_STRIP);
				glVertex2d(150,310);
				glVertex2d(450,310);
				glEnd();
				win = true;
			}
			if(ticTacToeBoard[0][2] == TicTacToeTileTypes.O && ticTacToeBoard[1][2] == TicTacToeTileTypes.O && ticTacToeBoard[2][2] == TicTacToeTileTypes.O){
				glBegin(GL_LINE_STRIP);
				glVertex2d(150,310);
				glVertex2d(450,310);
				glEnd();
				win = true;
			}
			if(ticTacToeBoard[0][0] == TicTacToeTileTypes.X && ticTacToeBoard[0][1] == TicTacToeTileTypes.X && ticTacToeBoard[0][2] == TicTacToeTileTypes.X){
				glBegin(GL_LINE_STRIP);
				glVertex2d(200,100);
				glVertex2d(200,400);
				glEnd();
				win = true;
			}
			if(ticTacToeBoard[0][0] == TicTacToeTileTypes.O && ticTacToeBoard[0][1] == TicTacToeTileTypes.O && ticTacToeBoard[0][2] == TicTacToeTileTypes.O){
				glBegin(GL_LINE_STRIP);
				glVertex2d(200,100);
				glVertex2d(200,400);
				glEnd();
				win = true;
			}
			if(ticTacToeBoard[1][0] == TicTacToeTileTypes.X && ticTacToeBoard[1][1] == TicTacToeTileTypes.X && ticTacToeBoard[1][2] == TicTacToeTileTypes.X){
				glBegin(GL_LINE_STRIP);
				glVertex2d(305,100);
				glVertex2d(305,400);
				glEnd();
				win = true;
			}
			if(ticTacToeBoard[1][0] == TicTacToeTileTypes.O && ticTacToeBoard[1][1] == TicTacToeTileTypes.O && ticTacToeBoard[1][2] == TicTacToeTileTypes.O){
				glBegin(GL_LINE_STRIP);
				glVertex2d(305,100);
				glVertex2d(305,400);
				glEnd();
				win = true;
			}
			if(ticTacToeBoard[2][0] == TicTacToeTileTypes.X && ticTacToeBoard[2][1] == TicTacToeTileTypes.X && ticTacToeBoard[2][2] == TicTacToeTileTypes.X){
				glBegin(GL_LINE_STRIP);
				glVertex2d(410,100);
				glVertex2d(410,400);
				glEnd();
				win = true;
			}
			if(ticTacToeBoard[2][0] == TicTacToeTileTypes.O && ticTacToeBoard[2][1] == TicTacToeTileTypes.O && ticTacToeBoard[2][2] == TicTacToeTileTypes.O){
				glBegin(GL_LINE_STRIP);
				glVertex2d(410,100);
				glVertex2d(410,400);
				glEnd();
				win = true;
			}
			if(ticTacToeBoard[0][0] == TicTacToeTileTypes.X && ticTacToeBoard[1][1] == TicTacToeTileTypes.X && ticTacToeBoard[2][2] == TicTacToeTileTypes.X){
				glBegin(GL_LINE_STRIP);
				glVertex2d(150,100);
				glVertex2d(450,400);
				glEnd();
				win = true;
			}
			if(ticTacToeBoard[0][0] == TicTacToeTileTypes.O && ticTacToeBoard[1][1] == TicTacToeTileTypes.O && ticTacToeBoard[2][2] == TicTacToeTileTypes.O){
				glBegin(GL_LINE_STRIP);
				glVertex2d(150,100);
				glVertex2d(450,400);
				glEnd();
				win = true;
			}
			if(ticTacToeBoard[2][0] == TicTacToeTileTypes.X && ticTacToeBoard[1][1] == TicTacToeTileTypes.X && ticTacToeBoard[0][2] == TicTacToeTileTypes.X){
				glBegin(GL_LINE_STRIP);
				glVertex2d(450,100);
				glVertex2d(150,400);
				glEnd();
				win = true;
			}
			if(ticTacToeBoard[2][0] == TicTacToeTileTypes.O && ticTacToeBoard[1][1] == TicTacToeTileTypes.O && ticTacToeBoard[0][2] == TicTacToeTileTypes.O){
				glBegin(GL_LINE_STRIP);
				glVertex2d(450,100);
				glVertex2d(150,400);
				glEnd();
				win = true;
			}
			if(ticTacToeBoard[0][0] != TicTacToeTileTypes.BLANK && ticTacToeBoard[1][0] != TicTacToeTileTypes.BLANK && ticTacToeBoard[2][0] != TicTacToeTileTypes.BLANK && ticTacToeBoard[0][1] != TicTacToeTileTypes.BLANK && ticTacToeBoard[1][1] != TicTacToeTileTypes.BLANK && ticTacToeBoard[2][1] != TicTacToeTileTypes.BLANK && ticTacToeBoard[0][2] != TicTacToeTileTypes.BLANK && ticTacToeBoard[1][2] != TicTacToeTileTypes.BLANK && ticTacToeBoard[2][2] != TicTacToeTileTypes.BLANK){
				win = true;
			}
			
			//Sync with display
			
			Display.update();
			Display.sync(60);
			
			//Instead of continuous mouseDown, only 'click' once
			
			if(mouseDown && !mouseAlreadyDown){
				mouseAlreadyDown = true;
			}
			
		}
		
		Display.destroy();
		
	}

	public static void main(String[] args) {
		
		new TicTacToe();

	}

}
