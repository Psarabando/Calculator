package calculator_api_rest.repository;

import calculator_api_rest.entity.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculationRepository extends JpaRepository<Calculation, Integer> {



}
