package it.nextworks.nfvmano.libs.descriptors.sol006;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.validation.annotation.Validated;


/**
 * References a VnfProfile or NsProfile.
 */
//@Schema(description = "References a VnfProfile or NsProfile.")

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-09T19:09:38.446+01:00[Europe/Rome]")


public class NsdSecondaryid   {
  @JsonProperty("secondary-ns-profile")
  private NsdSecondaryidSecondarynsprofile secondaryNsProfile = null;

  @JsonProperty("secondary-vnf-profile")
  private NsdSecondaryidSecondaryvnfprofile secondaryVnfProfile = null;

  public NsdSecondaryid secondaryNsProfile(NsdSecondaryidSecondarynsprofile secondaryNsProfile) {
    this.secondaryNsProfile = secondaryNsProfile;
    return this;
  }

  /**
   * Get secondaryNsProfile
   * @return secondaryNsProfile
   **/
  //@Schema(description = "")
  

    public NsdSecondaryidSecondarynsprofile getSecondaryNsProfile() {
    return secondaryNsProfile;
  }

  public void setSecondaryNsProfile(NsdSecondaryidSecondarynsprofile secondaryNsProfile) {
    this.secondaryNsProfile = secondaryNsProfile;
  }

  public NsdSecondaryid secondaryVnfProfile(NsdSecondaryidSecondaryvnfprofile secondaryVnfProfile) {
    this.secondaryVnfProfile = secondaryVnfProfile;
    return this;
  }

  /**
   * Get secondaryVnfProfile
   * @return secondaryVnfProfile
   **/
  //@Schema(description = "")
  

    public NsdSecondaryidSecondaryvnfprofile getSecondaryVnfProfile() {
    return secondaryVnfProfile;
  }

  public void setSecondaryVnfProfile(NsdSecondaryidSecondaryvnfprofile secondaryVnfProfile) {
    this.secondaryVnfProfile = secondaryVnfProfile;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NsdSecondaryid nsdSecondaryid = (NsdSecondaryid) o;
    return Objects.equals(this.secondaryNsProfile, nsdSecondaryid.secondaryNsProfile) &&
        Objects.equals(this.secondaryVnfProfile, nsdSecondaryid.secondaryVnfProfile);
  }

  @Override
  public int hashCode() {
    return Objects.hash(secondaryNsProfile, secondaryVnfProfile);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NsdSecondaryid {\n");
    
    sb.append("    secondaryNsProfile: ").append(toIndentedString(secondaryNsProfile)).append("\n");
    sb.append("    secondaryVnfProfile: ").append(toIndentedString(secondaryVnfProfile)).append("\n");
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
