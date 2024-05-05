package tournoidetennis;

public class Personne {
      private String nom;
      private String prenom;
      private int poids;
      private int taille;
      private String pays;
      
      public Personne() {
      }
      
      public Personne(String nom,String prenom,int poids,int taille,String pays) {
    	  this.nom=nom;
    	  this.prenom=prenom;
    	  this.poids=poids;
    	  this.taille=taille;
    	  this.pays=pays;
      }
      public String getNom() {
         return nom;
}  
      public void setNom(String nom) {
    	  this.nom=nom;
      }
      public String getPrenom() {
    	  return prenom;
      }
      public void setPrenom(String prenom) {
    	  this.prenom=prenom;
      }
      public int getTaille() {
    	  return taille;
      }
      public void setTaille(int taille) {
    	  this.taille=taille;
      }

	public int getPoids() {
		return poids;
	}

	public void setPoids(int poids) {
		this.poids = poids;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
	@Override
	public String toString() {
		return this.getNom()+" "+this.getPrenom()+" son poids:"+this.getPoids()+" sa taille:"+this.getTaille()+" son pays:"+this.getPays();
	}
	@Override 
	public boolean equals(Object o) {
			Personne p= (Personne)o;
			return this.getNom().equals(p.getNom())&& this.getPrenom().equals(p.getPrenom()) && this.getPays().equals(p.getPays());
	}
}