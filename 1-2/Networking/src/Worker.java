
import java.util.logging.Level;
import java.util.logging.Logger;

    //class to generate the threads

class Worker implements Runnable {

    WorkItem w;
    Thread t;
    Queue q;
    int[][] result;
    int k = 0, n;

    public Worker(Queue Q, int[][] result, int n) {
        q = Q;
        this.result = result;
        t = new Thread(this);
        this.n=n;
        t.start();
        
    }
    @Override
    public void run() {
            while(k < n) {
            k++;
            w=q.get();
            w.calculate();
            result[w.rowNum][w.colNum] = w.set();
            }

    }

}
