import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Magic extends JFrame {
    private MPanel mPanel;  //左窗口
    private MCanvas mCanvas;  //右窗口
    private ImageIcon imageIcon;  //背景图
    private JLabel MBg;  //背景框
    public MSprite mSprite;
    public SaveMap saveMap;
    private MMenu mMenu;

    public Magic() {
        mSprite = new MSprite();
        saveMap = new SaveMap();
        mPanel = new MPanel(mSprite);
        mCanvas = new MCanvas(mSprite);
        mMenu = new MMenu(mSprite,mCanvas);
        imageIcon = new ImageIcon("image/back.jpg");
        MBg = new JLabel(imageIcon);
        MBg.setBounds(new Rectangle(0, 0, 576, 438));  //实例化，设置背景位置以及背景图片
        ((JPanel) this.getContentPane()).setOpaque(false);
        int w = (Toolkit.getDefaultToolkit().getScreenSize().width - 576) / 2;
        int h = (Toolkit.getDefaultToolkit().getScreenSize().height - 438) / 2;

        this.setLocation(w, h);
        this.setTitle("魔塔");  //标题
        this.setSize(576, 460);  //窗体大小
        this.setLayout(null);  //清楚默认布局
        this.setResizable(false);  //窗口不可调整
        this.getLayeredPane().add(MBg, new Integer(Integer.MIN_VALUE));  //添加背景
        this.add(mPanel);  //添加左窗口
        this.add(mCanvas);  //添加右窗口-
        mPanel.setmCanvas(mCanvas);
        this.setJMenuBar(mMenu);
        this.setVisible(true);  //窗口显示
        this.addKeyListener(mCanvas);
        this.requestFocus(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new Magic();

    }


}
