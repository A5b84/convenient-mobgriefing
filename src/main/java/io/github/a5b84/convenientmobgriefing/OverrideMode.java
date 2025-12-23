package io.github.a5b84.convenientmobgriefing;

/** Possible values for an override game rule */
public enum OverrideMode {
  /** Value for overrides that change the base rule value to {@code true} */
  TRUE,
  /** Value for overrides that change the base rule value to {@code false} */
  FALSE,
  /** Value for overrides that keep the value of the base rule */
  DEFAULT
}
