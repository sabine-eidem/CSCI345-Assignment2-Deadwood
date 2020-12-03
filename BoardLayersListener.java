/*

   Deadwood GUI helper file
   Author: Moushumi Sharmin
   This file shows how to create a simple GUI using Java Swing and Awt Library
   Classes Used: JFrame, JLabel, JButton, JLayeredPane

*/

import java.awt.*;
import javax.swing.*;

import javax.imageio.ImageIO;
import java.awt.event.*;
import java.util.*;
import java.util.List;
import java.io.IOException;

public class BoardLayersListener extends JFrame {

   // JLabels
   JLabel boardlabel;

   JLabel[] playerLabels;
   JLabel[] cardLabels = new JLabel[10];
   JLabel playerlabel;
   JLabel mLabel;


   
   String currPlayerName   = "";
   String currPlayerRank   = "";
   String currPlayerCoins  = "";
   String currPlayerChips  = "";
   String currPlayerDollars= "";
   
   JLabel bPlayerName;
   JLabel bPlayerRank;
   JLabel bPlayerCoins;
   JLabel bPlayerChips;
   JLabel bPlayerDollars;

   // JButtons
   JButton bAct;
   JButton bRehearse;
   JButton bMove;
   JButton bTakeRole;
   JButton bUpgrade;
   JButton bEnd;

   // JLayered Pane
   JLayeredPane bPane;

   Player curPlayer;
   private List<Room> rooms;

   private int roomNum;

   // Constructor

   public BoardLayersListener() {

      // Set the title of the JFrame
      super("Deadwood");
      // Set the exit option for the JFrame
      setDefaultCloseOperation(EXIT_ON_CLOSE);

      // Create the JLayeredPane to hold the display, cards, dice and buttons
      bPane = getLayeredPane();

      // Create the deadwood board
      boardlabel = new JLabel();
      ImageIcon icon = new ImageIcon("pics/board.jpg");
      boardlabel.setIcon(icon);
      boardlabel.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

      // Add the board to the lowest layer
      bPane.add(boardlabel, new Integer(0));

      // Set the size of the GUI
      setSize(icon.getIconWidth() + 200, icon.getIconHeight());

      // Add a scene card to this room

      // Add the card to the lower layer

      // Add a dice to represent a player.
      // Role for Crusty the prospector. The x and y co-ordiantes are taken from
      // Board.xml file
      playerlabel = new JLabel();
      ImageIcon pIcon = new ImageIcon("pics/dice/r2.png");
      playerlabel.setIcon(pIcon);
      // playerlabel.setBounds(114,227,pIcon.getIconWidth(),pIcon.getIconHeight());
      playerlabel.setBounds(114, 227, 46, 46);
      playerlabel.setVisible(false);
      bPane.add(playerlabel, new Integer(3));

      // Create the Menu for action buttons
      mLabel = new JLabel("MENU");
      mLabel.setBounds(icon.getIconWidth() + 40, 0, 150, 20);
      bPane.add(mLabel, new Integer(2));

      // Create Action buttons
      bAct = new JButton("ACT");
      bAct.setBackground(Color.lightGray);
      bAct.setBounds(icon.getIconWidth() + 10, 30, 150, 20);
      bAct.addMouseListener(new boardMouseListener());

      bRehearse = new JButton("REHEARSE");
      bRehearse.setBackground(Color.lightGray);
      bRehearse.setBounds(icon.getIconWidth() + 10, 60, 150, 20);
      bRehearse.addMouseListener(new boardMouseListener());

      bMove = new JButton("MOVE");
      bMove.setBackground(Color.lightGray);
      bMove.setBounds(icon.getIconWidth() + 10, 90, 150, 20);
      bMove.addMouseListener(new boardMouseListener());

      bTakeRole = new JButton("Take Role");
      bTakeRole.setBackground(Color.lightGray);
      bTakeRole.setBounds(icon.getIconWidth() + 10, 120, 150, 20);
      bTakeRole.addMouseListener(new boardMouseListener());

      bUpgrade = new JButton("Upgrade");
      bUpgrade.setBackground(Color.lightGray);
      bUpgrade.setBounds(icon.getIconWidth() + 10, 150, 150, 20);
      bUpgrade.addMouseListener(new boardMouseListener());

      bEnd = new JButton("End");
      bEnd.setBackground(Color.lightGray);
      bEnd.setBounds(icon.getIconWidth() + 10, 180, 150, 20);
      bEnd.addMouseListener(new boardMouseListener());




      bPlayerName = new JLabel(currPlayerName);
      bPlayerName.setBackground(Color.darkGray);
      bPlayerName.setBounds(icon.getIconWidth() + 10, 300, 150, 20);

      
      bPlayerRank = new JLabel(currPlayerRank);
      bPlayerRank.setBackground(Color.darkGray);
      bPlayerRank.setBounds(icon.getIconWidth() + 10, 320, 150, 20);

      bPlayerCoins = new JLabel(currPlayerRank);
      bPlayerCoins.setBackground(Color.darkGray);
      bPlayerCoins.setBounds(icon.getIconWidth() + 10, 340, 150, 20);

      bPlayerChips = new JLabel(currPlayerRank);
      bPlayerChips.setBackground(Color.darkGray);
      bPlayerChips.setBounds(icon.getIconWidth() + 10, 360, 150, 20);

      bPlayerDollars = new JLabel(currPlayerRank);
      bPlayerDollars.setBackground(Color.darkGray);
      bPlayerDollars.setBounds(icon.getIconWidth() + 10, 380, 150, 20);

      

      // Place the action buttons in the top layer
      bPane.setBackground(Color.darkGray);
      this.setPreferredSize(new Dimension(1500, 1500));
      bPane.add(bAct, new Integer(2));
      bPane.add(bRehearse, new Integer(2));
      bPane.add(bMove, new Integer(2));
      bPane.add(bTakeRole, new Integer(2));
      bPane.add(bUpgrade, new Integer(2));
      bPane.add(bEnd, new Integer(2));
      
      bPane.add(bPlayerName, new Integer(2));
      bPane.add(bPlayerRank, new Integer(2));
      bPane.add(bPlayerCoins, new Integer(2));
      bPane.add(bPlayerChips, new Integer(2));
      bPane.add(bPlayerDollars, new Integer(2));
   }

   public void addCard(HashMap<String, Integer> area, int i) {

      cardLabels[i] = new JLabel();
      ImageIcon cIcon = new ImageIcon("pics/CardBack-small.jpg");
      cardLabels[i].setIcon(cIcon);
      cardLabels[i].setBounds(area.get("x"), area.get("y"), cIcon.getIconWidth() + 2, cIcon.getIconHeight());
      cardLabels[i].setOpaque(true);

      bPane.add(cardLabels[i], new Integer(1));
      // cardPanel.add(cardLabels[i]);
   }

   public void updateRoomCards() {
      for (int i = 0; i < cardLabels.length; i++) {

         String cardName = rooms.get(i).getCardFront();
         System.out.println(cardName);
         ImageIcon cIcon = new ImageIcon(cardName);
         cardLabels[i].setIcon(cIcon);
      }
   }

   public void initiatePlayers(List<Player> players) {

      playerLabels = new JLabel[players.size()];
      for (int i = 0; i < players.size(); i++) {
         playerLabels[i] = new JLabel();

         // get pic
         ImageIcon pIcon = new ImageIcon("pics/dice/" + players.get(i).getDiceName());
         // ImageIcon pIcon = new ImageIcon("pics/dice/b1.png");

         // set bounds

         HashMap<String, Integer> pos = new HashMap<>();

         int x, y;

         int minX = 1000;
         int maxX = 1150;

         int minY = 300;
         int maxY = 400;

         Random random = new Random();
         x = random.nextInt(maxX + 1 - minX) + minX;
         y = random.nextInt(maxY + 1 - minY) + minY;

         pos.put("x", x);
         pos.put("y", y);
         // add
         playerLabels[i].setIcon(pIcon);
         playerLabels[i].setBounds(x, y, pIcon.getIconWidth() + 2, pIcon.getIconHeight());
         playerLabels[i].setOpaque(true);
         bPane.add(playerLabels[i], new Integer(3));
         bPane.repaint();

         players.get(i).setPlayerPos(pos);
         players.get(i).setPIcon(pIcon);

         System.out.println("Player " + players.get(i).getName() + " added");
      }

   }

   public void updatePlayer(int playerIndex) {

      curPlayer.getRoom().setViseted();

      HashMap<String, Integer> pos = curPlayer.getPlayerPos();
      ImageIcon pIcon = curPlayer.getPICon();

      playerLabels[playerIndex].setBounds(pos.get("x"), pos.get("y"), pIcon.getIconWidth() + 2, pIcon.getIconHeight());

      currPlayerName = curPlayer.getName();
      bPlayerName.setText(currPlayerName);
      bPlayerRank.setText("Rank: " + Integer.toString(curPlayer.getRank()));
      bPlayerCoins.setText("Coins: " + Integer.toString(curPlayer.getCredits()));
      bPlayerChips.setText("Chips: " + Integer.toString(curPlayer.getChips()));
      bPlayerDollars.setText("Dollars: " + Integer.toString(curPlayer.getDollars()));
   }

   public void endGame() {
      JOptionPane.showMessageDialog(null, "Game has ended", "Congrats " + curPlayer.getName(),
            JOptionPane.INFORMATION_MESSAGE);
   }

   public void printRoleLocations(List<Room> rooms) {
      for (int i = 0; i < 10; i++) {
         List<Role> offCardRoles = rooms.get(i).getOffCardRoles();

         for (int j = 0; j < offCardRoles.size(); j++) {

            // cardLabels[i].setBounds(area.get("x"), area.get("y"), cIcon.getIconWidth() +
            // 2, cIcon.getIconHeight());

            HashMap<String, Integer> areaHashMap = offCardRoles.get(j).getAreaHashMap();

            JPanel redPanel = new JPanel();

            redPanel.setBackground(Color.red);
            redPanel.setBounds(areaHashMap.get("x"), areaHashMap.get("y"), areaHashMap.get("w"), areaHashMap.get("h"));
            // redPanel.setBounds(500, 100, 50, 50);
            redPanel.setOpaque(true);
            bPane.add(redPanel, new Integer(1));
         }
      }
   }

   public void printTakesLocations(List<Room> rooms) {
      for (int i = 0; i < 10; i++) {

         List<HashMap<String, Integer>> takesAreaHashList = rooms.get(i).getTakesAreaHashList();

         for (int j = 0; j < takesAreaHashList.size(); j++) {

            // cardLabels[i].setBounds(area.get("x"), area.get("y"), cIcon.getIconWidth() +
            // 2, cIcon.getIconHeight());

            HashMap<String, Integer> takesAreaHashMap = takesAreaHashList.get(j);

            ImageIcon boardIcon = new ImageIcon("pics/shot.png");
            JLabel shotLable = new JLabel();
            shotLable.setIcon(boardIcon);
            shotLable.setBounds(takesAreaHashMap.get("x"), takesAreaHashMap.get("y"), takesAreaHashMap.get("w"),
                  takesAreaHashMap.get("h"));
            // redPanel.setBounds(500, 100, 50, 50);

            shotLable.setOpaque(false);
            if(rooms.get(i).getShotList().get(j)){
               bPane.add(shotLable, new Integer(1));
            } 
         }
      }
   }

   public void updatePlayer(Player CurPlayer) {

      curPlayer = CurPlayer;
      curPlayer.resetTurnStatus();
   }

   public void updateRooms(List<Room> Rooms) {
      rooms = Rooms;
   }

   public void updateRoomCards(List<Room> rooms) {
      for (int i = 0; i < 10; i++) {
         Room room = rooms.get(i);

         String iconName = "";
         if (room.getVisted()) {
            iconName = "pics/cards/" + room.getCardFront();
         } else {
            iconName = "pics/CardBack-small.jpg";
         }

         ImageIcon cIcon = new ImageIcon(iconName);
         cardLabels[i].setIcon(cIcon);

      }
   }

   // This class implements Mouse Events

   class boardMouseListener implements MouseListener {

      // Code for the different button clicks
      public void mouseClicked(MouseEvent e) {

         if (e.getSource() == bAct) {
            if (curPlayer.hasRole()) {

               //curPlayer.act();

               Room currentRoom = curPlayer.getRoom();
               if (!currentRoom.getWraped()) {
                  int roll;
                  int budget = currentRoom.getScene().getBudget();
                  System.out.println("You are rolling to get at or above " + budget);
                  String message1 = "You are rolling to get at or above " + budget;

                  roll = curPlayer.rollDice(1);
                  System.out.println("You roll a " + roll);
                  String message2 = "You roll a " + roll;

                  String message3;
                  if (roll >= budget) {
                     System.out.println("You did well in the shot!");
                     message3 = "You did well in the shot!";
                     currentRoom.takeOffAShot();
                  } else {
                     System.out.println("You did not do well in the shot");
                     message3 = "You did NOT do well in the shot!";
                  }

                  String totalMessage = message1 + "\n" + message2 + "\n" + message3;

                  JOptionPane.showMessageDialog(null, totalMessage, curPlayer.getName(),
                        JOptionPane.ERROR_MESSAGE);

                  currentRoom.printShotList();
               } else {
                  System.out.println("Scene is wrapped, you cannot act");
                  JOptionPane.showMessageDialog(null, 
                        "Scene is wrapped, you cannot act", curPlayer.getName(), JOptionPane.ERROR_MESSAGE);
               }






            } else {
               System.out.println("Player does not have role");
               JOptionPane.showMessageDialog(null, "You do not have a role", curPlayer.getName(),
                     JOptionPane.ERROR_MESSAGE);
            }
         } else if (e.getSource() == bRehearse) {
            if (curPlayer.hasRole()) {
               curPlayer.rehearse();
            } else {
               System.out.println("Player does not have role");
               JOptionPane.showMessageDialog(null, "You do not have a role", curPlayer.getName(),
                     JOptionPane.ERROR_MESSAGE);
            }
         } else if (e.getSource() == bMove) {

            if (curPlayer.hasRole()) {
               System.out.println("Player has a role and cannot move");
               JOptionPane.showMessageDialog(null, "Player has a role and cannot move", curPlayer.getName(),
                     JOptionPane.ERROR_MESSAGE);

            } else if (curPlayer.hasMoved()) {
               System.out.println("Player has already moved this turn");
               JOptionPane.showMessageDialog(null, "Player has already moved this turn", curPlayer.getName(),
                     JOptionPane.ERROR_MESSAGE);
            } else {

               roomNum = 1;

               String[] comboArray = (curPlayer.getRoom().getNeighbors())
                     .toArray(new String[curPlayer.getRoom().getNeighbors().size()]);

               System.out.println("Where would you like to move?");
               curPlayer.printNeighbors();
               ComboBoxMove gennus = new ComboBoxMove(comboArray, curPlayer);

               if (curPlayer.getHasPickedRoom()) {
                  String cardFront = curPlayer.getRoom().getCardFront();
                  System.out.println("CardFront " + cardFront);

                  roomNum = curPlayer.getRoomChoise();
                  System.out.println(roomNum);
                  curPlayer.setRoomChoise(roomNum);

                  updateRoomCards();

                  ImageIcon cIcon = new ImageIcon(cardFront);
                  cardLabels[roomNum].setIcon(cIcon);

                  curPlayer.setHasPickdTrue();
                  curPlayer.finishedMove();

               }

            }
            System.out.println("Move is Selected\n");
         } else if (e.getSource() == bUpgrade) {

            if (curPlayer.getRoom().equals("office")) {

            } else {
               System.out.println("Player not in office, cannot upgrade");
               JOptionPane.showMessageDialog(null, "Player not in office, cannot upgrade", curPlayer.getName(),
                     JOptionPane.ERROR_MESSAGE);
            }
         } else if (e.getSource() == bTakeRole) {
            // take a role checklist
            if (curPlayer.hasRole()) {
               System.out.println("Player already has a role");
               JOptionPane.showMessageDialog(null, "Player already has a role", curPlayer.getName(),
                     JOptionPane.ERROR_MESSAGE);
               

            } else if ((curPlayer.getRoomName().equals("trailer")) || (curPlayer.getRoomName().equals("office"))) {
               System.out.println("You cannot take on roles in trailer or office");
               JOptionPane.showMessageDialog(null, "You cannot take on roles in trailer or office", curPlayer.getName(),
                     JOptionPane.ERROR_MESSAGE);

            } else {

               System.out.println("\nSelect a Role:");
               curPlayer.getRoom().printOffCardRoles();
               curPlayer.getRoom().getScene().printSceneInfo(curPlayer.getRoom().getOffCardRoleCount());


               ArrayList<Role> roles = new ArrayList<Role>();

               roles.addAll(curPlayer.getRoom().getOffCardRoles());
               roles.addAll(curPlayer.getRoom().getScene().getRoles());

               String[] roleNames = new String[roles.size()];

               for(int i = 0; i < roles.size(); i++){
                  String roleName = roles.get(i).getName();
                  roleNames[i] = roleName;
                  System.out.println(roleName);
               }

               while (!curPlayer.hasRole()) {

                  System.out.print("Select a role number: ");



                  ComboBoxRoles gennusis = new ComboBoxRoles(roleNames, curPlayer, roles);


                  if (curPlayer.getHasPickedRoom()) {
                  String cardFront = curPlayer.getRoom().getCardFront();
                  System.out.println("CardFront " + cardFront);

                  roomNum = curPlayer.getRoomChoise();
                  System.out.println(roomNum);
                  curPlayer.setRoomChoise(roomNum);
                  updateRoomCards();
                  
                  ImageIcon cIcon = new ImageIcon(cardFront);
                  cardLabels[roomNum].setIcon(cIcon);
                  
                  curPlayer.setHasPickdTrue();
                  curPlayer.finishedMove();
                  
                  int asdf = gennusis.comboBox.getSelectedIndex();
                  System.out.println(asdf);
               }

                  int input = 1;

                  // need to check if role is taken
                  if (input <= curPlayer.getRoom().getOffCardRoleCount()) {
                     // player has chosen off card role

                     if (!curPlayer.getRoom().isRoleTaken(input)) {
                        curPlayer.setRole(curPlayer.getRoom().getOffCardRole(input - 1));
                        curPlayer.getRoom().addPlayerToOffCardList(curPlayer);

                     } else {
                        System.out.println("Role is already taken");
                        JOptionPane.showMessageDialog(null, "Role is already taken",
                              curPlayer.getName(), JOptionPane.ERROR_MESSAGE);
                        
                     }
                  } else {
                     // player has chosen on card role
                     curPlayer.setRole(curPlayer.getRoom().getScene().getRole(input - 1));
                     curPlayer.getRoom().addPlayerToOffCardList(curPlayer);
                     curPlayer.playerChoseCardRole();
                  }

                  System.out.println("Cannot accept that answer");

               }
               System.out.println("Player has chosen role: " + curPlayer.getRoleName());

            }

         } else if (e.getSource() == bEnd) {

            System.out.println("Turn ended for " + curPlayer.getName());
            JOptionPane.showMessageDialog(null, "Players turn has ended", curPlayer.getName(),
                  JOptionPane.INFORMATION_MESSAGE);

            curPlayer.endTurn();

         }
      }

      public void mousePressed(MouseEvent e) {
      }

      public void mouseReleased(MouseEvent e) {
      }

      public void mouseEntered(MouseEvent e) {
      }

      public void mouseExited(MouseEvent e) {
      }
   }
}