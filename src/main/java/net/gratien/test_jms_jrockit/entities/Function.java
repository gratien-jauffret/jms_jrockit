package net.gratien.test_jms_jrockit.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="FUNCTION")
public class Function {
//  <xsd:complexType name="FunctionType" id="uuid-A494052D-115D-4452-9B4B-DC0FF3089A79">
//    <xsd:sequence>
//      <xsd:element ref="Name" id="uuid-36e8852b-2761-460d-110b-0c01c7bdecd3" minOccurs="0" />
//      <xsd:element ref="Description" id="uuid-687daacf-29b3-4e91-b1e7-8e9191d17338" />
//      <xsd:element ref="Identifier" id="uuid-8e762c3e-b658-4f5c-93d1-a2513667507f" minOccurs="0" />
//      <xsd:element ref="SequenceIndicator" id="uuid-abbc7e84-8306-4c89-9c8e-30a9d09616d2" minOccurs="0" />
//	    <xsd:element ref="PerformanceIndicator" minOccurs="0" maxOccurs="unbounded" />
//      <xsd:element ref="OtherInformation" id="uuid-75d113e5-18ea-4c6f-87ca-1811557471fb" minOccurs="0" />
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
	@OneToOne
	private PerformanceIndicator performanceIndicator;
	@Column(name="OTHER_INFORMATION", nullable=true)
	private String otherInformation;
	
	@ManyToOne
	private FeaturesAndFunctions featuresAndFunctions;
}
