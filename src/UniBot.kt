import java.awt.*
import java.util.*
import javax.swing.ImageIcon
import javax.swing.JFrame
import kotlin.concurrent.scheduleAtFixedRate
import kotlin.system.exitProcess

class UniBot : JFrame() {
    private val globalListener = GlobalListener("")
    private var pixelTracer = PixelTracer()
    private val mainPanel = Panel(GridLayout(3, 3).apply { hgap=10;vgap=20 })
    private val exitBtn = Button("Exit").apply {
        addActionListener {
            SystemTray.getSystemTray().remove(trayIcon)
            exitProcess(0)
        }
    }
    private val popupOnButton = PopupMenu().apply {
        add(MenuItem("CheckPixel")).addActionListener {
            println("adding pixel checker...")
        }
        add(MenuItem("WaitPixel")).addActionListener {
            println("adding pixel listener (wait for pixel color)...")
        }
        add(MenuItem("actionPerformer")).addActionListener {
            println("adding clicker/action-performer...")
        }
    }
    private val addBtn = Button("Add...").apply {
        add(popupOnButton)
        addActionListener { popupOnButton.show(this, this.width/2, this.height/2) }
    }
    //tray
    private val iconImg : Image = ImageIcon("res/icon.png").image
    private val trayIcon = TrayIcon(iconImg)
    //tray popup
    private val popup = PopupMenu("Exit").apply{
        add(MenuItem("Show")).addActionListener {isVisible = true}
        add(MenuItem("Tracer")).addActionListener {with(pixelTracer){isVisible = !isVisible}}
        add(MenuItem("Exit")).addActionListener {
            SystemTray.getSystemTray().remove(trayIcon)
            exitProcess(0)
        }
    }
    init {
        title = "UniB"
        defaultCloseOperation = HIDE_ON_CLOSE
        setSize(200, 200)
        setLocationRelativeTo(null)
        add(mainPanel)
        with(mainPanel){
            add(addBtn)
            add(exitBtn)
        }
        isVisible = true
        iconify()
    }

    fun stopQueued():Boolean = globalListener.stopQueued

    private fun iconify(){
        if(!SystemTray.isSupported()){
            println("System tray is not supported.")
            return
        }
        SystemTray.getSystemTray().add(trayIcon)
        trayIcon.popupMenu = popup
        trayIcon.addActionListener {
            isVisible = true
        }
    }
}