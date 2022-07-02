package views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Login_Register_Frame extends JFrame implements MouseListener {
    int width = 600;
    int height = 920;
    LoginPanel login = new LoginPanel();
    RegisterPanel register = new RegisterPanel();
    JLabel voltar_ao_login = new JLabel("Fazer login", JLabel.CENTER);
    JLabel register_button = new JLabel("Criar uma conta",  JLabel.CENTER);

    public Login_Register_Frame () {
        

        this.setResizable(false);

        //imagem que está no titulo 
        ImageIcon icon = new ImageIcon("images/to_do.png");
        Image imageIcon = icon.getImage();
        Image novaimageIcon = imageIcon.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        icon = new ImageIcon(novaimageIcon);
        
        //label que contém a imagem 
        JLabel titleLabel = new JLabel();
        titleLabel.setIcon(icon);
        titleLabel.setBounds(400, 10, 200, 200);

        //Label com o texto do titulo 
        final JLabel title = new JLabel("TO DO list");
        title.setBounds(this.width/2 - 150,  10, 200, 200);
        title.setFont(new Font("Verdana", Font.PLAIN, 38));
        title.setForeground(Color.white);


        /* //voltar ao login
        voltar_ao_login.setFont(new Font("Verdana", Font.PLAIN, 18));
        voltar_ao_login.setForeground(Color.decode("#2596be"));
        voltar_ao_login.setBackground(Color.white);
        voltar_ao_login.setBounds(this.width/2 - 290/2, 655, 290, 25);
        voltar_ao_login.addMouseListener(this); */

        //fazer conta.
        register_button.setFont(new Font("Verdana", Font.PLAIN, 18));
        register_button.setForeground(Color.decode("#2596be"));
        register_button.setBackground(Color.white);
        register_button.setBounds(this.width/2 - 290/2, 655, 290, 25); 
        register_button.addMouseListener(this);   


        this.setLayout(null);
        this.getContentPane().add(login);
        this.getContentPane().add(register);
        this.getContentPane().add(titleLabel);
        this.getContentPane().add(title);
        this.getContentPane().add(register_button);
        //this.getContentPane().add(voltar_ao_login);
        this.getContentPane().setBackground(new Color(144, 202, 249));

        register.setVisible(false);
       
        this.setSize(this.width, this.height);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    @Override
        public void mouseClicked(MouseEvent e) {
            // TODO Auto-generated method stub

            if ( login.isShowing() ) {
                login.setVisible(false);
                register.setVisible(true);
                register_button.setText("Fazer Login");
            } else {
                login.setVisible(true);
                register.setVisible(false);
                register_button.setText("Criar conta");
            }

            /* register_button.setText("Fazer login");


            System.out.println("Olás"); */
        
            
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
