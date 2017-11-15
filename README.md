# WebServicesMiniProject for University Jean-Monnet And Telecom Saint-Etienne

[![N|Solid](https://github.com/jbrat/SocialNetworkUJM-SpringReact/blob/master/src/main/resources/static/images/logo_ujm.png?raw=true)](https://www.univ-st-etienne.fr/fr/index.html)

[![N|Solid](http://rubenjgarcia.es/wp-content/uploads/2016/09/springboot.png)](https://projects.spring.io/spring-boot/)

Ce mini projet de l'UE du Master 2 Données et Systèmes Connectés en Web Services ("Applications Distribuees") a pour but de creer avec Spring, des graphiques à l'aide de la librairies amcharts.com, de manipuler les differentes tables de la base de donnee et de creer des comptes username/password a l'aide de Spring Security.

## Import the Database

Tout d'abord, il faut importer la database "humanresources.sql" dans votre base de donnee. Ce fichier se situe dans src/main/resources.

Ensuite, vous devez modifier le mot de passe de la base de donnee qui se trouve dans "application.properties." (et éventuellement, le user: par défaut, il est mis a "root").

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

Il existe différentes fonctionnalités pour ce projet : 

* L'Admin peut modifier le role des utilisateurs de son choix. (Sauf lui-même). "Profil dans la barre du menu".
* Chaque utilisateur peut modifier son password. "Your Profil dans la barre du menu".
* Chaque utilisateur peut supprimer son compte (définitivement) avec une pop-up de confirmation. "Delete Account dans la barre du menu".
* Chaque utilisateur peut se deconnecter a tout moment. "Logout dans la barre du menu".
* Les differents accés/role sités dans la partie "Users and Roles in the Database" a été implémenter. "Country, ..., Job dans la barre du menu".
* Le graphique "Graph per decile" dans la barre du menu seulement visible par l'admin.
* Le graphique "Graph" dans la barre du menu seulement visible par l'admin.
* L'acces a la description du site ce fait via "Description dans la barre du menu".
* L'acces a une eventuel aide sur le site ce fait via "Help dans la barre du menu".

### En tant que user non connecte

Il existe deux fonctionnalites : 

* L'utilisateur peut se connecter via "Sign in dans la barre de menu."
* L'utilisateur peut s'enregistrer un nouveau compte via "Sign out dans la barre de menu." Lors de la creation et de la validation de celui-ci, il y a un autologin qui se cree et l'utilisateur est connecte sans avoir a retaper les informations du nouveau compte qu'il vient tout juste de crée.

## Validation de formulaire 

Dans le projet nous avons mis en place des validations de formulaires, notamment : 

* Pour le "Sign in" si le username et password ne correspond pas aux données, on affiche un message en rouge sur la page.
* Pour le "Sign Out", si le username n'est pas compris entre 6 et 32 caracteres, on affiche un message d'erreur en rouge sur la page.
* Pour le "Sign Out", on verifie si les deux passwords correspondent aux mêmes, sinon on affiche un message d'erreur en rouge sur la page.
* Pour modifier le password, "Your profil and on Update button", on verifie si les deux mots de passes correspondent l'un à l'autre, sinon on affiche un message d'erreur en rouge sur la page.
