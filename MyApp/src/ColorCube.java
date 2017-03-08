import javax.media.j3d.Appearance;
import javax.media.j3d.QuadArray;
import javax.media.j3d.Shape3D;

public class ColorCube extends Object {
    private static final float[] verts = {
    // front face
         1.0f, -1.0f,  1.0f,                             1.0f,  1.0f,  1.0f,
        -1.0f,  1.0f,  1.0f,                            -1.0f, -1.0f,  1.0f,
    // back face
        -1.0f, -1.0f, -1.0f,                            -1.0f,  1.0f, -1.0f,
         1.0f,  1.0f, -1.0f,                             1.0f, -1.0f, -1.0f,
    // right face
         1.0f, -1.0f, -1.0f,                             1.0f,  1.0f, -1.0f,
         1.0f,  1.0f,  1.0f,                             1.0f, -1.0f,  1.0f,
    // left face
        -1.0f, -1.0f,  1.0f,                            -1.0f,  1.0f,  1.0f,
        -1.0f,  1.0f, -1.0f,                            -1.0f, -1.0f, -1.0f,
    // top face
         1.0f,  1.0f,  1.0f,                             1.0f,  1.0f, -1.0f,
        -1.0f,  1.0f, -1.0f,                            -1.0f,  1.0f,  1.0f,
    // bottom face
        -1.0f, -1.0f,  1.0f,                            -1.0f, -1.0f, -1.0f,
         1.0f, -1.0f, -1.0f,                             1.0f, -1.0f,  1.0f,
    };
    private static final float[] colors = {
    // front face (red)
        1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,
        1.0f, 0.0f, 0.0f,                            1.0f, 0.0f, 0.0f,
    // back face (green)
        0.0f, 1.0f, 0.0f,                            0.0f, 1.0f, 0.0f,
        0.0f, 1.0f, 0.0f,                            0.0f, 1.0f, 0.0f,
    // right face (blue)
        0.0f, 0.0f, 1.0f,                            0.0f, 0.0f, 1.0f,
        0.0f, 0.0f, 1.0f,                            0.0f, 0.0f, 1.0f,
    // left face (yellow)
        1.0f, 1.0f, 0.0f,                            1.0f, 1.0f, 0.0f,
        1.0f, 1.0f, 0.0f,                            1.0f, 1.0f, 0.0f,
    // top face (magenta)
        1.0f, 0.0f, 1.0f,                            1.0f, 0.0f, 1.0f,
        1.0f, 0.0f, 1.0f,                            1.0f, 0.0f, 1.0f,
    // bottom face (cyan)
        0.0f, 1.0f, 1.0f,                            0.0f, 1.0f, 1.0f,
        0.0f, 1.0f, 1.0f,                            0.0f, 1.0f, 1.0f,
    };

    private Shape3D shape;

    public ColorCube() {
        QuadArray cube = new QuadArray(24,
                        QuadArray.COORDINATES | QuadArray.COLOR_3);

        cube.setCoordinates(0, verts);
        cube.setColors(0, colors);

        shape = new Shape3D(cube, new Appearance());
    }

    public Shape3D getShape() {
        return shape;
    }
}