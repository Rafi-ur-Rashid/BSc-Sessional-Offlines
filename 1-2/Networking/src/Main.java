
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
public class Main {
    
    public static void main(String[] args) throws InterruptedException {
        
        int n,r1, c1, r2, c2;
        Scanner sc=new Scanner(System.in);
        n  = sc.nextInt();
        r1 = sc.nextInt();
        c1 = sc.nextInt();
        int[][] Matrix1 = new int[r1][c1];
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                Matrix1[i][j] = sc.nextInt();
            }
        }
        r2 = sc.nextInt();
        c2 = sc.nextInt();
        int[][] Matrix = new int[r2][c2]; //buffer array
        int[][] Matrix2 = new int[c2][r2];
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                Matrix[i][j] = sc.nextInt();
                Matrix2[j][i]=Matrix[i][j];  //Transposing 2nd matrix
            }
        }
        if (c1!=r2) {
            System.out.println( "This two matrix can't be multiplicated,Sorry!");
            return;
        }
        
        WorkItem[] W = new WorkItem[r1 * c2];
        Worker[] w = new Worker[n];
        int[][] result = new int[r1][c2];
        Queue Q=new Queue(r1,c2);
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                W[i * c2 + j] = new WorkItem(i, j, Matrix1[i], Matrix2[j]);
            }
        }
        
       
       for (int i = 0; i <n; i++) {
            w[i]=new Worker(Q, result, W.length/n);
        }
        for (int i = 0; i < W.length; i++)
        {
            Q.put(W[i]);
        }
       
        
        for (int i = 0; i < n; i++) {
            try {
                w[i].t.join();
            } catch (InterruptedException ex) {

            }
        }
        System.out.println("Here is your result:\n ");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println("");
        }
        //Calling routine to test the result
        Routine.single_Threaded_Multiplication(Matrix1, Matrix2);
    }

}

