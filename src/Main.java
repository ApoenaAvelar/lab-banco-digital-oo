

public class Main {

	
	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton, 100.0);
		Conta poupanca = new ContaPoupanca(venilton);

		System.out.println("depositar 50");
		((ContaCorrente) cc).depositar(50);
		System.out.println("sacar 20");
		((ContaCorrente) cc).sacar(20);
		((ContaCorrente) cc).setLimite(80);
		cc.imprimirExtrato();
		
		System.out.println("sacar 50");
		((ContaCorrente) cc).sacar(50);
		cc.imprimirExtrato();
		
	    ((ContaCorrente) cc).setLimite(80);
	    System.out.println("transferir 50");
		((ContaCorrente) cc).transferir(50, poupanca);
		cc.imprimirExtrato();
		System.out.println("transferir 60");
		((ContaCorrente) cc).transferir(60, poupanca);
		
		cc.imprimirExtrato();
		poupanca.imprimirExtrato();
		System.out.println("depositar 70");
		((ContaCorrente) cc).depositar(70);
		cc.imprimirExtrato();
	}

}
