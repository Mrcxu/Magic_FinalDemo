import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Monster {
    public int HP;
    public int DF;
    public int ATK;
    public int coin;
    public int Exp;
    public int mon_X;
    public int mon_Y;
    public int monID;
    public String name;
    public Image monster;

    public Monster(int monID, String name, int HP, int DF, int ATK, int coin, int Exp, Image monster) {
        this.monID = monID;
        this.HP = HP;
        this.ATK = ATK;
        this.DF = DF;
        this.coin = coin;
        this.Exp = Exp;
        this.monster = monster;
        this.name = name;
    }

    public void DrawMonster(Graphics g, JPanel i, int x, int y) {
        this.mon_X = x;
        this.mon_Y = y;
        g.drawImage(monster, mon_X, mon_Y, 32, 32, (ImageObserver) i);
    }
}
