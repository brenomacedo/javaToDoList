package views;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import utils.Theme;
import utils.JTextFieldLimit;

public class EditarTask extends JFrame implements ActionListener {

  int index;
  String titulo;
  String descricao;
  String data;
  String hora;
  String prioridade;
  String conclusao;

  JButton botaoSalvar;
  JTextField campoTitulo;
  JTextArea campoDescricao;
  JTextField campoData;
  JTextField campoHora;
  JComboBox<String> campoPrioridade;

  Menu menu;

  public EditarTask(int index, String titulo, String descricao, String data, String hora, String prioridade, String conclusao, Menu menu) {

    this.index = index;
    this.titulo = titulo;
    this.descricao = descricao;
    this.data = data;
    this.hora = hora;
    this.prioridade = prioridade;
    this.conclusao = conclusao;

    this.menu = menu;

    this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    this.getContentPane().setBackground(Theme.bgColor);
    this.setResizable(false);
    this.setSize(400, 570);
    this.setLayout(new BorderLayout());

    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        menu.setEditandoTarefa(false);
      }
    });

    JPanel secaoTitulo = new JPanel();
    secaoTitulo.setBackground(Theme.bgColor);
    secaoTitulo.setPreferredSize(new Dimension(400, 80));
    secaoTitulo.setLayout(new GridLayout(2, 1));
    secaoTitulo.setBorder(new EmptyBorder(8, 8, 16, 8));

    JLabel labelTitulo = new JLabel("Titulo");
    labelTitulo.setFont(new Font(null, Font.BOLD, 18));

    // Receber como parametro a entrada da model (Tiago big brand)
    campoTitulo = new JTextField();
    campoTitulo.setFont(new Font(null, Font.BOLD, 18));
    campoTitulo.setEditable(true);

    secaoTitulo.add(labelTitulo);
    secaoTitulo.add(campoTitulo);

    // Limitando a entrada do JTextField
    campoTitulo.setDocument(
      new JTextFieldLimit(30)
    );

    campoTitulo.setText(this.titulo);

    JPanel centroSecaoTitulo = new JPanel();
    centroSecaoTitulo.setLayout(new BorderLayout());

    JPanel secaoDescricao = new JPanel();
    secaoDescricao.setLayout(new BorderLayout());
    secaoDescricao.setPreferredSize(new Dimension(400, 152));
    secaoDescricao.setBorder(new EmptyBorder(8, 8, 16, 8));
    secaoDescricao.setBackground(Theme.bgColor);

    JLabel tituloDescricao = new JLabel("Descricao");
    tituloDescricao.setFont(new Font(null, Font.BOLD, 18));
    tituloDescricao.setPreferredSize(new Dimension(400, 24));

    campoDescricao = new JTextArea();
    campoDescricao.setFont(new Font(null, Font.BOLD, 18));
    campoDescricao.setEditable(true);
    campoDescricao.setPreferredSize(new Dimension(400, 96));
    campoDescricao.setLineWrap(true);
    campoDescricao.setWrapStyleWord(true);

    secaoDescricao.add(tituloDescricao, BorderLayout.NORTH);
    secaoDescricao.add(campoDescricao, BorderLayout.CENTER);

    centroSecaoTitulo.add(secaoDescricao, BorderLayout.NORTH);

    campoDescricao.setDocument(
      new JTextFieldLimit(140)
    );

    campoDescricao.setText(this.descricao);

    JPanel centroSecaoDescricao = new JPanel();
    centroSecaoDescricao.setLayout(new BorderLayout());

    JPanel secaoData = new JPanel();
    secaoData.setLayout(new GridLayout(2, 1));
    secaoData.setBackground(Theme.bgColor);
    secaoData.setPreferredSize(new Dimension(400, 80));
    secaoData.setLayout(new GridLayout(2, 1));
    secaoData.setBorder(new EmptyBorder(8, 8, 16, 8));

    JLabel tituloData = new JLabel("Data");
    tituloData.setFont(new Font(null, Font.BOLD, 18));
    tituloData.setPreferredSize(new Dimension(400, 24));

    campoData = new JTextField();
    campoData.setFont(new Font(null, Font.BOLD, 18));
    campoData.setEditable(true);

    campoData.setDocument(
      new JTextFieldLimit(30)
    );

    campoData.setText(this.data);

    secaoData.add(tituloData);
    secaoData.add(campoData);
    
    JPanel centroSecaoData = new JPanel();
    centroSecaoData.setLayout(new BorderLayout());

    JPanel secaoHora = new JPanel();
    secaoHora.setLayout(new GridLayout(2, 1));
    secaoHora.setBackground(Theme.bgColor);
    secaoHora.setPreferredSize(new Dimension(400, 80));
    secaoHora.setLayout(new GridLayout(2, 1));
    secaoHora.setBorder(new EmptyBorder(8, 8, 16, 8));

    JLabel tituloHora = new JLabel("Hora");
    tituloHora.setFont(new Font(null, Font.BOLD, 18));
    tituloHora.setPreferredSize(new Dimension(400, 24));

    campoHora = new JTextField();
    campoHora.setFont(new Font(null, Font.BOLD, 18));
    campoHora.setEditable(true);
    
    campoHora.setDocument(
      new JTextFieldLimit(30)
    );

    campoHora.setText(this.hora);

    secaoHora.add(tituloHora);
    secaoHora.add(campoHora);

    JPanel centroSecaoHora = new JPanel();
    centroSecaoHora.setLayout(new BorderLayout());

    JPanel secaoPrioridade = new JPanel();
    secaoPrioridade.setLayout(new GridLayout(2, 1));
    secaoPrioridade.setBackground(Theme.bgColor);
    secaoPrioridade.setPreferredSize(new Dimension(400, 80));
    secaoPrioridade.setLayout(new GridLayout(2, 1));
    secaoPrioridade.setBorder(new EmptyBorder(8, 8, 16, 8));

    JLabel tituloPrioridade = new JLabel("Prioridade");
    tituloPrioridade.setFont(new Font(null, Font.BOLD, 18));
    tituloPrioridade.setPreferredSize(new Dimension(400, 24));

    String[] options = { "0", "1", "2", "3", "4", "5" };

    campoPrioridade = new JComboBox<>(options);
    campoPrioridade.setFont(new Font(null, Font.BOLD, 18));
    campoPrioridade.setEditable(false);
    campoPrioridade.setBackground(Color.WHITE);

    secaoPrioridade.add(tituloPrioridade);
    secaoPrioridade.add(campoPrioridade);

    JPanel centroSecaoPrioridade = new JPanel();
    centroSecaoPrioridade.setLayout(new BorderLayout());

    botaoSalvar = new JButton("Salvar");
    botaoSalvar.addActionListener(this);
    botaoSalvar.setPreferredSize(new Dimension(400, 60));
    botaoSalvar.setBackground(new Color(33, 255, 174));
    botaoSalvar.setFont(new Font(null, Font.BOLD, 18));
    botaoSalvar.setForeground(Color.DARK_GRAY);
    botaoSalvar.setFocusable(false);
    botaoSalvar.setBorder(
      BorderFactory.createMatteBorder(0, 0, 6, 0, Color.DARK_GRAY)
    );
    
    centroSecaoPrioridade.add(botaoSalvar, BorderLayout.NORTH);
    centroSecaoHora.add(centroSecaoPrioridade, BorderLayout.CENTER);
    centroSecaoHora.add(secaoPrioridade, BorderLayout.NORTH);
    centroSecaoData.add(centroSecaoHora, BorderLayout.CENTER);
    centroSecaoData.add(secaoHora, BorderLayout.NORTH);
    centroSecaoDescricao.add(centroSecaoData, BorderLayout.CENTER);
    centroSecaoDescricao.add(secaoData, BorderLayout.NORTH);
    centroSecaoTitulo.add(centroSecaoDescricao, BorderLayout.CENTER);
    this.add(secaoTitulo, BorderLayout.NORTH);
    this.add(centroSecaoTitulo);
    this.setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == this.botaoSalvar) {
      String titulo = this.campoTitulo.getText();
      String descricao = this.campoDescricao.getText();
      String data = this.campoData.getText();
      String hora = this.campoHora.getText();
      String prioridade = (String) this.campoPrioridade.getSelectedItem();

      this.menu.editarTarefa(index, titulo, descricao, data, hora, prioridade);
      this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSING));
    }
  }
}
