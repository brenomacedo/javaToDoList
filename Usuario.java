public class Usuario {
    private int id;
    private String nome;
    private String senha;
    private String nome_usuario;
    private int tarefas_concluidas;
    private int total_tarefas;
    private int ultimo_indice_ocupado;
    Tarefa tarefas[] = new Tarefa[20];

    Usuario(int id_usuario){
        // Setar id_usuario, nome e senha
        // while{
        //   String tarefa = ler linha;
        //   String descricao = ler linha;
        //   String prioridade = ler linha;
        //   String conclusao = ler  linha;
        //   String hora = ler linha;
        //   String data = ler linha;
        //   tarefas[i].setNome(tarefa);
        // }
    }

    Usuario(){
        for (int i = 0; i < 20; i++){
        tarefas[i] = null;
        }
    }

    public void adicionarTarefa(Tarefa tarefa){
        for (int i = 0; i < 20; i++){
        if (tarefas[i] == null){
            tarefas[i] = tarefa;
        }
        }
    }
}
