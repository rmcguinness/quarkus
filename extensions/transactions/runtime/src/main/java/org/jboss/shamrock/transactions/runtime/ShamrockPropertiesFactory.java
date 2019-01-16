/*
 * Copyright 2018 Red Hat, Inc.
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

package org.jboss.shamrock.transactions.runtime;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.arjuna.common.util.propertyservice.AbstractPropertiesFactory;

public class ShamrockPropertiesFactory extends AbstractPropertiesFactory {

    private final Properties properties;

    public ShamrockPropertiesFactory(Properties properties) {
        this.properties = properties;
    }

    @Override
    protected Properties loadFromXML(Properties p, InputStream is) throws IOException {
        return properties;
    }
}