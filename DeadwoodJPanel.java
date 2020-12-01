import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;





//https://docs.oracle.com/javase/tutorial/uiswing/components/text.html

class DeadwoodJPanel extends JFrame implements ActionListener{

JButton button;



    public DeadwoodJPanel() throws IOException {

            //Popup
            //JPopupMenu popMenu = new JPopupMenu();




        //gridlayout
        JFrame grid = new JFrame();
        grid.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        grid.setSize(500, 500);
        grid.setLayout(new GridLayout(1, 4, 10, 10));

        grid.add(new JButton("1"));
        grid.add(new JButton("2"));
        grid.add(new JButton("3"));
        grid.add(new JButton("4"));
        grid.add(new JButton("5"));
        grid.add(new JButton("6"));
        grid.add(new JButton("7"));
        grid.add(new JButton("8"));
        grid.add(new JButton("9"));
        grid.add(new JButton("10"));
        grid.add(new JButton("11"));
        grid.add(new JButton("12"));
        grid.setVisible(true);

        


        button = new JButton();
        button.setBounds(1250, 100, 200, 50);
        button.setBackground(Color.lightGray);
        button.setText("Act");
        button.setFocusable(false);


        button.setEnabled(true);


        //button.actionListener(e -> System.out.println("Hello, there"));

        // this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setLayout(null);
        // this.setSize(500, 500);
        // this.setVisible(true);




        JPanel redPanel = new JPanel();
        redPanel.setBackground(Color.red);
        redPanel.setBounds(0, 0, 250, 250);



        JPanel forPics = new JPanel();
        forPics.setBounds(21, 69, 205, 115);


        ImageIcon boardIcon = new ImageIcon("pics/board.jpg");
        JLabel board = new JLabel();
        board.setIcon(boardIcon);
        board.setBounds(0, 0, 1200, 900);




        ImageIcon cardBack = new ImageIcon("pics/CardBack-small.jpg");
        JLabel cardBacks = new JLabel();
        cardBacks.setIcon(cardBack);
        cardBacks.setBounds(21, 69, 205, 115);



        


        JLabel label = new JLabel();
        label.setText("Welcome to Deadwood!");
        label.setHorizontalTextPosition(JLabel.RIGHT); //LEFT. CENTER, RIGHT
        label.setVerticalTextPosition(JLabel.TOP); // set text top, center, bottom of label
        label.setForeground((Color.WHITE));
        label.setFont(new Font("MV Boli", Font.PLAIN, 20));


        this.setTitle("Deadwood");
        this.setSize(1500, 940);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setResizable(false);
        //ImageIcon image = new ImageIcon("");
        //this.setIconImage(image.getImage());
        
        this.getContentPane().setBackground(Color.DARK_GRAY);
        this.add(forPics);
        
        
        this.add(board);
        this.add(label);
        forPics.add(cardBacks);
        this.setVisible(true);
        this.add(button);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==button){
            System.out.println("Hello, there");
        }
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