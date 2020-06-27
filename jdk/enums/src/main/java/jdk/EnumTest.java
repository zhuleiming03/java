package jdk;

import jdk.enums.GenderEnum;

public class EnumTest {

    public static void main(String[] args) {
        System.out.println(">>" + GenderEnum.FEMALE);
        System.out.println(">>" + GenderEnum.MALE.getCode());
        System.out.println(">>" + GenderEnum.MALE.getName());
        System.out.println(">>" + GenderEnum.valueOf(1));
        System.out.println(">>" + GenderEnum.valueOf("MALE"));
        System.out.println(">>" + GenderEnum.MALE.getValueByCode(1));
    }
}
