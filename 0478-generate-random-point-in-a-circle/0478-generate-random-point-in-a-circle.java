class Solution {

    double radius, x_center, y_center;
    Random rand = new Random();

    public Solution(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double r = radius * Math.sqrt(rand.nextDouble());
        double theta = 2 * Math.PI * rand.nextDouble();

        return new double[]{
            x_center + r * Math.cos(theta),
            y_center + r * Math.sin(theta)
        };
    }
}