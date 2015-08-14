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
@Table(name="CATEGORY")
public class Category {
//  <xsd:complexType name="CategoryType">
//	  <xsd:sequence>
//		<xsd:element ref="Name"/>
//		<xsd:element ref="Identifier"/>
//		<xsd:element ref="WebAddress" minOccurs="0"/>
//	  </xsd:sequence>
//  </xsd:complexType>
	@Column(name="NAME", nullable=false)
	private String name;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger identifier;
	@Column(name="WEB_ADDRESS", nullable=true)
	private String webAddress;
	
	@ManyToOne
	private Categorization categorization;
}
