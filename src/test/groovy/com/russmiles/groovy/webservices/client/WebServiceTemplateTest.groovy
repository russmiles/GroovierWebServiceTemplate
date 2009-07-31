package com.russmiles.groovy.webservices.client

import groovy.xml.MarkupBuilder

/**
 * Tests for the Groovy web service template
 * TODO Make this against a publicly available test SOAP service?
 * @author Russ Miles (russ@russmiles.com)
 *
 */
class WebServiceTemplateTest extends GroovyTestCase {
    def serviceURL = "http://localhost:8080/springws/services"

    def namespace = "http://mycompany.com/hr/schemas"

    def webServiceTemplate;

    void setUp(){
        webServiceTemplate = new WebServiceTemplate()
        webServiceTemplate.setDefaultUri(serviceURL)
    }

    void testSendAndReceiveStrings() {
      def request = this.createStringRequest()
      def response = webServiceTemplate.sendToEndpoint(request)
      System.out.println(response);
    }

    String createStringRequest(){
      def writer = new StringWriter()
      def request = new MarkupBuilder(writer)
	  request.HolidayRequest(xmlns: namespace) {
         Holiday {
           StartDate("2006-07-03")
           EndDate("2006-07-07")
         }
         Employee {
           Number("42")
           FirstName("Russ")
           LastName("Miles")
         }
      }

      writer.toString()
    }
}
