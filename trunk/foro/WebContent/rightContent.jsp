<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="foro.constantes.Constantes"%>
<!DOCTYPE html>
<html dir="ltr" lang="en-US">
<head>
<link rel="profile" href="http://gmpg.org/xfn/11" />
<link href='http://fonts.googleapis.com/css?family=Maven+Pro&amp;v1'
	rel='stylesheet' type='text/css'>
<meta charset="UTF-8" />
<meta name="description" content="Una pagina web de muestra con el framework struts2" />
<meta name="keywords" content="foro,struts,j2ee,ejemplo" />
<meta name="author"
	content="Rafael de los Santos Guirado / Original design by andreasviklund.com" />
<!--[if lt IE 9]>
	<script src="html5.js" type="text/javascript"></script>
	<![endif]-->
<title>Mi Pequeño Foro Virtual</title>
<link rel="stylesheet" type="text/css" media="all"
	href="smokescreen.css" />
</head>

<div id="secondary" class="widget-area">
				<aside class="widget">
					<h1 class="widget-title">Usuario</h1>
					<%
						if (!Constantes.logueado) {
					%>
					<s:actionerror />
					<s:form action="login.action" method="post">

						<s:textfield name="username" key="label.username" size="20" />
						<s:password name="password" key="label.password" size="20" />

						<s:submit method="execute" key="label.login" align="center" />
					</s:form>
					<%
						} else {
					%>
					<s:property value="usuario.nick" />
					<s:url action="salirAction.action"
									id="salir" />
								<s:a href="%{salir}">
									Salir
								</s:a>
					<%
						}
					%>
				</aside>

				<aside class="widget">
					<h1 class="widget-title">Topics</h1>
					<ul>
						<s:iterator value="categorias">

							<li class="menu-item"><s:url action="topicAction.action"
									id="urlD">
									<s:param name="id" value="%{id}" />
								</s:url> <s:a href="%{urlD}">
									<s:property value="nombre" />
								</s:a></li>
						</s:iterator>
					</ul>
				</aside>
			</div>
</html>