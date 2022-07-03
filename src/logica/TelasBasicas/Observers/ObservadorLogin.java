package logica.TelasBasicas.Observers;

import org.json.JSONObject;

import logica.MenuPrincipal.Models.ModelMenuPrincipal;
import logica.TelasBasicas.Models.ModelLogin;
import logica.TelasBasicas.Models.ModelTelasIniciais;
import views.Menu;

import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class ObservadorLogin{
  JSONObject usuario;
  ModelTelasIniciais model;

  public void setModel(ModelTelasIniciais model){
    this.model = model;
  }

  public void update(){
    this.usuario = (this.model).getUsuario();
    JFrame telaLogin = ((ModelLogin) this.model).telaLogin;
    telaLogin.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    telaLogin.dispatchEvent(new WindowEvent(telaLogin, WindowEvent.WINDOW_CLOSING));
    new Menu(new ModelMenuPrincipal(this.usuario, null));
  }
}