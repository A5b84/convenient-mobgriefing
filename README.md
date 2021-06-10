# Convenient mobGriefing

A [Fabric](https://fabricmc.net) mod that gives more control over the `mobGriefing` game rule by splitting it into four:
- `mobGriefing` for most mobs that destroy your world
- `lenientGriefing` for passive mobs and things that aren't really annoying
- `witherGriefing` for the Wither
- `dragonGriefing` for the Ender Dragon

Requires [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api). New gamerules are enabled by default.

A changelog is available [here](CHANGELOG.md).

`mobGriefing` controls:
- Creepers and Ghasts destruction
- Endermen taking and placing blocks
- Silverfish infesting blocks
- Ravagers destroying crops and leaves

`lenientGriefing` controls:
- Villagers harvesting crops
- Piglin bartering
- Sheeps eating grass
- Snow Golem placing snow
- Rabbits eating carrot crops
- Foxes eating Sweet Berries
- non-player entities:
  - picking up dropped items
  - turning farmland into dirt
  - placing wither roses when killed by a Wither
    - Wither Roses are dropped as items when this rule is disabled (vanilla behavior)
  - breaking turtle eggs
    - This also includes Zombies and Zombified Piglins pathfinding towards them
  - litting campfires
- Evokers wololo-ing Sheeps

`witherGriefing` allows the Wither to destroy stuff.

`dragonGriefing` allows the Ender Dragon to stuff.
