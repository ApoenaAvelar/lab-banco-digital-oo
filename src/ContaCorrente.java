

public class ContaCorrente extends Conta {
	
	private double limite = 0.0;
	private double saldoTotal = 0.0 ;
	private double usoLimite = 0.0;



	private void setSaldoTotal() {
		this.saldoTotal = this.saldo + this.limite;
	}

	public ContaCorrente(Cliente cliente) {
		super(cliente);

	}

	public ContaCorrente(Cliente cliente, double limite) {
		super(cliente);
		this.limite = limite;
		this.saldoTotal = this.saldo + this.limite ;

	}
	
	public double getLimite() {
		return limite;
	}

	public void setLimite(double novoLimite) {

		this.limite = novoLimite ;
		this.setSaldoTotal();
		System.out.println("Limite alterado para: " + this.limite);
		System.out.println("Saldo total: " + this.saldoTotal);
		
	}
	
	@Override
	public void depositar(double valor) {
		if (this.usoLimite > 0) {
			if (valor <= this.usoLimite){
				this.limite += valor;
				this.usoLimite -= valor;
				this.setSaldoTotal();
			}
			else {
				this.limite += this.usoLimite ;
				this.saldo += valor - this.usoLimite;
				this.usoLimite = 0;
				this.setSaldoTotal();
				
			}
			
		}
		else {
			saldo += valor;
			this.setSaldoTotal();
		}
		
	}

	
	@Override
	public boolean sacar(double valor) {
		if (saldo >= valor) { 
			saldo -= valor;
			this.setSaldoTotal();
			return true;
		}
		else
			if (this.saldoTotal >= valor) {
				this.usoLimite = (valor - saldo) ;
				this.limite -= this.usoLimite ; 				
				this.saldo = 0.0;			
				this.setSaldoTotal();
				return true;
			}
			else {
				System.out.println("Saldo insuficiente para realizar a operação.");
				return false;
			}
	}
	



	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato Conta Corrente ===");
		super.imprimirInfosComuns();
		System.out.println(String.format("limite: %.2f", this.limite));
		System.out.println(String.format("saldo total: %.2f", this.limite + this.saldo));
	}

	public double getSaldoTotal() {
		return saldoTotal;
	}
	

	
	
	
}
