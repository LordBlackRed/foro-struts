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
<meta name="description" content="Your description goes here" />
<meta name="keywords" content="your,keywords,goes,here" />
<meta name="author"
	content="Your Name / Original design by andreasviklund.com" />
<!--[if lt IE 9]>
	<script src="html5.js" type="text/javascript"></script>
	<![endif]-->
<title>Mi Pequeño Foro Virtual</title>
<link rel="stylesheet" type="text/css" media="all"
	href="smokescreen.css" />
</head>

<body>
	<div id="page">
		<s:include value="header.jsp"></s:include>

		<div id="main">
			<div id="primary">
				<div id="content" role="main">
					<article class="post">
						<header class="entry-header">
							<h1 class="entry-title">
								El Foro
								
							</h1>
						</header>
						<div class="entry-content">
							Mensaje Correcto
							<br></br>
							<s:url action="postAction.action" id="urlTopic">
							</s:url>
							<s:a href="%{urlTopic}">
								Ver Mensaje
							</s:a>
						</div>
					</article>

				</div>
			</div>

			<s:include value="rightContent.jsp"></s:include>
		</div>
	</div>
</body>
</html>