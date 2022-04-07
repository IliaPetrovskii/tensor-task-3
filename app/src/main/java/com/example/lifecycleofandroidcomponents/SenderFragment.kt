package com.example.lifecycleofandroidcomponents

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

class SenderFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sender, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.sendButton).setOnClickListener {
            val fr = ReceiverFragment.sendMessage("Some Message?")
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainerView, fr)
                .addToBackStack(null)
                .commit()
        }
    }
}