<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>Consultation dossier agent - Page d'erreur</title>

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

.btValider {
	display: block;
	margin: 0px 0px 5px 30px;
	padding: 8px 35px 10px 0px; 
	background-image :
	url("img/portail/btValider.gif"); background-repeat : no-repeat;
	background-position : right; text-align : right; color : #669900;
	font-size : 0.9em; font-weight : bold; text-decoration : none;
	float: right;
	margin: 0px 0px 5px 30px;
	padding: 8px 35px 10px 0px;
	background-image: url("img/portail/btSuivant.gif");
	background-repeat: no-repeat;
	background-position: right;
	text-align: right;
	color: #669900;
	font-size: 0.9em;
	font-weight: bold;
	text-decoration: none;
	padding: 8px 35px 10px 0px;
	background-image: url("img/portail/btValider.gif");
	background-repeat: no-repeat;
	background-position: right;
	text-align: right;
	font-size: 0.9em;
	font-weight: bold;
	text-decoration: none;
	background-image: url("img/portail/btValider.gif");
	background-repeat: no-repeat;
	background-position: right;
	text-align: right;
	font-size: 0.9em;
	font-weight: bold;
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
			Votre session a expiré
		</div>

		<table border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td class="tabline1"
					style="width: 900px; height: 50px; font-size: 0, 9em;">
					Pour des raisons de sécurité, votre session a expiré.
					<br />
					Vous pouvez retourner au portail d'accueil SIRHEN en suivant le
					lien ci-dessous.
					<br>
				</td>
			</tr>
		</table>
	</div>
</div>
<a title="Retour vers le portail"
	href="<%=basePath%>ihmr/accueil?sessionExpiree=true"
	style="margin-right: 14px;" class="btValider">Retour vers le
	portail</a>
			</div>
		</div>
	</body>
</html>
