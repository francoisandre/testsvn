<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>Portail - Page d'erreur</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">

		<style type="text/css">
body {
	background-color: #FFFFFF;
	color: #3E3E3E;
	font-family: Arial, Helvetica, sans-serif;
	font-size: 0.8em;
	font-weight: normal;
	margin: 0;
	padding: 0;
}

#global {
	width: 960px;
}

.fondPortail {
	background-image: url("img/portail/fond_portail.gif");
	background-repeat: repeat-y;
}

#contenuPortail {
	margin: 10px 0 0;
	padding: 0 0 0 140px;
}

#entete {
	background-image: url("img/portail/entete.gif");
	background-repeat: no-repeat;
	height: 48px;
	margin: 0;
	width: 795px;
}

#bandeauPortail {
	background-image: url("img/portail/bandeau.gif");
	background-repeat: no-repeat;
	height: 431px;
	margin: 0;
	padding: 0;
	position: absolute;
	width: 120px;
}

#form {
	margin: 0;
	padding: 0;
}

#MesConfirmerRouge {
	border-color: #FF3300;
	border-style: solid;
	border-width: 0 0 0 5px;
	margin: 0 0 0 20px;
	padding: 8px 15px 0 0;
}

.titre {
	color: #333333;
	font-size: 0.9em;
	font-weight: bold;
	padding: 5px 0 10px 10px;
}

table,tr,td {
	margin: 0;
	padding: 0;
}

#form .tabline1,.td1 {
	background-color: #D2D2D2;
	border-color: #FFFFFF;
	border-style: solid;
	border-width: 0 0 1px;
	color: #3E3E3E;
	font-size: 0.8em;
	font-weight: normal;
	width: 250px;
}

.btAnnuler {
	background-image: url("img/portail/btAnnuler.gif");
	background-position: right center;
	background-repeat: no-repeat;
	color: #FF3300;
	display: block;
	float: right;
	font-size: 0.9em;
	font-weight: bold;
	margin: 0 0 5px;
	padding: 8px 35px 10px 0;
	text-align: right;
	text-decoration: none;
}

#form td {
	padding: 5px 20px 5px 10px;
}
</style>
	</head>

	<body class="fondPortail">
		<div id="global">
			<!-- BANDEAU -->
			<div id="bandeauPortail">
				&nbsp;
			</div>

			<!-- ZONE CONTENU -->
			<div id="contenuPortail" style="margin: 0">
				<div id="entete">
					&nbsp;
				</div>

				<div id="form">

					<div id="MesConfirmerRouge" style="margin: 0px">
						<div class="titre">
							Accès refusé
						</div>

						<table border="0" cellpadding="0" cellspacing="0">
							<tr>
								<td class="tabline1"
									style="width: 900px; height: 50px; font-size: 0,9em;">
									Vous n'avez pas le droit d'accéder à cette application.
								</td>
							</tr>
						</table>

					</div>
				</div>
				<a title="Quitter" href="#" style="margin-right: 14px;"
					class="btAnnuler">Quitter</a>
				<br>
			</div>
		</div>
	</body>
</html>
