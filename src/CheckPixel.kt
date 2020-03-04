import java.awt.Color
import java.awt.Robot

class CheckPixel(private val pixelX:Int, private val pixelY: Int, private val pixelV: Color) {
    fun check():Boolean {
        //println("CheckPixel at $pixelX, $pixelY, must be $pixelV: ${Robot().getPixelColor(pixelX, pixelY) == pixelV}")
        return Robot().getPixelColor(pixelX, pixelY) == pixelV
    }
}