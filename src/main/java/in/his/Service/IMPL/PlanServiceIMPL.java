package in.his.Service.IMPL;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.his.Repo.PlanCategoryRepo;
import in.his.Repo.PlanRepo;
import in.his.Service.PlanServices;
import in.his.entity.Plan;
import in.his.entity.PlanCategory;

@Service
public class PlanServiceIMPL implements PlanServices {
	
	
	@Autowired
	private PlanRepo planrepo;
	
	@Autowired
	private PlanCategoryRepo cateRepo;
	
	

	@Override
	public Map<Integer, String> getPlanCategories() {
		
		List<PlanCategory> categoryEntitys = cateRepo.findAll();
		
		Map<Integer, String> categoryMap = new HashMap<Integer, String>();
		
		categoryEntitys.forEach(categories -> {
			categoryMap.put(categories.getCategoryId(), categories.getCategoryName());
		});
		
		return categoryMap;
	}
	
	
	
	
	@Override
	public boolean savePlan(Plan plan) {
		
		 Plan plans = planrepo.save(plan);
		 
		 return plans.getPlanId()!=null ? true : false;  //experianced logic
	}

	
	
	@Override
	public List<Plan> getAllPlans() {
		
	   return planrepo.findAll();
	}

	
	
	@Override
	public Plan getPlanById(Integer PlanId) {
		
	Optional<Plan> opt = planrepo.findById(PlanId);       //ctrl + 1, if u dont know what is return type of that method then u have to take cursor end of the statement and type ctrl+1 and click assign then u can directly return type automatically
		if(opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

	
	
	@Override
	public boolean updatePlan(Plan plan) {
		
         planrepo.save(plan);
         return plan.getPlanId()!=null ? true : false;
			
		}

	
	@Override
	public boolean deletePlanById(Integer planId) {
		
		boolean status = false;
		
		try {
		  planrepo.deleteById(planId);
		  status = true;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	

	
	@Override
	public boolean planSatusChange(Integer planId, String status) {
		
		Optional<Plan> planData = planrepo.findById(planId);
		
		if(planData.isPresent()) {
			
			Plan planGets = planData.get();
			planGets.setActiveSW(status);
			
			planrepo.save(planGets);
			
			return true;
		}
		return false;
	}

}
