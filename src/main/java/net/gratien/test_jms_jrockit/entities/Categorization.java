package net.gratien.test_jms_jrockit.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="CATEGORIZATION")
public class Categorization {
//  <xsd:complexType name="CategorizationType">
//	<xsd:sequence>
//		<xsd:element ref="Name" minOccurs="0"/>
//		<xsd:element ref="Category" maxOccurs="unbounded"/>
//	</xsd:sequence>
//  </xsd:complexType>
	@Column(name="NAME", nullable=true)
	private String name;
	@OneToMany(mappedBy="categorization")
	private Category category;
	@ManyToOne
	private ProductOrServiceDescription productOrServiceDescription;
}
