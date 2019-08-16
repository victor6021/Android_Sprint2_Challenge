package com.lambdaschool.sprint2_challenge.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.lambdaschool.sprint2_challenge.listOfItem.ShoppingList
import com.lambdaschool.sprint2_challenge.R
import com.lambdaschool.sprint2_challenge.util.ShoppingListAdapter
import kotlinx.android.synthetic.main.activity_main.*
import com.lambdaschool.notificationdemocode.util.NotificationGenerator


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ShoppingList.createShoppingList()

        shopping_list_view.apply{
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(applicationContext)
            adapter = ShoppingListAdapter(ShoppingList.List)
        }

        choose_button.setOnClickListener{ p0 ->
                NotificationGenerator.orderNotification(this)
                }
    }
}

/*Intent smsIntent = new Intent(android.content.Intent.ACTION_VIEW);
smsIntent.setType("vnd.android-dir/mms-sms");
smsIntent.putExtra("address","your desired phoneNumber");
smsIntent.putExtra("sms_body","your desired message");
startActivity(smsIntent);/*

fun composeMmsMessage(message: String, attachment: Uri) {
    val intent = Intent(Intent.ACTION_SEND).apply {
        data = Uri.parse("smsto:")  // This ensures only SMS apps respond
        putExtra("sms_body", message)
        putExtra(Intent.EXTRA_STREAM, attachment)
    }
    if (intent.resolveActivity(packageManager) != null) {
        startActivity(intent)
    }
}*/