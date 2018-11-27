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
package it.nextworks.nfvmano.libs.descriptors.templates;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.descriptors.nsd.nodes.NS.NSNode;
import it.nextworks.nfvmano.libs.descriptors.nsd.nodes.NsVirtualLink.NsVirtualLinkNode;
import it.nextworks.nfvmano.libs.descriptors.nsd.nodes.Sap.SapNode;
import it.nextworks.nfvmano.libs.descriptors.vnfd.nodes.Cp.CpNode;
import it.nextworks.nfvmano.libs.descriptors.vnfd.nodes.VDU.VDUComputeNode;
import it.nextworks.nfvmano.libs.descriptors.vnfd.nodes.VDU.VDUVirtualBlockStorageNode;
import it.nextworks.nfvmano.libs.descriptors.vnfd.nodes.VNF.VNFNode;
import it.nextworks.nfvmano.libs.descriptors.vnfd.nodes.VduCp.VduCpNode;
import it.nextworks.nfvmano.libs.descriptors.vnfd.nodes.VnfExtCp.VnfExtCpNode;
import it.nextworks.nfvmano.libs.descriptors.vnfd.nodes.VnfVirtualLink.VnfVirtualLinkNode;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Entity
public class TopologyTemplate implements DescriptorInformationElement {

    @Id
    @GeneratedValue
    @JsonIgnore
    private Long id;

    @OneToOne
    @JsonIgnore
    private DescriptorTemplate descriptorTemplate;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "topologyTemplate", cascade = CascadeType.ALL, orphanRemoval = true)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private SubstitutionMapping substituitionMapping;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @OneToMany(mappedBy = "topologyTemplate", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Map<String, Node> nodeTemplates = new HashMap<>();

    @JsonInclude(JsonInclude.Include.NON_NULL)
    @OneToMany(mappedBy = "topologyTemplate", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Map<String, Relationship> relationshipTemplates = new HashMap<>();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @OneToMany(mappedBy = "topologyTemplate", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Map<String, Policy> policies = new HashMap<>();

    /*@JsonInclude(JsonInclude.Include.NON_EMPTY)
    @OneToMany(mappedBy = "topologyTemplate", cascade = CascadeType.ALL)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @LazyCollection(LazyCollectionOption.FALSE)
    private Map<String, Group> groups = new HashMap<>();*/

    public TopologyTemplate() {

    }

    public TopologyTemplate(DescriptorTemplate descriptorTemplate) {
        this.descriptorTemplate = descriptorTemplate;
    }

    public TopologyTemplate(DescriptorTemplate descriptorTemplate, SubstitutionMapping substitutionMapping, Map<String, Node> nodeTemplates,
                            Map<String, Relationship> relationshipTemplates, Map<String, Policy> policies/*, Map<String, Group> groups*/) {
        this.descriptorTemplate = descriptorTemplate;
        this.substituitionMapping = substitutionMapping;
        this.nodeTemplates = nodeTemplates;
        this.relationshipTemplates = relationshipTemplates;
        this.policies = policies;
        //this.groups = groups;
    }

    public Long getId() {
        return id;
    }

    public DescriptorTemplate getDescriptorTemplate() {
        return descriptorTemplate;
    }

    @JsonProperty("substitutionMapping")
    public SubstitutionMapping getSubstituitionMapping() {
        return substituitionMapping;
    }

    @JsonProperty("nodeTemplates")
    public Map<String, Node> getNodeTemplates() {
        return nodeTemplates;
    }

    @JsonProperty("relationshipTemplates")
    public Map<String, Relationship> getRelationshipTemplates() {
        return relationshipTemplates;
    }

    @JsonProperty("policies")
    public Map<String, Policy> getPolicies() {
        return policies;
    }

    /*@JsonProperty("groups")
    public Map<String, Group> getGroups() {
        return groups;
    }*/

    @JsonIgnore
    public Map<String, CpNode> getCPNodes() throws MalformattedElementException {

        return nodeTemplates.entrySet()
                .stream()
                .filter(e -> e.getValue() instanceof CpNode)
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (CpNode) e.getValue()));
    }

    @JsonIgnore
    public Map<String, SapNode> getSapNodes() throws MalformattedElementException {

        return nodeTemplates.entrySet()
                .stream()
                .filter(e -> e.getValue() instanceof SapNode)
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (SapNode) e.getValue()));
    }

    @JsonIgnore
    public Map<String, VduCpNode> getVduCpNodes() throws MalformattedElementException {

        return nodeTemplates.entrySet()
                .stream()
                .filter(e -> e.getValue() instanceof VduCpNode)
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (VduCpNode) e.getValue()));
    }

    @JsonIgnore
    public Map<String, VnfExtCpNode> getVnfExtCpNodes() throws MalformattedElementException {

        return nodeTemplates.entrySet()
                .stream()
                .filter(e -> e.getValue() instanceof VnfExtCpNode)
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (VnfExtCpNode) e.getValue()));
    }

    @JsonIgnore
    public Map<String, VDUComputeNode> getVDUComputeNodes() throws MalformattedElementException {

        return nodeTemplates.entrySet()
                .stream()
                .filter(e -> e.getValue() instanceof VDUComputeNode)
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (VDUComputeNode) e.getValue()));
    }

    @JsonIgnore
    public Map<String, VDUVirtualBlockStorageNode> getVDUStorageNodes() throws MalformattedElementException {

        return nodeTemplates.entrySet()
                .stream()
                .filter(e -> e.getValue() instanceof VDUVirtualBlockStorageNode)
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (VDUVirtualBlockStorageNode) e.getValue()));
    }

    @JsonIgnore
    public Map<String, VNFNode> getVNFNodes() throws MalformattedElementException {

        return nodeTemplates.entrySet()
                .stream()
                .filter(e -> e.getValue() instanceof VNFNode)
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (VNFNode) e.getValue()));
    }

    @JsonIgnore
    public Map<String, NSNode> getNSNodes() throws MalformattedElementException {

        return nodeTemplates.entrySet()
                .stream()
                .filter(e -> e.getValue() instanceof NSNode)
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (NSNode) e.getValue()));
    }

    @JsonIgnore
    public Map<String, NsVirtualLinkNode> getNsVirtualLinkNodes() throws MalformattedElementException {

        return nodeTemplates.entrySet()
                .stream()
                .filter(e -> e.getValue() instanceof NsVirtualLinkNode)
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (NsVirtualLinkNode) e.getValue()));
    }

    @JsonIgnore
    public Map<String, VnfVirtualLinkNode> getVnfVirtualLinkNodes() throws MalformattedElementException {

        return nodeTemplates.entrySet()
                .stream()
                .filter(e -> e.getValue() instanceof VnfVirtualLinkNode)
                .collect(Collectors.toMap(Map.Entry::getKey, e -> (VnfVirtualLinkNode) e.getValue()));
    }

    @Override
    public void isValid() throws MalformattedElementException {
        if (this.getNSNodes().isEmpty() && this.getVNFNodes().isEmpty()) {
            throw new MalformattedElementException(
                    "At least one between NS node and VNF node should be present");
        }

    }
}
