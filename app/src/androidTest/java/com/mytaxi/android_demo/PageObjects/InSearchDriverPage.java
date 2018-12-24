package com.mytaxi.android_demo.PageObjects;

import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;

import com.mytaxi.android_demo.R;

import android.support.test.espresso.Espresso;
import android.util.Log;

import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.swipeLeft;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsNot.not;


public class InSearchDriverPage
{
    public static Espresso es;

    //Page Objects
    //------------------------------------//
    public static ViewInteraction txtbox_SearchDriver() { return Espresso.onView(withId(R.id.textSearch)); }
    public static ViewInteraction app_toolbar() { return Espresso.onView(withContentDescription("Open navigation drawer")); }
    public static ViewInteraction text_username() {return Espresso.onView(withId(R.id.nav_username));}
    public static ViewInteraction mytaxi_logo(){return Espresso.onView(withId(R.id.imageView));}

    //Methods in relation to Page Objects
    //------------------------------------//
    public static void EnterDriverNameAs(String value){
        txtbox_SearchDriver().perform(clearText(),typeText(value),closeSoftKeyboard());
        Log.d("EnterDriverNameAs","Entered Driver name as :"+ value); }

    public static void SelectDriverFromList(String value,ActivityTestRule mainActivityActivityTestRule) {
        Espresso.onView(withText(value)).inRoot(withDecorView(not(is(mainActivityActivityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed())).perform(click());
        Log.d("SelectDriverFromList","Select Driver name as : "+ value +" from list"); }

    public static void ClickMenuToolbar() throws InterruptedException {
        Thread.sleep(5000);
        app_toolbar().check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(click());
        Log.d("ClickMenuToolbar","Click on Menu Toolbar"); }

    public static void VerifyifmytaxiLogoDisplayed(){
        mytaxi_logo().check(matches(isDisplayed()));
        Log.d("VerifyifmytaxiLogoDisplayed","Verify mytaxi logo displayed"); }

    public static void VerifyifUsernameDisplayed(String value) {
        text_username().check(matches(withText(value)));
        Log.d("VerifyifUsernameDisplayed","Verify username displayed"); }

    public static void SwipeLeftToolbar(){
        text_username().perform(swipeLeft());
        Log.d("SwipeLeftToolbar","Swipe Left on Toolbar"); }

    //Workflows in relation to Page Objects and Methods
    //------------------------------------//
    public static void VerifyDidUserLoggedin(String user) {
        try{
            ClickMenuToolbar();
            VerifyifmytaxiLogoDisplayed();
            VerifyifUsernameDisplayed(user);
            SwipeLeftToolbar();}
        catch(Exception e)
            {Log.d("VerifyDidUserLoggedin","Exception Thrown as : "+e.toString());} }

    public static void SearchandPickDriver(String DriverShortName,String DriverFullName,ActivityTestRule mainActivityActivityTestRule){
        try{
            EnterDriverNameAs(DriverShortName);
            SelectDriverFromList(DriverFullName,mainActivityActivityTestRule);}
        catch(Exception e)
            {Log.d("SearchandPickDriver","Exception Thrown as : "+e.toString());} }
}