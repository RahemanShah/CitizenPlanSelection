package in.his.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.his.entity.PlanCategory;

public interface PlanCategoryRepo extends JpaRepository<PlanCategory, Integer> {

}
