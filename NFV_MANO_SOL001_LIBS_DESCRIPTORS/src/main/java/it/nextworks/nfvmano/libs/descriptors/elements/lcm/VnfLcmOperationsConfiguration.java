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
package it.nextworks.nfvmano.libs.descriptors.elements.lcm;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import it.nextworks.nfvmano.libs.common.DescriptorInformationElement;
import it.nextworks.nfvmano.libs.common.exceptions.MalformattedElementException;

//@Entity
public class VnfLcmOperationsConfiguration /* implements DescriptorInformationElement */ {

//	@Id
//	@GeneratedValue
//	@JsonIgnore
//	private Long id;
//
//	@OneToOne(fetch = FetchType.EAGER, mappedBy = "config", cascade = CascadeType.ALL, orphanRemoval = true)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	private InstantiateVnfOpConfig instantiateVnfOpConfig;
//
//	@OneToOne(fetch = FetchType.EAGER, mappedBy = "config", cascade = CascadeType.ALL, orphanRemoval = true)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	private ScaleVnfOpConfig scaleVnfOpConfig;
//
//	@OneToOne(fetch = FetchType.EAGER, mappedBy = "config", cascade = CascadeType.ALL, orphanRemoval = true)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	private ScaleVnfToLevelOpConfig scaleVnfToLevelOpConfig;
//
//	@OneToOne(fetch = FetchType.EAGER, mappedBy = "config", cascade = CascadeType.ALL, orphanRemoval = true)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	private ChangeVnfFlavourOpConfig changeVnfFlavourOpConfig;
//
//	@OneToOne(fetch = FetchType.EAGER, mappedBy = "config", cascade = CascadeType.ALL, orphanRemoval = true)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	private HealVnfOpConfig healVnfOpConfig;
//
//	@Embedded
//	@JsonInclude(JsonInclude.Include.NON_NULL)
//	@AttributeOverrides({
//			@AttributeOverride(name = "minGracefulStopTimeout", column = @Column(name = "minGracefulStopTimeoutOp")),
//			@AttributeOverride(name = "maxRecommendedGracefulStopTimeout", column = @Column(name = "maxRecommendedGracefulStopTimeoutOp")) })
//	private TerminateVnfOpConfig operateVnfOpConfig;
//
//	@Embedded
//	@JsonInclude(JsonInclude.Include.NON_NULL)
//	private TerminateVnfOpConfig terminateVnfOpConfig;
//
//	@OneToOne(fetch = FetchType.EAGER, mappedBy = "config", cascade = CascadeType.ALL, orphanRemoval = true)
//	@OnDelete(action = OnDeleteAction.CASCADE)
//	private ChangeExtVnfConnectivityOpConfig changeExtVnfConnectivityOpConfig;
//
//	public VnfLcmOperationsConfiguration() {
//	}
//
//	public VnfLcmOperationsConfiguration(TerminateVnfOpConfig operateVnfOpConfig,
//			TerminateVnfOpConfig terminateVnfOpConfig) {
//		this.operateVnfOpConfig = operateVnfOpConfig;
//		this.terminateVnfOpConfig = terminateVnfOpConfig;
//	}
//
//
//	public InstantiateVnfOpConfig getInstantiateVnfOpConfig() {
//		return instantiateVnfOpConfig;
//	}
//
//	public ScaleVnfOpConfig getScaleVnfOpConfig() {
//		return scaleVnfOpConfig;
//	}
//
//	public ScaleVnfToLevelOpConfig getScaleVnfToLevelOpConfig() {
//		return scaleVnfToLevelOpConfig;
//	}
//
//	public HealVnfOpConfig getHealVnfOpConfig() {
//		return healVnfOpConfig;
//	}
//
//	public TerminateVnfOpConfig getOperateVnfOpConfig() {
//		return operateVnfOpConfig;
//	}
//
//	public TerminateVnfOpConfig getTerminateVnfOpConfig() {
//		return terminateVnfOpConfig;
//	}
//
//	public ChangeVnfFlavourOpConfig getChangeVnfFlavourOpConfig() {
//		return changeVnfFlavourOpConfig;
//	}
//
//	public ChangeExtVnfConnectivityOpConfig getChangeExtVnfConnectivityOpConfig() {
//		return changeExtVnfConnectivityOpConfig;
//	}
//
//	@Override
//	public void isValid() throws MalformattedElementException {
//		if (operateVnfOpConfig != null)
//			operateVnfOpConfig.isValid();
//		if (instantiateVnfOpConfig != null)
//			instantiateVnfOpConfig.isValid();
//		if (terminateVnfOpConfig != null)
//			terminateVnfOpConfig.isValid();
//		if (scaleVnfOpConfig != null)
//			scaleVnfOpConfig.isValid();
//		if (scaleVnfToLevelOpConfig != null)
//			scaleVnfToLevelOpConfig.isValid();
//		if (healVnfOpConfig != null)
//			healVnfOpConfig.isValid();
//		if (changeVnfFlavourOpConfig != null)
//			changeVnfFlavourOpConfig.isValid();
//		if (changeExtVnfConnectivityOpConfig != null)
//			changeExtVnfConnectivityOpConfig.isValid();
//	}

}
