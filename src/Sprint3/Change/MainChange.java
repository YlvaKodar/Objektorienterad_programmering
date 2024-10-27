package Sprint3.Change;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainChange extends JFrame implements ActionListener {
    Scanner sc = new Scanner(System.in);
    List<NotesAndCoins> values = new ArrayList<>();
    int price;
    int pay;
    boolean acceptedInput;

    JPanel questions = new JPanel();
    JPanel answers = new JPanel();
    JPanel checkbox = new JPanel();

    JLabel  questPriceLabel = new JLabel("Price of item? ");
    JLabel questRecievedLabel = new JLabel("Received amount? ");
    JLabel questValues = new JLabel("\nAccepted values? ");

    JTextField priceInput = new JTextField(20);
    JTextField payInput = new JTextField(20);

    JButton submit = new JButton(" Submit ");
    JTextArea output = new JTextArea(5, 60);
    JScrollPane scrollMia = new JScrollPane(output);


    JCheckBox aThousand = new JCheckBox("1000 kr. notes", false);
    JCheckBox fiveHundred = new JCheckBox("500 kr. notes", false);
    JCheckBox twoHundred = new JCheckBox("200 kr. notes", false);
    JCheckBox oneHundred = new JCheckBox("100 kr. notes", false);
    JCheckBox fifty = new JCheckBox("50 kr. notes", false);
    JCheckBox twenty = new JCheckBox("20 kr. notes", false);
    JCheckBox ten = new JCheckBox("10 kr. coins", false);
    JCheckBox five = new JCheckBox("5 kr. coins", false);
    JCheckBox two = new JCheckBox("2 kr. coins", false);
    JCheckBox one = new JCheckBox("1 kr. coins", false);

    boolean showAnswers = false;

    public static void main(String[] args) {
        MainChange m = new MainChange();
        m.mainProgram();
    }
    public void mainProgram(){

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Change");
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        questions.setLayout(new GridLayout(3,1));
        questions.add(questPriceLabel);
        questions.add(priceInput);
        questions.add(questRecievedLabel);
        questions.add(payInput);
        questions.add(questValues);
        this.add(questions, BorderLayout.NORTH);

        checkbox.setLayout(new GridLayout(6,2));
        checkbox.add(aThousand);
        aThousand.addActionListener(this);
        checkbox.add(fiveHundred);
        fiveHundred.addActionListener(this);
        checkbox.add(twoHundred);
        twoHundred.addActionListener(this);
        checkbox.add(oneHundred);
        oneHundred.addActionListener(this);
        checkbox.add(fifty);
        fifty.addActionListener(this);
        checkbox.add(twenty);
        twenty.addActionListener(this);
        checkbox.add(ten);
        ten.addActionListener(this);
        checkbox.add(five);
        five.addActionListener(this);
        checkbox.add(two);
        two.addActionListener(this);
        checkbox.add(one);
        one.addActionListener(this);
        checkbox.add(submit);
        submit.addActionListener(this);
        this.add(checkbox, BorderLayout.CENTER);

        //answers.setVisible(showAnswers);
        answers.add(scrollMia);
        this.add(answers, BorderLayout.SOUTH);

        pack();
    }
    public String buildString(ChangeCalculator ch){
        StringBuilder sb = new StringBuilder();
        sb.append(ch.reactToAmountReceived());

        if(ch.isChange)
            for (Change c : ch.getListOfChange())
                sb.append(c.toString());

        return sb.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == aThousand) {toggler(NotesAndCoins.THOUSAND);}
        if (e.getSource() == fiveHundred) {toggler(NotesAndCoins.FIVE_HUNDRED);}
        if (e.getSource() == twoHundred) {toggler(NotesAndCoins.TWO_HUNDRED);}
        if (e.getSource() == oneHundred) {toggler(NotesAndCoins.ONE_HUNDRED);}
        if (e.getSource() == fifty) {toggler(NotesAndCoins.FIFTY);}
        if (e.getSource() == twenty) {toggler(NotesAndCoins.TWENTY);}
        if (e.getSource() == ten) {toggler(NotesAndCoins.TEN);}
        if (e.getSource() == five) {toggler(NotesAndCoins.FIVE);}
        if (e.getSource() == two) {toggler(NotesAndCoins.TWO);}
        if (e.getSource() == one) {toggler(NotesAndCoins.ONE);}

        if (e.getSource() == submit){

            Scanner scanPrice = new Scanner(priceInput.getText());
            Scanner scanPay = new Scanner(payInput.getText());

            if (scanPrice.hasNextInt() && scanPay.hasNextInt()){
                price = scanPrice.nextInt();
                System.out.println(price);
                pay = scanPay.nextInt();
                System.out.println(pay);
                acceptedInput = true;

            }else System.out.println("Inte accepted input");

            if (acceptedInput == true){
                showAnswers = true;

                ChangeCalculator ch = new ChangeCalculator(price, pay, values);
                String totOutput = buildString(ch);
                System.out.println(totOutput);
                output.setText(totOutput);
            }
        }
    }
    public void toggler(NotesAndCoins n){
        if (values.contains(n)){
            remove(values.indexOf(n));
        }else {
            values.add(n);
        }
    }
}
