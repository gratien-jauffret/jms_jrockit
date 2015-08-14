package net.gratien.test_jms_jrockit.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FEATURE")
public class Feature {
//  <xsd:complexType name="FeatureType" id="uuid-3604D5A8-2B17-1b14-88E9-F71866006E23">
//    <xsd:sequence>
//      <xsd:element ref="Name" id="uuid-0b19dff1-b98e-470f-08ca-92a755d8aa37" minOccurs="0" />
//      <xsd:element ref="Description" id="uuid-b454f40f-721c-1a24-ba43-3a56ef37766e" />
//      <xsd:element ref="Identifier" id="uuid-f0543f96-c5be-77d4-a86d-d2f04122a5ea" minOccurs="0" />
//      <xsd:element ref="SequenceIndicator" id="uuid-af23adab-d9d6-b264-a627-8cd2547d8193" minOccurs="0" />
//	    <xsd:element ref="PerformanceIndicator" minOccurs="0" maxOccurs="unbounded" />
//      <xsd:element ref="OtherInformation" id="uuid-edd05fe8-91ca-4511-5bf8-c360ac07ebe8" minOccurs="0" />
//    </xsd:sequence>
//  </xsd:complexType>
	@Column(name="NAME", nullable=true)
	private String name;
	@Column(name="DESCRIPTION", nullable=true)
	private String description;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger identifier;
	@Column(name="SEQUENCE_INDICATOR", nullable=true)
	private String sequenceIndicator;
	@OneToMany(mappedBy="feature")
	private PerformanceIndicator performanceIndicator;
	@Column(name="OTHER_INFORMATION", nullable=true)
	private String otherInformation;
	
	@ManyToOne
	private FeaturesAndFunctions featuresAndFunctions;
}
