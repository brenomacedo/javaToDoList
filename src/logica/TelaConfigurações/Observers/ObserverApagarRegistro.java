package logica.TelaConfigurações.Observers;

import javax.swing.JOptionPane;

/**
 * Observador da função de apagar o registro
 * @author Tiago Brandão e Gustavo Wendell
 */
public class ObserverApagarRegistro extends Observer {
  public void update(){
    JOptionPane.showMessageDialog(null, "Conta apagada com sucesso!", "Conta apagada", JOptionPane.INFORMATION_MESSAGE);
  }
}
