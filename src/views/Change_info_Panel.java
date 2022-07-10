package views;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import logica.MenuPrincipal.Models.ModelMenuPrincipal;
import logica.TelaConfigurações.Controller.ControllerConfiguracoes;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

public class Change_info_Panel extends JPanel implements ActionListener {

    JPasswordField change_passw_input = new JPasswordField(60);
    JPasswordField confirm_passw_input = new JPasswordField(60);
    JTextField change_userName_input = new JTextField(60);
    JTextField change_name_input = new JTextField(60);
    ModelMenuPrincipal model;
    ControllerConfiguracoes controllerConfiguracoes;
    JButton save_new_userName;
    JButton save_new_name;
    JButton save_new_passw;
    JButton logout_button;
    JButton delete_account;
    Sett_frame sett_frame;

    Change_info_Panel (ModelMenuPrincipal model, Sett_frame frame) {
        this.model = model;
        this.controllerConfiguracoes = new ControllerConfiguracoes(this.model.getUsuario());
        this.sett_frame = frame;
        //Label com o texto "informações do usuário"
        JLabel basic_inform_text = new JLabel("INFORMAÇÕES DO USUÁRIO");
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

        String senhaEscondida = "";

        for (int i = 0; i < model.getSenha().length(); i++) {
            senhaEscondida = senhaEscondida + "*";
        }

        JLabel senha_usuario = new JLabel(senhaEscondida);
        senha_usuario.setSize(400, 20);        
        senha_usuario.setFont(new Font("Verdana", Font.PLAIN, 16));
        senha_usuario.setBounds(10, 90, 300, 25);
        senha_usuario.setForeground(new Color(144, 202, 249));
        senha_usuario.setIcon(passwIconSetting);

        //Label com o titulo de alterar informações 
        JLabel change_inform = new JLabel("ALTERAR INFORMAÇÕES DO USUÁRIO");
        change_inform.setFont(new Font("Verdana", Font.PLAIN, 18));
        change_inform.setForeground(new Color(144, 202, 249));
        change_inform.setBounds(10, 140, 350, 25);

        //Label com o texto de alterar nome de usuário
        JLabel change_userName = new JLabel("Alterar nome de usuário: ");
        change_userName.setFont(new Font("Verdana", Font.PLAIN, 16));
        change_userName.setForeground(new Color(144, 202, 249));
        change_userName.setBounds(10, 170, 300, 25);

        //textinput para alterar nome de usuário
        change_userName_input.setBounds(10, 200, 300, 25);

        //botão para salvar novo nome de usuário
        save_new_userName = new JButton("Salvar");
        save_new_userName.setBounds(315, 200, 80, 25);
        save_new_userName.setBackground(Color.cyan);
        save_new_userName.addActionListener(this);

        //Label com o texto de alterar nome
        JLabel change_name = new JLabel("Alterar nome: ");
        change_name.setFont(new Font("Verdana", Font.PLAIN, 16));
        change_name.setForeground(new Color(144, 202, 249));
        change_name.setBounds(10, 226, 300, 25);

        //textinput para alterar nome
        change_name_input.setBounds(10, 248, 300, 25);

        //botão para salvar novo nome
        save_new_name = new JButton("Salvar");
        save_new_name.setBounds(315, 248, 80, 25);
        save_new_name.setBackground(Color.cyan);
        save_new_name.addActionListener(this);

        //Label com o texto de alterar senha
        JLabel change_passw = new JLabel("Alterar senha: ");
        change_passw.setFont(new Font("Verdana", Font.PLAIN, 16));
        change_passw.setForeground(new Color(144, 202, 249));
        change_passw.setBounds(10, 280, 300, 25);

        //textinput para alterar a senha 
       
        change_passw_input.setBounds(10, 310, 300, 25);


        //Label com o texto de confirmar senha 
        JLabel confirm_passw = new JLabel("Por favor, confirme sua senha: ");
        confirm_passw.setFont(new Font("Verdana", Font.PLAIN, 16));
        confirm_passw.setForeground(new Color(144, 202, 249));
        confirm_passw.setBounds(10, 340, 370, 25);

        //textinput para confirmar a senha 
        
        confirm_passw_input.setBounds(10, 370, 300, 25);

        //butão alterar senha 
        save_new_passw = new JButton("Salvar");
        save_new_passw.setBounds(315, 370, 80, 25);
        save_new_passw.setBackground(Color.cyan);
        save_new_passw.addActionListener(this);

        //botão de fazer logout
        logout_button = new JButton("Fazer logout");
        logout_button.addActionListener(this);
        logout_button.setFont(new Font("Verdana", Font.PLAIN, 16));
        logout_button.setForeground(Color.red);        
        logout_button.setBounds(240,400, 120, 55);
        logout_button.setBorder(new EmptyBorder(0, 0, 0, 0));
        logout_button.setBackground(Color.white);

        //botão de deletar conta
        delete_account = new JButton("Deletar conta");
        delete_account.addActionListener(this);
        delete_account.setFont(new Font("Verdana", Font.PLAIN, 16));
        delete_account.setForeground(Color.red);        
        delete_account.setBounds( 240, 470, 120, 55 );
        delete_account.setBorder(new EmptyBorder(0, 0, 0, 0));
        delete_account.setBackground(Color.white);


        this.add(basic_inform_text);
        this.add(nome_usuario);
        this.add(senha_usuario);
        this.add(change_inform);
        this.add(change_userName);
        this.add(change_userName_input);
        this.add(save_new_userName);
        this.add(change_name);
        this.add(change_name_input);
        this.add(save_new_name);
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
    public void actionPerformed(ActionEvent e) {

        String confirmarSenha = new String(confirm_passw_input.getPassword());

        if (e.getSource() == this.save_new_userName) {
            String username = change_userName_input.getText();
            this.controllerConfiguracoes.editarPerfil(username, confirmarSenha, "nome_usuario");
        }

        if (e.getSource() == this.save_new_name) {
            String name = change_name_input.getText();
            this.controllerConfiguracoes.editarPerfil(name, confirmarSenha, "nome");   
        }

        if (e.getSource() == this.save_new_passw) {
            String newPassword = new String(change_passw_input.getPassword());
            this.controllerConfiguracoes.editarPerfil(newPassword, confirmarSenha, "senha");
        }

        if (e.getSource() == this.logout_button) {
            this.controllerConfiguracoes.logout(this.sett_frame);
        }

        if (e.getSource() == this.delete_account) {
            this.controllerConfiguracoes.ApagarRegistro(this.sett_frame);
        }

        sett_frame.dispatchEvent(new WindowEvent(sett_frame, WindowEvent.WINDOW_CLOSING));
    }

}
