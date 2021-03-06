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
import it.nextworks.nfvmano.libs.descriptors.policies.SupportedVnfInterfaceProperties;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Map;

@Entity
public class InterfaceDetails implements DescriptorInformationElement {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @OneToOne
    @JsonIgnore
    private SupportedVnfInterfaceProperties supportedVnfInterfaceProperties;

    @Embedded
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private UriComponents uriComponents;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ElementCollection(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private Map<String, String> interfaceSpecificData;

    public InterfaceDetails() {
    }

    public InterfaceDetails(UriComponents uriComponents, Map<String, String> interfaceSpecificData) {
        this.uriComponents = uriComponents;
        this.interfaceSpecificData = interfaceSpecificData;
    }

    public InterfaceDetails(SupportedVnfInterfaceProperties supportedVnfInterfaceProperties, UriComponents uriComponents, Map<String, String> interfaceSpecificData) {
        this.supportedVnfInterfaceProperties = supportedVnfInterfaceProperties;
        this.uriComponents = uriComponents;
        this.interfaceSpecificData = interfaceSpecificData;
    }

    public Long getId() {
        return id;
    }

    public SupportedVnfInterfaceProperties getSupportedVnfInterfaceProperties() {
        return supportedVnfInterfaceProperties;
    }

    @JsonProperty("uriComponents")
    public UriComponents getUriComponents() {
        return uriComponents;
    }

    @JsonProperty("interfaceSpecificData")
    public Map<String, String> getInterfaceSpecificData() {
        return interfaceSpecificData;
    }


    @Override
    public void isValid() throws MalformattedElementException {

    }
}
