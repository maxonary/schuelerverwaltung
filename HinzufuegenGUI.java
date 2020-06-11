import java.sql.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Date;
public class HinzufuegenGUI
{
    //Verbindung zur StatusGUI zum Anzeigen des Erfolgs der Eingaben
    
    
    /**In dieser Klasse können neue Schüler des Internats manuell hinzugefügt werden.**/
    
    /**Persönliche Daten des Schülers**/
    /**Nachname des Kindes**/ 
      public JTextField nachname = new JTextField("Nachname des Schülers");
    
    /**Vorname des Kindes**/
      public JTextField vorname = new JTextField("Vorname des Schülers");
     
    /**Geburtsdatum des Kindes**/
      public JLabel txtGeburtsdatum = new JLabel("Geburtsdatum des Schülers");
      public SpinnerDateModel GebSpinMod = new SpinnerDateModel();
      public JSpinner geburtsdatum = new JSpinner(GebSpinMod);
      
      
    /**Straße**/
      public JTextField strasse = new JTextField("Straße des Schülers");
    
    /**Hausnummer**/
      public JTextField hausnummer = new JTextField("Hausnummer");
    
    /**Postleitzahl**/ 
      public JTextField postleitzahl = new JTextField("PLZ des Schülers");
    
    /**Ort**/
      public JTextField ort = new JTextField("Wohnort des Schülers");
    
    
    /**Persönliche Schul- und Internatsdaten des Schülers**/
    /**Schultyp**/
      public String[] Schultyp = {"Schultyp (bitte Auswählen)","Grundschule", "Gymnasium", "Sekudarschule", "Oberstufe"};
      public JComboBox schultyp = new JComboBox(Schultyp);
    
    /**Klasse**/
      public JLabel txtKlasse = new JLabel(" momentane Klassenstufe"); 
      public Integer[] Klasse = {1, 2, 3 ,4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
      public JComboBox klasse = new JComboBox(Klasse);
      
    /**Wahlpflichtkurs**/
      //Nur auf die gymnasialen Klassen 9 - 10 bezogen
      public String[] Wahlpflichtkurs = {"Wahlpflichtkurs (nur gymansiale Klassen 9-10)","undefiniert","Biologie","Informatik","Kunst","Musik","NaWi","Spanisch","Theater"};
      public JComboBox wahlpflichtkurs = new JComboBox(Wahlpflichtkurs);
      
    /**Schul Beitrittsdatum**/
      public JLabel txtKLSBeitrittDatum= new JLabel(" Beitrittsdatum der KLS"); 
      public SpinnerDateModel BeiSpinMod = new SpinnerDateModel();
      public JSpinner KLSBeitrittDatum = new JSpinner(BeiSpinMod);
      
    /**Zimmer im Internat**/
      public    JLabel txtZimmer = new JLabel(" Ort und Zimmernummer");
      public String[] ZimmerOrt = {"Haus im Park (ab 6 Jahren)", "Gartenhaus (ab 12 Jahren)", "Dachetage (ab 14 Jahren)"};
      public JComboBox zimmerOrt = new JComboBox(ZimmerOrt);
      public Integer[] ZimmerNr = {1,2,3,4,5};
      public JComboBox zimmerNr = new JComboBox(ZimmerNr);    
      
    /**Förderbedarf**/
      public JLabel txtFoerderbedarf = new JLabel(" Förderbedarf?");
      public String[] Foerderbedarf = {"Nein", "Ja"};
      public JComboBox foerderbedarf = new JComboBox(Foerderbedarf);
    
    
    /**Daten des Erziehungsberechtigten des Schülers (bitte nur einen Erziehungsberechtigten eintragen)**/
    /**Nachname des Erziehungsberechtigten**/
      public JTextField EBNachname = new JTextField("Nachname eines Erzehiungsberechtigten");
    
    /**Vorname des Erziehungsberechtigten**/
      public JTextField EBVorname = new JTextField("Vorname des Erzehiungsberechtigten");
    
    /**Beruf des Erziehungsberechtigten**/
      public JTextField EBBeruf = new JTextField("Beruf des Erzehiungsberechtigten");
    
    /**Straße**/
      public JTextField EBStrasse = new JTextField("Straße des Erzehiungsberechtigten");
    
    /**Hausnummer**/
      public JTextField EBHausnummer = new JTextField("Hausnummer des Erzehiungsberechtigten");
    
    /**Postleitzahl**/
      public JTextField EBPostleitzahl = new JTextField("PLZ des Erzehiungsberechtigten");
    
    /**Ort**/
      public JTextField EBOrt = new JTextField("Wohnort des Erzehiungsberechtigten");
    
    /**E-Mail des Erziehungsberechtigten**/
      public JTextField EBEmail = new JTextField("E-Mail des Erzehiungsberechtigten");
    
    /**Festnetztelefonnummer des Erziehungsberechtigten**/
      public JTextField EBTelefon = new JTextField("Festnetztelefonnummer des Erziehungsberechtigten");
    
    /**Mobiltelefon- / Handynummer des Erziehungsberechtigten**/
      public JTextField EBHandy = new JTextField("Mobiltelefon- / Handynummer des Erziehungsberechtigten");
    
      
    /**Anmerkungen zum Schüler**/
      public JTextField anmerkungen = new JTextField("Anmerkungen...");
    
    
    /**Designelemente für Swing / weitere Variablen**/
      public String datenKind;
      public String datenEltern;
      
      
      private JPanel panel = new JPanel();

      //Das Fenster wird an die y_achsen Höhe des Bildschirms angepasst
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      
      private JButton add;
    
      public JLabel platzhalter;
        
      public JLabel anhang1;
      public JLabel anhang2;

    public HinzufuegenGUI()
    {
        final JFrame window = new JFrame("Schüler zur Datenbank hinzufügen");
        
        window.setSize(450,screenSize.height);
        window.setLocationRelativeTo(null);
        panel.setBackground(Color.LIGHT_GRAY);
        
        
        /**Elemente zum Panel im Border Layout hinzufügen**/
        /**Persönliche Daten des Schülers LINE_START**/
        
        panel.add(nachname);
        nachname.setPreferredSize(new Dimension(382, 20));
        panel.add(vorname);
        vorname.setPreferredSize(new Dimension(382, 20));
 
            /**Geburtsdatum des Kindes**/
        panel.add(txtGeburtsdatum);
        txtGeburtsdatum.setPreferredSize(new Dimension(382, 20));
        geburtsdatum.setValue(new Date());
        geburtsdatum.setEditor(new JSpinner.DateEditor(geburtsdatum,"dd.MM.yyyy"));
        panel.add(geburtsdatum);
        geburtsdatum.setPreferredSize(new Dimension(382, 20));
        
        panel.add(strasse);
        strasse.setPreferredSize(new Dimension(382, 20));
        panel.add(hausnummer);
        hausnummer.setPreferredSize(new Dimension(382, 20));
        panel.add(postleitzahl);
        postleitzahl.setPreferredSize(new Dimension(382, 20));
        panel.add(ort);
        ort.setPreferredSize(new Dimension(382, 20));
        
        
        /**Persönliche Schul- und Internatsdaten des Schülers LINE_START**/
        panel.add(schultyp);
        schultyp.setPreferredSize(new Dimension(382, 20));
        panel.add(txtKlasse);
        txtKlasse.setPreferredSize(new Dimension(382, 20));
        panel.add(klasse);
        klasse.setPreferredSize(new Dimension(382, 20));
        panel.add(wahlpflichtkurs);
        wahlpflichtkurs.setPreferredSize(new Dimension(382, 20));
        
            /**Beitrittsdatum der KLS des Kindes**/
        panel.add(txtKLSBeitrittDatum);
        txtKLSBeitrittDatum.setPreferredSize(new Dimension(382, 20));
        KLSBeitrittDatum.setValue(new Date());
        KLSBeitrittDatum.setEditor(new JSpinner.DateEditor(KLSBeitrittDatum,"dd.MM.yyyy"));
        panel.add(KLSBeitrittDatum);
        KLSBeitrittDatum.setPreferredSize(new Dimension(382, 20));
        
        
        panel.add(txtZimmer);
        txtZimmer.setPreferredSize(new Dimension(382, 20));
        panel.add(zimmerOrt);
        zimmerOrt.setPreferredSize(new Dimension(382, 20));
        panel.add(zimmerNr);
        zimmerNr.setPreferredSize(new Dimension(382, 20));
        panel.add(txtFoerderbedarf);
        txtFoerderbedarf.setPreferredSize(new Dimension(382, 20));
        panel.add(foerderbedarf);
        foerderbedarf.setPreferredSize(new Dimension(382, 20));
        
        /**Anmerkungen CENTER**/
        anmerkungen.setPreferredSize(new Dimension(382, 200));
        panel.add(anmerkungen);
        
        
        /**Daten des Erziehungsberechtigten des Schülers LINE_END*/
        panel.add(EBNachname);
        EBNachname.setPreferredSize(new Dimension(382, 20));
        panel.add(EBVorname);
        EBVorname.setPreferredSize(new Dimension(382, 20));
        panel.add(EBBeruf);
        EBBeruf.setPreferredSize(new Dimension(382, 20));
        panel.add(EBStrasse);
        EBStrasse.setPreferredSize(new Dimension(382, 20));
        panel.add(EBHausnummer);
        EBHausnummer.setPreferredSize(new Dimension(382, 20));
        panel.add(EBPostleitzahl);
        EBPostleitzahl.setPreferredSize(new Dimension(382, 20));
        panel.add(EBOrt);
        EBOrt.setPreferredSize(new Dimension(382, 20));
        panel.add(EBEmail);
        EBEmail.setPreferredSize(new Dimension(382, 20));
        panel.add(EBTelefon);
        EBTelefon.setPreferredSize(new Dimension(382, 20));
        panel.add(EBHandy);
        EBHandy.setPreferredSize(new Dimension(382, 20));
        
        
       
        platzhalter = new JLabel(" ");
        platzhalter.setPreferredSize(new Dimension(382, 20));
        panel.add(platzhalter);
        
        
         /** INSERT Knopf **/
         add = new JButton("Fertig");
         add.setPreferredSize(new Dimension(382, 20));
         panel.add(add);
         add.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae) { 
                                         
            }
           });
         
         
        /**Weitere Designelemente PAGE_END**/
 
        anhang1 = new JLabel("Bitte alle Textfelder ausfüllen!");
        panel.add(anhang1);
        anhang1.setPreferredSize(new Dimension(382, 20));
        
        anhang2 = new JLabel("Alle vorherigen Eingaben ersetzen.");
        panel.add(anhang2);
        anhang2.setPreferredSize(new Dimension(382, 20));
        
        
        window.add(panel);
        window.setVisible(true);
    }
    public static void main(String[] args){

        SwingUtilities.invokeLater(new Runnable(){
        public void run(){
            HinzufuegenGUI tdate = new HinzufuegenGUI();
        }
        });
    }
     
}
