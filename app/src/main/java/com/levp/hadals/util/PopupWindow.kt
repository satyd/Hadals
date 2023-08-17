package com.levp.hadals.util


import android.content.Context
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.PopupWindow
import android.widget.TextView
import com.levp.hadals.R


fun Context.showPopup(anchorView: View, depth: Int) {
    val popup = PopupWindow(this)
    val popupView: View = LayoutInflater.from(this).inflate(R.layout.depth_popup, null)
    val textView = popupView.findViewById<TextView>(R.id.popup_text)
    textView.text = "${depth} m"
    popup.contentView = popupView
    popup.isOutsideTouchable = true
    popup.isFocusable = true
    val location = IntArray(2)
    //anchorView.getLocationOnScreen(location)
    val offset = 50 // Смещение от элемента в пикселях
    val popupWidth = popupView.width
    val popupHeight = popupView.height
    //val x = location[0] + anchorView.width / 2 - popupWidth / 2
    //val y = location[1] - popupHeight - offset
    popup.showAsDropDown(anchorView, 0,0, Gravity.RELATIVE_LAYOUT_DIRECTION)

}