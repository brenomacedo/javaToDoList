package logica.Auxiliar;

public class Mensagens{
  public static String nome = "nome";
  public static String nome_usuario = "nome_usuario";
  public static String senha = "senha";
  public static String gera_mensagem_login(int i, int valor_retorno){
    String mensagem = "";
    if (i == 0){
      if (valor_retorno == -1)
        mensagem = "Nome de usuário não existe!";
      else if (valor_retorno == 0)
        mensagem = "Login realizado com sucesso!";
      else if (valor_retorno == 1)
        mensagem = "Senha errada!";
    }

    else{
      if (i == -1)
        mensagem = "Por favor, digite nome de usuário e senha!";
      else if (i == -2)
        mensagem = "Por favor, digite a senha!";
      else if (i == -3)
        mensagem = "Por favor, digite o nome de usuário!";
    }

    return mensagem;
  }

  public static String gera_mensagem_cadastro(int i, int valor_retorno){
    String mensagem = "";
    if (i == 0){
      if (valor_retorno == 0)
        mensagem = "Cadastro realizado com sucesso!";
      else if (valor_retorno == 1)
        mensagem = "Já existe um registro com esse nome de usuário!";
    }

    else{
      if (i == -1)
        mensagem = "Por favor, digite nome, nome de usuário e senha!";
      else if (i == -2)
        mensagem = "Por favor, digite nome de usuário e senha!";
      else if (i == -3)
        mensagem = "Por favor, digite nome e nome de usuário!";
      else if (i == -4)
        mensagem = "Por favor, digite nome e senha!";
      else if (i == -5)
        mensagem = "Por favor, digite a senha!";
      else if (i == -6)
        mensagem = "Por favor, digite o nome!";
      else if (i == -7)
        mensagem = "Por favor, digite o nome de usuário!";
    }

    return mensagem;
  }

  public static String gera_mensagem_EditarPerfil(String senha_atual, String senha_ent, String tipo_mudanca){
    String mensagem = "";
    if (senha_ent.equals(mensagem))
      mensagem = "Por favor, digite a senha!"; 
    else if (senha_ent.equals(senha_atual)){
      if (tipo_mudanca.equals(nome))
        mensagem = "Nome modificado com sucesso!";
      else if (tipo_mudanca.equals(nome_usuario))
        mensagem = "Nome de usuário modificado com sucesso!";
      else
        mensagem = "Senha modificada com sucesso!";
    }
    else
      mensagem = "Senha errada!";

    return mensagem;
  }

  public static String gera_mensagem_ApagarRegistro(String senha_atual, String senha_ent){
    String mensagem = "";
    if (senha_ent.equals(mensagem))
      mensagem = "Por favor, digite a senha!"; 
    else if (senha_ent.equals(senha_atual))
      mensagem = "Registro apagado com sucesso!";
    else
      mensagem = "Senha errada!";

    return mensagem;
  }
}