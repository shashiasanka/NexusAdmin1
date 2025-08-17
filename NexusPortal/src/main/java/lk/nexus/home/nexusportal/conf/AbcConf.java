package lk.nexus.home.nexusportal.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:abc.properties")
@ConfigurationProperties
public class AbcConf {

	@Value("${aaa}")
    private String aaa;
	
	@Value("${nexusclientipurl}")
	private String nexusclientipurl;
	

	public String getAaa() {
		return aaa;
	}

	public void setAaa(String aaa) {
		this.aaa = aaa;
	}

	public String getNexusclientipurl() {
		return nexusclientipurl;
	}

	public void setNexusclientipurl(String nexusclientipurl) {
		this.nexusclientipurl = nexusclientipurl;
	}
	
	
	
	
	
}
