import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GUI extends JFrame {
    public static JButton solveButton = new JButton("Solve");
    public static ArrayList<JTextField> textFields = new ArrayList<>();
    public static JTextArea output = new JTextArea(10, 15);


    public GUI() {
        // Create panel for Sudoku
        JPanel board = new JPanel();
        board.setLayout(new GridLayout(3, 3));
        board.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        for (int row = 0; row < 3; ++row) {
            for (int col = 0; col < 3; ++col) {
                JPanel box = new JPanel(new GridLayout(3, 3));
                box.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                for (int cell = 0; cell < 9; ++cell) {
                    JTextField textField = new JTextField(2);
                    box.add(textField);
                    textFields.add(textField);
                }
                board.add(box);
            }
        }

        // Create menu panel
        JPanel menu = new JPanel();
        menu.setLayout(new GridBagLayout());
        GridBagConstraints menuConstraints = new GridBagConstraints();

        menuConstraints.anchor = GridBagConstraints.WEST;
        menuConstraints.weightx = 0.5;
        menuConstraints.weighty = 0.5;
        menuConstraints.gridwidth = 2;

        menuConstraints.gridx = 2;
        menuConstraints.gridy = 2;
        menu.add(solveButton, menuConstraints);


        menuConstraints.fill = GridBagConstraints.HORIZONTAL;
        menuConstraints.weightx = 0.5;
        menuConstraints.weighty = 0.5;
        menuConstraints.gridwidth = 2;
        menuConstraints.gridx = 0;
        menuConstraints.gridy = 5;

        // Create output panel
        output.setEditable(false);
        output.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLUE), "Output Area"));

        // Join the 3 panels on the frame
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(board, BorderLayout.WEST);
        cp.add(menu, BorderLayout.EAST);
        cp.add(output, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        // Create a frame and set its properties
        JFrame frame = new GUI();
        frame.setTitle("Sudoku Solver");
        frame.setSize(600, 600);
        frame.setLocationRelativeTo(null); // Center the frame

        // Setup the window
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("I was pressed");
                StringBuilder one = new StringBuilder();
                StringBuilder two = new StringBuilder();
                StringBuilder three = new StringBuilder();
                StringBuilder four = new StringBuilder();
                StringBuilder five = new StringBuilder();
                StringBuilder six = new StringBuilder();
                StringBuilder seven = new StringBuilder();
                StringBuilder eight = new StringBuilder();
                StringBuilder nine = new StringBuilder();

                for (int i = 0;i<9;i++){
                    System.out.println(textFields.get(i).getText() + " index was " + i );
                }
                for (int i = 9;i<18;i++){
                    System.out.println(textFields.get(i).getText() + " index was " + i );
                }
                for (int i = 18;i<27;i++){
                    System.out.println(textFields.get(i).getText() + " index was " + i );
                }
                for (int i = 27;i<36;i++){
                    System.out.println(textFields.get(i).getText() + " index was " + i );
                }
                for (int i = 36;i<45;i++){
                    System.out.println(textFields.get(i).getText() + " index was " + i );
                }
                for (int i = 45;i<54;i++){
                    System.out.println(textFields.get(i).getText() + " index was " + i );
                }
                for (int i = 54;i<63;i++){
                    System.out.println(textFields.get(i).getText() + " index was " + i );
                }
                for (int i = 63;i<72;i++){
                    System.out.println(textFields.get(i).getText() + " index was " + i );
                }
                for (int i = 72;i<81;i++){
                    System.out.println(textFields.get(i).getText() + " index was " + i );
                }
            }
        });
    }

}