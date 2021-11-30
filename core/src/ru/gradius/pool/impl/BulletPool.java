package ru.gradius.pool.impl;

import ru.gradius.pool.SpritesPool;
import ru.gradius.sprite.impl.Bullet;

public class BulletPool extends SpritesPool<Bullet> {
    @Override
    protected Bullet newObject() {
        return new Bullet();
    }
}
