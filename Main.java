package tournoidetennis;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Main {

	public static void main(String[] args){
		File folder = new File("C://Users/dell/Desktop/Tournoi de Tennis");
		File fileJoueur = new File("C://Users/dell/Desktop/Tournoi de Tennis/Joueurs");
		File fileMatches = new File("C://Users/dell/Desktop/Tournoi de Tennis/Matches");
		File fileArbitre = new File("C://Users/dell/Desktop/Tournoi de Tennis/Arbitres");
		if(!folder.exists())
		{ 
			folder.mkdir();
		}
		if(!fileJoueur.exists())
		{
			try {
				fileJoueur.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		if(!fileMatches.exists())
		{
			try {
				fileMatches.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		if(!fileArbitre.exists())
		{
			try {
				fileArbitre.createNewFile();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}

	}
}
	