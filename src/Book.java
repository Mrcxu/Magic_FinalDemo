import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.util.Arrays;

public class Book extends JPanel {
    private Image image;
    private SaveMap saveMap;
    public JTextField nameBlock1, nameBlock2, nameBlock3, nameBlock4, nameBlock5, nameBlock6, nameBlock7, nameBlock8, nameBlock9, nameBlock10;
    public JTextField HPBlock1, HPBlock2, HPBlock3, HPBlock4, HPBlock5, HPBlock6, HPBlock7, HPBlock8, HPBlock9, HPBlock10;
    public JTextField ATKBlock1, ATKBlock2, ATKBlock3, ATKBlock4, ATKBlock5, ATKBlock6, ATKBlock7, ATKBlock8, ATKBlock9, ATKBlock10;
    public JTextField DFBlock1, DFBlock2, DFBlock3, DFBlock4, DFBlock5, DFBlock6, DFBlock7, DFBlock8, DFBlock9, DFBlock10;
    public JTextField CEBlock1, CEBlock2, CEBlock3, CEBlock4, CEBlock5, CEBlock6, CEBlock7, CEBlock8, CEBlock9, CEBlock10;
    public JTextField loseBlock1, loseBlock2, loseBlock3, loseBlock4, loseBlock5, loseBlock6, loseBlock7, loseBlock8, loseBlock9, loseBlock10;
    public JTextField name1, name2, name3, name4, name5, name6, name7, name8, name9, name10;
    public JTextField HP1, HP2, HP3, HP4, HP5, HP6, HP7, HP8, HP9, HP10;
    public JTextField lose1, lose2, lose3, lose4, lose5, lose6, lose7, lose8, lose9, lose10;
    public JTextField ATK1, ATK2, ATK3, ATK4, ATK5, ATK6, ATK7, ATK8, ATK9, ATK10;
    public JTextField DF1, DF2, DF3, DF4, DF5, DF6, DF7, DF8, DF9, DF10;
    public JTextField coin1, coin2, coin3, coin4, coin5, coi6, coin7, coin8, coin9, coin10;
    public JTextField exp1, exp2, exp3, exp4, exp5, exp6, exp7, exp8, exp9, exp10;
    public JTextField point1, point2, point3, point4, point5, point6, point7, point8, point9, point10;
    private LoseHP loseHP;
    int[] x;
    int h = 0;
    int k = 0;
    public JTextField[] HP = {HP1, HP2, HP3, HP4, HP5, HP6, HP7, HP8, HP9, HP10};
    public JTextField[] name = {name1, name2, name3, name4, name5, name6, name7, name8, name9, name10};
    public JTextField[] lose = {lose1, lose2, lose3, lose4, lose5, lose6, lose7, lose8, lose9, lose10};
    public JTextField[] ATK = {ATK1, ATK2, ATK3, ATK4, ATK5, ATK6, ATK7, ATK8, ATK9, ATK10};
    public JTextField[] DF = {DF1, DF2, DF3, DF4, DF5, DF6, DF7, DF8, DF9, DF10};
    public JTextField[] coin = {coin1, coin2, coin3, coin4, coin5, coi6, coin7, coin8, coin9, coin10};
    public JTextField[] exp = {exp1, exp2, exp3, exp4, exp5, exp6, exp7, exp8, exp9, exp10};
    public JTextField[] nameBlock = {nameBlock1, nameBlock2, nameBlock3, nameBlock4, nameBlock5, nameBlock6, nameBlock7, nameBlock8, nameBlock9, nameBlock10};
    public JTextField[] HPBlock = {HPBlock1, HPBlock2, HPBlock3, HPBlock4, HPBlock5, HPBlock6, HPBlock7, HPBlock8, HPBlock9, HPBlock10};
    public JTextField[] ATKBlock = {ATKBlock1, ATKBlock2, ATKBlock3, ATKBlock4, ATKBlock5, ATKBlock6, ATKBlock7, ATKBlock8, ATKBlock9, ATKBlock10};
    public JTextField[] DFBlock = {DFBlock1, DFBlock2, DFBlock3, DFBlock4, DFBlock5, DFBlock6, DFBlock7, DFBlock8, DFBlock9, DFBlock10};
    public JTextField[] CEBlock = {CEBlock1, CEBlock2, CEBlock3, CEBlock4, CEBlock5, CEBlock6, CEBlock7, CEBlock8, CEBlock9, CEBlock10};
    public JTextField[] loseBlock = {loseBlock1, loseBlock2, loseBlock3, loseBlock4, loseBlock5, loseBlock6, loseBlock7, loseBlock8, loseBlock9, loseBlock10};
    public JTextField[] point = {point1, point2, point3, point4, point5, point6, point7, point8, point9, point10};

    public Book() {
        for (int i = 0; i < HP.length; i++) {
            HP[i] = new JTextField();
            name[i] = new JTextField();
            lose[i] = new JTextField();
            nameBlock[i] = new JTextField();
            HPBlock[i] = new JTextField();
            ATK[i] = new JTextField();
            DF[i] = new JTextField();
            coin[i] = new JTextField();
            exp[i] = new JTextField();
            ATKBlock[i] = new JTextField();
            DFBlock[i] = new JTextField();
            CEBlock[i] = new JTextField();
            loseBlock[i] = new JTextField();
            point[i] = new JTextField();
        }

        loseHP = new LoseHP();
        image = Toolkit.getDefaultToolkit().getImage("image/bookBG.jpg");
        saveMap = new SaveMap();
        x = new int[11];
    }

    public void DrawBook(Map map, MSprite sprite, Graphics g, JPanel i) {
        for (int z = 1; z < 12; z++) {
            for (int j = 1; j < 12; j++) {
                g.drawImage(image, (z - 1) * 32, (j - 1) * 32, 32, 32, (ImageObserver) i);
            }
        }
        for (int z = 1; z < 12; z++) {
            for (int j = 1; j < 12; j++) {
                if (map.map[z][j] >= 49 && map.map[z][j] <= 70) {
                    k = 0;
                    for (int l = 0; l < 11; l++) {
                        if (x[l] == map.map[z][j]) {
                            k++;
                        }
                    }
                    if (k == 0) {
                        x[h] = map.map[z][j];
                        h++;
                    }
                }
            }
        }
        Arrays.sort(x, 0, h);
        for (int j = 0; j < h; j++) {
            g.drawImage(map.road, 8, j * 32 + (j + 1) * 8, 32, 32, (ImageObserver) i);
            map.monsters[x[j] - 49].DrawMonster(g, i, 8, j * 32 + (j + 1) * 8);

            nameBlock[j].setForeground(Color.WHITE);
            nameBlock[j].setBounds(48, j * 32 + (j + 1) * 8, 40, 16);
            nameBlock[j].setBackground(Color.BLACK);
            nameBlock[j].setText("名称");
            nameBlock[j].setHorizontalAlignment(JTextField.CENTER);
            nameBlock[j].setEditable(false);
            nameBlock[j].setFocusable(false);
            nameBlock[j].setBorder(null);

            HPBlock[j].setForeground(Color.WHITE);
            HPBlock[j].setBounds(48, j * 32 + (j + 1) * 8 + 16, 40, 16);
            HPBlock[j].setBackground(Color.BLACK);
            HPBlock[j].setText("生命");
            HPBlock[j].setHorizontalAlignment(JTextField.CENTER);
            HPBlock[j].setEditable(false);
            HPBlock[j].setFocusable(false);
            HPBlock[j].setBorder(null);

            ATKBlock[j].setForeground(Color.WHITE);
            ATKBlock[j].setBounds(142, j * 32 + (j + 1) * 8, 40, 16);
            ATKBlock[j].setBackground(Color.BLACK);
            ATKBlock[j].setText("攻击");
            ATKBlock[j].setHorizontalAlignment(JTextField.CENTER);
            ATKBlock[j].setEditable(false);
            ATKBlock[j].setFocusable(false);
            ATKBlock[j].setBorder(null);

            DFBlock[j].setForeground(Color.WHITE);
            DFBlock[j].setBounds(142, j * 32 + (j + 1) * 8 + 16, 40, 16);
            DFBlock[j].setBackground(Color.BLACK);
            DFBlock[j].setText("防御");
            DFBlock[j].setHorizontalAlignment(JTextField.CENTER);
            DFBlock[j].setEditable(false);
            DFBlock[j].setFocusable(false);
            DFBlock[j].setBorder(null);

            CEBlock[j].setForeground(Color.WHITE);
            CEBlock[j].setBounds(214, j * 32 + (j + 1) * 8, 40, 16);
            CEBlock[j].setBackground(Color.BLACK);
            CEBlock[j].setText("金·经");
            CEBlock[j].setHorizontalAlignment(JTextField.CENTER);
            CEBlock[j].setEditable(false);
            CEBlock[j].setFocusable(false);
            CEBlock[j].setBorder(null);

            loseBlock[j].setForeground(Color.WHITE);
            loseBlock[j].setBounds(214, j * 32 + (j + 1) * 8 + 16, 40, 16);
            loseBlock[j].setBackground(Color.BLACK);
            loseBlock[j].setText("损失");
            loseBlock[j].setHorizontalAlignment(JTextField.CENTER);
            loseBlock[j].setEditable(false);
            loseBlock[j].setFocusable(false);
            loseBlock[j].setBorder(null);

            name[j].setForeground(Color.WHITE);
            name[j].setBounds(80, j * 32 + (j + 1) * 8, 65, 16);
            name[j].setBackground(Color.BLACK);
            name[j].setText(map.monsters[x[j] - 49].name);
            name[j].setHorizontalAlignment(JTextField.CENTER);
            name[j].setEditable(false);
            name[j].setFocusable(false);
            name[j].setBorder(null);

            HP[j].setForeground(Color.WHITE);
            HP[j].setBounds(80, j * 32 + (j + 1) * 8 + 16, 65, 16);
            HP[j].setBackground(Color.BLACK);
            HP[j].setText(String.valueOf(map.monsters[x[j] - 49].HP));
            HP[j].setHorizontalAlignment(JTextField.CENTER);
            HP[j].setEditable(false);
            HP[j].setFocusable(false);
            HP[j].setBorder(null);

            ATK[j].setForeground(Color.WHITE);
            ATK[j].setBounds(174, j * 32 + (j + 1) * 8, 40, 16);
            ATK[j].setBackground(Color.BLACK);
            ATK[j].setText(String.valueOf(map.monsters[x[j] - 49].ATK));
            ATK[j].setHorizontalAlignment(JTextField.CENTER);
            ATK[j].setEditable(false);
            ATK[j].setFocusable(false);
            ATK[j].setBorder(null);

            DF[j].setForeground(Color.WHITE);
            DF[j].setBounds(174, j * 32 + (j + 1) * 8 + 16, 40, 16);
            DF[j].setBackground(Color.BLACK);
            DF[j].setText(String.valueOf(map.monsters[x[j] - 49].DF));
            DF[j].setHorizontalAlignment(JTextField.CENTER);
            DF[j].setEditable(false);
            DF[j].setFocusable(false);
            DF[j].setBorder(null);

            coin[j].setForeground(Color.WHITE);
            coin[j].setBounds(262, j * 32 + (j + 1) * 8, 25, 16);
            coin[j].setBackground(Color.BLACK);
            coin[j].setText(String.valueOf(map.monsters[x[j] - 49].coin));
            coin[j].setHorizontalAlignment(JTextField.CENTER);
            coin[j].setEditable(false);
            coin[j].setFocusable(false);
            coin[j].setBorder(null);

            exp[j].setForeground(Color.WHITE);
            exp[j].setBounds(300, j * 32 + (j + 1) * 8, 25, 16);
            exp[j].setBackground(Color.BLACK);
            exp[j].setText(String.valueOf(map.monsters[x[j] - 49].Exp));
            exp[j].setHorizontalAlignment(JTextField.CENTER);
            exp[j].setEditable(false);
            exp[j].setFocusable(false);
            exp[j].setBorder(null);

            point[j].setForeground(Color.WHITE);
            point[j].setBounds(286, j * 32 + (j + 1) * 8, 15, 16);
            point[j].setBackground(Color.BLACK);
            point[j].setText("· ");
            point[j].setHorizontalAlignment(JTextField.CENTER);
            point[j].setEditable(false);
            point[j].setFocusable(false);
            point[j].setBorder(null);

            lose[j].setForeground(Color.WHITE);
            lose[j].setBounds(262, j * 32 + (j + 1) * 8 + 16, 65, 16);
            lose[j].setBackground(Color.BLACK);
            lose[j].setHorizontalAlignment(JTextField.CENTER);
            lose[j].setEditable(false);
            lose[j].setFocusable(false);
            lose[j].setBorder(null);
            if (loseHP.loseHP(sprite, map.monsters[x[j] - 49]) >= sprite.HP) {
                lose[j].setText("????");
            } else {
                lose[j].setText(String.valueOf(loseHP.loseHP(sprite, map.monsters[x[j] - 49])));
            }
        }
    }

    public void Empty() {
        for (int j = 0; j < h; j++) {
            x[j] = 0;
        }
        h = 0;
        k = 0;
    }
}
