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

    // waka waka waka
    val pacman = applicationContext.packageManager

    // use this Intent as the filter for the "Apps query"
    val appsIntent = Intent(Intent.ACTION_MAIN, null).addCategory(Intent.CATEGORY_LAUNCHER)

    // get apps as ResolveInfo from queryIntentActivities and map them to our AppInfo class
    val appsList = pacman.queryIntentActivities(appsIntent, 0)
      .map { AppInfo(it.activityInfo.packageName, it.loadLabel(pacman) as String) }
      .sortedBy { it.appLabel } // Sort alphabetically

    // get our appList ListView defined in the main layout
    val appsListView: ListView = findViewById(R.id.appList)

    // define what will happen when we click an item in the appList
    // (when clicked, start the selected app)
    appsListView.setOnItemClickListener { parent, _, position, _ ->
      // these two lines don't really need an explanation, but I'll add one anyways. Hi mom.
      val selectedItem = parent.getItemAtPosition(position) as AppInfo
      startActivity(pacman.getLaunchIntentForPackage(selectedItem.packageName))
    }

    // use an ArrayAdapter for appsListView with our app_item layout for each ListView item
    appsListView.adapter = ArrayAdapter(this, R.layout.app_item, R.id.appTextView, appsList)
  }
}