# Changelog

### [2.1.8](https://github.com/A5b84/convenient-mobgriefing/releases/tag/v2.1.8)
- Updated to 1.21.11
- Effects of Wind Charges and similar explosions are now controlled by `lenient_griefing`
- Renamed the game rules to match vanilla changes:
  - `lenientGriefing` is now `convenient_mobgriefing:lenient_griefing`
  - `witherGriefing` is now `convenient_mobgriefing:wither_griefing`
  - `dragonGriefing` is now `convenient_mobgriefing:dragon_griefing`
  - Existing rule settings in 1.21.10- worlds automatically carry over when first opening the world in 1.21.11+
- Fixed Ravagers destroying certain crops possibly being controlled by `mob_griefing` instead of `lenient_griefing` 

### [2.1.7](https://github.com/A5b84/convenient-mobgriefing/releases/tag/v2.1.7)
- Updated to 1.21.10

### [2.1.6](https://github.com/A5b84/convenient-mobgriefing/releases/tag/v2.1.6)
- Updated to 1.21.9

### [2.1.5](https://github.com/A5b84/convenient-mobgriefing/releases/tag/v2.1.5)
- Updated to 1.21.6

### [2.1.4](https://github.com/A5b84/convenient-mobgriefing/releases/tag/v2.1.4)
- Updated to 1.21.5

### [2.1.3](https://github.com/A5b84/convenient-mobgriefing/releases/tag/v2.1.3)
- Updated to 1.21.2

### [2.1.2](https://github.com/A5b84/convenient-mobgriefing/releases/tag/v2.1.2)
- Updated to 1.20.6
- Moved Ravagers breaking Pitcher Pods from `mobGriefing` to `lenientGriefing`
- Moved the Weaving effect from `mobGriefing` to `lenientGriefing`

### [2.1.1](https://github.com/A5b84/convenient-mobgriefing/releases/tag/v2.1.1)
- Updated to 1.20.4
- Moved Ravagers breaking leaves from `mobGriefing` to `lenientGriefing` ([#14](https://github.com/A5b84/convenient-mobgriefing/issues/14))
- Moved projectiles on fire litting TNT from `mobGriefing` to `lenientGriefing`

### [2.1.0](https://github.com/A5b84/convenient-mobgriefing/releases/tag/v2.1.0)
- Added support for:
  - Allays picking up items ([#10](https://github.com/A5b84/convenient-mobgriefing/pull/10), [#11](https://github.com/A5b84/convenient-mobgriefing/issues/11), [#13](https://github.com/A5b84/convenient-mobgriefing/pull/13)) 
  - non-player entities melting Powder Snow when on fire
  - projectiles from non-player entities:
    - breaking Chorus Flowers
    - breaking Pointed Dripstone (Tridents)
    - litting Campfires (when on fire)
    - lowering Cauldron water level (when on fire)

### [2.0.2](https://github.com/A5b84/convenient-mobgriefing/releases/tag/v2.0.2)
- Slightly better compatibility with some mods (e.g. MiniTweaks, [#6](https://github.com/A5b84/convenient-mobgriefing/issues/6))

### [2.0.1](https://github.com/A5b84/convenient-mobgriefing/releases/tag/v2.0.1)
- Fixed a crash on startup in 1.17 ([#5](https://github.com/A5b84/convenient-mobgriefing/issues/5))

### [2.0.0](https://github.com/A5b84/convenient-mobgriefing/releases/tag/v2.0.0)
- Renamed the game rules to sound more natural:
    - ⚠️ Settings from older versions will be lost. Don't forget to change them again after updating or your world may go boom.
    - `mobGriefingLenient` -> `lenientGriefing`
    - `mobGriefingWither` -> `witherGriefing`
    - `mobGriefingDragon` -> `dragonGriefing`
- Now requires [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api)
- Updated the icon

### [1.1.4](https://github.com/A5b84/convenient-mobgriefing/releases/tag/v1.1.4)
- New icon
- Fixed an incompatibility with some mods ([#3](https://github.com/A5b84/convenient-mobgriefing/issues/3))

### [1.1.3](https://github.com/A5b84/convenient-mobgriefing/releases/tag/v1.1.3)
- Lowered mixin priority, fixes potential incompatibility issues

### [1.1.2](https://github.com/A5b84/convenient-mobgriefing/releases/tag/v1.1.2)
- Fixed a crash on startup in 20w22a and later

### [1.1.1](https://github.com/A5b84/convenient-mobgriefing/releases/tag/v1.1.1)
- Added `en_us` and `fr_fr` language files with rule names and descriptions (used in 20w17a and later), requires the [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api) for localization to work.

### [1.1.0](https://github.com/A5b84/convenient-mobgriefing/releases/tag/v1.1.0)
- Fixed a crash on startup in 20w17a and later
- `mobGriefingPassive` has been renamed to `mobGriefingLenient`
- Piglin bartering is now affected by `mobGriefingLenient`
- Renamed the mod 'Convenient mobGriefing' because why not

### [1.0.0](https://github.com/A5b84/convenient-mobgriefing/releases/tag/v1.0.0)
- Initial release


### Minecraft compatibility by mod version

Old versions:

|     Version | 1.14-20w16a | 20w17a-20w21a | 20w22a-1.16.5 | 1.17-1.19.2 |
|------------:|:-----------:|:-------------:|:-------------:|:-----------:|
|       1.0.0 |      X      |               |               |             |
| 1.1.0-1.1.1 |      X      |       X       |               |             |
| 1.1.2-2.0.0 |      X      |       X       |       X       |             |
| 2.0.1-2.0.2 |      X      |       X       |       X       |      X      |

Newer versions:
- 2.1.0: 1.19.3-1.20.2
- 2.1.1: 1.20.3-1.20.4
- 2.1.2: 1.20.6-1.21.1
- 2.1.3: 1.21.2-1.21.4
- 2.1.4: 1.21.5
- 2.1.5: 1.21.6-1.21.8
- 2.1.6: 1.21.9
- 2.1.7: 1.21.10
- 2.1.8: 1.21.11+
