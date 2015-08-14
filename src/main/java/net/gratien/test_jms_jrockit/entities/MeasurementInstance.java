package net.gratien.test_jms_jrockit.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MEASUREMENT_INSTANCE")
public class MeasurementInstance {
//  <xsd:element name="MeasurementInstance">
//    <xsd:annotation>
//      <xsd:documentation source="documentation" xml:lang="EN">A measurement at a point in time.</xsd:documentation>
//    </xsd:annotation>
//    <xsd:complexType>
//      <xsd:sequence>
//        <xsd:element ref="ActualResult" id="uuid-B52A1491-AC8D-4548-A1A4-628342FA525A" minOccurs="0" maxOccurs="unbounded" />
//      </xsd:sequence>
//    </xsd:complexType>
//  </xsd:element>
	@OneToMany(mappedBy="measurementInstance")
	private List<ActualResult> actualResults;
	
	@ManyToOne
	private PerformanceIndicator performanceIndicator;
}
