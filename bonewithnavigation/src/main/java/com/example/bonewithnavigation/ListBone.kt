package com.example.bonewithnavigation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_list.*
import kotlinx.android.synthetic.main.item_list.view.*
import pro.horovodovodo4ka.bones.BoneSibling
import pro.horovodovodo4ka.bones.Finger
import pro.horovodovodo4ka.bones.Phalanx
import pro.horovodovodo4ka.bones.extensions.closest
import pro.horovodovodo4ka.bones.ui.delegates.Page

class ListBone : Phalanx() {
    fun showFullIbfo(it: String) {
        closest<Finger>()?.push(FullInfoBone(it).also { it.isActive = true })
    }

    override val seed = { ListFragment()}
}

class ListFragment : Fragment(), BoneSibling<ListBone> by Page(){


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()
    }

    private fun initRecycler() {
        val mockData = arrayOf("Позвоночник", "Кисть", "Палец", "Фаланага", "Череп")
        with(recycler){
            adapter = ListAdapter(mockData){
                bone.showFullIbfo(it)
            }
            layoutManager = LinearLayoutManager(context)
        }
    }
}

class ListAdapter(private val dataList : Array<String>, val clickListener : (String) -> Unit) : RecyclerView.Adapter<ListAdapter.Holder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return Holder(view)
    }

    override fun getItemCount(): Int = dataList.size


    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bind(dataList[position])
    }

    inner class Holder(private val item : View) : RecyclerView.ViewHolder(item){

        init {
            item.text.setOnClickListener {
                clickListener(dataList[adapterPosition])
            }
        }

        fun bind(s: String) {
            item.text.text = s
        }
    }
}