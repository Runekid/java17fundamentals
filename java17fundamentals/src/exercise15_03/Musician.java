package exercise15_03;

public class Musician {

    public void play() {

        Instrument instrument = new Instrument() {
            @Override
            public void makeSound() {
                System.out.println("brr");
            }
        };
        instrument.makeSound();
    }
}
