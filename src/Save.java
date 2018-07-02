import java.io.DataOutputStream;
import java.io.FileOutputStream;

public class Save {
    private SaveMap saveMap = new SaveMap();
    int[][][] Group= {saveMap.map1, saveMap.map2, saveMap.map3, saveMap.map4, saveMap.map5, saveMap.map6, saveMap.map7, saveMap.map8, saveMap.map9, saveMap.map10};
    public void save(int a, MSprite mSprite, MCanvas mCanvas) {
        try {
            DataOutputStream localDataOutPutStream = new DataOutputStream(new FileOutputStream("save" + a + ".dat"));
            for (int i = 0; i < Group.length; i++) {
                for (int j = 0; j < 13; j++) {
                    for (int k = 0; k < 13; k++) {
                        Group[i][j][k] = mCanvas.map.map[j][k];
                        localDataOutPutStream.writeInt(Group[i][j][k]);
                    }
                }
            }
            localDataOutPutStream.writeInt(mSprite.m_posX);
            localDataOutPutStream.writeInt(mSprite.m_posY);
            localDataOutPutStream.writeInt(mSprite.ATK);
            localDataOutPutStream.writeInt(mSprite.DF);
            localDataOutPutStream.writeInt(mSprite.HP);
            localDataOutPutStream.writeInt(mSprite.BKey);
            localDataOutPutStream.writeInt(mSprite.RKey);
            localDataOutPutStream.writeInt(mSprite.YKey);
            localDataOutPutStream.writeInt(mSprite.coin);
            localDataOutPutStream.writeInt(mSprite.floor);
            localDataOutPutStream.writeInt(mSprite.exp);
            localDataOutPutStream.writeInt(mSprite.book);
            localDataOutPutStream.writeInt(mSprite.jump);
            localDataOutPutStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
