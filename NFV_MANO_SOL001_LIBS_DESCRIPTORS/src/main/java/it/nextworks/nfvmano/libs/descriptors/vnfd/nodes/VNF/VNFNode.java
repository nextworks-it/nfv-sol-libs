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
package it.nextworks.nfvmano.libs.descriptors.vnfd.nodes.VNF;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.descriptors.templates.Node;
import it.nextworks.nfvmano.libs.descriptors.templates.TopologyTemplate;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;

@Entity
public class VNFNode extends Node implements DescriptorInformationElement {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "vnfNode", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private VNFProperties properties;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "vnfNode", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private VNFRequirements requirements;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "vnfNode", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private VNFCapabilities capabilities;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne(fetch = FetchType.EAGER, mappedBy = "vnfNode", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private VNFInterfaces interfaces;

    public VNFNode() {

    }

    public VNFNode(String type, String name, VNFProperties properties, VNFRequirements requirements,
                   VNFCapabilities capabilities, VNFInterfaces interfaces) {
        super(type);
        this.properties = properties;
        this.requirements = requirements;
        this.capabilities = capabilities;
        this.interfaces = interfaces;
    }

    public VNFNode(TopologyTemplate topologyTemplate, String type, String name, VNFProperties properties,
                   VNFRequirements requirements, VNFCapabilities capabilities, VNFInterfaces interfaces) {
        super(topologyTemplate, type);
        this.properties = properties;
        this.requirements = requirements;
        this.capabilities = capabilities;
        this.interfaces = interfaces;
    }

    @JsonProperty("properties")
    public VNFProperties getProperties() {
        return properties;
    }

    @JsonProperty("requirements")
    public VNFRequirements getRequirements() {
        return requirements;
    }

    @JsonProperty("capabilities")
    public VNFCapabilities getCapabilities() {
        return capabilities;
    }

    @JsonProperty("interfaces")
    public VNFInterfaces getInterfaces() {
        return interfaces;
    }

    @Override
    public void isValid() throws MalformattedElementException {
        if (this.properties == null)
            throw new MalformattedElementException("VNF Node without properties");
        else
            this.properties.isValid();
        if (this.requirements == null)
            throw new MalformattedElementException("VNF Node without requirements");
        else
            this.requirements.isValid();
        if (this.capabilities != null)
            this.capabilities.isValid();
    }

    public void setProperties(VNFProperties vnfProperties) {
        this.properties = vnfProperties;
    }

    public void setRequirements(VNFRequirements vnfRequirements) {
        this.requirements = vnfRequirements;
    }
}
