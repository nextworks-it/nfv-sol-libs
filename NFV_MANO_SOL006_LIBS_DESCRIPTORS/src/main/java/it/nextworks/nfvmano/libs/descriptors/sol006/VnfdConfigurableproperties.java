package it.nextworks.nfvmano.libs.descriptors.sol006;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;



/**
 * Describes the configurable properties of the VNF (e.g. related to auto scaling and auto healing).
 */
//@Schema(description = "Describes the configurable properties of the VNF (e.g. related to auto scaling and auto healing).")

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-09T19:09:38.446+01:00[Europe/Rome]")


public class VnfdConfigurableproperties   {
  @JsonProperty("is-auto-scalable-enabled")
  private Boolean isAutoScalableEnabled = null;

  @JsonProperty("is-auto-heal-enabled")
  private Boolean isAutoHealEnabled = null;

  @JsonProperty("additional-configurable-property")

  private List<VnfdVdustoragerequirements> additionalConfigurableProperty = null;

  public VnfdConfigurableproperties isAutoScalableEnabled(Boolean isAutoScalableEnabled) {
    this.isAutoScalableEnabled = isAutoScalableEnabled;
    return this;
  }

  /**
   * It permits to enable (TRUE) / disable (FALSE) the auto-scaling functionality.
   * @return isAutoScalableEnabled
   **/
  //@Schema(description = "It permits to enable (TRUE) / disable (FALSE) the auto-scaling functionality.")
  
    public Boolean isIsAutoScalableEnabled() {
    return isAutoScalableEnabled;
  }

  public void setIsAutoScalableEnabled(Boolean isAutoScalableEnabled) {
    this.isAutoScalableEnabled = isAutoScalableEnabled;
  }

  public VnfdConfigurableproperties isAutoHealEnabled(Boolean isAutoHealEnabled) {
    this.isAutoHealEnabled = isAutoHealEnabled;
    return this;
  }

  /**
   * It permits to enable (TRUE) / disable (FALSE) the auto-healing functionality.
   * @return isAutoHealEnabled
   **/
  //@Schema(description = "It permits to enable (TRUE) / disable (FALSE) the auto-healing functionality.")
  
    public Boolean isIsAutoHealEnabled() {
    return isAutoHealEnabled;
  }

  public void setIsAutoHealEnabled(Boolean isAutoHealEnabled) {
    this.isAutoHealEnabled = isAutoHealEnabled;
  }

  public VnfdConfigurableproperties additionalConfigurableProperty(List<VnfdVdustoragerequirements> additionalConfigurableProperty) {
    this.additionalConfigurableProperty = additionalConfigurableProperty;
    return this;
  }

  public VnfdConfigurableproperties addAdditionalConfigurablePropertyItem(VnfdVdustoragerequirements additionalConfigurablePropertyItem) {
    if (this.additionalConfigurableProperty == null) {
      this.additionalConfigurableProperty = new ArrayList<VnfdVdustoragerequirements>();
    }
    this.additionalConfigurableProperty.add(additionalConfigurablePropertyItem);
    return this;
  }

  /**
   * It provides VNF specific configurable properties that can be modified using the ModifyVnfConfiguration operation.
   * @return additionalConfigurableProperty
   **/
  //@Schema(description = "It provides VNF specific configurable properties that can be modified using the ModifyVnfConfiguration operation.")

    public List<VnfdVdustoragerequirements> getAdditionalConfigurableProperty() {
    return additionalConfigurableProperty;
  }

  public void setAdditionalConfigurableProperty(List<VnfdVdustoragerequirements> additionalConfigurableProperty) {
    this.additionalConfigurableProperty = additionalConfigurableProperty;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VnfdConfigurableproperties vnfdConfigurableproperties = (VnfdConfigurableproperties) o;
    return Objects.equals(this.isAutoScalableEnabled, vnfdConfigurableproperties.isAutoScalableEnabled) &&
        Objects.equals(this.isAutoHealEnabled, vnfdConfigurableproperties.isAutoHealEnabled) &&
        Objects.equals(this.additionalConfigurableProperty, vnfdConfigurableproperties.additionalConfigurableProperty);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isAutoScalableEnabled, isAutoHealEnabled, additionalConfigurableProperty);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VnfdConfigurableproperties {\n");
    
    sb.append("    isAutoScalableEnabled: ").append(toIndentedString(isAutoScalableEnabled)).append("\n");
    sb.append("    isAutoHealEnabled: ").append(toIndentedString(isAutoHealEnabled)).append("\n");
    sb.append("    additionalConfigurableProperty: ").append(toIndentedString(additionalConfigurableProperty)).append("\n");
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
