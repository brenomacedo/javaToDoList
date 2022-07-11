package logica.MenuPrincipal.Observers;

import logica.MenuPrincipal.Models.ModelMenuPrincipal;
import views.Menu;
import views.Task;

/**
 * Observador da função de adicionar tarefa
 * @author Tiago Brandão e Renan Xerez
 */
public class ObservadorAdicionarTarefa {
    ModelMenuPrincipal model;

    public void setModel (ModelMenuPrincipal model) {
        this.model = model;
    }

    public void update () {
        int num_tarefas = model.getTarefas().length();
        Menu menu = this.model.getMenu();
        menu.listaDeTarefas.add(new Task(num_tarefas-1,"Nova Tarefa", "0", false, menu));
        if (num_tarefas == 15){
            // Exibe mensagem de "n° máximo de tarefas alcançado"
            (this.model.getMenu()).botaoAdicionar.setEnabled(false);
        }
        else
            (this.model.getMenu()).botaoAdicionar.setEnabled(true);
            
        (this.model.getMenu()).setVisible(true);
    }
}