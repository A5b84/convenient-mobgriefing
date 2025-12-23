# Convenient mobGriefing

A [Fabric](https://fabricmc.net) mod that gives more control over the `mob_griefing` game rule by splitting it into four:
- `mob_griefing` for most mobs that destroy your world
- `lenient_griefing` for passive mobs and things that aren't really annoying
- `wither_griefing` for the Wither
- `dragon_griefing` for the Ender Dragon

Requires Fabric API ([CurseForge](https://www.curseforge.com/minecraft/mc-mods/fabric-api) / [Modrinth](https://modrinth.com/mod/fabric-api)). New game rules are enabled by default.

A changelog is available [here](CHANGELOG.md).

`mob_griefing` controls:
- Creepers and Ghasts destruction
- Endermen taking and placing blocks
- Silverfish infesting blocks
- Zombies and Vindicators breaking doors
- Goats, Nautiluses and Ravagers attacking Armor Stands
- Item Frames, Leashes and Paintings being affected by mobs 

`lenient_griefing` controls:
- Villagers harvesting crops
- Piglin bartering
- Allays picking up items
- Sheep eating grass
- Snow Golems placing snow
- Ravagers destroying leaves
- the Weaving status effect placing cobwebs
- Rabbits eating carrot crops
- Foxes eating Sweet Berries
- Wind Charges and similar explosions affecting blocks and entities
- non-player entities:
  - picking up dropped items
  - turning farmland into dirt
  - melting Powder Snow when on fire
  - placing wither roses when killed by a Wither
    - Wither Roses are dropped as items when this rule is disabled (vanilla behavior)
  - breaking turtle eggs
    - This also includes Zombies and Zombified Piglins pathfinding towards them
- projectiles from non-player entities:
  - breaking Chorus Flowers
  - breaking Pointed Dripstone (Tridents)
  - litting TNT (when on fire)
  - litting Campfires (when on fire)
  - lowering Cauldron water level (when on fire)
- Evokers wololo-ing Sheeps

`wither_griefing` and `dragon_griefing` respectively control whether the Wither and the Ender Dragon can destroy blocks.

Links: [CurseForge](https://www.curseforge.com/minecraft/mc-mods/convenient-mobgriefing) · [GitHub](https://github.com/A5b84/convenient-mobgriefing) · [Modrinth](https://modrinth.com/mod/convenient-mobgriefing)
