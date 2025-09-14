package lk.nexus.client.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import lk.nexus.client.dto.ClientOrderDto;
import lk.nexus.client.rowmappers.ClientOrderRowmapper;



@Service
@Transactional
public class SearchService {

	private static final Logger logger = LogManager.getLogger(SearchService.class);
	//NexussubcatRepository  NexusmaincatRepository NexusitemRepository
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<ClientOrderDto> getClientOrderList(String clientid) {
		List<ClientOrderDto> clientorderlist = null;
		try {
			
			StringBuffer sb = new StringBuffer();
			sb.append("select *,(SELECT os.statusdescription FROM orderstatus os where os.statuscode = co.orderstatus) as orderstatusdesc ");
			sb.append("from clientorder co ");
			sb.append("where co.clientid = ? ");

			clientorderlist = jdbcTemplate.query(sb.toString(), new Object[] { clientid }, new ClientOrderRowmapper());
	//
		} catch (Exception e) {
			e.printStackTrace();
		}
		return clientorderlist;
		//select *,(SELECT os.statusdescription FROM orderstatus os where os.statuscode = co.orderstatus) as orderstatusdesc 
		//from clientorder co 
		//where co.clientid = '100106001729';
		
		
	}
		
	
}
