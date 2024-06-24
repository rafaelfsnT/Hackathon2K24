package Vacina.dao;

import Vacina.model.AgenteDeSaude;
import Vacina.model.Historico;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HistoricoDao {
    private Connection connection;

    public HistoricoDao() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/vacina?useTimezone=true&serverTimezone=UTC", "root", "");
        } catch (Exception e) {
            throw new SQLException(e.getMessage());
        }
    }

    public List<Historico> listarTodos() throws SQLException {
        List<Historico> historicos = new ArrayList<Historico>();

        ResultSet rs = connection.prepareStatement("SELECT nome_idoso, nome_vacina, agendamento , nome_agente FROM agendamento"
            ).executeQuery();
        while (rs.next()) {
            historicos.add(new Historico(
                    rs.getString("nome_idoso"),
                    rs.getString("nome_vacina"),
                    rs.getDate("agendamento").toLocalDate(),
                    rs.getString("nome_agente")));
        }
        rs.close();

        return historicos;
    }
}
