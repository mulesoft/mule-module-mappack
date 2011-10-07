/*
 * Generated by the Mule project wizard. http://mule.mulesoft.org
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.module.nestedmappack;

import org.mule.api.MuleMessage;
import org.mule.module.client.MuleClient;
import org.mule.tck.FunctionalTestCase;
import org.mule.transport.NullPayload;

import java.util.HashMap;

public class MapPackToListTestCase extends FunctionalTestCase {
	protected String getConfigResources() {

		return "mappack-list-test-config.xml";
	}

	public void testNestedMapping() throws Exception {
		MuleClient client = new MuleClient(muleContext);
		MuleMessage result = client.send("vm://tolistoutput.in", "data",
				null);
		assertNotNull(result);
		assertNull(result.getExceptionPayload());
		assertFalse(result.getPayload() instanceof NullPayload);
		
		assertEquals(
				"[{map3={map2={key4=12/31/2011, key3=data test-1, map4={key5=data test-2}}}, map1={key2=data, key1=data}}]",
				result.getPayloadAsString());
	}

}
