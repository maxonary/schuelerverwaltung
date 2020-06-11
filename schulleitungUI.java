            import java.awt.*;
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

            
            public class schulleitungUI extends JFrame {
                final DefaultTableModel model;

                
            
               public schulleitungUI() {

                   String[] colNames = new String[] { "Name", "Vorname", "Geburtsdatum","Klasse" , "Schultyp" };
                   
                   /**Datenbank muss Initialisiert werden**/
                   //DBHelper DB = new DBHelper();  
                   
                   /** Datenbank Methode muss hinzugefügt werden**/
                   // ArrayList<String[]> antwort = "Anfrage an die Datenbank"
                            
                    model = new DefaultTableModel(colNames, 0);
                    TableRowSorter sorter = new TableRowSorter<>(model);
                    JTable table = new JTable(model);
                    table.setRowSorter(sorter);
                    JScrollPane sPane = new JScrollPane(table);
                                        
                    getContentPane().add(sPane, BorderLayout.CENTER);
            
                    JPanel topPanel = new JPanel();
                    topPanel.setBackground(Color.decode("#777777"));
                    getContentPane().add(topPanel, BorderLayout.NORTH);
                    topPanel.setVisible(true);

                    //for(int i=0; i<antwort.size(); i++){    
                    //    model.addRow(antwort.get(i)); 
                    //}                    

            
                    JTextField searchField = new JTextField("Suchen", 50);
                    searchField.setVisible(true);
                    topPanel.add(searchField);
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
                           sorter.setRowFilter(null);
                        } else {
                           sorter.setRowFilter(RowFilter.regexFilter(str));
                        }
                     }
                    });
            
                    this.setSize(900, 550);
                    this.setLocationRelativeTo(null);
                    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    this.setVisible(true);
                    

                           
                    
                            
                    JPanel bottomPanel = new JPanel();
                    bottomPanel.setVisible(true);
                    getContentPane().add(bottomPanel, BorderLayout.SOUTH);
            
                    JButton closeButton = new JButton("Schließen");
                    closeButton.setVisible(true);
                    bottomPanel.add(closeButton);
            
                    closeButton.addActionListener(new ActionListener()
                    {
                         public void actionPerformed(ActionEvent e){
                         System.exit(0);
                     }});

                     
                                          
             
    }
    public static void main(String[] args) {
          new schulleitungUI();
    }
    
}
