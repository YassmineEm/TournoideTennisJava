package tournoidetennis;
import javax.swing.*;
import java.io.*;
import java.awt.*;
public class InterfaceInscription extends JFrame {
	        private File fichierJoueurs;
            private JTextField nomField,codeField;
            private JPasswordField passwordField;
      public InterfaceInscription() {
        	super("Inscription Joueur de Tennis");
        	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	setSize(300,200);
        	JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));
        	 JLabel nomLabel = createStyledLabel("Nom", Color.GREEN);
             JLabel codeLabel = createStyledLabel("Code", Color.GREEN);
             JLabel passwordLabel = createStyledLabel("Password", Color.GREEN);
             nomField = createStyledTextField(20, Color.BLACK);
             codeField = createStyledTextField(10, Color.BLACK);
             passwordField = createStyledPasswordField(10, Color.BLACK);
             JButton validerButton = createStyledButton("S'inscrire", Color.BLACK);
        	 validerButton.addActionListener(e -> validerInscription());
        	 panel.add(nomLabel);
        	 panel.add(nomField);
        	 panel.add(codeLabel);
        	 panel.add(codeField);
        	 panel.add(passwordLabel);
        	 panel.add(passwordField);
        	 panel.add(validerButton);
        	 add(panel);
        	 setVisible(true);
             // le dossier sera crée s'il n'existe pas .
        	 String directoryPath = "C:\\Users\\dell\\Desktop\\Tournoi de Tennis\\Joueurs";
             File fileJoueur = new File(directoryPath);
             if (!fileJoueur.exists()) {
                 if (fileJoueur.mkdirs()) {
                     System.out.println("Directory created successfully: " + directoryPath);
                 } else {
                     System.err.println("Failed to create directory: " + directoryPath);
                 }
             }
             fichierJoueurs = new File(fileJoueur, "Joueur.txt");
        	}
        private JLabel createStyledLabel(String text, Color color) {
            JLabel label = new JLabel(text);
            label.setForeground(color);
            return label;
        }
        private JTextField createStyledTextField(int columns, Color color) {
            JTextField textField = new JTextField(columns);
            textField.setForeground(color);
            return textField;
        }
        private JPasswordField createStyledPasswordField(int columns, Color color) {
            JPasswordField passwordField = new JPasswordField(columns);
            passwordField.setForeground(color);
            return passwordField;
        }
        private JButton createStyledButton(String text, Color color) {
            JButton button = new JButton(text);
            button.setForeground(color);
            return button;
        }

        private void enregistrerInformations(String nom, String code, String password) {
			try (BufferedWriter writer = new BufferedWriter(new FileWriter(fichierJoueurs, true))){
                writer.write(nom + "," + code + "," + password);
                writer.newLine(); 
                System.out.println("Informations enregistrées avec succès dans le fichier.");
            } catch (IOException e) {
                System.err.println("Erreur lors de l'enregistrement des informations dans le fichier : " + e.getMessage());
            }
        }
        
		private void validerInscription() {
			String nom = nomField.getText();
			String password = new String(((JPasswordField) passwordField).getPassword());
			String code= codeField.getText();
			enregistrerInformations(nom, code, password);
            System.out.println("Nom:" +nom+",Code:"+code+",Password:"+password);
            nomField.setText("");
            passwordField.setText("");
            codeField.setText("");
		}
		public static void main(String[] args) {
	        SwingUtilities.invokeLater(() -> {
	            new InterfaceInscription();
	        });
	    }
	}


