# Convenient mobGriefing

A [Fabric](https://fabricmc.net) mod that gives more control over the `mobGriefing` game rule by splitting it into four:
- `mobGriefing` for most mobs that destroy your world
- `lenientGriefing` for passive mobs and things that aren't really annoying
- `witherGriefing` for the Wither
- `dragonGriefing` for the Ender Dragon

Requires [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api). New gamerules are enabled by default.

`mobGriefing` allows:
- Creepers and Ghasts to blow stuff up
- Endermen to take and place blocks
- Silverfish to be infest blocks
- Ravagers to destroy crops and leaves

`lenientGriefing` allows:
- Villagers to harvest crops
- bartering with Piglins
- Sheeps to eat grass
- Snow Golem to create snow
- Rabbits to eat carrot crops
- Foxes to eat sweet berries
- non-player entities to:
  - pick up loot
  - turn farmland into dirt
  - place wither roses when killed by a Wither
    - Wither Roses are dropped as items when this rule is disabled (vanilla behavior)
  - break turtle eggs
    - This also includes Zombies and Zombified Piglins pathfinding towards them
  - lit campfires
- Evokers to wololo Sheeps

`witherGriefing` allows the Wither to destroy stuff.

`dragonGriefing` allows the Ender Dragon to stuff.
