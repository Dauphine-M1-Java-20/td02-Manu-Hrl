package fr.dauphine.javaavance.td2.exo3;

public class Multiplication implements Expr {
	private Expr value1;
	private Expr value2;
	
	public Multiplication(Expr value1, Expr value2) {
		 this.value1 = value1;
		 this.value2 = value2;
	}
	
	public Multiplication() {
		this(new Value(0), new Value(0));
	}
	
	@Override
	public double eval() {
		
		return value1.eval() * value2.eval();
	}
	
	@Override
	public String toString() {
		
		return value1.toString() + " * " + value2.toString();
	}
}
