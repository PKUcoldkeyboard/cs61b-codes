/**
 * @author cuterwrite
 * @date 2021/12/8-21:50
 */
public class Planet {
    public String imgFileName;
    public double mass;
    public double xxPos;
    public double xxVel;
    public double yyPos;
    public double yyVel;
    private static final double G = 6.67E-11;

    public Planet(double xP, double yP, double xV, double yV, double m, String img) {
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }

    public Planet(Planet p) {
        this.xxPos = p.xxPos;
        this.yyPos = p.yyPos;
        this.xxVel = p.xxVel;
        this.yyVel = p.yyVel;
        this.mass = p.mass;
        this.imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet other) {
        return Math.sqrt((xxPos - other.xxPos) * (xxPos - other.xxPos) +
                (yyPos - other.yyPos) * (yyPos - other.yyPos));
    }

    public double calcForceExertedBy(Planet other) {
        double r = calcDistance(other);
        return (G * mass * other.mass) / (r * r);
    }

    public double calcForceExertedByX(Planet other) {
        double dx = other.xxPos - xxPos;
        double r = calcDistance(other);
        double F = calcForceExertedBy(other);
        return (F * dx) / r;
    }

    public double calcForceExertedByY(Planet other) {
        double dy = other.yyPos - yyPos;
        double r = calcDistance(other);
        double F = calcForceExertedBy(other);
        return (F * dy) / r;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets) {
        double res = 0.0;
        for (Planet p : allPlanets) {
            if (this.equals(p)) {
                continue;
            }
            res += calcForceExertedByX(p);
        }
        return res;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets) {
        double res = 0.0;
        for (Planet p : allPlanets) {
            if (this.equals(p)) {
                continue;
            }
            res += calcForceExertedByY(p);
        }
        return res;
    }

    public void update(double time, double forceX, double forceY) {
        // calculate the acceleration
        double accelerationX = forceX / mass;
        double accelerationY = forceY / mass;

        // calculate the new velocity
        double xxVelNew = xxVel + time * accelerationX;
        double yyVelNew = yyVel + time * accelerationY;

        // calculate the new position
        double xxPosNew = xxPos + time * xxVelNew;
        double yyPosNew = yyPos + time * yyVelNew;

        // update
        this.xxPos = xxPosNew;
        this.yyPos = yyPosNew;
        this.xxVel = xxVelNew;
        this.yyVel = yyVelNew;
    }

    public void draw() {
        StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}
