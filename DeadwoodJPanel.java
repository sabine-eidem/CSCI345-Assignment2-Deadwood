import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;





//https://docs.oracle.com/javase/tutorial/uiswing/components/text.html

class DeadwoodJPanel extends JFrame {





    public DeadwoodJPanel() throws IOException{

            //Popup
            JPopupMenu popMenu = new JPopupMenu();









        ImageIcon image = new ImageIcon("pics/board.jpg");


        JLabel label = new JLabel();
        label.setText("Welcome to Deadwood!");
        label.setIcon(image);
        label.setHorizontalTextPosition(JLabel.RIGHT); //LEFT. CENTER, RIGHT
        label.setVerticalTextPosition(JLabel.TOP); // set text top, center, bottom of label
        label.setForeground((Color.WHITE));
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));


        this.setTitle("Deadwood");
        this.setSize(1500, 940);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        //ImageIcon image = new ImageIcon("");
        //this.setIconImage(image.getImage());
        
        this.getContentPane().setBackground(Color.DARK_GRAY);
        
        
        
        
        
        this.add(label);
        
        this.setVisible(true);
    }

    

    // public DeadwoodJPanel() throws IOException {
    //     setTitle("DEADWOOD");
    //     setSize(1600, 1000);
    //     setLocationRelativeTo(null);

    //     setDefaultCloseOperation(EXIT_ON_CLOSE);
    //     setVisible(true);

    //     setLayout(new BorderLayout());
    //     JPanel background = new JPanel();
    //     background.setBackground(Color.DARK_GRAY);
    //     background.setLayout(new FlowLayout());
    //     l1 = new JLabel("Here is a button");
    //     b1 = new JButton("I am a button");
        
        
    //             BufferedImage board = ImageIO.read(new File("pics/board.jpg"));
    //             JLabel theboard = new JLabel(new ImageIcon(board));
    //             add(theboard);
    //     background.add(l1);
    //     background.add(b1);

    //     background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
    //     background.setAlignmentX(Component.LEFT_ALIGNMENT);

    //     background.setPreferredSize(new Dimension(1600, 1000));//sdfsdf
    //     background.setMinimumSize(new Dimension(1600, 1000));


    //     setSize(1600, 1000);
    //     //setSize(400, 400);


    // }


    
}