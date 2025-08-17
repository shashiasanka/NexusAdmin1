package lk.nexus.home.nexusportal.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;

import lk.nexus.home.nexusportal.dto.RegisterDto;

public class RegisterRowMapper implements RowMapper<RegisterDto> {

	@Override
	public RegisterDto mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		    System.out.println("RegisterDto:::::::::::::"+rs.getFetchSize());
	
			RegisterDto r = new RegisterDto();
			
			r.setId(rs.getLong("id"));
			r.setAccountHolderName(rs.getString("accountholdername"));
			r.setAccountid(rs.getString("accountid"));
			
			//r.setAccouttype(rs.getString("account_holder_name"));
			//brnamedesc custbankdesc custbankbranchdesc accountholdername
			r.setAddress1(rs.getString("address1"));
			//*****
			r.setBankAccountBranchDesc(rs.getString("custbankbranchdesc"));
			r.setBankAccountBranch(rs.getString("bankaccountbranch"));  
			r.setBankAccountType(rs.getString("bankaccounttype"));
			//***********
			r.setBankNameDesc(rs.getString("custbankdesc"));
			r.setBankName(rs.getString("bankname"));			
			
			r.setBrno(rs.getString("brno"));
			r.setBusinessName(rs.getString("businessname"));
			r.setCity(rs.getString("city"));
			r.setClientreferential(rs.getString("clientreferential"));
			r.setContactno(rs.getString("contactno"));
			r.setContactperson(rs.getString("contactperson"));
			
			r.setEmailaddress(rs.getString("emailaddress"));
			r.setFullname_businessname(rs.getString("fullname_businessname"));
			
			r.setNic_drivinglicence(rs.getString("nic_drivinglicence"));
			r.setSystemName(rs.getString("systemname"));
			r.setWebstore(rs.getString("webstore"));
			//*********************************
			r.setPickupbranchDesc(rs.getString("brnamedesc"));
			r.setPickupbranch(rs.getString("pickupbranch"));
			
			r.setPayementtype(rs.getString("payementtype"));
			r.setId(rs.getLong("id"));
			
			r.setAccouttype(rs.getString("accouttype"));
			
			r.setRelationshiptobusiness(rs.getString("relationshiptobusiness"));
			if(rs.getString("accouttype").equals("b")) {
				r.setAccouttypedesc("Business");
			}else {
				
				r.setAccouttypedesc("Personal");
			}
			
			r.setBankAccountType(rs.getString("bankaccounttype"));
			r.setSmsalert(rs.getString("smsalert"));
			//r.setPayementtype(rs.getString("payementtype"));
			r.setContactpersonnic(rs.getString("contactpersonnic"));
			
			r.setContactno2(rs.getString("contactno2"));
			r.setWebstore(rs.getString("webstore"));
			
			
//			r.setAccountHolderName(rs.getString("fullname_businessname"));
//			r.setSystemName(rs.getString("systemName"));
//			r.setEmailaddress(rs.getString("emailaddress"));
//			r.setPickupbranch(rs.getString("pickupbranch"));
//			r.setNic_drivinglicence(rs.getString("nic_drivinglicence"));
			//ls.add(r);
			
			return r;
		
		
		//return r;
	}

	
	
}
