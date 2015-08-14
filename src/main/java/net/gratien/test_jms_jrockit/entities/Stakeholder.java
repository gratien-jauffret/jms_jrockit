package net.gratien.test_jms_jrockit.entities;

import java.math.BigInteger;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="STAKEHOLDER")
public class Stakeholder {
//  <xsd:element name="Stakeholder" id="uuid-1effcb49-2649-4c9b-bdc2-92971c9fc9cf">
//    <xsd:annotation>
//      <xsd:documentation source="documentation" xml:lang="EN">An individual whose interests may be affected by or whose action may be required to achieve a goal or objective.</xsd:documentation>
//    </xsd:annotation>
//    <xsd:complexType>
//      <xsd:sequence>
//        <xsd:element ref="Name" id="uuid-35cc454d-43d4-46b2-845a-eeb3ff8605dd" minOccurs="0" />
//        <xsd:element ref="Description" id="uuid-7e18eb24-475c-fcb4-a3c4-1c43adaf127c" minOccurs="0" />
//		  <xsd:element ref="Identifier" id="uuid-7e18eb24-c574-fcb4-a3c4-1c43adaf127c" minOccurs="0" />
//        <xsd:element ref="Role" id="uuid-75B20BA6-6B35-490b-87BE-B98008D49CC2" minOccurs="0" maxOccurs="unbounded" />
//      </xsd:sequence>
//    </xsd:complexType>
//  </xsd:element>
	@Column(name="NAME", nullable=true)
	private String name;
	@Column(name="DESCRIPTION", nullable=true)
	private String description;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger identifier;
	@OneToMany(mappedBy="stakeholder")
	private List<Role> roles;
	@ManyToOne
	private ProductOrServiceDescription productOrServiceDescription;
}
