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
import java.util.Date;
import java.lang.String;
import com.spectralogic.ds3client.models.S3ObjectType;

public class S3Object {

    // Variables
    @JsonProperty("BucketId")
    private UUID bucketId;

    @JsonProperty("CreationDate")
    private Date creationDate;

    @JsonProperty("Id")
    private UUID id;

    @JsonProperty("Latest")
    private boolean latest;

    @JsonProperty("Name")
    private String name;

    @JsonProperty("Type")
    private S3ObjectType type;

    @JsonProperty("Version")
    private long version;

    // Constructor
    public S3Object(final UUID bucketId, final Date creationDate, final UUID id, final boolean latest, final String name, final S3ObjectType type, final long version) {
        this.bucketId = bucketId;
        this.creationDate = creationDate;
        this.id = id;
        this.latest = latest;
        this.name = name;
        this.type = type;
        this.version = version;
    }

    // Getters and Setters
    
    public UUID getBucketId() {
        return this.bucketId;
    }

    public void setBucketId(final UUID bucketId) {
        this.bucketId = bucketId;
    }


    public Date getCreationDate() {
        return this.creationDate;
    }

    public void setCreationDate(final Date creationDate) {
        this.creationDate = creationDate;
    }


    public UUID getId() {
        return this.id;
    }

    public void setId(final UUID id) {
        this.id = id;
    }


    public boolean getLatest() {
        return this.latest;
    }

    public void setLatest(final boolean latest) {
        this.latest = latest;
    }


    public String getName() {
        return this.name;
    }

    public void setName(final String name) {
        this.name = name;
    }


    public S3ObjectType getType() {
        return this.type;
    }

    public void setType(final S3ObjectType type) {
        this.type = type;
    }


    public long getVersion() {
        return this.version;
    }

    public void setVersion(final long version) {
        this.version = version;
    }

}