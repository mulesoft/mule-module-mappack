The Mule Mappack's project is a set of tools which help with the processing of payload into nested maps data. 

First in order to do any processing the mapping of the fields must be defined.  This is done in the configuration of Mule.
The following is a sample of a simple configuration:

<?xml version="1.0" encoding="UTF-8"?>
<mule xmlns="http://www.mulesoft.org/schema/mule/core"
      xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
      xmlns:mappack="http://www.mulesoft.org/schema/mule/mappack"
      xmlns:vm="http://www.mulesoft.org/schema/mule/vm"
      xmlns:script="http://www.mulesoft.org/schema/mule/scripting"
      xsi:schemaLocation="
        http://www.mulesoft.org/schema/mule/core http://www.mulesoft.org/schema/mule/core/3.2/mule.xsd
        http://www.mulesoft.org/schema/mule/mappack http://www.mulesoft.org/schema/mule/mappack/3.2/mule-mappack.xsd
        http://www.mulesoft.org/schema/mule/vm http://www.mulesoft.org/schema/mule/vm/3.2/mule-vm.xsd
        http://www.mulesoft.org/schema/mule/scripting http://www.mulesoft.org/schema/mule/scripting/3.2/mule-scripting.xsd
        ">

	<script:transformer name="transformertest1">
		<script:script engine="groovy"><![CDATA[
			return payload + " test-1";
		]]>
		</script:script>
	</script:transformer>	

	<script:transformer name="transformertest2">
		<script:script engine="groovy"><![CDATA[
			return payload + " test-2";
		]]>
		</script:script>
	</script:transformer>	

    <flow name="nestedmapoutput">
        <vm:inbound-endpoint path="nestedmapoutput.in" exchange-pattern="request-response" />

        <mappack:nested-map-transformer>
            <mappack:mapvalue map-name="map1" map-key="key1" value="#[payload]"/>
            <mappack:mapvalue map-name="map1" map-key="key2" value="#[payload]"/>
            <mappack:transform-mapvalue map-name="map2" map-key="key3" value="#[payload]" transformer-name="transformertest1" />
            <mappack:date-time-mapvalue map-name="map2" map-key="key4" date-format-in="yyyy-MM-dd"
				date-format-out="MM/dd/yyyy" value="2011-12-31" />
            <mappack:transform-mapvalue map-name="map4" map-key="key5" value="#[payload]" transformer-name="transformertest2" />
            
            <mappack:maporder parent-map="map2" child-map="map1" />
            <mappack:maporder parent-map="map2" child-map="map4" />
            <mappack:maporder parent-map="map3" child-map="map2" />
            <!-- IMPORTANT: maps that go direct into output, go last -->
            <mappack:maporder child-map="map1" />
        </mappack:nested-map-transformer>

    </flow>

</mule>
