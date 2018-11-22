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
package it.nextworks.nfvmano.libs.descriptors.vnfd.nodes.VnfVirtualLink;

//@Entity
public class VnfVirtualLinkCapabilities /*implements DescriptorInformationElement*/ {

	/*@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;

	@OneToOne
	@JsonIgnore
	private VnfVirtualLinkNode vnfVirtualLinkNode;

	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<String> monitoringParameter = new ArrayList<>();

	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<String> virtualLinkable = new ArrayList<>();

	public VnfVirtualLinkCapabilities() {

	}

	public VnfVirtualLinkCapabilities(List<String> monitoringParameter, List<String> virtualLinkable) {
		this.monitoringParameter = monitoringParameter;
		this.virtualLinkable = virtualLinkable;
	}

	public VnfVirtualLinkCapabilities(VnfVirtualLinkNode vnfVlNode, List<String> monitoringParameter) {
		this.vnfVirtualLinkNode = vnfVlNode;
		this.monitoringParameter = monitoringParameter;
	}

	public VnfVirtualLinkCapabilities(VnfVirtualLinkNode vnfVlNode, List<String> monitoringParameter,
			List<String> virtualLinkable) {
		this.vnfVirtualLinkNode = vnfVlNode;
		this.monitoringParameter = monitoringParameter;
		this.virtualLinkable = virtualLinkable;
	}

	public Long getId() {
		return id;
	}

	public VnfVirtualLinkNode getVnfVirtualLinkNode() {
		return vnfVirtualLinkNode;
	}

	@JsonProperty("monitoringParameter")
	public List<String> getMonitoringParameter() {
		return monitoringParameter;
	}

	@JsonProperty("virtualLinkable")
	public List<String> getVirtualLinkable() {
		return virtualLinkable;
	}

	@Override
	public void isValid() throws MalformattedElementException {

	}*/

}
