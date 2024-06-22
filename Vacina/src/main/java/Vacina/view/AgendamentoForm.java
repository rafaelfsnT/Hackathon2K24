package Vacina.view;

import Vacina.main;
import Vacina.model.Agendamento;
import Vacina.model.AgenteDeSaude;
import Vacina.service.AgendamentoService;
import Vacina.service.AgenteDeSaudeService;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;

import static java.lang.Integer.parseInt;


public class AgendamentoForm extends JFrame {
    private AgendamentoService service;
    private JLabel labelId;
    private JTextField campoId;
    private JLabel labelNomeAgente;
    private JTextField campoNomeAgente;
    private JLabel labelIdoso;
    private JTextField campoIdoso;
    private JLabel labelVacina;
    private JTextField campoVacina;
    private JLabel labelAtndimento;
    private JTextField campoAtendimento;
    private JButton botaoSalvar;
    private JButton botaoCancelar;
    private JButton botaoDeletar;
    private JButton botaoVoltarAgendamento;
    private JTable tabelaAgendamento;

    public AgendamentoForm() {
        service = new AgendamentoService();

        setTitle("Agendamento");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(600, 550);

        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);


        campoId = new JTextField(20);
        campoId.setEnabled(false);
        campoId.setVisible(false);
        constraints.gridx = 1;
        constraints.gridy = 0;
        painelEntrada.add(campoId, constraints);

        labelNomeAgente = new JLabel("Nome do idoso:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        painelEntrada.add(labelNomeAgente, constraints);

        campoNomeAgente = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 1;
        painelEntrada.add(campoNomeAgente, constraints);

        labelIdoso = new JLabel("Nome do Agente:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        painelEntrada.add(labelIdoso, constraints);

        campoIdoso = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 2;
        painelEntrada.add(campoIdoso, constraints);

        labelVacina = new JLabel("Vacina:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        painelEntrada.add(labelVacina, constraints);

        campoVacina = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 3;
        painelEntrada.add(campoVacina, constraints);

        labelAtndimento = new JLabel("Dia de Atendimento:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        painelEntrada.add(labelAtndimento, constraints);

        campoAtendimento = new JTextField(20);
        constraints.gridx = 1;
        constraints.gridy = 4;
        painelEntrada.add(campoAtendimento, constraints);

        botaoVoltarAgendamento = new JButton("Voltar");
        botaoVoltarAgendamento.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fechar o formulário de Agendamento
                dispose();
            }
        });
        constraints.gridx = 0;
        constraints.gridy = 5;
        painelEntrada.add(botaoVoltarAgendamento, constraints);

        botaoCancelar = new JButton("Cancelar");
        botaoCancelar.addActionListener(e -> limparCampos());
        constraints.gridx = 1;
        constraints.gridy = 5;
        painelEntrada.add(botaoCancelar, constraints);

        botaoDeletar = new JButton("Deletar");
        botaoDeletar.addActionListener(e -> deletar());
        constraints.gridx = 2;
        constraints.gridy = 5;
        painelEntrada.add(botaoDeletar, constraints);

        botaoSalvar = new JButton("Salvar");
        botaoSalvar.addActionListener(e -> executarAcaoDoBotao());
        constraints.gridx = 3;
        constraints.gridy = 5;
        painelEntrada.add(botaoSalvar, constraints);



        JPanel painelSaida = new JPanel(new BorderLayout());

        tabelaAgendamento = new JTable();
        tabelaAgendamento.setModel(carregarAtendimento());
        tabelaAgendamento.getSelectionModel().addListSelectionListener(e -> selecionarAgendamento(e));
        tabelaAgendamento.setDefaultEditor(Object.class, null);

        JScrollPane scrollPane = new JScrollPane(tabelaAgendamento);
        painelSaida.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(painelEntrada, BorderLayout.NORTH);
        getContentPane().add(painelSaida, BorderLayout.CENTER);

        setLocationRelativeTo(null);
    }
    private DefaultTableModel carregarAtendimento() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("id");
        model.addColumn("idoso");
        model.addColumn("agente");
        model.addColumn("vacina");
        model.addColumn("data atendiemento");


        service.listarAgendamento().forEach(agendamento -> model.addRow(new Object[]{
                        agendamento.getId(),
                        agendamento.getAgente(),
                        agendamento.getIdoso(),
                        agendamento.getVacina(),
                        agendamento.getAtendimento()
                })
        );
        return model;
    }

    private void limparCampos(){
        campoIdoso.setText("");
        campoAtendimento.setText("");
        campoNomeAgente.setText("");
        campoVacina.setText("");
        campoId.setText("");
    }

    private void executarAcaoDoBotao() {
        if (validarCampoVazio()) {
            service.salvar(construirAgendamento());
            limparCampos();
            tabelaAgendamento.setModel(carregarAtendimento());
        }
    }

    private void deletar() {
        service.excluir(construirAgendamento());
        limparCampos();
        tabelaAgendamento.setModel(carregarAtendimento());
    }
    private Agendamento construirAgendamento() {
        return campoId.getText().isEmpty()
                ?  new Agendamento(
                campoIdoso.getText(),
                campoNomeAgente.getText(),
                campoVacina.getText(),
                LocalDate.parse(campoAtendimento.getText())
        )
                : new Agendamento(
                parseInt(campoId.getText()),
                campoIdoso.getText(),
                campoNomeAgente.getText(),
                campoVacina.getText(),
                LocalDate.parse(campoAtendimento.getText()));
    }
    private void selecionarAgendamento(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting()) {
            int selectedRow = tabelaAgendamento.getSelectedRow();
            if (selectedRow != -1) {
                var id = (Integer) tabelaAgendamento.getValueAt(selectedRow, 0);
                campoId.setText(id.toString());
                var agente = (String) tabelaAgendamento.getValueAt(selectedRow, 1);
                campoNomeAgente.setText(agente);
                var idoso = (String) tabelaAgendamento.getValueAt(selectedRow,2);
                campoIdoso.setText(idoso);
                var vacina = (String) tabelaAgendamento.getValueAt(selectedRow,3);
                campoVacina.setText(vacina);
                var atendimento = (LocalDate)  tabelaAgendamento.getValueAt(selectedRow,4);
                campoAtendimento.setText(atendimento.toString());
            }
        }
    }
    private boolean validarCampoVazio() {
        if (campoNomeAgente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "O campo nome está vazio!", "Campo Inválido", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
}