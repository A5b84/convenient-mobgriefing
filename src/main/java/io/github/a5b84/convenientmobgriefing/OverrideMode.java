package io.github.a5b84.convenientmobgriefing;

import java.util.Locale;

/** Possible values for an override game rule */
public enum OverrideMode {
  /** Value for overrides that change the base rule value to {@code true} */
  TRUE,
  /** Value for overrides that change the base rule value to {@code false} */
  FALSE,
  /** Value for overrides that keep the value of the base rule */
  DEFAULT;

  @Override
  public String toString() {
    return super.toString().toLowerCase(Locale.ROOT);
  }
}
