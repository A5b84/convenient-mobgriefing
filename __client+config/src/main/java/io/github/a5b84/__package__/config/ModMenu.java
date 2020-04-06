package io.github.a5b84.__package__.config;

import java.util.function.Function;

import io.github.a5b84.__package__.Mod;
import io.github.prospector.modmenu.api.ModMenuApi;
import me.sargunvohra.mcmods.autoconfig1u.AutoConfig;
import net.minecraft.client.gui.screen.Screen;

public class ModMenu implements ModMenuApi {

    @Override
    public String getModId() {
        return Mod.ID;
    }

    @Override
    public Function<Screen, ? extends Screen> getConfigScreenFactory() {
        return screen -> AutoConfig.getConfigScreen(ModConfig.class, screen).get();
    }

}
