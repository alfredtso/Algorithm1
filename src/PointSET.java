import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.RectHV;
import edu.princeton.cs.algs4.SET;
import edu.princeton.cs.algs4.StdDraw;

import java.util.Queue;
import java.util.TreeSet;

public class PointSET {

    private TreeSet<Point2D> myTree;

    // TODO: Corner cases: exception if any argument is null
    // TODO: Performance requirement insert() and contains() log n worst case,
    // TODO: Performance requirement nearest() and range() n

    // construct an empty set of points
    public PointSET() {

        myTree = new TreeSet<>();
    }

    // is the set empty?
    public boolean isEmpty() {
        return myTree.isEmpty();
    }

    // number of points in the set
    public int size() {
        return myTree.size();
    }

    // add the point to the set (if it is not already in the set)
    public void insert(Point2D p) {
        myTree.add(p);
    }

    // does the set contain point p?
    public boolean contains(Point2D p) {
        return myTree.contains(p);
    }

    // draw all points to standard draw
    public void draw() {
        StdDraw.setPenRadius(0.01);
        for (Point2D p: myTree) {
            StdDraw.point(p.x(), p.y());
        }
    }

    // all points that are inside the rectangle (or on the boundary)
    public Iterable<Point2D> range(RectHV rect) {


        // initiate a set for holding the points
        SET<Point2D> myInside = new SET<>();

        for (Point2D p: myTree) {
            if (rect.contains(p)) {
                myInside.add(p);
            }
        }
        // performance linear to size of myTree
        return myInside;
    }

    // a nearest neighbor in the set to point p; null if the set is empty
    public Point2D nearest(Point2D p) {
        double champion = 0.0;
        Point2D champ = p;

        if (myTree.isEmpty()) { return null; }

        for (Point2D myP: myTree) {
            if (myP.distanceTo(p) >= champion){
                champ = myP;
            }
        }
        return champ;
    }

    // unit testing of the methods (optional)
    public static void main(String[] args) {
        Point2D first = new Point2D(0.5,0.5);
        Point2D second = new Point2D(0.3,0.3);
        PointSET mySet = new PointSET();
        mySet.insert(first);
        mySet.insert(second);
        mySet.draw();
    }
}

