# Projet de Simulation de Jardinage en Java

Ce projet est une application de simulation de jardinage développée en Java, mettant en œuvre une interface graphique interactive avec Swing et des concepts de programmation concurrente.

## Description

L'application simule un jeu où le joueur peut gérer un jardin virtuel. Il est possible de planter différentes sortes de fleurs, de s'en occuper, de les voir grandir en temps réel, de les récolter et de les vendre pour réaliser des profits. Un jardinier peut également être engagé pour automatiser certaines tâches.

## Fonctionnalités

*   **Gestion du Jardin :** Planter, arroser, désherber et récolter plusieurs types de fleurs (Rose, Tulipe, Muguet, etc.).
*   **Croissance en Temps Réel :** Les plantes grandissent visiblement avec le temps grâce à des barres de progression.
*   **Boutique :** Achat de graines et vente des fleurs récoltées ou des bouquets composés.
*   **Jardinier Automatisé :** Possibilité d'engager un jardinier qui se déplace et effectue des tâches de manière autonome sur la carte.
*   **Interface Interactive :** Tout le jeu est contrôlé via une interface graphique simple et intuitive.

## Concepts Techniques

### Architecture Modèle-Vue-Contrôleur (MVC)

Le projet est structuré selon le patron de conception MVC pour séparer les responsabilités :
*   **Modèle (`src/modele`) :** Contient toute la logique du jeu et l'état des données (ex: `Fleur`, `Jardinier`, `Carte`, `Boutique`). Il est indépendant de l'interface utilisateur.
*   **Vue (`src/vue`) :** Responsable de l'affichage et de la présentation des données à l'utilisateur (ex: `Fenetre`, `VueCarte`, `PanneauBoutique`). Elle observe le modèle pour se mettre à jour.
*   **Contrôleur (`src/controleur`) :** Gère les entrées de l'utilisateur (clics de souris, actions sur les boutons) et met à jour le modèle en conséquence (ex: `ListenerPlanter`, `ListenerDeplacer`).

### Programmation Concurrente

La concurrence est un aspect clé de ce projet pour assurer une expérience utilisateur fluide et simuler des actions parallèles :
*   **Croissance des plantes :** Des `CountDownTimer` sont utilisés pour gérer la croissance des fleurs et autres événements temporels sans bloquer l'interface utilisateur.
*   **Déplacement du Jardinier :** Le déplacement autonome du jardinier est géré dans un `Thread` séparé (`ThreadDeplacement`), ce qui permet à l'animation de se dérouler en parallèle des autres actions du joueur et de l'interface.

## Structure du Projet

```
.
└── src/
    ├── controleur/  # Les listeners pour les actions utilisateur
    ├── images/      # Les ressources graphiques du jeu
    ├── main/        # Le point d'entrée de l'application (Main.java)
    ├── modele/      # Les classes de la logique du jeu
    └── vue/         # Les classes de l'interface graphique (Swing)
```

## Comment Lancer le Projet

Le projet est configuré pour être utilisé avec l'IDE IntelliJ IDEA.

1.  Clonez ce dépôt sur votre machine locale.
2.  Ouvrez le projet avec IntelliJ IDEA.
3.  Assurez-vous d'avoir un SDK Java (version 11 ou supérieure) configuré pour le projet.
4.  Localisez et exécutez la méthode `main` dans le fichier `src/main/Main.java`.

