package com.service.users.domain.api;

import com.service.users.domain.model.owner.Owner;

public interface IOwnerServicePort {
     Owner saveOwner(Owner owner);
     Owner findUserByEmail(String email);
     Owner findUserById(Long userId);
}
