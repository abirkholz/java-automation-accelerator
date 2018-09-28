package jsonClasses;

public class ToDo {
	public Integer userId;
	public Integer id;
	public String title;
	public Boolean completed;
	
	/**
	 * Initialize ToDo class
	 */
	public ToDo(Integer userId, Integer id, String title, Boolean completed) {
		this.userId = userId;
		this.id = id;
		this.title = title;
		this.completed = completed;
	}
}
