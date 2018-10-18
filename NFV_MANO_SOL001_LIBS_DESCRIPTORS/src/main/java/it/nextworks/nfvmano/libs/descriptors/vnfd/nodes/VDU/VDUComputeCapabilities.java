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
package it.nextworks.nfvmano.libs.descriptors.vnfd.nodes.VDU;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.descriptors.capabilities.VirtualComputeCapability;

@Entity
public class VDUComputeCapabilities implements DescriptorInformationElement {

	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;

	@OneToOne
	@JsonIgnore
	private VDUComputeNode vduComputeNode;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "capabilities", cascade = CascadeType.ALL, orphanRemoval = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private VirtualComputeCapability virtualComputeCapability;

	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<String> virtualBinding = new ArrayList<>();

	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<String> monitoringParameters = new ArrayList<>();

	public VDUComputeCapabilities() {

	}
	
	public VDUComputeCapabilities(VirtualComputeCapability virtualComputeCapability) {
		this.virtualComputeCapability = virtualComputeCapability;
	}

	public VDUComputeCapabilities(VDUComputeNode vduComputeNode, VirtualComputeCapability virtualComputeCapability) {
		this.vduComputeNode = vduComputeNode;
		this.virtualComputeCapability = virtualComputeCapability;
	}

	public Long getId() {
		return id;
	}

	public VDUComputeNode getVduComputeNode() {
		return vduComputeNode;
	}

	@JsonProperty("virtualComputeCapability")
	public VirtualComputeCapability getVirtualComputeCapability() {
		return virtualComputeCapability;
	}

	@JsonProperty("virtualCompute")
	public VirtualComputeCapability getVirtualCompute() {
		return this.virtualComputeCapability;
	}

	@JsonProperty("virtualBinding")
	public List<String> getVirtualBinding() {
		return virtualBinding;
	}

	@JsonProperty("monitoringParameters")
	public List<String> getMonitoringParameters() {
		return monitoringParameters;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (this.virtualComputeCapability == null)
			throw new MalformattedElementException("VDUCompute Node capabilities without virtualCompute");
		if (this.virtualBinding == null || this.virtualBinding.isEmpty())
			throw new MalformattedElementException("VDUCompute Node capabilities without virtualBInding");
	}

}
