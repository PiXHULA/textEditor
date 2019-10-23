package textEditor;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.IOException;

public class textEditor extends JFrame {
    JPanel p = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel label = new JLabel("Filename: ");
    JTextArea textArea = new JTextArea(10,60);
    JTextField textField = new JTextField("",15);
    JComboBox<String> comboBox = new JComboBox();
    JButton open = new JButton("Open file");
    JButton save = new JButton("Save file");
    JButton print = new JButton("Print file");
    JButton exit = new JButton("Exit");
    JScrollPane scrollPane = new JScrollPane(textArea);
    static String [] fileNames = new String[30];


    Color c1 = new Color (165, 204, 197);
    Color c2 = new Color (78,153,139);
    Color c3 = new Color (232,255,255);

    public textEditor() throws IOException {
        Reader.ReadFromFile();
        JFrame jf = new JFrame();
        jf.setSize(800,600);
        jf.add(p);
        p.setLayout(new BorderLayout());
        p.add(scrollPane, BorderLayout.CENTER);
        p.add(buttonPanel, BorderLayout.NORTH);
        fileNames[0] = "                             ";
        comboBox = new JComboBox(textEditor.fileNames);
        comboBox.setSelectedIndex(-1);
        comboBox.setEditable(true);
        comboBox.setBackground(c3);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        textArea.setBackground(c3);
        textArea.setLineWrap(true);
        buttonPanel.setBackground(c1);
        textField.setBackground(c3);
        open.setBackground(c2);
        save.setBackground(c2);
        print.setBackground(c2);
        exit.setBackground(c2);

        buttonPanel.add(label);
        //buttonPanel.add(textField);
        buttonPanel.add(comboBox);
        buttonPanel.add(open);
        buttonPanel.add(save);
        buttonPanel.add(print);
        buttonPanel.add(exit);
        open.addActionListener(actionListener);
        save.addActionListener(actionListener);
        exit.addActionListener(actionListener);
        print.addActionListener(actionListener);

        jf.setVisible(true);

    }
    ActionListener actionListener = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == exit)
                System.exit(0);
            else if (e.getSource() == print) {
                try {
                    textArea.print();
                } catch (PrinterException ex) {
                    ex.printStackTrace();
                }
            }
            else if (e.getSource() == open) {
                try {
                    Reader.ReadFromFile(comboBox.getSelectedItem().toString(),textArea);
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            else if (e.getSource() == save) {
                try {
                    Writer.WriteToFile(comboBox, comboBox.getSelectedItem().toString(),textArea);
                    Writer.WriteToFile(comboBox.getSelectedItem().toString());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }


        }
    };
    public static void main(String[] args) throws IOException {
        textEditor ö4 = new textEditor();
    }
}
