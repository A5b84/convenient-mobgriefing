package io.github.a5b84.convenientmobgriefing.mixin;

import java.util.List;
import java.util.Set;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import net.minecraft.MinecraftVersion;

/**
 * Plugin pour désactiver les mixins incompatibles
 */
public class MixinConfigPlugin implements IMixinConfigPlugin {

    // De https://minecraft.gamepedia.com/Data_version#List_of_data_versions
    private static final int V20w17a = 2529;
    private static final int GAME_VERSION = new MinecraftVersion().getWorldVersion();

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.endsWith("Post20w17a")) return GAME_VERSION >= V20w17a;
        if (mixinClassName.endsWith("Pre20w17a")) return GAME_VERSION < V20w17a;

        return true;
    }

    @Override public void onLoad(String mixinPackage) {}
    @Override public String getRefMapperConfig() { return null; }
    @Override public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}
    @Override public List<String> getMixins() { return null; }
    @Override public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
    @Override public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}

}
