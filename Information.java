import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class Information extends JFrame {

    private JButton bolhe, menshe;
    private JLabel info;
    private JPanel panel;
    private static ImageIcon icon = new ImageIcon("src/icon.jpg");
    private static Double randValue1 = Double.valueOf(1 + (int) (Math.random() * 99));
    private static Double  cofMen = null, cofBol = null;
    private static DecimalFormat df = new DecimalFormat("#.###");
    private static String choice = null;


    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "Вам покажут случайное число от 1 до 100.\nЧтобы победить, угадайте будет следующее\nчисло больше или меньше!\nИ не забывайте сделать ставку!", "ИГРА БОЛЬШЕ/МЕНЬШЕ", JOptionPane.INFORMATION_MESSAGE, icon);
        Information i = new Information();
    }

    public Information() {

        cofMen = 100 / randValue1;
        cofBol = 100 / (100 - randValue1);
        info = new JLabel("Ваше число = " + randValue1);
        menshe = new JButton("Меньше " + df.format(cofMen) + "x");
        bolhe = new JButton("Больше " + df.format(cofBol) + "x");

        panel = new JPanel();
        add(panel, BorderLayout.CENTER);
        panel.add(info);
        panel.add(menshe);
        panel.add(bolhe);
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(220, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        menshe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = "меньше";
                Stavka s = new Stavka();
                dispose();
            }
        });

        bolhe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                choice = "больше";
                Stavka s = new Stavka();
                dispose();
            }
        });
    }

    public Double getRandValue1()
    {
        return randValue1;
    }
    protected void setRandValue1(Double rv1)
    {
        randValue1=rv1;
    }


    public Double getCofMen()
    {
        return cofMen;
    }

    public Double getCofBol()
    {
        return cofBol;
    }

    public String getChoice()
    {
        return choice;
    }
}


