package my_classes;

public class ShapeTools {
	
	public Tools getTools(String shapeType) {
		if(shapeType == null) {
			return null;
		}
		if (shapeType.equalsIgnoreCase("Concrete")) {
			return new Concrete();
		}
		else if(shapeType.equalsIgnoreCase("Woodwork")) {
			return new Woodwork();
		}
		else if(shapeType.equalsIgnoreCase("Plumbing")) {
			return new Plumbing();
		}
		else if(shapeType.equalsIgnoreCase("Yardwork")) {
			return new Yardwork();
		}
		else if(shapeType.equalsIgnoreCase("Paint")) {
			return new Paint();
		}
		
		return null;
	}
}
