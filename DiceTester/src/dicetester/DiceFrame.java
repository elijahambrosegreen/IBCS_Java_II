package dicetester;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JToggleButton;

/**
 *
 * @author 507606
 */
public class DiceFrame extends javax.swing.JFrame {

    /**
     * Creates new form DiceFrame
     */
    
    //game state constants
    public final static int RESET_GAME = 0;
    public final static int BEFORE_1ST_ROLL = 1;
    public final static int BEFORE_2ND_ROLL = 2;
    public final static int BEFORE_3RD_ROLL = 3;
    public final static int AFTER_3RD_ROLL = 4;
    public final static int SCORING = 5;
    public final static int GAME_OVER = 6;
    
    //dice state constants
    public static final int NUM_DICE = 5;
    public static final int NUM_SIDES = 6;
    
            
    public DiceFrame() 
    {
        initComponents();
        
        //create buttons array.
        //create array of dice that you want to hold.
        holdButtons = new JToggleButton[NUM_DICE];
        holdArray = new boolean[NUM_DICE];
        holdButtons[0] = dieOne;
        holdButtons[1] = dieTwo;
        holdButtons[2] = dieThree;
        holdButtons[3] = dieFour;
        holdButtons[4] = dieFive;    
        myDice = new Dice (NUM_DICE,NUM_SIDES);
        
        numRolls = 0;
        
    }
    
    public void manageUIState(int nextState)
    {
        switch (nextState)
        {
            case RESET_GAME:
                //todo
                break; 
            case BEFORE_1ST_ROLL:
                //disable hold buttons, then enable roll button, and clear the hold array.
                
               clearAndDisableHoldButtons();
               
               rollButton.setEnabled(true);
               
               clearHoldArray();
               
                break;
            case BEFORE_2ND_ROLL:
                //now we can enable the hold button. 
                
                enableHoldButtons();
                
                break;
            case BEFORE_3RD_ROLL:
                break;
            case AFTER_3RD_ROLL:
                // we need to disable the roll button here. 
                rollButton.setEnabled(false);
                break;
            case SCORING:
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
        for (int i = 0; i < holdButtons.length; i++)
        {
            holdButtons[i].setText("");
            holdButtons[i].setEnabled(false);
            holdButtons[i].setSelected(false);
        }
            
    }
    
    
    private void clearHoldArray()
    {
        for (int i = 0; i < holdArray.length; i++)
        {
            holdArray[i] = false;
        }
    }
    
    
    private void enableHoldButtons()
    {
        for (int i = 0; i < holdButtons.length; i++)
        {
            holdButtons[i].setEnabled(true);
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

        dieOne = new javax.swing.JToggleButton();
        rollButton = new javax.swing.JButton();
        scoreButton = new javax.swing.JButton();
        dieFive = new javax.swing.JToggleButton();
        dieThree = new javax.swing.JToggleButton();
        dieFour = new javax.swing.JToggleButton();
        dieTwo = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(300, 100));

        dieOne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dieOneActionPerformed(evt);
            }
        });

        rollButton.setText("Roll ");
        rollButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rollButtonActionPerformed(evt);
            }
        });

        scoreButton.setText("Score");
        scoreButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                scoreButtonActionPerformed(evt);
            }
        });

        dieFive.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dieFiveActionPerformed(evt);
            }
        });

        dieThree.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dieThreeActionPerformed(evt);
            }
        });

        dieFour.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dieFourActionPerformed(evt);
            }
        });

        dieTwo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dieTwoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(dieOne, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(dieTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(dieThree, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(dieFour, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dieFive, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dieTwo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dieOne, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dieThree, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dieFour, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dieFive, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rollButton, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(scoreButton, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rollButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rollButtonActionPerformed

        for (int i = 0; i < NUM_DICE; i++)
        {
            //if user isnt holding die, roll.
            if (!holdArray[i])
            {
                myDice.rollDie(i);
                holdButtons[i].setText("" + myDice.getDieValue(i));
            }
        }   
        
       if (currentUIState == BEFORE_1ST_ROLL)
       {
           manageUIState(BEFORE_2ND_ROLL);
       }
       else if (currentUIState == BEFORE_2ND_ROLL)
       {
           manageUIState(BEFORE_3RD_ROLL);
       }
       else if (currentUIState == BEFORE_3RD_ROLL)
       {
           manageUIState(AFTER_3RD_ROLL);
       }

    
       
    }//GEN-LAST:event_rollButtonActionPerformed

    private void scoreButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_scoreButtonActionPerformed
        // TODO add your handling code here:
            rollButton.setEnabled(true);
            
            numRolls = 0;
            
            for (int i = 0; i <= holdArray.length; i++)
            {
                if (holdArray[i])
                {
                    holdButtons[i].doClick();
                }
                holdArray[i] = false;
                holdButtons[i].setEnabled(true);
                holdButtons[i].setText("");
            }
            
    }//GEN-LAST:event_scoreButtonActionPerformed

    private void dieOneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dieOneActionPerformed
        // TODO add your handling code here:
        holdArray[0] = !holdArray[0];
    }//GEN-LAST:event_dieOneActionPerformed

    private void dieTwoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dieTwoActionPerformed
        // TODO add your handling code here:
        holdArray[1] = !holdArray[1];
    }//GEN-LAST:event_dieTwoActionPerformed

    private void dieThreeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dieThreeActionPerformed
        // TODO add your handling code here:
        holdArray[2] = !holdArray[2];
    }//GEN-LAST:event_dieThreeActionPerformed

    private void dieFourActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dieFourActionPerformed
        // TODO add your handling code here:
        holdArray[3] = !holdArray[3];
    }//GEN-LAST:event_dieFourActionPerformed

    private void dieFiveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dieFiveActionPerformed
        // TODO add your handling code here:
        holdArray[4] = !holdArray[4];
    }//GEN-LAST:event_dieFiveActionPerformed

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
            java.util.logging.Logger.getLogger(DiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DiceFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DiceFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton dieFive;
    private javax.swing.JToggleButton dieFour;
    private javax.swing.JToggleButton dieOne;
    private javax.swing.JToggleButton dieThree;
    private javax.swing.JToggleButton dieTwo;
    private javax.swing.JButton rollButton;
    private javax.swing.JButton scoreButton;
    // End of variables declaration//GEN-END:variables
    private Dice myDice; 
   
    private JToggleButton[] holdButtons;
    private boolean[] holdArray;
    private int numRolls;
    
    private int currentUIState;

}

