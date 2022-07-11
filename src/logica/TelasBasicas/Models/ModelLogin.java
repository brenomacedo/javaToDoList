package logica.TelasBasicas.Models;

import javax.swing.JFrame;

/**
 * Model do login
 * @author Tiago Brandão e Gustavo Wendell
 */
public class ModelLogin extends ModelTelasIniciais{

  public JFrame telaLogin;

  public ModelLogin(JFrame telaLogin){
    super();
    this.telaLogin = telaLogin;
  }
}