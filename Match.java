package tournoidetennis;
import java.util.Date;
public class Match {
	private int numeroMatch;
	private Date dateMatch;
	private String lieuMatch;
	private Joueur joueur1;
	private Joueur joueur2;
	private int scoreJoueur1;
	private int scoreJoueur2;
	private Arbitre arbitre;
	
	public Match(int numeroMatch,Date dateMatch,String lieuMatch,Joueur joueur1,Joueur joueur2,Arbitre a) {
	       this.numeroMatch=numeroMatch;
	       this.dateMatch=dateMatch;
	       this.lieuMatch=lieuMatch;
	       this.arbitre=a;
	       this.joueur1 =joueur1;
	       this.joueur2 =joueur2;
	       this.scoreJoueur1=0;
	       this.scoreJoueur2=0;
	}
	public void Joueur1Scores() {
		scoreJoueur1++;
	}
    public void Joueur2Scores() {
    	scoreJoueur2++;
    }

	public int getNumeroMatch() {
		return numeroMatch;
	}


	public void setNumeroMatch(int numeroMatch) {
		this.numeroMatch = numeroMatch;
	}


	public Date getDateMatch() {
		return dateMatch;
	}


	public void setDateMatch(Date dateMatch) {
		this.dateMatch = dateMatch;
	}


	public String getLieuMatch() {
		return lieuMatch;
	}


	public void setLieuMatch(String lieuMatch) {
		this.lieuMatch = lieuMatch;
	}


	public Joueur getJoueur1() {
		return joueur1;
	}


	public void setJoueur1(Joueur joueur1) {
		this.joueur1 = joueur1;
	}


	public Joueur getJoueur2() {
		return joueur2;
	}
	public Arbitre getArbitre() {
		return arbitre;
	}

	public void setArbitre(Arbitre arbitre) {
		this.arbitre = arbitre;
	}
	public void setJoueur2(Joueur joueur2) {
		this.joueur2 = joueur2;
	}
	public void enregistrerScore(int scoreJoueur1,int scoreJoueur2) {
		this.scoreJoueur1=scoreJoueur1;
		this.scoreJoueur2=scoreJoueur2;
	}
	public String afficherScore() {
	          return "le resultat du match est:"+this.scoreJoueur1+"vs"+this.scoreJoueur2;
	}
    public String afficherResultat() {
    	if(this.scoreJoueur1 >= 4 && this.scoreJoueur1 - this.scoreJoueur2 >= 2) {
    		return "Joueur 1 wins";
    	} else if(this.scoreJoueur2>= 4 && this.scoreJoueur2 - this.scoreJoueur1 >= 2) {
    		return "Joueur 2 wins";
    	}else {
    		return null;
    		}
    	}
    public boolean estTerminer() {
    	if(this.afficherResultat()!=null) {
    		return true;	
    	}
    	return false;
    }
    public Joueur JoueurGangant() {
    	if(this.estTerminer()) {
    	     if(afficherResultat()=="Joueur 1 wins") {
    		     return joueur1;
    	     }else {
    		     return joueur2;
             }
    	}
    	return null;
    }
}
	

