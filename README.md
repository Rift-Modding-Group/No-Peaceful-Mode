## No Peaceful Mode
No Peaceful Mode does what the name suggests: remove peaceful mode.

Well, not really. You can't remove a difficulty level entirely, so instead this mod just makes peaceful mode inaccessible. It does this by:

* Making the `/difficulty` command unable to set difficulty to peaceful via Mixins
* Making it impossible to set peaceful mode in settings via Mixins
* Making it so that when loading a world, if the difficulty was set to peaceful, it immediately changes to easy

The mod is for Minecraft Forge 1.12.2 and requires [MixinBooter](https://www.curseforge.com/minecraft/mc-mods/mixin-booter)