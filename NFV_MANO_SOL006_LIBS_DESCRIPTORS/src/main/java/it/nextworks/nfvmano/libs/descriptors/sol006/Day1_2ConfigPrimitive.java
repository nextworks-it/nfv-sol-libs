package it.nextworks.nfvmano.libs.descriptors.sol006;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Day1_2ConfigPrimitive {

    @JsonIgnore
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String uuid = null;

    @JsonProperty("name")
    private String name = null;

    @JsonProperty("execution-environment-ref")
    private String executionEnvironmentRef = null;

    @JsonProperty("execution-environment-primitive")
    private String executionEnvironmentPrimitive = null;

    @JsonProperty("parameter")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "day1_2_config_primitive_fk", referencedColumnName = "uuid")
    private List<Day1_2ConfigPrimitiveParameter> parameter = null;

    @JsonProperty("user-defined-script")
    private String userDefinedScript = null;

    public Day1_2ConfigPrimitive name(String name) {
        this.name = name;
        return this;
    }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public Day1_2ConfigPrimitive executionEnvironmentRef(String executionEnvironmentRef) {
        this.executionEnvironmentRef = executionEnvironmentRef;
        return this;
    }

    public String getExecutionEnvironmentRef() { return executionEnvironmentRef; }

    public void setExecutionEnvironmentRef(String executionEnvironmentRef) {
        this.executionEnvironmentRef = executionEnvironmentRef;
    }

    public Day1_2ConfigPrimitive executionEnvironmentPrimitive(String executionEnvironmentPrimitive) {
        this.executionEnvironmentPrimitive = executionEnvironmentPrimitive;
        return this;
    }

    public String getExecutionEnvironmentPrimitive() { return executionEnvironmentPrimitive; }

    public void setExecutionEnvironmentPrimitive(String executionEnvironmentPrimitive) {
        this.executionEnvironmentPrimitive = executionEnvironmentPrimitive;
    }

    public Day1_2ConfigPrimitive parameter(List<Day1_2ConfigPrimitiveParameter> parameter) {
        this.parameter = parameter;
        return this;
    }

    public Day1_2ConfigPrimitive addParameterItem(Day1_2ConfigPrimitiveParameter day1_2ConfigPrimitiveParameter) {
        if(this.parameter == null)
            this.parameter = new ArrayList<>();

        this.parameter.add(day1_2ConfigPrimitiveParameter);
        return this;
    }

    public List<Day1_2ConfigPrimitiveParameter> getParameter() { return parameter; }

    public void setParameter(List<Day1_2ConfigPrimitiveParameter> parameter) { this.parameter = parameter; }

    public Day1_2ConfigPrimitive userDefinedScript(String userDefinedScript) {
        this.userDefinedScript = userDefinedScript;
        return this;
    }

    public String getUserDefinedScript() { return userDefinedScript; }

    public void setUserDefinedScript(String userDefinedScript) { this.userDefinedScript = userDefinedScript; }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Day1_2ConfigPrimitive day1_2ConfigPrimitive = (Day1_2ConfigPrimitive) o;

        return Objects.equals(this.name, day1_2ConfigPrimitive.name) &&
                Objects.equals(this.executionEnvironmentRef, day1_2ConfigPrimitive.executionEnvironmentRef) &&
                Objects.equals(this.executionEnvironmentPrimitive, day1_2ConfigPrimitive.executionEnvironmentPrimitive) &&
                Objects.equals(this.parameter, day1_2ConfigPrimitive.parameter) &&
                Objects.equals(this.userDefinedScript, day1_2ConfigPrimitive.userDefinedScript);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, executionEnvironmentRef, executionEnvironmentPrimitive, parameter, userDefinedScript);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("class Day1_2ConfigPrimitive {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    executionEnvironmentRef: ").append(toIndentedString(executionEnvironmentRef)).append("\n");
        sb.append("    executionEnvironmentPrimitive: ").append(toIndentedString(executionEnvironmentPrimitive)).append("\n");
        sb.append("    parameter: ").append(toIndentedString(parameter)).append("\n");
        sb.append("    userDefinedScript: ").append(toIndentedString(userDefinedScript)).append("\n");
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
