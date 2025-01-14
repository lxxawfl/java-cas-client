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
package org.apereo.cas.client.validation;

/**
 * Generic exception to be thrown when ticket validation fails.
 *
 * @author Scott Battaglia
 * @version $Revision$ $Date$
 * @since 3.1
 */
public class TicketValidationException extends Exception {

    /**
     * Unique Id for Serialization
     */
    private static final long serialVersionUID = -7036248720402711806L;

    /**
     * Constructs an exception with the supplied message.
     *
     * @param string the message
     */
    public TicketValidationException(final String string) {
        super(string);
    }

    /**
     * Constructs an exception with the supplied message and chained throwable.
     *
     * @param string the message
     * @param throwable the original exception
     */
    public TicketValidationException(final String string, final Throwable throwable) {
        super(string, throwable);
    }

    /**
     * Constructs an exception with the chained throwable.
     * @param throwable the original exception.                                    
     */
    public TicketValidationException(final Throwable throwable) {
        super(throwable);
    }
}
