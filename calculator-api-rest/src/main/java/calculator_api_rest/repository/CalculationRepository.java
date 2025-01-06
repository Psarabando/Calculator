package calculator_api_rest.repository;

import calculator_api_rest.entity.Calculation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CalculationRepository extends JpaRepository<Calculation, Integer> {

    List<Calculation> findAllByUserIdOrderById(Integer id);

}
