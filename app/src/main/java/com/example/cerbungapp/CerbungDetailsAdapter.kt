package com.example.cerbungapp

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.example.cerbungapp.databinding.CerbungItemDetailsBinding

class CerbungDetailsAdapter():RecyclerView.Adapter<CerbungDetailsAdapter.CerbungViewHolder>() {
    class CerbungViewHolder(val binding: CerbungItemDetailsBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CerbungViewHolder {
        val binding = CerbungItemDetailsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CerbungViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CerbungViewHolder, position: Int) {
        with(holder.binding){
            if(Global.judul == Global.paragrafs[position].namecerbung){
                userTxt.text = Global.paragrafs[position].user
                paragrafText.text = Global.paragrafs[position].isiparagraf
            }else{
                CardViewItems.visibility= View.GONE
            }
        }
    }
    override fun getItemCount(): Int {
         return Global.paragrafs.size
    }
}