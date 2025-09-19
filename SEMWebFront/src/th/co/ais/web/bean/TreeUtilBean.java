package th.co.ais.web.bean;

public class TreeUtilBean extends AbstractBean {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1801914643776543848L;
	
	private String dir;
	private String id;
	private String name;
	private String path;
	private String label;
	private String value;
	private String record;
	private String level;
	
	protected String menuGroup;
	protected String menuSubGroup;
	protected String userLogin;
	
	//2015/02/25 added by.. NEW
	protected String company = "" ;
	protected String region = "";
	protected String elType = "";
	
	@Override
	public int getRowPerPage() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setRowPerPage(int rowPerPage) {
		// TODO Auto-generated method stub

	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getRecord() {
		return record;
	}

	public void setRecord(String record) {
		this.record = record;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getMenuGroup() {
		return menuGroup;
	}

	public void setMenuGroup(String menuGroup) {
		this.menuGroup = menuGroup;
	}

	public String getMenuSubGroup() {
		return menuSubGroup;
	}

	public void setMenuSubGroup(String menuSubGroup) {
		this.menuSubGroup = menuSubGroup;
	}

	public String getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getElType() {
		return elType;
	}

	public void setElType(String elType) {
		this.elType = elType;
	}
	
}
