package tournoidetennis;

public class Arbitre extends Personne{
	private String codeArbitre;
	
	public Arbitre(String nom,String prenom,int poids,int taille,String pays,String codeArbitre) throws CodeArbException {
            super(nom,prenom,poids,taille,pays);
            if(verifierCodeArbitre(codeArbitre))this.codeArbitre=codeArbitre;
            else throw new CodeArbException();
            }

	public String getCodeArbitre() {
		return codeArbitre;
	}

	public void setCodeArbitre(String codeArbitre) throws CodeArbException {
		if(verifierCodeArbitre(codeArbitre)) {
		   this.codeArbitre = codeArbitre;
		}else {
			throw new CodeArbException();
		}
	}
	@Override
	public String toString() {
		return super.toString()+" "+this.codeArbitre;
	}
	// Le code de l'arbitre doit etre un entier code sur deux chiffres.
	public static boolean verifierCodeArbitre(String codeAr) {
		if(codeAr.length()==2) {
			for(int i=0;i<codeAr.length();i++) {
				if(!Character.isDigit(codeAr.charAt(i))) {
					break;
				}
			if(i==codeAr.length()) {
				return true;
			}
			}
		}
		return false;
	}
}
	
