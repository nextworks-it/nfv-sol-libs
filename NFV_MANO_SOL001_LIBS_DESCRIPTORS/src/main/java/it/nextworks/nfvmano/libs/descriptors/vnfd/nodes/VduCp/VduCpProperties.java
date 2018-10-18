/*
* Copyright 2018 Nextworks s.r.l.
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package it.nextworks.nfvmano.libs.descriptors.vnfd.nodes.VduCp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.descriptors.elements.CpProtocolData;
import it.nextworks.nfvmano.libs.descriptors.elements.VirtualNetworkInterfaceRequirements;
import it.nextworks.nfvmano.libs.descriptors.vnfd.nodes.Cp.CpProperties;
import it.nextworks.nfvmano.libs.common.enums.CpRole;
import it.nextworks.nfvmano.libs.common.enums.LayerProtocol;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

@Entity
@DiscriminatorValue("VDUCP")
public class VduCpProperties extends CpProperties {

	@OneToOne
	@JsonIgnore
	private VduCpNode vduCpNode;
	private Integer bitrateRequirement;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@OneToMany(mappedBy = "vduCpProperties", cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<VirtualNetworkInterfaceRequirements> virtualNetworkInterfaceRequirements = new ArrayList<>();
	private int vduCpOrder;

	public VduCpProperties() {

	}

	public VduCpProperties(VduCpNode vduCpNode, LayerProtocol layerProtocol, CpRole role, String description,
			List<CpProtocolData> protocolData, boolean trunkMode, Integer bitrateRequirement,
			List<VirtualNetworkInterfaceRequirements> virtualNetworkInterfaceRequirements, int vduCpOrder) {
		super(null, layerProtocol, role, description, protocolData, trunkMode);
		this.vduCpNode = vduCpNode;
		this.bitrateRequirement = bitrateRequirement;
		this.virtualNetworkInterfaceRequirements = virtualNetworkInterfaceRequirements;
		this.vduCpOrder = vduCpOrder;
	}

	@JsonProperty("bitrateRequirement")
	public Integer getBitrateRequirement() {
		return bitrateRequirement;
	}

	@JsonProperty("virtualNetworkInterfaceRequirements")
	public List<VirtualNetworkInterfaceRequirements> getVirtualNetworkInterfaceRequirements() {
		return virtualNetworkInterfaceRequirements;
	}

	@JsonProperty("order")
	public int getVduCpOrder() {
		return vduCpOrder;
	}
	
	public VduCpNode getVduCpNode() {
		return vduCpNode;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		super.isValid();
	}

}
