package Vacina.view;

import Vacina.service.HistoricoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class AgendamentoView extends JFrame {
    private JTable tabelaAgendamenmto;
    private HistoricoService service;

    public AgendamentoView(){
        service = new HistoricoService();

        setTitle("Agendados");
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setSize(500, 600);

        JPanel painelEntrada = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.insets = new Insets(5, 5, 5, 5);
        JPanel painelSaida = new JPanel(new BorderLayout());

        tabelaAgendamenmto = new JTable();
        tabelaAgendamenmto.setModel(carregarDadosHistorico());
        tabelaAgendamenmto.setDefaultEditor(Object.class, null);

        JScrollPane scrollPane = new JScrollPane(tabelaAgendamenmto);
        painelSaida.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(painelEntrada, BorderLayout.NORTH);
        getContentPane().add(painelSaida, BorderLayout.CENTER);

        setLocationRelativeTo(null);

    }
    private DefaultTableModel carregarDadosHistorico() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("nome");
        model.addColumn("vacina");
        model.addColumn("aplicação");
        model.addColumn("agente");

        service.listarHistorico().forEach(historico -> model.addRow(new Object[]{
                        historico.getNomeIdoso(),
                        historico.getNomeVacina(),
                        historico.getDataAplicacao(),
                        historico.getNomeAgente()
                })
        );
        return model;
    }
}

