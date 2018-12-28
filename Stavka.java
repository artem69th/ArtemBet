import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.DecimalFormat;

public class Stavka extends Information {

    private static Double balance;
    private DecimalFormat df;
    private JPanel panel;
    private static JButton x5, x10,x15, x25, x50, x75, x85, x100;
    private static JLabel text;
    private static Double randValue2 = null;
    private static BufferedReader reader;
    private  static FileInputStream file;

    public Stavka() {

        try {
            file = new FileInputStream("src/balance.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line;
            line = reader.readLine();
            balance = Double.valueOf(line);


        } catch (Exception ex) {
            System.out.println("Не удалось произвести считывание с файла!");
        }

        df = new DecimalFormat("#");
        panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        x5 = new JButton("$" + (df.format(balance * 0.05)));
        x10 = new JButton("$" + (df.format(balance * 0.10)));
        x15 = new JButton("$" + (df.format(balance * 0.15)));
        x25 = new JButton("$" + (df.format(balance * 0.25)));
        x50 = new JButton("$" + (df.format(balance * 0.5)));
        x75 = new JButton("$" + (df.format(balance * 0.75)));
        x85 = new JButton("$" + (df.format(balance * 0.85)));
        x100 = new JButton("$" + (df.format(balance)));
        text = new JLabel("Баланс $" + df.format(balance));
        panel.add(text);
        panel.add(x5);
        panel.add(x10);
        panel.add(x15);
        panel.add(x25);
        panel.add(x50);
        panel.add(x75);
        panel.add(x85);
        panel.add(x100);

        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(130, 320);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        x5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Result(0.05);
                dispose();
                setRandValue1(Double.valueOf(1 + (int) (Math.random() * 99)));
                Information information = new Information();
            }
        });

        x10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Result(0.1);
                dispose();
                setRandValue1(Double.valueOf(1 + (int) (Math.random() * 99)));
                Information information = new Information();
            }
        });

        x15.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Result(0.15);
                dispose();
                setRandValue1(Double.valueOf(1 + (int) (Math.random() * 99)));
                Information information = new Information();
            }
        });

        x25.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Result(0.25);
                dispose();
                setRandValue1(Double.valueOf(1 + (int) (Math.random() * 99)));
                Information information = new Information();
            }
        });

        x50.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Result(0.5);
                dispose();
                setRandValue1(Double.valueOf(1 + (int) (Math.random() * 99)));
                Information information = new Information();
            }
        });

        x75.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Result(0.75);
                dispose();
                setRandValue1(Double.valueOf(1 + (int) (Math.random() * 99)));
                Information information = new Information();
            }
        });

        x85.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Result(0.85);
                dispose();
                setRandValue1(Double.valueOf(1 + (int) (Math.random() * 99)));
                Information information = new Information();
            }
        });

        x100.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Result(1.0);
                dispose();
                setRandValue1(Double.valueOf(1 + (int) (Math.random() * 99)));
                Information information = new Information();
            }
        });
    }

    private void Result(Double x)
    {
        randValue2 = Double.valueOf(0 + (int) (Math.random() * 100));
        df = new DecimalFormat("#");
        if(getChoice().equals("больше")) {
            if (randValue2 >= getRandValue1()) {
                balance = (balance - (balance * x)) + ((balance * x) * getCofBol());
                JOptionPane.showMessageDialog(panel, "Вы выиграли!\nВаше число = " + df.format(getRandValue1()) + "\nВторое число = " + df.format(randValue2)+ "\nТеперь ваш баланс $" + df.format(balance));
                if(balance >= 1000000)
                {
                    JOptionPane.showMessageDialog(panel,"Вы выиграли :)\nНачинаем заново!\nВаш баланс снова $1000");
                    balance = 1000.0;
                }
                try(FileWriter writer = new FileWriter("src/balance.txt", false))
                {
                    writer.write(balance +"");
                }
                catch (IOException ex) {
                    System.out.print("Ошибка при записи в файл!!!");
                }
            }

            else {
                balance = balance - ((balance * x));
                JOptionPane.showMessageDialog(panel, "Вы проиграли!\nВаше число = " + df.format(getRandValue1()) + "\nВторое число = " + df.format(randValue2)+ "\nТеперь ваш баланс $" + df.format(balance));
                if(balance == 0){
                    balance = 1000.0;
                    JOptionPane.showMessageDialog(panel,"Вы проиграли :(\nНачните игру заново!\nВаш баланс снова будет $1000");
                    System.exit(0);
                }

                try(FileWriter writer = new FileWriter("src/balance.txt", false))
                {
                    writer.write(balance +"");
                }
                catch (IOException ex) {
                    System.out.print("Ошибка при записи в файл!!!");
                }
            }
        }
        if(getChoice().equals("меньше")){
            if (randValue2 <= getRandValue1()) {
                balance = balance + ((balance * x) * getCofMen());
                JOptionPane.showMessageDialog(panel, "Вы выиграли!\nВаше число = " + df.format(getRandValue1()) + "\nВторое число = " + df.format(randValue2)+ "\nТеперь ваш баланс $" + df.format(balance));
                if(balance >= 1000000)
                {
                    JOptionPane.showMessageDialog(panel,"Вы выиграли :)\nНачинаем заново!\nВаш баланс снова $1000");
                    balance = 1000.0;
                }
                try(FileWriter writer = new FileWriter("src/balance.txt", false))
                {
                    writer.write(balance +"");
                }
                catch (IOException ex) {
                    System.out.print("Ошибка при записи в файл!!!");
                }
            }

            else {
                balance = balance - ((balance * x));
                JOptionPane.showMessageDialog(panel, "Вы проиграли!\nВаше число = " + df.format(getRandValue1()) + "\nВторое число = " + df.format(randValue2)+ "\nТеперь ваш баланс $" + df.format(balance));
                if(balance == 0){
                    balance = 1000.0;
                    JOptionPane.showMessageDialog(panel,"Вы проиграли :(\nНачните игру заново!\nВаш баланс снова будет $1000");
                    System.exit(0);
                }
                try(FileWriter writer = new FileWriter("src/balance.txt", false))
                {
                    writer.write(balance + "");
                }
                catch (IOException ex) {
                    System.out.print("Ошибка при записи в файл!!!");
                }
            }
        }
    }
}
