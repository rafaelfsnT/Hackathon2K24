<?php
session_start();

?>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ADMIN</title>
    <base href="<?php echo "http://" . $_SERVER["HTTP_HOST"] . $_SERVER["SCRIPT_NAME"]; ?>">

</head>

<body id="page-top">
    <?php
     
      if (isset($_GET['param'])) {

        // 'paginas/home/1
        // paginas == pasta/diretorio
        // home = o arquivo php
        // $array['paginas','home','id']

        // explode está desmontando o array param, dividindo pela "/" 
        $page = explode("/", $_GET['param']);

        // adicionando as partes desmontadas em cada variável
        $pasta = $page[0] ?? NULL;
        $arquivo = $page[1] ?? NULL;
        $id = $page[2] ?? NULL;

        // montando a url da pagina
        $page = "$pasta/$arquivo";

        // verificando se existe o arquivo com o nome da variavel page
        if(file_exists("$page.php")) {
            require "$page.php";
        }
    }

    ?>

</body>

</html>