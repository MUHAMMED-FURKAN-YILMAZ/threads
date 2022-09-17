package com.tpe.threads;

public class MultiThreading02 {
	
	public static int counter=0;
	

	public static void main(String[] args) throws InterruptedException {

		Thread thread1=new Thread(new Runnable() {
			
			@Override
			public void run() {

				Counter.count();
				System.out.println("Thread1 is completed....");

			}
		});
		
		thread1.start();
		
		// n adet thread'imn oldugu yapida join() kullanmak thread'leri siraya sokmak icin mantikli olmayabilir.
//		thread1.join();
		
		
		
		
		Thread thread2=new Thread(new Runnable() {
			
			@Override
			public void run() {

				Counter.count();
				System.out.println("Thread2 is completed....");
				
			}
		});
		
		thread2.start();
		
		
		
	}

}



 class Counter{
	 
	 // synchronized keyword'u ile bu method'u kullanan thread'leri siraya koyduk ,bu methoda erismek isteyen thread'ler
	 //  methoda tek tek girsin paralel calistirmasin
	 public synchronized static void count() { 
		for (int i = 1; i <= 1000; i++) {
			MultiThreading02.counter++;
		}
		
		System.out.println("Counter: "+MultiThreading02.counter);
		
	}
 }

