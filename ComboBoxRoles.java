import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ComboBoxRoles extends JFrame implements ActionListener{

 JComboBox comboBox;
 Player curPlayer;
 private ArrayList<Role> roleClass;


 ComboBoxRoles(String[] roles, Player CurPlayer, ArrayList<Role> RoleClass){
  this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  this.setLayout(new FlowLayout()); 
  curPlayer = CurPlayer;
  roleClass = RoleClass;

  
  comboBox = new JComboBox(roles);
  comboBox.addActionListener(this);
  

  this.add(comboBox);
  this.pack();
  this.setVisible(true);
 }
 
 @Override
 public void actionPerformed(ActionEvent e) {
  if(e.getSource()==comboBox) {
      curPlayer.setRole(roleClass.get(comboBox.getSelectedIndex()));
  }
 }

}