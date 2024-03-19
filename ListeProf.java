import java.util.ArrayList;

/**
 * une liste geree de maniere contigue 
 * avec une arrayList pour eviter le redimensionnement 
 * 
 * @author vthomas, Étienne André
 *
 */

public class ListeProf implements Liste
{

 	int compteurR;
	int compteurW;
	
	/**
	 * tableau de valeurs
	 */
	ArrayList<String> valeur;
	
	/**
	 * constructeur
	 */
	public ListeProf()
	{
		valeur=new ArrayList<String>();
	}

	@Override
	public void suplis(int p) {
		valeur.remove(p);
		
	}

	@Override
	public void adjtlis(String s) {
		valeur.add(0,s);
		
	}

	@Override
	public void adjlis(int p, String s) {
		valeur.add(p+1,s);
		
	}

	@Override
	public boolean finliste(int p) {
		return p>=valeur.size();
	}

	@Override
	public int tete() {
		return 0;
	}

	@Override
	public int suc(int p) {
		return p+1;
	}

	
	@Override
	public String val(int p) {
		return valeur.get(p);
	}

	
	public String toString()
	{
		String s="*******************\n* contenu liste Prof *\n*******************\n";
		for (String sous:valeur)
		{
			s+=sous;
			s+="\n";
		}
		return(s);
	}

// BEGIN COPIE-COLLE DANS LES DEUX CLASSES DE LISTES
	/**
	 * reinitialise le compteur d'operations (lecture)
	 */
	public void reset_counterR(){
		compteurR = 0;
	}
	
	/**
	 * recupere la valeur du compteur d'operations (lecture)
	 */
	public int get_counterR(){
		return compteurR;
	}
	
	/**
	 * reinitialise le compteur d'operations (ecriture)
	 */
	public void reset_counterW(){
		compteurW = 0;
	}
	
	/**
	 * recupere la valeur du compteur d'operations (ecriture)
	 */
	public int get_counterW(){
		return compteurW;
	}
	// END COPIE-COLLE DANS LES DEUX CLASSES DE LISTES

}
