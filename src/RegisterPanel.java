import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class RegisterPanel extends JPanel implements MouseListener {
    int width = 570;
    int height = 400;
    int inputWidth = 280;
    int buttonWidth = inputWidth - 30;
    int panelHeight = 400;
    int panelWidth = this.width - 30;
    int inputPositionInPanel = (this.panelWidth/2 - (this.inputWidth/2)) + 120 ;
    int buttonPositionPanel = this.panelWidth/2 - (this.buttonWidth/2) + 120;

    final JTextField emailInput = new JTextField(60);
    final JTextField emailInputTypeAgain = new JTextField(60);
    final JTextField passwoField = new JTextField(60);
    final JTextField passwoFieldTypeAgain = new JTextField(60);
    
    RegisterPanel () {

        //como fazer imagem
        /* ImageIcon iconeConfiguracoes = new ImageIcon("images/config.png");
        Image imageIconeConfiguracoes = iconeConfiguracoes.getImage();
        Image novoIconeConfiguracoes = imageIconeConfiguracoes.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
        iconeConfiguracoes = new ImageIcon(novoIconeConfigurac oes);*/

        //Label do input que pede o email
        final JLabel emailLabel = new JLabel("Digite seu email: ");
        emailLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        emailLabel.setForeground(Color.decode("#2596be"));
        emailLabel.setBounds(265, 20, 200, 25);

        //input que pede o email 
        
        emailInput.setBounds(this.inputPositionInPanel, 50, this.inputWidth, 25);

        //label do input que pede o email novamente
        final JLabel emailLabelTypeAgain = new JLabel("Repita o email: ");
        emailLabelTypeAgain.setFont(new Font("Verdana", Font.PLAIN, 18));
        emailLabelTypeAgain.setForeground(Color.decode("#2596be"));
        emailLabelTypeAgain.setBounds(265, 80, 200, 25);

        //input que pede o email novamente 
        
        emailInputTypeAgain.setBounds(this.inputPositionInPanel, 110, this.inputWidth, 25);

        //label do input que pede a senha 
        final JLabel passwordLabel = new JLabel("Digite sua senha: ");
        passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        passwordLabel.setForeground(Color.decode("#2596be"));
        passwordLabel.setBounds(265, 140, 200, 25);

        //input que pede a senha 
        
        passwoField.setBounds(this.inputPositionInPanel, 170, this.inputWidth, 25);

        //label do input que pede a senha novamente
        final JLabel passwordLabelTypeAgain = new JLabel("Repita a senha: ");
        passwordLabelTypeAgain.setFont(new Font("Verdana", Font.PLAIN, 18));
        passwordLabelTypeAgain.setForeground(Color.decode("#2596be"));
        passwordLabelTypeAgain.setBounds(265, 200, 200, 25);

        //input que pede a senha novamente
        
        passwoFieldTypeAgain.setBounds(this.inputPositionInPanel, 230, this.inputWidth, 25);

        //botão de criar conta 
        final JButton registerButton = new JButton("Criar conta");
        registerButton.setBounds(this.buttonPositionPanel, 280, this.buttonWidth, 25);
        registerButton.setBackground(Color.CYAN);

        
        
        //imagem que fica no JPanel de registro
        ImageIcon registerIcon = new ImageIcon("images/new_user_icon.png");
        Image imageRegisterIcon = registerIcon.getImage();
        Image newRegisterIcon = imageRegisterIcon.getScaledInstance(240, 400,  java.awt.Image.SCALE_SMOOTH);
        registerIcon = new ImageIcon(newRegisterIcon);

       

        //Colocando a imagem no JPanel
        JLabel imgae_Of_Inputs_panel = new JLabel();
        imgae_Of_Inputs_panel.setIcon(registerIcon);
        imgae_Of_Inputs_panel.setBounds(0, 0, 250, 400);
        

        this.setLayout(null);
        this.setBackground(Color.white);
        this.add(imgae_Of_Inputs_panel);
        this.add(emailLabel);
        this.add(emailInput);
        this.add(emailLabelTypeAgain);
        this.add(emailInputTypeAgain);
        this.add(passwordLabel);
        this.add(passwoField);
        this.add(passwordLabelTypeAgain);
        this.add(passwoFieldTypeAgain);
        this.add(registerButton);


        
       
        this.setLayout(null);
        this.setBounds(13, 250, this.width, this.height);
       
        

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

        String email = emailInput.getText();
        String password = emailInputTypeAgain.getText();
        String email_Confirm = passwoField.getText();
        String passw_confirm = passwoFieldTypeAgain.getText();

       //chamar a lógica do brandão
      
       

      
    
        
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
