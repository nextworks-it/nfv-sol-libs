package it.nextworks.nfvmano.libs.descriptors.groups;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;
import it.nextworks.nfvmano.libs.descriptors.templates.Group;
import it.nextworks.nfvmano.libs.descriptors.templates.TopologyTemplate;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import java.util.List;

/*@Entity
@JsonTypeName("PlacementGroup")*/
public class PlacementGroup extends Group {

    /*@Embedded
    private PlacementGroupProperties properties;

    public PlacementGroup(PlacementGroupProperties properties) {
        this.properties = properties;
    }

    public PlacementGroup(String type, List<String> members, PlacementGroupProperties properties) {
        super(type, members);
        this.properties = properties;
    }

    public PlacementGroup(TopologyTemplate topologyTemplate, String type, List<String> members, PlacementGroupProperties properties) {
        super(topologyTemplate, type, members);
        this.properties = properties;
    }

    @JsonProperty("properties")
    public PlacementGroupProperties getProperties() {
        return properties;
    }

    @Override
    public void isValid() throws MalformattedElementException {
        super.isValid();
        if (this.properties == null)
            throw new MalformattedElementException("PlacementGroup without properties");
        else
            this.properties.isValid();
    }*/


}
