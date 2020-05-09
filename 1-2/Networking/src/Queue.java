
import java.util.logging.Level;
import java.util.logging.Logger;

class Queue {
    WorkItem []w;
    int i=0;
    boolean val=false;
    public Queue(int r,int c) {
        w=new WorkItem[r*c];
    }
    synchronized void put(WorkItem W)
    {
        while(val)
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Exception in put: "+ex);
                
            }
        w[i++]=W;
        val=true;
        notifyAll();
    }
    synchronized WorkItem get()
    {
        while(!val)
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println("Exception in get: "+ex);
            }
        
        val=false;
        notifyAll();
        return w[i-1];
        
    }
    
}
