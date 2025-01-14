package com.service.users.domain.spi;

import com.service.users.domain.model.owner.Owner;

public interface IOwnerPersistencePort {
    Owner saveOwner(Owner owner);
}
