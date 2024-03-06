package  Threads;
public class MyThreadRunnableInterface implements Runnable{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		Thread t=Thread.currentThread();
		try {
			for(int i=0;i<4;i++) {
			Thread.sleep(500);
			System.out.println(t+" on step :"+i);}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("My Runnable Interface Thread Ended");
	}
	}
public class mainThread {
	public class MyThread extends Thread{

		public MyThread(String name) {
			super(name);
		}
		public void run() {
			try {
				for(int i=0;i<4;i++) {
				sleep(500);
				System.out.println(toString()+ " on step :"+i);}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("My  Thread Ended");
		}

	}

	public static void main(String[] args) {
		// Thread Basics
		Thread mainT=Thread.currentThread();
		System.out.println(mainT);
		mainT.setName("Main Thread");
		mainT.setPriority(8);
		System.out.println(mainT);
        System.out.println(mainT.isAlive());
        try {
			Thread.sleep(1000);
	        System.out.println(mainT.isAlive()+" here too.");

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||");
        //Creating Threads using class Thread
        
        MyThread secondT=new MyThread("My Own Thread");
        secondT.start();
        
        	try {
				
				for(int i=0;i<4;i++)
		        {Thread.sleep(500);
				System.out.println(mainT+" on step: "+i);}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	System.out.println("Main Thread Ended");
        
	
	  System.out.println("||||||||||||||||||||||||||||||||||||||||||||||||||");
      //Creating Threads using class that implements interface
	  Thread myThreadI=new Thread(new MyThreadRunnableInterface(),"Thread from Interface");
      myThreadI.start();
      
      
      Thread anotherThread=new Thread(new MyThreadRunnableInterface(),"Will be waited");
      
      try {
		anotherThread.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}      
    }}
