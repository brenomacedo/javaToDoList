package views;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import org.json.JSONObject;

import logica.MenuPrincipal.Models.ModelMenuPrincipal;
import utils.Theme;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.Iterator;
import logica.MenuPrincipal.Controllers.ControllerMenuPrincipal;

public class Menu extends JFrame implements ActionListener {
  
  ModelMenuPrincipal model;
  JPanel listaDeTarefas;
  JButton botaoConfig;
  JButton botaoAdicionar;
  ControllerMenuPrincipal controllerMenuPrincipal;

  public Menu (ModelMenuPrincipal model) {

    this.model = model;
    this.controllerMenuPrincipal = new ControllerMenuPrincipal(model.getUsuario());
    // configurações da tela
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    this.setSize(600, 920); 
    this.setResizable(false);
    this.setTitle("To Do List");

    this.getContentPane().setBackground(Theme.bgColor);

    // titulo
    JLabel titulo = new JLabel();
    titulo.setText("To Do List");

    titulo.setVerticalAlignment(JLabel.CENTER);
    titulo.setHorizontalAlignment(JLabel.CENTER);
    titulo.setBorder(new EmptyBorder(20, 60, 20, 0));
    titulo.setFont(new Font("Monospaced", Font.BOLD, 36));
    titulo.setForeground(Color.WHITE);

    JPanel tituloContainer = new JPanel();
    tituloContainer.setLayout(new BorderLayout());

    // icone do botao de configurações
    ImageIcon iconeConfiguracoes = new ImageIcon("images/config.png");
    Image imageIconeConfiguracoes = iconeConfiguracoes.getImage();
    Image novoIconeConfiguracoes = imageIconeConfiguracoes.getScaledInstance(30, 30,  java.awt.Image.SCALE_SMOOTH);
    iconeConfiguracoes = new ImageIcon(novoIconeConfiguracoes);

    // remover borda do botao de configuração
    Border emptyBorder = BorderFactory.createEmptyBorder();

    // botao de configurações
    botaoConfig = new JButton();
    botaoConfig.setPreferredSize(new Dimension(60, 76));
    botaoConfig.setIcon(iconeConfiguracoes);
    botaoConfig.setFocusable(false);
    botaoConfig.setBorder(emptyBorder);
    botaoConfig.setBackground(Theme.bgColor);
    botaoConfig.addActionListener(this);
    
    tituloContainer.add(titulo, BorderLayout.CENTER);
    tituloContainer.setBackground(Theme.bgColor);
    tituloContainer.add(botaoConfig, BorderLayout.EAST);


    // botoes de controle
    JPanel campoBotoes = new JPanel();
    campoBotoes.setBackground(Theme.bgColor);
    campoBotoes.setBorder(new EmptyBorder(16, 16, 16, 16));

    GridLayout campoBotoesLayout = new GridLayout(1, 3);
    campoBotoesLayout.setHgap(16);

    campoBotoes.setLayout(campoBotoesLayout);
    campoBotoes.setPreferredSize(new Dimension(600, 80));

    // icones dos botoes
    ImageIcon iconeAdicionar = new ImageIcon("images/add.png");
    Image imageIconeAdicionar = iconeAdicionar.getImage();
    Image novoIconeAdicionar = imageIconeAdicionar.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
    iconeAdicionar = new ImageIcon(novoIconeAdicionar);

    ImageIcon iconeRemoverConcluidas = new ImageIcon("images/trash.png");
    Image imageIconeRemoverConcluidas = iconeRemoverConcluidas.getImage();
    Image novoIconeRemoverConcluidas = imageIconeRemoverConcluidas.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
    iconeRemoverConcluidas = new ImageIcon(novoIconeRemoverConcluidas);

    ImageIcon iconeRemoverTudo = new ImageIcon("images/delete.png");
    Image imageIconeRemoverTudo = iconeRemoverTudo.getImage();
    Image novoIconeRemoverTudo = imageIconeRemoverTudo.getScaledInstance(20, 20,  java.awt.Image.SCALE_SMOOTH);
    iconeRemoverTudo = new ImageIcon(novoIconeRemoverTudo);
    // =================

    botaoAdicionar = new JButton("Adicionar");
    JButton botaoLimparConcluidas = new JButton("Limpar Conc.");
    JButton botaoLimparTudo = new JButton("Limpar tudo");

    Font fonteBotao = new Font("Monospaced", Font.BOLD, 14);
    botaoAdicionar.setFont(fonteBotao);
    botaoAdicionar.setForeground(Color.BLACK);
    botaoAdicionar.setBackground(Color.WHITE);
    botaoAdicionar.setFocusable(false);
    botaoAdicionar.setIcon(iconeAdicionar);
    botaoAdicionar.setIconTextGap(10);
    botaoAdicionar.addActionListener(this);

    botaoLimparConcluidas.setFont(fonteBotao);
    botaoLimparConcluidas.setForeground(Color.BLACK);
    botaoLimparConcluidas.setBackground(Color.WHITE);
    botaoLimparConcluidas.setFocusable(false);
    botaoLimparConcluidas.setIcon(iconeRemoverConcluidas);
    botaoLimparConcluidas.setIconTextGap(10);

    botaoLimparTudo.setFont(fonteBotao);
    botaoLimparTudo.setForeground(Color.BLACK);
    botaoLimparTudo.setBackground(Color.WHITE);
    botaoLimparTudo.setFocusable(false);
    botaoLimparTudo.setIcon(iconeRemoverTudo);
    botaoLimparTudo.setIconTextGap(10);

    campoBotoes.add(botaoAdicionar);
    campoBotoes.add(botaoLimparConcluidas);
    campoBotoes.add(botaoLimparTudo);

    listaDeTarefas = new JPanel();
    listaDeTarefas.setBackground(Theme.bgColor);
    listaDeTarefas.setLayout(new GridLayout(15, 1));

    this.carregarTarefas();

    this.add(listaDeTarefas, BorderLayout.CENTER);
    this.add(tituloContainer, BorderLayout.NORTH);
    this.add(campoBotoes, BorderLayout.SOUTH);
    this.setVisible(true);
  }

  public void carregarTarefas () {
    Iterator<Object> tarefas = this.model.getTarefas().iterator();

    JSONObject tarefa;
    int index = 0;
    while (tarefas.hasNext()) {
      tarefa = (JSONObject) tarefas.next();

      String titulo = (String) tarefa.get("titulo");
      int prioridade = (int) tarefa.get("prioridade");
      boolean conclusao = ((String) tarefa.get("conclusao")).equals("concluido");

      listaDeTarefas.add(
        new Task(index, titulo, prioridade, conclusao)
      );
      
      index++;
    }
  }

  public void adicionarTarefa () {
    int index = this.controllerMenuPrincipal.addTarefa();
    this.listaDeTarefas.add(
      new Task(index ,"Nova Tarefa", 0, false)
    );

    if (model.getTarefas().length() == 15) {
      botaoAdicionar.setEnabled(false);
    } else {
      botaoAdicionar.setEnabled(true);
    }

    this.setVisible(true);
  }

  public void recarregarTarefas () {
    
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.botaoConfig) {
      this.botaoConfig.removeActionListener(this);
      new Sett_frame(this, this.botaoConfig, model);
    }

    if (e.getSource() == this.botaoAdicionar) {
      this.adicionarTarefa();
    }
  }
}
