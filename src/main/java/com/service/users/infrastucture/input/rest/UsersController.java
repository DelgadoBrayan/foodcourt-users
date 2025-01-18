package com.service.users.infrastucture.input.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.service.users.application.dto.users.UsersRequest;
import com.service.users.application.handler.UsersHandler;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/owner/users")
@RequiredArgsConstructor
public class UsersController {
    private final UsersHandler usersHandler;

      @PostMapping("/{restaurantId}/employee")
    public ResponseEntity<Void> createEmployee(@PathVariable Long restaurantId,
                                               @Valid @RequestBody UsersRequest employeeRequest, 
                                               @RequestHeader("Authorization") String authorizationHeader) {
                                                
        String token = authorizationHeader.replace("Bearer ", "");                                      
        usersHandler.saveEmployee(employeeRequest,token, restaurantId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/client")
    public ResponseEntity<Void> createClient(@Valid @RequestBody UsersRequest clientRequest) {
        usersHandler.saveClient(clientRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UsersRequest> getOwnerBiId(@PathVariable Long userId,  @RequestHeader("Authorization") String authorizationHeader) {
        UsersRequest user = usersHandler.findUserById(userId);
        return ResponseEntity.status(HttpStatus.OK).body(user);
    }

}
