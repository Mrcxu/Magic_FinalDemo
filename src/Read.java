import javax.swing.*;
import java.io.DataInputStream;
import java.io.FileInputStream;

public class Read {
    private SaveMap saveMap = new SaveMap();
    int[][][] Group = {saveMap.map1, saveMap.map2, saveMap.map3, saveMap.map4, saveMap.map5, saveMap.map6, saveMap.map7, saveMap.map8, saveMap.map9, saveMap.map10};

    public void read(int a, MSprite mSprite, MCanvas mCanvas) {
        try {
            DataInputStream localDataInputStream = new DataInputStream(new FileInputStream("save" + a + ".dat"));
            for (int i = 0; i < Group.length; i++) {
                for (int j = 0; j < 13; j++) {
                    for (int k = 0; k < 13; k++) {
                        Group[i][j][k] = localDataInputStream.readInt();
                        mCanvas.map.map[j][k] = Group[i][j][k];
                    }
                }
            }
            mSprite.m_posX = localDataInputStream.readInt();
            mSprite.m_posY = localDataInputStream.readInt();
            mSprite.ATK = localDataInputStream.readInt();
            mSprite.DF = localDataInputStream.readInt();
            mSprite.HP = localDataInputStream.readInt();
            mSprite.BKey = localDataInputStream.readInt();
            mSprite.RKey = localDataInputStream.readInt();
            mSprite.YKey = localDataInputStream.readInt();
            mSprite.coin = localDataInputStream.readInt();
            mSprite.floor = localDataInputStream.readInt();
            mSprite.exp = localDataInputStream.readInt();
            mSprite.book = localDataInputStream.readInt();
            mSprite.jump = localDataInputStream.readInt();
            localDataInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "读取失败！此存档为空或损坏！", "读取失败", JOptionPane.WARNING_MESSAGE);
        }
    }
}
