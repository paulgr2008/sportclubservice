package sportclub.model;


import java.io.IOException;

import javax.persistence.*;

@Entity
public class EquipmentPool {
	
	@Id@Column(name="equipmentPoolId")
	@GeneratedValue
	int id;
	
	
	String name;
	@Override
	public String toString() {
		
		return "{\"id\""+"\"name\":"+name+",\"description\":"+description+"\""+"]}";
	}

	String description;
	

	public EquipmentPool() {	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
	

}
