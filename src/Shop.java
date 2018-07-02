import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Shop extends JPanel {
    private Image image;
    public JTextArea tip;
    public JTextField addHP;
    public JTextField addATK;
    public JTextField addDF;
    int[] x;
    int h = 0;
    int k = 0;

    public Shop() {
        image = Toolkit.getDefaultToolkit().getImage("image/bookBG.jpg");
        tip = new JTextArea("想要增加你的能力吗？如果你有25个金币，你可以任意选择一项。");
        addHP = new JTextField("增加 800 点生命");
        addATK = new JTextField("增加 4 点攻击");
        addDF = new JTextField("增加 4 点防御");

    }

    public void DrawShop(Graphics g, JPanel i) {
        for (int z = 4; z < 9; z++) {
            for (int j = 4; j < 10; j++) {
                g.drawImage(image, (z - 1) * 32, (j - 1) * 32, 32, 32, (ImageObserver) i);

                tip.setBackground(Color.BLACK);
                tip.setBounds(104, 103, 144, 50);
                tip.setForeground(Color.WHITE);
                tip.setLineWrap(true);
                tip.setFocusable(false);

                addHP.setBackground(Color.BLACK);
                addHP.setBounds(96, 176, 160, 32);
                addHP.setForeground(Color.WHITE);
                addHP.setHorizontalAlignment(JTextField.CENTER);
                addHP.setEditable(false);
                addHP.setFocusable(false);

                addATK.setBackground(Color.BLACK);
                addATK.setBounds(96, 208, 160, 32);
                addATK.setForeground(Color.WHITE);
                addATK.setHorizontalAlignment(JTextField.CENTER);
                addATK.setEditable(false);
                addATK.setFocusable(false);

                addDF.setBackground(Color.BLACK);
                addDF.setBounds(96, 240, 160, 32);
                addDF.setForeground(Color.WHITE);
                addDF.setHorizontalAlignment(JTextField.CENTER);
                addDF.setEditable(false);
                addDF.setFocusable(false);

            }
        }
    }
}
