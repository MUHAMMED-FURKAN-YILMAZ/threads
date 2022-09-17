package com.tpe.threads;

public class Volatile {
	
	// Eger thread'ler bir degere bagli ise, kod yapisinda sonsuz dongu olusma riskiniz var.
	// bu riski ortadan kaldirmak icin volatile kullanmayi unutma
	volatile public static int flag=0;
	
	
	public static void main(String[] args) {
		
		Thread thrad1=new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				while(true) {
					if(flag==0) {
						System.out.println("Thread1 running");
					}else {
						break;
					}
				}
				
			}
		});
		
		thrad1.start();
		
		
		Thread thread2= new Thread(new Runnable() {
			
			@Override
			public void run() {

				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				flag=1;
				
				System.out.println("The value of flag is updated");
			}
		});
		
		thread2.start();

		
	}

}
