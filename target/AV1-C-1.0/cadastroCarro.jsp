<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Geral" method="post">
            Nome: <input type="text" name="nome">
            <input type="hidden" name="parent" value="carro">
            <input type="submit" value="Cadastrar">
        </form>
        <a href="index.html">Retornar ao início</a>
    </body>
</html>