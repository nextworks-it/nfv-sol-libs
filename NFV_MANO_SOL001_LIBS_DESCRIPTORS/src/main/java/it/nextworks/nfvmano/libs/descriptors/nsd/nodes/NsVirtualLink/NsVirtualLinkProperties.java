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
package it.nextworks.nfvmano.libs.descriptors.nsd.nodes.NsVirtualLink;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.elements.QoS;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.descriptors.elements.ConnectivityType;
import it.nextworks.nfvmano.libs.descriptors.elements.ServiceAvailability;
import it.nextworks.nfvmano.libs.descriptors.elements.VlProfile;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
public class NsVirtualLinkProperties implements DescriptorInformationElement {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @OneToOne
    @JsonIgnore
    private NsVirtualLinkNode nsVirtualLinkNode;

    private String provider;
    private String version;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "nsVLProperties", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private VlProfile vlProfile;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "properties", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ConnectivityType connectivityType;

    // TODO: Already included in vlProfile, look at next SOL001 release
    /*
     * @Embedded private QoS qos;
     */

    @Embedded
    private ServiceAvailability serviceAvailability;

    public NsVirtualLinkProperties() {

    }

    public NsVirtualLinkProperties(NsVirtualLinkNode nsVirtualLinkNode, String provider, String version,
                                   VlProfile vlProfile, ConnectivityType connectivityType, QoS qos, ServiceAvailability serviceAvailability) {
        this.nsVirtualLinkNode = nsVirtualLinkNode;
        this.provider = provider;
        this.version = version;
        this.vlProfile = vlProfile;
        this.connectivityType = connectivityType;
        // this.qos = qos;
        this.serviceAvailability = serviceAvailability;
    }

    public Long getId() {
        return id;
    }

    public NsVirtualLinkNode getNsVirtualLinkNode() {
        return nsVirtualLinkNode;
    }

    @JsonProperty("provider")
    public String getProvider() {
        return provider;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("vlProfile")
    public VlProfile getVlProfile() {
        return vlProfile;
    }

    @JsonProperty("connectivityType")
    public ConnectivityType getConnectivityType() {
        return connectivityType;
    }

    /*
     * @JsonProperty("qos") public QoS getQos() { return qos; }
     */

    @JsonProperty("serviceAvailability")
    public ServiceAvailability getServiceAvailability() {
        return serviceAvailability;
    }

    @Override
    public void isValid() throws MalformattedElementException {
        if (this.version == null)
            throw new MalformattedElementException("NsVirtualLink Node without version");
        if (this.vlProfile == null)
            throw new MalformattedElementException("NsVirtualLink Node without vlProfile");
        else
            this.vlProfile.isValid();
        if (this.connectivityType == null)
            throw new MalformattedElementException("NsVirtualLink Node without connectivityType");
        else
            this.connectivityType.isValid();
        /*
         * if (this.qos != null) this.qos.isValid();
         */
        if (this.serviceAvailability != null)
            this.serviceAvailability.isValid();
    }
}
