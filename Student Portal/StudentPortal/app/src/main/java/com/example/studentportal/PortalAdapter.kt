package com.example.studentportal


import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.portal_item.view.*


class PortalAdapter(private val portals: List<PortalData>) :
    RecyclerView.Adapter<PortalAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.portal_item, parent, false)
        )    }

    override fun getItemCount() = portals.size


    override fun onBindViewHolder(holder: PortalAdapter.ViewHolder, position: Int) {
        holder.bind(portals[position])


    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(portal: PortalData) {
            itemView.siteName.text = portal.site
            itemView.siteUrl.text = portal.url



            itemView.setOnClickListener {
                val builder = CustomTabsIntent.Builder()
                val intent = builder.build()
                intent.launchUrl(itemView.context, Uri.parse(portal.url))
            }
        }


    }

}

