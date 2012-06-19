<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page import="foro.constantes.Constantes"%>
<!DOCTYPE html>
<html dir="ltr" lang="en-US">
<head>
<link rel="profile" href="http://gmpg.org/xfn/11" />
<link href='http://fonts.googleapis.com/css?family=Maven+Pro&amp;v1'
	rel='stylesheet' type='text/css'>
<meta charset="UTF-8" />
<meta name="description"
	content="Una pagina web de muestra con el framework struts2" />
<meta name="keywords" content="foro,struts,j2ee,ejemplo" />
<meta name="author"
	content="Rafael de los Santos Guirado / Original design by andreasviklund.com" />
<!--[if lt IE 9]>
	<script src="html5.js" type="text/javascript"></script>
	<![endif]-->
<title>Smokescreen CSS template</title>
<link rel="stylesheet" type="text/css" media="all"
	href="smokescreen.css" />
</head>

<body>
	<div id="page">
		<s:include value="header.jsp" />

		<div id="main">
			<div id="primary">
				<div id="content" role="main">
					<article class="post">
						<header class="entry-header">
							<h1 class="entry-title">El Foro</h1>
							<div class="entry-meta-2">
								Mensajes de
								<s:property value="%{topic.titulo}" />
							</div>
						</header>
						<div class="entry-content">
							<table>
								<s:subset source="topic.mensajeses" count="5"
									start="%{comienzoPag}">

									<s:iterator>
										<tr>
											<td><s:property value="mensaje" /></td>
										</tr>
									</s:iterator>
								</s:subset>
							</table>


							<%
								for (int i = 0; i < Constantes.numPaginas; i++) {
							%>
							<s:url action="postAction.action" id="verPag">
								<s:param name="pagActual">
									<%
										out.print(i + 1);
									%>
								</s:param>
							</s:url>
							<s:a href="%{verPag}">
								<%
									out.print(i + 1);
								%>
							</s:a>

							<%
								}
								if (Constantes.logueado) {
							%>
							<s:form action="nuevoPostAction.action" method="post">
								<s:textarea name="mensaje" key="label.mensajeNuevo" />
								<s:submit method="nuevoMensaje" key="label.enviar"
									align="center" />
							</s:form>

							<%
								}
							%>
						</div>
					</article>

				</div>
			</div>

			<s:include value="rightContent.jsp" />

			<s:include value="footer.jsp" />
		</div>
	</div>
</body>
</html>