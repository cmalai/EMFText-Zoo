package org.emftext.language.hedl.example.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Item"
)
/*
 * This class is generated from the entity 'Item' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class Item {
	
	@GenericGenerator(name="ItemIdGenerator", strategy="org.hibernate.id.MultipleHiLoPerTableGenerator",
	  parameters = {
	    @Parameter(name="table", value="IdentityGenerator"),
	    @Parameter(name="primary_key_column", value="sequence_name"),
	    @Parameter(name="primary_key_value", value="Item"),
	    @Parameter(name="value_column", value="next_hi_value"),
	    @Parameter(name="primary_key_length", value="100"),
	    @Parameter(name="max_lo", value="1000")
	  }
	)
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE, generator="ItemIdGenerator")
	private int id;

	private java.lang.String name;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="priceSet", updatable=false, nullable=true)
	private PriceSet priceSet;
	
	@ManyToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="producer", nullable=true)
	private Producer producer;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public Item() {
		super();
	}

	/**
	 * Constructor using all read-only properties.
	 */
	public Item(PriceSet priceSet) {
		super();
		this.priceSet = priceSet;
	}
	
	/**
	 * Returns the automatically generated id the identifies this entity object.
	 */
	public int getId() {
		return id;
	}

	/**
	 * The property 'id' is read-only. 
	 * This setter is only provided for Hibernate. 
	 * It must not be used directly.
	 */
	@Deprecated
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Returns the value of property 'name'.
	 */
	public java.lang.String getName() {
		return name;
	}
	
	/**
	 * Sets the value of property 'name'.
	 */
	public void setName(java.lang.String newValue) {
		this.name = newValue;
	}
	
	/**
	 * Returns the value of property 'priceSet'.
	 */
	public PriceSet getPriceSet() {
		return priceSet;
	}
	
	/**
	 * The property 'priceSet' is read-only. 
	 * This setter is only provided for Hibernate. 
	 * It must not be used directly.
	 */
	@Deprecated
	public void setPriceSet(PriceSet newValue) {
		this.priceSet = newValue;
	}
	
	/**
	 * Returns the value of property 'producer'.
	 */
	public Producer getProducer() {
		return producer;
	}
	
	/**
	 * Sets the value of property 'producer'.
	 */
	public void setProducer(Producer newValue) {
		this.producer = newValue;
	}
	
}
