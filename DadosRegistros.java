public class DadosRegistros{
  // 1) verificarLogin
  // Verifica se determinado login existe no banco de dados
  // Se existir -> retorna id_usuario
  // Caso contrário -> retorna -4
  static int verificarLogin(ModelLogin model){
    return -4;
  }

  // 2) apagar
  // Recebe a id_usuario e apaga o registro desse usuário do banco de dados
  static void apagar(int id_usuario){
  }

  // 3) cadastrar
  // Adiciona um novo cadastro ao banco de dados
  static void cadastrar(ModelCadastrar model){ 
  }


  // 4) atualizar
  // Atualiza a senha de um usuário no banco de dados
  static void atualizar(int id_usuario, ModelMudarSenha model){
  }

  // 5) verificarNomeUsuario
  // Verifica se o nome_usuario é válido, isto é, se não há nenhum usuário cadastrado com esse nome_usuário
  // Se for válido -> retorna true
  // Caso contrário -> retorna false
  static boolean verificarNomeUsuario(ModelCadastrar model){
    return true;
  }

  // 6) salvar
  void salvar(){
  }


  // 7) carregar
  void carregar(){
  }

}