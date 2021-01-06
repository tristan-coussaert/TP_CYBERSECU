# Pour lancer le projet

Pour créer l'image, lancer la commande :
docker build -t tpcybersecu .

Pour lancer le conteneur, lancer la commande :
docker run -d -p 8080:8080 tpcybersecu

Ce projet est une API d'un réseau social où on peut notamment créer,modifier,supprimer des utilisateurs et des messages. Ils sont stockés dans une bdd interne h2.

# Ce que fait le projet

## Utilisateurs, Messages et Amis

Il est possible d'effectuer les actions suivantes :

Afficher les utilisateurs, messages et amis existant en base via les routes /user, /post et /friend grâce à la méthode GET.

Afficher un utilisateur, message, ami existant en base en renseignant son id via les routes /user/{id}, /post/{id}, /friend/{id} grâce à la méthode GET.

Créer un compte en envoyant à la route /user/sign-up un .json de cette forme en body :
{
    "id": 1,
    "email": "gautier.coudur@lacatholille.fr",
    "password": "goat",
    "firstName": "gautier",
    "lastName": "COUDUR",
    "dob": "14091999",
    "sex": 1,
    "phone": "0627849023"
}

Créer un message en envoyant à la route /post/add un .json de cette forme en body :
{
  "id": 1,
  "name": "Titre du message",
  "content": "Contenu du message
}

Modifier un utilisateur existant en base en renseignant son id via la route /user/{id} et envoyant les paramètres suivants dans l'url grâce à la méthode PUT : nom,prenom,email,numero

Modifier un message existant en base en renseignant son id via la route /post/{id} et envoyant les paramètres suivants dans l'url grâce à la méthode PUT : name,content

Supprimer un utilisateur, message, ami existant en base en renseignant son id via les routes /user/{id}, /post/{id}, /friend/{id} grâce à la méthode DELETE.

Rechercher un utilisateur existant en base en renseignant son email via la route /user/search/{email} grâce à la méthode GET. 

Rechercher un message existant en base en renseignant son titre via la route /post/search/{name} grâce à la méthode GET.

Rechercher un ami existant en base en renseignant son nom via la route /friend/search/{name} grâce à la méthode GET.

# Objectif de securité
Confidentialité : 3/5. Les mots de passe sont hachés et stockés dans une base donnes interne h2, cependant le mot de passe de la base peut pour l'instant être facilement hacké. 

Intégrité : 2/5. La sécurité étant pour le moment facile à briser, on ne peut pas s'assurer que les données seront celles que l'on attend et qu'elles seront exacts et complètes.

Disponibilité : 4/5. L'application utlisant Docker, dès que le container est lancé, l'application se lance sur le localhost. Cependant, elle n'est déployée qu'en local donc cela peut encore être ameliorer.

Traçabilité : 1/5. L'application ne cherche pas à respecter les exigences légales tel que les RGPD (avec un bandeau de cookies). Cependant, aucune information de l'utilisateur n'a pour objectif d'être retenu. 
