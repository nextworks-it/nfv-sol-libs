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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.descriptors.templates.Policy;
import it.nextworks.nfvmano.libs.descriptors.templates.TopologyTemplate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.util.List;

/*@Entity
@JsonTypeName("SecurityGroupRule")*/
public class SecurityGroupRule /*extends Policy implements DescriptorInformationElement*/ {

    /*@Embedded
    private SecurityGroupRuleProperties properties;

    public SecurityGroupRule() {

    }

    public SecurityGroupRule(String type, List<String> targets, SecurityGroupRuleProperties properties) {
        super(type, targets);
        this.properties = properties;
    }

    public SecurityGroupRule(TopologyTemplate topologyTemplate, String type, List<String> targets, SecurityGroupRuleProperties properties) {
        super(topologyTemplate, type, targets);
        this.properties = properties;
    }

    @JsonProperty("properties")
    public SecurityGroupRuleProperties getProperties() {
        return properties;
    }

    @Override
    public void isValid() throws MalformattedElementException {
        if (this.properties == null)
            throw new MalformattedElementException("SecurityGroupRule without properties");
        else
            this.properties.isValid();
    }*/

}
