public class Mensagens{
  static String gera_mensagem_login(int i, int valor_retorno){
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

  static String gera_mensagem_cadastro(int i, int valor_retorno){
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

  static String gera_mensagem_mudarsenha(int i, int valor_retorno){
    String mensagem = "";
    if (i == 0){
      if (valor_retorno == -1)
        mensagem = "Nome de usuário não existe!";
      else if (valor_retorno == 0)
        mensagem = "Senha modificada com sucesso!";
      else if (valor_retorno == 1)
        mensagem = "Senha errada!";
    }

    else{
      if (i == -1)
        mensagem = "Por favor, digite nome de usuário, senha atual e senha nova!";
      else if (i == -2)
        mensagem = "Por favor, digite nome de usuário e senha atual!";
      else if (i == -3)
        mensagem = "Por favor, digite nome de usuário e senha nova!";
      else if (i == -4)
        mensagem = "Por favor, digite senha atual e senha nova!";
      else if (i == -5)
        mensagem = "Por favor, digite a senha atual!";
      else if (i == -6)
        mensagem = "Por favor, digite a senha nova!";
      else if (i == -7)
        mensagem = "Por favor, digite o nome de usuário!";
    }

    return mensagem;
  }

  static String gera_mensagem_apagarRegistro(int i, int valor_retorno){
    String mensagem = "";
    if (i == 0){
      if (valor_retorno == -1)
        mensagem = "Nome de usuário não existe!";
      else if (valor_retorno == 0)
        mensagem = "Registro excluído com sucesso!";
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
}