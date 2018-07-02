import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;


public class MSprite {
    public int m_posX = 160;
    public int m_posY = 320;
    public int m_w = 32;
    public int m_h = 32;
    public int HP =1000;
    public int DF =10;
    public int ATK =10;
    public int YKey = 1;
    public int BKey = 1;
    public int RKey = 1;
    public int coin = 0;
    public int level = 1;
    public int floor = 0;
    public int exp = 0;
    public int book = 1;
    public int jump = 1;

    public Image sprite = Toolkit.getDefaultToolkit().getImage("image/01-2.png");

    public void DrawSprite(Graphics g, JPanel i) {
        g.drawImage(sprite, m_posX, m_posY, m_w, m_h, (ImageObserver) i);
    }
}
