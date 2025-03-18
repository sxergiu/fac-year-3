package com.example.computergraphics.bouncycube;

import android.opengl.GLSurfaceView;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class CubeRenderer implements GLSurfaceView.Renderer {

    private final Cube mCube;
    private float mTransY;
    private float mAngle;

    public CubeRenderer() {
        mCube = new Cube();
        mTransY = 0;
        mAngle = 0;
    }

    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {

        gl.glDisable(GL10.GL_DITHER);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
        gl.glClearColor(0,0,0,0);
        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glEnable(GL10.GL_DEPTH_TEST);

        gl.glCullFace(GL10.GL_FRONT);
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
