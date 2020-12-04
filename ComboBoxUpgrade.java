import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ComboBoxUpgrade extends JFrame implements ActionListener{

 JComboBox comboBox;
 Player curPlayer;
 private ArrayList<Upgrade> upgradeList;


 ComboBoxUpgrade(String[] upgrades, Player CurPlayer, ArrayList<Upgrade> UpgradeList){
  this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  this.setLayout(new FlowLayout()); 
  curPlayer = CurPlayer;
  upgradeList = UpgradeList;

  
  comboBox = new JComboBox(upgrades);
  comboBox.addActionListener(this);
  

  this.add(comboBox);
  this.pack();
  this.setVisible(true);
 }
 
 @Override
 public void actionPerformed(ActionEvent e) {
  if(e.getSource()==comboBox) {

      Upgrade upgradeChoise = upgradeList.get(comboBox.getSelectedIndex());

      int rank = Integer.parseInt(upgradeChoise.getLevel());
      int amount = Integer.parseInt(upgradeChoise.getAmt());

      if(upgradeChoise.getCurrency().equals("dollar")){
        if(curPlayer.getDollars() < amount){
            JOptionPane.showMessageDialog(null, "Player does not have enough dollars", curPlayer.getName(),
                    JOptionPane.ERROR_MESSAGE);
        } else {
            //upgrade to rank
            curPlayer.setRank(rank);
        }
      } else {
          if (curPlayer.getCredits() < amount) {
              JOptionPane.showMessageDialog(null, "Player does not have enough credits", curPlayer.getName(),
                      JOptionPane.ERROR_MESSAGE);
          } else {
              // upgrade to rank
              curPlayer.setRank(rank);
          }
      }
  }
 }

}