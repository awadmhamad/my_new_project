import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.GraphicsConfiguration;

import javax.media.j3d.Alpha;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.RotationInterpolator;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.vecmath.Point3d;

public class HelloUniverse extends Applet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BranchGroup createSceneGraph() {
        // Create the root of the branch graph
        BranchGroup objRoot = new BranchGroup();

        // Create the TransformGroup node and initialize it to the
        // identity. Enable the TRANSFORM_WRITE capability so that
        // our behavior code can modify it at run time. Add it to
        // the root of the subgraph.
        TransformGroup objTrans = new TransformGroup();
        objTrans.setCapability(
                            TransformGroup.ALLOW_TRANSFORM_WRITE);
        objRoot.addChild(objTrans);
        // Create a simple Shape3D node; add it to the scene graph.
        objTrans.addChild(new ColorCube().getShape());

        // Create a new Behavior object that will perform the
        // desired operation on the specified transform and add
        // it into the scene graph.
        Transform3D yAxis = new Transform3D();
        Alpha rotationAlpha = new Alpha(
                -1, Alpha.INCREASING_ENABLE,
                0, 0,            4000, 0, 0,                        0, 0, 0);
        RotationInterpolator rotator = new RotationInterpolator(
                rotationAlpha, objTrans, yAxis,
                0.0f, (float) Math.PI*2.0f);
        BoundingSphere bounds =
            new BoundingSphere(new Point3d(0.0,0.0,0.0), 100.0);
        rotator.setSchedulingBounds(bounds);
        objTrans.addChild(rotator);

        return objRoot;
    }

    public HelloUniverse() {
        setLayout(new BorderLayout());
        GraphicsConfiguration graphicsConfig =getGraphicsConfiguration();
		Canvas3D c = new Canvas3D(graphicsConfig);
        add("Center", c);
        // Create a simple scene and attach it to the virtual
        // universe
        BranchGroup scene = createSceneGraph();
        UniverseBuilder u = new UniverseBuilder(c);
        u.addBranchGraph(scene);
    }
    
    public static void main(){
    	HelloUniverse universe=new HelloUniverse();
    }
}