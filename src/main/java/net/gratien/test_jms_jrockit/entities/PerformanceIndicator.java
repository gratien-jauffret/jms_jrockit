package net.gratien.test_jms_jrockit.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.gratien.test_jms_jrockit.entities.enums.PerformanceIndicatorType;

@Entity
@Table(name="PERFORMANCE_INDICATOR")
public class PerformanceIndicator {
//  <xsd:element name="PerformanceIndicator" id="uuid-5E26BC7A-0437-48ce-A11E-D3B566026C49">
//    <xsd:annotation>
//      <xsd:documentation source="documentation" xml:lang="EN">A measurement dimension, unit of measurement, and measurement instance specifying target and actual results, e.g., of inputs applied, outputs produced, processes conducted, and outcomes realized.</xsd:documentation>
//    </xsd:annotation>
//    <xsd:complexType>
//      <xsd:sequence>
//        <xsd:element ref="SequenceIndicator" id="uuid-49339C06-8c33-4e80-8FFE-B1BF1668EE5D" minOccurs="0" />
//        <xsd:element ref="MeasurementDimension" id="uuid-17139C06-33C8-4e80-8FFE-B1BF1668ED4C" minOccurs="0" />
//        <xsd:element ref="UnitOfMeasurement" minOccurs="0" />
//        <xsd:element ref="Identifier" id="uuid-5C262CB2-FB6B-4508-BF8o-2954CFC98841" minOccurs="0" />
//        <xsd:element ref="MeasurementInstance" minOccurs="0" maxOccurs="unbounded" />
//        <xsd:element ref="OtherInformation" id="uuid2FC2C862-2FE0-2f44-8F3A-A48A1E07BEBC" minOccurs="0" />
//      </xsd:sequence>
//      <xsd:attribute name="PerformanceIndicatorType" type="PerformanceIndicatorTypeType" />
//    </xsd:complexType>
//  </xsd:element>
	@Column(name="SEQUENCE_INDICATOR", nullable=true)
	private String sequenceIndicator;
	@Column(name="MEASUREMENT_DIMENSION", nullable=true)
	private String measurementDimension;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger identifier;
	@OneToMany(mappedBy="performanceIndicator")
	private MeasurementInstance measurementInstance;
	@Column(name="OTHER_INFORMATION", nullable=true)
	private String otherInformation;
	@Column(name="TYPE", nullable=true)
	@Enumerated(EnumType.STRING)
	private PerformanceIndicatorType type;
}
