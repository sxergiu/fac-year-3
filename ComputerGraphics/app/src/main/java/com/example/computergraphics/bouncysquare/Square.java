package com.example.computergraphics.bouncysquare;


import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;
import javax.microedition.khronos.opengles.GL11;

import android.content.Context;
import android.graphics.*;
import android.opengl.*;
public class Square {

    //private int[] textures = new int[1];
    private FloatBuffer mFVertexBuffer;
    private ByteBuffer mColorBuffer;
    private ByteBuffer mIndexBuffer;
    public FloatBuffer mTextureBuffer;
    //private int texIncrease=1000;

    /*
    float[] textureCoords =
            {
                    0.0f, 0.0f,
                    1.0f, 0.0f,
                    0.0f, 1.0f,
                    1.0f, 1.0f
            };
    */
    public Square() {
        float[] vertices =
                {
                        -1.0f, -1.0f,
                        1.0f, -1.0f,
                        -1.0f, 1.0f,
                        1.0f, 1.0f,
                };

        byte maxColor = (byte) 255;
        byte sixtyercent = (byte) 153;
        byte[] colors =
                {
                        maxColor, 0, 0, maxColor,
                        maxColor, 0, 0, maxColor,
                        maxColor, 0, 0, maxColor,
                        maxColor, 0, 0, maxColor,
                };

        byte[] indices =
                {
                        0, 3, 1,
                        0, 2, 3
                };

        ByteBuffer vbb = ByteBuffer.allocateDirect(vertices.length * 4);
        vbb.order(ByteOrder.nativeOrder());
        mFVertexBuffer = vbb.asFloatBuffer();
        mFVertexBuffer.put(vertices);
        mFVertexBuffer.position(0);
        mColorBuffer = ByteBuffer.allocateDirect(colors.length);
        mColorBuffer.put(colors);
        mColorBuffer.position(0);
        mIndexBuffer = ByteBuffer.allocateDirect(indices.length);
        mIndexBuffer.put(indices);
        mIndexBuffer.position(0);
        /*
        ByteBuffer tbb = ByteBuffer.allocateDirect(textureCoords.length * 4);
        tbb.order(ByteOrder.nativeOrder());
        mTextureBuffer = tbb.asFloatBuffer();
        mTextureBuffer.put(textureCoords);
        mTextureBuffer.position(0);
        */
    }

    public void draw(GL10 gl) {

        gl.glFrontFace(GL11.GL_CW);
        gl.glVertexPointer(2, GL11.GL_FLOAT, 0, mFVertexBuffer);
        gl.glColorPointer(4, GL11.GL_UNSIGNED_BYTE, 0, mColorBuffer);
        gl.glDrawElements(  GL11.GL_TRIANGLES, 2 * 3, GL11.GL_UNSIGNED_BYTE, mIndexBuffer);

        /*
        gl.glEnable(GL10.GL_TEXTURE_2D);
        gl.glEnable(GL10.GL_BLEND);
        gl.glBlendFunc(GL10.GL_ONE, GL10.GL_SRC_COLOR);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);
        gl.glTexCoordPointer(2, GL10.GL_FLOAT,0, mTextureBuffer);
        gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

        textureCoords[0]+=texIncrease;
        textureCoords[1]+=texIncrease;
        textureCoords[2]+=texIncrease;
        textureCoords[3]+=texIncrease;
        textureCoords[4]+=texIncrease;
        textureCoords[5]+=texIncrease;
        textureCoords[6]+=texIncrease;
        textureCoords[7]+=texIncrease;
         */
    }

    /*
    public void createTexture(GL10 gl, Context contextRegf, int resource){
        Bitmap image = BitmapFactory.decodeResource(contextRegf.getResources(), resource);
        gl.glGenTextures(1, textures, 0);
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textures[0]);
        GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, image, 0);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_LINEAR);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_LINEAR);
        image.recycle();
    }
     */
}
