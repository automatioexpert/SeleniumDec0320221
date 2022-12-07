package core.apiEngine;

import lombok.Getter;


@Getter
public class Param {

    private String Key;

    private String Value;

    private boolean IsSecret;

    public Param(String key, String value) {
        this(key, value, false);
    }

    public Param(String key, String value, boolean isSecret) {
        Key = key;
        Value = value;
        IsSecret = isSecret;
    }
}
