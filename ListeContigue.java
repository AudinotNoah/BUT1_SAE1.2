/**
 * implementation contigue d'une liste 
 * @author vthomas, Étienne André
 *
 */
public class ListeContigue implements Liste{

	/**
	 * taille actuelle de la liste
	 * correspond au nombre de cases utilisees du tableau
	 */
	private int taille;
	
	
	/**
	 * le tableau de la liste avec une tailleMax
	 */
	private  String[] tab;
	private  int tailleMax;
	
	/**
	 * constructeur de la liste
	 * @param t tailleMax de la liste
	 */
	public ListeContigue(int t)
	{
		taille=0;
		tailleMax=t;
		tab=new String[tailleMax];
	}
	
	/**
	 * calcule le successeur
	 * consiste a decaler p de 1
	 */
	@Override
	public int suc(int p) {
		return p+1;
	}
	
	
	
	/**
	 * la tete de la liste est forcement 0
	 * car on commence au debut du tableau 
	 */
	@Override
	public int tete() {
		return 0;
	}
	
	
	/**
	 * on est en findeliste si on a depasse le dernier element
	 * a savoir la taille de la liste (puisque contigue)
	 */
	@Override
	public boolean finliste(int p) {
		return p>=taille;
	}


	/**
	 * supprimer consiste a decaler les elements pour
	 * les garder contigus les uns aux autres
	 */
	@Override
	public void suplis(int p) {
		for (int i=p;i<taille;i++)
		{
			tab[i]=tab[i+1];
		}
		taille--;
		
	}

	/**
	 * ajouter en tete consiste a decaler les elements pour liberer la place 0
	 * et y mettre le nouvel element
	 */
	@Override
	public void adjtlis(String s) {
		for (int i=taille;i>0;i--)
		{
			tab[i]=tab[i-1];
		}
		tab[0]=s;
		taille++;
	}

	/**
	 * ajouter a un endroit consiste a liberer la place en decalant (pour maintenir ordre)
	 */
	@Override
	public void adjlis(int p, String s) {
		for (int i=taille;i>p+1;i--)
		{
			tab[i]=tab[i-1];
		}
		tab[p+1]=s;
		taille++;
	}


	/**
	 * valeur consiste simplement a regarder dans la place du tableau
	 */
	@Override
	public String val(int p) {
		return tab[p];
	}
	
	
	/**
	 * affiche la liste sous forme de chaine
	 */
	public String toString()
	{
		String s="*******************\n* contenu liste CONTIGUE *\n*******************\n";
		for (int i=0;i<taille;i++)
		{
			s+=tab[i]+"\n";
		}
		s+="********************";
		return(s);
	}

}
