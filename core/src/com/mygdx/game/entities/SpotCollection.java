package com.mygdx.game.entities;


import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.mygdx.game.utils.CustomDialog;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class SpotCollection {

    private Map<Rectangle, CustomDialog> spots;

    public SpotCollection() {}

    /**
     * initiate spots by putting the ith door and ith question in a map.
     * @param doorRects array of doors.
     * @param questions array of questions.
     */
    public void initSpots(Array<Rectangle> doorRects, Array<CustomDialog> questions) {
        spots = new HashMap<>();
        for(int i=0; i<doorRects.size; i++){
            Rectangle rect = doorRects.get(i);
            CustomDialog question = questions.get(i);
            spots.put(rect, question);
        }
    }

    public static <T, E> T getKeyByValue(Map<T, E> map, E value) {
        for (Map.Entry<T, E> entry : map.entrySet()) {
            if (Objects.equals(value, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public Map<Rectangle, CustomDialog> getSpots() {
        return spots;
    }
}
