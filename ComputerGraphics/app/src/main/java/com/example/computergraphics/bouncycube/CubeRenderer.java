package com.example.computergraphics.bouncycube;

import android.opengl.GLSurfaceView;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class CubeRenderer implements GLSurfaceView.Renderer {

    private final Cube mCube;
    private float mTransY;
    private float mAngle;
    public final static int SS_SUNLIGHT = GL10.GL_LIGHT0;

    public CubeRenderer() {
        mCube = new Cube();
        mTransY = 0;
        mAngle = 0;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {

        gl.glDepthMask(false);
        initLighting(gl);

        gl.glDisable(GL10.GL_DITHER);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
        gl.glClearColor(0,0,0,0);
        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glEnable(GL10.GL_DEPTH_TEST);

        gl.glCullFace(GL10.GL_FRONT);

    }

    private void initLighting(GL10 gl) {

        gl.glEnable(GL10.GL_LIGHTING);
        gl.glEnable(SS_SUNLIGHT);
        gl.glEnable(GL10.GL_COLOR_MATERIAL);

        float[] green = {0.0f, 1.0f, 0.0f, 1.0f};
        float[] red = {1.0f, 0.0f, 0.0f, 1.0f};
        float[] blue ={ 0.0f, 0.0f, 1.0f, 1.0f};
        float[] colorVector={0.2f, 0.2f, 0.2f, 0.0f};
        float[] yellow={1.0f, 1.0f, 0.0f, 1.0f};

        float[] position = {0.0f,5.0f,0.0f,1.0f};
        float[] direction={1.0f,0.0f,0.0f};

        gl.glLightfv(SS_SUNLIGHT, GL10.GL_POSITION, makeFloatBuffer(position));
        gl.glLightfv(SS_SUNLIGHT, GL10.GL_DIFFUSE, makeFloatBuffer(green));
        gl.glLightfv(SS_SUNLIGHT,GL10.GL_SPECULAR, makeFloatBuffer(red));
        gl.glLightfv(SS_SUNLIGHT, GL10.GL_AMBIENT, makeFloatBuffer(blue));
        gl.glLightfv(SS_SUNLIGHT,GL10.GL_SPECULAR, makeFloatBuffer(red));
        gl.glLightModelfv(GL10.GL_LIGHT_MODEL_AMBIENT, makeFloatBuffer(colorVector));
        gl.glLightfv(GL10.GL_LIGHT0, GL10.GL_SPOT_DIRECTION, makeFloatBuffer(direction));
        gl.glLightf(SS_SUNLIGHT, GL10.GL_LINEAR_ATTENUATION, 0.025f);


        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_DIFFUSE, makeFloatBuffer(red));
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SPECULAR, makeFloatBuffer(red));
        gl.glMaterialf(GL10.GL_FRONT_AND_BACK,GL10.GL_SHININESS, 25);
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_SPECULAR, makeFloatBuffer(red));
        gl.glMaterialf(GL10.GL_FRONT_AND_BACK,GL10.GL_SHININESS, 5);
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_AMBIENT, makeFloatBuffer(blue));
        gl.glMaterialfv(GL10.GL_FRONT_AND_BACK, GL10.GL_EMISSION, makeFloatBuffer(yellow));

    }

    protected static FloatBuffer makeFloatBuffer(float[] array)
    {
        ByteBuffer bb = ByteBuffer.allocateDirect(array.length*4);
        bb.order(ByteOrder.nativeOrder());
        FloatBuffer fb = bb.asFloatBuffer();
        fb.put(array);
        fb.position(0);
        return fb;
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();

        float fieldOfView = 40.0f/57.3f;
        float aspectRatio = (float)width/(float)height;
        float zNear = 6.0f;
        float zFar = 1000.0f;
        float size = zNear * (float)(Math.tan((double)(fieldOfView/2.0f)));
        gl.glFrustumf(-size, size, -size/aspectRatio, size/aspectRatio, zNear, zFar);
        gl.glMatrixMode(GL10.GL_MODELVIEW);
    }

    @Override
    public void onDrawFrame(GL10 gl) {

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL10.GL_MODELVIEW);

        gl.glLoadIdentity();
        gl.glTranslatef(0.0f, (float) Math.sin(mTransY), -7.0f);
        mTransY += 0.075f;

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

        gl.glScalef(1,1,1);
        gl.glEnable(GL10.GL_CULL_FACE);

        gl.glRotatef(mAngle, 1.0f, 0.0f, 0.0f);
        gl.glRotatef(mAngle, 0.0f, 1.0f, 0.0f);
        mAngle += 0.4f;

        mCube.draw(gl);
    }
}
