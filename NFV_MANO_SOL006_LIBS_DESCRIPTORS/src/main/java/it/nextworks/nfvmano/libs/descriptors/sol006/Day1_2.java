package it.nextworks.nfvmano.libs.descriptors.sol006;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.nextworks.nfvmano.libs.common.enums.BlacklistConfigPrimitiveEnum;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Day1_2 {

    @JsonIgnore
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String uuid = null;

    @JsonProperty("id")
    private String id = null;

    @JsonProperty("script")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "script_fk", referencedColumnName = "uuid")
    private Day1_2Script script = null;

    @JsonProperty("juju")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "juju_fk", referencedColumnName = "uuid")
    private Day1_2Juju juju = null;

    @JsonProperty("execution-environment-list")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "day1_2_fk", referencedColumnName = "uuid")
    private List<Day1_2ExecutionEnvironmentList> executionEnvironmentList = null;

    @JsonProperty("config-primitive")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "day1_2_fk", referencedColumnName = "uuid")
    private List<Day1_2ConfigPrimitive> configPrimitive = null;

    @JsonProperty("initial-config-primitive")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "day1_2_fk", referencedColumnName = "uuid")
    private List<InitialConfigPrimitive> initialConfigPrimitive = null;

    @JsonProperty("terminate-config-primitive")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "day1_2_fk", referencedColumnName = "uuid")
    private List<TerminateConfigPrimitive> terminateConfigPrimitive = null;

    @JsonProperty("metrics")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "day1_2_fk", referencedColumnName = "uuid")
    private List<Day1_2Metrics> metrics = null;

    @JsonProperty("relation")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinColumn(name = "day1_2_fk", referencedColumnName = "uuid")
    private List<Day1_2Relation> relation = null;

    @JsonProperty("config-access")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "config_access_fk", referencedColumnName = "uuid")
    private Day1_2ConfigAccess configAccess = null;

    @JsonProperty("blacklist-config-primitive")
    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<BlacklistConfigPrimitiveEnum> blacklistConfigPrimitive = null;

    public Day1_2 id(String id) {
        this.id = id;
        return this;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public Day1_2 script(Day1_2Script script) {
        this.script = script;
        return this;
    }

    public Day1_2Script getScript() { return script; }

    public void setScript(Day1_2Script script) { this.script = script; }

    public Day1_2 juju(Day1_2Juju juju) {
        this.juju = juju;
        return this;
    }

    public Day1_2Juju getJuju() { return juju; }

    public void setJuju(Day1_2Juju juju) { this.juju = juju; }

    public Day1_2 executionEnvironmentList(List<Day1_2ExecutionEnvironmentList> executionEnvironmentList) {
        this.executionEnvironmentList = executionEnvironmentList;
        return this;
    }

    public Day1_2 addExecutionEnvironmentListItem(Day1_2ExecutionEnvironmentList day1_2ExecutionEnvironmentList) {
        if(this.executionEnvironmentList == null)
            this.executionEnvironmentList = new ArrayList<>();

        this.executionEnvironmentList.add(day1_2ExecutionEnvironmentList);
        return this;
    }

    public List<Day1_2ExecutionEnvironmentList> getExecutionEnvironmentList() { return executionEnvironmentList; }

    public void setExecutionEnvironmentList(List<Day1_2ExecutionEnvironmentList> executionEnvironmentList) {
        this.executionEnvironmentList = executionEnvironmentList;
    }

    public Day1_2 configPrimitive(List<Day1_2ConfigPrimitive> configPrimitive) {
        this.configPrimitive = configPrimitive;
        return this;
    }

    public Day1_2 addConfigPrimitiveItem(Day1_2ConfigPrimitive day1_2ConfigPrimitive) {
        if(this.configPrimitive == null)
            this.configPrimitive = new ArrayList<>();

        this.configPrimitive.add(day1_2ConfigPrimitive);
        return this;
    }

    public List<Day1_2ConfigPrimitive> getConfigPrimitive() { return configPrimitive; }

    public void setConfigPrimitive(List<Day1_2ConfigPrimitive> configPrimitive) { this.configPrimitive = configPrimitive; }

    public Day1_2 initialConfigPrimitive(List<InitialConfigPrimitive> initialConfigPrimitive) {
        this.initialConfigPrimitive = initialConfigPrimitive;
        return this;
    }

    public Day1_2 addInitialConfigPrimitiveItem(InitialConfigPrimitive initialConfigPrimitive) {
        if(this.initialConfigPrimitive == null)
            this.initialConfigPrimitive = new ArrayList<>();

        this.initialConfigPrimitive.add(initialConfigPrimitive);
        return this;
    }

    public List<InitialConfigPrimitive> getInitialConfigPrimitive() { return initialConfigPrimitive; }

    public void setInitialConfigPrimitive(List<InitialConfigPrimitive> initialConfigPrimitive) {
        this.initialConfigPrimitive = initialConfigPrimitive;
    }

    public Day1_2 terminateConfigPrimitive(List<TerminateConfigPrimitive> terminateConfigPrimitive) {
        this.terminateConfigPrimitive = terminateConfigPrimitive;
        return this;
    }

    public Day1_2 addTerminateConfigPrimitiveItem(TerminateConfigPrimitive terminateConfigPrimitive) {
        if(this.terminateConfigPrimitive == null)
            this.terminateConfigPrimitive = new ArrayList<>();

        this.terminateConfigPrimitive.add(terminateConfigPrimitive);
        return this;
    }

    public List<TerminateConfigPrimitive> getTerminateConfigPrimitive() { return terminateConfigPrimitive; }

    public void setTerminateConfigPrimitive(List<TerminateConfigPrimitive> terminateConfigPrimitive) {
        this.terminateConfigPrimitive = terminateConfigPrimitive;
    }

    public Day1_2 metrics(List<Day1_2Metrics> metrics) {
        this.metrics = metrics;
        return this;
    }

    public Day1_2 addMetricsItem(Day1_2Metrics day1_2Metrics) {
        if(this.metrics == null)
            this.metrics = new ArrayList<>();

        this.metrics.add(day1_2Metrics);
        return this;
    }

    public List<Day1_2Metrics> getMetrics() { return metrics; }

    public void setMetrics(List<Day1_2Metrics> metrics) { this.metrics = metrics; }

    public Day1_2 relation(List<Day1_2Relation> relation) {
        this.relation = relation;
        return this;
    }

    public Day1_2 addRelationItem(Day1_2Relation day1_2Relation) {
        if(this.relation == null)
            this.relation = new ArrayList<>();

        this.relation.add(day1_2Relation);
        return this;
    }

    public List<Day1_2Relation> getRelation() { return relation; }

    public void setRelation(List<Day1_2Relation> relation) { this.relation = relation; }

    public Day1_2 configAccess(Day1_2ConfigAccess configAccess) {
        this.configAccess = configAccess;
        return this;
    }

    public Day1_2ConfigAccess getConfigAccess() { return configAccess; }

    public void setConfigAccess(Day1_2ConfigAccess configAccess) { this.configAccess = configAccess; }

    public Day1_2 blacklistConfigPrimitive(List<BlacklistConfigPrimitiveEnum> blacklistConfigPrimitive) {
        this.blacklistConfigPrimitive = blacklistConfigPrimitive;
        return this;
    }

    public Day1_2 addBlacklistConfigPrimitiveItem(BlacklistConfigPrimitiveEnum blacklistConfigPrimitiveEnum) {
        if(this.blacklistConfigPrimitive == null)
            this.blacklistConfigPrimitive = new ArrayList<>();

        this.blacklistConfigPrimitive.add(blacklistConfigPrimitiveEnum);
        return this;
    }

    public List<BlacklistConfigPrimitiveEnum> getBlacklistConfigPrimitive() { return blacklistConfigPrimitive; }

    public void setBlacklistConfigPrimitive(List<BlacklistConfigPrimitiveEnum> blacklistConfigPrimitive) {
        this.blacklistConfigPrimitive = blacklistConfigPrimitive;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Day1_2 day1_2 = (Day1_2) o;

        return Objects.equals(this.id, day1_2.id) &&
                Objects.equals(this.script, day1_2.script) &&
                Objects.equals(this.juju, day1_2.juju) &&
                Objects.equals(this.executionEnvironmentList, day1_2.executionEnvironmentList) &&
                Objects.equals(this.configPrimitive, day1_2.configPrimitive) &&
                Objects.equals(this.initialConfigPrimitive, day1_2.initialConfigPrimitive) &&
                Objects.equals(this.terminateConfigPrimitive, day1_2.terminateConfigPrimitive) &&
                Objects.equals(this.metrics, day1_2.metrics) &&
                Objects.equals(this.relation, day1_2.relation) &&
                Objects.equals(this.configAccess, day1_2.configAccess) &&
                Objects.equals(this.blacklistConfigPrimitive, day1_2.blacklistConfigPrimitive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, script, juju, executionEnvironmentList, configPrimitive, initialConfigPrimitive,
                terminateConfigPrimitive, metrics, relation, configAccess, blacklistConfigPrimitive);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("class Day1_2 {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    script: ").append(toIndentedString(script)).append("\n");
        sb.append("    juju: ").append(toIndentedString(juju)).append("\n");
        sb.append("    executionEnvironmentList: ").append(toIndentedString(executionEnvironmentList)).append("\n");
        sb.append("    configPrimitive: ").append(toIndentedString(configPrimitive)).append("\n");
        sb.append("    initialConfigPrimitive: ").append(toIndentedString(initialConfigPrimitive)).append("\n");
        sb.append("    terminateConfigPrimitive: ").append(toIndentedString(terminateConfigPrimitive)).append("\n");
        sb.append("    metrics: ").append(toIndentedString(metrics)).append("\n");
        sb.append("    relation: ").append(toIndentedString(relation)).append("\n");
        sb.append("    configAccess: ").append(toIndentedString(configAccess)).append("\n");
        sb.append("    blacklistConfigPrimitive: ").append(toIndentedString(blacklistConfigPrimitive)).append("\n");
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
