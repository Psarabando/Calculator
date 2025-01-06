package calculator_api_rest.service;

import calculator_api_rest.entity.Calculation;
import calculator_api_rest.entity.User;
import calculator_api_rest.repository.CalculationRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class CalculationService {

    private final CalculationRepository calculationRepository;
    private final UserService userService;

    public Calculation saveCalculation(Calculation calculation, Integer idUserOwner) {

        calculation.setUser(userService.getUserById(idUserOwner));
        return calculationRepository.save(calculation);
    }

    public List<Calculation> getCalculationsOfUser(Integer idUserOwner) {

        if (idUserOwner == null) {
            throw new IllegalStateException("Invalid argument: user Id");
        }

        return calculationRepository.findAllByUserIdOrderById(idUserOwner);

    }

    public void deleteCalculation(Integer id) {

        Calculation calculation = calculationRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Calculation not found."));

        calculationRepository.deleteById(id);

    }

}
