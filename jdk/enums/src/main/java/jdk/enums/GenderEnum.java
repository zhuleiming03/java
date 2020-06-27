package jdk.enums;

public enum GenderEnum {

    /**
     * 男性
     */
    MALE(1, "男性"),
    /**
     * 女性
     */
    FEMALE(2, "女性");


    private Integer code;

    private String name;

    public Integer getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getValueByCode(Integer code) {
        for (GenderEnum enumInstance : GenderEnum.values()) {
            if (code.equals(enumInstance.getCode())) {
                return enumInstance.getName();
            }
        }
        return null;
    }

    public static GenderEnum valueOf(Integer code) {
        for (GenderEnum enumInstance : GenderEnum.values()) {
            if (code.equals(enumInstance.getCode())) {
                return enumInstance;
            }
        }
        return null;
    }

    GenderEnum(Integer code, String name) {
        this.code = code;
        this.name = name;
    }
}
