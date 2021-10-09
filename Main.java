package fr.dauphine.javaavance.td2;

import java.io.IOException;

class Mere {
	public void a() { 
		System.out.println("Mere_a");
	}

	void b(Fille fille) { 
		System.out.println("Mere_b(Fille)");
	}

	void c() {
		System.out.println("Mere_c");
	}

	void c(Mere mere) {
		System.out.println("Mere_c(Mere)");
	}

	static void d() {
		System.out.println("static Mere_d");
	}

	protected void e() {
		System.out.println("Mere_e");
	}

	private void f() {
		System.out.println("Mere_f");
	}

	public void printF() {
		f();
	}

	Object g() {
		System.out.println("Mere_g");
		return 2;
	}

	int h() {
		System.out.println("Mere_h");
		return 2;
	}

	void i() {
		System.out.println("Mere_i");
	}

	void j() throws Exception {
		System.out.println("Mere_j");
	}

	void k() throws IOException {
		System.out.println("Mere_k");
	}

	void l() throws Exception {
		System.out.println("Mere_l");
	}

	void m() throws Exception, ArrayIndexOutOfBoundsException {
		System.out.println("Mere_m");
	}

	void miage() {
		// TODO Auto-generated method stub
		System.out.println("Miage");
		
	}
}

class Fille extends Mere {
	/**
	 * Red�finition
	 */
	void miage() {
		System.out.println("Miage");
	}

	/**
	 * Red�finition
	 */
	public void a() {
		System.out.println("Fille_a");
	}

	/**
	 * Red�finition
	 */
	protected void b(Fille fille) {
		System.out.println("Fille_b(Fille)");
	}

	/**
	 * Red�finition
	 */
	public void c(Mere mere) {
		System.out.println("Fille_c(Mere)");
	}

	/**
	 * Surcharge
	 * @param b
	 */
	void c(Fille b) {
		System.out.println("Fille_c(Fille)");
	}

	/**
	 * Red�finition
	 */
	static void d() {
		System.out.println("static Fille_d");
	}

	/**
	 * Surcharge
	 * @param mere
	 */
	static void d(Mere mere) {
		System.out.println("Fille_d(Mere)");
	}

	/**
	 * Red�finition
	 */
	private void e() {
		System.out.println("Fille_e");
	}

	/**
	 * Red�finition
	 */
	protected void f() {
		System.out.println("Fille_f");
	}

	/**
	 * Red�finition
	 */
	String g() {
		System.out.println("Fille_g");
		return "c";
	}

	/**
	 * Surcharge
	 */
char h() {System.out.println("Fille_h"); return 'c';}

	/**
	 * Surcharge
	 */
	int i() {
		System.out.println("Fille_i");
		return 3;
	}

	/**
	 * Red�finition
	 */
	void j() throws IOException {
		System.out.println("Fille_j");
	}

	/**
	 * Surcharge (ne fonctionne m�me pas � cause de Exception)
	 */
	void k() throws Exception {
		System.out.println("Fille_k");
	}

	/**
	 * Surcharge
	 */
	void l() {
		System.out.println("Fille_l");
	}

	/**
	 * Surcharge
	 */
	void m() throws IOException, IllegalArgumentException {
		System.out.println("Fille_m");
	}
}

/**
 * 1. Le Main affiche :
*42
*42
*24
*24
*24
*24
*Pour � mereFille � on effectue un transtypage implicite (mettre un object de type Fille dans un object de type Mere), donc ce sont les m�thodes de la classe Fille qui sont utilis�es.
*
*2. Lorsqu�on est dans Fille on acc�de � 2 m�thodes (meth() de Mere avec le mot cl� � super � et meth() de Fille).
*Dans Main, on a seulement acc�s � la m�thode meth() de la classe Fille.
*
*3. le Main affiche :
*42
*42
*24
*42 --> printMeth va appeler la m�thode meth() de la classe Mere
*42 --> �a appel la m�thode meth de la classe Mere (pas de polymorphisme pour les m�thodes static)
*42 --> On appelle printMeth de la classe Mere
*Une m�thode � static � ne peut pas �tre sujette � l�h�ritage, les m�thode static sont �valu�es que lors de la compilation.
*
*4. le Main affiche :
*42
*42
*24
*42
*42
*42
*On acc�de aux valeurs auxquelles le champ est rattach� en termes de classe.
*
*Exercice 2
*
*1. Voici les erreurs :
*
*Exception in thread "main" java.lang.Error: Unresolved compilation problems: 
*	The method miage() is undefined for the type Mere
*	The method miage() is undefined for the type Mere
*	The method k() from the type Mere refers to the missing type IOException
*La m�thode miage() est non d�finie dans Mere, et pour la m�thode k() il faut importer la IOException
*
*2. On retire (j�ai mis en commentaire) les m�thodes miage() et k() qui sont appel� dans le main.
*
*3. Une surcharge consiste � r��crire une m�thode avec un nombre d�argument ou un type d�argument diff�rent
*Une red�finition consiste � avoir deux m�thodes avec le m�me nom et les m�mes param�tres, 
*mais l'une des m�thodes est dans la classe parente et l'autre dans la classe fille. 
*Cependant, l�on peut changer la visibilit� de la m�thode tant qu�elle n�est pas � restreinte � par rapport � celle de classe m�re 
*et changer le type de retour tant que le type de retour modifi� h�rite du type de retour de base.
*
*4. Mere_a = L�objet mere appel sa m�thode a()
*Fille_a = mereFille contient une instance de fille donc appel a() de Fille
*Fille_a = appel de la m�thode a() de Fille car instance de Fille
*Fille_a = mereFille contient une instance de fille donc appel a() de Fille malgr� le cast explicit
*Fille_b(Fille) = mereFille contient une instance de fille, appel de la m�thode b() de Fille
*
*Mere_c = c() est d�fini seulement dans M�re donc on appel c() de la classe M�re
*Fille_c(Mere) = mereFille contient une instance de fille donc appel c(M�re) de Fille
*Fille_c(Mere) = mereFille est de classe Mere donc le compilateur appel c(Mere) de la classe Fille
*Fille_c(Mere) = 
*Fille_c(Fille) = appel de c(fille) de la classe Fille par l�instance fille
*
*static Mere_d = appel de d() de la classe Mere par l�instance mere
*static Mere_d = appel de d() de la classe Mere par l�instance mereFille car une m�thode static ne peux pas �tre appliqu� � l�h�ritage
*
*Mere_f = appel de printF() de la classe Mere par l�instance mere par l�instance mere et appel f() de la classe mere
*Mere_f = appel de printF() de la classe Mere par l�instance mereFille par l�instance mere et appel f() de la classe mere
*
*Fille_j = appel j() de la classe Fille par l�instance mereFille car c�est une instance de Fille � l�int�rieur
*Fille_l = appel l() de la classe Fille par l�instance mereFille car c�est une instance de Fille � l�int�rieur
*Fille_m = appel m() de la classe Fille par l�instance mereFille car c�est une instance de Fille � l�int�rieur
*
 * @author Emmanuel
 *
 */
public class Main {
	public static void main(String[] args) throws Exception {
		Mere mere = new Mere();
		Mere mereFille = new Fille();
		Fille fille = new Fille();

		/*
		mere.miage();
		fille.miage();
		mereFille.miage();
		((Fille) mereFille).miage();
		*/

		mere.a();
		mereFille.a();
		fille.a();
		((Mere) mereFille).a();
		mereFille.b(null);

		mereFille.c();
		mereFille.c(mere);
		mereFille.c(mereFille);
		mereFille.c(fille);
		fille.c(fille);

		mere.d();
		mereFille.d();

		mere.printF();
		mereFille.printF();

		mereFille.j();
		/*
		mereFille.k();
		*/
		mereFille.l();
		mereFille.m();
	}
}