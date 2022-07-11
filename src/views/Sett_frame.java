package views;
import javax.swing.*;

import logica.MenuPrincipal.Models.ModelMenuPrincipal;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;

/**
 * Frame que envolve os componentes de icone do usuario e de edição de suas informações
 * @author Rafael Facundo
 */
public class Sett_frame extends JFrame {

    public ActionListener menuFrame;
    JButton botaoConfig;
    ModelMenuPrincipal model;

    int width = 600;
    int height = 920;

    public User_image_Panel user_image;
    public Change_info_Panel change_panel;


    
    public Sett_frame (ActionListener menuFrame, JButton botaoConfig, ModelMenuPrincipal model) {
        this.menuFrame = menuFrame;
        this.botaoConfig = botaoConfig;
        this.model = model;
        this.change_panel = new Change_info_Panel(model, this);
        this.user_image = new User_image_Panel(model.getNome());

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                botaoConfig.addActionListener(menuFrame);
            }
        });

        this.setSize(this.width, this.height);
        this.getContentPane().add(user_image);
        this.getContentPane().add(change_panel);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

    }


    
}
