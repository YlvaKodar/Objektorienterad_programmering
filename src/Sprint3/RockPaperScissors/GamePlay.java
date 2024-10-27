package Sprint3.RockPaperScissors;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePlay extends JFrame implements ActionListener {
    GameLogic gameLogic;
    //JPanel bas = new JPanel();
    JPanel greetingPanel = new JPanel();
    JPanel roundPanel = new JPanel();
    JPanel scorePanel = new JPanel();
    JPanel gamePanel = new JPanel();
    JPanel davePanel = new JPanel();
    JPanel halPanel = new JPanel();

    JButton rockDave = new JButton(" Rock ");
    JButton rockHal = new JButton(" Rock ");
    JButton paperDave = new JButton(" Paper ");
    JButton paperHal = new JButton(" Paper ");
    JButton scissorsDave = new JButton(" Scissors ");
    JButton scissorsHal = new JButton(" Scissors ");
    JButton yes = new JButton(" Yes ");

    JLabel greeting = new JLabel(" Hello, Dave. I am Hal 9000. Play a game with me.");
    JLabel A = new JLabel(" You ");
    JLabel B = new JLabel(" Me ");
    JLabel roundCounts = new JLabel("Ready for round 1?");
    JLabel scoreDave = new JLabel("");
    JLabel scoreHal = new JLabel("");

    JLabel weapon = new JLabel("");
    JLabel reaction = new JLabel();

    JLabel currentScore = new JLabel();
    JLabel results = new JLabel();

    public GamePlay() {
        gameLogic = new GameLogic();

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Rock Paper Scissors");
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setSize(500, 300);

        roundPanel.setLayout(new GridLayout(1, 2));
        roundPanel.add(roundCounts);
        roundPanel.add(yes);
        yes.addActionListener(this);

        greetingPanel.setLayout(new GridLayout(4, 1));
        greetingPanel.add(greeting);
        greetingPanel.add(new Label(""));
        greetingPanel.add(roundPanel);

        greetingPanel.add(weapon);

        add(greetingPanel, BorderLayout.NORTH);

        add(new JPanel(), BorderLayout.WEST);
        add(new JPanel(), BorderLayout.EAST);
        gamePanel.setLayout(new BorderLayout());
        add(gamePanel, BorderLayout.CENTER);

        davePanel.setLayout(new GridLayout(5, 1));
        davePanel.add(A);
        davePanel.add(rockDave);
        davePanel.add(scissorsDave);
        davePanel.add(paperDave);
        davePanel.add(scoreDave);
        gamePanel.add(davePanel, BorderLayout.WEST);

        halPanel.setLayout(new GridLayout(5, 1));
        halPanel.add(B);
        halPanel.add(rockHal);
        halPanel.add(scissorsHal);
        halPanel.add(paperHal);
        halPanel.add(scoreHal);
        gamePanel.add(halPanel, BorderLayout.EAST);



        scorePanel.setLayout(new GridLayout(2, 1));
        scorePanel.add(reaction);
        scorePanel.add(currentScore);
        add(scorePanel, BorderLayout.SOUTH);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == yes) {
            roundCounts.setText("Round " + gameLogic.getTurns());
            yes.setBackground(Color.GRAY);
            yes.removeActionListener(this);

            reaction.setText("");
            rockDave.addActionListener(this); scissorsDave.addActionListener(this); paperDave.addActionListener(this);
            rockDave.setBackground(Color.WHITE); scissorsDave.setBackground(Color.WHITE); paperDave.setBackground(Color.WHITE);
            rockHal.setBackground(Color.WHITE); scissorsHal.setBackground(Color.WHITE); paperHal.setBackground(Color.WHITE);
            weapon.setText("Choose your weapon.");
        }

        if (e.getSource() == rockDave || e.getSource() == scissorsDave || e.getSource() == paperDave){
            weapon.setText("Interesting choice.");

            int source = 1;

            if (e.getSource() == scissorsDave)
                source = 2;
            if (e.getSource() == paperDave)
                source = 3;

            int result = gameLogic.round(source);

            if (result == 1) {
                if (source == 1){rockDave.setBackground(Color.green); scissorsHal.setBackground(Color.RED);
                }else if (source == 2){scissorsDave.setBackground(Color.green); paperHal.setBackground(Color.RED);
                }else if (source == 3){paperDave.setBackground(Color.green); rockHal.setBackground(Color.RED);}
            }
            if (result == 2) {
                if (source == 1){rockDave.setBackground(Color.RED); paperHal.setBackground(Color.GREEN);
                }else if (source == 2){scissorsDave.setBackground(Color.RED); rockHal.setBackground(Color.GREEN);
                }else if (source == 3){ paperDave.setBackground(Color.RED); scissorsHal.setBackground(Color.GREEN);}
            }
            if (result == 0) {
                if (source == 1){rockDave.setBackground(Color.YELLOW); rockHal.setBackground(Color.YELLOW);
                }else if (source == 2){scissorsDave.setBackground(Color.YELLOW); scissorsHal.setBackground(Color.YELLOW);
                }else if (source == 3){ paperDave.setBackground(Color.YELLOW); paperHal.setBackground(Color.YELLOW);}
            }
            setTheStage(result);
        }
    }
    public void setTheStage(int result){
        rockDave.removeActionListener(this); scissorsDave.removeActionListener(this); paperDave.removeActionListener(this);

        scoreDave.setText(gameLogic.getScoreDave());
        scoreHal.setText(gameLogic.getScoreHal());
        currentScore.setText(gameLogic.currentScore());

        if (gameLogic.gameOver == false) {
            yes.addActionListener(this);
            yes.setBackground(Color.WHITE);
            reaction.setText(gameLogic.react(result));
            roundCounts.setText(gameLogic.newTurn());
        }
    }

    public static void main(String[] args) {GamePlay newGame = new GamePlay();}
}
