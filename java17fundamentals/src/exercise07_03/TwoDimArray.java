package exercise07_03;

public class TwoDimArray {
    public static void main(String[] args) {
        int[][] twoD = new int[4][6];
        for (int i = 0; i < twoD.length; i++) {
            for (int j = 0; j < twoD[i].length; j++) {
                twoD[i][j] = (i + 1) * (j + 1);
            }
        }

        for (int[] row : twoD) {
            for (int el : row) {
                System.out.printf("%3d", el);
            }
            System.out.printf("%n");
        }
    }
}
