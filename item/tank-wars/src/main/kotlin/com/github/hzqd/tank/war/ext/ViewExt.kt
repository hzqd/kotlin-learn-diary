package com.github.hzqd.tank.war.ext

import com.github.hzqd.tank.war.model.View

fun View.checkCollision(view: View) = checkCollision(x, view.x, y, view.y, width, view.width, height, view.height)