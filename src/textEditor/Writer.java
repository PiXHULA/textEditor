package textEditor;


import javax.swing.*;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import static javax.swing.JOptionPane.showMessageDialog;

public class Writer {
    public static void WriteToFile(JComboBox comboBox, String fileName, JTextArea textArea) throws IOException {
        fileName = "src\\textEditor\\savedFiles\\" + fileName + ".txt";
        try (PrintWriter file = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(fileName, true)))) {
            file.print(textArea.getText());
            file.close();
        } catch (FileNotFoundException e) {
            showMessageDialog(null, "Filen " + fileName + " hittades inte");
        }
    }
    public static void WriteToFile(String fileName) throws IOException {
        String fileNames = "src\\textEditor\\savedFiles\\completeList\\fileName.txt";
        try (PrintWriter file = new PrintWriter(
                new BufferedWriter(
                        new FileWriter(fileNames, true)))) {
            file.print(fileName + ".txt" + "\n");
            file.close();
        }
        catch (FileNotFoundException e){
            showMessageDialog(null, "Filen " + fileName + " hittades inte");
        }
    }
}
