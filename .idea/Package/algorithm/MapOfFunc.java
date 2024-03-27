package Package.algorithm;

import java.util.HashMap;
import java.util.Map;

public class MapOfFunc {
    private final String CONST1 = "1";
    private final String CONST2 = "2";
    private final String CONST3 = "3";

    private final Map<String, String> stringMap = Map.of(
            CONST1, "200",
            CONST2, "TECH"
    );

    public Integer getSetting(String setting) {
        return Integer.parseInt(stringMap.get(setting));
    }
}
