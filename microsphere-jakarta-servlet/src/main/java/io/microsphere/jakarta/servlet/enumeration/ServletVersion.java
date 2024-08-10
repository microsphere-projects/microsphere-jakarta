/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.microsphere.jakarta.servlet.enumeration;

import io.microsphere.util.Version;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;

import static io.microsphere.util.Version.of;

/**
 * Servlet Version
 *
 * @author <a href="mailto:mercyblitz@gmail.com">Mercy</a>
 * @see Servlet
 * @see ServletContext
 * @see Version
 * @since 1.0.0
 */
public enum ServletVersion {

    /**
     * Jakarta Servlet version 5.0 is only a change of namespaces.
     * Thus, migrating a Servlet 4.0 project to Servlet 5.0 and above, requires the replacement of the namespace javax.* with jakarta.*.
     */
    SERVLET_5_0(5, 0),

    /**
     * Jakarta Servlet version 6.0
     *
     * <h3>New features, enhancements or additions</h3>
     * <ul>
     * <li><a href="https://github.com/eclipse-ee4j/servlet-api/issues/18">Issue 18</a> Clarify the decoding and normalization of URI paths</li>
     * <li><a href="https://github.com/eclipse-ee4j/servlet-api/issues/37">Issue 37</a> Update Cookie class, related classes and the specification to remove references to FC 2109 and to replace them with RFC 6265</li>
     * <li><a href="https://github.com/eclipse-ee4j/servlet-api/issues/105">Issue 105</a> Clarify the behaviour of getRealPath(String)</li>
     * <li><a href="https://github.com/eclipse-ee4j/servlet-api/issues/175">Issue 175</a> Provide generic attribute support to cookies, including session cookies, to provide support for additional attributes such as the SameSite attribute</li>
     * <li><a href="https://github.com/eclipse-ee4j/servlet-api/issues/201">Issue 201</a> Add a module-info.java to support using the Servlet API in a modular environment as per the Java module system and the Jakarta EE 10 recommendations</li>
     * <li><a href="https://github.com/eclipse-ee4j/servlet-api/issues/272">Issue 272</a> Remove the recommendation that Servlet containers should include an <code>X-Powered-By</code>header</li>
     * <li><a href="https://github.com/eclipse-ee4j/servlet-api/issues/365">Issue 365</a> Correct the list of valid orderings for example 2 in Section 8.2.2, “Ordering of web.xml and webfragment.xml”</li>
     * <li><a href="https://github.com/eclipse-ee4j/servlet-api/issues/368">Issue 368</a> Clarify the behaviour of getRemoteAddress()</li>
     * <li><a href="https://github.com/eclipse-ee4j/servlet-api/issues/377">Issue 377</a> Clarify the behaviour of setCharacterEncoding(null) and similar calls</li>
     * <li><a href="https://github.com/eclipse-ee4j/servlet-api/issues/407">Issue 407</a> Add new methods to obtain unique identifiers for the current request and/or associated connection</li>
     * <li><a href="https://github.com/eclipse-ee4j/servlet-api/issues/411">Issue 411</a> Relax the requirements set out in Section 6.2.2, “Wrapping Requests and Responses” and allow the container to wrap Requests and Responses to meet the requirements of implementing the RequestDispatcher functionality.</li>
     * <li><a href="https://github.com/eclipse-ee4j/servlet-api/issues/416">Issue 416</a> Remove the restriction on programatically added listeners calling some ServletContext getter methods</li>
     * <li><a href="https://github.com/eclipse-ee4j/servlet-api/issues/418">Issue 418</a></li>
     * <li>Add a new method getErrorOnELNotFound() to JspPropertyGroupDescriptor to align with changes in the Jakarta Pages 3.1 specification.</li>
     * <li>Clarify the Javadoc for ServletRequest.isAsyncStarted() to align it with the specification text</li>
     * <li>Update the Javadoc to clarify the scheduling implications when ServletInputStream.isReady() or ServletOutputStream.isReady() return false</li>
     * </ul>
     * <h3>Removals, deprecations or backwards incompatible changes</h3>
     * <ul>
     * <li><a href="https://github.com/eclipse-ee4j/servlet-api/issues/225">Issue 225</a> Deprecated wrapped response handling in the doHead method in favour of container implementation of HEAD method behavior</li>
     * <li>Remove API classes and methods that were deprecated in Servlet 5.0 and earlier. This includes removing the SingleThreadModel and HttpSessionContext interfaces and the HttpUtils class as well as various deprecated methods</li>
     * </ul>
     * <h3>Minimum Java SE Version</h3>
     * <p><strong>Java SE 11 or higher</strong></p>
     **/
    SERVLET_6_0(6, 0),

    /**
     * Jakarta Servlet version 6.1
     *
     * <h3>New features, enhancements or additions</h3>
     * <ul>
     * <li>Allow control of status code and response body when sending a redirect</li>
     * <li>Add a query string attribute to error dispatches</li>
     * <li>Add constants for new HTTP status codes</li>
     * <li>Add overloaded methods that use <code>CharSet</code> rather than <code>String</code></li>
     * <li>Add <code>ByteBuffer</code> support to <code>ServletInputStream</code> and <code>ServletOutputStream</code></li>
     * <li>Various clarifications</li>
     * </ul>
     * <h3>Removals, deprecations or backwards incompatible changes</h3>
     * <ul>
     * <li>All references to the SecurityManager and associated APIs have been removed</li>
     * </ul>
     * <h3 id="minimum-java-se-version">Minimum Java SE Version</h3>
     * <p><strong>Java SE 17 or higher</strong></p>
     */
    SERVLET_6_1(6, 1);

    private final Version version;

    ServletVersion(int majorVersion, int minorVersion) {
        this.version = of(majorVersion, minorVersion);
    }

    public int getMajor() {
        return version.getMajor();
    }

    public int getMinor() {
        return version.getMinor();
    }

    public boolean gt(ServletContext servletContext) {
        return isGreaterThan(servletContext);
    }

    public boolean isGreaterThan(ServletContext servletContext) {
        Version that = getVersion(servletContext);
        return version.isGreaterThan(that);
    }

    public boolean ge(ServletContext servletContext) {
        return isGreaterOrEqual(servletContext);
    }

    public boolean isGreaterOrEqual(ServletContext servletContext) {
        Version that = getVersion(servletContext);
        return version.isGreaterOrEqual(that);
    }

    public boolean lt(ServletContext servletContext) {
        return isLessThan(servletContext);
    }

    public boolean isLessThan(ServletContext servletContext) {
        Version that = getVersion(servletContext);
        return version.isLessThan(that);
    }

    public boolean le(ServletContext servletContext) {
        return isLessOrEqual(servletContext);
    }

    public boolean isLessOrEqual(ServletContext servletContext) {
        Version that = getVersion(servletContext);
        return version.isLessOrEqual(that);
    }

    public boolean eq(ServletContext servletContext) {
        return equals(servletContext);
    }

    public boolean equals(ServletContext servletContext) {
        Version that = getVersion(servletContext);
        return version.equals(that);
    }

    /**
     * Get the {@link Version Servlet version} of Current {@link ServletContext} in runtime
     *
     * @param servletContext {@link ServletContext}
     * @return non-null
     */
    public static Version getVersion(ServletContext servletContext) {
        int majorVersion = servletContext.getMajorVersion();
        int minorVersion = servletContext.getMinorVersion();
        return of(majorVersion, minorVersion);
    }

    /**
     * Get the {@link ServletVersion Servlet version} of Current {@link ServletContext} in runtime
     *
     * @param servletContext {@link ServletContext}
     * @return non-null
     */
    public static ServletVersion valueOf(ServletContext servletContext) {
        int majorVersion = servletContext.getMajorVersion();
        int minorVersion = servletContext.getMinorVersion();
        ServletVersion version = null;
        for (ServletVersion servletVersion : ServletVersion.values()) {
            if (servletVersion.getMajor() == majorVersion && servletVersion.getMinor() == minorVersion) {
                version = servletVersion;
                break;
            }
        }
        if (version == null) {
            throw new IllegalArgumentException("No ServletVersion enum for Servlet " + majorVersion + "." + minorVersion);
        }
        return version;
    }
}
