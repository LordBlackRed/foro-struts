<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
<title>Welcome</title>
</head>

<body>
	<h2>
		Howdy,
		<s:property value="username" />
		...!
	</h2>

	<table>
		<s:iterator value="categorias">
			<tr>
				<td><s:url action="topicAction.action" id="url">
						<s:param name="id" value="%{id}" />
					</s:url> <s:a href="%{url}">
						<s:property value="nombre" />
					</s:a></td>
			</tr>
		</s:iterator>
	</table>
</body>
</html>
