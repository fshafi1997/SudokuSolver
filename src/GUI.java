import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class GUI extends JFrame {
    public static JButton solveButton = new JButton("Solve");
    public static ArrayList<JTextField> textFields = new ArrayList<>();
    public static JTextArea output = new JTextArea(10, 15);

    public static void print2D(int mat[][]) {
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }


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

                for (int i = 0; i < textFields.size(); i++) {
                    if (textFields.get(i).getText().equals("")){
                        textFields.get(i).setText("0");
                    } else continue;
                }

                //output.setText(eight.toString());
                int[][] enteredBoard = { { Integer.parseInt(textFields.get(0).getText()), Integer.parseInt(textFields.get(1).getText()), Integer.parseInt(textFields.get(2).getText()), Integer.parseInt(textFields.get(9).getText()), Integer.parseInt(textFields.get(10).getText()), Integer.parseInt(textFields.get(11).getText()), Integer.parseInt(textFields.get(18).getText()), Integer.parseInt(textFields.get(19).getText()), Integer.parseInt(textFields.get(20).getText()) },
                                         { Integer.parseInt(textFields.get(3).getText()), Integer.parseInt(textFields.get(4).getText()), Integer.parseInt(textFields.get(5).getText()), Integer.parseInt(textFields.get(12).getText()), Integer.parseInt(textFields.get(13).getText()), Integer.parseInt(textFields.get(14).getText()), Integer.parseInt(textFields.get(21).getText()), Integer.parseInt(textFields.get(22).getText()), Integer.parseInt(textFields.get(23).getText()) },
                                         { Integer.parseInt(textFields.get(6).getText()), Integer.parseInt(textFields.get(7).getText()), Integer.parseInt(textFields.get(8).getText()), Integer.parseInt(textFields.get(15).getText()), Integer.parseInt(textFields.get(16).getText()), Integer.parseInt(textFields.get(17).getText()), Integer.parseInt(textFields.get(24).getText()), Integer.parseInt(textFields.get(25).getText()), Integer.parseInt(textFields.get(26).getText()) },
                                         { Integer.parseInt(textFields.get(27).getText()), Integer.parseInt(textFields.get(28).getText()), Integer.parseInt(textFields.get(29).getText()), Integer.parseInt(textFields.get(36).getText()), Integer.parseInt(textFields.get(37).getText()), Integer.parseInt(textFields.get(38).getText()), Integer.parseInt(textFields.get(45).getText()), Integer.parseInt(textFields.get(46).getText()), Integer.parseInt(textFields.get(47).getText()) },
                                         { Integer.parseInt(textFields.get(30).getText()), Integer.parseInt(textFields.get(31).getText()), Integer.parseInt(textFields.get(32).getText()), Integer.parseInt(textFields.get(39).getText()), Integer.parseInt(textFields.get(40).getText()), Integer.parseInt(textFields.get(41).getText()), Integer.parseInt(textFields.get(48).getText()), Integer.parseInt(textFields.get(49).getText()), Integer.parseInt(textFields.get(50).getText()) },
                                         { Integer.parseInt(textFields.get(33).getText()), Integer.parseInt(textFields.get(34).getText()), Integer.parseInt(textFields.get(35).getText()), Integer.parseInt(textFields.get(42).getText()), Integer.parseInt(textFields.get(43).getText()), Integer.parseInt(textFields.get(44).getText()), Integer.parseInt(textFields.get(51).getText()), Integer.parseInt(textFields.get(52).getText()), Integer.parseInt(textFields.get(53).getText()) },
                                         { Integer.parseInt(textFields.get(54).getText()), Integer.parseInt(textFields.get(55).getText()), Integer.parseInt(textFields.get(56).getText()), Integer.parseInt(textFields.get(63).getText()), Integer.parseInt(textFields.get(64).getText()), Integer.parseInt(textFields.get(65).getText()), Integer.parseInt(textFields.get(72).getText()), Integer.parseInt(textFields.get(73).getText()), Integer.parseInt(textFields.get(74).getText()) },
                                         { Integer.parseInt(textFields.get(57).getText()), Integer.parseInt(textFields.get(58).getText()), Integer.parseInt(textFields.get(59).getText()), Integer.parseInt(textFields.get(66).getText()), Integer.parseInt(textFields.get(67).getText()), Integer.parseInt(textFields.get(68).getText()), Integer.parseInt(textFields.get(75).getText()), Integer.parseInt(textFields.get(76).getText()), Integer.parseInt(textFields.get(77).getText()) },
                                         { Integer.parseInt(textFields.get(60).getText()), Integer.parseInt(textFields.get(61).getText()), Integer.parseInt(textFields.get(62).getText()), Integer.parseInt(textFields.get(69).getText()), Integer.parseInt(textFields.get(70).getText()), Integer.parseInt(textFields.get(71).getText()), Integer.parseInt(textFields.get(78).getText()), Integer.parseInt(textFields.get(79).getText()), Integer.parseInt(textFields.get(80).getText()) }
                };

                algorithm algorithm2 = new algorithm(enteredBoard);
                boolean solved = algorithm2.solve(new algorithm.Cell(0, 0));
                if (!solved) {
                    System.out.println("SUDOKU cannot be solved.");
                    return;
                }
                System.out.println("SOLUTION\n");

                print2D(algorithm2.grid);
            }
        });
    }

}