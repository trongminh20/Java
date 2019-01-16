class geometry{
	private double numberOfEdges;
	private double width;
	private double heigh;
	
	geometry(double width, double heigh){
		this.width =width;
		this.heigh =heigh;
	}
	void setSides(double w, double h){
		width = w;
		heigh = h;
	}
	double area(){
		return width*heigh;
	}

	double perimeter(double w, double h){
		return (w+h)*2;
	}
}