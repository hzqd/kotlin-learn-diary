package com.github.hzqd.tank.war.business

import com.github.hzqd.tank.war.model.View

/**自动射击*/
interface AutoShotable {
    fun autoShot(): View?
}