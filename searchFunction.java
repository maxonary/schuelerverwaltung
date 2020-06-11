import javax.swing.event.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;

public class searchFunction
{

    public searchFunction()
    {
        /**"tableModel" mit dem Namen des Tabellen Model ersetzen**/
        //TableRowSorter sorter = new TableRowSorter<>("tableModel";
        /**"table" mit dem Namen der Tabelle ersetzen**/
        //"table".setRowSorter(sorter);                                  
        
        JTextField searchField = new JTextField("Suchen", 50);
        searchField.setVisible(true);
        /**"topPanel" muss mit dem Namen eines Panels ersetzt werden, Ich würde eins ganz oben über der Tabelle erstellen**/
        //topPanel.add(searchField);                                      
        searchField.setBackground(Color.decode("#777777"));
        searchField.setForeground(Color.WHITE);
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
                           //sorter.setRowFilter(null);                             //Das Kommentar muss noch entfernt werden, damit die Suchfunktion funktioniert
        } else {
                           //sorter.setRowFilter(RowFilter.regexFilter(str));       //Das Kommentar muss noch entfernt werden, damit die Suchfunktion funktioniert
        }
        }
        });
    }

}
