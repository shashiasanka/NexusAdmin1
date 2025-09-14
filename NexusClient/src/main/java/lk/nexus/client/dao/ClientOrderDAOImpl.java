package lk.nexus.client.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lk.nexus.client.dto.ClientOrderDto;
import lk.nexus.client.rowmappers.ClientOrderRowmapper;

@Component
public class ClientOrderDAOImpl implements ClientOrderDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Override
	public ClientOrderDto getClientorderbyTrackingId(String trackingId) {

		StringBuffer sb = new StringBuffer();
		//SELECT *,(select p.name_en from provinces p where p.id = co.province) as prodesc, (select d.name_en from districts d where d.id = co.district) disdesc FROM clientorder co where co.ordertrackingid ='92767846'
		
		sb.append("SELECT *,(select p.name_en from provinces p where p.id = co.province) AS provdesc, (select d.name_en from districts d where d.id = co.district) AS distdesc, ");
		sb.append("(SELECT os.statusdescription FROM orderstatus os where os.statuscode = co.orderstatus) as orderstatusdesc FROM clientorder co ");
		sb.append("where co.ordertrackingid = ? ");
		
		ClientOrderDto x = null;
		
		x =  jdbcTemplate.queryForObject(sb.toString(), new Object[] { trackingId }, new ClientOrderRowmapper());
		
		
		return x;
	}

}
