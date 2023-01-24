package exercise04_09;

public class BitOpsApp {
    public static void main(String[] args) {
        int heating = 0;
        final int HALL = 0x01;
        final int LIVINGROOM = 0x02;
        final int KITCHEN = 0X04;
        final int VERANDA = 0x08;
        final int BEDROOM = 0x10;
        final int LAUNDRY = 0x20;
        final int BATHROOM = 0x40;
        final int CELLAR = 0x80;

        final int DOWNSTAIRS = HALL | KITCHEN | LIVINGROOM | VERANDA;
        final int UPSTAIRS = BEDROOM | LAUNDRY | CELLAR | BATHROOM;

        heating |= LIVINGROOM;
        System.out.println("Heating in living room on: heating |= LIVINGROOM (" + heating + ")");
        heating &= ~LIVINGROOM;
        System.out.println("Heating in living room off: heating &= ~LIVINGROOM (" + heating + ")");
        heating |= DOWNSTAIRS;
        System.out.println("Heating downstairs on: heating |= DOWNSTAIRS (" + heating + ")");
        heating |= UPSTAIRS;
        System.out.println("Heating upstairs on:  heating |= UPSTAIRS (" + heating + ")");
        heating ^= DOWNSTAIRS;
        System.out.println("Heating downstairs switched: heating ^= DOWNSTAIRS (" + heating + ")");
        System.out.println("Check heating in bathroom on: (heating & BATHROOM)==BATHROOM (" + ((heating & BATHROOM)==BATHROOM) + ")");
        heating &= ~UPSTAIRS;
        System.out.println("Heating upstairs off:  heating &= ~UPSTAIRS (" + heating + ")");

    }
}
