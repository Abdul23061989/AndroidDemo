package com.mytaxi.android_demo.PageObjects;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.util.Log;

import com.mytaxi.android_demo.R;

import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class InLoginPage
{
    public static Espresso es;

    //Page Objects
    //------------------------------------//
    private static ViewInteraction txtbox_UserName() { return Espresso.onView(withId(R.id.edt_username)); }
    private static ViewInteraction txtbox_Password() { return Espresso.onView(withId(R.id.edt_password)); }
    private static ViewInteraction btn_Login() { return Espresso.onView(withId(R.id.btn_login)); }

    //Methods in relation to Page Objects
    //------------------------------------//
    public static void EnterUserNameAs(String value){
        txtbox_UserName().check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(clearText(),typeText(value),closeSoftKeyboard());
        Log.d("EnterUserNameAs","Entered Username as :"+ value); }

    public static void EnterPasswordAs(String value){
        txtbox_Password().check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(clearText(),typeText(value),closeSoftKeyboard());
        Log.d("EnterPasswordAs","Entered Username as :"+ value); }

    public static void ClickLoginButton(){
        btn_Login().check(ViewAssertions.matches(ViewMatchers.isDisplayed())).perform(click());
        Log.d("ClickLoginButton","Clicked Login Button"); }

    //Workflows in relation to Page Objects and Methods
    //------------------------------------//
    public static void UserLogsInWith(String Username,String Password){
        try{
            EnterUserNameAs(Username);
            EnterPasswordAs(Password);
            ClickLoginButton();
            InSearchDriverPage.VerifyDidUserLoggedin(Username); }
        catch(Exception e)
            {Log.d("UserLogsInWith","Exception Thrown as : "+e.toString());} }

}