package net.gratien.test_jms_jrockit.entities;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.gratien.test_jms_jrockit.entities.enums.CurrencyType;

@Entity
@Table(name="COST")
public class Cost {
//  <xsd:element name="Cost">
//    <xsd:annotation>
//      <xsd:documentation>The amount of currency determined by multiplying the price times the quantity to be purchased.</xsd:documentation>
//    </xsd:annotation>
//    <xsd:complexType>
//      <xsd:sequence>
//        <xsd:element ref="CurrencyType" minOccurs="1" />
//        <xsd:element ref="Price" minOccurs="1" />
//        <xsd:element ref="Quantity" minOccurs="1" />
//      </xsd:sequence>
//    </xsd:complexType>
//  </xsd:element>
	@Column(name="CURRENCY", nullable=false)
	@Enumerated(EnumType.STRING)
	private CurrencyType currency;
	@Column(name="PRICE", nullable=false)
	private BigDecimal price;
	@Column(name="QUANTITY", nullable=false)
	private BigInteger quantity;
	
	@ManyToOne
	private ProductOrServiceDescription productOrServiceDescription;
}
