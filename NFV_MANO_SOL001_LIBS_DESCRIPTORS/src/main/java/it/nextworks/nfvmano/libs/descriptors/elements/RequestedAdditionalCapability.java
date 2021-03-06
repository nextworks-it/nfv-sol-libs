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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.descriptors.capabilities.VirtualComputeCapability;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;

@Entity
public class RequestedAdditionalCapability implements DescriptorInformationElement {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @ManyToOne
    @JsonIgnore
    private VirtualComputeCapability virtualComputeCapability;

    private String requestedAdditionalCapabilityName;
    private boolean supportMandatory;
    private String minRequestedAdditionalCapabilityVersion;
    private String preferredRequestedAdditionalCapabilityVersion;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ElementCollection(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Map<String, String> targetPerformanceParameters = new HashMap<String, String>();

    public RequestedAdditionalCapability() {
    }

    public RequestedAdditionalCapability(String requestedAdditionalCapabilityName, boolean supportMandatory, String minRequestedAdditionalCapabilityVersion, String preferredRequestedAdditionalCapabilityVersion,
                                         Map<String, String> targetParameter) {
        this.requestedAdditionalCapabilityName = requestedAdditionalCapabilityName;
        this.supportMandatory = supportMandatory;
        this.minRequestedAdditionalCapabilityVersion = minRequestedAdditionalCapabilityVersion;
        this.preferredRequestedAdditionalCapabilityVersion = preferredRequestedAdditionalCapabilityVersion;
        this.targetPerformanceParameters = targetParameter;
    }

    public RequestedAdditionalCapability(VirtualComputeCapability virtualComputeCapability, String requestedAdditionalCapabilityName, boolean supportMandatory, String minRequestedAdditionalCapabilityVersion, String preferredRequestedAdditionalCapabilityVersion, Map<String, String> targetPerformanceParameters) {
        this.virtualComputeCapability = virtualComputeCapability;
        this.requestedAdditionalCapabilityName = requestedAdditionalCapabilityName;
        this.supportMandatory = supportMandatory;
        this.minRequestedAdditionalCapabilityVersion = minRequestedAdditionalCapabilityVersion;
        this.preferredRequestedAdditionalCapabilityVersion = preferredRequestedAdditionalCapabilityVersion;
        this.targetPerformanceParameters = targetPerformanceParameters;
    }

    public Long getId() {
        return id;
    }

    public Map<String, String> getTargetPerformanceParameters() {
        return targetPerformanceParameters;
    }

    @JsonProperty("requestedAdditionalCapabilityName")
    public String getRequestedAdditionalCapabilityName() {
        return requestedAdditionalCapabilityName;
    }

    @JsonProperty("supportMandatory")
    public boolean getSupportMandatory() {
        return supportMandatory;
    }

    @JsonProperty("minRequestedAdditionalCapabilityVersion")
    public String getMinRequestedAdditionalCapabilityVersion() {
        return minRequestedAdditionalCapabilityVersion;
    }

    @JsonProperty("preferredRequestedAdditionalCapabilityVersion")
    public String getPreferredRequestedAdditionalCapabilityVersion() {
        return preferredRequestedAdditionalCapabilityVersion;
    }

    @JsonProperty("targetPerformanceParameters")
    public Map<String, String> getTargetParameter() {
        return targetPerformanceParameters;
    }

    @Override
    public void isValid() throws MalformattedElementException {
        if (Boolean.valueOf(this.supportMandatory) == null)
            throw new MalformattedElementException("RequestedAdditionalCapability without supportMandatory");
        if (this.requestedAdditionalCapabilityName == null)
            throw new MalformattedElementException("RequestedAdditionalCapability without requestedAdditionalCapabilityName");
        if (this.targetPerformanceParameters == null || this.targetPerformanceParameters.isEmpty())
            throw new MalformattedElementException("RequestedAdditionalCapability without targetPerformanceParameters");
    }

}
