package exercise05_01;

public class DataTypesApp {

    public static void main(String[] args) {
        var aBoolean = false;
        var aCharacter = 'd';
        byte aByte = 126;
        short aShort = 115;
        var anInteger = 1256456;
        var aLongInteger = 456123789L;
        var aDecimalNumber = 12356.03F;
        var aBigDecimalNumber = 12.151618989456;

        var anIntegerOctal = 0342;
        var anIntegerHexadecimal = 0x56_31;
        var anIntegerBinary = 0b0101_1100;

        System.out.println(aBoolean);
        System.out.println(aCharacter);
        System.out.println(aByte);
        System.out.println(aShort);
        System.out.println(anInteger);
        System.out.println(aLongInteger);
        System.out.println(aDecimalNumber);
        System.out.println(aBigDecimalNumber);

        System.out.println(anIntegerOctal);
        System.out.println(anIntegerHexadecimal);
        System.out.println(anIntegerBinary);

        final double PI = 3.14;
        //PI = 3.15; kan enkel 1 value assignen aan een constante veriabele

        aByte = (byte) aShort;
        System.out.println(aByte);

        aShort = (short) aCharacter;
        System.out.println(aShort);

        anInteger = aCharacter;
        System.out.println(anInteger);
    }
}
