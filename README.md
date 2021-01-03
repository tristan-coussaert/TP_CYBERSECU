# Pour lancer le projet

Pour créer l'image, lancer la commande :
docker build -t tpcybersecu .

Pour lancer le conteneur, lancer la commande :
docker run -d -p 8080:8080 tpcybersecu

Ce projet est une API d'un réseau social où on peut notamment créer,modifier,supprimer des utilisateurs et des messages. Ils sont stockés dans une bdd interne h2.
