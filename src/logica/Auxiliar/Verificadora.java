package logica.Auxiliar;

public class Verificadora{
  public static String vazio = "";
  // Essa classe serve para realizar verificações simples, mas que realizamos muitas vezes
  // ao longo da execução
  
  public static int verifica_senha_nomeUsuario (String nome_usuario, String senha){
    if (nome_usuario.equals(vazio) && senha.equals(vazio))
      return -1;

    if (senha.equals(vazio))
      return -2;

    if (nome_usuario.equals(vazio))
      return -3;

    return 0;
  }

  public static int verifica_senha_nomeUsuario_senhaNova(String nome_usuario, String senha, String senha_nova){
    if (nome_usuario.equals(vazio) && senha.equals(vazio) && senha_nova.equals(vazio))
      return -1;

    if (nome_usuario.equals(vazio) && senha.equals(vazio))
      return -2;

    if (nome_usuario.equals(vazio) && senha_nova.equals(vazio))
      return -3;

    if (senha.equals(vazio) && senha_nova.equals(vazio))
      return -4;

    if (senha.equals(vazio))
      return -5;

    if (senha_nova.equals(vazio))
      return -6;

    if (nome_usuario.equals(vazio))
      return -7;

    return 0;
  }

  public static int verifica_nome_nomeUsuario_senha(String nome, String nome_usuario, String senha){
    if (nome_usuario.equals(vazio) && senha.equals(vazio) && nome.equals(vazio))
      return -1;

    if (nome_usuario.equals(vazio) && senha.equals(vazio))
      return -2;

    if (nome_usuario.equals(vazio) && nome.equals(vazio))
      return -3;

    if (senha.equals(vazio) && nome.equals(vazio))
      return -4;

    if (senha.equals(vazio))
      return -5;

    if (nome.equals(vazio))
      return -6;

    if (nome_usuario.equals(vazio))
      return -7;

    return 0;
  }
}