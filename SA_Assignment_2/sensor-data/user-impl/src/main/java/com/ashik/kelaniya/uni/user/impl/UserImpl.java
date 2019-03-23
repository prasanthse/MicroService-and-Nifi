package com.ashik.kelaniya.uni.user.impl;

import akka.Done;
import akka.NotUsed;
import com.ashik.kelaniya.uni.user.api.User;
import com.ashik.kelaniya.uni.user.api.UserService;
import com.google.inject.Inject;
import com.lightbend.lagom.javadsl.api.ServiceCall;

import java.util.concurrent.CompletableFuture;

public class UserImpl implements UserService {
    private final UserRepository userRepository;

    @Inject
    public UserImpl(UserRepository userRepository) {
        this.userRepository =userRepository;
    }

    @Override
    public ServiceCall<NotUsed, User> getUserById(String id){
        //System.out.println("get product by id method is called with id "+ id);

        //  ProductRepository productRepository=new InMemoryUserRepository();
        return request -> CompletableFuture.completedFuture(userRepository.getUser(id));
    }

    @Override
    public ServiceCall<User, Done> addUser() {


        return request -> {

            userRepository.save(request);//requst contaion producr object

//            System.out.println(requst.getId());
//            System.out.println(requst.getDescription());
//            System.out.println(requst.getUnitPrice());
            //save the product in database

            return   CompletableFuture.completedFuture(Done.getInstance());

        };
    }

}
