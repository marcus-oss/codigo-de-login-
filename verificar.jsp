
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import ="model.Usuario"%>
<%@page import="dao.UsuarioDAO"%>

<%
Usuario usu= new Usuario();
UsuarioDAO usd= new UsuarioDAO();

String nome = request.getParameter("login");
String senha = request.getParameter("senha");


usu.setLogin_usuario(nome);
usu.setSenha_usuario(senha);
boolean status = usd.verificarUsuario(usu);
if(usd.result){
    out.print("Bem Vindo :" +usd.nome);
    
}else{
    out.print("login invalido");
}



%>