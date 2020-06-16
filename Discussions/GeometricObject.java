package Discussions;

public class GeometricObject {
	private String objColor = "black";
	private boolean objFilled = false;

	public String getObjColor() {
		return objColor;
	}

	public void setObjColor(String objColor) {
		this.objColor = objColor;
	}

	public boolean isObjFilled() {
		return objFilled;
	}

	public void setObjFilled(boolean objFilled) {
		this.objFilled = objFilled;
	}

	public String toString() {
		String objDescription = "Color: " + objColor;
		objDescription += "\nFilled? " + Boolean.toString(objFilled);
		return objDescription;
	}

	public GeometricObject() {

	}

	public GeometricObject(String objColor, boolean objFilled) {
		this.objColor = objColor;
		this.objFilled = objFilled;
	}

	@SuppressWarnings("unused")
	private static void main(String[] args) {

	}
}
