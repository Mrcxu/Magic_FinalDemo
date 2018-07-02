import java.awt.*;

public class Fight {
    public Monster monster;
    public Monster xmonster;
    public int HP;
    public int MHP;

    public Fight() {

    }

    public void Fighting(MSprite sprite, int monID, Map map, int a, int b) {
        for (int i = 0; i < 1; i++) {
            if (monID <= 70 && monID >= 49) {
                xmonster = map.monsters[monID - 49];
                monster = new Monster(monID, null, xmonster.HP, xmonster.DF, xmonster.ATK, xmonster.coin, xmonster.Exp, null);
                HP = sprite.HP;
                MHP = monster.HP;
                if (sprite.ATK > monster.DF) {
                    while (MHP > 0) {
                        if (sprite.DF < monster.ATK && MHP > 0) {
                            MHP -= (sprite.ATK - monster.DF);
                            HP -= (monster.ATK - sprite.DF);
                        } else if (sprite.DF >= monster.ATK && MHP > 0) {
                            MHP = 0;
                        }
                    }
                }


                if (sprite.ATK > monster.DF && HP > 0) {
                    while (monster.HP > 0) {
                        if (sprite.DF >= monster.ATK && sprite.ATK > monster.DF) {
                            monster.HP = 0;
                            map.map[sprite.m_posY / 32 + 1 + a][sprite.m_posX / 32 + 1 + b] = 0;
                            sprite.coin += monster.coin;
                        }
                        if (sprite.DF < monster.ATK && monster.HP > 0) {
                            monster.HP -= (sprite.ATK - monster.DF);
                            sprite.HP -= (monster.ATK - sprite.DF);
                        }
                        if (monster.HP <= 0) {
                            map.map[sprite.m_posY / 32 + 1 + a][sprite.m_posX / 32 + 1 + b] = 0;
                            sprite.coin += monster.coin;
                            sprite.exp += monster.Exp;
                        }
                    }
                }
            }
        }

    }
}
