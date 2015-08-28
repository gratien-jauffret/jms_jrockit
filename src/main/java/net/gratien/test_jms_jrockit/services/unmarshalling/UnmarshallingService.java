package net.gratien.test_jms_jrockit.services.unmarshalling;

import javax.xml.XMLConstants;
import javax.xml.validation.SchemaFactory;

import org.springframework.beans.factory.annotation.Autowired;

import net.gratien.test_jms_jrockit.handlers.unmarshalling.UnmarshallingValidationEventHandler;

public class UnmarshallingService {
	
	@Autowired
	UnmarshallingValidationEventHandler handler;
	
	public void unmarshall(String productOrServiceDescription) {
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI); 
//        Schema schema = sf.newSchema(getClass().getResource("/ProductOrServiceDescription.xsd")); 
 
//        JAXBContext jc = JAXBContext.newInstance(ProductOrServiceDescrption.class);
// 
//        Unmarshaller unmarshaller = jc.createUnmarshaller();
//        unmarshaller.setSchema(schema);
//        unmarshaller.setEventHandler(handler);
//        ProductOrServiceDescrption customer = (ProductOrServiceDescrption) unmarshaller.unmarshal();
	}
}
