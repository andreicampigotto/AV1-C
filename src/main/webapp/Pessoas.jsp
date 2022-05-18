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
    <%
        ArrayList<Pessoa> pessoas = (ArrayList<Pessoa>) request.getAttribute("pessoas");
    %>
        <table>
            <thead>
                <tr>
                    <th colspan="1">id</th>
                    <th colspan="1">nome</th>
                    <th colspan="1">email</th>
                    <th colspan="1">peso</th>
                    <th colspan="1">carro</th>
                </tr>
            </thead>
            <tbody>
    <%
        for (Pessoa pessoa : pessoas) {
    %>
            <tr>
            <td><%=pessoa.getId()%></td>
            <td><%=pessoa.getNome()%></td>
            <td><%=pessoa.getEmail()%></td>
            <td><%=pessoa.getPeso()%></td>
            <td><%=pessoa.getCarro().getNome()%></td>
            </tr>
    <%
        }
    %>       
            </tbody>
        </table>
    <a href="index.html">Retornar ao início</a>
    </body>
</html>