class Point{
	private double x;
	private double y;

	Point(double x, double y){
		this.x = x;
		this.y = y;
	}

	double getX(){
		return x;
	}
	double getY(){
		return y;
	}

	String getCoor(){
		return x+" and " +y;
	}

	double dotProduct(Point a){
		double product = a.x *x + a.y *y;
		return product;
	}

	boolean equals(Point t){
		return (t.x == x && t.y == y)? true: false;
	}

	String add(Point addPoint){
		double newX = addPoint.x + x;
		double newY = addPoint.y+y;
		

		return newX+","+newY;
	}

}