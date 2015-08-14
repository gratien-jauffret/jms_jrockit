package net.gratien.test_jms_jrockit.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PICTURE")
public class Picture {
//  <xsd:complexType name="PictureType" id="uuid-A494052D-115D-2533-9B4B-DC0FF3089A79">
//    <xsd:sequence>
//      <xsd:element ref="Name" id="uuid-36e8852b-2761-d052-110b-0c01c7bdecd3" minOccurs="0" />
//      <xsd:element ref="Description" id="uuid-687daacf-29b3-1983-b1e7-8e9191d17338" />
//      <xsd:element ref="Identifier" id="uuid-8e762c3e-b658-cfby-93d1-a2513667507f" minOccurs="0" />
//      <xsd:element ref="SequenceIndicator" id="uuid-abbc7e84-8306-974m-9c8e-30a9d09616d2" minOccurs="0" />
//      <xsd:element ref="OtherInformation" id="uuid-75d113e5-18ea-648x-87ca-1811557471fb" minOccurs="0" />
//      <xsd:element ref="WebAddress" id="uuid-75d113e5-18ea-648x-87ca-18115574mxcv" minOccurs="1" />
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
	@Column(name="OTHER_INFORMATION", nullable=true)
	private String otherInformation;
	@Column(name="WEB_ADDRESS", nullable=false)
	private String webAddress;
	
	@ManyToOne
	private ProductOrServiceDescription productOrServiceDescription;
}
