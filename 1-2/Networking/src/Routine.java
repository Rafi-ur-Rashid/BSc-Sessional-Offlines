//routine for single threaded test
class Routine {

    static int r1, c1, c2, r2;
    static int[][] result;

    static void single_Threaded_Multiplication(int[][] M1, int[][] M2) {
        r1 = M1.length;
        c1 = M1[0].length;
        c2 = M2.length;
        r2 = M2[0].length;
        result = new int[r1][c2];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                int sum = 0;
                for (int k = 0; k < r2; k++) {
                    sum += M1[i][k] * M2[j][k];
                }
                result[i][j] = sum;
            }

        }
        System.out.println("\nThis is single threaded test result:\n ");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
