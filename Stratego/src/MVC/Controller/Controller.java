package MVC.Controller;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import MVC.Model.*;
import Utilities.RandomizePieces;
import MVC.View.*;
/**
 * Controller is the brain of the game. It controls the whole game.
 * Connects the Model package with the View package.
 * 
 * @version B
 * @author George Vasileiadis
 * */
public class Controller implements ActionListener{
	
		private Piece[][] Buttons = new Piece[8][10];
		private final Piece [] pieces = new Piece[60];
		
		Piece selected = null;
	     
	    Player P1,P2,P;
	    private ArrayList <Player> players=new ArrayList<Player>();

		public static final Color FireRed = new Color(255,51,51);		
		public static final Color IceBlue = new Color(51,204,255);
		
	        
		Graphics tablo;
		Board board;
		
				
		public Controller() throws IOException 
	        {
	        	tablo = new Graphics();
	        	board = new Board();
	        	
	            P1 = new Player("Player1", IceBlue);
	            P2 = new Player("Player2", FireRed);
	            players.add(P1);
	            players.add(P2);
	            
	            init_player_pieces(pieces);
	            
	            
	            init_Buttons();
	            putButtonsinPanel();
	            
	            setChangeofTurn();
	            

	        }
	        
	        
	    public void init_player_pieces(Piece[] pieces) throws IOException
	    {
	    	        
	    	        	//Bflag
	    	        	pieces[0] = new ImmovablePiece(0,IceBlue,100,"./src/Resources/images/bluePieces/flagB.png");
	    	            //first 3 Btraps
	    	        	for (int i = 1; i < 4; i++) {
	    	                pieces[i] = new ImmovablePiece(0,IceBlue,(100+i),"./src/Resources/images/bluePieces/trapB.png");
	    	            }
	    	            //Bslayer
	    	            pieces[4] =new MovablePiece(1,IceBlue,104,"./src/Resources/images/bluePieces/slayerB.png");
	    	            //first 2 Bscouts
	    	            for (int i = 5; i < 7; i++) {
	    	                pieces[i] =new MovablePiece(2,IceBlue,(100+i),"./src/Resources/images/bluePieces/scoutB.png");
	    	            }
	    	            //first 2 Bdwarves
	    	            for (int i = 7; i < 9; i++) {
	    	                pieces[i] =new MovablePiece(3,IceBlue,(100+i),"./src/Resources/images/bluePieces/dwarfB.png");
	    	            }
	    	            // first Belf	    	           
	    	            pieces[9] = new MovablePiece(4,IceBlue,109,"./src/Resources/images/bluePieces/elfB.png");
	    	            //first  Yeti
	    	            pieces[10] = new MovablePiece(5,IceBlue,110,"./src/Resources/images/bluePieces/yeti.png");
	    	        	//first Bsorceress
	    	            pieces[11] = new MovablePiece(6,IceBlue,111,"./src/Resources/images/bluePieces/sorceressB.png");
	    	            // first BBeastRider	            
	    	            pieces[12] = new MovablePiece(7,IceBlue,112,"./src/Resources/images/bluePieces/beastRiderB.png");
	    	            // first Bknight	    	            
	    	            pieces[13] = new MovablePiece(8,IceBlue,113,"./src/Resources/images/bluePieces/knightB.png");
	    	            // BMage
	    	            pieces[14] = new MovablePiece(9,IceBlue,114,"./src/Resources/images/bluePieces/mageB.png");
	    	            // BDrake
	    	            pieces[15] = new MovablePiece(10,IceBlue,115,"./src/Resources/images/bluePieces/dragonB.png");
	    	            // the other 3 Btraps
	    	            for (int i = 16; i < 19; i++) {
	    	                pieces[i] = new ImmovablePiece(0,IceBlue,(100+i),"./src/Resources/images/bluePieces/trapB.png");
	    	            }
	    	            //the other 2 Bscouts
	    	            for (int i = 19; i < 21; i++) {
	    	            	pieces[i] = new MovablePiece(2,IceBlue,(100+i),"./src/Resources/images/bluePieces/scoutB.png");
	    	            }
	    	            //the other 3 Bdwarves
	    	            for (int i = 21; i < 24; i++) {
	    	            	 pieces[i] =new MovablePiece(3,IceBlue,(100+i),"./src/Resources/images/bluePieces/dwarfB.png");
	    	            }
	    	            // the other Belf
	    	            pieces[24] = new MovablePiece(4,IceBlue,124,"./src/Resources/images/bluePieces/elfB.png");
	    	            // the other Byeti
	    	            pieces[25] = new MovablePiece(5,IceBlue,125,"./src/Resources/images/bluePieces/yeti.png");
	    	            //the other Bsorceress
	    	            pieces[26] = new MovablePiece(6,IceBlue,126,"./src/Resources/images/bluePieces/sorceressB.png");
	    	            // the other BBeastRider
	    	            for(int i = 27; i < 29; i++) {
	    	            pieces[i] = new MovablePiece(7,IceBlue,(100+i),"./src/Resources/images/bluePieces/beastRiderB.png");
	    	            }
	    	            //the other Bknight
	    	            pieces[29] = new MovablePiece(8,IceBlue,129,"./src/Resources/images/bluePieces/knightB.png");
	    	            
	    	            //Rflag
	    	        	pieces[30] = new ImmovablePiece(0,FireRed,200,"./src/Resources/images/bluePieces/flagR.png");
	    	            //first 3 Rtraps
	    	        	for (int i = 31; i < 34; i++) {
	    	                pieces[i] = new ImmovablePiece(0,FireRed,(200+i),"./src/Resources/images/bluePieces/trapR.png");
	    	            }
	    	            //Rslayer
	    	            pieces[34] =new MovablePiece(1,FireRed,204,"./src/Resources/images/bluePieces/slayerR.png");
	    	            //first 2 Rscouts
	    	            for (int i = 35; i < 37; i++) {
	    	                pieces[i] =new MovablePiece(2,FireRed,(200+i),"./src/Resources/images/bluePieces/scoutR.png");
	    	            }
	    	            //first 2 Rdwarves
	    	            for (int i = 37; i < 39; i++) {
	    	                pieces[i] =new MovablePiece(3,FireRed,(200+i),"./src/Resources/images/bluePieces/dwarfR.png");
	    	            }
	    	            // first Relf	    	           
	    	            pieces[39] = new MovablePiece(4,FireRed,209,"./src/Resources/images/RedPieces/elfR.png");
	    	            //first  Lavabeast
	    	            pieces[40] = new MovablePiece(5,FireRed,210,"./src/Resources/images/RedPieces/lavaBeast.png");
	    	        	//first Rsorceress
	    	            pieces[41] = new MovablePiece(6,FireRed,211,"./src/Resources/images/RedPieces/sorceressR.png");
	    	            // first RBeastRider	            
	    	            pieces[42] = new MovablePiece(7,FireRed,212,"./src/Resources/images/RedPieces/beastRiderR.png");
	    	            // first Rknight	    	            
	    	            pieces[43] = new MovablePiece(8,FireRed,213,"./src/Resources/images/RedPieces/knightR.png");
	    	            // RMage
	    	            pieces[44] = new MovablePiece(9,FireRed,214,"./src/Resources/images/RedPieces/mageR.png");
	    	            // RDrake
	    	            pieces[45] = new MovablePiece(10,FireRed,215,"./src/Resources/images/RedPieces/dragonR.png");
	    	            // the other 3 Rtraps
	    	            for (int i = 46; i < 49; i++) {
	    	                pieces[i] = new ImmovablePiece(0,FireRed,(200+i),"./src/Resources/images/RedPieces/trapR.png");
	    	            }
	    	            //the other 2 Rscouts
	    	            for (int i = 49; i < 51; i++) {
	    	            	pieces[i] = new MovablePiece(2,FireRed,(200+i),"./src/Resources/images/RedPieces/scoutR.png");
	    	            }
	    	            //the other 3 Rdwarves
	    	            for (int i = 51; i < 54; i++) {
	    	            	 pieces[i] = new MovablePiece(3,FireRed,(200+i),"./src/Resources/images/RedPieces/dwarfR.png");
	    	            }
	    	            // the other Relf
	    	            pieces[54] = new MovablePiece(4,FireRed,224,"./src/Resources/images/RedPieces/elfR.png");
	    	            // the other LavaBeast
	    	            pieces[55] = new MovablePiece(5,FireRed,225,"./src/Resources/images/RedPieces/lavaBeast.png");
	    	            //the other Rsorceress
	    	            pieces[56] = new MovablePiece(6,FireRed,226,"./src/Resources/images/RedPieces/sorceressR.png");
	    	            // the other RBeastRider
	    	            for(int i = 57; i < 59; i++) {
	    	            pieces[i] = new MovablePiece(7,FireRed,(200+i),"./src/Resources/images/RedPieces/beastRiderR.png");
	    	            //the other Rknight
	    	            pieces[59] = new MovablePiece(8,FireRed,229,"./src/Resources/images/RedPieces/knightR.png");
	    	            }
	    	        
	    	            putImages(pieces);
	    	    }
	    
	    public void putImages(Piece[] p) throws IOException {	
	    	String currentPath = new java.io.File(".").getCanonicalPath();
            System.out.println("Current dir:" + currentPath);
	    	for(int i = 0; i < p.length; i++) {	    	
	    		System.out.println(p[i].getImagename());
	    		Icon eikona = new ImageIcon(p[i].getImagename());
	    		p[i].setIcon(eikona);
	    		 
	    		}   	
	    }	
	    
	    /** 
	     * In this method p1 attacks p2 
	     * @param Piece p1
	     * @param Piece p2
	     * */
	    public void attack(Piece p1, Piece p2) {
	    		//////////// attacking Immovables
	    	if (p2 instanceof ImmovablePiece && (p2.getSpecialID() % 100) == 0) {
	    		if(p1.getColor() == Controller.FireRed) {
	    			JOptionPane.showMessageDialog(null, "Volcandria's Victory!", "Game ended!", JOptionPane.INFORMATION_MESSAGE);
	    			
	    		}else if(p1.getColor() == Controller.IceBlue) {
	    			JOptionPane.showMessageDialog(null, "Everwinter's Victory!", "Game ended!", JOptionPane.INFORMATION_MESSAGE);
	    			
	    		}
	    		if(p1.getColor() == Controller.FireRed) P = P1;
	    		else if (p1.getColor() == Controller.IceBlue) P = P2;
	    }	else if(p2 instanceof ImmovablePiece && p2.getSpecialID() % 100 != 0) { 
	    	   if(p1.getGrade() != 3) {
	   	    	board.addCaptures(p1);
	   	    	P.setTotalAttacks();
	    		P.setWin_Percentage();
	   	    	
	   	    	}else if(p1.getGrade() == 3) {
	   	    		board.addCaptures(p2);
	   	    		P.setTotalAttacks();
		    		P.setWin_Percentage();	 
	   	    		movePiece(p1,p2);
	   	    	}
	   	    		
	    	   }
	       		/////////////	
	    		
	    if(p2 instanceof MovablePiece) {
	    	if (p1.getGrade() < p2.getGrade() && p1.getGrade() != 1) {
	    		board.addCaptures(p1);
	    		P.setTotalAttacks();
	    		P.setWin_Percentage();	    		
	    	}
	    	else if(p1.getGrade() == p2.getGrade()) {
	    		board.addCaptures(p1);
	    		board.addCaptures(p2);
	    		P.setTotalAttacks();
	    		P.setWin_Percentage();	 
	    	}
	    	else if(p1.getGrade() > p2.getGrade()) {
	    		board.addCaptures(p2);
	    		P.setTotalAttacks();
	    		P.setWin_Percentage();	 
	    		movePiece(p1,p2);
	    		
	    	}else if(p1.getGrade() == 1) {
	    		if(p2.getGrade() == 10) {
	    		board.addCaptures(p2);
	    		P.setTotalAttacks();
	    		P.setWin_Percentage();	 
	    		
	    		movePiece(p1,p2);
	    		}
	    		else if(p2.getGrade() != 10 ) {
	    		board.addCaptures(p1);
	    		P.setTotalAttacks();
	    		P.setWin_Percentage();	 
	    		}
	    	}
	     }
	    if(p1.getColor() == Controller.FireRed) P1 = P;
		else if (p1.getColor() == Controller.IceBlue) P2 = P;
	 }
	    
	    //need to fix the input of the pieces to the buttons
	    public void init_Buttons()
	    {
	    	
	    	Graphics.ReducedArmyButton.addActionListener(this);
	        Graphics.NoRetreatButton.addActionListener(this);
	        
	      RandomizePieces.RandomizePieceArray(this.pieces, board.getReducedArmy());
	        	int index = 0;
	        for(int i = 0; i < 8; i++) {
	        	for(int j = 0; j < 10; j++) {
	        		if(i<3)index = (10*i) + j;
	        		else if (i > 4) index = (10* i) + j - 20;
	        		System.out.println(index);
	        		Buttons[i][j] = pieces[index];
	        		
	        	}
	        	if(i == 2) i = i+ 2; 
	        }
	        for(int i = 3; i < 5; i++) {
	        	for(int j = 0; j < 10; j++) {
	        	Buttons[i][j] = new MovablePiece(0, Color.white, 0,"");
	        		
	        	if(i == 3 && j == 2 || i == 3 && j ==3 || i == 4 && j == 2 || i == 4 && j ==3 ||
                       i == 3 && j == 6 || i == 4 && j ==6 || i == 3 && j == 7 || i == 4 && j ==7){

                    Buttons[i][j].setBackground(Color.blue);
                    Buttons[i][j].setEnabled(false);
                    Buttons[i][j].setBorderPainted(false);
                    Buttons[i][j].setColor(Color.blue);

                }else {
                    Buttons[i][j].setBackground(Color.white);
                    Buttons[i][j].setBorder(new LineBorder(Color.lightGray,1) );
                    Buttons[i][j].addActionListener(this);
                    Buttons[i][j].setBorder(new LineBorder(null));
                    setButtonnotSelected(Buttons[i][j]); 
                }
	        	}
	        }
	    }
	    
	    
	    public void putButtonsinPanel() 
	    {
	    	
	            for (int i = 0; i < 8; i++) {
	                for (int j = 0; j < 10; j++) {

	                    this.tablo.background.add(Buttons[i][j]);

	                }
	            }
	        }
	    
	    //This method suppose to move pieces to empty available squares
	    public void movePiece(Piece p1, Piece p2) 
	    {
	    	p1.setColor(p2.getColor());
	        p1.setImage(p2.getImage());
	        p1.setGrade(p2.getGrade());
	        p1.setIcon(p2.getImage());
	        p1.setHasRescued(p2.getHasRescued());
	        p1.setisPieceonBoard(p2.isPieceonBoard());

	        pieceRemove(p2);

	        EndofTurn();

	    }
	    
	    public void pieceRemove(Piece p)
	    {
	    	p.setGrade(0);
	    	p.setColor(Color.white);
	    	p.setImage(new ImageIcon(""));
	    	p.setIcon(null);
	    	
	    	removeBorder();
	    }
	    
	    public void EndofTurn() 
	    {
	    	board.setRedsturn(Board.redsturn);
	    	board.setRound();
	    	
	    	if(board.getRedsturn())
	    	{
	    		PlayersTurn(P2);
	    		recoverImages(Buttons,Controller.FireRed);
	    	}
	    	else
	    	{
	    		PlayersTurn(P1);
	    		recoverImages(Buttons,Controller.IceBlue);
	    	}
	    	setChangeofTurn();
	    }
	    
	    public void setButtonSelected(Piece p) {
	    	if(p.getColor() != Color.white)
	    		p.getModel().setSelected(true);
	    }
	    
	    public void setButtonnotSelected(Piece p) {
	    	if(p.getColor() != Color.white)
	    		p.getModel().setSelected(false);
	    }

	    public void PlayersTurn(Player p) {
	    	Graphics.PlayerTurnLabel.setText(p.getName() + " Turn");
	        Graphics.WinPercentageLabel.setText("Successful attacks: " + p.getWin_Percentage() + " %");
	        Graphics.RescuesLabel.setText("Total Rescues: " + p.getRescues() + " / 2 ");
	        Graphics.RoundsLabel.setText("Round : " + board.getRound());
	        if(p == P1)
	        Graphics.CapturesLabel.setText("Total Captures: "  + board.getRCaptured());
	        else if(p == P2)
	        Graphics.CapturesLabel.setText("Total Captures: "  + board.getBCaptured());
	    }
	    
	    
	    public void recoverImages(Piece[][] grid, Color color){
	        for (int i = 0; i < 8; i++) {
	            for (int j = 0; j < 10; j++) {
	                if (grid[i][j].getColor() != Color.white && color == grid[i][j].getColor()) {
	                    grid[i][j].setIcon(grid[i][j].getImage());
	                }
	            }

	        }
	    }
	    public void setChangeofTurn()
	    {
	    	if(board.getRedsturn())
	    	{
	    		PlayersTurn(P2);
	    		
	    		for(int i = 0; i < 8; i++) {
	    			for(int j = 0; j < 10; j++) {
	    				if(Buttons[i][j].getColor() == Controller.IceBlue)
	    					Buttons[i][j].setIcon(new ImageIcon("./src/Resources/images/bluePieces/blueHidden.png"));	
	    			}
	    		}
	    	}else {
	    		PlayersTurn(P1);
	    		
	    		for(int i = 0; i < 8; i++) {
	    			for(int j = 0; j < 10 ; j++) {
	    				if(Buttons[i][j].getColor() == Controller.FireRed)
	    					Buttons[i][j].setIcon(new ImageIcon("./src/Resources/images/RedPieces/redHidden.png"));
	    			}
	    		}
	    	}
	    }

	    void RescueGui(Player p){
	        JFrame frame = new JFrame("Save");
	        JPanel panel = new JPanel();

	        panel.setBounds(0,0,400,400);
	        panel.setLayout(new GridLayout());
	        System.out.println(p.getEnemyCapts());
	        for (int k = 0; k < 30; k++) {
	            if (p.getCaptures(k).getImagename() != ""){
	                p.getCaptures(k).addActionListener(this);
	                p.getCaptures(k).setIcon(p.getCaptures(k).getImage());
	                System.out.println(p.getCaptures(k).getGrade());
	                panel.add(p.getCaptures(k));
	            }
	        }

	        frame.add(panel);

	        frame.setBounds(400,200,500,500);
	        frame.setLayout(null);
	        frame.setVisible(true);

	    }
	    
	    public void setBorders(Piece p, Color color) {
	    	if ( p.isEnabled() && (p.getColor() == Color.white || p.getColor() != color) && color != Color.white &&
	    	           ((color == Controller.IceBlue && board.getRedsturn()) || (color == Controller.FireRed && !board.getRedsturn())) ){

	    	                p.setBorder(new LineBorder(Color.yellow,3) );
	    	                p.setAvailable_square(true);

	    	        }
	    }
	    
	    public void removeBorder(){
	        for (int i = 0; i < 8; i++) {
	            for (int j = 0; j < 10; j++) {
	                Buttons[i][j].setBorder(new LineBorder(null));
	                Buttons[i][j].setAvailable_square(false);
	            }
	        }
	    }
	    
		@Override
		public void actionPerformed(ActionEvent action) {

			for (int i = 0; i < 8; i++) {
	            for (int j = 0; j < 10; j++) {
	                if (action.getSource() == Buttons[i][j]){
	                    //if we click on the bordered button here we check if we want to move or we want to attack
	                    if (Buttons[i][j].getAvailable_square() && selected != null) {
	                        if (selected.getColor() != Buttons[i][j].getColor() && Buttons[i][j].getColor() != Color.white) {
	                            attack(Buttons[i][j], selected);
	                            removeBorder();
	                        } else {
	                            movePiece(Buttons[i][j], selected);
	                        }
	                        setButtonnotSelected(selected);
	                        removeBorder();
	                    }
	                    if ((Buttons[i][j] instanceof MovablePiece)) {
	                        //By the first click of the button we select the button to manage the borders properly in order to move or attack
	                        if (!Buttons[i][j].getModel().isSelected() && !Buttons[i][j].getAvailable_square()) {
	                            removeBorder();
	                            selected = Buttons[i][j];

	                            //if it is a scout
	                            if (Buttons[i][j].getGrade() == 2) {
	                                try {
	                                    int n = 1;

	                                    if (i < 7) {
	                                        while (Buttons[i + n][j].getColor() == Color.white) {
	                                            setBorders(Buttons[i + n][j], Buttons[i][j].getColor());
	                                            n++;
	                                        }
	                                        if (Buttons[i + (n - 1)][j].isEnabled())
	                                            setBorders(Buttons[i + n][j], Buttons[i][j].getColor());
	                                    }
	                                    if (j > 0) {
	                                        n = 1;

	                                        while (Buttons[i][j - n].getColor() == Color.white) {
	                                            setBorders(Buttons[i][j - n], Buttons[i][j].getColor());
	                                            n++;
	                                        }
	                                        if (Buttons[i][j - (n - 1)].isEnabled())
	                                            setBorders(Buttons[i][j - n], Buttons[i][j].getColor());
	                                    }
	                                    if (j < 9) {
	                                        n = 1;

	                                        while (Buttons[i][j + n].getColor() == Color.white) {
	                                            setBorders(Buttons[i][j + n], Buttons[i][j].getColor());
	                                            n++;
	                                        }
	                                        if (Buttons[i][j + (n - 1)].isEnabled())
	                                            setBorders(Buttons[i][j + n], Buttons[i][j].getColor());
	                                    }
	                                    if (i > 0) {
	                                        n = 1;

	                                        while (Buttons[i - n][j].getColor() == Color.white) {
	                                            setBorders(Buttons[i - n][j], Buttons[i][j].getColor());
	                                            n++;
	                                        }
	                                        if (Buttons[i - (n - 1)][j].isEnabled())
	                                            setBorders(Buttons[i - n][j], Buttons[i][j].getColor());
	                                    }
	                                } catch (Exception d) {
	                                    System.out.println("Corner Piece!");
	                                }

	                            } else {
	                                //if it is not a scout
	                                // check if the button isn't on any corner
	                                if (i < 7) setBorders(Buttons[i + 1][j], Buttons[i][j].getColor());
	                                if (j > 0) setBorders(Buttons[i][j - 1], Buttons[i][j].getColor());
	                                if (j < 9) setBorders(Buttons[i][j + 1], Buttons[i][j].getColor());
	                                if (i > 0) setBorders(Buttons[i - 1][j], Buttons[i][j].getColor());
	                            }

	                            //make button selected
	                            setButtonSelected(Buttons[i][j]);

	                        } else {

	                            removeBorder();

	                            //make button not selected
	                            setButtonnotSelected(Buttons[i][j]);

	                        }
	                    }

	                }



	                // Rescues
	                if (Buttons[i][j].getColor() == Controller.IceBlue && i == 7 && !Buttons[i][j].getHasRescued()){

	                    ///////

	                    RescueGui(P2);

	                    ///////

	                    Buttons[i][j].setHasRescued(true);
	                }

	                if (Buttons[i][j].getColor() == Controller.FireRed && i == 0 && !Buttons[i][j].getHasRescued()){

	                    ///////

	                    RescueGui(P1);

	                    ///////

	                    Buttons[i][j].setHasRescued(true);
	                }

	            }
	        }
			
		}
}