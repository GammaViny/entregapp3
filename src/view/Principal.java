package view;

public class Principal {
	
	static String str0 = "0";
	static String str1 = "1";
	
	public static void main(String args[]) {
		Thread t = new Thread() {// instancia da thread
		public void run() {
			synchronized (str0) {// aloca o String str0 para a thread t
				System.out.println(str0);
				synchronized (str1) {
					// durante a execução chama o str1
				}
			}
		}
		};
		Thread t1 = new Thread() {
			public void run() {
				synchronized (str1) {// aloca o String str1 para a thread t1
					System.out.println(str1);
					synchronized (str0) {
						// durante a execução chama o str0			
					}
				}
			}
		};
		t.start();
		t1.start();
		//quando as duas threads são chamadas alocam recursos que a outra depende, assim travando o processo
	}
}