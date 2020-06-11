import javax.swing.*;

public class login
{
    
    public login()
    {
        JFrame mainFrame = new JFrame();
        mainFrame.setSize(400, 400);
        mainFrame.setVisible(true);
        
        JTextField txtName = new JTextField("", 150);
        JTextField txtPassword = new JTextField("", 150);
        
        JPanel mainPanel = new JPanel();
        
        
        txtName.setVisible(true);
        txtPassword.setVisible(true);
        
        
    }

}
