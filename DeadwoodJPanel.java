import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;





//https://docs.oracle.com/javase/tutorial/uiswing/components/text.html

class DeadwoodJPanel extends JFrame {
    JButton b1;
    JLabel l1;

    public DeadwoodJPanel() throws IOException {
        setTitle("Background Color for JFrame");
        setSize(1600, 1000);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        setLayout(new BorderLayout());
        JPanel background = new JPanel();
        background.setBackground(Color.DARK_GRAY);
        background.setLayout(new FlowLayout());
        l1 = new JLabel("Here is a button");
        b1 = new JButton("I am a button");
        background.add(l1);
        background.add(b1);

        background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
        background.setAlignmentX(Component.LEFT_ALIGNMENT);

        background.setPreferredSize(new Dimension(1600, 1000));//sdfsdf
        background.setMinimumSize(new Dimension(1600, 1000));


        setSize(1600, 1000);
        //setSize(400, 400);



        BufferedImage board = ImageIO.read(new File("pics/board.jpg"));
        JLabel theboard = new JLabel(new ImageIcon(board));
        add(theboard);

    }


    
}