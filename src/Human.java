import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Human
{
    String name;
    int hp = 100;
    public Human(String n){
        name = n;
    }
    public void attack(Slime s){
        ImageIcon blueSlime_fire = new ImageIcon("src/slime2(blue).png");
        ImageIcon redSlime_fire = new ImageIcon("src/slime2(red).png");

        if (s == Project01.bs1){
            Project01.imgLabel1.setIcon(blueSlime_fire);
        } else {
            Project01.imgLabel2.setIcon(redSlime_fire);
        }
        java.util.Timer timer1 = new Timer();
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                Project01.imgLabel1.setIcon(Project01.blueSlime);
                Project01.imgLabel2.setIcon(Project01.redSlime);
                timer1.cancel();
            }
        };
        timer1.schedule(task1, 500);

        s.hp = s.hp - 30;
        if (s.hp < 1){
            if (s == Project01.bs1){
                Project01.button1.setEnabled(false);
            } else {
                Project01.button2.setEnabled(false);
            }
            Project01.label1.setText(s.name + "를 마스터했다!!ㅜㅜ");
            Project01.label2.setText("");
        } else {
            Project01.label1.setText(name + "의 공격. " + s.name + "의 체력은 " + s.hp + " ");
        }
    }
}
