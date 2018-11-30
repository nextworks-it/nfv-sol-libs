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
package it.nextworks.nfvmano.libs.descriptors.vnfd.nodes.VDU;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class VDUVirtualFileStorageRequirements implements DescriptorInformationElement {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @OneToOne
    @JsonIgnore
    private VDUVirtualFileStorageNode vduStorageNode;

    @ElementCollection(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    private List<String> virtualLink = new ArrayList<>();

    public VDUVirtualFileStorageRequirements() {

    }

    public VDUVirtualFileStorageRequirements(VDUVirtualFileStorageNode vduStorageNode, List<String> virtualLink) {
        this.vduStorageNode = vduStorageNode;
        this.virtualLink = virtualLink;
    }

    public Long getId() {
        return id;
    }

    public VDUVirtualFileStorageNode getVduStorageNode() {
        return vduStorageNode;
    }

    @JsonProperty("virtualLink")
    public List<String> getVirtualLink() {
        return virtualLink;
    }

    @Override
    public void isValid() throws MalformattedElementException {
        if (virtualLink == null || virtualLink.isEmpty())
            throw new MalformattedElementException("VDUVirtualFileStorageNode Node requirements without virtualLink");
    }

}
