import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class MPanel extends JPanel implements Runnable, ActionListener {
    private Thread t;
    private MSprite mSprite;

    public void setmCanvas(MCanvas mCanvas) {
        this.mCanvas = mCanvas;
    }

    private MCanvas mCanvas;
    private Map map = new Map();
    private SaveMap saveMap = new SaveMap();
    private Save save = new Save();
    private Read read = new Read();
    private JPanel infoAllPanel = new JPanel(new BorderLayout());
    private JPanel infoPanel = new JPanel(new GridLayout(5, 2, 0, 0));
    private JPanel info_level = new JPanel(new FlowLayout());
    private JPanel keyPanel = new JPanel(new GridLayout(3, 4, 3, 3));
    private JPanel floorPanel = new JPanel(new GridLayout(1, 3, 4, 4));
    private JPanel contrlPanel = new JPanel(new GridLayout(2, 2, 0, 0));
    private Border border = new EtchedBorder(EtchedBorder.RAISED, Color.white, new Color(255, 150, 0));
    private Image sprite = Toolkit.getDefaultToolkit().getImage("image/01-1.png");
    private Image YKey = Toolkit.getDefaultToolkit().getImage("image/YKey.png");
    private Image BKey = Toolkit.getDefaultToolkit().getImage("image/BKey.png");
    private Image RKey = Toolkit.getDefaultToolkit().getImage("image/RKey.png");
    private JLabel label_HP = new JLabel(" 生命"),
            label_ATK = new JLabel(" 攻击"),
            label_DF = new JLabel(" 防御"),
            label_COIN = new JLabel(" 金钱"),
            label_EXP = new JLabel(" 经验"),
            label_GE1 = new JLabel(" 个"),
            label_GE2 = new JLabel(" 个"),
            label_GE3 = new JLabel(" 个"),
            label_JI = new JLabel(" 级"),
            label_DI = new JLabel("  第"),
            label_CENG = new JLabel("层"),
            label_A = new JLabel("         "),
            label_B = new JLabel("         "),
            label_C = new JLabel("         "),
            label_a = new JLabel("         "),
            label_b = new JLabel("         "),
            label_c = new JLabel("         "),
            jtf_level = new JLabel(),
            jtf_HP = new JLabel(),
            jtf_ATK = new JLabel(),
            jtf_DF = new JLabel(),
            jtf_COIN = new JLabel(),
            jtf_EXP = new JLabel(),
            jtf_YKEY = new JLabel(),
            jtf_BKEY = new JLabel(),
            jtf_RKEY = new JLabel(),
            jtf_floor = new JLabel();

    private JButton jb_save = new JButton("保存"),
            jb_quit = new JButton("退出"),
            jb_read = new JButton("读取"),
            jb_restart = new JButton("重玩");


    public MPanel(MSprite aaa) {
        t = new Thread(this);
        t.start();
        mSprite = aaa;
        this.setBounds(32, 32, 128, 352);
        this.add(infoAllPanel);
        this.add(keyPanel);
        this.add(floorPanel);
        this.add(contrlPanel);
        this.add(label_HP);

        infoAllPanel.setPreferredSize(new Dimension(128, 150));
        keyPanel.setPreferredSize(new Dimension(128, 96));
        floorPanel.setPreferredSize(new Dimension(128, 28));
        contrlPanel.setPreferredSize(new Dimension(128, 58));
        label_HP.setFont(new Font("黑体", Font.BOLD, 14));
        label_ATK.setFont(new Font("黑体", Font.BOLD, 14));
        label_DF.setFont(new Font("黑体", Font.BOLD, 14));
        label_COIN.setFont(new Font("黑体", Font.BOLD, 14));
        label_EXP.setFont(new Font("黑体", Font.BOLD, 14));
        label_GE1.setFont(new Font("黑体", Font.BOLD, 14));
        label_GE2.setFont(new Font("黑体", Font.BOLD, 14));
        label_GE3.setFont(new Font("黑体", Font.BOLD, 14));
        label_JI.setFont(new Font("黑体", Font.BOLD, 14));
        label_DI.setFont(new Font("黑体", Font.BOLD, 14));
        label_CENG.setFont(new Font("黑体", Font.BOLD, 14));
        jtf_level.setFont(new Font("黑体", Font.BOLD, 16));
        jtf_HP.setFont(new Font("黑体", Font.BOLD, 16));
        jtf_ATK.setFont(new Font("黑体", Font.BOLD, 16));
        jtf_DF.setFont(new Font("黑体", Font.BOLD, 16));
        jtf_COIN.setFont(new Font("黑体", Font.BOLD, 16));
        jtf_EXP.setFont(new Font("黑体", Font.BOLD, 16));
        jtf_YKEY.setFont(new Font("黑体", Font.BOLD, 16));
        jtf_BKEY.setFont(new Font("黑体", Font.BOLD, 16));
        jtf_RKEY.setFont(new Font("黑体", Font.BOLD, 16));
        jtf_floor.setFont(new Font("黑体", Font.BOLD, 16));
        label_HP.setForeground(Color.white);
        label_ATK.setForeground(Color.white);
        label_DF.setForeground(Color.white);
        label_COIN.setForeground(Color.white);
        label_EXP.setForeground(Color.white);
        label_GE1.setForeground(Color.white);
        label_GE2.setForeground(Color.white);
        label_GE3.setForeground(Color.white);
        label_JI.setForeground(Color.white);
        label_DI.setForeground(Color.white);
        label_CENG.setForeground(Color.white);
        jtf_level.setForeground(Color.white);
        jtf_HP.setForeground(Color.white);
        jtf_ATK.setForeground(Color.white);
        jtf_DF.setForeground(Color.white);
        jtf_COIN.setForeground(Color.white);
        jtf_EXP.setForeground(Color.white);
        jtf_YKEY.setForeground(Color.white);
        jtf_BKEY.setForeground(Color.white);
        jtf_RKEY.setForeground(Color.white);
        jtf_floor.setForeground(Color.white);


        infoAllPanel.add(info_level, BorderLayout.NORTH);
        infoAllPanel.add(infoPanel, BorderLayout.CENTER);
        info_level.add(label_A);
        info_level.add(label_b);
        info_level.add(jtf_level);
        info_level.add(label_JI);
        infoPanel.add(label_HP);
        infoPanel.add(jtf_HP);
        infoPanel.add(label_ATK);
        infoPanel.add(jtf_ATK);
        infoPanel.add(label_DF);
        infoPanel.add(jtf_DF);
        infoPanel.add(label_COIN);
        infoPanel.add(jtf_COIN);
        infoPanel.add(label_EXP);
        infoPanel.add(jtf_EXP);
        infoAllPanel.setBorder(border);
        infoAllPanel.setOpaque(false);
        infoPanel.setOpaque(false);
        info_level.setOpaque(false);

        keyPanel.add(label_A);
        keyPanel.add(label_a);
        keyPanel.add(jtf_YKEY);
        keyPanel.add(label_GE1);
        keyPanel.add(label_B);
        keyPanel.add(label_b);
        keyPanel.add(jtf_BKEY);
        keyPanel.add(label_GE2);
        keyPanel.add(label_C);
        keyPanel.add(label_c);
        keyPanel.add(jtf_RKEY);
        keyPanel.add(label_GE3);
        keyPanel.setBorder(border);
        keyPanel.setOpaque(false);

        floorPanel.add(label_DI);
        floorPanel.add(jtf_floor);
        floorPanel.add(label_CENG);
        floorPanel.setBorder(border);
        floorPanel.setOpaque(false);

        contrlPanel.add(jb_save);
        jb_save.addActionListener(this);
        jb_save.setFocusable(false);
        contrlPanel.add(jb_quit);
        jb_quit.addActionListener(this);
        jb_quit.setFocusable(false);
        contrlPanel.add(jb_read);
        jb_read.addActionListener(this);
        jb_read.setFocusable(false);
        contrlPanel.add(jb_restart);
        jb_restart.addActionListener(this);
        jb_restart.setFocusable(false);
        contrlPanel.setBorder(border);
        contrlPanel.setOpaque(false);


    }

    public void paintComponent(Graphics g) {
        ImageIcon icon =
                new ImageIcon("image/02.jpg");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 11; j++)
                g.drawImage(icon.getImage(), i * 32, j * 32 + 6, 32, 32, infoAllPanel);
        }
        g.drawImage(sprite, 5, 10, 20, 20, info_level);
        g.drawImage(YKey, 10, 160, 32, 32, keyPanel);
        g.drawImage(BKey, 10, 192, 32, 32, keyPanel);
        g.drawImage(RKey, 10, 224, 32, 32, keyPanel);
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.getStackTrace();
            }
            jtf_level.setText(String.valueOf(mSprite.level));
            jtf_HP.setText(String.valueOf(mSprite.HP));
            jtf_ATK.setText(String.valueOf(mSprite.ATK));
            jtf_DF.setText(String.valueOf(mSprite.DF));
            jtf_COIN.setText(String.valueOf(mSprite.coin));
            jtf_EXP.setText(String.valueOf(mSprite.exp));
            jtf_YKEY.setText(String.valueOf(mSprite.YKey));
            jtf_BKEY.setText(String.valueOf(mSprite.BKey));
            jtf_RKEY.setText(String.valueOf(mSprite.RKey));
            jtf_floor.setText(String.valueOf(" " + mSprite.floor));
        }
    }

    public void restart() {
        mSprite = null;
        map = null;
        saveMap = null;
        mSprite = new MSprite();
        map = new Map();
        saveMap = new SaveMap();
        mCanvas.setmSprite(mSprite);
        mCanvas.setMap(map);
        mCanvas.setSaveMap(saveMap);
        mCanvas.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jb_save) {
            Object[] possibleValues = {"存档 1 ", "存档 2 ", "存档 3 "};
            Object selectedValue = JOptionPane.showInputDialog(null, "你要保存在哪个存档~", "保存游戏",
                    JOptionPane.INFORMATION_MESSAGE, null, possibleValues, possibleValues[0]);
            if (selectedValue == possibleValues[0] ) {
                File file = new File("save1.dat");
                if (!file.exists()) {
                    save.save(1, mSprite, mCanvas);
                    JOptionPane.showMessageDialog(null, "保存成功！", "保存成功！", JOptionPane.PLAIN_MESSAGE);
                } else{
                    int a = JOptionPane.showConfirmDialog(null, "是否覆盖游戏存档？", "此存档有内容", JOptionPane.YES_OPTION);
                    if (a == 0) {
                        save.save(1, mSprite, mCanvas);
                        JOptionPane.showMessageDialog(null, "覆盖保存成功！", "保存成功！", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            } else if (selectedValue == possibleValues[1]) {
                File file = new File("save2.dat");
                if (!file.exists()) {
                    save.save(2, mSprite, mCanvas);
                    JOptionPane.showMessageDialog(null, "保存成功！", "保存成功！", JOptionPane.PLAIN_MESSAGE);
                } else {
                    int a = JOptionPane.showConfirmDialog(null, "是否覆盖游戏存档？", "此存档有内容", JOptionPane.YES_OPTION);
                    if (a == 0) {
                        save.save(2, mSprite, mCanvas);
                        JOptionPane.showMessageDialog(null, "覆盖保存成功！", "保存成功！", JOptionPane.PLAIN_MESSAGE);
                    }
                }
            } else if (selectedValue == possibleValues[2]) {
                File file = new File("save3.dat");
                if (!file.exists()) {
                    save.save(3, mSprite, mCanvas);
                    JOptionPane.showMessageDialog(null, "保存成功！", "保存成功！", JOptionPane.PLAIN_MESSAGE);
                }
            } else {
                int a = JOptionPane.showConfirmDialog(null, "是否覆盖游戏存档？", "此存档有内容", JOptionPane.YES_OPTION);
                if (a == 0) {
                    save.save(3, mSprite, mCanvas);
                    JOptionPane.showMessageDialog(null, "覆盖保存成功！", "保存成功！", JOptionPane.PLAIN_MESSAGE);
                }
            }


        } else if (e.getSource() == jb_read)

        {
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
        } else if (e.getSource() == jb_restart)

        {
            int a = JOptionPane.showConfirmDialog(null, "是否重玩游戏？（警告！重玩后无法进行作弊！请认真游戏！）", "重玩游戏", JOptionPane.YES_OPTION);
            if (a == 0) {
                this.restart();
            }
        } else if (e.getSource() == jb_quit)

        {
            int b = JOptionPane.showConfirmDialog(null, "是否退出游戏？", "退出游戏", JOptionPane.YES_OPTION);
            if (b == 0) {
                System.exit(-1);
            } else {
                setVisible(true);

            }
        }

    }
}
