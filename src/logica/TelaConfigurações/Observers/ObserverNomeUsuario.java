package logica.TelaConfigurações.Observers;

/**
 * Observador do username do usuario
 * @author Tiago Brandão e Gustavo Wendell
 */
public class ObserverNomeUsuario extends Observer {
  public void update(){
    System.out.println((this.model).getMensagem());
  }
}
