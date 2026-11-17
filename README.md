# SHAPEZ

Projet Java réalisé dans le cadre du TP de conception logicielle. Il modélise les
éléments principaux d'un système de convoyage de formes sur une grille.

## Fonctionnalités

Le projet contient actuellement les éléments suivants :

- création d'une `Forme` identifiée par un entier ;
- création d'une `Cellule` positionnée par ses coordonnées `(x, y)` ;
- vérification de l'état libre ou occupé d'une cellule ;
- association d'une machine à une cellule ;
- orientation d'une cellule selon les points cardinaux `NORD`, `SUD`, `EST` et
  `OUEST` ;
- création d'un `Tapis` avec une entrée et une sortie orientées ;
- stockage temporaire et déplacement de formes dans la hiérarchie des
  convoyeurs ;
- tests de construction pour les formes, cellules, cellules orientées et tapis.

## Spécifications

Le modèle objet est organisé autour des classes suivantes :

- `Machine` : classe mère des machines installées sur la grille ;
- `Convoyeur` : classe abstraite représentant le déplacement et le stockage
  d'une forme ;
- `Tapis` : convoyeur installé sur une cellule, avec une direction d'entrée et
  une direction de sortie ;
- `Cellule` : emplacement de la grille contenant ses coordonnées et, le cas
  échéant, une machine ;
- `CelluleOriente` : couple formé par une cellule et une direction ;
- `Forme` : objet transporté par les convoyeurs ;
- `Cardinal` : énumération des quatre directions possibles.

Un tapis ne peut être créé que sur une cellule libre. Sa création associe
automatiquement le tapis à cette cellule. Une forme peut être stockée, chargée
sur un convoyeur, puis déplacée vers la machine située à sa sortie.


## Arborescence

```text
shapez/
├── src/
│   ├── Cardinal.java
│   ├── Cellule.java
│   ├── CelluleOriente.java
│   ├── Convoyeur.java
│   ├── Forme.java
│   ├── Machine.java
│   └── Tapis.java
├── tests/
│   ├── TestCellule.java
│   ├── TestCelluleOrientee.java
│   ├── TestForme.java
│   └── TestTapis.java
├── main.java
├── Partie 3.pdf
├── GUIDE_GIT_GITHUB.md
└── README.md
```

## Auteurs / date de dernière modification

- Ghiles Seddiki
- Vincent Brelier
- Gaby Nimuzima
- Marc-Eloi de Besombes
- Zyad Zougaghi Kassimi-Alaoui

Dernière mise à jour du README : 17 novembre 2026.

## Guide d'utilisation

### Prérequis

- Java Development Kit (JDK) ;
- Visual Studio Code ;
- extension **Extension Pack for Java** recommandée dans VS Code.

### Ouverture du projet

Ouvrir le dossier `shapez` dans VS Code. Les sources se trouvent dans `src/`
et les tests exécutables dans `tests/`.

### Compilation

Depuis le dossier `shapez`, la compilation peut être lancée avec :

```powershell
New-Item -ItemType Directory -Force out
javac -d out src\*.java tests\*.java
```

La compilation complète doit être finalisée après l'ajout des accesseurs de
forme utilisés par `Convoyeur` et la mise en cohérence des déclarations de
packages des tests.

### Exécution des tests

Après compilation, les tests peuvent être exécutés individuellement :

```powershell
java -cp out tests.TestForme
java -cp out tests.TestCellule
java -cp out tests.TestCelluleOrientee
java -cp out tests.TestTapis
```

Chaque test affiche un message de réussite ou lève une `AssertionError` en cas
de comportement incorrect.

## Licence

Aucune licence open source n'est actuellement déclarée pour ce projet.