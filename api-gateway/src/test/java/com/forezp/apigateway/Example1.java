package com.forezp.apigateway;

/**
 * @Auther: huangsj
 * @Date: 2018/9/12 20:57
 * @Description:
 */
public class Example1 extends Thread {
    boolean stop=false;
    public static void main( String args[] ) throws Exception {
        Example1 thread = new Example1();
        System.out.println( "Starting thread..." );
        thread.start();
        Thread.sleep( 3000 );
        System.out.println( "Interrupting thread..." );
        thread.interrupt();
        Thread.sleep( 3000 );
        System.out.println("Stopping application..." );
        //System.exit(0);
    }
    public void run() {
        while(!stop){
            System.out.println( "Thread is running..." );
            long time = System.currentTimeMillis();
            while((System.currentTimeMillis()-time < 1000)) {
                try {
                    Thread.sleep(100);
                    if(this.isInterrupted()){
                        break;
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("Thread exiting under request..." );
    }
}