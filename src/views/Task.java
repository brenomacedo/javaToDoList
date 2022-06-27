package views;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Dimension;

import utils.Theme;

public class Task extends JPanel {
  Task(String titulo, int prioridade) {
    this.setLayout(new BorderLayout());
    this.setBorder(BorderFactory.createMatteBorder(4, 8, 4, 8, Theme.bgColor));
    this.setBackground(Color.WHITE);
    JPanel botoes = new JPanel();
    botoes.setBorder(new EmptyBorder(0, 8, 0, 8));
    botoes.setBackground(Color.WHITE);
    GridLayout botoesLayout = new GridLayout(1, 4);
    botoesLayout.setHgap(4);
    botoes.setLayout(botoesLayout);
    botoes.setPreferredSize(new Dimension(140, 28));

    // Icone icone tarefa concluida
    ImageIcon iconeConcluido = new ImageIcon("images/concluded-task.png");
    Image imageIconeConcluido = iconeConcluido.getImage();
    Image novoIconeConcluido = imageIconeConcluido.getScaledInstance(24, 24,  java.awt.Image.SCALE_SMOOTH);
    iconeConcluido = new ImageIcon(novoIconeConcluido);

    // Icone icone tarefa nao concluida
    ImageIcon iconeNaoConcluido = new ImageIcon("images/empty-checkbox.png");
    Image imageIconeNaoConcluido = iconeNaoConcluido.getImage();
    Image novoIconeNaoConcluido = imageIconeNaoConcluido.getScaledInstance(24, 24,  java.awt.Image.SCALE_SMOOTH);
    iconeNaoConcluido = new ImageIcon(novoIconeNaoConcluido);

    // Checkbox tarefa concluída
    JCheckBox tarefaConcluida = new JCheckBox();
    tarefaConcluida.setSize(24, 24);
    tarefaConcluida.setSelectedIcon(iconeConcluido);
    tarefaConcluida.setIcon(iconeNaoConcluido);
    tarefaConcluida.setBackground(Color.WHITE);

    // Icone botao deletar
    ImageIcon iconeDeletar = new ImageIcon("images/delete.png");
    Image imageIconeDeletar = iconeDeletar.getImage();
    Image novoIconeDeletar = imageIconeDeletar.getScaledInstance(24, 24,  java.awt.Image.SCALE_SMOOTH);
    iconeDeletar = new ImageIcon(novoIconeDeletar);

    // borda botoes
    Border emptyBorder = BorderFactory.createEmptyBorder();

    // botao deletar
    JButton botaoDeletar = new JButton();
    botaoDeletar.setFocusable(false);
    botaoDeletar.setIcon(iconeDeletar);
    botaoDeletar.setBackground(Color.WHITE);
    botaoDeletar.setBorder(emptyBorder);

    // Icone botao editar
    ImageIcon iconeEditar = new ImageIcon("images/edit.png");
    Image imageIconeEditar = iconeEditar.getImage();
    Image novoIconeEditar = imageIconeEditar.getScaledInstance(24, 24,  java.awt.Image.SCALE_SMOOTH);
    iconeEditar = new ImageIcon(novoIconeEditar);

    // Botao editar
    JButton botaoEditar = new JButton();
    botaoEditar.setFocusable(false);
    botaoEditar.setIcon(iconeEditar);
    botaoEditar.setBackground(Color.WHITE);
    botaoEditar.setBorder(emptyBorder);

    // Icone botao visualizar
    ImageIcon iconeVisualizar = new ImageIcon("images/visualize.png");
    Image imageIconeVisualizar = iconeVisualizar.getImage();
    Image novoIconeVisualiar = imageIconeVisualizar.getScaledInstance(24, 24,  java.awt.Image.SCALE_SMOOTH);
    iconeVisualizar = new ImageIcon(novoIconeVisualiar);

    // Botao visualizar
    JButton botaoVisualizar = new JButton();
    botaoVisualizar.setFocusable(false);
    botaoVisualizar.setIcon(iconeVisualizar);
    botaoVisualizar.setBackground(Color.WHITE);
    botaoVisualizar.setBorder(emptyBorder);
    
    botoes.add(tarefaConcluida);
    botoes.add(botaoDeletar);
    botoes.add(botaoEditar);
    botoes.add(botaoVisualizar);

    this.add(botoes, BorderLayout.EAST);

  }
}
