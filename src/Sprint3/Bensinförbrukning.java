package Sprint3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Bensinförbrukning extends JFrame implements ActionListener{

    Scanner sc = new Scanner(System.in);

    JLabel currentMeterLabel = new JLabel("Mätarinställning nu?");
    JLabel lastYearMeterLabel = new JLabel("Mätarinställning förra året?");
    JLabel gasConsumptionLabel = new JLabel("Liter bensin under året?");

    JLabel drivenMilesLabel = new JLabel("");
    JLabel gasConsumptionLabel2 = new JLabel("");
    JLabel gasPerMile = new JLabel("");

    JPanel questions = new JPanel();
    JPanel answers = new JPanel();
    JPanel input = new JPanel();

    JTextField currentMeterText = new JTextField(30);
    JTextField lastYearText = new JTextField(30);
    JTextField gasConsumptionText = new JTextField(30);

    public Bensinförbrukning(){

        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Bensinförbrukning");
        setLocationRelativeTo(null);
        setSize(500, 100);
        setLayout(new java.awt.BorderLayout());

        questions.setLayout(new GridLayout(3, 1));
        questions.add(currentMeterLabel);
        questions.add(lastYearMeterLabel);
        questions.add(gasConsumptionLabel);
        this.add(questions, BorderLayout.WEST);

        input.setLayout(new GridLayout(3, 1));
        input.add(currentMeterText);
        input.add(lastYearText);
        input.add(gasConsumptionText);
        this.add(input, BorderLayout.CENTER);

        answers.setLayout(new GridLayout(1, 3));
        answers.add(drivenMilesLabel);
        answers.add(gasConsumptionLabel2);
        answers.add(gasPerMile);
        this.add(answers, BorderLayout.SOUTH);

        currentMeterText.addActionListener(this);
        lastYearText.addActionListener(this);
        gasConsumptionText.addActionListener(this);

    }
    public double meterDifference(double currentMeter, double lastYearsMeter) {
        return currentMeter - lastYearsMeter;
    }
    public double gasPerMile(double milesThisYear, double gasConsumption) {
        return milesThisYear / gasConsumption;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == currentMeterText || e.getSource() == lastYearText || e.getSource() == gasConsumptionText){

            Scanner scanCurrentMeter = new Scanner(currentMeterText.getText());
            Scanner scanLastYear = new Scanner(lastYearText.getText());
            Scanner scanGasConsumption = new Scanner(gasConsumptionText.getText());

            if (scanCurrentMeter.hasNextDouble() && scanLastYear.hasNextDouble() && scanGasConsumption.hasNextDouble()){
                double nu = scanCurrentMeter.nextDouble();
                double iFjol = scanLastYear.nextDouble();
                double gas = scanGasConsumption.nextDouble();

                double diff = meterDifference(nu, iFjol);
                double gasMile = gasPerMile(diff, gas);

                drivenMilesLabel.setText(String.format("Antal körda mil: \n" + diff));
                gasConsumptionLabel2.setText(String.format("Antal liter bensin: \n" + gas));
                gasPerMile.setText(String.format("Antal liter per mil: \n" + gasMile));
            }
        }
    }
    public static void main (String[] args){Bensinförbrukning bs = new Bensinförbrukning();}

}
