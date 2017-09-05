package Concepts;

public enum ProjectileOrigin {

	Laser("laser", 15), Missle("missle", 25);
	
	
	String projectileName;
	int damage;
	
	
	ProjectileOrigin(String projectileName, int damage){
		
		this.projectileName = projectileName;
		this.damage = damage;
		
	}
}
