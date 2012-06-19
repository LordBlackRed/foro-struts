<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@page import="foro.constantes.Constantes"%>
<!DOCTYPE html>
<html dir="ltr" lang="en-US">
<head>
<meta HTTP-EQUIV="REFRESH" content="0; url=index.action">
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
<title>Mi Pequeño Foro Virtual</title>
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
							<div class="entry-meta-2">Últimos Mensajes</div>
						</header>
						<div class="entry-content">
							<table>
								<s:subset source="mensajes" count="5" start="0">
									<s:iterator>
										<tr>
											<td><h4>
													<s:property value="topic.titulo" />
													-
													<s:property value="fecha" />
												</h4>
												<table>
													<tr>
														<s:url action="postAction.action" id="urlTopicM">
															<s:param name="id" value="%{topic.id}" />
														</s:url>
														<td><s:a href="%{urlTopicM}">
																<s:property value="mensaje" />
															</s:a></td>
														<td>
														<td><b><i> <s:property value="usuario.nick" />
															</i></b></td>
													</tr>
												</table></td>
										</tr>
									</s:iterator>
								</s:subset>

							</table>
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