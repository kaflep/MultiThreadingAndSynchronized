

class multiThreadingSynchronized {
//    this is one of the example of multithreading and synchronized

    int count;
    /*
    this is multithreading
    it will not give total count 2000 because
    th1 and th2 increment and assign same time and th1 gives to the
    th2 and th2 gives to the th1 that count value

     */

    //    public  void Counter(){
//        count++;
//    }
/*
    this is synchronized way to do that once
    th1 and th2 runs simulations and it gives count 2000
 */
    public  synchronized void Counter(){
        count++;
    }

}
public class SyncDemo {
    public static void main(String[] args) throws  Exception{
        multiThreadingSynchronized MTS = new multiThreadingSynchronized();
        Thread th1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i<=1000;i++) {
                    MTS.Counter();
                }
            }
        });
        Thread th2 = new Thread(new Runnable() {
            public void run() {
                for (int i = 1; i<=1000;i++) {
                    MTS.Counter();
                }
            }
        });

        th1.start();
        th2.start();

        th1.join();
        th2.join();;
        System.out.println("Count:" + MTS.count);
    }

}

