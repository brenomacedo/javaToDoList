package views;
import javax.swing.*;
import java.awt.*;

public class User_image_Panel extends JPanel {
    
    User_image_Panel (String nome) {

        //imagem seta voltando
        ImageIcon arrowIcon = new ImageIcon("images/back_arrow.png");
        Image imageArrowIcon = arrowIcon.getImage();
        Image novaimageIcon = imageArrowIcon.getScaledInstance(25, 25, java.awt.Image.SCALE_SMOOTH);
        arrowIcon = new ImageIcon(novaimageIcon);
 
        //botão de voltar
        JLabel back_to_main = new JLabel("Voltar");
        back_to_main.setForeground(Color.white);
        back_to_main.setBounds(10,10,90,40);
        back_to_main.setIcon(arrowIcon);
 
        //imagem de usuário
        ImageIcon userIcon = new ImageIcon("images/user_icon.png");
        Image imageUserIcon = userIcon.getImage();
        Image novaImageUserIcon = imageUserIcon.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        userIcon = new ImageIcon(novaImageUserIcon);
 
        //Label com o icone de usuário e o nome 
        JLabel user_Icon = new JLabel(nome, JLabel.CENTER);
        user_Icon.setIcon(userIcon);
        user_Icon.setFont(new Font("Verdana", Font.PLAIN, 16));
        user_Icon.setHorizontalTextPosition(JLabel.CENTER);
        user_Icon.setVerticalTextPosition(JLabel.BOTTOM);
        user_Icon.setBounds(0, 0, 600, 270 );

        this.add(user_Icon);
        this.add(back_to_main);


        this.setBounds(0,0,600,270);
        this.setBackground(new Color(144, 202, 249));
        this.setLayout(null);
    }


}
