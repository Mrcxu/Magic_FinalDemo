import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MCanvas extends JPanel implements KeyListener, MouseListener {
    public MapPackge mapPackge;
    public Fight fight;
    public MSprite mSprite;  //角色
    public Map map;
    public SaveMap saveMap;
    private FloorJump floorJump;
    private KeyPress keyPress;
    public Book book;
    public Shop shop;
    int h;
    int k;
    int x[];
    String VK;
    String VK1;

    public MCanvas(MSprite aaa) {
        x = new int[11];
        mapPackge = new MapPackge();
        saveMap = new SaveMap();
        map = new Map();
        mSprite = aaa;
        fight = new Fight();
        floorJump = new FloorJump();
        keyPress = new KeyPress();
        book = new Book();
        shop = new Shop();
        VK = "";
        VK1 = "";
        this.add(shop.addHP);
        this.add(shop.addATK);
        this.add(shop.addDF);
        this.add(shop.tip);
        shop.addHP.setVisible(false);
        shop.addATK.setVisible(false);
        shop.addDF.setVisible(false);
        shop.tip.setVisible(false);
        shop.addHP.addMouseListener(this);
        shop.addATK.addMouseListener(this);
        shop.addDF.addMouseListener(this);

        this.setBounds(192, 32, 352, 352);
        for (int i = 0; i < 10; i++) {
            this.add(book.nameBlock[i]);
            this.add(book.HPBlock[i]);
            this.add(book.ATKBlock[i]);
            this.add(book.DFBlock[i]);
            this.add(book.CEBlock[i]);
            this.add(book.loseBlock[i]);
            this.add(book.name[i]);
            this.add(book.HP[i]);
            this.add(book.ATK[i]);
            this.add(book.DF[i]);
            this.add(book.coin[i]);
            this.add(book.exp[i]);
            this.add(book.lose[i]);
            this.add(book.point[i]);
            book.nameBlock[i].setVisible(false);
            book.HPBlock[i].setVisible(false);
            book.ATKBlock[i].setVisible(false);
            book.DFBlock[i].setVisible(false);
            book.CEBlock[i].setVisible(false);
            book.loseBlock[i].setVisible(false);
            book.name[i].setVisible(false);
            book.HP[i].setVisible(false);
            book.ATK[i].setVisible(false);
            book.DF[i].setVisible(false);
            book.coin[i].setVisible(false);
            book.exp[i].setVisible(false);
            book.lose[i].setVisible(false);
            book.point[i].setVisible(false);
        }
    }

    public void setmSprite(MSprite mSprite) {
        this.mSprite = mSprite;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public void setSaveMap(SaveMap saveMap) {
        this.saveMap = saveMap;
    }


    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (VK1 == "UP") {
            VK1 = "";
            shop.addHP.setVisible(false);
            shop.addATK.setVisible(false);
            shop.addDF.setVisible(false);
            shop.tip.setVisible(false);
        }
        if (VK == "") {
            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                int a = 1;
                int b = 0;
                keyPress.Keypress(mSprite, map, fight, floorJump, saveMap, a, b);
            } else if (e.getKeyCode() == KeyEvent.VK_UP) {
                int a = -1;
                int b = 0;
                keyPress.Keypress(mSprite, map, fight, floorJump, saveMap, a, b);

                if (map.map[mSprite.m_posY / 32][mSprite.m_posX / 32 + 1] == 46) {
                    if (VK1 == "UP") {
                        VK1 = "";
                        shop.addHP.setVisible(false);
                        shop.addATK.setVisible(false);
                        shop.addDF.setVisible(false);
                        shop.tip.setVisible(false);
                    } else {
                        VK1 = "UP";
                        shop.addHP.setVisible(true);
                        shop.addATK.setVisible(true);
                        shop.addDF.setVisible(true);
                        shop.tip.setVisible(true);
                    }
                }

            } else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                int a = 0;
                int b = -1;
                keyPress.Keypress(mSprite, map, fight, floorJump, saveMap, a, b);
            } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                int a = 0;
                int b = 1;
                keyPress.Keypress(mSprite, map, fight, floorJump, saveMap, a, b);
            }
            if (e.getKeyCode() == KeyEvent.VK_Z) {
                int x = 0;
                if (mSprite.jump == 1) {
                    for (int j = 1; j < 12; j++) {
                        for (int h = 1; h < 12; h++) {
                            if (map.map[j][h] >= 1000 && map.map[j][h] < 2000) {
                                x = map.map[j][h];
                            }
                        }
                    }
                    floorJump.Jump(x, map, saveMap, mSprite);
                }

            }
            if (e.getKeyCode() == KeyEvent.VK_X) {
                int x = 0;
                if (mSprite.jump == 1) {
                    for (int j = 1; j < 12; j++) {
                        for (int h = 1; h < 12; h++) {
                            if (map.map[j][h] >= 2000 && map.map[j][h] < 3000) {
                                x = map.map[j][h];
                            }
                        }
                    }
                    floorJump.Jump(x, map, saveMap, mSprite);
                }
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_A && mSprite.book == 1) {
            h = 0;
            for (int i = 0; i < 11; i++) {
                x[i] = 0;
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

            if (VK == "A") {
                VK = "";
                for (int i = 0; i < h; i++) {
                    book.nameBlock[i].setVisible(false);
                    book.HPBlock[i].setVisible(false);
                    book.ATKBlock[i].setVisible(false);
                    book.DFBlock[i].setVisible(false);
                    book.CEBlock[i].setVisible(false);
                    book.loseBlock[i].setVisible(false);
                    book.name[i].setVisible(false);
                    book.HP[i].setVisible(false);
                    book.ATK[i].setVisible(false);
                    book.DF[i].setVisible(false);
                    book.coin[i].setVisible(false);
                    book.exp[i].setVisible(false);
                    book.lose[i].setVisible(false);
                    book.point[i].setVisible(false);
                }
                h = 0;
                book.Empty();
            } else {
                VK = "A";
                for (int i = 0; i < h; i++) {
                    book.nameBlock[i].setVisible(true);
                    book.HPBlock[i].setVisible(true);
                    book.ATKBlock[i].setVisible(true);
                    book.DFBlock[i].setVisible(true);
                    book.CEBlock[i].setVisible(true);
                    book.loseBlock[i].setVisible(true);
                    book.name[i].setVisible(true);
                    book.HP[i].setVisible(true);
                    book.ATK[i].setVisible(true);
                    book.DF[i].setVisible(true);
                    book.coin[i].setVisible(true);
                    book.exp[i].setVisible(true);
                    book.lose[i].setVisible(true);
                    book.point[i].setVisible(true);
                }
            }
//            repaint();
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == shop.addHP && mSprite.coin >= 25) {
            mSprite.coin -= 25;
            mSprite.HP += 800;
        }
        if (e.getSource() == shop.addATK && mSprite.coin >= 25) {
            mSprite.coin -= 25;
            mSprite.ATK += 4;
        }
        if (e.getSource() == shop.addDF && mSprite.coin >= 25) {
            mSprite.coin -= 25;
            mSprite.DF += 4;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.clearRect(0, 0, this.getWidth(), this.getHeight());
        map.DrawMap(g, this);
        mSprite.DrawSprite(g, this);
        if (map.map[mSprite.m_posY / 32][mSprite.m_posX / 32 + 1] == 46 && VK1 == "UP") {
            shop.DrawShop(g, this);
        }
        if (mSprite.book == 1 && VK == "A") {
            book.DrawBook(map, mSprite, g, this);
        }
    }
}
