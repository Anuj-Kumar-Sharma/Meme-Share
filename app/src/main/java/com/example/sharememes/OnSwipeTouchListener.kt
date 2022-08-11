package com.example.sharememes

//package com.rrtutors.androidsamples.guestures

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
//import com.rrtutors.androidsamples.guestures.OnSwipeTouchListener.GestureListener



public abstract class OnSwipeTouchListener() :View.OnTouchListener{

    constructor(c: Context) : this() {
        gestureDetector = GestureDetector(c, GestureListener())
    }

    private var gestureDetector: GestureDetector?=null;

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {

        return gestureDetector?.onTouchEvent(event)!!;
    }

    inner class GestureListener: GestureDetector.OnGestureListener{
        private val SWIPE_THRESHOLD = 100
        private val SWIPE_VELOCITY_THRESHOLD = 100
        override fun onShowPress(e: MotionEvent?) {


        }

        override fun onSingleTapUp(e: MotionEvent?): Boolean {
            //onSingleTapUp(e)
            return true;
        }

        override fun onDown(e: MotionEvent?): Boolean {

            return true;
        }

        override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
            try {
                val diffY = e2?.getY()!! - e1?.getY()!!
                val diffX = e2.getX() - e1.getX()
                if (Math.abs(diffX) > Math.abs(diffY)) {
                    if (Math.abs(diffX) > SWIPE_THRESHOLD && Math.abs(velocityX) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffX > 0) {
                            onSwipeRight()
                        } else {
                            onSwipeLeft()
                        }
                    }
                } else {
                    if (Math.abs(diffY) > SWIPE_THRESHOLD && Math.abs(velocityY) > SWIPE_VELOCITY_THRESHOLD) {
                        if (diffY > 0) {
                            onSwipeDown()
                        } else {
                            onSwipeUp()
                        }
                    }
                }
            } catch (exception: Exception) {
                exception.printStackTrace()
            }

            return false
        }

        override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
            return true;
        }

        override fun onLongPress(e: MotionEvent?) {

        }

    }

    abstract fun onSwipeRight();
    abstract fun onSwipeLeft();
    private fun onSwipeUp() {}
    private fun onSwipeDown() {}
    private fun onClick() {}
    private fun onDoubleClick() {}
    private fun onLongClick() {}
}