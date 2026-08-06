package com.lynkattu.shop.repository;

import com.lynkattu.shop.component.MembershipGenerator;
import com.lynkattu.shop.model.UserRequest;
import com.lynkattu.shop.model.UserResponse;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.Optional;
import java.util.UUID;

public class UserRepository {
    private final JdbcClient jdbc;

    public UserRepository(JdbcClient jdbc) {
        this.jdbc = jdbc;
    }

    @Transactional
    public Optional<UserResponse> createUser(UserRequest userRequest) {
        String id = UUID.randomUUID().toString().replace("-", "");
        String membershipNumber = MembershipGenerator.generateMembershipNumber();
        jdbc.sql(
                """
                INSERT INTO users (
                    id,
                    firstname,
                    lastname,
                    email,
                    phone,
                    address,
                    postalcode,
                    city,
                    country,
                    username,
                    password,
                    membershipNumber
                )
                VALUES (
                    UNHEX(:id),
                    :firstname,
                    :lastname,
                    :email,
                    :phone,
                    :address,
                    :postalcode,
                    :city,
                    :country,
                    :username,
                    :password,
                    :membershipNumber
                )
                """)
                .param("id", id)
                .param("firstname", userRequest.firstname())
                .param("lastname", userRequest.lastname())
                .param("email", userRequest.email())
                .param("phone", userRequest.phone())
                .param("address", userRequest.address())
                .param("postalcode", userRequest.postalcode())
                .param("city", userRequest.city())
                .param("country", userRequest.country())
                .param("username", userRequest.username())
                .param("password", userRequest.password())
                .param("membershipNumber", membershipNumber)
                .update();

        return jdbc.sql("""
                SELECT *
                FROM users
                WHERE id = UNHEX(:id)
                """)
                .param("id", id)
                .query(UserResponse.class)
                .optional();
    }
}
