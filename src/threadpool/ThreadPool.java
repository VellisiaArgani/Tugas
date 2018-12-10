package threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
/**
 *
 * @author asus
 */
class Threadku implements Runnable{
    private int id;
    
    public Threadku(int id){
        this.id=id;
    }
    public void run(){
        System.out.println("Jalankan Thread :"+id);
        
        try{
            Thread.sleep(4000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Finish Thread :"+id);
        
        }
    }
        
public class ThreadPool {

    public static void main(String[] args) {
      ExecutorService service = Executors.newFixedThreadPool(5); 
      
      for (int i =1; i<100; i=i+2){
          
      service.submit(new Threadku(i));
      
    }
    service.shutdown();
 
        System.out.println("START THREAD");
        
        try{
            service.awaitTermination(1, TimeUnit.HOURS);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("FINISH");
    
    }
    
}
