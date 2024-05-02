package com.example.testpusher.ui.theme

import android.util.Log
import androidx.lifecycle.ViewModel
import com.pusher.client.Pusher
import com.pusher.client.PusherOptions
import com.pusher.client.channel.Channel

class PusherViewModel : ViewModel() {

    private val pusher: Pusher = Pusher("718ebf71f167480899fb", PusherOptions().setCluster("ap1"))
    private lateinit var channel: Channel
    var message=""

    fun connect() {
        pusher.connect()
        channel = pusher.subscribe("infoweb")

        channel.bind("sport-event") { data ->
            message = data.data
            Log.e("TAG", "connect Stablled: $message")
        }
    }

    fun disconnect() {
        pusher.disconnect()
    }
}
