import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.util.Enumeration;

public class Project01 {
//    static Slime s = null;
    static JLabel label1, label2, imgLabel1, imgLabel2;
    static ImageIcon blueSlime, redSlime;

    static BlueSlime bs1 = new BlueSlime("JAVA");
    static RedSlime rs1 = new RedSlime("DB");
    static Human h = new Human("컴공과 학생");

    static JButton button1, button2;

    public static void main(String[] args) {

        Enumeration<Object> keys = UIManager.getDefaults().keys();
        while(keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                UIManager.put(key, new FontUIResource("굴림", 0, 14));
            }
        }

        JFrame frame = new JFrame("전공을 무찔러라!!");
        frame.setSize(350, 350);
        frame.setLocationRelativeTo((Component)null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout((LayoutManager)null);

        button1 = new JButton(bs1.name);
        button2 = new JButton(rs1.name);
        button1.setBounds(30, 170, 122, 30);
        button2.setBounds(182, 170, 122, 30);
        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);

        label1 = new JLabel();
        label1.setBounds(30, 210, 274, 50);
        label1.setText("시험을 시작하도록 하지, 캬캬컄");
        label1.setHorizontalAlignment(JLabel.CENTER);
        frame.getContentPane().add(label1);

        label2 = new JLabel();
        label2.setBounds(30, 240, 274, 50);
        label2.setText(h.name + "의 체력은 " + h.hp + "입니다");
        label2.setHorizontalAlignment(JLabel.CENTER);
        frame.getContentPane().add(label2);

        imgLabel1 = new JLabel();
        blueSlime = new ImageIcon("src/slime(blue).png");
        imgLabel1.setIcon(blueSlime);
        imgLabel1.setBounds(30, 30, 122, 130);
        imgLabel1.setHorizontalAlignment(0);
        frame.getContentPane().add(imgLabel1);

        imgLabel2 = new JLabel();
        redSlime = new ImageIcon("src/slime(red).png");
        imgLabel2.setIcon(redSlime);
        imgLabel2.setBounds(182, 30, 122, 130);
        imgLabel2.setHorizontalAlignment(0);
        frame.getContentPane().add(imgLabel2);
        frame.setVisible(true);

        button1.addActionListener((event) -> {
            battle(bs1);
        });
        button2.addActionListener((event) -> {
            battle(rs1);
        });
    }
    public static void battle(Slime s){
        int randomNum = (int)(Math.random()*3);
        if (randomNum == 0){
            label1.setText(h.name + "의 공격은 빗나갔다...!!");
        } else {
            h.attack(s);
        }

        if (s instanceof BlueSlime){
            randomNum = (int) (Math.random()*3);
            if (randomNum == 0){
                ((BlueSlime)s).heal(s);
            }else {
                s.attack(h);
            }
        } else {
            randomNum = (int) (Math.random()*3);
            if (randomNum == 0){
                ((RedSlime)s).attack2(h);
            }else {
                s.attack(h);
            }
        }

        if (bs1.hp < 1 && rs1.hp < 1){
            JOptionPane.showMessageDialog(label2, "전공 Clear");
            System.exit(0);
        }
    }
}
