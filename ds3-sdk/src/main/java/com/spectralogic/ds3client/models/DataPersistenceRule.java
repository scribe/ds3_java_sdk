/*
 * ******************************************************************************
 *   Copyright 2014-2015 Spectra Logic Corporation. All Rights Reserved.
 *   Licensed under the Apache License, Version 2.0 (the "License"). You may not use
 *   this file except in compliance with the License. A copy of the License is located at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *   or in the "license" file accompanying this file.
 *   This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 *   CONDITIONS OF ANY KIND, either express or implied. See the License for the
 *   specific language governing permissions and limitations under the License.
 * ****************************************************************************
 */

// This code is auto-generated, do not modify
package com.spectralogic.ds3client.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.UUID;
import com.spectralogic.ds3client.models.DataIsolationLevel;
import java.lang.Integer;
import com.spectralogic.ds3client.models.DataPersistenceRuleState;
import com.spectralogic.ds3client.models.DataPersistenceRuleType;

public class DataPersistenceRule {

    // Variables
    @JsonProperty("DataPolicyId")
    private UUID dataPolicyId;

    @JsonProperty("Id")
    private UUID id;

    @JsonProperty("IsolationLevel")
    private DataIsolationLevel isolationLevel;

    @JsonProperty("MinimumDaysToRetain")
    private Integer minimumDaysToRetain;

    @JsonProperty("State")
    private DataPersistenceRuleState state;

    @JsonProperty("StorageDomainId")
    private UUID storageDomainId;

    @JsonProperty("Type")
    private DataPersistenceRuleType type;

    // Constructor
    public DataPersistenceRule(final UUID dataPolicyId, final UUID id, final DataIsolationLevel isolationLevel, final Integer minimumDaysToRetain, final DataPersistenceRuleState state, final UUID storageDomainId, final DataPersistenceRuleType type) {
        this.dataPolicyId = dataPolicyId;
        this.id = id;
        this.isolationLevel = isolationLevel;
        this.minimumDaysToRetain = minimumDaysToRetain;
        this.state = state;
        this.storageDomainId = storageDomainId;
        this.type = type;
    }

    // Getters and Setters
    
    public UUID getDataPolicyId() {
        return this.dataPolicyId;
    }

    public void setDataPolicyId(final UUID dataPolicyId) {
        this.dataPolicyId = dataPolicyId;
    }


    public UUID getId() {
        return this.id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }


    public DataIsolationLevel getIsolationLevel() {
        return this.isolationLevel;
    }

    public void setIsolationLevel(final DataIsolationLevel isolationLevel) {
        this.isolationLevel = isolationLevel;
    }


    public Integer getMinimumDaysToRetain() {
        return this.minimumDaysToRetain;
    }

    public void setMinimumDaysToRetain(final Integer minimumDaysToRetain) {
        this.minimumDaysToRetain = minimumDaysToRetain;
    }


    public DataPersistenceRuleState getState() {
        return this.state;
    }

    public void setState(final DataPersistenceRuleState state) {
        this.state = state;
    }


    public UUID getStorageDomainId() {
        return this.storageDomainId;
    }

    public void setStorageDomainId(final UUID storageDomainId) {
        this.storageDomainId = storageDomainId;
    }


    public DataPersistenceRuleType getType() {
        return this.type;
    }

    public void setType(final DataPersistenceRuleType type) {
        this.type = type;
    }

}