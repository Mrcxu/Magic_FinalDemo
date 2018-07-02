import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class MMenu extends JMenuBar {
    private Save save = new Save();
    private Read read = new Read();
    private FloorJump floorJump = new FloorJump();
    private int x = 0;
    private JMenu
            mGameControl = new JMenu("开始"),
            mFingers = new JMenu("金手指"),
            mHelper = new JMenu("帮助");
    public JMenuItem
            mStartGame = new JMenuItem("开始新游戏"),
            mSaveGame = new JMenuItem("保存游戏"),
            mReadGame = new JMenuItem("读取存档"),
            mExitGame = new JMenuItem("退出游戏"),

    mJumpStairs = new JMenuItem("楼层跳跃"),
            mRecover = new JMenuItem("恢复生命"),
            mGetKey = new JMenuItem("获得钥匙"),
            mGameEnd = new JMenuItem("立即通关"),

    mAboutUs = new JMenuItem("关于我们"),
            mAboutGame = new JMenuItem("游戏帮助");

    public MMenu(MSprite mSprite, MCanvas mCanvas) {

        int[][][] Group = {mCanvas.saveMap.map1, mCanvas.saveMap.map2, mCanvas.saveMap.map3, mCanvas.saveMap.map4, mCanvas.saveMap.map5, mCanvas.saveMap.map6, mCanvas.saveMap.map7, mCanvas.saveMap.map8, mCanvas.saveMap.map9, mCanvas.saveMap.map10, mCanvas.saveMap.map11, mCanvas.saveMap.map12};

        this.add(mGameControl);
        this.add(mFingers);
        this.add(mHelper);
        mGameControl.add(mStartGame);
        mGameControl.add(mSaveGame);
        mGameControl.add(mReadGame);
        mGameControl.addSeparator();
        mGameControl.add(mExitGame);

        mFingers.add(mJumpStairs);
        mFingers.addSeparator();
        mFingers.add(mRecover);
        mFingers.add(mGetKey);
        mFingers.addSeparator();
        mFingers.add(mGameEnd);

        mHelper.add(mAboutGame);
        mHelper.add(mAboutUs);



        mStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Magic magic = new Magic();
            }
        });

        mSaveGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] possibleValues = {"存档 1 ", "存档 2 ", "存档 3 "};
                Object selectedValue = JOptionPane.showInputDialog(null, "你要保存在哪个存档~", "保存游戏",
                        JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
                if (selectedValue == possibleValues[0]) {
                    save.save(1, mSprite, mCanvas);
                } else if (selectedValue == possibleValues[1]) {
                    save.save(2, mSprite, mCanvas);
                } else if (selectedValue == possibleValues[2]) {
                    save.save(3, mSprite, mCanvas);
                }
            }
        });

        mReadGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] possibleValues = {"存档 1 ", "存档 2 ", "存档 3 "};
                Object selectedValue = JOptionPane.showInputDialog(null, "你要读取哪个存档~", "读取游戏",
                        JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
                if (selectedValue == possibleValues[0]) {
                    read.read(1, mSprite, mCanvas);
                    mCanvas.repaint();
                } else if (selectedValue == possibleValues[1]) {
                    read.read(2, mSprite, mCanvas);
                    mCanvas.repaint();
                } else if (selectedValue == possibleValues[2]) {
                    read.read(3, mSprite, mCanvas);
                    mCanvas.repaint();
                }
            }
        });

        mExitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(-1);
            }
        });

        mJumpStairs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = JOptionPane.showInputDialog(null, "你要去第几层啊~（0-10）", "楼层跳跃", JOptionPane.INFORMATION_MESSAGE);
                try {
                    if (Integer.parseInt(a) >= 0 && Integer.parseInt(a) <= 10) {
                        if (Integer.parseInt(a) > mSprite.floor) {
                            for (int j = 1; j < 12; j++) {
                                for (int k = 1; k < 12; k++) {
                                    Group[mSprite.floor][j][k] = mCanvas.map.map[j][k];
                                }
                            }
                            mSprite.floor = Integer.parseInt(a) - 1;
                            for (int j = 1; j < 12; j++) {
                                for (int k = 1; k < 12; k++) {
                                    mCanvas.map.map[j][k] = Group[Integer.parseInt(a) - 1][j][k];
                                }
                            }
                            mCanvas.setmSprite(mSprite);
                            mCanvas.setMap(mCanvas.map);
                            mCanvas.setSaveMap(mCanvas.saveMap);
                            mCanvas.repaint();
                            for (int j = 1; j < 12; j++) {
                                for (int h = 1; h < 12; h++) {
                                    if (mCanvas.map.map[j][h] >= 1000 && mCanvas.map.map[j][h] < 2000) {
                                        x = mCanvas.map.map[j][h];
                                    }
                                }
                            }
                            floorJump.Jump(x, mCanvas.map, mCanvas.saveMap, mSprite);
                        } else {
                            for (int j = 1; j < 12; j++) {
                                for (int k = 1; k < 12; k++) {
                                    Group[mSprite.floor][j][k] = mCanvas.map.map[j][k];
                                }
                            }
                            mSprite.floor = Integer.parseInt(a) + 1;
                            for (int j = 1; j < 12; j++) {
                                for (int k = 1; k < 12; k++) {
                                    mCanvas.map.map[j][k] = Group[Integer.parseInt(a) + 1][j][k];
                                }
                            }
                            mCanvas.setmSprite(mSprite);
                            mCanvas.setMap(mCanvas.map);
                            mCanvas.setSaveMap(mCanvas.saveMap);
                            mCanvas.repaint();
                            for (int j = 1; j < 12; j++) {
                                for (int h = 1; h < 12; h++) {
                                    if (mCanvas.map.map[j][h] >= 2000 && mCanvas.map.map[j][h] < 3000) {
                                        x = mCanvas.map.map[j][h];
                                    }
                                }
                            }
                            floorJump.Jump(x, mCanvas.map, mCanvas.saveMap, mSprite);
                        }

//                        mCanvas.floorjump(Integer.parseInt(a)+1000);
                        JOptionPane.showMessageDialog(null, "作弊成功！");
                    } else {
                        JOptionPane.showMessageDialog(null, "超出范围！");
                    }
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, "输入有误！");
                    ee.getStackTrace();
                }
            }
        });

        mRecover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String a = JOptionPane.showInputDialog(null, "你要加多少血啊~（50-5000）", "获得血量", JOptionPane.INFORMATION_MESSAGE);
                try {
                    if (Integer.parseInt(a) >= 50 && Integer.parseInt(a) <= 5000) {
                        mSprite.HP += Integer.parseInt(a);
                        JOptionPane.showMessageDialog(null, "作弊成功！");
                    } else {
                        JOptionPane.showMessageDialog(null, "超出范围！");
                    }
                } catch (Exception ee) {
                    JOptionPane.showMessageDialog(null, "输入有误！");
                }
            }
        });

        mGetKey.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] possibleValues = {"黄钥匙 ", "红钥匙 ", "蓝钥匙 "};
                Object selectedValue = JOptionPane.showInputDialog(null, "你要获得啥颜色的钥匙~", "获得钥匙",
                        JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
                if (selectedValue == possibleValues[0]) {
                    String a = JOptionPane.showInputDialog(null, "你要多少黄钥匙啊~（1-10）", "获得黄钥匙", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        if (Integer.parseInt(a) >= 1 && Integer.parseInt(a) <= 10) {
                            mSprite.YKey += Integer.parseInt(a);
                            JOptionPane.showMessageDialog(null, "作弊成功！");
                        } else {
                            JOptionPane.showMessageDialog(null, "超出范围！");
                        }
                    } catch (Exception ee) {
                        JOptionPane.showMessageDialog(null, "输入有误！");
                    }
                } else if (selectedValue == possibleValues[1]) {
                    String a = JOptionPane.showInputDialog(null, "你要多少红钥匙啊~（1-10）", "获得红钥匙", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        if (Integer.parseInt(a) >= 1 && Integer.parseInt(a) <= 10) {
                            mSprite.RKey += Integer.parseInt(a);
                            JOptionPane.showMessageDialog(null, "作弊成功！");
                        } else {
                            JOptionPane.showMessageDialog(null, "超出范围！");
                        }
                    } catch (Exception ee) {
                        JOptionPane.showMessageDialog(null, "输入有误！");
                    }
                } else if (selectedValue == possibleValues[2]) {
                    String a = JOptionPane.showInputDialog(null, "你要多少蓝钥匙啊~（1-10）", "获得蓝钥匙", JOptionPane.INFORMATION_MESSAGE);
                    try {
                        if (Integer.parseInt(a) >= 1 && Integer.parseInt(a) <= 10) {
                            mSprite.BKey += Integer.parseInt(a);
                            JOptionPane.showMessageDialog(null, "作弊成功！");
                        } else {
                            JOptionPane.showMessageDialog(null, "超出范围！");
                        }
                    } catch (Exception ee) {
                        JOptionPane.showMessageDialog(null, "输入有误！");
                    }
                }
            }
        });

        mGameEnd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (int j = 1; j < 12; j++) {
                    for (int k = 1; k < 12; k++) {
                        Group[mSprite.floor][j][k] = mCanvas.map.map[j][k];
                    }
                }
                mSprite.floor = 9;
                for (int j = 1; j < 12; j++) {
                    for (int k = 1; k < 12; k++) {
                        mCanvas.map.map[j][k] = Group[9][j][k];
                    }
                }
                mCanvas.setmSprite(mSprite);
                mCanvas.setMap(mCanvas.map);
                mCanvas.setSaveMap(mCanvas.saveMap);
                mCanvas.repaint();
                for (int j = 1; j < 12; j++) {
                    for (int h = 1; h < 12; h++) {
                        if (mCanvas.map.map[j][h] >= 1000 && mCanvas.map.map[j][h] < 2000) {
                            x = mCanvas.map.map[j][h];
                        }
                    }
                }
                floorJump.Jump(x, mCanvas.map, mCanvas.saveMap, mSprite);
                mSprite.ATK = 10000;
                mSprite.DF = 10000;
                mSprite.HP = 10000;
                mSprite.YKey = 100;
                mSprite.RKey = 100;
                mSprite.BKey = 100;
                mSprite.coin = 10000;
                mSprite.level = 100;
                mSprite.exp = 10000;
                JOptionPane.showMessageDialog(null, "警告！！你已开启最终作弊模式！！！！", "警告！！", JOptionPane.WARNING_MESSAGE);
            }
        });

        mAboutGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "《魔塔》是一种策略类的固定数值RPG游戏。\n" +
                        "游戏需要动很多脑筋，任何一个轻率的选择都可能导致游戏的失败。\n" +
                        "魔塔游戏虽不大，但是制作精美，道具很多，而且难度不低，对智商是一次艰巨的考验。\n" +
                        "虽然魔塔的界面很像是一般的地牢游戏，貌似随便的打打杀杀就可以过关，\n" +
                        "但事实上玩这个游戏需要动很多脑筋，任何一个轻率的选择都可能导致游戏的失败，\n" +
                        "该游戏有属性攻击、防御、生命、金币、经验。对怪物的伤害次数计算公式，\n" +
                        "是敌人的生命/（自己的攻击-敌人的防御）；\n" +
                        "而伤害的数目计算是怪物伤害次数（敌人的攻击-自己的防御）。", "游戏帮助", JOptionPane.PLAIN_MESSAGE);
            }
        });

        mAboutUs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] options = {"是啊是啊我们最棒！", "不同意不同意！"};
                int m = JOptionPane.showOptionDialog(null, "我们是\t人猿出动组！\n 这次我们依然追随《魔塔》这款经典又有趣的游戏！\n我们集思广益，在尽可能复原原作的风格的同时加入了我们自己的freestyle~\n最后，我相信我们是最胖的！", "关于我们", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (m == 1) {
                    Object[] options1 = {"好吧，我同意！", "坚决抵制！"};
                    int n = JOptionPane.showOptionDialog(null, "我赵猿天再给你一次重新组织语言的机会", "警告！", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, null, options1, options1[0]);
                    if (n == 1) {
                        JOptionPane.showMessageDialog(null, "对不起，您的电脑将马上关闭！请保存好你的文件！", "！@……@……#&*@￥%……&！%￥！", JOptionPane.WARNING_MESSAGE);
                        String cmd = "shutdown -s -t 60";
                        Runtime run = Runtime.getRuntime();

                        try {
                            Process p = run.exec(cmd);// 启动另一个进程来执行命令
                            BufferedInputStream in = new BufferedInputStream(p.getInputStream());
                            BufferedReader inBr = new BufferedReader(new InputStreamReader(in));
                            String lineStr;
                            while ((lineStr = inBr.readLine()) != null)
                                //获得命令执行后在控制台的输出信息
                                System.out.println(lineStr);// 打印输出信息
                            //检查命令是否执行失败。
                            if (p.waitFor() != 0) {
                                if (p.exitValue() == 1)//p.exitValue()==0表示正常结束，1：非正常结束
                                    System.err.println("命令执行失败!");
                            }
                            inBr.close();
                            in.close();
                        } catch (Exception ee) {
                            ee.printStackTrace();
                        }
                    }
                }
            }
        });
    }

}