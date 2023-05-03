import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class Utente {

    private String nome;
    private String cognome;
    private String CF;
    private String Indirizzo;
    private String UserID;
    private String password;

    public Utente(String nome, String cognome, String CF, String Indirizzo, String UserID, String password) {

        this.nome = nome;
        this.cognome = cognome;
        this.CF = CF;
        this.Indirizzo = Indirizzo;
        this.UserID = UserID;
        this.password = password;

    }

    public Utente(String UserID, String password) {

        this.UserID = UserID;
        this.password = password;

    }

    /* metodo per la registrazione
    *  inserisce nel file OperatoriRegistrati i dati che immettiamo nei campi
    *  richiesti durante la registrazione.
    * UserID e Password sono separati da <SEP> mentre gli altri campi da virgola */
    public void Registrazione() {
        try {

            FileWriter writer = new FileWriter("data/OperatoriRegistrati.dati.txt", true);
            writer.write(this.UserID + "<SEP>" + this.password + "<SEP>" + this.nome + ", " + this.CF + ", "
                    + this.cognome + ", " + this.Indirizzo + "\n");
            writer.flush();

        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /* metodo di controllo in modo da non potersi registrare
    * se si immettono dei campi vuoti */
    public boolean CampiVuoti() {

        boolean condizione = false;

        if (this.nome.isBlank() || this.cognome.isBlank() || this.CF.isBlank()
                || this.Indirizzo.isBlank() || this.UserID.isBlank() || this.password.isBlank()) {

            condizione = true;
        }
        return condizione;
    }

    /* metodo di controllo in modo da non poter avere
    * più operatori registrati con lo stesso UserID */
    public boolean UserEsistente() {

        boolean condizione = false;

        try {
            BufferedReader reader = new BufferedReader(new FileReader("data/OperatoriRegistrati.dati.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] stringa = line.split("<SEP>");
                if (stringa[0].equals(this.UserID)) {
                    condizione = true;
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return condizione;
    }

    /* metodo di controllo per la verifica del codice fiscale */
    public boolean CFvalido() {

        boolean condizione = false;
        return this.CF.length() == 16;
    }

    /* metodo di controllo per effettuare il login */
    public boolean Login() {

        boolean condizione = false;

        try{
            BufferedReader reader = new BufferedReader(new FileReader("data/OperatoriRegistrati.dati.txt"));
            String line;
            while ((line = reader.readLine())!= null) {
                String[] stringa = line.split("<SEP>");
                if (stringa[0].equals(this.UserID) && stringa[1].equals(this.password)) {
                    condizione = true;
                    break;
                }
            }
        }  catch (Exception ex) {
            ex.printStackTrace();
        }
        return condizione;
    }

    public void CercaAreaGeografica() {
        
    }
}

