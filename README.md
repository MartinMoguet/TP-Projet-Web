Pour lancer le projet, il faut d'abord se placer dans la lib de hsqldb présent dans le projet puis lancer la bdd avec la commande :
java -cp hsqldb.jar org.hsqldb.server.Server  --database.0 file:mydb --dbname.0 classic

Ensuite, il faut run ProjetSpringBootApplication puis run Index.html présent dans le dossier Jquery.

PS : il peut y avoir des bugs d'affichage pour les carrousels, notamment lors de l'ouverture de l'index.html, il faut refresh une fois la page et tout devrait s'afficher. Si il y a un bug d'affichage, il faut rafraîchir la page. 

Bonne visite.
