/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.russmiles.groovy.webservices.client

import org.springframework.xml.transform.StringResult;
import org.springframework.xml.transform.StringSource;

/**
 * A Groovy facade around the Spring WebServicesTemplate
 *
 * @author Russ Miles (russ@russmiles.com)
 *
 */
class WebServiceTemplate
{
  org.springframework.ws.client.core.WebServiceTemplate webServiceTemplate;
     
  WebServiceTemplate() {
    this.webServiceTemplate = new org.springframework.ws.client.core.WebServiceTemplate();
  }

  String sendToEndpoint(String request) {
     StringResult result = new StringResult();
     StringSource source = new StringSource(request as String);
     webServiceTemplate.sendSourceAndReceiveToResult(source, result);
     result.toString()
  }

  String sendToEndpoint(String uri, String request) {
     StringResult result = new StringResult();
     StringSource source = new StringSource(request as String);
     webServiceTemplate.sendSourceAndReceiveToResult(uri, source, result);
     result.toString()
  }

  void setDefaultUri(String serviceUri) {
    webServiceTemplate.setDefaultUri(serviceUri);
  }
}
