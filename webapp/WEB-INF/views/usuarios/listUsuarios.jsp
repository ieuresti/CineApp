<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">    
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Listado de Usuarios</title>
    <!-- Ruta relativa al ContextPath -->
    <spring:url value="/resources" var="urlPublic" />
    <spring:url value="/usuarios/edit" var="urlEdit" />
    <spring:url value="/usuarios/delete" var="urlDelete" />
    <spring:url value="/usuarios/create" var="urlCreate" />
    <link href="${urlPublic}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="${urlPublic}/bootstrap/css/theme.css" rel="stylesheet">
    
  </head>

  <body>

    <jsp:include page="../includes/menu.jsp"></jsp:include>

    <div class="container theme-showcase" role="main">

      <h3>Listado de Usuarios</h3>
      
      <c:if test="${msg != null}">
      	<div class="alert alert-success" role="alert">${msg}</div>
      </c:if>
      
      <a href="${urlCreate}" class="btn btn-success" role="button" title="Nuevo Usuario" >Nuevo</a><br><br>

      <div class="table-responsive">
        <table class="table table-hover table-striped table-bordered">
            <tr>
                <th>Cuenta</th>
                <th>Email</th>
                <th>Telefono</th>              
                <th>Estatus</th>              
                <th>Opciones</th>              
            </tr>
            
            <c:forEach items="${usuarios}" var="usuario">
            <tr>
                <td>${usuario.cuenta}</td>
				<td>${usuario.email}</td>
				<td>${usuario.telefono}</td>
				<c:choose>
					<c:when test="${usuario.activo eq '1'}">
						<td><span class="label label-success">${usuario.activo}</span></td>
					</c:when>
					<c:otherwise>
						<td><span class="label label-danger">${usuario.activo}</span></td>
					</c:otherwise>
				</c:choose>
                <td>
                    <a href="${urlEdit}/${usuario.id}" class="btn btn-success btn-sm" role="button" title="Edit" ><span class="glyphicon glyphicon-pencil"></span></a>
                    <a href="${urlDelete}/${usuario.id}" onclick='return confirm("�Estas seguro?")' class="btn btn-danger btn-sm" role="button" title="Eliminar" ><span class="glyphicon glyphicon-trash"></span></a>
                </td>
            </tr>
            </c:forEach>       
        </table>
      </div>  
      <hr class="featurette-divider">

      <jsp:include page="../includes/footer.jsp"></jsp:include>

    </div> <!-- /container -->

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> 
    <script src="${urlPublic}/bootstrap/js/bootstrap.min.js"></script>     
  </body>
</html>