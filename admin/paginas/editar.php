<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tela de Agendamento</title>
    <link rel="stylesheet" href="./cssPages/agendamentos.css">

    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">

</head>

<body>
    <div class="container">

        <img src="./img/logovacina.png" alt="Logo do Sistema" class="logo">
        <h1>Tela de Agendamento</h1>
        <form id="cadastroForm" method="post" action="./paginas/home">
 


            <div class="form-group">
                <label for="nome">Nome</label>
                <input type="text" id="nome" name="nome" required>
            </div>
            <div class="form-group">
                <label for="vacina">Vacina</label>
                <input type="text" id="vacina" name="vacina" required>

            </div>
            <div class="form-group">
                <label for="dataNascimento">Data</label>
                <input type="date" id="dataNascimento" name="dataNascimento" required>
            </div>
            <div class="form-buttons row">
                <div class="col">
                    <button class="btn btn-outline-success mt-3" type="submit">Agendar</button>
                </div>
                <div class="col">
                <a href="./paginas/home"><button class="btn btn-outline-danger mt-3" type="button">Voltar</button></a>
                </div>
            </div>
        </form>
    </div>
</body>