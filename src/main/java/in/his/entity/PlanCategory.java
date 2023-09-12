package in.his.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Plan_Category")
public class PlanCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="CATEGORY_ID")
	private Integer categoryId;
	
	//@Column(name="CATEGORY_NAME")
	private String categoryName;
	
	//@Column(name="ACTIVE_SW")
	private String activeSW;
	
	//@Column(name="CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDate createDate;
	
	//@Column(name="UPDATED_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDate updateDate;
	
	//@Column(name="CREADTED_BY")
	private String createdBy;
	
	//@Column(name="UPDATED_BY")
	private String updatedBy;

}
