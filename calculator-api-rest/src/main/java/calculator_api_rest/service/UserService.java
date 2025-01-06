package calculator_api_rest.service;

import calculator_api_rest.entity.User;
import calculator_api_rest.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User signIn(User newUser) {
        return userRepository.save(newUser);
    }

    public User login() {
        return null;
    }

    public User getUserById(Integer id) {
        Optional<User> userOpt = userRepository.findById(id);

        if (userOpt.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found.");
        }

        return userOpt.get();
    }

    public void deleteUser(Integer id) {

        User user = userRepository.findById(id).
                orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found."));

        userRepository.deleteById(id);
    }

    public User editUser(User userEdited) {

        if (!userRepository.existsById(userEdited.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found a user with thats Id");
        }

        return userRepository.save(userEdited);
    }

}
