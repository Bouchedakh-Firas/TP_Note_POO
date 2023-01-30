_**Web:**
Spring web permet de construire des applications Web en Java. il utilise
le principe du Modèle/Vue/Contrôleur (MVC).De plus il integre les RESTful et un serveur 
integré pour facilité le developement web

**JPA:** 
c'est un module qui nous permet de manipuler les differente base de données en utilisant 
des drivers convenable

**Hibernate**:
Hibernate mappe des classes Java à des tables de base de données et fournit également 
des fonctions pour la récupération des données
**H2**:
H2 est une base de données local qui utilise la memoire local pour srocker les informations 

**DevTools**: 
differente outils de dev et gestion de configuration
**Thymeleaf**:
est un moteur de template qui permet d'integrer des composent et l'hérité.

**ETAPE 13:**
1- la partie du code qui nous permet de paramétré l'url d'appel /greeting c'est getmapping

2- la partie du  code pour afficher le fichier HTML c'est Thymeleaf et la commande return "template_name"
puisque Thymeleaf est un moteur de template

3-on envoie le nom ou le paramètre a utilisé à l'affichage avec le passage de paramètres par URL
ou la fonction extrait le contenu de paramètre attendu et l'utilise dans son traitement.

**ETAPE 17**
l'application spring boot fait un scan des nouvelles entités contenant l'annotation @Entity.
Cette entité est migrée vers la base de données.
De plus les differentes annotaions des variables nous permet de déterminer la clé primaire
les types de variable et même les contraintes a respecter.

**ETAPE 20**

oui le contenu de la requête select affiche tous les informations insérer.
la seule différence que le current timestamp est appliqué au moment d'insertion

**ETAPE 22**

Autowired dans Spring Boot est une annotation qui permet à Spring de rechercher automatiquement une dépendance nécessaire pour un bean donné.
Il peut également être utilisé pour injecter des instances de beans dans des propriétés de classe ou des constructeurs.

**ETAPE 30**

on peut ajouter boostrap à travers un cdn ou bien statiquement en mettant le code dans static est l'appeler à l'aide de cette commande<link th:href = "@{/css/bootstrap.min (3).css}" rel="stylesheet">  


_**PARTIE 2**_

**ETAPE 6**

**• Faut-il une clé API pour appeler MeteoConcept ?**
Oui, une clé API est nécessaire pour appeler MeteoConcept.
le parametre de tocken d'authentification est passer en parametre de url de l'API
**• Quelle URL appeler ?**
L'URL d'appel dépend de l'opération souhaitée avec MeteoConcept API.
par exemple pour savoir le meteo d'une region c'est :
https://api.meteo-concept.com/api/location/cities?token=MON_TOKEN&search=Rennes

**• Quelle méthode HTTP utiliser ?**
la methode HTTP utiliser les GET

**• Comment passer les paramètres d'appels ?**
Les paramètres d'appels peuvent être passés soit dans l'URL
(latitude et langitude dans notre cas), soit dans 
le corps de la requête (comme le header pour 
specifier le type de reponse XML ou JSON). 

**• Où est l'information dont j'ai besoin dans la réponse :**
Les information dans la réponse se trouve dans le BODY du json
récupérer

**• Pour afficher la température du lieu visé par les coordonnées GPS :**
La temperature du lieu visé c'est le parametre tmax tmin dans la reponse JSON

**• Pour afficher la prévision de météo du lieu visé par les coordonnées GPS :**
c'est le "weather" au sein du reponse JSON recu

**ETAPE 7**


