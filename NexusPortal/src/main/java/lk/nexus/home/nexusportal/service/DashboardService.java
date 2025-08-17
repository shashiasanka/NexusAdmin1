package lk.nexus.home.nexusportal.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lk.nexus.home.nexusportal.dto.DashboardResults;
import lk.nexus.home.nexusportal.repository.DashboardRepository;



@Service
@Transactional
public class DashboardService {
	
	@Autowired
	DashboardRepository repojdbc;
	
	
	
	public DashboardResults getOrderDetailstoDashboard() {
		DashboardResults dasboard = null;
		dasboard = repojdbc.getDashboardResultofaClient();
		
		return dasboard;
	}

}
