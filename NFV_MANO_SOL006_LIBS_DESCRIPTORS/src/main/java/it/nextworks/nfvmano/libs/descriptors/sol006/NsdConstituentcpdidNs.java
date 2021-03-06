package it.nextworks.nfvmano.libs.descriptors.sol006;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;

/**
 * NsdConstituentcpdidNs
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-09T19:09:38.446+01:00[Europe/Rome]")

@Embeddable
public class NsdConstituentcpdidNs {

  @JsonProperty("ns")
  @Embedded
  private NsdConstituentcpdidNsNs ns = null;

  public NsdConstituentcpdidNs ns(NsdConstituentcpdidNsNs ns) {
    this.ns = ns;
    return this;
  }

  /**
   * Get ns
   * @return ns
   **/
  //@Schema(description = "")
  

    public NsdConstituentcpdidNsNs getNs() {
    return ns;
  }

  public void setNs(NsdConstituentcpdidNsNs ns) {
    this.ns = ns;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NsdConstituentcpdidNs nsdConstituentcpdidNs = (NsdConstituentcpdidNs) o;
    return Objects.equals(this.ns, nsdConstituentcpdidNs.ns);
  }

  @Override
  public int hashCode() {
    return Objects.hash(ns);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NsdConstituentcpdidNs {\n");
    
    sb.append("    ns: ").append(toIndentedString(ns)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
