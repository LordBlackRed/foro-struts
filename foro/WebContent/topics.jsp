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
							<div class="entry-meta-2">Topics en el Foro</div>
						</header>
						<div class="entry-content">
							<table>
								<s:iterator value="topics">
									<tr>
										<td><s:url action="postAction.action" id="urlTopic">
												<s:param name="id" value="%{id}" />
											</s:url> <s:a href="%{urlTopic}">
												<s:property value="titulo" />
											</s:a></td>
									</tr>
								</s:iterator>
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