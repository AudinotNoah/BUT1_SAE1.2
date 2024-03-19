public class Principale {
    private static final String[] ELEMENTS_DE_DEBUT = {"ABITEBOUL", "ADLEMAN", "AL-KINDI", "ALUR", "BERNERS-LEE",
            "BOOLE", "BUCHI", "BUTLER", "CLARKE", "CURRY"};
    private static final String[] ELEMENTS_DE_FIN = {"RABIN", "RIVEST", "SHAMIR", "SIFAKIS", "TORVALDS",
            "TURING", "ULLMAN", "VALIANT", "WIRTH", "YAO"};

    private static final String[] ELEMENTS_DE_DEBUT_SUPPR = {"ABBADI", "ABERGEL", "ALIAS", "ALIOUI", "AKKUS", "ALAZARD",
            "ALLA", "AIDARA", "ABRANTES", "AARAB"};
    private static final String[] ELEMENTS_DE_FIN_SUPPR = {"WEIS", "ZANIN", "WERQUIN", "YAGOUBI", "WERNERT",
            "WAWRZYNIAK", "ZULIANI", "ZAIRE", "WAVRANT", "VILLAR"};

    
    public static ListeTriee creerListe(String type) {
        ListeTriee liste;
        switch (type) {
            case "contigue":
                liste = new ListeTriee(new ListeContigue(10020));
                break;
            case "chainee":
                liste = new ListeTriee(new ListeChainee(10020));
                break;
            default:
                liste = new ListeTriee(new ListeChaineePlacesLibres(10020));
                break;
        }
        remplirListe(liste, "noms10000.txt");
        return liste;
    }

    public static void remplirListe(ListeTriee liste, String nomFichier) {
        LectureFichier lf = new LectureFichier(nomFichier);
        String[] listeNoms = lf.lireFichier();
        for (String nom : listeNoms) {
            liste.adjlisT(nom);
        }
    }

    public static long mesurerPerformance(ListeTriee l, String[] s, String operation) {
        long dateDebut = System.nanoTime();
        for (String element : s) {
            switch (operation) {
                case "ajouter":
                    l.adjlisT(element);
                    break;
                case "supprimer":
                    l.suplisT(element);
                    break;
                default:
                    break;
            }
        }
        return System.nanoTime() - dateDebut;
    }

    public static long moyenne100(String type, String[] s, String operation) {
        long moyenne = 0;
        for (int i = 0; i < 100; i++) {
            ListeTriee liste = creerListe(type);
            moyenne += mesurerPerformance(liste, s, operation);
        }
        return moyenne / 100;
    }

    public static void ecrireResultat(EcritureFichier fichier, String type, String operation, String position, String[] elements) {
        long moyenne = moyenne100(type, elements, operation);
        String tempsEnNanosecondes = String.format("%.0f", (double) moyenne);
        String ligne = String.format("%s:%s:%s:%s", type, operation, position, tempsEnNanosecondes);
        fichier.ecrireLigne(ligne);
    }

    public static void main(String[] args) {
        EcritureFichier fichierResultat = new EcritureFichier("resultats.csv");
        fichierResultat.ouvrirFichier();

        ecrireResultat(fichierResultat, "contigue", "ajouter", "debut", ELEMENTS_DE_DEBUT);
        ecrireResultat(fichierResultat, "contigue", "ajouter", "fin", ELEMENTS_DE_FIN);
        ecrireResultat(fichierResultat, "contigue", "supprimer", "debut", ELEMENTS_DE_DEBUT_SUPPR);
        ecrireResultat(fichierResultat, "contigue", "supprimer", "fin", ELEMENTS_DE_FIN_SUPPR);

        ecrireResultat(fichierResultat, "chainee", "ajouter", "debut", ELEMENTS_DE_DEBUT);
        ecrireResultat(fichierResultat, "chainee", "ajouter", "fin", ELEMENTS_DE_FIN);
        ecrireResultat(fichierResultat, "chainee", "supprimer", "debut", ELEMENTS_DE_DEBUT_SUPPR);
        ecrireResultat(fichierResultat, "chainee", "supprimer", "fin", ELEMENTS_DE_FIN_SUPPR);

        ecrireResultat(fichierResultat, "chaineelibre", "ajouter", "debut", ELEMENTS_DE_DEBUT);
        ecrireResultat(fichierResultat, "chaineelibre", "ajouter", "fin", ELEMENTS_DE_FIN);
        ecrireResultat(fichierResultat, "chaineelibre", "supprimer", "debut", ELEMENTS_DE_DEBUT_SUPPR);
        ecrireResultat(fichierResultat, "chaineelibre", "supprimer", "fin", ELEMENTS_DE_FIN_SUPPR);

        fichierResultat.fermerFichier();
    }
}
