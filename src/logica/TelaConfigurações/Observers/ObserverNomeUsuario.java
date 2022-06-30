package logica.TelaConfigurações.Observers;

public class ObserverNomeUsuario extends Observer {
  public void update(){
    System.out.println((this.model).getMensagem());
  }
}
