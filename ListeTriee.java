/**
 * Classe ListeTriee
 * @author Étienne André
 * @since 2021-11-12
 *
 */



public class ListeTriee{

    // Attribut de liste sous-jacente
    private Liste liste;
    
    public ListeTriee(Liste listevide){
	// Affectation de la liste vide à l'attribut privé
	    liste = listevide;
    }
    
    /**
     * retourne la premiere place de la listee
     * @return tete de liste
     */
    public int tete(){
        return liste.tete();
    }
	
    /**
     * permet de connaitre la place suivante dans la liste
     * @param p place en cours
     * @return place derriere p dans la liste
     */
    public int suc(int p){
	    return liste.suc(p);
    }
    
    /**
     * retourne la valeur associee a la place p
     * @param p place de la liste
     * @return la valeur associee  p
     */
    public String val(int p){
	    return liste.val(p);
    }
 
    /**
     * indique si la place p est a la fin de la liste ou non
     * @param p place de la liste
     * @return vrai si p est a la fin de la liste, faux sinon
     */   
    public boolean finliste(int p){
	    return liste.finliste(p);
    }
	
    
    /**
     * ajoute un element au bon endroit dans la liste triee
     * @param chaine element a inserer
     */
    public void adjlisT(String chaine){
        boolean insere = false;
        int place = this.tete();
        int pPre = place;
        while (this.finliste(place) == false && insere == false){
            if (this.val(place).compareTo(chaine) > 0){
                if (place == this.tete()){
                    this.liste.adjtlis(chaine);
                }
                else {this.liste.adjlis(pPre, chaine);}
                insere = true;
            }
            else {
                pPre = place;
                place = this.suc(place);
            }
        }
        if (insere == false){
            if (place == -1){
                this.liste.adjlis(0, chaine);
            }
            else {
            this.liste.adjlis(place-1, chaine);
            }
        }
    }
	
    /**
     * permet de supprimer un element d'une liste. Supprime le premier element dont la valeur est egale a "chaine" ; ne fait rien si "chaine" n'appartient pas a la liste.
     * @param chaine l'element a supprimer 
     */
    public void suplisT(String chaine){
        int place = this.tete();
        boolean supprime = false;
        while (this.finliste(place) == false && supprime == false){
            if (this.val(place).compareTo(chaine) == 0){
                this.liste.suplis(place);
                supprime = true;
            }
            else {
                place = this.suc(place);
            }
        }
    }
		
    public String toString(){
	return liste.toString();
    }
}
