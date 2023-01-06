package de.konsl.webweaverapi.model.auth;

import java.util.Arrays;
import java.util.Objects;

public enum DigestAlgorithm {
    MD5("md5"),
    SHA1("sha1"),
    SHA256("sha256"),
    SHA512("sha512");

    private final String value;

    DigestAlgorithm(String _value) {
        value = _value;
    }

    public String getValue() {
        return value;
    }

    public static DigestAlgorithm of(String value) {
        return Arrays.stream(values())
                .filter(e -> Objects.equals(e.value, value))
                .findFirst().orElse(null);
    }
}
