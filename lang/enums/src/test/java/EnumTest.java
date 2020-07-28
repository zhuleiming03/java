import org.junit.Test;

public class EnumTest {

    @Test
    public void baseTest(){
        System.out.println(">>" + GenderEnum.FEMALE);
        System.out.println(">>" + GenderEnum.MALE.getCode());
        System.out.println(">>" + GenderEnum.MALE.getName());
        System.out.println(">>" + GenderEnum.valueOf(1));
        System.out.println(">>" + GenderEnum.valueOf("MALE"));
        System.out.println(">>" + GenderEnum.MALE.getValueByCode(1));
    }
}
