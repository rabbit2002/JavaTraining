package chapter12_QuickHit;

/**
 * 关卡参数类
 *
 * @author RABBIT2002
 * @date 2020/12/17
 */
public class LevelParam {
    private final static LevelUnit[] LEVELS = new LevelUnit[6];

    static {
        LEVELS[0] = LevelUnit.GET_LEVEL_UNIT("LV1", 2, 1, 1000 * 1000L, 1);
        LEVELS[1] = LevelUnit.GET_LEVEL_UNIT("LV2", 3, 1, 1000 * 1000L, 2);
        LEVELS[2] = LevelUnit.GET_LEVEL_UNIT("LV3", 4, 1, 1000 * 1000L, 5);
        LEVELS[3] = LevelUnit.GET_LEVEL_UNIT("LV4", 5, 1, 1000 * 1000L, 8);
        LEVELS[4] = LevelUnit.GET_LEVEL_UNIT("LV5", 6, 1, 1000 * 1000L, 10);
        LEVELS[5] = LevelUnit.GET_LEVEL_UNIT("LV6", 7, 1, 1000 * 1000L, 15);
    }

    public static final LevelUnit[] GET_LEVELS() {
        return LEVELS;
    }
}