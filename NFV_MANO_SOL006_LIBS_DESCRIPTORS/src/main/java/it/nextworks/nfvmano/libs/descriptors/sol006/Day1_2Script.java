package it.nextworks.nfvmano.libs.descriptors.sol006;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.nextworks.nfvmano.libs.common.enums.ScriptTypeEnum;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Day1_2Script {

    @JsonIgnore
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String uuid = null;

    @JsonProperty("script-type")
    private ScriptTypeEnum scriptType = null;

    public Day1_2Script scriptType(ScriptTypeEnum scriptType) {
        this.scriptType = scriptType;
        return this;
    }

    public ScriptTypeEnum getScriptType() { return scriptType; }

    public void setScriptType(ScriptTypeEnum scriptType) { this.scriptType = scriptType; }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Day1_2Script day1_2Script = (Day1_2Script) o;

        return Objects.equals(this.scriptType, day1_2Script.scriptType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scriptType);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("class Day1_2Script {\n");
        sb.append("    scriptType: ").append(toIndentedString(scriptType)).append("\n");
        sb.append("}");

        return sb.toString();
    }

    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
