package lk.nexus.home.nexusportal.util;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import lk.nexus.home.nexusportal.joindto.NexususerDTO;
import lk.nexus.home.nexusportal.models.Nexususerlogin;
import lk.nexus.home.nexusportal.models.Nexususers;

@Service
public class NexusPortalUtil {

	public static boolean isNullOrEmpty(String str) {
		if (str != null && !str.isEmpty())
			return false;
		return true;
	}

	public Nexususers convertNexususersdtoToNexususers(NexususerDTO nexusUserData) {

		Nexususers nexusUser = null;
		// user here is a prepopulated User instance
		try {
			ModelMapper modelMapper = new ModelMapper();
			nexusUser = modelMapper.map(nexusUserData, Nexususers.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nexusUser;
	}
	
public NexususerDTO convertNexususerToNexususersDTO(Nexususers nexusUser) {

		NexususerDTO nexusUserDto = null;

		try {
			ModelMapper modelMapper = new ModelMapper();
			nexusUserDto = modelMapper.map(nexusUser, NexususerDTO.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nexusUserDto;
	}


public List<NexususerDTO> convertNexususerToNexususersDTOList(List<Nexususers> nexusUser) {

	List<NexususerDTO> nexusUserDto = null; 

	try {
//		ModelMapper modelMapper = new ModelMapper();
//		nexusUserDto = (List<NexususerDTO>) modelMapper.m
		nexusUserDto = ObjectMapperUtils.mapAll(nexusUser, NexususerDTO.class);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return nexusUserDto;
}


public List<NexususerDTO> convertNexususerloginToNexususersDTOList(List<Nexususerlogin> nexusUser) {

	List<NexususerDTO> nexusUserDto = null; 

	try {
//		ModelMapper modelMapper = new ModelMapper();
//		nexusUserDto = (List<NexususerDTO>) modelMapper.m
		nexusUserDto = ObjectMapperUtils.mapAll(nexusUser, NexususerDTO.class);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return nexusUserDto;
}


public Nexususerlogin convertNexususersdtoToNexususerlogin(NexususerDTO nexusUserData) {

	Nexususerlogin nexusUser = null;
	// user here is a prepopulated User instance
	try {
		ModelMapper modelMapper = new ModelMapper();
		nexusUser = modelMapper.map(nexusUserData, Nexususerlogin.class);
	} catch (Exception e) {
		e.printStackTrace();
	}
	return nexusUser;
}

}
