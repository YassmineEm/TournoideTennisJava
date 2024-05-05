package model;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnexion {
	
	
	//Etablir une connexion
	
//	public static void main(String[] args) {
//		String url = "jdbc:mysql://localhost:3306/tournoidetennis";
//		Connection connexion = null;
//		try {
//			connexion=DriverManager.getConnection(url, "root", "nouveaumotdepasse");
//	
//		} catch (SQLException e) {
//			System.out.println("Problème de connexion");	
//		}
//		
//		System.out.println("ok");
//		}
	
	
	//Interroger la base de donnees
	
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/tournoidetennis";
		Connection connexion = null;
		try {
			connexion=DriverManager.getConnection(url, "root", "nouveaumotdepasse");
			Statement st = connexion.createStatement();
			String requete = "select * from pays where continent = 'Europe'";
			ResultSet resultat = st.executeQuery(requete);
			while (resultat.next()) {
			System.out.println(resultat.getInt("idpays")+" " +resultat.getString("nom"));
		}
			
			
		} catch (SQLException e) {
			System.out.println("Problème de connexion");	
		}
		
		System.out.println("ok");
		}
	
	
	//Mise a jour des donnees
	
//		public static void main(String[] args) {
//			String url = "jdbc:mysql://localhost:3306/tournoidetennis";
//			Connection connexion = null;
//			try {
//				connexion=DriverManager.getConnection(url, "root", "nouveaumotdepasse");
//				Statement st = connexion.createStatement();
//				String requete = "update pays set nom = 'Espagne' where idpays = 4 ";
//				int nbre = st.executeUpdate(requete);
//				System.out.println(nbre+"ligne mises a jour");
//			
//				
//				
//			} catch (SQLException e) {
//				System.out.println("Problème de connexion");	
//			}
//			
//			System.out.println("ok");
//			}

}
 





