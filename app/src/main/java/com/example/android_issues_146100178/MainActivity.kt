package com.example.android_issues_146100178

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.view.menu.MenuBuilder
import androidx.appcompat.view.menu.MenuPopupHelper
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "To reproduce an issue: click \"Show popup menu\" menu button in top right corner", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(toolbarItem: MenuItem): Boolean {
        return when (toolbarItem.itemId) {
            R.id.action_show_pop_up -> {

                val activityContext = this
                val popupMenuBuilder = MenuBuilder(activityContext)

                val item: MenuItem = popupMenuBuilder.add(
                    Menu.NONE,
                    R.drawable.ic_restore_24dp,
                    Menu.NONE,
                    R.string.menu_retore
                )
                item.setIcon(R.drawable.ic_restore_24dp)

                val menuHelper = MenuPopupHelper(activityContext, popupMenuBuilder, findViewById(R.id.action_show_pop_up))
                menuHelper.setForceShowIcon(true)
                menuHelper.show()

                true
            }
            else -> super.onOptionsItemSelected(toolbarItem)
        }
    }
}
