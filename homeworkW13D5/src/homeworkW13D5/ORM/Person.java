package homeworkW13D5.ORM;

public class Person extends Model {

	private String tableName;
	private String value;
	private Integer id;

	public Person(String tableName, String value, Integer id) {
		super(tableName);
		this.value = value;
		this.id = id;
	}

	@Override
	public String findByPk(Integer id, String tableName) {
		return super.findByPk(id, tableName);
	}

	@Override
	public String findByAttribute(String tableName, String value) {
		return super.findByAttribute(tableName, value);
	}

	public String getTableName() {
		return tableName;
	}

	public String getValue() {
		return value;
	}

	public Integer getId() {
		return id;
	}

}
