package com.gbizotto.wifimonitor.feature

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.gbizotto.wifimonitor.R
import com.gbizotto.wifimonitor.data.ConnectionLog
import com.gbizotto.wifimonitor.databinding.LogItemBinding
import java.util.*

class ConnectionLogAdapter(
    private val logs: List<ConnectionLog>,
    private val context: Context,
) : RecyclerView.Adapter<ConnectionLogAdapter.LogsViewHolder>() {

    class LogsViewHolder(itemView: View, private val binding: LogItemBinding) : RecyclerView.ViewHolder(itemView) {
        fun bind(connectionLog: ConnectionLog) {
            binding.txtStatus.text = if (connectionLog.connected) {
                "Connected"
            } else {
                "Disconnected"
            }

            binding.txtDate.text = Date(connectionLog.timestamp).toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LogsViewHolder {
        val layoutInflater = LayoutInflater.from(context)
        val binding = DataBindingUtil.inflate<LogItemBinding>(layoutInflater, R.layout.log_item, parent, false)
        return LogsViewHolder(binding.root, binding)

//        val view = LayoutInflater.from(parent.context).inflate(R.layout.log_item, parent, false)
//        return LogsViewHolder(view, binding)

        /*
        val layoutInflater = LayoutInflater.from(context)
        val binding = DataBindingUtil.inflate<HistoryItemRowBinding>(layoutInflater, R.layout.history_item_row, parent, false)
        return HistoryAdapter.ViewHolder(binding.root, binding)
         */
    }

    override fun getItemCount(): Int {
        return logs.size
    }

    override fun onBindViewHolder(holder: LogsViewHolder, position: Int) {
        holder.bind(logs[position])
    }
}
