package net.gratien.test_jms_jrockit.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ProductOrServiceDescription {
//	<xsd:sequence>
//    <xsd:element ref="Name" id="uuid-C1032E04-gp98-4810-9C84-8D49216BDFEE" minOccurs="1" />
//    <xsd:element ref="Description" id="uuid-C1032E04-qr07-4810-9C84-8D49216BDFEE" minOccurs="0" />
//	  <xsd:element ref="Categorization" id="uuid-3c9c0a38-4d9b-4146-f00a-f05e722ec4f6" minOccurs="0" maxOccurs="unbounded" />
//    <xsd:element ref="Organization" id="uuid-C800A4FC-bv334-45d5-B862-70FBF6628156" minOccurs="0" />
//    <xsd:element ref="Stakeholder" id="uuid-3c9c0a38-4d9b-4146-a0f0-f05e722e6f4c" minOccurs="0" maxOccurs="unbounded" />
//    <xsd:element ref="Objective" id="uuid-3c9c0a38-4d9b-4146-a0f0-f05e722ec4f6" minOccurs="0" maxOccurs="unbounded" />
//    <xsd:element ref="OtherInformation" id="uuid-C800A4FC-mucp-45d5-B862-70FBF6628156" minOccurs="0" />
//    <xsd:element ref="FeaturesAndFunctions" id="uuid-41F187FB-rrbb-491b-8B0E-65B14A57A4C8" />
//    <xsd:element ref="Picture" id="uuid-3c9c0a38-4d9b-4146-f0a0-f05e722e6f4c" minOccurs="0" maxOccurs="unbounded" />
//    <xsd:element ref="Cost" id="uuid-C1032E04-qr07-4810-9C84-8D49216Beefd" minOccurs="0" maxOccurs="unbounded" />
//    <xsd:element ref="Relationship" id="uuid-C1032E04-qr07-4810-9C84-8D49216fdeeB" minOccurs="0" maxOccurs="unbounded" />
//    <xsd:element ref="AdministrativeInformation" id="uuid-29939A46-92mx-45a1-B865-D62FEEE9AB8C" minOccurs="0" />
//    <xsd:element ref="Submitter" id="uuid-4147E26D-BB81-495f-33mv-1D63EBE45A62" minOccurs="0" />
//  </xsd:sequence>
//  <xsd:attribute name="Type" use="required">
//    <xsd:simpleType>
//      <xsd:restriction base="xsd:string">
//        <xsd:enumeration value="Product" />
//        <xsd:enumeration value="Service" />
//      </xsd:restriction>
//    </xsd:simpleType>
//  </xsd:attribute>
	@Column(name="NAME", nullable=false)
	private String name;
	@Column(name="DESCRIPTION", nullable=true)
	private String description;
	@OneToMany(mappedBy="productOrServiceDescription")
	private List<Categorization> categorizations;
	@OneToOne
	private Organization Organization;
	@OneToMany(mappedBy="productOrServiceDescription")
	private List<Stakeholder> stakeholders;
	@OneToMany(mappedBy="productOrServiceDescription")
	private List<Objective> objectives;
	@Column(name="OTHER_INFORMATION", nullable=true)
	private String otherInformation;
	@OneToOne
	private FeaturesAndFunctions featuresAndFunctions;
	@OneToMany(mappedBy="productOrServiceDescription")
	private List<Picture> pictures;
	@OneToMany(mappedBy="productOrServiceDescription")
	private List<Cost> costs;
	@OneToMany(mappedBy="productOrServiceDescription")
	private List<Relationship> relationships;
	@OneToOne
	private AdministrativeInformation administrativeInformation;
	@OneToOne
	private ContactInformation submitter;
	@Column(name="TYPE", nullable=false)
	@Enumerated(EnumType.STRING)
	private Type type;
	
	public enum Type{
		product,
		service;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Categorization> getCategorizations() {
		return categorizations;
	}

	public void setCategorizations(List<Categorization> categorizations) {
		this.categorizations = categorizations;
	}
	
	public void addToCategorizations(Categorization categorization) {
		if(this.categorizations == null)
			this.categorizations = new ArrayList<Categorization>();
		this.categorizations.add(categorization);
	}

	public Organization getOrganization() {
		return Organization;
	}

	public void setOrganization(Organization organization) {
		Organization = organization;
	}

	public List<Stakeholder> getStakeholders() {
		return stakeholders;
	}

	public void setStakeholders(List<Stakeholder> stakeholders) {
		this.stakeholders = stakeholders;
	}
	
	public void addToStakeholders(Stakeholder stakeholder) {
		if(this.stakeholders == null)
			this.stakeholders = new ArrayList<Stakeholder>();
		this.stakeholders.add(stakeholder);
	}

	public List<Objective> getObjectives() {
		return objectives;
	}

	public void setObjectives(List<Objective> objectives) {
		this.objectives = objectives;
	}
	
	public void addToObjectives(Objective objective) {
		if(this.objectives == null)
			this.objectives = new ArrayList<Objective>();
		this.objectives.add(objective);
	}

	public String getOtherInformation() {
		return otherInformation;
	}

	public void setOtherInformation(String otherInformation) {
		this.otherInformation = otherInformation;
	}

	public FeaturesAndFunctions getFeaturesAndFunctions() {
		return featuresAndFunctions;
	}

	public void setFeaturesAndFunctions(FeaturesAndFunctions featuresAndFunctions) {
		this.featuresAndFunctions = featuresAndFunctions;
	}

	public List<Picture> getPictures() {
		return pictures;
	}

	public void setPictures(List<Picture> pictures) {
		this.pictures = pictures;
	}
	
	public void addToPictures(Picture picture) {
		if(this.pictures == null)
			this.pictures = new ArrayList<Picture>();
		this.pictures.add(picture);
	}

	public List<Cost> getCosts() {
		return costs;
	}

	public void setCosts(List<Cost> costs) {
		this.costs = costs;
	}
	
	public void addToCosts(Cost cost) {
		if(this.costs == null)
			this.costs = new ArrayList<Cost>();
		this.costs.add(cost);
	}

	public List<Relationship> getRelationships() {
		return relationships;
	}

	public void setRelationships(List<Relationship> relationships) {
		this.relationships = relationships;
	}
	
	public void addToRelationships(Relationship relationship) {
		if(this.relationships == null)
			this.relationships = new ArrayList<Relationship>();
		this.relationships.add(relationship);
	}

	public AdministrativeInformation getAdministrativeInformation() {
		return administrativeInformation;
	}

	public void setAdministrativeInformation(AdministrativeInformation administrativeInformation) {
		this.administrativeInformation = administrativeInformation;
	}

	public ContactInformation getSubmitter() {
		return submitter;
	}

	public void setSubmitter(ContactInformation submitter) {
		this.submitter = submitter;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}
}
