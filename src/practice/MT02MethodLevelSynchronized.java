package practice;
/*
  =========================================   SYNCHRONIZED  ==========================================================
  
multi-threading çalışma koşullarında birden fazla thread'in aynı kaynağa (değişken method, class, bellek vb)
erişimi (okuma veya yazma) sırasında verinin güncellenmesi ve tutarlılığı ile ilgili sorunlar çıkabilir.
Bu tutarsızlığı engellemek için synchronized keywordu kullanılabilir.
Kısaca, Syncronization bir kaynağın tread'ler tarafından eş zamanlı kullanımına kapatılması (Lock) işlemidir.

Synchronized keywordunun farklı kullanımları bulunmaktadır.
1- Eğer bir metot "synchronized" yapılırsa (Method-Level Syncronization) bu metota aynı andan birden 
	fazla thread'in erişimine izin verilmez.

2- Eğer bir metot yerine o metodun ait olduğu class'ı aynı anda birden fazla thread'in kullanımına kapatmak
  (class-level Synchronization) istersek o zaman "synchronized static" kullanmalıyız.

3- Eğer bir metot içerisinde belirli bir kismin eş zamanlı thread kullanımına kapatılmasını istenire
  "synchronized block" (block-level Synchronization) kullanılmalı.

   */
public class MT02MethodLevelSynchronized {
    // task  messi ronaldo cekismesini multi thread yapip altin ayakkabi methodu'na erisimini dengeleyin. 
	// iyi olan kazansin
    // synchronized ile bi sana bi bana olabilir mi?
    // class create ediniz class izinde method create edin bu methoda messi ronaldo saldirsin


	public static int altinKrampon=0;// ayni anda erisilecek kaynak
	
	
	public static void main(String[] args) {
		
		
		Thread thRonaldo = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				Cekisme.kramponKimin("Krampon Ronaldo'nun");	
			}
		});
		
		Thread thMessi = new Thread(new Runnable() {
			
			@Override
			public void run() {
				
				Cekisme.kramponKimin("Krampon Messi'nin");
			}
		});
		
	
		thRonaldo.start(); thMessi.start();
		
	}
	
}


class Cekisme {// multiple class
	
	public synchronized static void kramponKimin(String thread) {
		// synchronized keywordu ile diger thread'ler tarafindan es zamanli erisimi lock'ladik
		
		for (int i = 1; i <=10 ; i++) {
			MT02MethodLevelSynchronized.altinKrampon++;
			
			System.out.println("Altin krampon - " + thread + " : "+ MT02MethodLevelSynchronized.altinKrampon);
		}
		
		
	}
	
}






