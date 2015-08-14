package net.gratien.test_jms_jrockit.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ORGANIZATION")
public class Organization {
//  <xsd:element name="Organization" id="uuid-9d589d53-42ce-4c18-b5db-5be8075c1be5">
//    <xsd:annotation>
//      <xsd:documentation source="documentation" xml:lang="EN">The legal or logical entity to which the plan or report applies.</xsd:documentation>
//    </xsd:annotation>
//    <xsd:complexType>
//      <xsd:sequence>
//        <xsd:element ref="Name" id="uuid-e871651e-e943-1141-b0b6-eb1f5754f3be" minOccurs="0" />
//        <xsd:element ref="Acronym" id="uuid-eb510ea2-07de-40ec-95f1-abdf6644e002" minOccurs="0" />
//        <xsd:element ref="Identifier" id="uuid-d5b4b082-8326-46a8-a475-533813a4ed29" minOccurs="0" />
//        <xsd:element ref="WebAddress" id="uuid-d5b4b082-8326-46a8-a475-533813a492de" minOccurs="0" />
//      </xsd:sequence>
//    </xsd:complexType>
//  </xsd:element>
	@Column(name="NAME", nullable=true)
	private String name;
	@Column(name="ACRONYM", nullable=true)
	private String acronym;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger identifier;
	@Column(name="WEB_ADDRESS", nullable=true)
	private String webAddress;
	
	@OneToOne
	private ProductOrServiceDescription productOrServiceDescription;
}
