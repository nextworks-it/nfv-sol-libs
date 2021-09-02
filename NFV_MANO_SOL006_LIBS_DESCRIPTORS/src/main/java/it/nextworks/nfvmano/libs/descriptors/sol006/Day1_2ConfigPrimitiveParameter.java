package it.nextworks.nfvmano.libs.descriptors.sol006;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.nextworks.nfvmano.libs.common.enums.DataTypeEnum;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Day1_2ConfigPrimitiveParameter {

    @JsonIgnore
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String uuid = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("data-type")
    private DataTypeEnum dataType = null;

    @JsonProperty("mandatory")
    private Boolean mandatory = null;

    @JsonProperty("default-value")
    private String defaultValue = null;

    @JsonProperty("parameter-pool")
    private String parameterPool = null;

    @JsonProperty("read-only")
    private Boolean readOnly = null;

    @JsonProperty("hidden")
    private Boolean hidden = null;

    public Day1_2ConfigPrimitiveParameter name(String name) {
        this.name = name;
        return this;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Day1_2ConfigPrimitiveParameter dataType(DataTypeEnum dataType) {
        this.dataType = dataType;
        return this;
    }

    public DataTypeEnum getDataType() { return dataType; }

    public void setDataType(DataTypeEnum dataType) { this.dataType = dataType; }

    public Day1_2ConfigPrimitiveParameter mandatory(Boolean mandatory) {
        this.mandatory = mandatory;
        return this;
    }

    public Boolean getMandatory() { return mandatory; }

    public void setMandatory(Boolean mandatory) { this.mandatory = mandatory; }

    public Day1_2ConfigPrimitiveParameter defaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
        return this;
    }

    public String getDefaultValue() { return defaultValue; }

    public void setDefaultValue(String defaultValue) { this.defaultValue = defaultValue; }

    public Day1_2ConfigPrimitiveParameter parameterPool(String parameterPool) {
        this.parameterPool = parameterPool;
        return this;
    }

    public String getParameterPool() { return parameterPool; }

    public void setParameterPool(String parameterPool) { this.parameterPool = parameterPool; }

    public Day1_2ConfigPrimitiveParameter readOnly(Boolean readOnly) {
        this.readOnly = readOnly;
        return this;
    }

    public Boolean getReadOnly() { return readOnly; }

    public void setReadOnly(Boolean readOnly) { this.readOnly = readOnly; }

    public Day1_2ConfigPrimitiveParameter hidden(Boolean hidden) {
        this.hidden = hidden;
        return this;
    }

    public Boolean getHidden() { return hidden; }

    public void setHidden(Boolean hidden) { this.hidden = hidden; }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Day1_2ConfigPrimitiveParameter day1_2ConfigPrimitiveParameter = (Day1_2ConfigPrimitiveParameter) o;

        return Objects.equals(this.name, day1_2ConfigPrimitiveParameter.name) &&
                Objects.equals(this.dataType, day1_2ConfigPrimitiveParameter.dataType) &&
                Objects.equals(this.mandatory, day1_2ConfigPrimitiveParameter.mandatory) &&
                Objects.equals(this.defaultValue, day1_2ConfigPrimitiveParameter.defaultValue) &&
                Objects.equals(this.parameterPool, day1_2ConfigPrimitiveParameter.parameterPool) &&
                Objects.equals(this.readOnly, day1_2ConfigPrimitiveParameter.readOnly) &&
                Objects.equals(this.hidden, day1_2ConfigPrimitiveParameter.hidden);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dataType, mandatory, defaultValue, parameterPool, readOnly, hidden);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("class Day1_2ConfigPrimitiveParameter {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    dataType: ").append(toIndentedString(dataType)).append("\n");
        sb.append("    mandatory: ").append(toIndentedString(mandatory)).append("\n");
        sb.append("    defaultValue: ").append(toIndentedString(defaultValue)).append("\n");
        sb.append("    parameterPool: ").append(toIndentedString(parameterPool)).append("\n");
        sb.append("    readOnly: ").append(toIndentedString(readOnly)).append("\n");
        sb.append("    hidden: ").append(toIndentedString(hidden)).append("\n");
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
