package com.example.cerbungapp

import android.app.AlertDialog
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.cerbungapp.databinding.CerbungItemBinding
import com.squareup.picasso.Picasso

class CerbungAdapter() : RecyclerView.Adapter<CerbungAdapter.CerbungViewHolder>() {
    class CerbungViewHolder (val binding: CerbungItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CerbungViewHolder {
        val binding = CerbungItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CerbungViewHolder(binding)

    }

    override fun getItemCount(): Int {
        return Global.cerbungs.size
    }

    override fun onBindViewHolder(holder: CerbungViewHolder, position: Int) {
        val url = Global.cerbungs[position].url
        with(holder.binding){
            val builder = Picasso.Builder(holder.itemView.context)
            builder.listener{ Picasso, url, exception -> exception.printStackTrace() }
            Picasso.get().load(url).into(imgPoster)
            txtTitle.text = Global.cerbungs[position].title
            txtDateUpdated.text = Global.cerbungs[position].lastUpdate
            txtAuthor.text = Global.cerbungs[position].author
//            txtManyParagraph.text =
//            txtManyLike.text = Global.cerbungs[position].like.toString()
//            txtDescription.text = Global.cerbungs[position].description
        }

        with(holder.binding){
            btnRead.setOnClickListener(){
                val intent = Intent(holder.itemView.context, CerbungDetails::class.java)
                intent.putExtra("idcerbung", position)
                holder.itemView.context.startActivity(intent)
            }
        }
    }

}