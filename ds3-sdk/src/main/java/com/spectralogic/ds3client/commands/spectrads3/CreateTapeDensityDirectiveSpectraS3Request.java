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
import com.spectralogic.ds3client.models.TapeDriveType;
import java.util.UUID;
import com.spectralogic.ds3client.models.TapeType;

public class CreateTapeDensityDirectiveSpectraS3Request extends AbstractRequest {

    // Variables
    
    private final String tapeDensityDirective;

    private final TapeDriveType density;

    private final UUID partitionId;

    private final TapeType tapeType;


    // Constructor
    public CreateTapeDensityDirectiveSpectraS3Request(final TapeDriveType density, final UUID partitionId, final String tapeDensityDirective, final TapeType tapeType) {
        this.tapeDensityDirective = tapeDensityDirective;
        this.density = density;
        this.partitionId = partitionId;
        this.tapeType = tapeType;
        
    }

    @Override
    public HttpVerb getVerb() {
        return HttpVerb.PUT;
    }

    @Override
    public String getPath() {
        return "/_rest_/tape_density_directive/" + tapeDensityDirective;
    }
    
    public String getTapeDensityDirective() {
        return this.tapeDensityDirective;
    }


    public TapeDriveType getDensity() {
        return this.density;
    }


    public UUID getPartitionId() {
        return this.partitionId;
    }


    public TapeType getTapeType() {
        return this.tapeType;
    }


}