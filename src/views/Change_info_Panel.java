package views;
import javax.swing.*;

import logica.MenuPrincipal.Models.ModelMenuPrincipal;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Change_info_Panel extends JPanel  implements MouseListener {

    JPasswordField change_passw_input = new JPasswordField(60);
    JPasswordField confirm_passw_input = new JPasswordField(60);
    ModelMenuPrincipal model;

    Change_info_Panel (ModelMenuPrincipal model) {
        this.model = model;
        //Label com o texto "informações do usuário"
        JLabel basic_inform_text = new JLabel("Informações do usuário");
        basic_inform_text.setFont(new Font("Verdana", Font.PLAIN, 18));
        basic_inform_text.setForeground(new Color(144, 202, 249));
        basic_inform_text.setBounds(10, 10, 280, 25);

        //imagem do icone de usuario nas configurações
        ImageIcon userIconSetting = new ImageIcon("images/user_icon_settings.png");
        Image imageUserIconSetting = userIconSetting.getImage();
        Image novaImageUserIconSetting = imageUserIconSetting.getScaledInstance(30, 30, java.awt.Image.SCALE_SMOOTH);
        userIconSetting = new ImageIcon(novaImageUserIconSetting);

        //Label do nome de usuário 
        JLabel nome_usuario = new JLabel(model.getNomeUsuario());
        nome_usuario.setFont(new Font("Verdana", Font.PLAIN, 16));
        nome_usuario.setForeground(new Color(144, 202, 249));
        nome_usuario.setBounds(10, 50 , 300, 25);
        nome_usuario.setIcon(userIconSetting);

        //imagem do icone de senha nas configurações
        ImageIcon passwIconSetting = new ImageIcon("images/password_icon.png");
        Image imagePasswIconSetting = passwIconSetting.getImage();
        Image novaImagePasswIconSetting = imagePasswIconSetting.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        passwIconSetting = new ImageIcon(novaImagePasswIconSetting);

        //Label com senha 
        JLabel senha_usuario = new JLabel(model.getSenha());
        senha_usuario.setSize(400, 20);        
        senha_usuario.setFont(new Font("Verdana", Font.PLAIN, 16));
        senha_usuario.setBounds(10, 90, 300, 25);
        senha_usuario.setForeground(new Color(144, 202, 249));
        senha_usuario.setIcon(passwIconSetting);

        //Label com o titulo de alterar informações 
        JLabel change_inform = new JLabel("alterar Informações do usuário");
        change_inform.setFont(new Font("Verdana", Font.PLAIN, 18));
        change_inform.setForeground(new Color(144, 202, 249));
        change_inform.setBounds(10, 140, 350, 25);

        //Label com o texto de alterar senha
        JLabel change_passw = new JLabel("alterar senha: ");
        change_passw.setFont(new Font("Verdana", Font.PLAIN, 16));
        change_passw.setForeground(new Color(144, 202, 249));
        change_passw.setBounds(10, 180, 300, 25);

        //textinput para alterar a senha 
       
        change_passw_input.setBounds(10, 210, 300, 25);


        //Label com o texto de confirmar senha 
        JLabel confirm_passw = new JLabel("Por favor, confirme sua senha: ");
        confirm_passw.setFont(new Font("Verdana", Font.PLAIN, 16));
        confirm_passw.setForeground(new Color(144, 202, 249));
        confirm_passw.setBounds(10, 240, 300, 25);

        //textinput para confirmar a senha 
        
        confirm_passw_input.setBounds(10, 270, 300, 25);

        //butão alterar senha 
        JButton save_new_passw = new JButton("Salvar");
        save_new_passw.setBounds(315, 270, 80, 25);
        save_new_passw.setBackground(Color.cyan);
        save_new_passw.addMouseListener(this);

        //botão de fazer logout
        JLabel logout_button = new JLabel("Fazer logout");
        logout_button.setFont(new Font("Verdana", Font.PLAIN, 16));
        logout_button.setForeground(Color.red);        
        logout_button.setBounds(240,340, 300, 25);

        //botão de deletar conta
        JLabel delete_account = new JLabel("Deletar conta");
        delete_account.setFont(new Font("Verdana", Font.PLAIN, 16));
        delete_account.setForeground(Color.red);        
        delete_account.setBounds(236,370, 300, 25);


        this.add(basic_inform_text);
        this.add(nome_usuario);
        this.add(senha_usuario);
        this.add(change_inform);
        this.add(change_passw);
        this.add(change_passw_input);
        this.add(confirm_passw);
        this.add(confirm_passw_input);
        this.add(save_new_passw);
        this.add(logout_button);
        this.add(delete_account);

        this.setBounds(0,270,600, 650);
        this.setBackground(Color.white);
        this.setLayout(null);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

        String passw_confirm = confirm_passw_input.getText();
        String new_passw = change_passw_input.getText();

       
        System.out.println("sneha: " + passw_confirm);
        System.out.println("new pass: " + new_passw);
       

      
    
        
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
