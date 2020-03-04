import java.awt.Color
import java.awt.Robot

class CheckPixel(private val pixelX:Int, private val pixelY: Int, private val pixelValue: Color) {
    fun check():Boolean {
        return Robot().getPixelColor(pixelX, pixelY) == pixelValue
    }
}