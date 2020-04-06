# Fabric : Modèle mod client

## À modifier pour commencer

1. Copier les trucs d'un dossier qui commence par `__` à la racine
    (et supprimer les autres) (modèle client par défaut)
    (à faire hors de VS Code pcq'il remplace au lieu de fusionner)
2. Dépendances (`build.gradle`) et versions (`gradle.properties`)
3. Package
    * Ctrl F + `__package__`
    * Renommer `src/main/java/io/github/a5b84/__package__`
4. ID
    * Ctrl F + `__id__`
    * Renommer `src/main/resources/__id__.mixins.json`
    et `src/main/resources/assets/__id__`
5. Remplacer le `README.md`



## Petits tips

* Faire faire ses trucs à Gradle
    * Enregistrer `build.gradle` puis cliquer sur 'Yes'

* Sources
    * Génération : `./gradlew.bat genSources` (~5 minutes)
    * Recherche d'un fichier : Ctrl P + `#MinecraftClient` (par exemple)

* Compiler
    1. `./gradlew.bat build`
    2. Résultat : `build/libs/[id]-[version].jar`
    3. `./gradlew.bat build; scp ./build/libs/[id]-[version].jar [...]/.minecraft/mods/`
    pour gagner du temps (ou Ctrl Shift B dans VS Code)



### Problèmes / Solutions

* `Failed to get sources`
    1. Ctrl Shift P + `> Java: Clean the language server workspace`
    2. `genSources`
    3. Prier

* Pas d'autocomplete / de résultats dans Ctrl P
    * Actualiser Gradle



## Autres

Très inspiré de [fabric-example-mod](https://github.com/FabricMC/fabric-example-mod)
([CC0](https://github.com/FabricMC/fabric-example-mod/blob/master/LICENSE))
