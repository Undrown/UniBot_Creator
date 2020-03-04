import java.awt.TextArea
import javax.swing.JFrame

class LogFrame:JFrame() {
    private val textArea = TextArea()
    init {
        title = "Log"
        defaultCloseOperation = HIDE_ON_CLOSE
        setSize(350, 200)
        setLocationRelativeTo(null)
        setLocation(location.x, location.y+200)
        add(textArea)
        isVisible = true
    }

    fun write(comment: String){
        textArea.append("# $comment\n")
    }

    fun writeCommand(name: String, type: CommandType, args: String){
        textArea.append("$name: $args\n")
    }

    enum class CommandType{
        EMPTY,
        CHECK,
        WAIT,
        CLICK
    }
}