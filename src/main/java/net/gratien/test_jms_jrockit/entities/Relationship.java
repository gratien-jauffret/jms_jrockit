package net.gratien.test_jms_jrockit.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.gratien.test_jms_jrockit.entities.enums.RelationshipType;

@Entity
@Table(name="RELATIONSHIP")
public class Relationship {
//  <xsd:element name="Relationship">
//    <xsd:annotation>
//      <xsd:documentation>A conceptual connection between two elements that have Identifiers.</xsd:documentation>
//    </xsd:annotation>
//    <xsd:complexType>
//      <xsd:sequence>
//        <xsd:element ref="Name" minOccurs="0" />
//        <xsd:element ref="Description" minOccurs="0" />
//        <xsd:element ref="Identifier" minOccurs="0" />
//        <xsd:element ref="WebAddress" minOccurs="0" />
//        <xsd:element ref="OtherInformation" minOccurs="0" />
//      </xsd:sequence>
//      <xsd:attribute name="RelationshipType" type="RelationshipTypeType" />
//    </xsd:complexType>
//  </xsd:element>¨
	@Column(name="NAME", nullable=true)
	private String name;
	@Column(name="DESCRIPTION", nullable=true)
	private String description;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger identifier;
	@Column(name="WEB_ADDRESS", nullable=true)
	private String webAddress;
	@Column(name="OTHER_INFORMATION", nullable=true)
	private String otherInformation;
	@Column(name="TYPE", nullable=true)
	@Enumerated(EnumType.STRING)
	private RelationshipType type;
	
	@ManyToOne
	private ProductOrServiceDescription productOrServiceDescription;
}
