import java.awt.MouseInfo
import java.awt.Robot
import java.awt.event.MouseEvent
import java.awt.event.MouseMotionListener
import java.util.*
import javax.swing.JFrame
import javax.swing.JLabel
import kotlin.concurrent.scheduleAtFixedRate

class PixelTracer: JFrame() {
    private val r = Robot()
    private val label = JLabel("Default").apply { addMouseMotionListener(MMListener()) }
    init {
        title = "PixelTracer"
        defaultCloseOperation = HIDE_ON_CLOSE
        setSize(200, 25)
        setLocationRelativeTo(null)
        setLocation(10, 10)
        isUndecorated = true
        add(label)
        isVisible = false
        Timer().scheduleAtFixedRate(100, 25){showPixel()}
    }

    private inner class MMListener:MouseMotionListener {
        override fun mouseMoved(e: MouseEvent?) {
            if (location.x > 200)
                setLocation(10, 10)
            else
                setLocation(300, 10)
        }

        override fun mouseDragged(e: MouseEvent?) {
            //nop
        }
    }

    private fun showPixel(){
        val pos = MouseInfo.getPointerInfo().location
        val color = r.getPixelColor(pos.x, pos.y)
        var r = color.red.toString()
        if (r.count() == 1) r = "0$r"
        if (r.count() == 2) r = "0$r"
        var g = color.green.toString()
        if (g.count() == 1) g = "0$g"
        if (g.count() == 2) g = "0$g"
        var b = color.blue.toString()
        if (b.count() == 1) b = "0$b"
        if (b.count() == 2) b = "0$b"
        label.text = "r: $r  g: $g  b: $b"
    }
}
