package it.nextworks.nfvmano.libs.descriptors.sol006;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.nextworks.nfvmano.libs.common.enums.HelmVersionEnum;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Day1_2ExecutionEnvironmentList {

    @JsonIgnore
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String uuid = null;

    @JsonProperty("id")
    private String id = null;

    @JsonProperty("juju")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "juju_fk", referencedColumnName = "uuid")
    private Day1_2Juju juju = null;

    @JsonProperty("helm-chart")
    private String helmChart = null;

    @JsonProperty("helm-version")
    private HelmVersionEnum helmVersion = null;

    @JsonProperty("metric-service")
    private String metricService = null;

    @JsonProperty("external-connection-point-ref")
    private String externalConnectionPointRef = null;

    public Day1_2ExecutionEnvironmentList id(String id) {
        this.id = id;
        return this;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public Day1_2ExecutionEnvironmentList juju(Day1_2Juju juju) {
        this.juju = juju;
        return this;
    }

    public Day1_2Juju getJuju() { return juju; }

    public void setJuju(Day1_2Juju juju) { this.juju = juju; }

    public Day1_2ExecutionEnvironmentList helmChart(String helmChart) {
        this.helmChart = helmChart;
        return this;
    }

    public String getHelmChart() { return helmChart; }

    public void setHelmChart(String helmChart) { this.helmChart = helmChart; }

    public Day1_2ExecutionEnvironmentList helmVersion(HelmVersionEnum helmVersion) {
        this.helmVersion = helmVersion;
        return this;
    }

    public HelmVersionEnum getHelmVersion() { return helmVersion; }

    public void setHelmVersion(HelmVersionEnum helmVersion) { this.helmVersion = helmVersion; }

    public Day1_2ExecutionEnvironmentList metricService(String metricService) {
        this.metricService = metricService;
        return this;
    }

    public String getMetricService() { return metricService; }

    public void setMetricService(String metricService) { this.metricService = metricService; }

    public Day1_2ExecutionEnvironmentList externalConnectionPointRef(String externalConnectionPointRef) {
        this.externalConnectionPointRef = externalConnectionPointRef;
        return this;
    }

    public String getExternalConnectionPointRef() { return externalConnectionPointRef; }

    public void setExternalConnectionPointRef(String externalConnectionPointRef) {
        this.externalConnectionPointRef = externalConnectionPointRef;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Day1_2ExecutionEnvironmentList day1_2ExecutionEnvironmentList = (Day1_2ExecutionEnvironmentList) o;

        return Objects.equals(this.id, day1_2ExecutionEnvironmentList.id) &&
                Objects.equals(this.juju, day1_2ExecutionEnvironmentList.juju) &&
                Objects.equals(this.helmChart, day1_2ExecutionEnvironmentList.helmChart) &&
                Objects.equals(this.helmVersion, day1_2ExecutionEnvironmentList.helmVersion) &&
                Objects.equals(this.metricService, day1_2ExecutionEnvironmentList.metricService) &&
                Objects.equals(this.externalConnectionPointRef, day1_2ExecutionEnvironmentList.externalConnectionPointRef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, juju, helmChart, helmVersion, metricService, externalConnectionPointRef);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("class Day1_2ExecutionEnvironmentList {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    juju: ").append(toIndentedString(juju)).append("\n");
        sb.append("    helmChart: ").append(toIndentedString(helmChart)).append("\n");
        sb.append("    helmVersion: ").append(toIndentedString(helmVersion)).append("\n");
        sb.append("    metricService: ").append(toIndentedString(metricService)).append("\n");
        sb.append("    externalConnectionPointRef: ").append(toIndentedString(externalConnectionPointRef)).append("\n");
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
