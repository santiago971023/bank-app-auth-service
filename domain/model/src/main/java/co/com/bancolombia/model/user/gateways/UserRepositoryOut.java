package co.com.bancolombia.model.user.gateways;

import co.com.bancolombia.model.user.User;
import reactor.core.publisher.Mono;

public interface UserRepositoryOut {

    public Mono<User> save(User user);

    public Mono<Boolean> existsByEmail(String email);

}
