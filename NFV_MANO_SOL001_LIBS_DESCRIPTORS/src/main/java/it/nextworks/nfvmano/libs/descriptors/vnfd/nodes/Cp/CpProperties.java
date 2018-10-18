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
package it.nextworks.nfvmano.libs.descriptors.vnfd.nodes.Cp;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.enums.CpRole;
import it.nextworks.nfvmano.libs.common.enums.LayerProtocol;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.descriptors.elements.CpProtocolData;

@Entity
@Inheritance
@DiscriminatorColumn(name = "CONNPOINT_TYPE")
public class CpProperties implements DescriptorInformationElement {

	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;

	@OneToOne
	@JsonIgnore
	private CpNode cpNode;

	private LayerProtocol layerProtocol;
	private CpRole role;
	private String description;

	@JsonInclude(JsonInclude.Include.NON_EMPTY)
	@OneToMany(mappedBy = "properties", cascade = CascadeType.ALL)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<CpProtocolData> protocolData = new ArrayList<>();

	private boolean trunkMode;

	public CpProperties() {

	}
	
	public CpProperties(LayerProtocol layerProtocol, CpRole role, String description,
			List<CpProtocolData> protocolData, boolean trunkMode) {
		this.layerProtocol = layerProtocol;
		this.role = role;
		this.description = description;
		this.protocolData = protocolData;
		this.trunkMode = trunkMode;
	}

	public CpProperties(CpNode cpNode, LayerProtocol layerProtocol, CpRole role, String description,
			List<CpProtocolData> protocolData, boolean trunkMode) {
		this.cpNode = cpNode;
		this.layerProtocol = layerProtocol;
		this.role = role;
		this.description = description;
		this.protocolData = protocolData;
		this.trunkMode = trunkMode;
	}

	public Long getId() {
		return id;
	}

	public CpNode getCpNode() {
		return cpNode;
	}

	@JsonProperty("layerProtocol")
	public LayerProtocol getLayerProtocol() {
		return layerProtocol;
	}

	@JsonProperty("role")
	public CpRole getRole() {
		return role;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("protocolData")
	public List<CpProtocolData> getProtocolData() {
		return protocolData;
	}

	@JsonProperty("trunkMode")
	public boolean isTrunkMode() {
		return trunkMode;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (this.layerProtocol == null)
			throw new MalformattedElementException("Cp Node properties without layerProtocol");
		if (this.protocolData == null || this.protocolData.isEmpty()) {
			throw new MalformattedElementException("Cp Node properties without protocolData");
		} else {
			for (CpProtocolData cpData : this.protocolData) {
				cpData.isValid();
			}
		}
	}
}
