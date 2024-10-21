package dicetester;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import dicetester.Dice;

/**
 *
 * @author 507606
 */
public class YatzheeJFrame extends javax.swing.JFrame {

    /**
     * Creates new form YatzheeJFrame
     */
    
    //game state constants
    public final static int RESET_GAME = 1;
    public final static int BEFORE_1ST_ROLL = 2;
    public final static int BEFORE_2ND_ROLL = 3;
    public final static int BEFORE_3RD_ROLL = 4;
    public final static int AFTER_3RD_ROLL = 5;
    public final static int SCORING = 6;
    public final static int GAME_OVER = 7;
    
    // lower score category constants 
    public final static int THREE_OF_A_KIND = 0;
    public final static int FOUR_OF_A_KIND = 1;
    public final static int FULL_HOUSE = 2;
    public final static int SMALL_STRAIGHT = 3;
    public final static int LARGE_STRAIGHT = 4;
    public final static int YATZHEE = 5;
    public final static int CHANCE = 6;
    
    
    //dice state constants
    public static final int NUM_DICE = 5;
    public static final int NUM_SIDES = 6;
    

            
    public YatzheeJFrame() 
    {
        initComponents();
        
        
        myDice = new Dice (NUM_DICE,NUM_SIDES);
        
        
        //create buttons array.
        //create array of dice that you want to hold.
        holdButtonArray = new JToggleButton[NUM_DICE];
        
        holdButtonArray[0] = holdButtonOne;
        holdButtonArray[1] = holdButtonTwo;
        holdButtonArray[2] = holdButtonThree;
        holdButtonArray[3] = holdButtonFour;
        holdButtonArray[4] = holdButtonFive;  
        
        upperScoreButtonArray = new 
                JToggleButton[GameModel.NUM_UPPER_SCORE_CATS +1];
        
        upperScoreButtonArray[1]=this.acesButton;
        upperScoreButtonArray[2]=this.twosButton;
        upperScoreButtonArray[3]=this.threesButton;
        upperScoreButtonArray[4]=this.foursButton;
        upperScoreButtonArray[5]=this.fivesButton;
        upperScoreButtonArray[6]=this.sixesButton;
        
        
        upperScoreTextBoxArray = new 
                JTextField[GameModel.NUM_UPPER_SCORE_CATS +1];
        
        
        upperScoreTextBoxArray[1] = this.acesField;
        upperScoreTextBoxArray[2] = this.twosField;
        upperScoreTextBoxArray[3] = this.threesField;
        upperScoreTextBoxArray[4] = this.foursField;
        upperScoreTextBoxArray[5] = this.fivesField;
        upperScoreTextBoxArray[6] = this.sixesField;
        
        
        
        lowerScoreButtonArray = new 
                JToggleButton[GameModel.NUM_LOWER_SCORE_CATS];
        
        lowerScoreButtonArray[THREE_OF_A_KIND] = this.threeOfAKindButton;
        lowerScoreButtonArray[FOUR_OF_A_KIND] = this.fourOfAKindButton;
        lowerScoreButtonArray[FULL_HOUSE] = this.fullHouseButton;
        lowerScoreButtonArray[SMALL_STRAIGHT] = this.smallstr8Button;
        lowerScoreButtonArray[LARGE_STRAIGHT] = this.largeStr8Button;
        lowerScoreButtonArray[YATZHEE] = this.yahtzeeButton;
        lowerScoreButtonArray[CHANCE] = this.chanceButton;
         
        lowerScoreTextBoxArray = new 
                JTextField[GameModel.NUM_LOWER_SCORE_CATS];
        
         
        lowerScoreTextBoxArray[THREE_OF_A_KIND] = this.threeKindField;
        lowerScoreTextBoxArray[FOUR_OF_A_KIND] = this.fourKindField;
        lowerScoreTextBoxArray[FULL_HOUSE] = this.fullHouseField;
        lowerScoreTextBoxArray[SMALL_STRAIGHT] = this.smallStr8Field;
        lowerScoreTextBoxArray[LARGE_STRAIGHT] = this.largeStr8Field;
        lowerScoreTextBoxArray[YATZHEE] = this.yahtzeeField;
        lowerScoreTextBoxArray[CHANCE] = this.chanceField;
        
  
        holdArray = new boolean[NUM_DICE];
        
        game = new GameModel();
        manageUIState(RESET_GAME);
        manageUIState(BEFORE_1ST_ROLL);
  
      
    }
    
    public void manageUIState(int nextState)
    {
        switch (nextState)
        {
            case RESET_GAME:
              //  game.clearAllUpperScoringCats();
               // game.clearAllLowerScoringCats();
                break; 
            case BEFORE_1ST_ROLL:
                clearAndDisableHoldButtons();
               //disable hold buttons, then enable roll button, and clear the hold array. 
               rollButton.setEnabled(true);
               clearAndDisableHoldButtons();
               clearHoldArray();     
               disableAllScoreButtons();
                break;
            case BEFORE_2ND_ROLL:
                //now we can enable the hold buttons. 
               enableHoldButtons();
               enableAllUnusedScoreButtons();
                break;
            case BEFORE_3RD_ROLL:
                
                break;
            case AFTER_3RD_ROLL:
                // we need to disable the roll button here. 
                rollButton.setEnabled(false);
                break;
            case SCORING:
               disableAllScoreButtons();
               game.nextTurn();
               break;
            case GAME_OVER:
                break;   
            default:
                JOptionPane.showMessageDialog(this, "Uh Oh! Invalid UI state detected.");
                break;
        }
        currentUIState = nextState;  
    }
    
    private void clearAndDisableHoldButtons()
    {
        for (int i = 0; i < NUM_DICE; i++)
        {
            holdButtonArray[i].setText("");
            holdButtonArray[i].setEnabled(false);
            holdButtonArray[i].setSelected(false);
        }    
    }
    
    
    private void showTotalsAndAdvanceTurn()
            {
                //this.showTotals();
                if (game.getCurrentTurnNum() <= GameModel.MAX_NUM_TURN )
                {
                    manageUIState(BEFORE_1ST_ROLL);
                }
                else
                {
                    manageUIState(GAME_OVER);
                }
                
            }
    
    private void clearHoldArray()
    {
        for (int i = 0; i < NUM_DICE; i++)
        {
            holdArray[i] = false;
        }
    }
   
    
    private void enableAllUnusedScoreButtons()
    {
        for (int i = 1; i <= GameModel.NUM_UPPER_SCORE_CATS; i++)
        {
            if (!game.getUsedUpperScoringCatState(i))
            {
                this.upperScoreButtonArray[i].setEnabled(true);
            }
        }    
        for (int i = 0; i < GameModel.NUM_LOWER_SCORE_CATS; i++)
        {
            if (!game.getUsedLowerScoringCatState(i))
            {
                this.lowerScoreButtonArray[i].setEnabled(true);
            }
            
        }
    }
  
    
   
    private void enableHoldButtons()
    {
        for (int i = 0; i < NUM_DICE; i++)
        {
            holdButtonArray[i].setEnabled(true);
        }
    }
    
    private void disableAllScoreButtons()
    {
        for (int i = 1; i <= GameModel.NUM_UPPER_SCORE_CATS; i++)
        {
            this.upperScoreButtonArray[i].setEnabled(false);
        }
         for (int i = 0; i < GameModel.NUM_LOWER_SCORE_CATS; i++)
        {
            this.lowerScoreButtonArray[i].setEnabled(false);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        holdButtonOne = new javax.swing.JToggleButton();
        rollButton = new javax.swing.JButton();
        holdButtonFive = new javax.swing.JToggleButton();
        holdButtonThree = new javax.swing.JToggleButton();
        holdButtonFour = new javax.swing.JToggleButton();
        holdButtonTwo = new javax.swing.JToggleButton();
        acesButton = new javax.swing.JToggleButton();
        twosButton = new javax.swing.JToggleButton();
        foursButton = new javax.swing.JToggleButton();
        threesButton = new javax.swing.JToggleButton();
        fivesButton = new javax.swing.JToggleButton();
        sixesButton = new javax.swing.JToggleButton();
        threeOfAKindButton = new javax.swing.JToggleButton();
        fullHouseButton = new javax.swing.JToggleButton();
        smallstr8Button = new javax.swing.JToggleButton();
        largeStr8Button = new javax.swing.JToggleButton();
        fourOfAKindButton = new javax.swing.JToggleButton();
        chanceButton = new javax.swing.JToggleButton();
        yahtzeeButton = new javax.swing.JToggleButton();
        acesField = new javax.swing.JTextField();
        threesField = new javax.swing.JTextField();
        foursField = new javax.swing.JTextField();
        fivesField = new javax.swing.JTextField();
        twosField = new javax.swing.JTextField();
        sixesField = new javax.swing.JTextField();
        threeKindField = new javax.swing.JTextField();
        fourKindField = new javax.swing.JTextField();
        fullHouseField = new javax.swing.JTextField();
        smallStr8Field = new javax.swing.JTextField();
        largeStr8Field = new javax.swing.JTextField();
        yahtzeeField = new javax.swing.JTextField();
        chanceField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        upperScoreField = new javax.swing.JTextField();
        bonusField = new javax.swing.JTextField();
        bonusLabel = new javax.swing.JLabel();
        upperScoreLabel = new javax.swing.JLabel();
        grandTotalField = new javax.swing.JTextField();
        totalLowerScoreField = new javax.swing.JTextField();
        totalLowerScoreLabel = new javax.swing.JLabel();
        grandTotalLabel = new javax.swing.JLabel();
        totalUpperScoreField = new javax.swing.JTextField();
        totalUpperScoreLabel = new javax.swing.JLabel();
        newGameButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Elijah's Yatzhee ");
        setAutoRequestFocus(false);
        setBackground(new java.awt.Color(0, 0, 0));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFocusableWindowState(false);
        setFont(new java.awt.Font("Arial Black", 1, 10)); // NOI18N
        setForeground(java.awt.Color.darkGray);
        setResizable(false);
        setSize(new java.awt.Dimension(300, 100));

        holdButtonOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                holdButtonOneActionPerformed(evt);
            }
        });

        rollButton.setText("Roll ");
        rollButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollButtonActionPerformed(evt);
            }
        });

        holdButtonFive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                holdButtonFiveActionPerformed(evt);
            }
        });

        holdButtonThree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                holdButtonThreeActionPerformed(evt);
            }
        });

        holdButtonFour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                holdButtonFourActionPerformed(evt);
            }
        });

        holdButtonTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                holdButtonTwoActionPerformed(evt);
            }
        });

        acesButton.setText("Aces");
        acesButton.setPreferredSize(new java.awt.Dimension(120, 40));

        twosButton.setText("Twos");

        foursButton.setText("Fours");
        foursButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                foursButtonActionPerformed(evt);
            }
        });

        threesButton.setText("Threes");

        fivesButton.setText("Fives");

        sixesButton.setText("Sixes");

        threeOfAKindButton.setText("3 of a Kind");
        threeOfAKindButton.setPreferredSize(new java.awt.Dimension(120, 40));
        threeOfAKindButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                threeOfAKindButtonActionPerformed(evt);
            }
        });

        fullHouseButton.setText("Full House");
        fullHouseButton.setPreferredSize(new java.awt.Dimension(115, 40));

        smallstr8Button.setText("Small Straight");
        smallstr8Button.setPreferredSize(new java.awt.Dimension(115, 40));

        largeStr8Button.setText("Large Straight");
        largeStr8Button.setPreferredSize(new java.awt.Dimension(115, 40));

        fourOfAKindButton.setText("4 of a Kind");
        fourOfAKindButton.setPreferredSize(new java.awt.Dimension(115, 40));
        fourOfAKindButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fourOfAKindButtonActionPerformed(evt);
            }
        });

        chanceButton.setText("Chance");
        chanceButton.setPreferredSize(new java.awt.Dimension(115, 40));
        chanceButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chanceButtonActionPerformed(evt);
            }
        });

        yahtzeeButton.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        yahtzeeButton.setText("Yahtzee!");
        yahtzeeButton.setPreferredSize(new java.awt.Dimension(115, 40));
        yahtzeeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yahtzeeButtonActionPerformed(evt);
            }
        });

        fivesField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fivesFieldActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Verdana", 3, 36)); // NOI18N
        jLabel1.setText("Yatzeee!");

        bonusLabel.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        bonusLabel.setText("Bonus if >63:");

        upperScoreLabel.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        upperScoreLabel.setText("Upper Score:");

        totalLowerScoreLabel.setFont(new java.awt.Font("Segoe UI", 2, 12)); // NOI18N
        totalLowerScoreLabel.setText("Total Lower Score:");

        grandTotalLabel.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        grandTotalLabel.setText("Grand Total:");

        totalUpperScoreLabel.setFont(new java.awt.Font("Segoe UI", 3, 12)); // NOI18N
        totalUpperScoreLabel.setText("Total Upper Score:");

        newGameButton.setText("Play Again?");
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(bonusLabel)
                            .addComponent(upperScoreLabel)
                            .addComponent(totalUpperScoreLabel))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(newGameButton)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(holdButtonOne, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(holdButtonTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(holdButtonThree, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(holdButtonFour, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(holdButtonFive, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(acesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(twosButton)
                                                    .addComponent(threesButton))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(acesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(twosField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(threesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(foursButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(foursField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(fivesButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(fivesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(sixesButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(sixesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(upperScoreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(bonusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(totalUpperScoreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(43, 43, 43)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(fourOfAKindButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(fourKindField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(threeOfAKindButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(threeKindField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(fullHouseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(fullHouseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(smallstr8Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(smallStr8Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(largeStr8Button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(18, 18, 18)
                                                .addComponent(largeStr8Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(yahtzeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(yahtzeeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(totalLowerScoreLabel)
                                                    .addComponent(chanceButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(grandTotalLabel))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(grandTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(totalLowerScoreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addComponent(chanceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(138, 138, 138)
                                        .addComponent(jLabel1)))))
                        .addGap(0, 17, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {acesButton, fivesButton, foursButton, sixesButton, threesButton, twosButton});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {chanceButton, fourOfAKindButton, fullHouseButton, largeStr8Button, smallstr8Button, threeOfAKindButton});

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {holdButtonFive, holdButtonFour, holdButtonOne, holdButtonThree, holdButtonTwo, rollButton});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(holdButtonOne, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(holdButtonFive, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(holdButtonTwo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(holdButtonThree, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(holdButtonFour, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(acesButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeOfAKindButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threeKindField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(twosButton)
                    .addComponent(fourOfAKindButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(twosField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fourKindField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(threesButton)
                    .addComponent(fullHouseButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(threesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fullHouseField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(foursButton)
                    .addComponent(smallstr8Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(foursField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(smallStr8Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fivesButton)
                    .addComponent(largeStr8Button, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fivesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(largeStr8Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sixesButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(yahtzeeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sixesField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yahtzeeField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(chanceButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chanceField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(upperScoreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(upperScoreLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bonusField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(bonusLabel)
                    .addComponent(totalLowerScoreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalLowerScoreLabel))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(totalUpperScoreLabel)
                        .addComponent(totalUpperScoreField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(grandTotalField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(grandTotalLabel)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addComponent(newGameButton)
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {acesButton, fivesButton, foursButton, sixesButton, threesButton, twosButton});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {chanceButton, fourOfAKindButton, fullHouseButton, largeStr8Button, smallstr8Button, threeOfAKindButton});

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {holdButtonFive, holdButtonFour, holdButtonOne, holdButtonThree, holdButtonTwo});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rollButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollButtonActionPerformed

        int rollValue = 0; 
        
        for (int i = 0; i < NUM_DICE; i++)
        {
            //if user isnt holding die, roll.
            if (!holdArray[i])
            {
                rollValue = myDice.rollDie(i);
                holdButtonArray[i].setText("" + rollValue);
            }
        }   
        
       switch(currentUIState)
   {
       case BEFORE_1ST_ROLL:
       
         manageUIState(BEFORE_2ND_ROLL);
         break;   
         
       case BEFORE_2ND_ROLL:
       
           manageUIState(BEFORE_3RD_ROLL);
           break;
       
       case BEFORE_3RD_ROLL:
       
           manageUIState(AFTER_3RD_ROLL);
           break;
       
    }//GEN-LAST:event_rollButtonActionPerformed
    }
       
       
    private void holdButtonTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_holdButtonTwoActionPerformed
        // TODO add your handling code here:
        holdArray[1] = !holdArray[1];
    }//GEN-LAST:event_holdButtonTwoActionPerformed

    private void holdButtonThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_holdButtonThreeActionPerformed
        // TODO add your handling code here:
        holdArray[2] = !holdArray[2];
    }//GEN-LAST:event_holdButtonThreeActionPerformed

    private void holdButtonFourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_holdButtonFourActionPerformed
        // TODO add your handling code here:
        holdArray[3] = !holdArray[3];
    }//GEN-LAST:event_holdButtonFourActionPerformed

    private void holdButtonFiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_holdButtonFiveActionPerformed
        // TODO add your handling code here:
        holdArray[4] = !holdArray[4];
    }//GEN-LAST:event_holdButtonFiveActionPerformed

    private void foursButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_foursButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_foursButtonActionPerformed

    private void chanceButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chanceButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_chanceButtonActionPerformed

    private void fivesFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fivesFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fivesFieldActionPerformed

    private void yahtzeeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yahtzeeButtonActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_yahtzeeButtonActionPerformed

    private void threeOfAKindButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_threeOfAKindButtonActionPerformed
        // TODO add your handling code here:
        int score = 0; 
        
        game.setUsedLowerScoreCat(THREE_OF_A_KIND, true);
        manageUIState(SCORING);
        
        if (game.is3ofAKind(myDice))
        {
            score = game.addEmUp(myDice);
        }
        game.setLowerScoreCat(THREE_OF_A_KIND, score);
        //redisplay
        this.lowerScoreTextBoxArray[THREE_OF_A_KIND].setText( Integer.toString(score));
        
        showTotalsAndAdvanceTurn();
        
        
    }//GEN-LAST:event_threeOfAKindButtonActionPerformed

 
    private void holdButtonOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_holdButtonOneActionPerformed
        // TODO add your handling code here:
        holdArray[0] = !holdArray[0];
    }//GEN-LAST:event_holdButtonOneActionPerformed

    private void fourOfAKindButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fourOfAKindButtonActionPerformed
        // TODO add your handling code here:
        
        int score = 0;
        
        game.setUsedLowerScoreCat(FOUR_OF_A_KIND, true);
        manageUIState(SCORING);
        
        if (game.is4ofAKind(myDice))
        {
            score = game.addEmUp(myDice);
        }
        
        game.setLowerScoreCat(FOUR_OF_A_KIND, score);
        this.lowerScoreTextBoxArray[FOUR_OF_A_KIND].setText( Integer.toString(score));
        
        showTotalsAndAdvanceTurn();
            
    }//GEN-LAST:event_fourOfAKindButtonActionPerformed

    private void newGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameButtonActionPerformed
        // TODO add your handling code here:
         manageUIState(RESET_GAME);
         manageUIState(BEFORE_1ST_ROLL);
    }//GEN-LAST:event_newGameButtonActionPerformed

  /*  
    public void showTotals()
    {
        game.updateTotals();
        bonusField.setText(""+game.getBonus());
        upperScoreField.setText("" + game.getSumUpperScores());
        totalLowerScoreField.setText("" + game.getSumLowerScores());
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(YatzheeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(YatzheeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(YatzheeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(YatzheeJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new YatzheeJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton acesButton;
    private javax.swing.JTextField acesField;
    private javax.swing.JTextField bonusField;
    private javax.swing.JLabel bonusLabel;
    private javax.swing.JToggleButton chanceButton;
    private javax.swing.JTextField chanceField;
    private javax.swing.JToggleButton fivesButton;
    private javax.swing.JTextField fivesField;
    private javax.swing.JTextField fourKindField;
    private javax.swing.JToggleButton fourOfAKindButton;
    private javax.swing.JToggleButton foursButton;
    private javax.swing.JTextField foursField;
    private javax.swing.JToggleButton fullHouseButton;
    private javax.swing.JTextField fullHouseField;
    private javax.swing.JTextField grandTotalField;
    private javax.swing.JLabel grandTotalLabel;
    private javax.swing.JToggleButton holdButtonFive;
    private javax.swing.JToggleButton holdButtonFour;
    private javax.swing.JToggleButton holdButtonOne;
    private javax.swing.JToggleButton holdButtonThree;
    private javax.swing.JToggleButton holdButtonTwo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JToggleButton largeStr8Button;
    private javax.swing.JTextField largeStr8Field;
    private javax.swing.JButton newGameButton;
    private javax.swing.JButton rollButton;
    private javax.swing.JToggleButton sixesButton;
    private javax.swing.JTextField sixesField;
    private javax.swing.JTextField smallStr8Field;
    private javax.swing.JToggleButton smallstr8Button;
    private javax.swing.JTextField threeKindField;
    private javax.swing.JToggleButton threeOfAKindButton;
    private javax.swing.JToggleButton threesButton;
    private javax.swing.JTextField threesField;
    private javax.swing.JTextField totalLowerScoreField;
    private javax.swing.JLabel totalLowerScoreLabel;
    private javax.swing.JTextField totalUpperScoreField;
    private javax.swing.JLabel totalUpperScoreLabel;
    private javax.swing.JToggleButton twosButton;
    private javax.swing.JTextField twosField;
    private javax.swing.JTextField upperScoreField;
    private javax.swing.JLabel upperScoreLabel;
    private javax.swing.JToggleButton yahtzeeButton;
    private javax.swing.JTextField yahtzeeField;
    // End of variables declaration//GEN-END:variables
   
    
    private Dice myDice; 
    private JToggleButton[] holdButtonArray;
    private JToggleButton[] upperScoreButtonArray;
    private JToggleButton[] lowerScoreButtonArray;
    private JTextField[] upperScoreTextBoxArray;
    private JTextField[] lowerScoreTextBoxArray;
    private boolean holdArray[];
   // private int rollNum; // TMP VAR
    private int currentUIState;
    private GameModel game;

}

