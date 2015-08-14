package net.gratien.test_jms_jrockit.entities;

import java.math.BigInteger;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CONTACT_INFORMATION")
public class ContactInformation {
//  <xsd:complexType name="ContactInformationType" id="uuid-b07e1586-6676-2124-8a6a-4a365a4977ec">
//    <xsd:sequence>
//      <xsd:element ref="Identifier" id="uuid-3AA1341B-C021-43a9-3D49-5AE78BEA9B90" minOccurs="0" />
//      <xsd:element ref="FirstName" id="uuid-be2396f2-cdf9-c894-82ef-1ce1b9209086" minOccurs="0" />
//      <xsd:element ref="LastName" id="uuid-3d5034e0-328a-46a0-bf5b-776e070cca5f" minOccurs="0" />
//      <xsd:element ref="PhoneNumber" id="uuid-160fe527-9d1d-423a-59cb-ad48f3257276" minOccurs="0" />
//      <xsd:element ref="EmailAddress" id="uuid-9e408a3b-034a-486f-540b-7cc74505b44d" minOccurs="0" />
//    </xsd:sequence>
//  </xsd:complexType>
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private BigInteger identifier;
	@Column(name="FIRST_NAME", nullable=true)
	private String firstName;
	@Column(name="LAST_NAME", nullable=true)
	private String lastName;
	@Column(name="PHONE_NUMBER", nullable=true)
	private String phoneNumber;
	@Column(name="EMAIL_ADDRESS", nullable=true)
	private String emailAddress;
	
	@OneToOne
	private ProductOrServiceDescription productOrServiceDescription;
}
