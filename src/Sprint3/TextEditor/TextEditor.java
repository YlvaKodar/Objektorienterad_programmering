package Sprint3.TextEditor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardOpenOption.APPEND;

public class TextEditor extends javax.swing.JFrame {

    JPanel bas = new JPanel();
    JPanel buttonsAndFile = new JPanel();
    JPanel text = new JPanel();

    JButton open = new JButton("Open");
    JButton save = new JButton("Save");
    JButton print = new JButton("Print");
    JButton exit = new JButton("Exit");
    JLabel fileName = new JLabel("File name: ");

    JTextField fileField = new JTextField(10);

    JTextArea textArea = new JTextArea(10, 60);
    JScrollPane textAreaScrollPane = new JScrollPane(textArea,
            JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

    public TextEditor() {

        setVisible(true);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        open.addActionListener(readFile);
        save.addActionListener(saveFile);
        print.addActionListener(printFile);
        exit.addActionListener(exitEditor);

        buttonsAndFile.add(fileName);
        buttonsAndFile.add(fileField);
        buttonsAndFile.add(open);
        buttonsAndFile.add(save);
        buttonsAndFile.add(print);
        buttonsAndFile.add(exit);

        text.add(textAreaScrollPane);

        add(buttonsAndFile, BorderLayout.EAST);
        add(text, BorderLayout.SOUTH);

        pack();
    }
    ActionListener readFile = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            readFromFile(fileField.getText());
        }
    };
    ActionListener saveFile = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            saveToFile(fileField.getText());
        }
    };
    ActionListener printFile = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                textArea.print();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    };
    ActionListener exitEditor = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    };

    public void saveToFile (String filename){
        Path p = Paths.get(filename);

        try{ if (!Files.exists(p)){ Files.createFile(p);}
        }catch (IOException e){ e.printStackTrace(); }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            textArea.write(bw);
        }catch (IOException e){ e.printStackTrace(); }

    }
    public void readFromFile (String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {

            textArea.read(br, null);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        TextEditor te = new TextEditor();
    }
}
