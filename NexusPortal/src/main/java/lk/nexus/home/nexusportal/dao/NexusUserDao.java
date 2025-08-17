package lk.nexus.home.nexusportal.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import lk.nexus.home.nexusportal.joindto.NexususerDTO;
import lk.nexus.home.nexusportal.models.Nexususerroles;
import lk.nexus.home.nexusportal.repository.NexususerrolesRepository;
import lk.nexus.home.nexusportal.rowmapper.NexususerDTORowMapper;
import lk.nexus.home.nexusportal.rowmapper.RegisterRowMapper;

@Service
@Transactional
public class NexusUserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NexususerrolesRepository nexusRoleRepo;

	public List<NexususerDTO> getNexusLogingUsers1() {

		List<NexususerDTO> nexususerDTOList = new ArrayList<NexususerDTO>();
		try {

			StringBuffer sb = new StringBuffer();
			sb.append(
					"SELECT nul.username,nul.nexusstatus,nu.empid,(select ur.rolename from nexususerroles ur where ur.rolecode = nu.role) as role,");
			sb.append(
					"(select b.branchdescription from branchdetails b where b.branchcode = nu.branch) as branch,nu.user_nic,nu.employeename ");
			sb.append("FROM nexususerlogin nul, nexususers nu ");
			sb.append("WHERE nul.empid = nu.empid and nul.nexusstatus = 'A' order by nul.empid");

			// nexususerDTOList = jdbcTemplate.query(sb.toString(), new
			// NexususerDTORowMapper());
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sb.toString());

			for (Map row : rows) {
				NexususerDTO obj = new NexususerDTO();

				obj.setBranch((String) row.get("branch"));
				obj.setEmpid((String) row.get("empid"));
				obj.setEmployeename((String) row.get("employeename"));
				obj.setRole((String) row.get("role"));
				obj.setUser_nic((String) row.get("user_nic"));
				obj.setUsername((String) row.get("username"));
				obj.setNexusstatus((String) row.get("nexusstatus"));

				nexususerDTOList.add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return nexususerDTOList;
	}

	public List<NexususerDTO> getNexusUsers1() {

		List<NexususerDTO> nexususerDTOList = new ArrayList<NexususerDTO>();
		try {

			StringBuffer sb = new StringBuffer();
			sb.append(
					"SELECT nu.id,nu.empid,(select ur.rolename from nexususerroles ur where ur.rolecode = nu.role) as role,(select b.branchdescription from branchdetails b where b.branchcode = nu.branch)");
			sb.append("as branch,nu.employeename,nu.user_nic ");
			sb.append("FROM nexususers nu ");

			// nexususerDTOList = jdbcTemplate.query(sb.toString(), new
			// NexususerDTORowMapper());
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sb.toString());

			for (Map row : rows) {
				NexususerDTO obj = new NexususerDTO();

				obj.setBranch((String) row.get("branch"));
				obj.setEmpid((String) row.get("empid"));
				obj.setEmployeename((String) row.get("employeename"));
				obj.setRole((String) row.get("role"));
				obj.setUser_nic((String) row.get("user_nic"));
				obj.setUsername((String) row.get("username"));
				obj.setNexusstatus((String) row.get("nexusstatus"));

				nexususerDTOList.add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return nexususerDTOList;
	}

	public List<NexususerDTO> getNexusLogingUsersbyEmpId123(String empid) {

		List<NexususerDTO> nexususerDTOList = new ArrayList<NexususerDTO>();
		try {

			StringBuffer sb = new StringBuffer();
			sb.append(
					"SELECT nul.username,nul.nexusstatus,nu.empid,(select ur.rolename from nexususerroles ur where ur.rolecode = nu.role) as roleDesc,");
			sb.append(
					"(select b.branchdescription from branchdetails b where b.branchcode = nu.branch) as branchDesc,nu.user_nic,nu.employeename,nu.role,nu.branch ");
			sb.append("FROM nexususerlogin nul, nexususers nu ");
			sb.append("WHERE nul.empid = nu.empid and nu.empid= ? order by nul.empid");

			// nexususerDTOList = jdbcTemplate.query(sb.toString(), new
			// NexususerDTORowMapper());
			List<Map<String, Object>> rows = jdbcTemplate.queryForList(sb.toString(), new Object[] { empid });

			// jdbcTemplate.queryForList(sql, elementType, args)

			for (Map row : rows) {
				NexususerDTO obj = new NexususerDTO();

				obj.setBranch((String) row.get("branchDesc"));
				obj.setEmpid((String) row.get("empid"));
				obj.setEmployeename((String) row.get("employeename"));
				obj.setRole((String) row.get("roleDesc"));
				obj.setUser_nic((String) row.get("user_nic"));
				obj.setUsername((String) row.get("username"));
				obj.setNexusstatus((String) row.get("nexusstatus"));
				obj.setBranchCode((String) row.get("role"));
				obj.setRoleCode((String) row.get("branch"));

				nexususerDTOList.add(obj);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return nexususerDTOList;
	}

	public NexususerDTO getNexusUsersbyEmpId(String empid) {

		// List<NexususerDTO> nexususerDTOList = new ArrayList<NexususerDTO>();
		NexususerDTO nexususerDTO = null;
		try {

			StringBuffer sb = new StringBuffer();
			sb.append(
					"SELECT nu.empid,(select ur.rolename from nexususerroles ur where ur.rolecode = nu.role) as roleDesc, ");
			sb.append(
					"(select b.branchdescription from branchdetails b where b.branchcode = nu.branch) as branchDesc,nu.user_nic,nu.employeename,nu.role,nu.branch ");
			sb.append("FROM nexususers nu WHERE nu.empid = ? ");

			// nexususerDTOList = jdbcTemplate.query(sb.toString(), new
			// NexususerDTORowMapper());
			nexususerDTO = jdbcTemplate.queryForObject(sb.toString(), new Object[] { empid },
					new NexususerDTORowMapper());

		} catch (Exception e) {
			e.printStackTrace();
		}

		return nexususerDTO;
	}

	public ArrayList<Nexususerroles> getNexusUserRoleList() {

		ArrayList<Nexususerroles> roleList = (ArrayList<Nexususerroles>) nexusRoleRepo.findAll();

		return roleList;

	}
}
