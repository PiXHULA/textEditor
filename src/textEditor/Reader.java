package textEditor;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import static javax.swing.JOptionPane.*;

public class Reader {
    public static void ReadFromFile(String fileName, JTextArea textArea) throws IOException {
        //Argument should be fileName without suffix
        //Remember to put file in src\com\Database
        Path path = Paths.get("src\\textEditor\\savedFiles\\" + fileName + ".txt");
        try (FileReader fr = new FileReader(String.valueOf(path))) {
            textArea.read(fr, null);
        } catch (IOException e) {
            showMessageDialog(null, "Filen " + path.toString() + " hittades inte");
        }
    }

    public static void ReadFromFile() throws IOException {
        int counter = 1;
        Path path = Paths.get("src\\textEditor\\savedFiles\\completeList\\fileName.txt");
        try (Scanner sc = new Scanner(path)) {
            while (sc.hasNextLine()) {
                textEditor.fileNames[counter] = sc.nextLine();
                counter++;
            }
        } catch (IOException e) {
            showMessageDialog(null, "Filen " + path.toString() + " hittades inte");
        }
    }
}

