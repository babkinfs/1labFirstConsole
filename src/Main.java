import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import java.awt.event.*;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");
        Scanner in = new Scanner(System.in);
        System.out.print("Input a numbers:");

        System.out.println("Created GUI on EDT? " +
                SwingUtilities.isEventDispatchThread());
        JFrame f = new JFrame("Swing Paint Demo");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contents = new JPanel(new FlowLayout(FlowLayout.LEFT));

        Dimension labelSize = new Dimension(80, 18);
        Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        //Icon icon = UIManager.getIcon("OptionPane.errorIcon");
        contents.setBorder(
                BorderFactory.createTitledBorder("Text position"));
        JLabel textPosLeftTopLabel = new JLabel("Размер = ");
        textPosLeftTopLabel.setVerticalTextPosition(JLabel.TOP);
        textPosLeftTopLabel.setHorizontalTextPosition(JLabel.LEFT);
        textPosLeftTopLabel.setPreferredSize(labelSize);
        textPosLeftTopLabel.setBorder(solidBorder);
        //textPosLeftTopLabel.setIcon(icon);
        contents.add(textPosLeftTopLabel);

        MyPanel myPanel = new MyPanel();

// Создание текстовых полей
        JTextField smallField = new JTextField("300, 250, 25, 45, 20");
        //smallField.setToolTipText("Короткое поле");
        //smallField.setName("12346");
        JTextField numbers = new JTextField("0, 1, 2, 3, 4, 5, 6, 7, 8, 9");
        numbers.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){

                String[] parm = smallField.getText().replaceAll(" ", "").split(",");
                int[] koords = new int[parm.length];
                if (parm.length != parm.length){
                    //Отображение введенного текста
                    JOptionPane.showMessageDialog(null,
                            "Ошибка в количестве параметров");
                }

                for (int i=0; i< parm.length; i++){
                    koords[i] = getInteger(parm[i]);
                }
                myPanel.setX(koords[0]);
                myPanel.setY(koords[1]);
                myPanel.setWidth(koords[2]);
                myPanel.setHeight(koords[3]);
                myPanel.setOtstup(koords[4]);
                myPanel.setNumbers(numbers.getText());
                myPanel.repaint();
            };
        });
        // Настройка шрифта
        // Слушатель окончания ввода

        smallField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String[] parm = smallField.getText().replaceAll(" ", "").split(",");
                int[] koords = new int[parm.length];
                if (parm.length != parm.length){
                     //Отображение введенного текста
                     JOptionPane.showMessageDialog(null,
                             "Ошибка в количестве параметров");
                }
                for (int i=0; i< parm.length; i++){
                    koords[i] = getInteger(parm[i]);
                }
                myPanel.setX(koords[0]);
                myPanel.setY(koords[1]);
                myPanel.setWidth(koords[2]);
                myPanel.setHeight(koords[3]);
                myPanel.repaint();
            };

        });
        // Создание панели с текстовыми полями
        contents.add(numbers);
        contents.add(smallField);
        f.setContentPane(contents);
        // Определяем размер окна и выводим его на экран
        f.setSize(400, 130);
        f.setVisible(true);


        f.add(myPanel);
        f.pack();
        f.setVisible(true);
        //textField.setMaximumSize(new );
    }
    private static int getInteger(String parm){
        try {
            return Integer.parseInt(parm);
        }
        catch (Exception e){
            new Exception("Это не цифра");
        }
        return 0;
    }
}