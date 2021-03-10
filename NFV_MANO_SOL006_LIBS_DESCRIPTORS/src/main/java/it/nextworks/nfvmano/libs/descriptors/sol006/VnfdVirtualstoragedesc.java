package it.nextworks.nfvmano.libs.descriptors.sol006;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import org.springframework.validation.annotation.Validated;


/**
 * VnfdVirtualstoragedesc
 */

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2021-03-09T19:09:38.446+01:00[Europe/Rome]")


public class VnfdVirtualstoragedesc   {
  @JsonProperty("type-of-storage")
  private String typeOfStorage = null;

  @JsonProperty("rdma-enabled")
  private Boolean rdmaEnabled = null;

  @JsonProperty("size-of-storage")
  private String sizeOfStorage = null;

  @JsonProperty("vdu-storage-requirements")

  private List<VnfdVdustoragerequirements> vduStorageRequirements = null;

  @JsonProperty("sw-image-desc")
  private String swImageDesc = null;

  @JsonProperty("id")
  private String id = null;

  public VnfdVirtualstoragedesc typeOfStorage(String typeOfStorage) {
    this.typeOfStorage = typeOfStorage;
    return this;
  }

  /**
   * Type of virtualised storage resource (e.g. volume, object).
   * @return typeOfStorage
   **/
  //@Schema(description = "Type of virtualised storage resource (e.g. volume, object).")
  
    public String getTypeOfStorage() {
    return typeOfStorage;
  }

  public void setTypeOfStorage(String typeOfStorage) {
    this.typeOfStorage = typeOfStorage;
  }

  public VnfdVirtualstoragedesc rdmaEnabled(Boolean rdmaEnabled) {
    this.rdmaEnabled = rdmaEnabled;
    return this;
  }

  /**
   * Indicate if the storage support RDMA.
   * @return rdmaEnabled
   **/
  //@Schema(description = "Indicate if the storage support RDMA.")
  
    public Boolean isRdmaEnabled() {
    return rdmaEnabled;
  }

  public void setRdmaEnabled(Boolean rdmaEnabled) {
    this.rdmaEnabled = rdmaEnabled;
  }

  public VnfdVirtualstoragedesc sizeOfStorage(String sizeOfStorage) {
    this.sizeOfStorage = sizeOfStorage;
    return this;
  }

  /**
   * Size of virtualised storage resource (e.g. size of volume, in GB)
   * @return sizeOfStorage
   **/
  //@Schema(description = "Size of virtualised storage resource (e.g. size of volume, in GB)")
  
    public String getSizeOfStorage() {
    return sizeOfStorage;
  }

  public void setSizeOfStorage(String sizeOfStorage) {
    this.sizeOfStorage = sizeOfStorage;
  }

  public VnfdVirtualstoragedesc vduStorageRequirements(List<VnfdVdustoragerequirements> vduStorageRequirements) {
    this.vduStorageRequirements = vduStorageRequirements;
    return this;
  }

  public VnfdVirtualstoragedesc addVduStorageRequirementsItem(VnfdVdustoragerequirements vduStorageRequirementsItem) {
    if (this.vduStorageRequirements == null) {
      this.vduStorageRequirements = new ArrayList<VnfdVdustoragerequirements>();
    }
    this.vduStorageRequirements.add(vduStorageRequirementsItem);
    return this;
  }

  /**
   * Array of key-value pairs that articulate the storage deployment requirements.
   * @return vduStorageRequirements
   **/
  //@Schema(description = "Array of key-value pairs that articulate the storage deployment requirements.")

    public List<VnfdVdustoragerequirements> getVduStorageRequirements() {
    return vduStorageRequirements;
  }

  public void setVduStorageRequirements(List<VnfdVdustoragerequirements> vduStorageRequirements) {
    this.vduStorageRequirements = vduStorageRequirements;
  }

  public VnfdVirtualstoragedesc swImageDesc(String swImageDesc) {
    this.swImageDesc = swImageDesc;
    return this;
  }

  /**
   * Software image to be loaded on the VirtualStorage resource created based on this VirtualStorageDesc.
   * @return swImageDesc
   **/
  //@Schema(description = "Software image to be loaded on the VirtualStorage resource created based on this VirtualStorageDesc.")
  
    public String getSwImageDesc() {
    return swImageDesc;
  }

  public void setSwImageDesc(String swImageDesc) {
    this.swImageDesc = swImageDesc;
  }

  public VnfdVirtualstoragedesc id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of this VirtualStorageDesc in the VNFD.
   * @return id
   **/
  //@Schema(description = "Unique identifier of this VirtualStorageDesc in the VNFD.")
  
    public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VnfdVirtualstoragedesc vnfdVirtualstoragedesc = (VnfdVirtualstoragedesc) o;
    return Objects.equals(this.typeOfStorage, vnfdVirtualstoragedesc.typeOfStorage) &&
        Objects.equals(this.rdmaEnabled, vnfdVirtualstoragedesc.rdmaEnabled) &&
        Objects.equals(this.sizeOfStorage, vnfdVirtualstoragedesc.sizeOfStorage) &&
        Objects.equals(this.vduStorageRequirements, vnfdVirtualstoragedesc.vduStorageRequirements) &&
        Objects.equals(this.swImageDesc, vnfdVirtualstoragedesc.swImageDesc) &&
        Objects.equals(this.id, vnfdVirtualstoragedesc.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(typeOfStorage, rdmaEnabled, sizeOfStorage, vduStorageRequirements, swImageDesc, id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VnfdVirtualstoragedesc {\n");
    
    sb.append("    typeOfStorage: ").append(toIndentedString(typeOfStorage)).append("\n");
    sb.append("    rdmaEnabled: ").append(toIndentedString(rdmaEnabled)).append("\n");
    sb.append("    sizeOfStorage: ").append(toIndentedString(sizeOfStorage)).append("\n");
    sb.append("    vduStorageRequirements: ").append(toIndentedString(vduStorageRequirements)).append("\n");
    sb.append("    swImageDesc: ").append(toIndentedString(swImageDesc)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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
