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
@Table(name="OBJECTIVE")
public class Objective {
//  <xsd:complexType name="ObjectiveType" id="uuid-A494052D-115D-4452-B49B-DC0FF3089A79">
//    <xsd:sequence>
//      <xsd:element ref="Name" id="uuid-36e8852b-2761-460d-b911-0c01c7bdecd3" minOccurs="0" />
//      <xsd:element ref="Description" id="uuid-687daacf-3b29-4e91-b1e7-8e9191d17338" />
//      <xsd:element ref="Identifier" id="uuid-8e762c3e-85b6-4f5c-93d1-a2513667507f" minOccurs="0" />
//      <xsd:element ref="OtherInformation" id="uuid-75d113e5-ae18-4c6f-87ca-1811557471fb" minOccurs="0" />
//    </xsd:sequence>
//  </xsd:complexType>
	@Column(name="NAME", nullable=true)
	private String name;
	@Column(name="DESCRIPTION", nullable=true)
	private String description;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger identifier;
	@Column(name="OTHER_INFORMATION", nullable=true)
	private String otherInformation;
	@ManyToOne
	private ProductOrServiceDescription productOrServiceDescription;
}
