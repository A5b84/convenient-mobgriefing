# Changelog

- [Compatibility table](#compatibility-table)

### [2.0.0]
- Renamed the game rules to sound more natural:
    - ⚠️ Settings from older versions will be lost. Your world may go boom.
    - `mobGriefingLenient` -> `lenientGriefing`
    - `mobGriefingWither` -> `witherGriefing`
    - `mobGriefingDragon` -> `dragonGriefing`
- Now requires [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api)
- Updated the icon

### [1.1.4]
- New icon
- Fixed [#3](https://github.com/A5b84/convenient-mobgriefing/issues/3)

### [1.1.3]
- Lowered mixin priority, fixes potential incompatibility issues

### [1.1.2]
- Fixed a crash on startup in 20w22a and later

### [1.1.1]
- Added `en_us` and `fr_fr` language files with rule names and descriptions (used in 20w17a and later), requires the [Fabric API](https://www.curseforge.com/minecraft/mc-mods/fabric-api) for localization to work.

### [1.1.0]
- Fixed a crash on startup in 20w17a and later
- `mobGriefingPassive` has been renamed to `mobGriefingLenient`
- Piglin bartering is now affected by `mobGriefingLenient`
- Renamed the mod 'Convenient mobGriefing' because why not

### [1.0.0]
- Initial release



### Compatibility table
| Version     | 1.14-20w16a | 20w17a-20w21a | 20w22a+ |
|------------:|:-----------:|:-------------:|:-------:|
| 1.0.0       | X
| 1.1.0-1.1.1 | X           | X
| 1.1.2+      | X           | X             | X



[1.0.0]: https://github.com/A5b84/convenient-mobgriefing/releases/tag/v1.0.0
[1.1.0]: https://github.com/A5b84/convenient-mobgriefing/releases/tag/v1.1.0
[1.1.1]: https://github.com/A5b84/convenient-mobgriefing/releases/tag/v1.1.1
[1.1.2]: https://github.com/A5b84/convenient-mobgriefing/releases/tag/v1.1.2
[1.1.3]: https://github.com/A5b84/convenient-mobgriefing/releases/tag/v1.1.3
[1.1.4]: https://github.com/A5b84/convenient-mobgriefing/releases/tag/v1.1.4
[2.0.0]: https://github.com/A5b84/convenient-mobgriefing/releases/tag/v2.0.0
