import java.awt.TextArea
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import javax.swing.JFrame

class LogFrame:JFrame() {
    private val logFile = File("log.txt")
    private val textArea = TextArea()
    private val pattern = SimpleDateFormat("dd MMMM HH:mm:ss #")
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
        val date = pattern.format(Date())
        textArea.append("$date $comment\n")
        logFile.appendText("$date $comment\n")
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