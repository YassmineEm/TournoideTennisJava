package tournoidetennis;
import java.util.ArrayList;
public class Court {
     private String codeCourt;
     private String typeCourt;
     private ArrayList<Match> matchesProgrammes = new ArrayList<>();
     
     public Court(String codeCourt,String typeCourt) throws CodeCourtException{
    	 if(verifierCodeCourt(codeCourt)) this.codeCourt=codeCourt;
    	 else throw new CodeCourtException();
    	 this.typeCourt=typeCourt;
     }

	public String getCodeCourt() {
		return codeCourt;
	}

	public void setCodeCourt(String codeCourt) throws CodeCourtException{
		if(verifierCodeCourt(codeCourt)) {
		   this.codeCourt = codeCourt;
	}else {
		throw new CodeCourtException();
	  }
	}
	public String getTypeCourt() {
		return typeCourt;
	}

	public void setTypeCourt(String typeCourt) {
		this.typeCourt = typeCourt;
	}
	public void ajouterMatchProgramme(Match match) {
		this.matchesProgrammes.add(match);
	}
    //le code de la court doit etre code sur un seul chiffre.
	public boolean verifierCodeCourt(String c) {
		if(c.length()==1) {
				if(Character.isDigit(c.charAt(0))|| !Character.isDigit(c.charAt(1))) {
					    return false;
				}else {
				return true;
			}
		}
		return false;
		}
	public int nombreMatchesProgrammes() {
        return this.matchesProgrammes.size();
    }
	public boolean estDisponible() {
		for(Match m: matchesProgrammes){
			if(!m.matchTerminer()){
				return false;
			}
		}
		return true;
		}
}

