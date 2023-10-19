import javax.swing.*;
import java.awt.*;

public class Project01
{
    public static void main(String[] args) {
        JFrame frame = new JFrame("슬라임을 무찔러라!!");
        frame.setSize(350, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JButton button1 = new JButton("슬라삐");
        JButton button2 = new JButton("슬라디");
        button1.setBounds(30, 170, 122, 30);
        button2.setBounds(182, 170, 122, 30);
        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);

        JLabel label1 = new JLabel();
        label1.setBounds(30, 200, 274, 50);
        label1.setText("전쟁을 시작하도록 하지, 껄껄껄");
        label1.setHorizontalAlignment(JLabel.CENTER);
        frame.getContentPane().add(label1);

        button1.addActionListener(event -> {
            label1.setText("내 이름은 슬라삐!");
        });
        button2.addActionListener(event -> {
            label1.setText("내 이름은 슬라디!");
        });
        JLabel imgLabel1 = new JLabel();
        ImageIcon blueSlime = new ImageIcon("src/slime(blue).png");
        imgLabel1.setIcon(blueSlime);
        imgLabel1.setBounds(30, 30, 122, 130);
        imgLabel1.setHorizontalAlignment(JLabel.CENTER);
        frame.getContentPane().add(imgLabel1);

        frame.setVisible(true);
        //52부터 다시 보면 됨.
    }
}