package logica.TelaConfigurações.Observers;

import logica.TelaConfigurações.Models.ModelConfiguracoes;

/**
 * Superclasse de observador
 * @author Tiago Brandão e Gustavo Wendell
 */
public class Observer{
  ModelConfiguracoes model;

  /**
   * 
   * @param model
   */
  public void setModel(ModelConfiguracoes model) {
    this.model = model;
  }

  public ModelConfiguracoes getModel() {
    return this.model;
  }
}
