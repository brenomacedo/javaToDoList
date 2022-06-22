public class MenuLogin{
  // "registros_de_todos_os_usuarios_do_TODO_LIST.txt":
  // n° da última id registrada
  // nome1
  // senha1
  // id1
  // nome2
  // senha2
  // id2
  // ...

  // string_nova = "nome3" + '\n' + "senha3" + '\n' + "id_3"
  // string_velha = read(registro.txt)
  // save(registro.txt, string_velha + string_nova)
  
  // OBS 1: "username" serão gravados em maiúsculo, e o usuário pode digitar da forma que ele quiser 
  // (não é Keysensitive). Já as senhas serão gravadas da mesma maneira que foram digitadas.

  // OBS 2: Cada "id" será única


  // "id_usuario.txt":
  // tarefa_1
  // descricao_tarefa_1
  // prioridade_tarefa_1
  // estado_tarefa_1
  // hora_1
  // data_1
  // tarefa_2
  // descricao_tarefa_2
  // prioridade_tarefa_2
  // estado_tarefa_2
  // hora_2
  // data_2
  // ...


  // 1) Função verificar_login
  // Recebemos "username" e "senha" do "submit" da tela de login
  // Casos possíveis:
  // 1.1) "username" e "senha" contêm alguma coisa
  // 1.1.1) Se login correto -> retorno id_usuario
  // 1.1.2) Se login errado -> retorno -4
  // 1.2) "username" ou "senha" não contêm alguma coisa
  // 1.2.1) "senha" vazio -> retorno -1
  // 1.2.2) "username" vazio -> retorno -2
  // 1.2.3) "username" e "senha" vazios -> retorno -3
  int verificar_login(String username, String senha){
    username = toUpperCase(username);

    if (username == "" && senha == "")
      return -3;

    elif (username == "")
      return -2;

    elif (senha == "")
      return -1;

    else{
      // Abrimos o file "registros.txt"
      // n° da última id registrada
      // nome1
      // senha1
      // id1
      // nome2
      // senha2
      // id2
      // ...

      // Pulamos a primeira linha (a linha do id)
      // while tiver_linha{
      //  usuario_verificacao = nome_i
      //  senha_veririficao = senha_i
      //  if (usuario_verificao == username && senha_verificao == senha)
      //    id_usuario = id_i
      //    return id_usuario
      // }
      // return -4
    }
  }

  // 2) Função mudar_senha
  // Recebemos "username", "senha_atual" e "nova_senha" do "submit" da tela de login
  // Casos possíveis:
  // 2.1) "username", "senha_atual" e "nova senha" contêm alguma coisa
  int mudar_senha (String username, String senha_atual, String nova_senha){

  }

  // 3) Função criar_registro


  // 4) Função apagar_registro
}