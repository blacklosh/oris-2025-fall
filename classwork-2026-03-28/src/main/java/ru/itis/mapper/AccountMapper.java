package ru.itis.mapper;

import org.mapstruct.Mapper;
import ru.itis.dto.rq.AccountRequest;
import ru.itis.dto.rs.AccountResponse;
import ru.itis.entity.AccountEntity;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    AccountResponse toResponse(AccountEntity entity);

    AccountEntity toEntity(AccountRequest request);

}
