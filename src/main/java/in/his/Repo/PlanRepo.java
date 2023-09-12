package in.his.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.his.entity.Plan;

public interface PlanRepo extends JpaRepository<Plan, Integer> {

}
