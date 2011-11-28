package org.emftext.language.hedl.example.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "Supplier"
)
/*
 * This class is generated from the entity 'Supplier' defined in the HEDL model.
 * Note: Any change made to this class will be overridden.
 */
public class Supplier {
	
	@GenericGenerator(name="SupplierIdGenerator", strategy="org.hibernate.id.MultipleHiLoPerTableGenerator",
	  parameters = {
	    @Parameter(name="table", value="IdentityGenerator"),
	    @Parameter(name="primary_key_column", value="sequence_name"),
	    @Parameter(name="primary_key_value", value="Supplier"),
	    @Parameter(name="value_column", value="next_hi_value"),
	    @Parameter(name="primary_key_length", value="100"),
	    @Parameter(name="max_lo", value="1000")
	  }
	)
	@Id 
	@GeneratedValue(strategy=GenerationType.TABLE, generator="SupplierIdGenerator")
	private int id;

	private java.lang.String name;
	
	@OneToOne(cascade={CascadeType.ALL})
	@JoinColumn(name="warehouse", nullable=true)
	private Warehouse warehouse;
	
	/**
	 * Default constructor. Only used by Hibernate.
	 */
	public Supplier() {
		super();
	}

	/**
	 * Constructor using all read-only properties.
	 */
	public Supplier(java.lang.String name) {
		super();
		this.name = name;
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
	 * The property 'name' is read-only. 
	 * This setter is only provided for Hibernate. 
	 * It must not be used directly.
	 */
	@Deprecated
	public void setName(java.lang.String newValue) {
		this.name = newValue;
	}
	
	/**
	 * Returns the value of property 'warehouse'.
	 */
	public Warehouse getWarehouse() {
		return warehouse;
	}
	
	/**
	 * Sets the value of property 'warehouse'.
	 */
	public void setWarehouse(Warehouse newValue) {
		this.warehouse = newValue;
	}
	
}
