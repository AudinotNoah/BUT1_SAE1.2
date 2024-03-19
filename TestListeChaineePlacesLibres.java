/**
 * classe de test pour classe ListeChaineePlacesLibres
 */

import static libtest.OutilTest.*;
import static libtest.Lanceur.*;



public class TestListeChaineePlacesLibres {
	
	/**
	 * methode verifiant si une liste contient les memes elements qu'un tableau de chaines
         *
         * @param l liste triee a tester
         * @param reponse contenu attendu de la liste
         */
	public static void verifie(Liste l, String[] reponse){
		// verification
		int p = l.tete();
		for (int i=0;i<reponse.length;i++){
			// teste pas en fin de liste
			assertEquals("liste non vide etape("+i+")",false,l.finliste(p));

			// verifie la valeur
			assertEquals("mauvaise valeur position("+i+")",reponse[i],l.val(p));
			
			// decale place
			p = l.suc(p);
		} 
		// verification liste finie
		assertEquals("mauvaise fin de liste", true, l.finliste(p));
	}




	/**
	 * constructeur liste contigue
	 */
	public void test_01_Contructeur()
	{
		//creation de la liste
		Liste lc=new ListeChaineePlacesLibres(100);
		
		//verification vide
		int tete=lc.tete();
		assertEquals("la liste devrait etre vide", true, lc.finliste(tete));
	}
	
	/**
	 * creation liste, ajout en tete listevide et verification des valeurs 
	 */
	public void test_02_adjtlis_listeVide()
	{

		// reponse attendue
		String[] reponse = {"a"};
			
		//creation de la liste
		Liste lc=new ListeChaineePlacesLibres(100);
		lc.adjtlis("a");
		
		// verification liste
		verifie(lc,reponse);

	}
	
	/**
	 * creation liste, ajout en tete liste existante et verification des valeurs 
	 */
	public void test_03_adjtlis_listeNonVide()
	{

		//creation de la liste
		Liste lc = new ListeChaineePlacesLibres(100);
		lc.adjtlis("a");
		lc.adjtlis("b");
		
		// verification liste
		String[] reponse = {"b","a"};
		verifie(lc,reponse);
	}
	
	/**
	 * test methode suppression 
	 * suppression en tete liste existante
	 */
	public void test_04_suplis_suppressionTete()
	{
		//creation de la liste
		Liste lc = new ListeChaineePlacesLibres(100);
		lc.adjtlis("a");
		lc.adjtlis("b");
		lc.adjtlis("c");
		
		//suppression en tete
		lc.suplis(lc.tete());

		// verification liste
		String[] reponse = {"b","a"};
		verifie(lc,reponse);	
	}
	
	
	
	/**
	 * test methode suppression 
	 * suppression en tete liste avec un element
	 */
	public void test_05_suplis_SuppressionTeteListe1Element()
	{
		//creation de la liste
		Liste lc = new ListeChaineePlacesLibres(100);
		lc.adjtlis("a");
		
		//suppression en tete
		lc.suplis(lc.tete());
		
		// verification liste
		String[] reponse = {};
		verifie(lc,reponse);	

	}
	
	/**
	 * test methode suppression 
	 * suppressions en tete successives
	 */
	public void test_06_suplis_SuppressionTetePlusieursFois()
	{
		//creation de la liste
		Liste lc = new ListeChaineePlacesLibres(100);
		lc.adjtlis("a");
		lc.adjtlis("b");
		lc.adjtlis("c");
		
		//suppression en tete
		lc.suplis(lc.tete());
		lc.suplis(lc.tete());
		
		// verification liste
		String[] reponse = {"a"};
		verifie(lc,reponse);			
	}
	
	/**
	 * test methode suppression 
	 * suppressions en queue
	 */
	public void test_07_suplis_SuppressionQueue()
	{
		//creation de la liste
		Liste lc = new ListeChaineePlacesLibres(100);
		lc.adjtlis("a");
		lc.adjtlis("b");
		lc.adjtlis("c");
		
		//parcours de la tete
		int place=lc.tete();
		place=lc.suc(place);
		place=lc.suc(place);
		//supprime la queue
		lc.suplis(place);
		
		// verification liste
		String[] reponse = {"c","b"};
		verifie(lc,reponse);			

	}
	
	

	/**
	 * test methode suppression 
	 * suppressions au milieu
	 */
	public void test_08_suplis_SuppressionMilieu()
	{
		//creation de la liste
		Liste lc = new ListeChaineePlacesLibres(100);
		lc.adjtlis("a");
		lc.adjtlis("b");
		lc.adjtlis("c");
		
		
		//suppression en tete
		int place=lc.tete();
		place=lc.suc(place);
		//supprime le milieu
		lc.suplis(place);
		
		
		// verification liste
		String[] reponse = {"c","a"};
		verifie(lc,reponse);			
	}
	
	/**
	 * test methode adjlis 
	 * ajout derriere la tete
	 */
	public void test_09_adjlis_AjoutTete()
	{
		//creation de la liste
		Liste lc = new ListeChaineePlacesLibres(100);
		lc.adjtlis("a");
		lc.adjtlis("b");
		
		//ajout derriere la tete
		lc.adjlis(lc.tete(),"c");
				
		
		// verification liste
		String[] reponse = {"b","c","a"};
		verifie(lc,reponse);				}
	
	/**
	 * test methode adjlis 
	 * ajout en Queue
	 */
	public void test_10_adjlis_AjoutQueue()
	{
		//creation de la liste
		Liste lc = new ListeChaineePlacesLibres(100);
		lc.adjtlis("a");
		lc.adjtlis("b");
		lc.adjtlis("c");
		
		//ajout derriere le dernier
		int place=lc.tete();
		place=lc.suc(place);
		place=lc.suc(place);
		lc.adjlis(place,"d");
				
		
		// verification liste
		String[] reponse = {"c","b","a","d"};
		verifie(lc,reponse);				}
	
	/**
	 * test methode adjlis 
	 * ajout au milieu
	 */
	public void test_11_adjlis_AjoutMilieu()
	{
		//creation de la liste
		Liste lc = new ListeChaineePlacesLibres(100);
		lc.adjtlis("a");
		lc.adjtlis("b");
		lc.adjtlis("c");
		
		//ajout derriere le deuxieme
		int place=lc.tete();
		place=lc.suc(place);
		lc.adjlis(place,"d");
				
		// verification liste
		String[] reponse = {"c","b","d","a"};
		verifie(lc,reponse);				}
	
	
	/**
	 * lancement des tests
	 */
	public static void main(String args[])
	{
		lancer(new TestListeChaineePlacesLibres(),args);
		
	}

}
