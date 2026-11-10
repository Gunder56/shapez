# Guide Git et GitHub pour le projet

Ce guide explique comment utiliser le dépôt dans VS Code.

## 1. Première installation

Installer :

- [Git](https://git-scm.com/downloads)
- [VS Code](https://code.visualstudio.com/)
- l'extension **Extension Pack for Java** dans VS Code

Dans VS Code, ouvrir `Ctrl+Shift+P`, choisir **Git: Clone**, puis utiliser :

```text
https://github.com/Gunder56/shapez.git
```

Choisir un dossier local, puis ouvrir le projet cloné.

## 2. Avant de commencer à travailler

Ouvrir le terminal de VS Code avec **Terminal > New Terminal**, puis exécuter :

```powershell
git checkout main
git pull origin main
```

Cela récupère la version la plus récente du projet.

## 3. Créer une branche de travail

Ne pas travailler directement sur `main`. Créer une branche personnelle ou liée à la tâche :

```powershell
git checkout -b feature/nom-de-la-tache
```

Exemples :

```text
feature/classe-forme
feature/tests-convoyeur
fix/destination-convoyeur
```

## 4. Enregistrer son travail

Vérifier les fichiers modifiés :

```powershell
git status
git diff
```

Ajouter les fichiers et créer un commit :

```powershell
git add .
git commit -m "Ajouter la classe Forme"
```

Les messages doivent être courts et décrire une seule modification.

## 5. Envoyer sa branche sur GitHub

```powershell
git push -u origin feature/nom-de-la-tache
```

Ensuite, ouvrir GitHub et créer une **Pull Request** vers `main`. Un collègue doit relire la modification avant sa fusion.

## 6. Mettre sa branche à jour

Avant de continuer, récupérer les changements récents de `main` :

```powershell
git checkout main
git pull origin main
git checkout feature/nom-de-la-tache
git merge main
```

En cas de conflit, corriger les fichiers signalés dans VS Code, puis :

```powershell
git add .
git commit
git push
```

## 7. Règles importantes

- Ne jamais faire de `git push --force` sur `main`.
- Ne pas commiter de mots de passe, clés ou fichiers personnels.
- Faire des commits petits et cohérents.
- Toujours faire `git pull` avant de commencer.
- Utiliser une Pull Request pour intégrer une branche dans `main`.
