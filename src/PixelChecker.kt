import java.awt.Color
import java.awt.Robot
import java.util.*

class PixelChecker(private val pixelX:Int, private val pixelY: Int, private val pixelValue: Color) {
    private val r = Robot()
    private val timeout = 10000L
    fun check():Boolean {
        return r.getPixelColor(pixelX, pixelY) == pixelValue
    }
    fun wait():Boolean{
        val timeStart = Date().time
        while(timeStart + timeout < Date().time){
            if (check())
                return true
        }
        return false
    }

    fun save(name:String){
        //save to file name.ubc
    }
}