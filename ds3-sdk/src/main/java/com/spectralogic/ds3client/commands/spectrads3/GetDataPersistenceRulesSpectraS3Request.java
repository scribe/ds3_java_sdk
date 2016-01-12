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
package com.spectralogic.ds3client.commands.spectrads3;

import com.spectralogic.ds3client.commands.AbstractRequest;
import com.spectralogic.ds3client.HttpVerb;
import java.util.UUID;
import com.spectralogic.ds3client.models.DataIsolationLevel;
import com.spectralogic.ds3client.models.DataPersistenceRuleState;
import com.spectralogic.ds3client.models.DataPersistenceRuleType;

public class GetDataPersistenceRulesSpectraS3Request extends AbstractRequest {

    // Variables
    
    private final String dataPersistenceRule;

    private UUID dataPolicyId;
    private DataIsolationLevel isolationLevel;
    private boolean lastPage;
    private int pageLength;
    private int pageOffset;
    private UUID pageStartMarker;
    private DataPersistenceRuleState state;
    private UUID storageDomainId;
    private DataPersistenceRuleType type;

    // Constructor
    public GetDataPersistenceRulesSpectraS3Request(final String dataPersistenceRule) {
        this.dataPersistenceRule = dataPersistenceRule;
        
    }
    public GetDataPersistenceRulesSpectraS3Request withDataPolicyId(final UUID dataPolicyId) {
        this.dataPolicyId = dataPolicyId;
        this.updateQueryParam("data_policy_id", dataPolicyId.toString());
        return this;
    }

    public GetDataPersistenceRulesSpectraS3Request withIsolationLevel(final DataIsolationLevel isolationLevel) {
        this.isolationLevel = isolationLevel;
        this.updateQueryParam("isolation_level", isolationLevel.toString());
        return this;
    }

    public GetDataPersistenceRulesSpectraS3Request withLastPage(final boolean lastPage) {
        this.lastPage = lastPage;
        if (this.lastPage) {
            this.getQueryParams().put("last_page", null);
        } else {
            this.getQueryParams().remove("last_page");
        }
        return this;
    }

    public GetDataPersistenceRulesSpectraS3Request withPageLength(final int pageLength) {
        this.pageLength = pageLength;
        this.updateQueryParam("page_length", Integer.toString(pageLength));
        return this;
    }

    public GetDataPersistenceRulesSpectraS3Request withPageOffset(final int pageOffset) {
        this.pageOffset = pageOffset;
        this.updateQueryParam("page_offset", Integer.toString(pageOffset));
        return this;
    }

    public GetDataPersistenceRulesSpectraS3Request withPageStartMarker(final UUID pageStartMarker) {
        this.pageStartMarker = pageStartMarker;
        this.updateQueryParam("page_start_marker", pageStartMarker.toString());
        return this;
    }

    public GetDataPersistenceRulesSpectraS3Request withState(final DataPersistenceRuleState state) {
        this.state = state;
        this.updateQueryParam("state", state.toString());
        return this;
    }

    public GetDataPersistenceRulesSpectraS3Request withStorageDomainId(final UUID storageDomainId) {
        this.storageDomainId = storageDomainId;
        this.updateQueryParam("storage_domain_id", storageDomainId.toString());
        return this;
    }

    public GetDataPersistenceRulesSpectraS3Request withType(final DataPersistenceRuleType type) {
        this.type = type;
        this.updateQueryParam("type", type.toString());
        return this;
    }


    @Override
    public HttpVerb getVerb() {
        return HttpVerb.GET;
    }

    @Override
    public String getPath() {
        return "/_rest_/data_persistence_rule/" + dataPersistenceRule;
    }
    
    public String getDataPersistenceRule() {
        return this.dataPersistenceRule;
    }


    public UUID getDataPolicyId() {
        return this.dataPolicyId;
    }

    public DataIsolationLevel getIsolationLevel() {
        return this.isolationLevel;
    }

    public boolean getLastPage() {
        return this.lastPage;
    }

    public int getPageLength() {
        return this.pageLength;
    }

    public int getPageOffset() {
        return this.pageOffset;
    }

    public UUID getPageStartMarker() {
        return this.pageStartMarker;
    }

    public DataPersistenceRuleState getState() {
        return this.state;
    }

    public UUID getStorageDomainId() {
        return this.storageDomainId;
    }

    public DataPersistenceRuleType getType() {
        return this.type;
    }

}