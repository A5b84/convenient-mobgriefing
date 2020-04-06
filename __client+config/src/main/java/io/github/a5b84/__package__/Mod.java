package io.github.a5b84.__package__;

import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import me.sargunvohra.mcmods.autoconfig1u.serializer.GsonConfigSerializer;
import io.github.a5b84.__package__.config.ModConfig;
import net.fabricmc.api.ClientModInitializer;

public class Mod implements ClientModInitializer {

    public static final String ID = "__id__";

    @Override
    public void onInitializeClient() {
        AutoConfig.register(ModConfig.class, GsonConfigSerializer::new);
    }

}
