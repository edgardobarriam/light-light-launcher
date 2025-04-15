package io.github.edgardobarriam.lightlightlauncher

class AppInfo(val packageName: String, val appLabel: String) {

  /*
  * From Docs:
  * By default, the array adapter creates a view by calling Object.toString() on each data object in the collection you provide,
  * and places the result in a TextView. You may also customize what type of view is used for the data object in the collection.
  * To customize what type of view is used for the data object, override getView(int, android.view.View, android.view.ViewGroup)
  * and inflate a view resource.
  *
  * So to avoid creating a custom Adapter and just use ArrayAdapter, we create this AppInfo class and override toString()
  * */
  override fun toString() = appLabel
}