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
import com.spectralogic.ds3client.models.WritePreferenceLevel;

public class CreatePoolStorageDomainMemberSpectraS3Request extends AbstractRequest {

    // Variables
    
    private final String storageDomainMember;

    private final UUID poolPartitionId;

    private final UUID storageDomainId;

    private WritePreferenceLevel writePreference;

    // Constructor
    public CreatePoolStorageDomainMemberSpectraS3Request(final UUID poolPartitionId, final UUID storageDomainId, final String storageDomainMember) {
        this.storageDomainMember = storageDomainMember;
        this.poolPartitionId = poolPartitionId;
        this.storageDomainId = storageDomainId;
        
    }
    public CreatePoolStorageDomainMemberSpectraS3Request withWritePreference(final WritePreferenceLevel writePreference) {
        this.writePreference = writePreference;
        this.updateQueryParam("write_preference", writePreference.toString());
        return this;
    }


    @Override
    public HttpVerb getVerb() {
        return HttpVerb.PUT;
    }

    @Override
    public String getPath() {
        return "/_rest_/storage_domain_member/" + storageDomainMember;
    }
    
    public String getStorageDomainMember() {
        return this.storageDomainMember;
    }


    public UUID getPoolPartitionId() {
        return this.poolPartitionId;
    }


    public UUID getStorageDomainId() {
        return this.storageDomainId;
    }


    public WritePreferenceLevel getWritePreference() {
        return this.writePreference;
    }

}