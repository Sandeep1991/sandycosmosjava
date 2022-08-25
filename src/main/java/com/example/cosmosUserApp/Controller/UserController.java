package com.example.cosmosUserApp.Controller;

import com.example.cosmosUserApp.Model.User;
import com.example.cosmosUserApp.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class UserController {
    @Autowired
    private UserRepository repository;

    @RequestMapping(value="user",method = RequestMethod.POST)
    /*
    @RequestParam("fn") String firstName,
            @RequestParam("ln") String lastName,
            @RequestParam("add") String address
    * */
    public final void addUser(
            @RequestBody UserEntity userEntity
    ) {
        final User newUser = new User(userEntity.fn, userEntity.ln, userEntity.add);
        final Mono<User> saveUserMono =
                this.repository.save(newUser);
        saveUserMono.block();
    }

    @RequestMapping(value="allUsers",method = RequestMethod.GET)
    public final Flux<User> getAllUsers(@RequestParam("fn") String firstName) {

        // measure DB query benchmark

        var users = repository.findAll();
        return users;
    }

    private static class UserEntity
    {
        public String fn;
        public String ln;
        public String add;
    }
}
