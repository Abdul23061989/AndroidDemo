package com.mytaxi.android_demo.PageObjects;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.util.Log;

import com.mytaxi.android_demo.R;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


public class InDriverProfilePage
{
    public static Espresso es;

    //Page Objects
    //------------------------------------//
    private static ViewInteraction img_Driver() { return Espresso.onView(withId(R.id.imageViewDriverAvatar)); }
    private static ViewInteraction text_DriverName() { return Espresso.onView(withId(R.id.textViewDriverName)); }
    private static ViewInteraction button_CallDriver() { return Espresso.onView(withId(R.id.fab)); }

    //Methods in relation to Page Objects
    //------------------------------------//
    public static void VerifyImageofDriver() {
        img_Driver().check(matches(isDisplayed()));
        Log.d("VerifyImageofDriver","Verify Image of Driver"); }

    public static void VerifyNameofDriver(String value){
        text_DriverName().check(matches(withText(value)));
        Log.d("VerifyNameofDriver","Verify Name of Driver"); }

    public static void ClickCallDriverButton(){
        button_CallDriver().check(matches(isDisplayed())).perform(click());
        Log.d("ClickCallDriverButton","Click call driver button"); }

    //Workflows in relation to Page Objects and Methods
    //------------------------------------//
    public static void CallDriver(String DriverName){
        try{
            VerifyImageofDriver();
            VerifyNameofDriver(DriverName);
            ClickCallDriverButton();}
        catch(Exception e)
            {Log.d("CallDriver","Exception Thrown as : "+e.toString());} }
}
