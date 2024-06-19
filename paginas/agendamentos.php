<!DOCTYPE html>
<html lang="pt-br">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Vacinas de 2024</title>
    <link rel="stylesheet" href="./css/agendamentos.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/8bb0dffdb3.js" crossorigin="anonymous"></script>
    <style>

    </style>
</head>

<body>
    
        <nav class="navbar navbar-expand-lg navbar-custom ">
            <div class="container-fluid">
                <a class="navbar-brand" href="./paginas/home">Início</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    </ul>
                    <ul class="navbar-nav navbar-nav-center mb-2 mb-lg-0">
                        <li class="nav-item">
                            <a class="nav-link active" href="./paginas/agendamentos">Agendamentos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link active" href="#saibaMais">Saiba Mais</a>
                        </li>
                    </ul>
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item">
                            <button class="btn btn-outline-light" type="button">Cadastrar Idoso</button>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>


    <div class="container mt-5">
        <h1 class="text-center mb-4">Formulário de Agendamento de Visitas</h1>
        <form>
            <div class="mb-3">
                <label for="nome" class="form-label">Nome Completo</label>
                <input type="text" class="form-control" id="nome" name="nome" required>
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">E-mail</label>
                <input type="email" class="form-control" id="email" name="email" required>
            </div>
            <div class="mb-3">
                <label for="telefone" class="form-label">Telefone</label>
                <input type="tel" class="form-control" id="telefone" name="telefone" required>
            </div>
            <div class="mb-3">
                <label for="data-visita" class="form-label">Data da Visita</label>
                <input type="date" class="form-control" id="data-visita" name="data_visita" required>
            </div>
            <div class="mb-3">
                <label for="mensagem" class="form-label">Mensagem (opcional)</label>
                <textarea class="form-control" id="mensagem" name="mensagem" rows="3"></textarea>
            </div>
            <button type="submit" class="btn btn-primary">Agendar Visita</button>
        </form>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>

</html>