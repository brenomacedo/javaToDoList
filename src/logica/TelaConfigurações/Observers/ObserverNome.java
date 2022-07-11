package logica.TelaConfigurações.Observers;

/**
 * Observador do nome do usuario
 * @author Tiago Brandão e Gustavo Wendell
 */
public class ObserverNome extends Observer{
  public void update(){
    System.out.println((this.model).getMensagem());
  }
}
