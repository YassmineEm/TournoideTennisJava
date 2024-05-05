package tournoidetennis;
import javax.swing.*;
import java.awt.*;
import java.io.*;
public class InterfaceSingIn extends JFrame{
	private JTextField codeField;
    private JPasswordField passwordField;
    public InterfaceSingIn() {
        super("Connexion Joueur de Tennis");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

        JLabel codeLabel = createStyledLabel(" Code ", Color.GREEN);
        JLabel passwordLabel = createStyledLabel("Mot de passe", Color.GREEN);

        codeField = createStyledTextField(20, Color.BLACK);
        passwordField = createStyledPasswordField(20, Color.BLACK);

        JButton connectButton = createStyledButton("Se connecter", Color.BLACK);
        connectButton.addActionListener(e -> validerConnexion());

        panel.add(codeLabel);
        panel.add(codeField);
        panel.add(passwordLabel);
        panel.add(passwordField);
        panel.add(connectButton);

        add(panel);
        setVisible(true);
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
    private void validerConnexion() {
        String enteredCode = codeField.getText();
        String enteredPassword = new String(passwordField.getPassword());
        if (isValidCredentialsFromFile(enteredCode, enteredPassword)) {
            JOptionPane.showMessageDialog(this, "Connexion réussie !");
        } else {
            JOptionPane.showMessageDialog(this, "Échec de la connexion. Veuillez vérifier vos informations.");
        }
    }
    private boolean isValidCredentialsFromFile(String enteredCode, String enteredPassword) {
        String filePath = "C:\\Users\\dell\\Desktop\\Tournoi de Tennis\\Joueurs\\joueur.txt";
        // filePath existe déja dans mon ordinateur.
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String storedNom = parts[0].trim();
                    String storedCode = parts[1].trim();
                    String storedPassword = parts[2].trim();
                    if (storedCode.equals(enteredCode) && storedPassword.equals(enteredPassword)) {
                        return true; 
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier : " + e.getMessage());
        }

        return false;
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
        	new InterfaceSingIn();
        });
    }
}
