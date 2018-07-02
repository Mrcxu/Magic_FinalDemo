import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;

public class Map {
    public MapPackge mapPackge;
    public Image wall;
    public Image magma;
    public Image road;
    public Image empty;
    public Image up;
    public Image down;

    public Image YDoor;
    public Image BDoor;
    public Image RDoor;


    public Image YKey;
    public Image BKey;
    public Image RKey;
    public Image SHP;
    public Image BHP;
    public Image book;
    public Image Item01a;
    public Image Item01b;
    public Image sword01a;
    public Image sword01b;
    public Image promote;
    public Image Snow;
    public Image Akey;
    public Image Shield;
    public Image Cross;


    public Image NPC01a;
    public Image NPC01b;
    public Image NPC01c;
    public Image NPP02a;
    public Image NPC03a;
    public Image Princess;


    private Monster monster01a, monster01b, monster01c;
    private Monster Monster02a, Monster02b, Monster02c;
    private Monster Monster03a, Monster03b, Monster03c;
    private Monster Monster04a, Monster04b;
    private Monster Monster05a, Monster05b;
    private Monster Monster06a, Monster06b;
    private Monster Monster07a, Monster07b;
    private Monster Monster08a;
    private Monster Monster09a;
    private Monster Monster10a;
    private Monster Monster11a;
    private Monster Monster12a;


    public Monster[] monsters = {Monster12a, monster01a, monster01b, monster01c, Monster02a, Monster02b, Monster02c, Monster03a, Monster03b, Monster03c, Monster04a, Monster04b
            , Monster05a, Monster05b, Monster06a, Monster06b, Monster07a, Monster07b, Monster08a, Monster09a, Monster10a, Monster11a};


    public int[][] map;

    public Map() {
        mapPackge = new MapPackge();
        map = new int[13][13];
        wall = Toolkit.getDefaultToolkit().getImage("image/05.jpg");
        magma = Toolkit.getDefaultToolkit().getImage("image/03.jpg");
        road = Toolkit.getDefaultToolkit().getImage("image/02.jpg");
        empty = Toolkit.getDefaultToolkit().getImage("image/04.jpg");
        up = Toolkit.getDefaultToolkit().getImage("image/02-1.png");
        down = Toolkit.getDefaultToolkit().getImage("image/02-2.png");
        YDoor = Toolkit.getDefaultToolkit().getImage("image/YDoor.png");
        BDoor = Toolkit.getDefaultToolkit().getImage("image/BDoor.png");
        RDoor = Toolkit.getDefaultToolkit().getImage("image/RDoor.png");
        YKey = Toolkit.getDefaultToolkit().getImage("image/YKey.png");
        BKey = Toolkit.getDefaultToolkit().getImage("image/BKey.png");
        RKey = Toolkit.getDefaultToolkit().getImage("image/RKey.png");
        SHP = Toolkit.getDefaultToolkit().getImage("image/SHP.png");
        BHP = Toolkit.getDefaultToolkit().getImage("image/BHP.png");
        book = Toolkit.getDefaultToolkit().getImage("image/book.png");
        Item01a = Toolkit.getDefaultToolkit().getImage("image/Item01a.png");
        Item01b = Toolkit.getDefaultToolkit().getImage("image/Item01b.png");
        sword01a = Toolkit.getDefaultToolkit().getImage("image/sword01a.png");
        sword01b = Toolkit.getDefaultToolkit().getImage("image/sword01b.png");
        promote = Toolkit.getDefaultToolkit().getImage("image/promote.png");
        Snow = Toolkit.getDefaultToolkit().getImage("image/Snow.png");
        Akey = Toolkit.getDefaultToolkit().getImage("image/Akey.png");
        Shield = Toolkit.getDefaultToolkit().getImage("image/Shield.png");
        Cross = Toolkit.getDefaultToolkit().getImage("image/Cross.png");

        ////NPC
        NPC01a = Toolkit.getDefaultToolkit().getImage("image/NPC01a.png");
        NPC01b = Toolkit.getDefaultToolkit().getImage("image/NPC01b.png");
        NPC01c = Toolkit.getDefaultToolkit().getImage("image/NPC01c.png");
        NPP02a = Toolkit.getDefaultToolkit().getImage("image/NPP02a.png");
        NPC03a = Toolkit.getDefaultToolkit().getImage("image/shop.png");
        Princess = Toolkit.getDefaultToolkit().getImage("image/Princess.png");


        ////怪物ID、属性、图片
        monsters[0] = new Monster(49, "黄金BOSS", 1000, 500, 250, 22, 19, Toolkit.getDefaultToolkit().getImage("image/Yellow.png"));
        monsters[1] = new Monster(50, "绿头怪", 50, 1, 20, 1, 1, Toolkit.getDefaultToolkit().getImage("image/monster01a.png"));
        monsters[2] = new Monster(51, "红头怪", 70, 2, 15, 2, 2, Toolkit.getDefaultToolkit().getImage("image/monster01b.png"));
        monsters[3] = new Monster(52, "青头怪", 200, 10, 35, 5, 5, Toolkit.getDefaultToolkit().getImage("image/monster01c.png"));
        monsters[4] = new Monster(53, "骷髅小兵", 110, 5, 25, 5, 4, Toolkit.getDefaultToolkit().getImage("image/Monster02a.png"));
        monsters[5] = new Monster(54, "骷髅士兵", 150, 20, 40, 8, 5, Toolkit.getDefaultToolkit().getImage("image/Monster02b.png"));
        monsters[6] = new Monster(55, "骷髅队长", 400, 50, 90, 15, 12, Toolkit.getDefaultToolkit().getImage("image/Monster02c.png"));
        monsters[7] = new Monster(56, "小蝙蝠", 100, 5, 20, 3, 3, Toolkit.getDefaultToolkit().getImage("image/Monster03a.png"));
        monsters[8] = new Monster(57, "大蝙蝠", 150, 30, 65, 25, 20, Toolkit.getDefaultToolkit().getImage("image/Monster03b.png"));
        monsters[9] = new Monster(58, "红蝙蝠", 250, 100, 170, 10, 10, Toolkit.getDefaultToolkit().getImage("image/Monster03c.png"));
        monsters[10] = new Monster(59, "初级法师", 125, 25, 50, 10, 7, Toolkit.getDefaultToolkit().getImage("image/Monster04a.png"));
        monsters[11] = new Monster(60, "高级法师", 20, 10, 25, 10, 10, Toolkit.getDefaultToolkit().getImage("image/Monster04b.png"));
        monsters[12] = new Monster(61, "麻衣法师", 100, 110, 100, 30, 25, Toolkit.getDefaultToolkit().getImage("image/Monster05a.png"));
        monsters[13] = new Monster(62, "红衣法师", 100, 100, 160, 47, 35, Toolkit.getDefaultToolkit().getImage("image/Monster05b.png"));
        monsters[14] = new Monster(63, "兽面人", 300, 45, 75, 13, 10, Toolkit.getDefaultToolkit().getImage("image/Monster06a.png"));
        monsters[15] = new Monster(64, "兽面武士", 300, 130, 250, 50, 40, Toolkit.getDefaultToolkit().getImage("image/Monster06b.png"));
        monsters[16] = new Monster(65, "金队长", 300, 100, 250, 45, 35, Toolkit.getDefaultToolkit().getImage("image/Monster07a.png"));
        monsters[17] = new Monster(66, "金卫队", 300, 150, 250, 77, 60, Toolkit.getDefaultToolkit().getImage("image/Monster07b.png"));
        monsters[18] = new Monster(67, "白衣武士", 100, 150, 300, 40, 30, Toolkit.getDefaultToolkit().getImage("image/Monster08a.png"));
        monsters[19] = new Monster(68, "石头怪人", 300, 65, 115, 15, 15, Toolkit.getDefaultToolkit().getImage("image/Monster09a.png"));
        monsters[20] = new Monster(69, "怪王", 300, 125, 250, 32, 25, Toolkit.getDefaultToolkit().getImage("image/Monster10a.png"));
        monsters[21] = new Monster(70, "初级卫兵", 250, 90, 100, 22, 19, Toolkit.getDefaultToolkit().getImage("image/Monster11a.png"));


        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 13; j++) {
                map[i][j] = mapPackge.map1[i][j];
            }
        }
    }

    public void DrawMap(Graphics g, JPanel i) {
        for (int z = 1; z < 12; z++) {
            for (int j = 1; j < 12; j++) {
                if (map[z][j] == 1) {
                    g.drawImage(wall, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 2) {
                    g.drawImage(magma, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 3) {
                    g.drawImage(empty, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 0) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 40) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(NPC01a, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 41) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(NPC01b, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 42) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(NPC01c, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 43) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(NPP02a, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 44) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(road, (j) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(road, (j + 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(NPC03a, (j - 1) * 32, (z - 1) * 32, 96, 32, (ImageObserver) i);
                }
                if (map[z][j] == 45) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(Princess, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 71) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(book, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 72) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(Item01a, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 73) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(Item01b, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 74) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(sword01a, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 75) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(sword01b, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 76) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(promote, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 77) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(Snow, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 78) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(Akey, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 79) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(Shield, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 80) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(Cross, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }

                if (map[z][j] >= 1000 && map[z][j] < 2000) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(up, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);

                }
                if (map[z][j] >= 2000 && map[z][j] < 3000) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(down, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);

                }
                if (map[z][j] == 100) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(YDoor, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 101) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(BDoor, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 102) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(RDoor, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 200) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(YKey, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 201) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(BKey, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 202) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(RKey, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 300) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(SHP, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 301) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                    g.drawImage(BHP, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }
                if (map[z][j] == 10000 || map[z][j] == 10001) {
                    g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                }

                for (int y = 0; y < monsters.length; y++) {
                    if (map[z][j] == monsters[y].monID) {
                        g.drawImage(road, (j - 1) * 32, (z - 1) * 32, 32, 32, (ImageObserver) i);
                        monsters[y].DrawMonster(g, i, (j - 1) * 32, (z - 1) * 32);
                    }
                }
            }
        }
    }
}
