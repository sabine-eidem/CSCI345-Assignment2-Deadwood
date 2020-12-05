import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class ComboBoxRoles extends JFrame implements ActionListener {

    JComboBox comboBox;
    Player curPlayer;
    private ArrayList<Role> roleClass;
    int roomNum;

    ComboBoxRoles(String[] roles, Player CurPlayer, ArrayList<Role> RoleClass) {
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
        if (e.getSource() == comboBox) {

            System.out.println("Player picked role " + comboBox.getSelectedItem());

            int input = comboBox.getSelectedIndex(); // size of the offcard list

            int rank = curPlayer.getRank();

            // need to check if role is taken

            System.out.println(input);
            if (input < curPlayer.getRoom().getOffCardRoleCount()-1) {
                // player has chosen off card role

                System.out.println(curPlayer.getRoom().getOffCardRoleCount()-1);
                if (!curPlayer.getRoom().getOffCardRole(input).isTaken()) {

                    if (rank < curPlayer.getRoom().getOffCardRole(input).getRank()) {
                        JOptionPane.showMessageDialog(null, "Player is not high enough rank", curPlayer.getName(),
                                JOptionPane.ERROR_MESSAGE);

                    } else {

                        curPlayer.setRole(curPlayer.getRoom().getOffCardRole(input), false);
                        curPlayer.getRoom().addPlayerToOffCardList(curPlayer);

                        // set as taken
                        curPlayer.getRoom().getOffCardRole(input).take();
                    }

                } else {
                    System.out.println("Role is already taken");
                    JOptionPane.showMessageDialog(null, "Role is already taken", curPlayer.getName(),
                            JOptionPane.ERROR_MESSAGE);

                }
            } else {

                input -= curPlayer.getRoom().getOffCardRoles().size();

                if (!curPlayer.getRoom().getScene().getRole(input).isTaken()) {

                    if (rank < curPlayer.getRoom().getScene().getRole(input).getRank()) {
                        JOptionPane.showMessageDialog(null, "Player is not high enough rank", curPlayer.getName(),
                                JOptionPane.ERROR_MESSAGE);

                    } else {
                        JOptionPane.showMessageDialog(null, "Player got card role", curPlayer.getName(),
                                JOptionPane.ERROR_MESSAGE);

                        curPlayer.setRole(curPlayer.getRoom().getScene().getRole(input), true);
                        curPlayer.getRoom().addPlayerToCardList(curPlayer);

                        // set as taken
                        curPlayer.getRoom().getScene().getRole(input).take();

                    }

                } else {

                    System.out.println("Role is already taken");
                    JOptionPane.showMessageDialog(null, "Role is already taken", curPlayer.getName(),
                            JOptionPane.ERROR_MESSAGE);

                }
            }

            curPlayer.setHasPickdTrue();
            curPlayer.finishedMove();
        }
    }
}