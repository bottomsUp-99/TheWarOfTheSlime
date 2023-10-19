import javax.swing.*;

public class Study01
{
    public static void main(String[] args) {
        Slime s1 = new Slime("슬라삐");
        Slime s2 = new Slime("슬라돌");
        Human h = new Human("알렉스");
        System.out.println(s1.name + "와 " + s2.name + "이 나타났다! 당신의 이름은 " + h.name + "이다\n");

        int target = Integer.parseInt(JOptionPane.showInputDialog("어느 슬라임을 공격하겠습니까? 1은 " + s1.name + "2는 " + s2.name));
        if (target == 1){
            h.attack(s1.name);
            s1.attack();
        } else if (target == 2) {
            h.attack(s2.name);
            s2.attack();
        }else {
            System.out.println("올바른 숫자를 입력하세요");
        }
    }
}