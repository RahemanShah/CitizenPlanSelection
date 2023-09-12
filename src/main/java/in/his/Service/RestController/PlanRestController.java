package in.his.Service.RestController;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.his.Constant.AppConstant;
import in.his.Properties.AppProperties;
import in.his.Service.PlanServices;
import in.his.entity.Plan;

@RestController
public class PlanRestController {
	
	
	
	@Autowired
	private PlanServices service;
	
	@Autowired
	private AppProperties appProp;
		
	
	@GetMapping("/category")
	public ResponseEntity<Map<Integer, String>> planCategories(){
		
		Map<Integer, String> planCategories = service.getPlanCategories();
		return new ResponseEntity<>(planCategories, HttpStatus.OK);
	}
	
	
	
	@PostMapping("/plan")
	public ResponseEntity<String> savedPlans(@RequestBody Plan plan){
		
		boolean savePlan = service.savePlan(plan);
		String Msg = AppConstant.EMPTY_STR;
		
		Map<String, String> messages = appProp.getMessages();
		
		if(savePlan) {
			Msg = messages.get(AppConstant.PLAN_SAVE_SUCC);
		}
		else {
			Msg = messages.get(AppConstant.PLAN_SAVE_FAILED);
		}
		
		return new ResponseEntity<>(Msg, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/plans")
	public ResponseEntity<List<Plan>> getAllPlans(){
		
		List<Plan> allPlans = service.getAllPlans();
		
		return new ResponseEntity<>(allPlans, HttpStatus.OK);
		
	}
	
	
	@GetMapping("/plan/{planId}")
	public ResponseEntity<Plan> gettingPlanId(@PathVariable Integer planId){
		
		Plan planById = service.getPlanById(planId);
		
		return new ResponseEntity<>(planById, HttpStatus.OK);
	}
	
	

	@PutMapping("/plan")
	public ResponseEntity<String> updatePlanData(@RequestBody Plan planId){
		
		boolean updatePlan = service.updatePlan(planId);
		String Msg = AppConstant.EMPTY_STR;
		
		Map<String, String> messages = appProp.getMessages();
		
		if(updatePlan) {
			Msg = 	messages.get(AppConstant.PLAN_UPDATE_SUCC);
		}
		else {
			Msg = messages.get(AppConstant.PLAN_UPDATE_FAILED);
		}
		return new ResponseEntity<>(Msg, HttpStatus.OK);
	}
	
	
	
	
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlans(@PathVariable Integer planId){
		
		boolean deletePlanById = service.deletePlanById(planId);
		String Msg = AppConstant.EMPTY_STR;
		
		Map<String, String> messages = appProp.getMessages();
		
		if(deletePlanById) {
			Msg = messages.get(AppConstant.PLAN_DELETE_SUCC);
		}
		else {
			Msg = messages.get(AppConstant.PLAN_DELETE_FAILED);
		}
		
		return new ResponseEntity<>(Msg, HttpStatus.OK);
	}
	
	
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> StatusChanged(@PathVariable Integer planId, String status){
		
		boolean planSatusChange = service.planSatusChange(planId, status);
		String Msg = AppConstant.EMPTY_STR;
		
		Map<String, String> messages = appProp.getMessages();
		
		if(planSatusChange) {
		   Msg = messages.get(AppConstant.PLAN_STATUS_CHANGED);
		}
		else {
			Msg = messages.get(AppConstant.PLAN_STATUS_CHANGE_FAIL);
		}
		
		return new ResponseEntity<>(Msg, HttpStatus.OK);
	}
	
	
	
	
	

}
