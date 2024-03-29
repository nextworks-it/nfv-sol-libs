package it.nextworks.nfvmano.libs.common.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BlacklistConfigPrimitiveEnum {

    UPGRADE("upgrade"),

    ROLLBACK("rollback");

    private String value;

    BlacklistConfigPrimitiveEnum(String value) { this.value = value; }

    @Override
    @JsonValue
    public String toString() { return String.valueOf(value); }

    @JsonCreator
    public static BlacklistConfigPrimitiveEnum fromValue(String text) {
        for (BlacklistConfigPrimitiveEnum b : BlacklistConfigPrimitiveEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }

        return null;
    }
}
