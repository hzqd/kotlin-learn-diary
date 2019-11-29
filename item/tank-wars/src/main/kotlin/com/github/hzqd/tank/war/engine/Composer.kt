package com.github.hzqd.tank.war.engine

import java.io.BufferedInputStream
import javax.sound.sampled.*

const val HIT = "/img/hit.wav"

class Audio(path: String) {
    private val audioInputStream = AudioSystem.getAudioInputStream(
        BufferedInputStream(
            javaClass.getResourceAsStream(
                path
            )
        )
    )

    private val af = audioInputStream.format
    private val size = (af.frameSize * audioInputStream.frameLength).toInt()
    private val audio = ByteArray(size)
    private val info = DataLine.Info(Clip::class.java, af, size)

    fun play() {
        audioInputStream.read(audio, 0, size)
        val clip = AudioSystem.getLine(info) as Clip
        clip.open(af, audio, 0, size)
        clip.start()
    }
}

object Composer {
    private val buffer = HashMap<String, Audio>()
    init {
        buffer[HIT] = Audio(HIT)
    }

    fun play(audioName: String) {
        buffer[audioName]!!.play()

    }
}