/**
 * Licensed to Apereo under one or more contributor license
 * agreements. See the NOTICE file distributed with this work
 * for additional information regarding copyright ownership.
 * Apereo licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License.  You may obtain a
 * copy of the License at the following location:
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apereo.cas.client;

import org.apereo.cas.client.authentication.AttributePrincipalImpl;
import org.apereo.cas.client.authentication.SimplePrincipal;
import org.apereo.cas.client.jaas.AssertionPrincipal;
import org.apereo.cas.client.validation.AssertionImpl;

import junit.framework.TestCase;
import org.junit.Assert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;

/**
 * Confirms serialization support for classes intended for session storage or
 * other potential serialization use cases.
 *
 * @author Marvin S. Addison
 * @version $Revision$
 * @since 3.1.11
 */
public class SerializationTests extends TestCase {

    public void testSerializeDeserialize() throws Exception {
        final Object[] subjects = getTestSubjects();
        for (int i = 0; i < subjects.length; i++) {
            final ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            final ObjectOutputStream out = new ObjectOutputStream(byteOut);
            try {
                out.writeObject(subjects[i]);
            } catch (final Exception e) {
                Assert.fail("Serialization failed for " + subjects[i]);
            } finally {
                out.close();
            }

            final ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            final ObjectInputStream in = new ObjectInputStream(byteIn);
            try {
                Assert.assertEquals(subjects[i], in.readObject());
            } catch (final Exception e) {
                Assert.fail("Deserialization failed for " + subjects[i]);
            } finally {
                in.close();
            }
        }
    }

    private Object[] getTestSubjects() {
        final SimplePrincipal simplePrincipal = new SimplePrincipal("simple");
        final AttributePrincipalImpl attributePrincipal = new AttributePrincipalImpl("attr",
            Collections.<String, Object>singletonMap("LOA", "3"));
        final AssertionPrincipal assertionPrincipal = new AssertionPrincipal("assertion", new AssertionImpl(
            attributePrincipal, Collections.<String, Object>singletonMap("authenticationMethod", "username")));

        return new Object[]{simplePrincipal, attributePrincipal, assertionPrincipal,};
    }
}
