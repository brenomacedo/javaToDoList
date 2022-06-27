public class Verificadora{
  // Essa classe serve para realizar verificações simples, mas que realizamos muitas vezes
  // ao longo da execução
  
  static int verifica_senha_nomeUsuario (String nome_usuario, String senha){
    if (nome_usuario == "" && senha == "")
      return -1;

    if (senha == "")
      return -2;

    if (nome_usuario == "")
      return -3;

    return 0;
  }

  static int verifica_senha_nomeUsuario_senhaNova(String nome_usuario, String senha, String senha_nova){
    if (nome_usuario == "" && senha == "" && senha_nova == "")
      return -1;

    if (nome_usuario == "" && senha == "")
      return -2;

    if (nome_usuario == "" && senha_nova == "")
      return -3;

    if (senha == "" && senha_nova == "")
      return -4;

    if (senha == "")
      return -5;

    if (senha_nova == "")
      return -6;

    if (nome_usuario == "")
      return -7;

    return 0;
  }
}