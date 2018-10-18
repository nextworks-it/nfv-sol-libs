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
package it.nextworks.nfvmano.libs.descriptors.elements;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.descriptors.vnfd.nodes.VNF.VNFProperties;

@Entity
public class VnfInfoModifiableAttributes implements DescriptorInformationElement {

	@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;

	@OneToOne
	@JsonIgnore
	private VNFProperties vnfProperties;

	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Map<String, String> extension = new HashMap<String, String>();

	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private Map<String, String> metadata = new HashMap<String, String>();

	public VnfInfoModifiableAttributes() {
	}
	
	public VnfInfoModifiableAttributes(Map<String, String> extension,
			Map<String, String> metadata) {
		if (extension != null)
			this.extension = extension;
		if (metadata != null)
			this.metadata = metadata;
	}

	public VnfInfoModifiableAttributes(VNFProperties vnfProperties, Map<String, String> extension,
			Map<String, String> metadata) {
		this.vnfProperties = vnfProperties;
		if (extension != null)
			this.extension = extension;
		if (metadata != null)
			this.metadata = metadata;
	}

	public Long getId() {
		return id;
	}

	public VNFProperties getVnfProperties() {
		return vnfProperties;
	}

	@JsonProperty("extension")
	public Map<String, String> getExtension() {
		return extension;
	}

	@JsonProperty("metadata")
	public Map<String, String> getMetadata() {
		return metadata;
	}

	@Override
	public void isValid() throws MalformattedElementException {
	}

}
