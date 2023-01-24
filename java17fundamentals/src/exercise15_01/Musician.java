package exercise15_01;

public class Musician {

    public void play() {
        class Instrument {
            public void makeSound() {
                System.out.println("brrr");
            }
        }
        Instrument instrument = new Instrument();
        instrument.makeSound();
    }
}
