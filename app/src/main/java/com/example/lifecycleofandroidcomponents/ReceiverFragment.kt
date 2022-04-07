package com.example.lifecycleofandroidcomponents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class ReceiverFragment : Fragment() {

    companion object {
        private const val sendingMessage = "message"

        fun sendMessage(message: String): Fragment =
            ReceiverFragment().apply {
                arguments = Bundle().apply {
                    putString(sendingMessage, message)
                }
            }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_receiver, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel = ViewModelProvider(this)[ReceiverViewModel::class.java]
        val messageView = view.findViewById<TextView>(R.id.message)

        super.onViewCreated(view, savedInstanceState)

        viewModel.message.observe(viewLifecycleOwner) { message ->
            messageView.text = message
        }

        if (savedInstanceState == null)
            viewModel.setMessage(requireArguments().getString(sendingMessage)!!)

        view.findViewById<Button>(R.id.readButton).setOnClickListener {
            viewModel.setMessage("All messages is read")
        }
    }
}