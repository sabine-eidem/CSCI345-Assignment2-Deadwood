import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ComboBoxMove extends JFrame implements ActionListener{

 JComboBox comboBox;
 Player curPlayer;


 ComboBoxMove(String[] roles, Player CurPlayer){
  this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  this.setLayout(new FlowLayout()); 
  curPlayer = CurPlayer;

  
  comboBox = new JComboBox(roles);
  comboBox.addActionListener(this);
  

  this.add(comboBox);
  this.pack();
  this.setVisible(true);
 }
 
 @Override
 public void actionPerformed(ActionEvent e) {
  if(e.getSource()==comboBox) {
   System.out.println(comboBox.getSelectedItem());
   System.out.println(comboBox.getSelectedIndex());
   curPlayer.setRoomChoise(comboBox.getSelectedIndex());
  }
 }

}