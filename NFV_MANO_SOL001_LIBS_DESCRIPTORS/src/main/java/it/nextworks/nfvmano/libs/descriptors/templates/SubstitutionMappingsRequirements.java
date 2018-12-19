package it.nextworks.nfvmano.libs.descriptors.templates;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
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
public class SubstitutionMappingsRequirements implements DescriptorInformationElement {

    @Id
    @GeneratedValue
    @JsonIgnore
    Long id;

    @OneToOne
    @JsonIgnore
    private SubstitutionMappings subMapping;

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ElementCollection(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    List<String> virtualLink = new ArrayList<>();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ElementCollection(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    List<String> virtualLinkBackend = new ArrayList<>();

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    @ElementCollection(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    List<String> virtualLinkService = new ArrayList<>();

    public SubstitutionMappingsRequirements() {
    }

    public SubstitutionMappingsRequirements(SubstitutionMappings subMapping, List<String> virtualLink, List<String> virtualLinkBackend, List<String> virtualLinkService) {
        this.subMapping = subMapping;
        this.virtualLink = virtualLink;
        this.virtualLinkBackend = virtualLinkBackend;
        this.virtualLinkService = virtualLinkService;
    }

    public Long getId() {
        return id;
    }

    public SubstitutionMappings getSubMapping() {
        return subMapping;
    }

    @JsonProperty("virtualLink")
    public List<String> getVirtualLink() {
        return virtualLink;
    }

    @JsonProperty("virtualLinkBackend")
    public List<String> getVirtualLinkBackend() {
        return virtualLinkBackend;
    }

    @JsonProperty("virtualLinkService")
    public List<String> getVirtualLinkService() {
        return virtualLinkService;
    }

    @Override
    public void isValid() throws MalformattedElementException {

    }
}
