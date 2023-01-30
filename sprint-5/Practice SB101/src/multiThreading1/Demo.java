package multiThreading1;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		
		ThreadA t1 = new ThreadA();
		t1.start();
		
	}
	
}

class ThreadA extends Thread{
	
	@Override
	public void run() {
		
		for(int i = 0; i <= 10; i++) {
			System.out.println(i);
			if(i == 5) {
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
}


