**Projet Programmation Mobile (HAI811I) :  Application pour la Gestion des Intérims**  

**Présentation du projet** 

Ce projet consiste à développer une application mobile pour la gestion des offres et candidatures pour le travail en intérim.  ![](Aspose.Words.f5f13b49-1347-4a34-894b-f092a053e14a.001.png)

![](Aspose.Words.f5f13b49-1347-4a34-894b-f092a053e14a.002.png)![](Aspose.Words.f5f13b49-1347-4a34-894b-f092a053e14a.003.png). 

Cette application gère les utilisateurs suivants :  

1) **Anonyme  :**  tous  les  utilisateurs  qui  installent  l’application  peuvent  bénéficier  des services de base de l’application. Ce sont les utilisateurs anonymes.  
1) **Candidat inscrit/connecté :** Ce sont les utilisateurs qui se sont inscrits pour bénéficier des services de l’application destinés aux candidats aux offres d’intérim.  
1) **Employeur :** Ce sont les utilisateurs qui se sont inscrits pour bénéficier des services de l’application destinés aux employeurs qui proposent des offres d’intérim.  
1) **Agence d’intérim :** Ce sont les utilisateurs qui se sont inscrits pour bénéficier des services de l’application destinés aux agences d’intérim.  
1) **Gestionnaire :** Ce sont les utilisateurs qui se sont inscrits pour bénéficier des services de l’application destinés aux gestionnaires. 
1) **Super-Gestionnaire  :**  Ce  sont  des  gestionnaires  qui  bénéficient  des  services supplémentaires. 

**Services offerts aux utilisateurs anonymes :  ![](Aspose.Words.f5f13b49-1347-4a34-894b-f092a053e14a.004.png)**

- Affichage d’annonces/offres :  
- Pour la première utilisation, l’application demande à l’utilisateur d’accepter la localisation en lui expliquant que la raison est pour afficher des annonces autour de sa localisation. 
  - Si  l’utilisateur  accepte,  enregistrer  le  lieu  dans  les  préférences  de l’utilisateur et afficher les annonces en lien avec cette localisation.  
  - Si  l’utilisateur  refuse,  afficher  des  annonces  sélectionnées  par  un algorithme défini. Cet algorithme peut afficher les annonces suivant des critères internes tels que celles plus récentes, les recherchées par les candidats ou d’autres critères.  
- Pour les utilisations suivantes (après la première fois) : utiliser les informations déjà enregistrées lors des précédentes utilisations pour afficher des annonces pertinentes.  Parmi les informations enregistrées : les recherches précédentes, le lieu enregistré, etc.  
- Pour chaque annonce d’offre affiché, quelque que soit l’utilisateur (anonyme ou connecté), un certain nombre de possibilité sont offertes aux utilisateurs :  
- Lien vers la source de l’offre si ce lien existe : URL agence ou employeur  
- Candidater  
- Traduire  
- Enregistrer  
- Chercher  des  annonces  similaires  :  possibilité  d’utiliser  des  cases  à cocher pour les options suivantes :  
- Même employeur  
- Même période  
- Même métier  
- Même lieu 
- Même durée  
- Etc.  
- Partager  
- Sur les réseaux sociaux  
- Par SMS 
- Signaler à des amis dans l’application  
- Chercher les annonces/offres : Deux modes de recherche sont disponibles : 
- Recherche vocale : permet à l’utilisateur de chercher des annonces de manière vocale.  
- Recherche textuelle : deux types de recherche textuelle sont disponibles :  
- Recherche rapide : utiliser une barre de recherche pour écrire le texte à utiliser pour chercher des annonces.  
- Recherche avancée : Il s’agit de l’utilisation d’un formulaire pour saisir les critères que l’application propose comme filtre tels que le métier cible, la zone géographique, la période, etc.  
- S’inscrire/s’authentifier :  Quand un utilisateur n’est pas déjà connecté, il peut se connecter selon deux possibilités :  
- Une interface de connexion est disponible dans l’interface IHM (directement accessible et via un menu). Les utilisateurs non encore connectés peuvent se loguer ou s’inscrire. Des interfaces d’authentification (s’il est déjà inscrit) et d’inscription sont proposées. Pour l’IHM d’inscription, les choix disponibles sont : vous êtes à la recherche d’intérim, employer ou agences d’intérim.  
- Quand  un  utilisateur  anonyme  veut  candidater  pour  une  offre  donnée, l’application lui demande de s’authentifier (s’il est déjà inscrit) ou de s’inscrire. Il est à noter que pour chaque annonce/offre affichée, un bouton est disponible pour candidater à cette offre.  

Les informations à renseigner pour s’inscrire en tant que chercheur d’emploi sont  les  suivantes  :  Nom  (obligatoire),  prénom  (obligatoire),  nationalité (optionnel), date de naissance (optionnel), numéro de téléphone (optionnel), adresse  mail  (optionnel),  ville  (optionnel),  CV  (optionnel),  commentaires (optionnel). Il est à noter qu’au moins un numéro de téléphone ou une adresse mail doit être renseigné.  

L’application doit envoyer un code à l’utilisateur (sur son numéro de téléphone ou sur son adresse mail) qui sera utilisé par l’utilisateur pour confirmer son inscription sur une interface de validation.   

**Services offerts aux utilisateurs inscrits comme chercheurs d’emplois d’intérim  ![](Aspose.Words.f5f13b49-1347-4a34-894b-f092a053e14a.005.png)**

**Ces utilisateurs bénéficient des services suivants, en plus de tous les services offerts aux utilisateurs anonymes (sauf l’inscription) :**  

- S’enregistrer pour recevoir des notifications d’offres :  
- Il s’agit de la possibilité de s’enregistrer pour que l’application envoie à l’utilisateur des offres qui correspondent à ses critères de recherche. L’utilisateur doit renseigner certains de ces critères tels que le métier, le lieu, la période, l’employeur, etc. Tous ces critères de sélection sont optionnels. L’utilisateur doit renseigner au moins un de ces critères.  
- Candidater :  
- Deux modes de candidature sont disponibles pour une offre donnée.  
- Candidature pour une offre. Pour candidater, un utilisateur inscrit en tant que chercheurs d’emplois d’intérim** renseigne, dans un formulaire, son nom, son prénom, sa date de naissance, sa nationalité, son CV, une lettre de motivation (optionnelle). Toutes les informations déjà renseignées pendant  l’inscription  sont  automatiquement  réutilisées  dans  ce formulaire. Si nécessaire, l’utilisateur peut changer toutes ces valeurs.   Il est  à  noter  que  l’utilisateur  peut  candidater  à  une  seule  offre  ou candidater en même temps à plusieurs offres sélectionnées. Dans le deuxième cas, l’application doit lui afficher un message d’alerte pour lui signaler qu’il va candidater à plusieurs offres en même temps et qu’il est préférable qu’il adapte son dossier de candidature en fonction de l’offre. L’utilisateur peut choisir de continuer ou d’annuler.    
- Candidature  spontanée.  Il  s’agit  d’envoyer  une  candidature  sans l’associer à une offre spécifique. Le candidat peut filtrer les cibles de ses candidatures selon un ensemble de critères optionnels tels que : les métiers cibles, les employeurs cibles, la période désirée, etc.  
- L’application offre à l’utilisateur la possibilité de réutiliser le dossier d’une de ses candidatures précédentes pour une nouvelle candidature. 
- Consulter les notifications : réponses et propositions  
- Consulter les réponses aux candidatures. Il s’agit de consulter les réponses reçues par l’utilisateur à ses candidatures.  
- Consulter les propositions d’offres. Il s’agit de consulter les notifications d’offres proposées (filtrées) par l’application qui correspondent aux centres d’intérêt de l’utilisateur. L’utilisateur peut ainsi candidater pour ces offres (voir Candidature). L’utilisateurs peut agir sur ces candidatures : mettre en favoris, supprimer, classer en une catégorie donnée, etc. Il est à noter que les propositions affichées par l’application sont générées par un algorithme qui prend en considération la date actuelle, la date de la proposition (ne pas afficher des offres proposées avant date actuelle – N (un nombre de jour à fixer), la période de validité de la proposition (ne pas afficher des propositions dont les dates de validité sont dépassées), etc. 
- Consulter et gérer mes candidatures : il s’agit de pouvoir gérer toutes les candidatures  
- Gestion et suivi des candidatures encours  
- Gestion candidatures en cours et sans réponse  
- Afficher toutes les candidatures  
- Filtrer les candidatures en fonction d’un certain nombre de critères : dates, métier, lieu, employeur, etc.   
- Pour chaque candidature affichée, l’application offre un certain 

nombre de services :  

- Modifier candidature  
- Supprimer candidature  
- Contacter employeur ou agence d’intérim destinataire de la candidature.  
- Itinéraire  
- Déclarer un problème  
- Gestion des candidatures en cours acceptées  
  - Accepter**/**refuser/ contacter employeur ou agence d’intérim destinataire de la candidature 
  - Déclarer un problème 
  - Montrer itinéraire  
  - Ajouter à l’agenda  
- Gestion des candidatures en cours non acceptées 
- Afficher les candidatures et leurs réponses  
- Filtrer les candidatures  
- Consulter des candidatures passées 
  - Toutes les candidatures  
  - Filtrer  
- Consulter des candidatures potentielles : Il s’agit d’afficher les offres encore valides enregistrées par l’utilisateur ou ajoutées aux favoris.   
- Gestion de mes emplois 
- Gestion des emplois en cours et à venir  
  - Consulter et gérer mon agenda d’emplois  
    - Affichage  
    - Définir des alertes/notifications programmées 
  - Afficher tous les emplois passés  
- Filtrer mes emplois selon certains critères : dates, lieu, employeur, métier, etc.   
  - Pour chaque emploi affiché, l’application permet de :  
- Demander/imprimer une attestation 
- Faire une candidature spontanée à l’employeur (si l’employeur accepte les candidatures spontanées).    
- Aide à la candidature :  
- Afficher/réutiliser des modèles de cv disponibles  
- Afficher des lettres motivation disponibles  
- Aide à la rédaction de CV  
- Aide à la rédaction de lettre motivation  
- Consulter des statistiques d’emplois  
- Employabilité en fonction :  
  - Du métier  
  - De la période  
  - De la zone géographique 
  - Etc.  
- Des emplois disponibles  
  - Consulter réglementation par pays 
- Partager une annonce  
  - Partager 
    - Sur les réseaux sociaux  
    - Par SMS 
    - Partager avec une personne ou groupe d’amis dans l’application 
  - Créer  des  groupes  de  partage  :  l’application  permet  à  l’utilisateur inscrit/connecté de créer des groupes de partages (d’amis) et partager avec eux des annonces.  
- Créer un groupe : spécifier son nom  
- Ajouter un ou plusieurs personnes à un groupe. Pour cela, il suffit de donner l’adresse mail de la personne ou son numéro de téléphone. Cette personne fera partie de ce groupe. Si la personne ajoutée a un compte (à l’application Interim), l’application lui envoie une notification contenant les informations de l’offre partagée. Si la personne ajoutée ne possède pas de compte, alors l’application lui envoie un mail ou un SMS. Il est à noter qu’un utilisateur inscrit peut à la possibilité de bloquer la réception des  notifications  de  partage  soit  totalement  ou  issues  de  certains comptes.  
- Gestion des langues : il s’agit d’un service de traduction  
- Traduire le texte d’une offre  

**Services offerts aux utilisateurs  3-Employeur :  ![](Aspose.Words.f5f13b49-1347-4a34-894b-f092a053e14a.004.png)**

- Pour la première utilisation, l’application présente des slides d’explication des services offerts par l’application pour les employeurs.  
- Proposition  d’une  interface  de  connexion  ou  d’inscription  (se  connecter  ou  de s’inscrire).  
- Pour l’inscription :  
- Renseigner les informations suivantes :  
- Nom de l’entreprise (obligatoire) 
- Nom d’un service/département (optionnel) 
- Nom d’un sous service/sous département (optionnel) 
- Numéro nationale de l’entité dépositaire d’annonces 
- Nom personne contact 1 - (optionnel) 
- Nom personne contact 2 - (optionnel) 
- Adresse mail-1  (Obligatoire) 
- Adresse mail -2 (Optionnel) 
- Numéro téléphone 1 (optionnel) 
- Numéro téléphone 2 (optionnel) 
- Adresse (obligatoire)   
- Liens publics de l’employeur  
- Site Web, LinkedIn, Facebook, … 
- L’application envoie à cet utilisateur un mail ou un SMS avec un code de validation que ce dernier soit renseigner pour confirmer sa demande d’inscription.  
- L’application  présente  aux  utilisateurs  les  différents  types d’abonnement :  
- Abonnement ponctuel (pour uniquement une annonce) 
- Abonnement un mois 
- Abonnement un trimestre 
- Abonnement un semestre  
- Abonnement une année 
- Abonnement indéterminé  
- Pour chaque type d’abonnement, l’application présente à l’utilisateur :  
- Le prix  
- Les conditions et les avantages  
- Les conditions pour se désabonner  
- Exemple : pour abonnement indéterminé, préavis un an.  
- L’utilisateur choisi le type d’abonnement et le type de paiement :  
  - Par Carte  
  - Par prélèvement automatique  
- L’application présente l’interface de paiement adéquat.  
- Dès que le paiement effectué, l’utilisateur bénéficie de tous les services de l’application offerts aux employeurs.  
- Gérer les offres  
- Déposer une offre d’emploi. Une offre d’emploi peut être décrite par nom, un métier cible, une description, une période, une rémunération, etc.  
- Consulter et gérer les offres déjà déposées 
- Consulter  
- Modifier  
- Supprimer  
- Créer des catégories d’offres   
- Déplacer une offre dans une catégorie  
- Gérer les candidatures pas encore traitées  
- Consulter les candidatures aux offres déposées. 
- Chercher une candidature  
- Chercher suivant étiquette 
- Chercher suivant offre 
- Chercher suivant date  
- Etc.  
- Accepter une candidature  
- Refuser une candidature 
- Répondre à une candidature  
- Bloquer un candidat  
- Signaler un candidat  
- Créer une nouvelle étiquette   
- Associé une candidature avec une étiquette  
- Gérer les candidatures acceptées  
- Consulter 
- Contacter candidat  
- Par mail 
- Par téléphone  
- Par SMS  
- Etc.  

**Utilisateur4-Agence intérim ![](Aspose.Words.f5f13b49-1347-4a34-894b-f092a053e14a.004.png)**

- Les mêmes services offerts aux employeurs. 
- Déposer des offres. Il s’agit de la possibilité offerte à une agence pour déposer plusieurs offres en même temps. Ces offres ne sont pas saisies mais déposées sous forme de fichiers.  
- Configurer une URI (API endPoint) pour pouvoir récupérer des propositions d’offres en interaction B2B via un web service (Rest, GRPC, etc.) 
- Configurer l’URL du site web de l’agence.  

**Utilisateur5 – Gestionnaire ![](Aspose.Words.f5f13b49-1347-4a34-894b-f092a053e14a.004.png)**

- Consulter les inscriptions des employeurs et des agences. 
- Traiter les inscriptions des employeurs et des agences : Valider, refuser, demande de complément d’information, contacter, etc.  
- Contacter un employeur ou une agence.  
- Gérer les utilisateurs bloqués/signalés 
- Affichage de statistiques. Il s’agit des fonctionnalités BI (Business Intelligence) telles que :  
- Nombre d’annonces déposées par période, par zone géographique, par métier, etc.  
- Nombre de candidatures par période, par zone géographique, par métier, etc.  
- Les métiers les plus demandées par zone géographique, par période, etc.  
- Les métiers les plus proposées par zone géographique, par période, etc. 
- Nombre moyen de candidatures pour une offre : en général, par métier, par zone géographique, etc.  
- Nombre de consultations de l’application par période, par zone géographique, etc.  
- Etc.   

Exigences non fonctionnelles :  

- Structure du projet : MVC 
- Interface IHM : Charte graphique et Matériel design  
- Code : GIT ; CI/CD 
- Web services  
- Base de données  
- Sécurité  

**Taille du groupe**  

1 à 3 étudiants.  ![](Aspose.Words.f5f13b49-1347-4a34-894b-f092a053e14a.004.png)Dates Importantes :  

21 mars 2023 

Maquettes  

Diagrammes d’analyse 

Structure/architecture de l’application  4 avril  

Rapport du travail réalisé  Fonctionnalités ajoutées  Code 

25 avril  

Rapport du travail réalisé  Fonctionnalités ajoutées  Code 

Vidéo de démonstration  9 mai   

Rapport du travail réalisé  Fonctionnalités ajoutées  Code 

Vidéo de démonstration  

28 mai 2023 

Rapport Final Transparents  

Vidéo de démonstration Code   
11
