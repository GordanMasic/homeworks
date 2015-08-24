package homeworkW13D5.ORM;
public abstract class Model {

	@SuppressWarnings("unused")
	private String tableName;

	public Model(String tableName) {
		this.tableName = tableName;
	}

	public String findByPk(Integer id, String tableName) {
		return String
				.format("SELECT * FROM %s  WHERE id = %d ;", tableName, id);
	}

	public String findByAttribute(String tableName, String value) {
		return String.format("SELECT * FROM %s WHERE value = \"%s\"; ",
				tableName, value);
	}

}
