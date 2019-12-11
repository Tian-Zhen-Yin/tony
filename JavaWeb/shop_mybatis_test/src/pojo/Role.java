package pojo;

import java.io.Serializable;

//角色对象
public class Role implements Serializable{
	private int id;
	private String roleName;
	private String roleCode;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	@Override
	public String toString() {
		return "Role [rid=" + id + ", rolename=" + roleName + "]";
	}
	
}
