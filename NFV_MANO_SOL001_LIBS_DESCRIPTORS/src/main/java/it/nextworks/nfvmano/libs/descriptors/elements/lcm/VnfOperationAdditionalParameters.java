package it.nextworks.nfvmano.libs.descriptors.elements.lcm;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonProperty;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

@Embeddable
public class VnfOperationAdditionalParameters implements DescriptorInformationElement {

	private String parameter;

	public VnfOperationAdditionalParameters() {

	}

	public VnfOperationAdditionalParameters(String parameter) {
		this.parameter = parameter;
	}

	@JsonProperty("parameter")
	public String getParameter() {
		return parameter;
	}

	@Override
	public void isValid() throws MalformattedElementException {

	}

}
