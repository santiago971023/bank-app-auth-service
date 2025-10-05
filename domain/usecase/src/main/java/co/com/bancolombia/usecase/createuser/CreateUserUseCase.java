package co.com.bancolombia.usecase.createuser;

import co.com.bancolombia.model.user.User;
import co.com.bancolombia.model.user.exceptions.UserAlreadyExistsException;
import co.com.bancolombia.model.user.gateways.UserRepositoryOut;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

import java.util.logging.Logger;

@RequiredArgsConstructor
public class CreateUserUseCase {

    private final static Logger LOGGER = Logger.getLogger(CreateUserUseCase.class.getName());

    private final UserRepositoryOut userRepository;

    public Mono<User> createUser(User user) {

        LOGGER.info("Empezando método 'createUser' en mi 'CreateUserUseCase'");

        return userRepository.existsByEmail(user.getEmail())
                .flatMap(exists -> {
                    if(exists) {
                        LOGGER.info("Usuario ya existe");
                        return Mono.<User>error(new UserAlreadyExistsException("User already exists"));
                    }
                    return Mono.empty();
                })
                .switchIfEmpty(Mono.defer( () -> {
                    LOGGER.info("Guardando usuario.");
                    return userRepository.save(user);
                }));
    }
}
