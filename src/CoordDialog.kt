import java.awt.Color
import java.awt.FlowLayout
import java.awt.MouseInfo
import java.awt.Robot
import java.awt.event.MouseEvent
import java.awt.event.MouseListener
import javax.swing.JDialog
import javax.swing.JPanel
import javax.swing.JTextField
import javax.swing.border.Border
import javax.swing.border.LineBorder

class CoordDialog:JDialog() {
    val panel = JPanel(FlowLayout())
    val inputX:JTextField = JTextField("xxx")
    val inputY:JTextField = JTextField("yyy")
    val dragPanel = JPanel()
    val inputColor:JTextField = JTextField("cccccc")
    init {
        setSize(200, 200)
        add(panel)
        dragPanel.border = LineBorder(Color.BLACK)
        panel.add(dragPanel)
        panel.add(inputX)
        panel.add(inputY)
        panel.add(inputColor)
        dragPanel.addMouseListener(MListener())
    }

    inner class MListener:MouseListener{
        var end = false
        /**
         * Invoked when a mouse button has been released on a component.
         * @param e the event to be processed
         */
        override fun mouseReleased(e: MouseEvent?) {
            end = true
        }

        /**
         * Invoked when the mouse enters a component.
         * @param e the event to be processed
         */
        override fun mouseEntered(e: MouseEvent?) {
        }

        /**
         * Invoked when the mouse button has been clicked (pressed
         * and released) on a component.
         * @param e the event to be processed
         */
        override fun mouseClicked(e: MouseEvent?) {
        }

        /**
         * Invoked when the mouse exits a component.
         * @param e the event to be processed
         */
        override fun mouseExited(e: MouseEvent?) {
        }

        /**
         * Invoked when a mouse button has been pressed on a component.
         * @param e the event to be processed
         */
        override fun mousePressed(e: MouseEvent?) {
            if(!end) {
                val point = MouseInfo.getPointerInfo().location
                inputX.text = point.x.toString()
                inputY.text = point.y.toString()
            }
        }

    }
}