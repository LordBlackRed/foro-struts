<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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

<header id="branding">
	<hgroup>
		<h1 id="site-title">
			<s:url action="index.action" id="index">
			</s:url>
			<s:a href="%{index}">Mi Pequeño Foro Virtual</s:a>
		</h1>
		<h2 id="site-description">¡¡Un pequeño foro realizado en Struts &
			J2EE!!</h2>
	</hgroup>

	<nav id="access" role="navigation">
		<ul class="menu">
			<li class="menu-item current_page_item"><s:a href="%{index}">Inicio</s:a></li>
			<s:iterator value="categorias">

				<li class="menu-item"><s:url action="topicAction.action"
						id="url">
						<s:param name="id" value="%{id}" />
					</s:url> <s:a href="%{url}">
						<s:property value="nombre" />
					</s:a></li>
			</s:iterator>
		</ul>
	</nav>
</header>
</html>