public class LoseHP {
    int loseHP;
    int MHP;
    int HP;

    public int loseHP(MSprite sprite, Monster monster) {
        loseHP = sprite.HP;
        MHP = monster.HP;
        HP = sprite.HP;
        if (sprite.ATK > monster.DF) {
            while (MHP > 0) {
                if (sprite.DF >= monster.ATK && sprite.ATK > monster.DF) {
                    MHP = 0;
                }
                if (sprite.DF < monster.ATK && MHP > 0) {
                    MHP -= (sprite.ATK - monster.DF);
                    HP -= (monster.ATK - sprite.DF);
                }
            }
            loseHP = loseHP - HP;
        }
        return loseHP;
    }
}
