package com.cruxBank.www.Account.DAO;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import com.cruxBank.www.Account.api.SignupInfoDto;
import com.cruxBank.www.Registration.DAO.SignupInfo;


@Mapper(componentModel = "spring")
public interface ProfileDataMapper {
	
	public void updateProfileDatafromDto(SignupInfoDto dto,@MappingTarget SignupInfo entity);
}
