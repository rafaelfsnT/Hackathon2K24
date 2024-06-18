<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Idoso</title>

<link rel="stylesheet" href="../css/cadastro.css">
<body>
    <form action="home.php" method="post">
        <h2>Cadastro de Idoso</h2>
        <label for="nome">Nome:</label>
        <input type="text" id="nome" name="nome" required>

        <label for="idade">Idade:</label>
        <input type="number" id="idade" name="idade" required>

        <label for="genero">Gênero:</label>
        <select id="genero" name="genero" required>
            <option value="">Selecione...</option>
            <option value="masculino">Masculino</option>
            <option value="feminino">Feminino</option>
        </select>

        <label for="observacoes">Observações:</label>
        <textarea id="observacoes" name="observacoes" rows="4"></textarea>

        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>