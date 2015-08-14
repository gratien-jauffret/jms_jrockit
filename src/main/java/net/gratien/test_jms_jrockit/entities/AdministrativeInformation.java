package net.gratien.test_jms_jrockit.entities;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="ADMINISTRATIVE_INFORMATION")
public class AdministrativeInformation {
//  <xsd:complexType name="AdministrativeInformationType" id="uuid-32864389-a032-4f77-9c09-c083386fcad9">
//    <xsd:sequence>
//      <xsd:element ref="Identifier" id="uuid-A36D9558-9F96-2794-91FA-B4F311A7735D" minOccurs="0" />
//      <xsd:element ref="PublicationDate" id="uuid-6ebfbf00-e08c-8114-8980-aba1f91c3936" minOccurs="0" />
//      <xsd:element ref="Source" id="uuid-f2e49267-3f70-a794-827e-3b65644badd8" minOccurs="0" />
//    </xsd:sequence>
//  </xsd:complexType>
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger identifier;
	@Column(name="PUBLICATION_DATE", nullable=true)
	@Temporal(TemporalType.DATE)
	private Date publicationDate;
	@Column(name="SOURCE", nullable=true)
	private String source;
}
