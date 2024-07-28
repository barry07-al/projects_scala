# Projets Scala

### Nom et prénom
BARRY Alpha Oumar

### Particules

Pour le projet simulation de particules, j'ai utilisé **750 particules au lieu de 1500** pour des questions de performances.

### Wator

Ce projet n'est pas achevé

### Predateur proie

Pour ce projet la proie est répresenté par un cercle bleu et le predateur par un cercle rouge.

L'algorithme de Djisktra est utilisé pour le deplacement du predateur à la poursuite de la proie.

## Éxécution

Pour récuperer ces projet faudra le cloner en éxécutant une de ces commandes :

**En SSH**
```
git clone git@github.com:barry07-al/projects_scala.git
```

**En HTTPS**
```
git clone https://github.com/barry07-al/projects_scala.git
```

Pour l'éxécuter il faudra ouvrir chaque projet dans vscode (ou autre éditeur) et ensuite le compiler avec le **plugin metals** et ensuite éxécuter les commandes **run** au dessus de la classe Main de chaque projet. Ou encore sur vscode vous pouvez les éxécuter en debug en adaptant ce code (changer les paramètres **buildTarget** par le nom du repertoire du projet) pour chaque projet dans le fichier **.vscode/launch.json** et ensuite éxécuter les projets en debug en cliquant sur **F5**.

**Pour Particules**
```
{
    "version": "0.2.0",
    "configurations": [
      {
        "type": "scala",
        "request": "launch",
        "name": "Debug project",
        "mainClass": "app.Main",
        "buildTarget": "projet_particules",
        "args": [],
        "jvmOptions": [],
        "env": {}
      },
    ]
}
```
