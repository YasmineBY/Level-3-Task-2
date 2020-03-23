package com.example.studentportal

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*



const val ADD_PORTAL_REQUEST_CODE = 100

class MainActivity : AppCompatActivity() {
    private var portals = arrayListOf<PortalData>()
    private var portalAdapter = PortalAdapter(portals)
    private lateinit var portAdapter: PortalAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        addDataSet()
        fab.setOnClickListener {
            fab.setOnClickListener { startAddPortalActivity() }
        }
        initView()

    }
    private fun initView(){
        recView.layoutManager = StaggeredGridLayoutManager(2, LinearLayoutManager.VERTICAL)
        recView.adapter = portalAdapter
        recView.addItemDecoration(DividerItemDecoration(this@MainActivity, DividerItemDecoration.VERTICAL))


    }


    private fun startAddPortalActivity() {
        val intent = Intent(this, AddPortal::class.java)
        startActivityForResult(intent, ADD_PORTAL_REQUEST_CODE)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                ADD_PORTAL_REQUEST_CODE -> {
                    val reminder = data!!.getParcelableExtra<PortalData>(NEW_PORTAL)
                    portals.add(reminder)
                    portalAdapter.notifyDataSetChanged()
                }
            }
        }
    }

    private fun addDataSet(){

        portals.add(PortalData(site = "VLO", url = "https://vlo.informatica.hva.nl/"))
        portals.add(PortalData(site = "Roosters", url = "https://rooster.hva.nl/"))
        portals.add(PortalData(site = "SIS", url = "https://sis.hva.nl/"))
        portals.add(PortalData(site = "HvA", url = "https://hva.nl/"))
        portalAdapter.notifyDataSetChanged()


    }





}

