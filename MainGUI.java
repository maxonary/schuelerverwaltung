import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.util.*;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.event.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;
import java.util.ArrayList;
            
import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;

public class MainGUI
{
        HinzufuegenGUI hinzufuegenGUI = new HinzufuegenGUI();
        
      /**Designelemente**/
      private JFrame window = new JFrame("Projekt Schülerverwaltung");
      //Das Fenster wird an die x_achsen Breite des Bildschirms angepasst
      Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
      private JPanel panel = new JPanel();
        
      private JLabel kopfzeile = new JLabel("   Hier können die Daten der Internatsschüler und ihrer Erziehungsberechtigten aus der Datenbank ausgelesen werden. Die IDs sind bei Erziehungsberechtigtem und Kind identisch. Bitte wählen Sie die gewünschte Tabelle.");
      
      /**Ein LINE_END Panel (rechte Seite) für weitere Knöpfe und Checkboxen**/
      JPanel panelRechts = new JPanel();
      
      /**Auswahl der verschiedenen Tabellen**/

      /**Die Anzeigetabelle**/
      //Das CENTER Panel mit den Tabellen
      private JPanel panelCenter = new JPanel();
      
      //Schüler
      private String[] Schuelerdaten = new String[]{" ID", " Nachname", " Vorname", " Geburtsdatum", 
          " Straße", " Hausnummer", " Postleitzahl", " Ort", " Schultyp", " Klassenstufe", 
          " Wahlplichtkurs", " Beitrittsdatum", " Zimmerort", " Zimmernummer", " Förderbedarf", " Anmerkungen"};
       private DefaultTableModel model1 = new DefaultTableModel( Schuelerdaten,  0);
       private JTable table1 = new JTable( model1 );
       //Die Tabelle scrollbar machen
       private JScrollPane schuelerpanel = new JScrollPane( table1 );
      
      
      //Erziehungsberechtigte
      private String[] Elterndaten = new String[]{" ID", " Nachname", " Vorname", " Beruf", 
          " Straße", " Hausnummer", " Postleitzahl", " Ort", " E-Mail", " Festnetztelefon", 
          " Mobiltelefon"};
       private DefaultTableModel model2 = new DefaultTableModel( Elterndaten, 0);
       private JTable table2 = new JTable( model2 );
       //Die Tabelle scrollbar machen
       private JScrollPane elternpanel = new JScrollPane( table2 );
      
      final static String internatsschueler = "Internatsschüler";
      final static String erziehungsberechtige = "Erziehungsberechtigte";

      /**Knöpfe und ComboBox und Button auf der rechten Seite**/
      
      private String[] Auswahl = {internatsschueler, erziehungsberechtige};
      private JComboBox auswahl = new JComboBox(Auswahl);
      
      private JButton hinzufuegen = new JButton( "Weitere Schüler hinzufügen" );
      
     public MainGUI()
     {
      window.setSize(screenSize.width,800);
      window.setLocationRelativeTo(null);
      
      window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      panel.setLayout( new java.awt.BorderLayout());
      
      /**Die Anzeigetabelle**/
      panelCenter.setLayout(new CardLayout());
      panelCenter.add(schuelerpanel, internatsschueler);
      TableRowSorter sorter1 = new TableRowSorter<>(model1);
      table1.setRowSorter(sorter1);
      panelCenter.add(elternpanel, erziehungsberechtige);
      TableRowSorter sorter2 = new TableRowSorter<>(model2);
      table2.setRowSorter(sorter2);
      panel.add(panelCenter, BorderLayout.CENTER);
      
      /**Kopfzeile der GUI mit Suchfunktion**/
      panel.add(kopfzeile, BorderLayout.PAGE_START);
      kopfzeile.setPreferredSize(new Dimension(1000, 50));
      panel.setBackground(Color.decode("#0041C2"));
      kopfzeile.setForeground(Color.WHITE);

      /**Das rechte Panel mit den Auswahlmöglichkeiten**/
      panelRechts.setPreferredSize(new Dimension(220,150));
      panelRechts.setBackground(Color.LIGHT_GRAY);

      //Das Suchfeld
      JTextField searchField = new JTextField("Suchen");
      //searchField.setVisible(true);
      panelRechts.add(searchField);
      searchField.setPreferredSize(new Dimension(200, 50));
      searchField.setHorizontalAlignment(JTextField.CENTER);
      
       searchField.getDocument().addDocumentListener(new DocumentListener() {
       @Override
                     public void insertUpdate(DocumentEvent e) {
                        search(searchField.getText());
       }
       @Override
                     public void removeUpdate(DocumentEvent e) {
                        search(searchField.getText());
       }
       @Override
                     public void changedUpdate(DocumentEvent e) {
                        search(searchField.getText());
       }
       public void search(String str) {
                        if (str.length() == 0) {
                           sorter1.setRowFilter(null);
                           sorter2.setRowFilter(null);
                        } else {
                           sorter1.setRowFilter(RowFilter.regexFilter(str));
                           sorter2.setRowFilter(RowFilter.regexFilter(str));
                        }
       }
      });
      
      //Das Auswahlfenster
      auswahl.setPreferredSize(new Dimension(200,100));
      auswahl.setEditable(false);
      auswahl.addItemListener(new ItemListener()
      {
         public void itemStateChanged(ItemEvent evt) {
               CardLayout cl = (CardLayout)(panelCenter.getLayout());
               cl.show(panelCenter, (String)evt.getItem());
         }
         });
      panelRechts.add(auswahl); 
      
      panelRechts.add(hinzufuegen);
      hinzufuegen.setPreferredSize(new Dimension(200,50));
      hinzufuegen.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ae) {
                hinzufuegenGUI.HinzufuegenGUI();
            }
            });
      panel.add(panelRechts, BorderLayout.LINE_END);

      window.add(panel);
      window.setVisible(true);
     }

    
}
