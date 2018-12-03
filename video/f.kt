//生成纯色图片：
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun main(args: Array<String>) {
    var image = BufferedImage(1000,1000,BufferedImage.TYPE_INT_RGB)
    var w = 0 .. 999
    var h = 0 .. 999
    image.setRGB(0,0,0xff0000)

    image.apply { for(i in w) for(j in h) setRGB(i,j,0x000000) }
    ImageIO.write(image,"bmp", File("black.bmp"))

    image.apply { for(i in w) for(j in h) setRGB(i,j,0xc0c0c0) }
    ImageIO.write(image,"bmp", File("silver.bmp"))

    image.apply { for(i in w) for(j in h) setRGB(i,j,0x808080) }
    ImageIO.write(image,"bmp", File("gray.bmp"))

    image.apply { for(i in w) for(j in h) setRGB(i,j,0xffffff) }
    ImageIO.write(image,"bmp", File("white.bmp"))

    image.apply { for(i in w) for(j in h) setRGB(i,j,0x800000) }
    ImageIO.write(image,"bmp", File("maroon.bmp"))

    image.apply { for(i in w) for(j in h) setRGB(i,j,0xff0000) }
    ImageIO.write(image,"bmp", File("red.bmp"))

    image.apply { for(i in w) for(j in h) setRGB(i,j,0x800080) }
    ImageIO.write(image,"bmp", File("purple.bmp"))

    image.apply { for(i in w) for(j in h) setRGB(i,j,0xff00ff) }
    ImageIO.write(image,"bmp", File("fuchsia.bmp"))

    image.apply { for(i in w) for(j in h) setRGB(i,j,0x008000) }
    ImageIO.write(image,"bmp", File("green.bmp"))

    image.apply { for(i in w) for(j in h) setRGB(i,j,0x00ff00) }
    ImageIO.write(image,"bmp", File("lime.bmp"))

    image.apply { for(i in w) for(j in h) setRGB(i,j,0x808000) }
    ImageIO.write(image,"bmp", File("olive.bmp"))

    image.apply { for(i in w) for(j in h) setRGB(i,j,0xffff00) }
    ImageIO.write(image,"bmp", File("yellow.bmp"))

    image.apply { for(i in w) for(j in h) setRGB(i,j,0x000080) }
    ImageIO.write(image,"bmp", File("navy.bmp"))

    image.apply { for(i in w) for(j in h) setRGB(i,j,0x0000ff) }
    ImageIO.write(image,"bmp", File("blue.bmp"))

    image.apply { for(i in w) for(j in h) setRGB(i,j,0x008080) }
    ImageIO.write(image,"bmp", File("teal.bmp"))

    image.apply { for(i in w) for(j in h) setRGB(i,j,0x00ffff) }
    ImageIO.write(image,"bmp", File("aqua-cyan.bmp"))

    image.apply { for(i in w) for(j in h) setRGB(i,j,0x1e90ff) }
    ImageIO.write(image,"bmp", File("doder-blue.bmp"))

    image.apply { for(i in w) for(j in h) setRGB(i,j,0xffa500) }
    ImageIO.write(image,"bmp", File("orange.bmp"))
}