package pojo;

public enum ColorEnums {

    /**
     *
     */
    RED("red", "红色"),
    /**
     *
     */
    PINK("pink", "粉色");

    private String value;

    private String key;

    ColorEnums(String key, String value) {
        this.value = value;
        this.key = key;
    }

    public static String getValueByKey(String key) {
        for (ColorEnums enums : ColorEnums.values()) {
            if (enums.key.equals(key)) {
                return enums.value;
            }
        }
        return "default";
    }
}
