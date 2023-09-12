package in.his.entity;

import java.time.LocalDate;

import javax.persistence.Column;
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
@Table(name="PLAN_MASTER")
public class Plan {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name="PLAN_ID")
	private Integer planId;
	
	//@Column(name="PLAN_NAME")
	private String planName;
	
	//@Column(name="PLAN_START_DATE")
	private LocalDate planStartDate;
	
	//@Column(name="PLAN_END_DATE")
	private LocalDate planEndDate;
	
	//@Column(name="ACTIVE_SW")
	private String activeSW;
	
	//@Column(name="CATEGORY_ID")
	private Integer planCategoryId;
	
	//@Column(name="UPDATED_BY", insertable = )
	private String createdBy;
	
	//@Column(name="UPDATED_BY")
	private String updatedBy;
	
	//@Column(name="CREATED_DATE", updatable = false)
	@CreationTimestamp
	private LocalDate createDate;
	
	//@Column(name="UPDATED_DATE", insertable = false)
	@UpdateTimestamp
	private LocalDate updateDate;
	
	
	

}
