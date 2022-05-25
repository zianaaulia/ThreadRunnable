package zianaaulia.polbeng.ac.id.threadrunnable

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Message
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            Worker().execute()
        }
    }
    inner class Worker : AsyncTask<Void, String, Boolean>() {
        override fun doInBackground(vararg p0: Void?): Boolean {
            for (i in 1..20) {
                publishProgress(i.toString())
                Thread.sleep(2000)
            }
            return true
        }
        override fun onProgressUpdate(vararg values: String?) {
            textView.text = values[0]
        }
        override fun onPostExecute(result: Boolean?) {
            println(result)
        }
    }
}

        /*mhandler = object : Handler() {
            override fun handleMessage(msg: Message) {
                textView.text = msg?.data?.getString("counter")
            }
        }

        button.setOnClickListener {
            val runnable = Worker()
            val thread = Thread(runnable)
            thread.start()
        }
    }
    inner class Worker : Runnable {
        override fun run() {
            killSomeTime()
        }
    }
    private fun killSomeTime() {
        for (i in 1..20) {
            var msg = Message.obtain()
            msg.data.putString("counter", i.toString())
            mhandler.sendMessage(msg)
            Thread.sleep(2000)
        }
    }*/
