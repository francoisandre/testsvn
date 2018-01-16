Etapes à réaliser lors du démarage de votre projet:

1) Exécuter la commande maven "ECLIPSE generate-myeclipse-project-files" sur votre projet pour générer les fichiers de configuration de My Eclipse.
2) Faites un refresh sur votre projet.

A ce stade, votre projet doit avoir la bonne arborescence et les dépendances Maven.
En revanche, votre projet ne compile pas car il n'a pas la dépendance sur votre client généré par votre MAS.

3) Renseigner la dépendance de votre mas client dans le pom.xml.
4) Corriger les imports dans les classes Java qui ne compilent pas.
5) Modifier l'attribut "serviceClass" dans le fichier src/main/resources/spring/client-context.xml par l'interface générée dans votre mas client.

Désormais, vous pouvez lancer les tests unitaires et déployer votre projet sous JBoss.

Ce fichier doit etre supprimé lorsque les etapes ci-dessus ont été réalisées.
