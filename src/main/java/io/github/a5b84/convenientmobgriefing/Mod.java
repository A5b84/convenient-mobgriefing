package io.github.a5b84.convenientmobgriefing;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.Identifier;

public class Mod implements ModInitializer {

  private static final String NAMESPACE = "convenient_mobgriefing";

  public static Identifier identifier(String path) {
    return Identifier.fromNamespaceAndPath(NAMESPACE, path);
  }

  @Override
  public void onInitialize() {
    ModRules.registerRules();
  }
}
