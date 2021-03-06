package it.nextworks.nfvmano.libs.descriptors.sol006;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * NsdScalingaspect
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-09T19:09:38.446+01:00[Europe/Rome]")

@Entity
public class NsdScalingaspect {

  @JsonIgnore
  @Id
  @GeneratedValue(generator = "uuid")
  @GenericGenerator(name = "uuid", strategy = "uuid2")
  private String uuid = null;

  @JsonProperty("id")
  private String id = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("scaling-level")
  private String scalingLevel = null;

  public NsdScalingaspect id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of this NsScalingAspect information element. It uniquely identifies the NS scaling aspect in an NSD.
   * @return id
   **/
  //@Schema(description = "Identifier of this NsScalingAspect information element. It uniquely identifies the NS scaling aspect in an NSD.")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public NsdScalingaspect description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Provides a human readable description of the NS scaling aspect.
   * @return description
   **/
  //@Schema(description = "Provides a human readable description of the NS scaling aspect.")
  
    public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public NsdScalingaspect name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Provides a human readable name of the NS scaling aspect.
   * @return name
   **/
  //@Schema(description = "Provides a human readable name of the NS scaling aspect.")
  
    public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public NsdScalingaspect scalingLevel(String scalingLevel) {
    this.scalingLevel = scalingLevel;
    return this;
  }

  /**
   * Describes the details of an NS level.
   * @return scalingLevel
   **/
  //@Schema(description = "Describes the details of an NS level.")
  
    public String getScalingLevel() {
    return scalingLevel;
  }

  public void setScalingLevel(String scalingLevel) {
    this.scalingLevel = scalingLevel;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NsdScalingaspect nsdScalingaspect = (NsdScalingaspect) o;
    return Objects.equals(this.id, nsdScalingaspect.id) &&
        Objects.equals(this.description, nsdScalingaspect.description) &&
        Objects.equals(this.name, nsdScalingaspect.name) &&
        Objects.equals(this.scalingLevel, nsdScalingaspect.scalingLevel);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, description, name, scalingLevel);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NsdScalingaspect {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    scalingLevel: ").append(toIndentedString(scalingLevel)).append("\n");
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
