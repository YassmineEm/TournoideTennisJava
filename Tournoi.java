package tournoidetennis;
import java.util.ArrayList;
import java.util.Date;
import java.io.*;
import java.util.HashMap;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
public class Tournoi<J,A> implements Serializable{
        List<J> Joueurs= new ArrayList<>();
        List<Match> matches = new ArrayList<>(); 
        List<Court> courts = new ArrayList<>();
        List<A> arbitres=new ArrayList<>();
        HashMap<Court,Integer> nbrMatch = new HashMap<>();
        
        
       public J rechercherJoueur(String codeJoueur){
    	   for(int i=0;i<this.Joueurs.size();i++) {
    		   if(((J)this.Joueurs.get(i)).getCodeJoueur()==codeJoueur) {
    			   return (J)this.Joueurs.get(i);
    		   }
    		   }
    	   return null;
    	   }
       public A rechercherArbitre(String codeArbitre){
    	   for(int i=0;i<this.arbitres.size();i++) {
    		   if(((A)this.arbitres.get(i)).getCodeArbitre()==codeArbitre) {
    			   return (A)this.arbitres.get(i);
    		   }
    		   }
    	   return null;
    	   
       }
       public void inscrireJoueur(J joueur) {
    	    Joueurs.add(joueur);
       }
       public void ajouterArbitre(A arbitre) {
    	   arbitres.add(arbitre);
       }
       public void ajouterCourt(Court court) {
           courts.add(court);
       }
       public J genererJoueur(){
    	   Random random = new Random();
    	   int index=random.nextInt(Joueurs.size());
    	   J joueur=(J)Joueurs.get(index);
    	   return joueur ;
       }
       public Match genererMatch(int n,Date d,String l) {
    	   J joueur1 = genererJoueur();
    	   J joueur2=genererJoueur();
    	   do {
               joueur2 = genererJoueur();
           } while (joueur1.equals(joueur2));
    	   Match match = new Match(n,d,l,joueur1, joueur2,assignerArbitre());
    	   return match;
       }
       public A assignerArbitre() {
    	   Random random= new Random();
    	   int a =random.nextInt(arbitres.size());
    	   A arbitre =(A)arbitres.get(a);
    	   return arbitre;
       }
       public int indiceJoueur(String codeJoueur) {
    	   for(int i=0;i<this.Joueurs.size();i++) {
    		   if(((J)this.Joueurs.get(i)).getCodeJoueur()==codeJoueur) {
 			       return i;
    		   }
    	   }
		return -1;
       }
       public void supprimerJoueur(String codeJoueur) {
    	   if(indiceJoueur(codeJoueur) != -1) {
    		   Joueurs.remove(indiceJoueur(codeJoueur));
    	   }
       }
       public HashMap<Court, Integer> matchJouer() {
   		   for(int i=0;i<courts.size();i++) {
   			 this.nbrMatch.put((Court) courts.get(i),((Court) courts.get(i)).nombreMatchesProgrammes());
   		   }
   		   return nbrMatch;
   	   }
       public List<Match> génererMatchesRound(Date d,String l){
    	   List<Match> matches = new ArrayList<>();
           List<J> JoueursRest = new ArrayList<>(Joueurs);
		   List<J> JoueursRound = new ArrayList<>(Joueurs);
           for(int i=0;i<(Joueurs.size())/2;i++) {
        	   Match match=génererMatch(i,d,l);
        	   matches.add(match);
        	   JoueursRest.remove(match.getJoueur1());
        	   JoueursRest.remove(match.getJoueur2());
           }
           for (Match match : matches) {
        	   if(match.JoueurGangant()==match.getJoueur1()) {
        		   J loser = match.getJoueur2();
        		   JoueursRound.remove(loser);
        	   }else {
        		   J loser = match.getJoueur1();
        		   JoueursRound.remove(loser);
        	   }
           }
           return matches;
       }
       public void writeJoueursInFile(String fichierPath) {
           try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichierPath))) {
               for (J joueur :Joueurs) {
                   writer.write(joueur.toString());
                   writer.newLine();
               }
               System.out.println("Joueurs enregistrés avec succés");
           } catch (IOException e) {
                e.printStackTrace();
           }
       }
       public void sauvegarderTournoi(String fichierTournoi) {
    	   ObjectOutputStream os;
		try {
			os = new ObjectOutputStream(new FileOutputStream (fichierTournoi));
	        os.writeObject(this);
	        System.out.println("Tournoi sauvegardé avec succèc");
        } catch(IOException e) {
    	   e.printStackTrace();
       }
       }
       public static Tournoi chargertournoi(String fichierTournoi) {
    	   try (ObjectInputStream is = new ObjectInputStream(new FileInputStream(fichierTournoi))) {
               Tournoi tournoiCharge = (Tournoi) is.readObject();
               System.out.println("Tournoi chargé avec succès : " + tournoiCharge);
               return tournoiCharge;
           }catch (IOException | ClassNotFoundException e) {
               e.printStackTrace();
               return null;
           }
       }
        public int nombreDeJoueursDansFichier(String fichierPath) {
           int count = 0;
           try {
                BufferedReader reader = new BufferedReader(new FileReader(fichierPath));
                while (reader.readLine() != null) {
                    count++;
            }
            reader.close();
            } catch (IOException e) {
                 e.printStackTrace();
            }
            return count;
        }
    }