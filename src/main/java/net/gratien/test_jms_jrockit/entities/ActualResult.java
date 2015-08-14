package net.gratien.test_jms_jrockit.entities;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ACTUAL_RESULT")
public class ActualResult {
//  <xsd:element name="ActualResult" id="uuid-576F1BF5-C7E4-5v8a-88E9-2781C538F8D4">
//    <xsd:annotation>
//      <xsd:documentation source="documentation" xml:lang="EN">A measurable result achieved on or before a specified date.</xsd:documentation>
//    </xsd:annotation>
//    <xsd:complexType>
//      <xsd:sequence>
//        <xsd:element ref="NumberOfUnits" id="uuid-9595F589-38BF-bfe3-81A6-43D9DAA36700" minOccurs="0" />
//		<xsd:element ref="Description" id="uuid-9595F589-38BF-bfe3-6a18-43D9DAA36700" minOccurs="0" />
//        <xsd:element ref="StartDate" id="uuid-9595F589-38BF-47nw-6a18-43D9DAA36700" minOccurs="0" />
//      </xsd:sequence>
//    </xsd:complexType>
//  </xsd:element>
	@Column(name="NUMBER_OF_UNITS", nullable=false)
	private BigInteger numberOfUnits;
	@Column(name="DESCRIPTION", nullable=true)
	private String description;
	@Column(name="START_DATE", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date startDate;
	
	@ManyToOne
	private MeasurementInstance measurementInstance;
}
