import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class KeyPress {
    public void Keypress(MSprite mSprite, Map map, Fight fight, FloorJump floorJump, SaveMap saveMap, int a, int b) {
        if (mSprite.m_posY >= 0 && mSprite.m_posY <= 320 && mSprite.m_posX >= 0 && mSprite.m_posX <= 320) {
            if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 100 && mSprite.YKey > 0) {
                map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] = 0;
                mSprite.YKey--;
            }
            if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 101 && mSprite.BKey > 0) {
                map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] = 0;
                mSprite.BKey--;
            }
            if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 102 && mSprite.RKey > 0) {
                map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] = 0;
                mSprite.RKey--;
            }
            if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 200) {
                map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] = 0;
                mSprite.YKey++;
            }
            if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 201) {
                map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] = 0;
                mSprite.BKey++;
            }
            if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 202) {
                map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] = 0;
                mSprite.RKey++;
            }
            if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 300) {
                map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] = 0;
                mSprite.HP += 200;
            }
            if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 301) {
                map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] = 0;
                mSprite.HP += 500;
            }
            if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 71) {
                map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] = 0;
                mSprite.book = 1;
            }
            if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 72) {
                map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] = 0;
                mSprite.ATK += 3;
            }
            if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 73) {
                map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] = 0;
                mSprite.DF += 3;
            }
            if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 74) {
                map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] = 0;
                mSprite.ATK += 10;
            }
            if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 75) {
                map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] = 0;
                mSprite.ATK += 70;
            }
            if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 76) {
                map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] = 0;
                mSprite.level += 1;
                mSprite.ATK += 7;
                mSprite.DF += 7;
            }
            if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 77) {
                map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] = 0;
                mSprite.jump = 1;
            }
            if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 78) {
                map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] = 0;
                mSprite.YKey += 1;
                mSprite.BKey += 1;
                mSprite.RKey += 1;
            }
            if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 79) {
                map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] = 0;
                mSprite.DF += 10;
            }
            if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 80) {
                map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] = 0;
                mSprite.HP = mSprite.HP * 4 / 3;
                mSprite.ATK = mSprite.ATK * 4 / 3;
                mSprite.DF = mSprite.DF * 4 / 3;
            }
            if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 45) {
                Object[] options = {"拯救她！", "我放弃！"};
                int c = JOptionPane.showOptionDialog(null, "哇！啊~勇士！我终于见到你了！" + "\n" + "可是我被囚禁在这里被锁上了枷锁，快破解枷锁的密码救我出去吧！", "啊！公主手上有手铐！", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
                if (c == 0) {
                    Random random = new Random();
                    int randa = random.nextInt(100);
                    int randb = random.nextInt(100);
                    String x = randa * randb + randa - randb+"";
                    String inputValue = JOptionPane.showInputDialog(randa + " 乘 " + randb + " 加上 " + randa + " 与 " + randb + " 的差等于： \n<你只有一次回答的机会！且错误后果很严重！>");
                    if (inputValue.equals(x)) {
                        Object[] options1 = {"确认", "关于我们"};
                        int q = JOptionPane.showOptionDialog(null, "哇！勇士你智勇双全！快把我救出去！我们一起去愉快的写JAVA吧！", "“咔擦”，你扭动了枷锁上的密码锁，枷锁应声断裂。", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options1, options1[0]);
                        if (q == 0) {
                            int p = JOptionPane.showConfirmDialog(null, "游戏通关！感谢您的支持！是否退出游戏？", "恭喜！", JOptionPane.YES_NO_OPTION);
                            if (p == 0) {
                                System.exit(-1);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "我们是\t“人猿出动”组！\n 这次我们依然追随《魔塔》这款经典又有趣的游戏！\n我们集思广益，在尽可能超复原原作的风格的同时加入了我们自己的freestyle~\n看了我们的作品相信你也有一定的评分了吧！！Come on，Boy！！");
                            int p = JOptionPane.showConfirmDialog(null, "游戏通关！感谢您的支持！是否退出游戏？", "恭喜！", JOptionPane.YES_NO_OPTION);
                            if (p == 0) {
                                System.exit(-1);
                            }
                        }
                    } else if (!inputValue.equals(x)) {
                        System.out.println(inputValue);
                        System.out.println(randa * randb + randa - randb);
                        JOptionPane.showMessageDialog(null, "游戏通关失败！功亏一篑！");
                        System.exit(-1);
                    }
                } else if (c == 1) {
                    JOptionPane.showMessageDialog(null, "游戏通关失败！功亏一篑！");
                    System.exit(-1);
                }
            }

            fight.Fighting(mSprite, map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b], map, a, b);

        }

        if (a == 1) {
            mSprite.sprite = Toolkit.getDefaultToolkit().getImage("image/01-1.png");
            if (mSprite.m_posY / 32 + 1 < 11) {
                if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 0 || map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] >= 1000) {
                    mSprite.m_posY += 32;
                }
            }
        }
        if (a == -1) {
            mSprite.sprite = Toolkit.getDefaultToolkit().getImage("image/01-2.png");
            if (mSprite.m_posY / 32 - 1 < 11) {
                if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 0 || map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] >= 1000) {
                    mSprite.m_posY -= 32;
                }
            }
        }
        if (b == 1) {
            mSprite.sprite = Toolkit.getDefaultToolkit().getImage("image/01-4.png");
            if (mSprite.m_posX / 32 + 1 < 11) {
                if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 0 || map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] >= 1000) {
                    mSprite.m_posX += 32;
                }
            }
        }
        if (b == -1) {
            mSprite.sprite = Toolkit.getDefaultToolkit().getImage("image/01-3.png");
            if (mSprite.m_posX / 32 - 1 < 11) {
                if (map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] == 0 || map.map[mSprite.m_posY / 32 + 1 + a][mSprite.m_posX / 32 + 1 + b] >= 1000) {
                    mSprite.m_posX -= 32;
                }
            }
        }


        if (map.map[mSprite.m_posY / 32 + 1][mSprite.m_posX / 32 + 1] >= 1000 && map.map[mSprite.m_posY / 32 + 1][mSprite.m_posX / 32 + 1] < 3000)

        {
            floorJump.Jump(map.map[mSprite.m_posY / 32 + 1][mSprite.m_posX / 32 + 1], map, saveMap, mSprite);
        }
    }
}