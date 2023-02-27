import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
public class GUI implements ActionListener
{
    JFrame frame;
    JPanel panel;
    JLabel question;
    ArrayList<JCheckBox> spiceList;
    ArrayList<String> checked;
    JButton submitButton;
    File file;
    JPanel spices;
    public GUI() throws FileNotFoundException {
        file = new File("Spices.txt");

        frame = new JFrame();
        spiceList = new ArrayList<>();
        checked = new ArrayList<>();
        Scanner in = new Scanner(file);

        while (in.hasNext()) {
            spiceList.add(new JCheckBox(in.nextLine()));
        }
        question = new JLabel("what spices would you like to use?");
        spices = new JPanel();
        spices.setLayout(new GridLayout(15,15));
        panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 1, 30 ));
        panel.setLayout(new GridLayout(1, 1));
        panel.add(question);
        for (JCheckBox spice : spiceList) {
            spices.add(spice);
            spice.addActionListener(e -> {
                if (spice.isSelected()) {
                    checked.add(spice.getText());
                }else if (!spice.isSelected()){
                    checked.remove(spice.getText());
                }
            });
        }
        submitButton = new JButton("submit");
        submitButton.addActionListener(e -> {
            if (e.getSource() == submitButton) {
                System.out.println(checked);
            }
        });

        frame.add(panel,BorderLayout.LINE_START);
        frame.add(spices,BorderLayout.AFTER_LAST_LINE);
        frame.add(submitButton,BorderLayout.AFTER_LINE_ENDS);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("GUITest");
        frame.pack();
        frame.setVisible(true);


    }
    public static void main(String[] args) throws FileNotFoundException {
        new GUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}