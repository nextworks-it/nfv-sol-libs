package it.nextworks.nfvmano.libs.descriptors.templates;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.org.apache.xpath.internal.operations.String;
import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SubstitutionMappingCapabilities implements DescriptorInformationElement {

    @Id
    @GeneratedValue
    @JsonIgnore
    Long id;

    @OneToOne
    @JsonIgnore
    private SubstitutionMapping subMapping;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ElementCollection(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    List<String> virtualCompute = new ArrayList<>();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ElementCollection(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    List<String> virtualStorage = new ArrayList<>();

    public SubstitutionMappingCapabilities() {
    }

    public SubstitutionMappingCapabilities(SubstitutionMapping subMapping, List<String> virtualCompute, List<String> virtualStorage) {
        this.subMapping = subMapping;
        this.virtualCompute = virtualCompute;
        this.virtualStorage = virtualStorage;

    }

    public Long getId() {
        return id;
    }

    public SubstitutionMapping getSubMapping() {
        return subMapping;
    }

    @JsonProperty("virtualCompute")
    public List<String> getVirtualCompute() {
        return virtualCompute;
    }

    @JsonProperty("virtualStorage")
    public List<String> getVirtualStorage() {
        return virtualStorage;
    }

    @Override
    public void isValid() throws MalformattedElementException {

    }
}
