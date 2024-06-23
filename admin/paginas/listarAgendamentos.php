<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listagem de Agendamento</title>
    <link rel="stylesheet" href="./cssPages/agendamentos.css">

    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">

</head>

<body>

    <div class="container mt-4">
        <div class="card">
            <div class="card-body">
                <table class="table table-bordered table-hover table-striped">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Nome do idoso</th>
                            <th>Nome do agente</th>
                            <th>Nome da vacina</th>
                            <th>Opções</th>
                        </tr>
                    </thead>
                    <tbody>
                        <?php
                        $link = "http://localhost:3001/agendamento";
                        $response = file_get_contents($link);
                        $dados = json_decode($response);

                        if ($dados === null) {
                            die('Erro ao decodificar JSON.');
                        }

                        foreach ($dados->agendamentos as $agendamento) {
                            ?>
                            <tr>
                                <td><?php echo $agendamento->id; ?></td>
                                <td><?php echo $agendamento->nome_idoso; ?></td>
                                <td><?php echo $agendamento->nome_agente; ?></td>
                                <td><?php echo $agendamento->nome_vacina; ?></td>
                                <td>
                                    <a href="http://localhost:3001/agendamento/<?php echo $agendamento->id; ?>"
                                        class="btn btn-success">
                                        <i class="fas fa-edit"></i> Editar
                                    </a>
                                <td>
                                    <button type="button" class="btn btn-danger"
                                        onclick="deleteAgendamento(<?php echo $agendamento->id; ?>)">
                                        <i class="fas fa-trash"></i> Excluir
                                    </button>
                                </td>
                                </a>
                                </td>
                            </tr>
                            <?php
                        }
                        ?>
                    </tbody>
                </table>
            </div>
        </div>
    </div>


</body>

<script>
    function deleteAgendamento(id) {
        if (confirm('Tem certeza que deseja excluir este agendamento?')) {
            fetch(`http://localhost:3001/agendamentos/${id}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json',
                },
            })
            .then(response => {
                if (response.ok) {
                    alert('Agendamento excluído com sucesso.');
                    location.reload(); 
                } else {
                    alert('Erro ao excluir o agendamento.');
                }
            })
            .catch(error => {
                console.error('Erro:', error);
                alert('Erro ao excluir o agendamento.');
            });
        }
    }
</script>

</html>