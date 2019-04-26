<!-- Pagina Jsp  -->

<%
//Pegando o valor da empresa que esta no request

String nomeEmpresa = (String) request.getAttribute("empresa");
System.out.println(nomeEmpresa);
%>

<html><body>
Empresa <%= nomeEmpresa %> cadastrada com sucesso!
</body></html>