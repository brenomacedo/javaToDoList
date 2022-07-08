package logica.TelaConfigurações.Observers;

import javax.swing.JOptionPane;

public class ObserverApagarRegistro extends Observer {
  public void update(){
    JOptionPane.showMessageDialog(null, "Conta apagada com sucesso!", "Conta apagada", JOptionPane.INFORMATION_MESSAGE);
  }
}
