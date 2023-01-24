package workspace;

public class ComparableTest<E extends Integer, E2 extends Double> {


    public void eenMethode() {
        interface Inner {
            void start();
            void stop();

        }
        System.out.println(new Inner() {
            @Override
            public void start() {
                System.out.println();
            }

            @Override
            public void stop() {

            }


        });
    }

}
