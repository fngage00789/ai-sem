package th.co.ais.domain.authorize;

import java.io.Serializable;

import org.hibernate.envers.Audited;

@Audited
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String username;
	private String password;

	public User() {
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
