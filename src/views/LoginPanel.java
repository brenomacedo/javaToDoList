package views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LoginPanel extends JPanel implements MouseListener {
    int width = 300;
    int height = 400;
    int inputWidth = 600/3;
    int buttonWidth = inputWidth - 30;
    int panelHeight = 400;
    int panelWidth = 300;
    int inputPositionInPanel = this.panelWidth/2 - (this.inputWidth/2);
    int buttonPositionPanel = this.panelWidth/2 - (this.buttonWidth/2);
    final JTextField usernameInput = new JTextField(60);
    final JPasswordField passwoField = new JPasswordField(60);

    LoginPanel () {
        
        
        final JLabel usernameLabel = new JLabel("Digite seu username: ");
        final JLabel passwordLabel = new JLabel("Digite sua senha: ");
        final JButton loginButton = new JButton("Login");
       
    
        usernameLabel.setBounds(this.inputPositionInPanel, 165, 200, 25);
        passwordLabel.setBounds(this.inputPositionInPanel, 225 , 200, 25);
        usernameInput.setBounds( this.inputPositionInPanel, 195 , this.inputWidth, 25);
        passwoField.setBounds(this.inputPositionInPanel, 250, this.inputWidth, 25);
        loginButton.setBounds(this.buttonPositionPanel, 300, this.buttonWidth, 30);

        loginButton.setBackground(Color.CYAN);
       
        usernameLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        usernameLabel.setForeground(Color.decode("#2596be"));
        passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        passwordLabel.setForeground(Color.decode("#2596be"));

        //como fazer imagem
        /* ImageIcon iconeConfiguracoes = new ImageIcon("images/config.png");
        Image imageIconeConfiguracoes = iconeConfiguracoes.getImage();
        Image novoIconeConfiguracoes = imageIconeConfiguracoes.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
        iconeConfiguracoes = new ImageIcon(novoIconeConfigurac oes);*/


        loginButton.addMouseListener(this);
       

        ImageIcon backRec = new ImageIcon("images/logIN.png");
        Image imageBack = backRec.getImage();
        Image novaimageBack = imageBack.getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
        backRec = new ImageIcon(novaimageBack);

        JLabel backLabel = new JLabel();
        backLabel.setIcon(backRec);
        backLabel.setBounds(0, 0, 300, 150);
       

       // this.getContentPane().add(mainContent);
       /*  this.getContentPane().add(usernameInput);
        this.getContentPane().add(passwoField);
        this.getContentPane().add(loginButton);
         */
        //this.getContentPane().add(mainContentBackground);


       

        this.setBounds(300 - (this.width/2), 250, this.width, this.height);
        this.setLayout(null);
        this.setBackground(Color.white);
        this.add(backLabel);
        this.add(usernameLabel);
        this.add(usernameInput);
        this.add(passwordLabel);
        this.add(passwoField);
        this.add(loginButton);
       

        
    
        
        
        this.setLayout(null);
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

       String username = usernameInput.getText();
       String passw = passwoField.getText();

       

      
    
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
      
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
       
        
    }


}
