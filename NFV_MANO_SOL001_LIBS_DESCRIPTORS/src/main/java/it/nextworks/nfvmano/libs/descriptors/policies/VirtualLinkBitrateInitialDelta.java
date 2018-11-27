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
package it.nextworks.nfvmano.libs.descriptors.policies;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.descriptors.templates.Policy;
import it.nextworks.nfvmano.libs.descriptors.templates.TopologyTemplate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.List;

@Entity
@JsonTypeName("VirtualLinkBitrateInitialDelta")
public class VirtualLinkBitrateInitialDelta extends Policy implements DescriptorInformationElement {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "virtualLinkBitrateInitialDelta", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private VirtualLinkBitrateInitialDeltaProperties properties;

    public VirtualLinkBitrateInitialDelta() {

    }

    public VirtualLinkBitrateInitialDelta(String type, List<String> targets, VirtualLinkBitrateInitialDeltaProperties properties) {
        super(type, targets);
        this.properties = properties;
    }

    public VirtualLinkBitrateInitialDelta(TopologyTemplate topologyTemplate, String type, List<String> targets, VirtualLinkBitrateInitialDeltaProperties properties) {
        super(topologyTemplate, type, targets);
        this.properties = properties;
    }

    @JsonProperty("properties")
    public VirtualLinkBitrateInitialDeltaProperties getProperties() {
        return properties;
    }

    @Override
    public void isValid() throws MalformattedElementException {
        if (this.properties == null)
            throw new MalformattedElementException("VirtualLinkBitrateInitialDelta without properties");
        else
            this.properties.isValid();
    }

}
