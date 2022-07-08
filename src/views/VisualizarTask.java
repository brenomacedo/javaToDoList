package views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import utils.Theme;

public class VisualizarTask extends JFrame {

  String titulo;
  String descricao;
  String data;
  String hora;
  String prioridade;
  String conclusao;

  public VisualizarTask(String titulo, String descricao, String data, String hora, String prioridade, String conclusao, Menu menu) {

    this.titulo = titulo;
    this.descricao = descricao;
    this.data = data;
    this.hora = hora;
    this.prioridade = prioridade;
    this.conclusao = conclusao;

    this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    this.getContentPane().setBackground(Theme.bgColor);
    this.setResizable(false);
    this.setSize(400, 510);
    this.setLayout(new BorderLayout());

    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        menu.setVisualizandoTarefa(false);
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
    JTextField campoTitulo = new JTextField(this.titulo);
    campoTitulo.setFont(new Font(null, Font.BOLD, 18));
    campoTitulo.setEditable(false);

    secaoTitulo.add(labelTitulo);
    secaoTitulo.add(campoTitulo);

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

    JTextArea campoDescricao = new JTextArea(this.descricao);
    campoDescricao.setFont(new Font(null, Font.BOLD, 18));
    campoDescricao.setEditable(false);
    campoDescricao.setPreferredSize(new Dimension(400, 96));
    campoDescricao.setLineWrap(true);
    campoDescricao.setWrapStyleWord(true);

    secaoDescricao.add(tituloDescricao, BorderLayout.NORTH);
    secaoDescricao.add(campoDescricao, BorderLayout.CENTER);

    centroSecaoTitulo.add(secaoDescricao, BorderLayout.NORTH);

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

    JTextField campoData = new JTextField(this.data);
    campoData.setFont(new Font(null, Font.BOLD, 18));
    campoData.setEditable(false);

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

    JTextField campoHora = new JTextField(this.hora);
    campoHora.setFont(new Font(null, Font.BOLD, 18));
    campoHora.setEditable(false); 

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

    JTextField campoPrioridade = new JTextField(this.prioridade);
    campoPrioridade.setFont(new Font(null, Font.BOLD, 18));
    campoPrioridade.setEditable(false); 

    secaoPrioridade.add(tituloPrioridade);
    secaoPrioridade.add(campoPrioridade);

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
}
