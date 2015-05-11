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

package com.spectralogic.ds3client.commands.notifications;

import com.spectralogic.ds3client.commands.AbstractResponse;
import com.spectralogic.ds3client.models.notification.NotificationRegistration;
import com.spectralogic.ds3client.networking.WebResponse;
import com.spectralogic.ds3client.serializer.XmlOutput;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

public class NotificationResponse extends AbstractResponse {
    private NotificationRegistration registration;
    public NotificationResponse(final WebResponse response) throws IOException {
        super(response);
    }

    @Override
    protected void processResponse() throws IOException {
        try (final WebResponse response = this.getResponse()) {
            if (response == null) {
                throw new IOException("response was null");
            }
            this.checkStatusCode(200, 201);

            try (final InputStream content = response.getResponseStream()) {
                final StringWriter writer = new StringWriter();
                IOUtils.copy(content, writer, UTF8);
                this.registration = XmlOutput.fromXml(writer.toString(), NotificationRegistration.class);
            }
        }
    }

    public NotificationRegistration getRegistration() {
        return this.registration;
    }
}