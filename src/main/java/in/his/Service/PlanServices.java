package in.his.Service;

import java.util.List;
import java.util.Map;

import in.his.entity.Plan;

public interface PlanServices {

	
     public Map<Integer, String> getPlanCategories();
	
	 public boolean savePlan(Plan plan);
	
	 public List<Plan> getAllPlans();
	
	 public Plan getPlanById(Integer PlanId);
	
     public boolean updatePlan(Plan plan);
	
	 public boolean deletePlanById(Integer planId);
	
	 public boolean planSatusChange(Integer planId, String status);
}
