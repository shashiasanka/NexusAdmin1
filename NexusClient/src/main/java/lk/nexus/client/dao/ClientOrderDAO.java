package lk.nexus.client.dao;

import lk.nexus.client.dto.ClientOrderDto;
import lk.nexus.client.models.Clientorder;

public interface ClientOrderDAO {

	public ClientOrderDto getClientorderbyTrackingId(String trackingId);
	
}
