import java.util.*
import kotlin.concurrent.scheduleAtFixedRate

class GlobalListener(val button:String) {
    private val command = "notepad" //must terminate after target button pressed
    private val interval = 1000L    //1 sec
    var stopQueued = false
    private var stopListener:Process? = null
    private var stopListenerTask:TimerTask? = null
    fun start(){
        stopQueued = false
        stopListener = ProcessBuilder(command).start()
        stopListenerTask = Timer().scheduleAtFixedRate(interval, interval){
            if(stopListener == null){
                stopQueued = true
                this.cancel()
            }
            try {
                stopListener!!.exitValue()
                stopQueued = true
                this.cancel()
            }catch (e:IllegalThreadStateException){
                //nop
            }
        }
    }
}