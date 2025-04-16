package io.github.edgardobarriam.lightlightlauncher

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : Activity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)
    val pacMan = applicationContext.packageManager

    val appsIntent = Intent(Intent.ACTION_MAIN, null).addCategory(Intent.CATEGORY_LAUNCHER)
    val appsList = pacMan.queryIntentActivities(appsIntent, 0)
      .map { AppInfo(it.activityInfo.packageName, it.loadLabel(pacMan) as String) }
      .sortedBy { it.appLabel }

    val appsListView: ListView = findViewById(R.id.appList)
    appsListView.setOnItemClickListener { parent, _, position, _ ->
      val selectedItem = parent.getItemAtPosition(position) as AppInfo
      startActivity(pacMan.getLaunchIntentForPackage(selectedItem.packageName))
    }
    appsListView.adapter = ArrayAdapter(this, R.layout.app_item, R.id.appTextView, appsList)
  }
  override fun onBackPressed() { }
}