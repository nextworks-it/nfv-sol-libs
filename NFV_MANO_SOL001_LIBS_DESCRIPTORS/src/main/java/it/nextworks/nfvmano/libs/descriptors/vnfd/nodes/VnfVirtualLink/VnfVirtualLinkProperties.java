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
public class VnfVirtualLinkProperties /*implements DescriptorInformationElement*/ {

	/*@Id
	@GeneratedValue
	@JsonIgnore
	private Long id;

	@OneToOne
	@JsonIgnore
	private VnfVirtualLinkNode vnfVirtualLinkNode;

	@Embedded
	private ConnectivityType connectivityType;

	@ElementCollection(fetch = FetchType.EAGER)
	@Fetch(FetchMode.SELECT)
	@Cascade(org.hibernate.annotations.CascadeType.ALL)
	private List<TestAccess> testAccess = new ArrayList<>();

	private String description;

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@OneToOne(fetch = FetchType.EAGER, mappedBy = "vnfVLProperties", cascade = CascadeType.ALL, orphanRemoval = true)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private VlProfile vlProfile;

	public VnfVirtualLinkProperties() {
	}

	public VnfVirtualLinkProperties(VnfVirtualLinkNode vnfVirtualLinkNode, ConnectivityType connectivityType,
			List<TestAccess> testAccess, String description, VlProfile vlProfile) {
		this.vnfVirtualLinkNode = vnfVirtualLinkNode;
		this.connectivityType = connectivityType;
		this.testAccess = testAccess;
		this.description = description;
		this.vlProfile = vlProfile;
	}

	public Long getId() {
		return id;
	}

	public VnfVirtualLinkNode getVnfVirtualLinkNode() {
		return vnfVirtualLinkNode;
	}

	@JsonProperty("connectivityType")
	public ConnectivityType getConnectivityType() {
		return connectivityType;
	}

	@JsonProperty("testAccess")
	public List<TestAccess> getTestAccess() {
		return testAccess;
	}

	@JsonProperty("description")
	public String getDescription() {
		return description;
	}

	@JsonProperty("vlProfile")
	public VlProfile getVlProfile() {
		return vlProfile;
	}

	@Override
	public void isValid() throws MalformattedElementException {
		if (this.testAccess != null) {
			for (TestAccess testAccess : this.testAccess) {
				if (testAccess != TestAccess.NONE && testAccess != TestAccess.ACTIVE_LOOPBACK
						&& testAccess != TestAccess.PASSIVE_MONITORING)
					throw new MalformattedElementException("Wrong testAccess values in VFN VL Properties");
			}
		}

		if (this.connectivityType == null)
			throw new MalformattedElementException("ConnectivityType is missing in VFN VL Properties");
		else
			this.connectivityType.isValid();

		if (this.vlProfile == null)
			throw new MalformattedElementException("VlProfile is missing in VFN VL Properties");
		else
			this.vlProfile.isValid();
	}*/

}
