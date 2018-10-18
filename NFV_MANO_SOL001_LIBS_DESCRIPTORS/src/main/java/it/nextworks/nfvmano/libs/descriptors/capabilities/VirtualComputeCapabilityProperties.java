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
package it.nextworks.nfvmano.libs.descriptors.capabilities;

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
import it.nextworks.nfvmano.libs.descriptors.elements.VirtualCpu;
import it.nextworks.nfvmano.libs.descriptors.elements.VirtualMemory;

@Entity
public class VirtualComputeCapabilityProperties implements DescriptorInformationElement {

	@Id
	@GeneratedValue
	@JsonIgnore
	Long id;

	@OneToOne
	@JsonIgnore
	private VirtualComputeCapability virtualComputeCapability;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "properties", cascade = CascadeType.ALL, orphanRemoval = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private VirtualMemory virtualMemory;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "properties", cascade = CascadeType.ALL, orphanRemoval = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private VirtualCpu virtualCpu;

	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<String> virtualLocalStorage = new ArrayList<>();
	
	public VirtualComputeCapabilityProperties() {
		
	}

	public VirtualComputeCapabilityProperties(VirtualMemory virtualMemory, VirtualCpu virtualCpu,
			ArrayList<String> virtualLocalStorage) {
		this.virtualMemory = virtualMemory;
		this.virtualCpu = virtualCpu;
		this.virtualLocalStorage = virtualLocalStorage;
	}
	
	public VirtualComputeCapabilityProperties(VirtualComputeCapability capability, VirtualMemory virtualMemory, VirtualCpu virtualCpu,
			ArrayList<String> virtualLocalStorage) {
		this.virtualComputeCapability = capability;
		this.virtualMemory = virtualMemory;
		this.virtualCpu = virtualCpu;
		this.virtualLocalStorage = virtualLocalStorage;
	}

	public Long getId() {
		return id;
	}

	public VirtualComputeCapability getVirtualComputeCapability() {
		return virtualComputeCapability;
	}

	@JsonProperty("virtualMemory")
	public VirtualMemory getVirtualMemory() {
		return virtualMemory;
	}

	@JsonProperty("virtualCpu")
	public VirtualCpu getVirtualCpu() {
		return virtualCpu;
	}

	@JsonProperty("virtualLocalStorage")
	public List<String> getVirtualLocalStorage() {
		return virtualLocalStorage;
	}

	@Override
	public void isValid() throws MalformattedElementException {

	}

}
