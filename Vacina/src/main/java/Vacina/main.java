package Vacina;



import Vacina.view.*;

import java.awt.*;

import javax.swing.*;

public class main {
    public static void main(String[] args) {

        agendamentoNotificação();

        JFrame frame = new JFrame("Formulário");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JButton idosoButton = new JButton("Cadastrar/Alterar Idoso");
        JButton agenteButton = new JButton("Cadastrar/Alterar Agente");
        JButton vacinaButton = new JButton("Cadastrar/Alterar Vacina");
        JButton agendamentoButton = new JButton("Cadastrar/Alterar Agendamento");
        JButton historicoButton = new JButton("Historico");


        Dimension buttonSize = new Dimension(250, 50); // Adjust as needed
        idosoButton.setPreferredSize(buttonSize);
        agenteButton.setPreferredSize(buttonSize);
        vacinaButton.setPreferredSize(buttonSize);
        agendamentoButton.setPreferredSize(buttonSize);
        historicoButton.setPreferredSize(buttonSize);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.setBackground(Color.blue);

        buttonPanel.add(Box.createVerticalStrut(10));

        JPanel emptyPanel = new JPanel();
        emptyPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        emptyPanel.setBackground(Color.black);

        emptyPanel.add(idosoButton);
        emptyPanel.add(agenteButton);
        emptyPanel.add(vacinaButton);
        emptyPanel.add(agendamentoButton);
        emptyPanel.add(historicoButton);

        buttonPanel.add(emptyPanel);

        idosoButton.addActionListener(e -> idosoINvocar());
        agenteButton.addActionListener(e -> agenteINvocar());
        vacinaButton.addActionListener(e -> vacinaINvocar());
        agendamentoButton.addActionListener(e -> agemdamentoINvocar());
        historicoButton.addActionListener(e -> historicoINvocar());



        frame.add(buttonPanel, BorderLayout.CENTER);


        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void agenteINvocar() {
        SwingUtilities.invokeLater(() -> {
            var form = new AgenteDeSaudeForm();
            form.setVisible(true);
        });
    }
    public static void idosoINvocar() {
        SwingUtilities.invokeLater(() -> {
            var form = new IdosoForm();
            form.setVisible(true);
        });


    }
    public static void vacinaINvocar() {
        SwingUtilities.invokeLater(() -> {
            var form = new Vacinaform();
            form.setVisible(true);
        });


    }

    public static void agemdamentoINvocar() {
        SwingUtilities.invokeLater(() -> {
            var form = new AgendamentoForm();
            form.setVisible(true);
        });
    }

        public static void historicoINvocar() {
            SwingUtilities.invokeLater(() -> {
                var form = new HistoricoView();
                form.setVisible(true);
            });

    }

    public static void agendamentoNotificação() {
        SwingUtilities.invokeLater(() -> {
            var form = new AgendamentoView();
            form.setVisible(true);
        });

    }
}


