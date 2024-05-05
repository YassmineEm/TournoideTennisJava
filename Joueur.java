package tournoidetennis;
public class Joueur extends Personne {
	 private String codeJoueur;
     private int classementJoueur;
     
    public Joueur(String nom,String prenom,int poids,int taille,String pays,String c,int ClasM) throws CodeJouException{
    	 super(nom,prenom,poids,taille,pays);
    	 this.classementJoueur=ClasM;
    	 if(verifierCodeJoueur(codeJoueur)) this.codeJoueur=c;
    	 else throw new CodeJouException();
    	 }
	public String getCodeJoueur() {
		return codeJoueur;
	}
	public void setCodeJoueur(String codeJoueur) throws CodeJouException {
		if(verifierCodeJoueur(codeJoueur)) {
		this.codeJoueur = codeJoueur;
		}
		else {
			throw new CodeJouException();
		}
	}
	public int getClassementJoueur() {
		return classementJoueur;
	}
	public void setClassementJoueur(int classementJoueur){
		this.classementJoueur = classementJoueur;
	    }
	@Override
	public String toString() {
		return this.codeJoueur+"_"+this.classementJoueur+"_"+super.toString();
	}
	//Le code du joueur doit etre un entier code sur trois chiffres.
	public static boolean verifierCodeJoueur(String c) {
		if(c.length()==3) {
			for(int i=0;i<c.length();i++) {
				if(!Character.isDigit(c.charAt(i))) {
					break;
				}
			if(i==c.length()) {
				return true;
			}
			}
		}
		return false;
	}   
}

