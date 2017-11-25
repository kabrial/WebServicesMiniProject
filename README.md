# WebServicesMiniProject for University Jean-Monnet And Telecom Saint-Etienne

[![N|Solid](https://github.com/jbrat/SocialNetworkUJM-SpringReact/blob/master/src/main/resources/static/images/logo_ujm.png?raw=true)](https://www.univ-st-etienne.fr/fr/index.html)

[![N|Solid](http://rubenjgarcia.es/wp-content/uploads/2016/09/springboot.png)](https://projects.spring.io/spring-boot/)

Ce mini projet de l'UE du Master 2 Données et Systèmes Connectés en Web Services ("Applications Distribuees") a pour but de creer avec Spring, des graphiques à l'aide de la librairies amcharts.com, de manipuler les differentes tables de la base de donnee et de creer des comptes username/password a l'aide de Spring Security.

## Import the Database

Tout d'abord, il faut importer la database "humanresources.sql" dans votre base de donnee. Ce fichier se situe dans src/main/resources.

Ensuite, vous devez modifier le mot de passe de la base de donnee qui se trouve dans "application.properties." (et éventuellement, le user: par défaut, il est mis a "root"). Une fois, lancer, il faut acceder a "http://localhost:8080/", cela redirige a "http://localhost:8080/login", pour se connecter.

### Spring Security

Dans ce projet nous avons utilisés Spring Security, pour pouvoir utilisé des comptes pour ce site avec le framework Spring.
Les mots de passes sont cryptés pour chaque utilisateur, avec BCryptPasswordEncoder.

### Users and Roles in the Database

Il existe 3 types de roles pour les utilisateurs : 
* ADMIN : The CEO has all the rights. 
* ACCOUNTING : People from accounting and finance have edit access rights for employees and jobs 
and can consult the rest. 
* SALES : People from sales management have only the right to cons
ult data from locations, 
regions and country. 

```
L'utilisateur avec le username:  useradmin et password: useradmin correspond a un compte avec le role d'admin.
L'utilisateur avec le username:  useraccounting et password: useraccounting correspond a un compte avec le role d'accounting.
L'utilisateur avec le username:  usersales et password: useraccounting correspond a un compte avec le role de sales.
```

## Fonctionnalités

### En tant que user connecte

Il existe les fonctionnalités suivantes pour ce projet : 

* L'Admin peut modifier le role des utilisateurs de son choix. (Sauf lui-même). "Profil dans la barre du menu". :warning: Seulement l'admin a accès a cette fonctionnalite.
* Chaque utilisateur peut modifier son password. "Your Profil dans la barre du menu". :warning: Seulement a l'utilisateur courant connecté a accès a cette fonctionnalite.
* Chaque utilisateur peut supprimer son compte (définitivement) avec une pop-up de confirmation. "Delete Account dans la barre du menu". :warning: Seulement a l'utilisateur courant connecté a accès a cette fonctionnalite.
* Chaque utilisateur peut se deconnecter a tout moment. "Logout dans la barre du menu". :warning: Seulement a l'utilisateur courant connecté a accès a cette fonctionnalite.
* Les differents accés/role sités dans la partie "Users and Roles in the Database" a été implémenter. "Country, ..., Job dans la barre du menu" avec l'accès du chemin suivant: "/country, ..., /job". par exemple, cela redirige vers les URL suivantes: "http://localhost:8080/country", "http://localhost:8080/department", "http://localhost:8080/employee", "http://localhost:8080/location", "http://localhost:8080/region", "http://localhost:8080/job" :warning: Les droits d'acces sont ceux definies dans le sujet du projet qui est dans la partie Users and Roles in the Database de ce document.
* Update toutes parties de la base de donnee, il suffit d'avoir un utilisateur ayant les droits qui sont definies dans le sujet du projet, il suffit d'aller au URL, cité ci-dessus, puis d'un clic d'aller sur le bouton Update, de rempir le formulaire et de valider via le boutton. :warning: Les droits d'acces sont ceux definies dans le sujet du projet qui est dans la partie Users and Roles in the Database de ce document.
* Le graphique "Graph per decile" dans la barre du menu seulement visible par l'admin. Par example: "http://localhost:8080/graph/decile", :warning: Seulement l'admin a accès au graphique.
* Le graphique "Graph" dans la barre du menu seulement visible par l'admin. Par example: "http://localhost:8080/graph", , :warning: Seulement l'admin a accès au graphique.
* L'acces a la description du site ce fait via "Description dans la barre du menu".  :white_check_mark: Accessibilité , a tout le monde, même au utilisateur non connecté.
* L'acces a une eventuel aide sur le site ce fait via "Help dans la barre du menu".  :white_check_mark: Accessibilité , a tout le monde, même au utilisateur non connecté.

### En tant que user non connecte

Il existe les fonctionnalites suivantes pour ce projet : 

* L'utilisateur peut se connecter via "Sign in dans la barre de menu."
* L'utilisateur peut s'enregistrer un nouveau compte via "Sign out dans la barre de menu." Lors de la creation et de la validation de celui-ci, il y a un autologin qui se cree et l'utilisateur est connecte sans avoir a retaper les informations du nouveau compte qu'il vient tout juste de crée.
* L'acces a la description du site ce fait via "Description dans la barre du menu".
* L'acces a une eventuel aide sur le site ce fait via "Help dans la barre du menu".

## Validation de formulaire 

Dans le projet nous avons mis en place des validations de formulaires, notamment : 

* Pour le "Sign in dans la barre du menu" si le username et password ne correspond pas aux données, on affiche un message en rouge sur la page. 
* Pour le "Sign Out dans la barre du menu", si le username n'est pas compris entre 6 et 32 caracteres, on affiche un message d'erreur en rouge sur la page.
* Pour le "Sign Out dans la barre du menu", on verifie si les deux passwords correspondent aux mêmes, sinon on affiche un message d'erreur en rouge sur la page.
* Pour modifier le password, "Your profil dans la barre du menu and on Update button", on verifie si les deux mots de passes correspondent l'un à l'autre, sinon on affiche un message d'erreur en rouge sur la page.

## Les pages html

Toutes les pages html se trouvent dans src/main/resources/templates.

## Swagger pour la documentation API Rest

Nous avons rajouter une documentation API Rest qui est disponible "http://localhost:8080/swagger-ui.html" seulement en étant connectés, cependant, seul l'admin peut executer la requete dans la documentation car il y a que l'admin qui a les droits de faire des requetes sur cette URL. (Si on test avec les 2 autres types d'utilisateurs, il aura un message d'erreur: "Access Denied")

## Conclusion & Respect des consignes

Ce projet nous a permis de revoir Spring.
Nous avons respecter toutes les regles definies dans le sujet (nous pouvons modifier chaque partie de la base de donnée), nous avons même rajouter de nouvelles fonctionnalités qui ne sont pas décrites dans le sujet du projet mais qui sont décrites (Voir les parties: Fonctionnalités -> En tant que user connecte et Validation de formulaire.)

## Authors

* **Kevin ABRIAL**

* **Alexis BARTHELEMY**
