package fr.dauphine.javaavance.td2.exo3;

public class Value implements Expr {
	private double value;
	
	public Value(double value) {
		
		this.value = value;
	}
	
	public Value() {
		
		this(0.0);
	}
	
	@Override
	public double eval() {
		
		return value;
	}
	
	@Override
	public String toString() {
		
		return Double.toString(value);
	}
}
