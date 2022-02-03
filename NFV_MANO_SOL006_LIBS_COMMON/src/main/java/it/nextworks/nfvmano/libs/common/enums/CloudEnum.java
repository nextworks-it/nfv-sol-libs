package it.nextworks.nfvmano.libs.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum CloudEnum {

    LXD("lxd"),

    K8S("k8s");

    private String value;

    CloudEnum(String value) { this.value = value; }

    @Override
    @JsonValue
    public String toString() { return String.valueOf(value); }

    @JsonCreator
    public static CloudEnum fromValue(String text) {
        for (CloudEnum b : CloudEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }

        return null;
    }
}
