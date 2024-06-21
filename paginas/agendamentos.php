<!DOCTYPE html>
<html lang="pt-BR">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cadastro de Idoso para Vacina</title>
    <link rel="stylesheet" href="./css/agendamentos.css">
    <script src="./js/cadastro.js"></script>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap" rel="stylesheet">

</head>

<body>
<div class="container">
        <header>
            <img src="./img/logovacina.png" alt="Logo do Sistema" class="logo">
            <h1>Tela de Agendamento</h1>
        </header>
        <form id="cadastroForm" onsubmit="return validarFormulario()" method="post">  
        <div class="form-group">
                <label for="nome">Nome</label>
                <input type="text" id="nome" name="nome" required>
            </div>   
            
        <div class="form-group">
                <label for="dataNascimento">Data</label>
                <input type="date" id="dataNascimento" name="dataNascimento" required>
            </div>
        
           
          
           
           
            <div class="form-buttons">
               <a href="./paginas/home"> <button type="submit">Agendar</button></a> 
            </div>
        </form>
    </div>
   

</body>

</html>