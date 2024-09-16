package com.mygdx.game.entities;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Explosion {
    private static final float FRAME_LENGTH = 0.1f;
    private static final int OFFSET = 0;
    private static final int SIZE = 50;

    private static Animation anim = null;
    private float x,y;
    private float statetime;

    public boolean remove = false;

    public Explosion (float x, float y){
        this.x = x-OFFSET;
        this.y = y-OFFSET;
        statetime = 0;

        if (anim == null){
            anim = new Animation(FRAME_LENGTH, TextureRegion.split(new Texture("interfaceComponents/explosion.png"), SIZE, SIZE)[0]);
        }
    }

    public void update (float deltatime){
        statetime += deltatime;
        if (anim.isAnimationFinished(statetime))
            remove = true;
    }

    public void render (SpriteBatch sb){
        sb.draw((TextureRegion) anim.getKeyFrame(statetime), x, y);
    }

}
