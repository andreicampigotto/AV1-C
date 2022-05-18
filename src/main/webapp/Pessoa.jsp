<%@page contentType="text/html" pageEncoding="UTF-8"
        import="java.util.*"
        import="ifc.edu.br.mv9webhib.model.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="Geral" method="post">
            Nome: <input type="text" name="nome"> <br>
            Email: <input type="text" name="email"> <br>
            Peso: <input type="text" name="peso"> <br>
            Carro: 
        <select name="carros">
    <%
        ArrayList<Carro> carros = (ArrayList<Carro>) request.getAttribute("carros");
        for (Carro carro : carros) {
    %>
            <option value="<%=carro.getId()%>"><%=carro.getNome()%></option>
    <%
        }
    %>
        </select> <br>
            <input type="hidden" name="parent" value="pessoa">
            <input type="submit" value="Cadastrar">
        </form>
        <a href="index.html">Retornar ao início</a>
    </body>
</html>
