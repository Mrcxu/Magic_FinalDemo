import java.awt.*;

public class FloorJump {
    public void Jump(int i, Map map, SaveMap saveMap, MSprite mSprite) {

        int[][][] Group = {saveMap.map1, saveMap.map2, saveMap.map3, saveMap.map4, saveMap.map5, saveMap.map6, saveMap.map7, saveMap.map8, saveMap.map9, saveMap.map10, saveMap.map11, saveMap.map12};

        if (i >= 1000 && i < 2000) {
            int z = i - 1000;
            mSprite.floor = z + 1;
            for (int j = 0; j < 13; j++) {
                for (int h = 0; h < 13; h++) {
                    Group[z][j][h] = map.map[j][h];
                    map.map[j][h] = Group[z + 1][j][h];
                }
            }
            int x = 0, y = 0;
            for (int j = 1; j < 13; j++) {
                for (int h = 1; h < 13; h++) {

                    if (Group[z + 1][j][h] >= 2000 && Group[z + 1][j][h] < 3000) {
                        x = h;
                        y = j;
                    }
                }
            }
            for (int j = 1; j < 13; j++) {
                for (int h = 1; h < 13; h++) {
                    if (Group[z + 1][j][h] == 10001) {
                        mSprite.m_posX = (h - 1) * 32;
                        mSprite.m_posY = (j - 1) * 32;
                        if (x > h && y == j) {
                            mSprite.sprite = Toolkit.getDefaultToolkit().getImage("image/01-3.png");
                        }
                        if (x < h && y == j) {
                            mSprite.sprite = Toolkit.getDefaultToolkit().getImage("image/01-4.png");
                        }
                        if (x == h && y < j) {
                            mSprite.sprite = Toolkit.getDefaultToolkit().getImage("image/01-1.png");
                        }
                        if (x == h && y > j) {
                            mSprite.sprite = Toolkit.getDefaultToolkit().getImage("image/01-2.png");
                        }
                    }
                }
            }
        }
        if (i >= 2000 && i < 3000) {
            int z = i - 2000;
            mSprite.floor = z - 1;
            for (int j = 0; j < 13; j++) {
                for (int h = 0; h < 13; h++) {
                    Group[z][j][h] = map.map[j][h];
                    map.map[j][h] = Group[z - 1][j][h];
                }
            }
            int x = 0, y = 0;
            for (int j = 1; j < 13; j++) {
                for (int h = 1; h < 13; h++) {

                    if (Group[z - 1][j][h] >= 1000 && Group[z - 1][j][h] < 2000) {
                        x = h;
                        y = j;
                    }
                }
            }
            for (int j = 1; j < 13; j++) {
                for (int h = 1; h < 13; h++) {
                    if (Group[z - 1][j][h] == 10000) {
                        mSprite.m_posX = (h - 1) * 32;
                        mSprite.m_posY = (j - 1) * 32;
                        if (x > h && y == j) {
                            mSprite.sprite = Toolkit.getDefaultToolkit().getImage("image/01-3.png");
                        }
                        if (x < h && y == j) {
                            mSprite.sprite = Toolkit.getDefaultToolkit().getImage("image/01-4.png");
                        }
                        if (x == h && y < j) {
                            mSprite.sprite = Toolkit.getDefaultToolkit().getImage("image/01-1.png");
                        }
                        if (x == h && y > j) {
                            mSprite.sprite = Toolkit.getDefaultToolkit().getImage("image/01-2.png");
                        }
                    }
                }
            }
        }
    }
}
