package it.nextworks.nfvmano.libs.descriptors.sol006;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.nextworks.nfvmano.libs.common.enums.CloudEnum;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Day1_2Juju {

    @JsonIgnore
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String uuid = null;

    @JsonProperty("charm")
    private String charm = null;

    @JsonProperty("proxy")
    private Boolean proxy = null;

    @JsonProperty("cloud")
    private CloudEnum cloud = null;

    public Day1_2Juju charm(String charm) {
        this.charm = charm;
        return this;
    }

    public String getCharm() { return charm; }

    public void setCharm(String charm) { this.charm = charm; }

    public Day1_2Juju proxy(Boolean proxy) {
        this.proxy = proxy;
        return this;
    }

    public Boolean getProxy() { return proxy; }

    public void setProxy(Boolean proxy) { this.proxy = proxy; }

    public Day1_2Juju cloud(CloudEnum cloud) {
        this.cloud = cloud;
        return this;
    }

    public CloudEnum getCloud() { return cloud; }

    public void setCloud(CloudEnum cloud) { this.cloud = cloud; }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Day1_2Juju day1_2Juju = (Day1_2Juju) o;

        return Objects.equals(this.charm, day1_2Juju.charm) &&
                Objects.equals(this.proxy, day1_2Juju.proxy) &&
                Objects.equals(this.cloud, day1_2Juju.cloud);
    }

    @Override
    public int hashCode() {
        return Objects.hash(charm, proxy, cloud);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("class Day1_2Juju {\n");
        sb.append("    charm: ").append(toIndentedString(charm)).append("\n");
        sb.append("    proxy: ").append(toIndentedString(proxy)).append("\n");
        sb.append("    cloud: ").append(toIndentedString(cloud)).append("\n");
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
