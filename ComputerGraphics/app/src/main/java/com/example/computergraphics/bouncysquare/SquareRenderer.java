package com.example.computergraphics.bouncysquare;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import android.opengl.GLSurfaceView;

import android.content.Context;

import android.graphics.*;
import android.opengl.*;

import com.example.computergraphics.R;

public class SquareRenderer implements GLSurfaceView.Renderer
{
    private final Square mSquare;
    private float mTransY;

    //private Context context;

    public SquareRenderer(Context context) {

        //this.context = context;
        mSquare = new Square();
        mTransY = 0;
    }
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig eglConfig) {

        gl.glDisable(GL10.GL_DITHER);
        gl.glHint(GL10.GL_PERSPECTIVE_CORRECTION_HINT, GL10.GL_FASTEST);
        gl.glClearColor(1,1,1,1);
        gl.glEnable(GL10.GL_CULL_FACE);
        gl.glShadeModel(GL10.GL_SMOOTH);
        gl.glEnable(GL10.GL_DEPTH_TEST);

        //int resid = R.drawable.kkk;
        //mSquare.createTexture(gl, this.context, resid);
    }

    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {

        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL10.GL_PROJECTION);
        gl.glLoadIdentity();
        float ratio = (float) width / height;
        gl.glFrustumf(-ratio, ratio, -1, 1, 1, 10);

    }

    @Override
    public void onDrawFrame(GL10 gl) {

        gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);
        gl.glMatrixMode(GL10.GL_MODELVIEW);

        gl.glLoadIdentity();
        gl.glTranslatef((float)Math.sin(mTransY),0.0f, -3.0f);
        mTransY += 0.03f;

        gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
        gl.glEnableClientState(GL10.GL_COLOR_ARRAY);

        mSquare.draw(gl);

    }
}
