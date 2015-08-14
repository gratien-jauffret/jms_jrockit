package net.gratien.test_jms_jrockit.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FEATURES_AND_FUNCTIONS")
public class FeaturesAndFunctions {
//  <xsd:element name="FeaturesAndFunctions" id="uuid-ce9c9293-e374-0084-8d62-9ee87d0c9887">
//    <xsd:annotation>
//      <xsd:documentation source="documentation" xml:lang="EN">A listing of the features and functions of a product or service.</xsd:documentation>
//    </xsd:annotation>
//    <xsd:complexType>
//      <xsd:sequence>
//        <xsd:element ref="Feature" id="uuid-f8d6372e-52e8-05A4-ab1c-274aad8bcf33" minOccurs="0" maxOccurs="unbounded" />
//        <xsd:element ref="Function" id="uuid-d4dbdad8-0cdd-4924-b091-b8bec961d03b" minOccurs="0" maxOccurs="unbounded" />
//      </xsd:sequence>
//    </xsd:complexType>
//  </xsd:element>
	@OneToMany(mappedBy="featuresAndFunctions")
	private List<Feature> features;
	@OneToMany(mappedBy="featuresAndFunctions")
	private List<Function> functions;
}
