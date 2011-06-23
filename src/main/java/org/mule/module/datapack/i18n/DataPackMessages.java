/*
 * Generated by the Mule project wizard. http://mule.mulesoft.org
 *
 * The software in this package is published under the terms of the CPAL v1.0
 * license, a copy of which has been included with this distribution in the
 * LICENSE.txt file.
 */
package org.mule.module.datapack.i18n;

import org.mule.config.i18n.Message;
import org.mule.config.i18n.MessageFactory;

public class DataPackMessages extends MessageFactory
{
    private static final DataPackMessages FACTORY = new DataPackMessages();

    private static final String BUNDLE_PATH = getBundlePath("datapack");

    public static Message noColumnsDefinedMessage()
    {
        return FACTORY.createMessage(BUNDLE_PATH, 1);
    }

    public static Message notAbleToConvertToString(String columnName)
    {
        return FACTORY.createMessage(BUNDLE_PATH, 2, columnName);
    }

    public static Message dateInboundParseError(String value, String format)
    {
        return FACTORY.createMessage(BUNDLE_PATH, 3, value, format);
    }

    public static Message noColumnNameDefined()
    {
        return FACTORY.createMessage(BUNDLE_PATH, 4);
    }

    public static Message noTransformerFound(String transformerName)
    {
        return FACTORY.createMessage(BUNDLE_PATH, 5, transformerName);
    }

    public static Message notAbleToConvertPayloadToString()
    {
        return FACTORY.createMessage(BUNDLE_PATH, 6);
    }

    public static Message columnSizeMisMatch()
    {
        return FACTORY.createMessage(BUNDLE_PATH, 7);
    }

    public static Message payloadNotList()
    {
        return FACTORY.createMessage(BUNDLE_PATH, 8);
    }
}
