package redis.obj;

import java.io.Serializable;

/**
@author junmeng.xu
@date  2016年4月14日下午5:53:28
 */
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private long id;

	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}
