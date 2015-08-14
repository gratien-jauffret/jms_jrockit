package net.gratien.test_jms_jrockit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="ROLE")
public class Role {
//  <xsd:element name="Role" id="uuid-6BEF4BD5-bd9c-497c-A264-B81B443F36AA">
//    <xsd:annotation>
//      <xsd:documentation source="documentation" xml:lang="EN">A complex element containing other elements enabling the naming, description, and categorization of different kinds of interests individuals and groups may have in the achievement of goals and objectives.</xsd:documentation>
//    </xsd:annotation>
//    <xsd:complexType>
//      <xsd:sequence>
//        <xsd:element ref="Name" id="uuid-8AA40586-F938-df44-8D84-873E6E172480" minOccurs="0" />
//        <xsd:element ref="Description" id="uuid-E7588067-5345-4087-AE9F-191CF2058B09" minOccurs="0" />
//      </xsd:sequence>
//    </xsd:complexType>
//  </xsd:element>
	@Column(name="NAME", nullable=true)
	private String name;
	@Column(name="DESCRIPTION", nullable=true)
	private String description;
	@ManyToOne
	private Stakeholder stakeholder;
}
