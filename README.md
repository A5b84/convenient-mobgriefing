# Convenient mobGriefing

A [Fabric](https://fabricmc.net) mod that gives more control over the `mob_griefing` game rule by splitting it into the following four broad rules:
- `mob_griefing` for hostile mob behaviors that generally have a negative impact
- `lenient_griefing` for behaviors that are generally not negative and/or can be easily avoided
- `wither_griefing` for the Wither
- `dragon_griefing` for the Ender Dragon

These can be further configured to toggle individual mob behaviors covered by the vanilla `mob_griefing` rule.

With this mod, `mob_griefing` controls:
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

Requires Fabric API ([CurseForge](https://www.curseforge.com/minecraft/mc-mods/fabric-api) / [Modrinth](https://modrinth.com/mod/fabric-api)).
A changelog is available [here](CHANGELOG.md).

## Configuration

New game rules can be modified like any vanilla game rule and are enabled by default.

Behaviors covered by the broad game rules can be individually toggled using override rules, e.g. `convenient_mobgriefing:lenient_griefing.override.mobs_pick_up_items` controls whether mobs can pick up items.
Override rules have three possible values:
- `default`: the override is inactive, i.e. the behavior is controlled by its base rule (`convenient_mobgriefing:lenient_griefing` in the previous example)
- `true`: the behavior is enabled independently of its base rule
- `false`: the behavior is disabled independently of its base rule

Links: [CurseForge](https://www.curseforge.com/minecraft/mc-mods/convenient-mobgriefing) · [GitHub](https://github.com/A5b84/convenient-mobgriefing) · [Modrinth](https://modrinth.com/mod/convenient-mobgriefing)
