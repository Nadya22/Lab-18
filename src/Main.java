import  javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    private final String NAME = "Новый файл";
    private JFileChooser f = new JFileChooser();
    private JTabbedPane tabs = new JTabbedPane();
    public static void main(String[] args)  {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });

    }

    public Main(){

        JMenuBar menu = new JMenuBar();
        JMenu file = new JMenu("Файл");
        JMenuItem newFile = new JMenuItem("Создать файл");

        JMenuItem saveFile = new JMenuItem("Сохранить файл");
        file.add(newFile);

        file.add(saveFile);

        menu.add(file);

        JFrame window = new JFrame("Блокнот");
        window.setSize(800,600);

        window.setJMenuBar(menu);
       window.add(tabs);
      /*  tabs.add("Текст", new JTextArea());*/

        window.setJMenuBar(menu);
      //  window.setResizable(false);
        //window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);

        newFile.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                JTextArea text = new JTextArea();
            Scroll scroll = new Scroll(text);
            tabs.addTab(NAME, scroll);
            }
        });

        saveFile.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {

                Scroll text = (Scroll) tabs.getSelectedComponent();
                String output = text.getText();
                f.showSaveDialog(null);
                File file = f.getSelectedFile();

                try {
                    FileWriter writer = new FileWriter(file);
                    writer.write(output);
                } catch (IOException eq) {
                    eq.printStackTrace();
                    //  JOptionPane.showMessageDialog(null, output);
                }
            }
        });
    }
}




