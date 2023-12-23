import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class RockPaperScissorsGUI extends JFrame implements ActionListener {

    private JButton rockButton, paperButton, scissorsButton;
    private JLabel resultLabel;

    public RockPaperScissorsGUI() {
        setTitle("Rock Paper Scissors Game");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create buttons
        rockButton = new JButton("Rock");
        paperButton = new JButton("Paper");
        scissorsButton = new JButton("Scissors");

        // Create result label
        resultLabel = new JLabel("Result: ");

        // Set layout manager
        setLayout(new GridLayout(4, 1));

        // Add components to the frame
        add(rockButton);
        add(paperButton);
        add(scissorsButton);
        add(resultLabel);

        // Add action listeners to buttons
        rockButton.addActionListener(this);
        paperButton.addActionListener(this);
        scissorsButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String userChoice = "";

        if (e.getSource() == rockButton) {
            userChoice = "Rock";
        } else if (e.getSource() == paperButton) {
            userChoice = "Paper";
        } else if (e.getSource() == scissorsButton) {
            userChoice = "Scissors";
        }

        String computerChoice = getComputerChoice();
        String result = determineWinner(userChoice, computerChoice);

        resultLabel.setText("Result: " + result + " (Computer chose " + computerChoice + ")");
    }

    private String getComputerChoice() {
        String[] choices = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int index = random.nextInt(choices.length);
        return choices[index];
    }

    private String determineWinner(String userChoice, String computerChoice) {
        if (userChoice.equals(computerChoice)) {
            return "It's a tie!";
        } else if ((userChoice.equals("Rock") && computerChoice.equals("Scissors")) ||
                (userChoice.equals("Paper") && computerChoice.equals("Rock")) ||
                (userChoice.equals("Scissors") && computerChoice.equals("Paper"))) {
            return "You win!";
        } else {
            return "Computer wins!";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            RockPaperScissorsGUI game = new RockPaperScissorsGUI();
            game.setVisible(true);
        });
    }
}
