package fr.dauphine.javaavance.td2.exo3;

public class RacineCarree implements Expr {
	private Expr value;
	
	public RacineCarree(Expr value) {
		 this.value = value;
	}
	
	public RacineCarree() {
		this(new Value(0));
	}
	
	@Override
	public double eval() {
		
		return Math.sqrt(value.eval());
	}
	
	@Override
	public String toString() {

		return "\u221a" + value.toString(); // La racine carrée ne s'affiche pas chez moi malgré l'encodage approprié
	}
	
}
