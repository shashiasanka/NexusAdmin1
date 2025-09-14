package lk.nexus.client.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:nexusclient.properties")
@ConfigurationProperties
public class NexusClientConf {
	
	@Value("${nexclientuploadpath}")
    private String nexclientuploadpath;

	//@Value("${nexclienttemplatepath}")
	//private String nexclienttemplatepath;
	
	@Value("${nexclient_generate_file_path}")
	private String nexclient_generate_file_path;
	
	@Value("${nexclient_generate_file}")
	private String nexclient_generate_file;
	
	public String getNexclientuploadpath() {
		return nexclientuploadpath;
	}

	public void setNexclientuploadpath(String nexclientuploadpath) {
		this.nexclientuploadpath = nexclientuploadpath;
	}

//	public String getNexclienttemplatepath() {
//		return nexclienttemplatepath;
//	}
//
//	public void setNexclienttemplatepath(String nexclienttemplatepath) {
//		this.nexclienttemplatepath = nexclienttemplatepath;
//	}

	public String getNexclient_generate_file_path() {
		return nexclient_generate_file_path;
	}

	public void setNexclient_generate_file_path(String nexclient_generate_file_path) {
		this.nexclient_generate_file_path = nexclient_generate_file_path;
	}

	public String getNexclient_generate_file() {
		return nexclient_generate_file;
	}

	public void setNexclient_generate_file(String nexclient_generate_file) {
		this.nexclient_generate_file = nexclient_generate_file;
	}
	
	
	

}
