package io.github.a5b84.convenientmobgriefing.mixin;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import java.util.Set;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

/**
 * Plugin pour désactiver les mixins incompatibles
 */
public class MixinConfigPlugin implements IMixinConfigPlugin {

    // De https://minecraft.gamepedia.com/Data_version#List_of_data_versions
    private static final int V20w17a = 2529;
    private static final int GAME_VERSION = getGameVersion();

    @Override
    public boolean shouldApplyMixin(String targetClassName, String mixinClassName) {
        if (mixinClassName.endsWith("Post20w17a")) return GAME_VERSION >= V20w17a;
        if (mixinClassName.endsWith("Pre20w17a")) return GAME_VERSION < V20w17a;

        return true;
    }

    /** Lit la version du jeu depuis le version.json dans le jar
     * Copié de Dark Loading Screen */
    private static int getGameVersion() {
        try (
            final InputStream stream = MixinConfigPlugin.class.getResourceAsStream("/version.json");
            final Reader reader = new InputStreamReader(stream);
        ) {
            final JsonObject versions = new JsonParser().parse(reader).getAsJsonObject();
            return versions.get("world_version").getAsInt();
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException("[Convenient mobGriefing] Couldn't get the game version", e);
        }
    }

    @Override public void onLoad(String mixinPackage) {}
    @Override public String getRefMapperConfig() { return null; }
    @Override public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}
    @Override public List<String> getMixins() { return null; }
    @Override public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
    @Override public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}

}
