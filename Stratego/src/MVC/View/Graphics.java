package MVC.View;

import javax.swing.*;

import MVC.Controller.Controller;

import java.awt.*;

/**
 * 
 * @version B
 * @author George Vasileiadis
 * */
@SuppressWarnings("serial")
public class Graphics extends JFrame {
	
	public static JCheckBox ReducedArmyButton;
	public static JCheckBox NoRetreatButton;
	private Image image;
	private JButton EndGame;
	private JCheckBox gamemode;
	
    public DIYFrame frame;
    public DIYBackgroundPanel background;
    Table menu;


    public JPanel rulesPanel, statisticPanel, capturesPanel;

    public static JLabel menuLabel1,menuLabel2,menuLabel3,PlayerTurnLabel,WinPercentageLabel,RescuesLabel,RoundsLabel,CapturesLabel,totalCapturesLabel;

    private boolean ReducedArmy = false;

    /**
     * The constructor of the class View, here we will make
     * the initializations that we need for the GUI of the project.
     */
    public Graphics(){

        frame = new DIYFrame();
        background = new DIYBackgroundPanel();
        menu = new Table();

        initializePanels();
        initializeLabels();

        initializeCheckBox();


        frame.add(background);
        frame.add(menu);

        frame.setVisible(true);
    }


    /**
     * this method will initialize the checkboxes
     */
    	public void initializeCheckBox(){
        ReducedArmyButton = new JCheckBox("Reduced Army!:");
        ReducedArmyButton.setFocusable(false);
        ReducedArmyButton.setBackground(null);
        ReducedArmyButton.setHorizontalTextPosition(SwingConstants.LEFT);
        ReducedArmyButton.setForeground(Color.lightGray);
        ReducedArmyButton.setFont(new java.awt.Font("Bradley Hand ITC", Font.BOLD, 14));
        rulesPanel.add(ReducedArmyButton);

        NoRetreatButton = new JCheckBox("NoRetreat!:");
        NoRetreatButton.setFocusable(false);
        NoRetreatButton.setBackground(null);
        NoRetreatButton.setHorizontalTextPosition(SwingConstants.LEFT);
        NoRetreatButton.setForeground(Color.lightGray);
        NoRetreatButton.setFont(new java.awt.Font("Bradley Hand ITC", Font.BOLD, 14));
        rulesPanel.add(NoRetreatButton);
    }



    /**
     * 
     */
    	public void initializePanels(){
        //rules
        rulesPanel = new JPanel();
        rulesPanel.setBounds(20,50,330,100);
        rulesPanel.setBackground(Color.darkGray);
        rulesPanel.setLayout(new GridLayout(2,1));
        menu.add(rulesPanel);
        
        

        //statistics
        statisticPanel = new JPanel();
        statisticPanel.setBounds(8,240,325,120);
        statisticPanel.setBackground(Color.darkGray);
        statisticPanel.setLayout(null);
        menu.add(statisticPanel);


        //captures
        capturesPanel = new JPanel();
        capturesPanel.setBounds(8,490,325,270);
        capturesPanel.setBackground(Color.darkGray);
        capturesPanel.setLayout(null);
        menu.add(capturesPanel);
    }

    /**
     * 
     */
 public void initializeLabels(){

        //label 1
        menuLabel1 = new JLabel("Special Game Modes",JLabel.CENTER);
        menuLabel1.setBounds(0,0,350,40);
        menuLabel1.setFont(new Font("Times New Roman", Font.BOLD, 22));
        menu.add(menuLabel1);

        //label 2
        menuLabel2 = new JLabel("Player's Statistics",JLabel.CENTER);
        menuLabel2.setBounds(0,200,350,40);
        menuLabel2.setFont(new Font("Times New Roman", Font.BOLD, 22));
        menuLabel2.setVerticalAlignment(JLabel.TOP);
        menu.add(menuLabel2);


        //label 3
        menuLabel3 = new JLabel("Enemy's Captured Pieces",JLabel.CENTER);
        menuLabel3.setBounds(0,450,350,40);
        menuLabel3.setFont(new Font("Times New Roman", Font.BOLD, 22));
        menuLabel3.setVerticalAlignment(JLabel.TOP);
        menu.add(menuLabel3);

        //playerTurn label
        PlayerTurnLabel = new JLabel("",JLabel.CENTER);
        PlayerTurnLabel.setBounds(80,10,200,40);
        PlayerTurnLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
        PlayerTurnLabel.setForeground(Color.magenta);
        statisticPanel.add(PlayerTurnLabel);

        //WinPercentage label
        WinPercentageLabel = new JLabel();
        WinPercentageLabel.setBounds(10,50,300,20);
        WinPercentageLabel.setFont(new Font("Verdana", Font.BOLD, 14));
        WinPercentageLabel.setForeground(Color.lightGray);
        statisticPanel.add(WinPercentageLabel);

        //Rescues Label
        RescuesLabel = new JLabel();
        RescuesLabel.setBounds(10,90,150,20);
        RescuesLabel.setFont(new Font("Century Schoolbook", Font.BOLD, 14));
        RescuesLabel.setForeground(Color.lightGray);
        statisticPanel.add(RescuesLabel);

        //rounds Label
        RoundsLabel = new JLabel();
        RoundsLabel.setBounds(220,90,100,20);
        RoundsLabel.setFont(new Font("Century Schoolbook", Font.BOLD, 14));
        RoundsLabel.setForeground(Color.lightGray);
        statisticPanel.add(RoundsLabel);

        //captures Label
        CapturesLabel = new JLabel();
        CapturesLabel.setLayout(new GridLayout(3,4));
        CapturesLabel.setBounds(5,10,400,230);
        capturesPanel.add(CapturesLabel);


        //totalCaptures Label
        totalCapturesLabel = new JLabel();
        totalCapturesLabel.setBounds(15,300,400,40);
        totalCapturesLabel.setFont(new Font("Century Schoolbook", Font.BOLD, 12));
        totalCapturesLabel.setForeground(Color.lightGray);
        capturesPanel.add(totalCapturesLabel);

    }


}
