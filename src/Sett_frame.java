import java.awt.Color;
import javax.swing.*;

public class Sett_frame extends JFrame {
    int width = 600;
    int height = 920;

    User_image_Panel user_image = new User_image_Panel();
    Change_info_Panel change_panel = new Change_info_Panel();


    
    Sett_frame () {


        this.setSize(this.width, this.height);
        this.getContentPane().add(user_image);
        this.getContentPane().add(change_panel);
        this.getContentPane().setBackground(Color.pink);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


    
}
